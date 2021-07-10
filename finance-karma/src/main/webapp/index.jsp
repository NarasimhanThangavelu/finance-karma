<!DOCTYPE html>
<html ng-app="financeKarmaApp">
<head>
<meta charset="ISO-8859-1">
<title>Finance Karma</title>
	<script src="resources/angular/angular.min.js" type="text/javascript"></script>
	<script src="resources/js/financekarma.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="resources/css/emsLayout.css">
	<base target="_blank">
	
</head>
<body>

<div class="header">
  <a href="#default" class="logo">Finance Karma</a>
  <div class="header-right">
    <a class="active" href="#home">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
  </div>
</div>
  
  <div ng-controller="financeKarmaController" ng-init=init() style="width:100%;" >
	<div class="leftDiv">
	<form name="employerListForm">
		<div class="searchDiv">
			<fieldset>
				<legend style="font-weight:bold;">Delinquent Customer List :</legend>
					<div style="width:100%; float:right;padding-right:2px;">
		  				<table style="border:15px solid #ddd">
		  			    <tr style="border:1px solid #ddd">
		  			    	<td class="tab-cell-padding cellBorder fullWidth"><input type="text" ng-model="searchKey" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding tab-head cellBorder"><button ng-click="search()" class="tab-head fontBold fullWidth buttonStyle">Search</button></td>
		  			    </tr>
		  				</table>
	  				</div>
	  			<div class="listTableDiv">
					<table class="listTable">  
			         <tr class="tab-head">
			          <th class="tab-cell-padding" style="width:20px;"><input type="checkbox" ng-model="all"/></th>  
			          <th class="tab-cell-padding" style="width:150px;">Customer Name</th>  
			          <th class="tab-cell-padding" style="width:100px;">DOB</th>  
			          <th class="tab-cell-padding" style="width:120px;">Customer Village/Town</th>
			          <th class="tab-cell-padding" style="width:120px;">Contact Number</th>
			          <th class="tab-cell-padding" style="width:120px;">View/Update</th>  
			         </tr> 
			         <tr ng-if="showCustomerDatas==false" class="tab-row cellBorder">
			      		<td colspan="6" class="tab-cell-padding cellBorder" style="text-align:center;">No data records found</td>
					</tr>
				         <tr ng-if="showCustomerDatas==true" ng-repeat = "customerDetail in customerDetails" class="tab-row">  
					          <td class="tab-cell-padding"><input type="checkbox" ng-model="selected" value="{{ customerDetail.id }}"  ng-change="getSelectedCheckboxes(customerDetail.id, selected)" ng-checked="all"/></td>
					          <td class="tab-cell-padding">{{ customerDetail.customerDetail.firstName }} </td>  
					          <td class="tab-cell-padding">{{ customerDetail.customerDetail.dobStr }}</td>  
					          <td class="tab-cell-padding">{{ customerDetail.customerDetail.address.addressLine2 }}</td>  
					          <td class="tab-cell-padding">{{ customerDetail.customerDetail.contactNumber }}</td>  
					          <td align="middle">
						          <div id="cudButtons">
									<table>  
										<tr style="border:1px solid #ddd">
										    	<td class="tab-cell-padding tab-head cellBorder"><button ng-click="update(customerDetail, customerDetail.selected)" class="tab-head"  style="padding:2px;">Update</button></td>
										    	<td class="tab-cell-padding tab-head cellBorder"><button ng-click="viewRecord(customerDetail, customerDetail.selected)" class="tab-head"  style="padding:2px;">View</button></td>
							  			</tr>
							  		</table>
								</div>
							</td>
				         </tr>  
			        </table> 
				</div>
			
				<div id="cudButtons" style="float:right;">
					<table>  
						<tr style="border:1px solid #ddd">
						    	<td class="tab-cell-padding tab-head cellBorder"><button ng-click="create()" class="tab-head buttonStyle" >Create</button></td>
						    	<td class="tab-cell-padding tab-head cellBorder"><button ng-click="deleteRecords()" class="tab-head buttonStyle" >Delete</button></td>
			  			</tr>
			  		</table>
				</div>
			</fieldset>
	  		</div>
	  	</form>
	  	</div>
	  	<div class="detailsDiv">
	  	
	  		<div id="createUpdateView" ng-if="hideShow==false"  style="width:100%;height:650px;padding-top:18px;">
				<table style="width:100%;height:597px;border:3px solid #ddd;overflow:auto;">
					<tr>
						<td align="middle" style="color:dodgerblue;font-size:20px;">Please select a record to view customer details <td>
					</tr>
				</table>
			</div>
			
			
			<div id="createUpdateView" ng-if="hideShow"  style="width:100%;height:660px;padding-top:10px;">
				<div style="float:right;width:100%;">
				<fieldset>
				<legend style="font-weight:bold;">Customer Details:</legend>
				<div style="padding-right:5px;">
				
    			<form action="">
				<input type="hidden" ng-model=custID id="custID" name="custID" value="">
				<table class="createUpdateViewTable" style="width:100%;">
					<tr>
		  			    	<td class="tab-head tdwidth">First Name<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="customerDetail.firstName" ng-value="customerDetail.firstName" required maxlength="50"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Last Name : </td>
		  			    	<td class="tab-cell-padding cellBorder" style=""><input type="text" ng-model="customerDetail.lastName" ng-value="customerDetail.lastName" maxlength="50" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Date of Birth : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.dobStr" ng-value="customerDetail.dobStr" maxlength="10" placeholder="MM/DD/YYYY" class="fullWidth"/></td>
		  			    </tr>
		  			    <tr>
		  			    	<td class="tab-head tdwidth" >Street Name : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.address.addressLine1" ng-value="customerDetail.address.addressLine1" required maxlength="50"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Village or Town<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="customerDetail.address.addressLine2" ng-value="customerDetail.address.addressLine2" maxlength="50" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >City<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="customerDetail.address.city" ng-value="customerDetail.address.city" maxlength="50" class="fullWidth"/></td>
		  			    </tr>
		  			    
		  			     <tr>
		  			    	<td class="tab-head tdwidth" >Pin/Zip : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.address.zip" ng-value="customerDetail.address.zip" required maxlength="10"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >State<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="customerDetail.address.state" ng-value="customerDetail.address.state" maxlength="50" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Country<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.address.country" ng-value="customerDetail.address.country" maxlength="50" class="fullWidth"/></td>
		  			    </tr>
		  			    
		  			     <tr>
		  			    	<td class="tab-head tdwidth " >Aadhar No : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.aadharNumber" ng-value="customerDetail.aadharNumber" required maxlength="50"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Voter Id : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.voterIdNumber" ng-value="customerDetail.voterIdNumber"  maxlength="20" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Passport No : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.passportNumber" ng-value="customerDetail.passportNumber" maxlength="20" class="fullWidth"/></td>
		  			    </tr>
		  			    
		  			    <tr>
		  			    	<td class="tab-head tdwidth " >Ration Card No : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.rationCardNumber" ng-value="customerDetail.rationCardNumber" required maxlength="20"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Dr License No : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.drivingLicenseNumber" ng-value="customerDetail.drivingLicenseNumber" maxlength="20" class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Email : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="customerDetail.email"  ng-value="customerDetail.email" maxlength="50" class="fullWidth"/></td>
		  			    </tr>
		  			    
		  			    <tr>
		  			    	<td class="tab-head tdwidth " >Contact No<span class="mandatory">*</span> : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="customerDetail.contactNumber" ng-value="customerDetail.contactNumber" required maxlength="30"  class="fullWidth"/></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Sex : </td>
		  			    	<td class="tab-cell-padding cellBorder" ><select class="fullWidth" ng-model="customerDetail.sex" ng-options="sex for sex  in sexTypes"></select></td>
		  			    	<td class="tab-cell-padding redBackground"></td>
		  			    	<td class="tab-head tdwidth" >Married : </td>
		  			    	<td class="tab-cell-padding cellBorder"  align="left"><input type="checkbox" ng-model="customerDetail.maritalStatus"  style="float:left;"/></td>
		  			    </tr>
		  			    <tr>
		  			    	<td colspan="8"></td>
		  			    </tr>
		  			</table>
		  		</form>	
		  	</div>
		
			<div style="overflow:auto;height:430px;padding-top:20px;" >
			  			<div id="financeDetails" ng-repeat = "financeDetail in customerDetail.financeDetails track by $index">
			  			
			  				<fieldset>
	    						<legend style="font-weight:bold;">Finance Details: - {{$index + 1}}</legend>
	    							<div>
		    						<table class="createUpdateViewTable" style="width:100%;">
										<tr>
							  			    	<td class="tab-head tdwidth " >Finance Name<span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="text" required ng-model="financeDetail.financeName" ng-value="financeDetail.financeName" required maxlength="100"  class="fullWidth"/></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Owner Name : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="text" ng-model="financeDetail.financeOwnerName" ng-value="financeDetail.financeOwnerName" maxlength="50" class="fullWidth"/></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Loan Status<span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><select class="fullWidth" required  ng-model="financeDetail.loanStatus" ng-options="loanStatus for loanStatus in loanStatuses"></select></td>
							  			    </tr>
							  			    <tr>
							  			    	<td class="tab-head tdwidth " >Delinq.. Amt: <span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="number" ng-model="financeDetail.delinquencyAmount" ng-value="financeDetail.delinquencyAmount" required maxlength="100"  class="fullWidth"/></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Payment Type<span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><select class="fullWidth" required ng-model="financeDetail.repaymentType" ng-options="paymentType for paymentType in paymentTypes"></select></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Loan Start Date : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="text" placeholder="MM/DD/YYYY" ng-model="financeDetail.loanStartDateStr" ng-value="financeDetail.loanStartDateStr" maxlength="13" class="fullWidth"/></td>
							  			    </tr>
							  			    <tr>
							  			    	<td class="tab-head tdwidth " >Loan End Date : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="text" placeholder="MM/DD/YYYY" ng-model="financeDetail.loanEndDateStr" ng-value="financeDetail.loanEndDateStr" required maxlength="100"  class="fullWidth"/></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Loan Amount<span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="number" required ng-model="financeDetail.loanAmount" ng-value="financeDetail.loanAmount" maxlength="50" class="fullWidth"/></td>
							  			    	<td class="tab-cell-padding redBackground"></td>
							  			    	<td class="tab-head tdwidth" >Due Amount<span class="mandatory">*</span> : </td>
							  			    	<td class="tab-cell-padding cellBorder" ><input type="number" required ng-model="financeDetail.dueAmount" ng-value="financeDetail.dueAmount" maxlength="50" class="fullWidth"/></td>
							  			    </tr>
							  			    
							  			    <tr>
							  			    	<td class="tab-head tdwidth " >Comments by Owner : </td>
							  			    	<td class="tab-cell-padding cellBorder"  colspan="7"><textarea id="comments" maxlength="500" ng-model="financeDetail.commentsAboutCustomer" ng-value="financeDetail.commentsAboutCustomer" style="width:100%;" rows="4" cols="81"></textarea>
												</td>
							  			    	
							  			    </tr>
							  		</table>
	    						</div>
	    						<div id="cudButtons" style="float:right;">
									<table>  
										<tr style="border:1px solid #ddd">
										    <td class="tab-cell-padding tab-head cellBorder"><button ng-click="deleteBranch($index)" class="tab-head" style="padding:2px;">Delete</button></td>
							  			</tr>
							  		</table>
								</div>
	    					</fieldset>
			  			</div>
			  			
		  			</div>
		  			<div ng-if="saveDiv==true" style="float:right;">
		  			    		<table style="">  
									<tr style="border:1px solid #ddd">
					  			    	<td class="tab-cell-padding tab-head"><button ng-click="save(customerDetail, customerDetail.financeDetails)" class="tab-head buttonStyle" >Save</button></td>
					  			    	<td class="tab-cell-padding tab-head"><button ng-click="cancel()" class="tab-head buttonStyle" >Cancel</button></td>
					  			    	<td class="tab-cell-padding tab-head"><button ng-click="create()" class="tab-head buttonStyle" >Clear</button></td>
					  			    	<td class="tab-cell-padding tab-head"><button ng-click="addBranch()" class="tab-head buttonStyle" >Add Finance Details</button></td>
					  			    </tr>
		  			    		</table>	
		  			    	</div>
		  			
		</fieldset>
	  	</div>
	  	
	</div>
	</div>
	</div>
