'user strict';
var app = angular.module("financeKarmaApp", []);
app.controller("financeKarmaController", function($scope, $http) {
	$scope.chkboxList = [];
	$scope.selected = [];
	$scope.customerDetail = {};
	$scope.tempEmployerDetail = {};
	$scope.hideShow = false;
	$scope.sample = {};
//	$scope.model = {edit:angular.copy(result.data),show:angular.copy(result.data)};
	var i = 0;
	$scope.branchDetails = {};
	$scope.paymentTypes = ["---Select---","Daily","Monthly","Weekly"];
	$scope.sexTypes = ["---Select---","Female","Male","Aravani"];
	$scope.loanStatuses = ["---Select---","Closed","Delinquency","Open"];
	$scope.datePattern = "/^(0[1-9]|[1-2][0-9]|3[0-1])\/(0[1-9]|1[0-2])\/[0-9]{4}$/";
	
//	$scope.paymentTypes.setDefault=$scope.paymentTypes[1];
	var tempData = [];
	$scope.init = function() {
		$http.get('http://localhost:8080/finance-karma/fkservice/delinquent/customers.json')
		.then(function(response) {
//			alert(angular.toJson(response.data.payload.allDeliquentCustomers));
		$scope.customerDetails = response.data.payload.allDeliquentCustomers;
//		alert(angular.toJson($scope.customerDetails));
		$scope.showCustomerDatas=response.data.payload.allDeliquentCustomers.length > 0 ? true : false;
		$scope.hideShow = false;
		})
		.catch(function (err) {alert(angular.toJson(err))});
	};
	
	$scope.save = function(customerDetailObj, branchDetails) {

		if (validate(customerDetailObj)) {
			var customerDetails;
			
			if ($scope.custID == undefined|| $scope.custID == "" ) {
				customerDetails = { customerDetail : customerDetailObj};
				$http.post('http://localhost:8080/finance-karma/fkservice/customers/create', angular.toJson(customerDetails)).
				then(function(response) {
					if (response.data.payload.allDeliquentCustomers != undefined) {
						alert("The new customer added successfully");
						$scope.customerDetails = response.data.payload.allDeliquentCustomers;
//						angular.copy(response.data.payload.allEmployerDetails,$scope.tempEmployerDetail);
						$scope.hideShow = false;
					} else {
						alert("The new customer not added successfully");
						$scope.hideShow = true;
					}
				}).catch(function (err) {alert("The new customer not added successfully : exception : " + angular.toJson(err))});
			} else {
				customerDetails = { "id":$scope.custID, customerDetail : customerDetailObj};
				$http.post('http://localhost:8080/finance-karma/fkservice/customers/update', angular.toJson(customerDetails)).
				then(function(response) {
					if (response.data.payload.allDeliquentCustomers != undefined) {
						alert("The selected record updated successfully");
						$scope.customerDetails = response.data.payload.allDeliquentCustomers;
//						angular.copy(response.data.payload.allEmployerDetails,$scope.tempEmployerDetail);
						$scope.hideShow = false;
					} else {
						alert("The selected record not updated successfully");
						$scope.hideShow = true;
					}
				}).catch(function (err) {alert(angular.toJson(err))});;
			}
			
		} else {
			alert ("Please fill mandatory(*) fields in both customer and finance details !");
		}
		
	};
	
	var validate = function(customerDetailObj) {
		if (isValid(customerDetailObj.firstName) 
//				&& isValid(customerDetailObj.dob) 
				&& isValid(customerDetailObj.contactNumber) 
				&& isValid(customerDetailObj.address.addressLine2)
				&& isValid(customerDetailObj.address.city)
				&& isValid(customerDetailObj.address.state)) {
			let dob = isDateValid(customerDetailObj.dobStr, "DOB");
			if (dob == "Not Valid") {
				return false;
			}
			
			var flag = 0;
			angular.forEach(customerDetailObj.financeDetails, function(financeDetail){
				if (isValid(financeDetail.financeName) 
					&& isValid(financeDetail.loanStatus) 
					&& isValid(financeDetail.repaymentType) 
					&& isValid(financeDetail.loanAmount) 
					&& isValid(financeDetail.dueAmount)) {
					var loanStartDate = isDateValid(financeDetail.loanStartDateStr, "Loan Start Date");
					var loanEndDate = isDateValid(financeDetail.loanEndDateStr, "Loan End Date");
					
					if (loanStartDate == "Not Valid" || loanEndDate == "Not Valid") {
						return false;
					}
					
					if (financeDetail.loanStatus=="Delinquency" && !isValid(financeDetail.delinquencyAmount)) {
						alert("Please fill the delinquency amount");
						return false;
					}
					flag++;
				}
			});
			if (flag == customerDetailObj.financeDetails.length) {
				return true;
			}
		}
		return false;
		
	};
	
	var isDateValid = function(date, fieldName) {
		if (isValid(date)) {
			let valid = new Date(date);
			if (valid != "Invalid Date") {
				return valid;
			} else {
				alert("Please give valid date with format (MM/DD/YYYY) for "+ fieldName);
				return "Not valid";
			}
		}
		return "empty";
	};
	
	var isValid = function(value) {
		var isNotEmpty = false;
		if (value != undefined) {
			if (isNaN(value)) {
				isNotEmpty =  value.trim() != "";
			} else {
				isNotEmpty =  value > 0;
			}
		}
		return isNotEmpty
	};
	
	$scope.update = function(customerDetails, active){
		$scope.custID = customerDetails.id;
		$scope.customerDetail = customerDetails.customerDetail;
		$scope.hideShow = true;
		$scope.saveDiv = true;
		$scope.deleteFD=false;
	};
	
	$scope.deleteRecords = function() {
		if ($scope.chkboxList.length == 0) {
			alert("Please select record(s) to delete!");
		} else if(confirm("Are you sure to delete the selected record(s)?")) {
			$http.post('http://localhost:8080/finance-karma/fkservice/customers/delete', angular.toJson($scope.chkboxList)).
			then(onSuccess, onError);
		}
	};
	
	var onSuccess = function (response) {
		
		if (response.data.message == undefined && response.data.payload.allDeliquentCustomers != undefined) {
			alert("The selected record(s) deleted successfully");
			$scope.customerDetails = response.data.payload.allDeliquentCustomers;
			$scope.hideShow = false;
			$scope.customerDetail = {};
			$scope.chkboxList = [];
		} else {
			alert("The selected record not deleted successfully because of " + response.data.message);
			$scope.hideShow = false;
		}
    };
	
	var onError = function (response) {
		alert("The selected record not deleted successfully" +angular.toJson(response));
    }
	
	$scope.search = function() {
		if ($scope.searchKey == undefined) {
			$scope.searchKey = "";
		}
		$http.get('http://localhost:8080/finance-karma/fkservice/customers/search.json?searchKey='+$scope.searchKey).
		then(function(response) {
			$scope.customerDetails = response.data.payload.allDeliquentCustomers;
//		angular.copy(response.data.payload.allEmployerDetails,$scope.tempEmployerDetail);
		$scope.showCustomerDatas = response.data.payload.allDeliquentCustomers.length > 0 ? true : false;
		$scope.hideShow = false;
		});
	};
	
	$scope.create = function(){
		$scope.saveDiv = true;
		$scope.custID = "";
		$scope.customerDetail = {};
		$scope.customerDetail.financeDetails = [];
		if ($scope.customerDetail.financeDetails.length == 0) {
			$scope.addBranch();
		}
		$scope.customerDetail.sex = $scope.sexTypes[0];
		$scope.hideShow = true;
		$scope.deleteFD=true;
		
	}
	
	$scope.addBranch = function() {
		var financeDetail = {};
		financeDetail.repaymentType = $scope.paymentTypes[0];
		financeDetail.loanStatus = $scope.loanStatuses[0];
		$scope.customerDetail.financeDetails.push(financeDetail);
	};
	
	$scope.deleteBranch = function(index) {
		if ($scope.customerDetail.financeDetails.length-1 > 0) {
			if (confirm("Are you sure to delete the finance details which recently added?")) {
			var test = $scope.customerDetail.financeDetails.splice(index,1);
			} 
		} else {
			alert("Minimum one finance details required to create finance details! ");
		}
	};
	
	$scope.viewRecord = function(customerDetails, active){
		$scope.customerDetail = customerDetails.customerDetail;
		$scope.hideShow = true;
		$scope.saveDiv = false;
	};
	
	$scope.getSelectedCheckboxes = function(selectedCustId, event){
		
		if (event) {
			if (!$scope.chkboxList.includes(selectedCustId)) {
				$scope.chkboxList.push(selectedCustId);
			} 			
		} else {
			
			for(var i=0 ; i < this.chkboxList.length; i++) {
			       if(this.chkboxList[i] == selectedCustId) {
			         this.chkboxList.splice(i,1);
			      }
			}
		}
		};

	$scope.cancel = function() {
		$scope.hideShow = false;
	};
	
	$scope.clear = function() {
		$scope.customerDetail = {};
	};
	
});