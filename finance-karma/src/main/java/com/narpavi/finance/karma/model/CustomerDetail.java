package com.narpavi.finance.karma.model;

import java.util.Date;
import java.util.List;

public class CustomerDetail {
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String dobStr;
	private String aadharNumber;
	private String rationCardNumber;
	private String drivingLicenseNumber;
	private String voterIdNumber;
	private String passportNumber;
	private String panIdNumber;
	private String email;
	private String contactNumber;
	private boolean maritalStatus;
	private String sex;
	private Address address;
	private List<VehicleDetails> vehicleDetails;
	private List<FinanceDetails> financeDetails;
	private FamilyDetails familyDetails;
	private List<QualificationDetails> qualificationDetails;
	private List<JobDetails> jobDetails;
	private List<AssertDetails> assertDetails;
	private List<InvestmentDetails> investmentDetails;
	private List<HealthDetails> healthDetails;
	private List<InsurenceDetails> insurenceDetails;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getRationCardNumber() {
		return rationCardNumber;
	}
	public void setRationCardNumber(String rationCardNumber) {
		this.rationCardNumber = rationCardNumber;
	}
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	public String getVoterIdNumber() {
		return voterIdNumber;
	}
	public void setVoterIdNumber(String voterIdNumber) {
		this.voterIdNumber = voterIdNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPanIdNumber() {
		return panIdNumber;
	}
	public void setPanIdNumber(String panIdNumber) {
		this.panIdNumber = panIdNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<VehicleDetails> getVehicleDetails() {
		return vehicleDetails;
	}
	public void setVehicleDetails(List<VehicleDetails> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	public List<FinanceDetails> getFinanceDetails() {
		return financeDetails;
	}
	public void setFinanceDetails(List<FinanceDetails> financeDetails) {
		this.financeDetails = financeDetails;
	}
	public FamilyDetails getFamilyDetails() {
		return familyDetails;
	}
	public void setFamilyDetails(FamilyDetails familyDetails) {
		this.familyDetails = familyDetails;
	}
	public List<QualificationDetails> getQualificationDetails() {
		return qualificationDetails;
	}
	public void setQualificationDetails(List<QualificationDetails> qualificationDetails) {
		this.qualificationDetails = qualificationDetails;
	}
	public List<JobDetails> getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(List<JobDetails> jobDetails) {
		this.jobDetails = jobDetails;
	}
	public List<AssertDetails> getAssertDetails() {
		return assertDetails;
	}
	public void setAssertDetails(List<AssertDetails> assertDetails) {
		this.assertDetails = assertDetails;
	}
	public List<InvestmentDetails> getInvestmentDetails() {
		return investmentDetails;
	}
	public void setInvestmentDetails(List<InvestmentDetails> investmentDetails) {
		this.investmentDetails = investmentDetails;
	}
	public List<HealthDetails> getHealthDetails() {
		return healthDetails;
	}
	public void setHealthDetails(List<HealthDetails> healthDetails) {
		this.healthDetails = healthDetails;
	}
	public List<InsurenceDetails> getInsurenceDetails() {
		return insurenceDetails;
	}
	public void setInsurenceDetails(List<InsurenceDetails> insurenceDetails) {
		this.insurenceDetails = insurenceDetails;
	}
	
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getDobStr() {
		return dobStr;
	}
	public void setDobStr(String dobStr) {
		this.dobStr = dobStr;
	}
	@Override
	public String toString() {
		return "CustomerDetail [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", aadharNumber="
				+ aadharNumber + ", rationCardNumber=" + rationCardNumber + ", drivingLicenseNumber="
				+ drivingLicenseNumber + ", voterIdNumber=" + voterIdNumber + ", passportNumber=" + passportNumber
				+ ", panIdNumber=" + panIdNumber + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", address=" + address + ", vehicleDetails=" + vehicleDetails + ", financeDetails=" + financeDetails
				+ ", familyDetails=" + familyDetails + ", qualificationDetails=" + qualificationDetails
				+ ", jobDetails=" + jobDetails + ", assertDetails=" + assertDetails + ", investmentDetails="
				+ investmentDetails + ", healthDetails=" + healthDetails + ", insurenceDetails=" + insurenceDetails
				+ "]";
	}
	
}
