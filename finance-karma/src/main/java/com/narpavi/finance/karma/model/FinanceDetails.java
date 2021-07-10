package com.narpavi.finance.karma.model;

import java.math.BigDecimal;
import java.util.Date;

public class FinanceDetails {
	
	private Integer id;
	private String financeName;
	private String financeOwnerName;
	private Address address;
	private boolean deliquency;
	private String loanStatus;
	private String commentsAboutCustomer;
	private BigDecimal delinquencyAmount;
	private String repaymentType;
	private BigDecimal loanAmount;
	private BigDecimal dueAmount;
	private Date loanStartDate;
	private String loanStartDateStr;
	private Date loanEndDate;
	private String loanEndDateStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFinanceName() {
		return financeName;
	}
	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}
	public String getFinanceOwnerName() {
		return financeOwnerName;
	}
	public void setFinanceOwnerName(String financeOwnerName) {
		this.financeOwnerName = financeOwnerName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isDeliquency() {
		return deliquency;
	}
	public void setDeliquency(boolean deliquency) {
		this.deliquency = deliquency;
	}
	public String getCommentsAboutCustomer() {
		return commentsAboutCustomer;
	}
	public void setCommentsAboutCustomer(String commentsAboutCustomer) {
		this.commentsAboutCustomer = commentsAboutCustomer;
	}
	public BigDecimal getDelinquencyAmount() {
		return delinquencyAmount;
	}
	public void setDelinquencyAmount(BigDecimal delinquencyAmount) {
		this.delinquencyAmount = delinquencyAmount;
	}
	public String getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public Date getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public BigDecimal getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}
	
	public String getLoanStartDateStr() {
		return loanStartDateStr;
	}
	public void setLoanStartDateStr(String loanStartDateStr) {
		this.loanStartDateStr = loanStartDateStr;
	}
	public String getLoanEndDateStr() {
		return loanEndDateStr;
	}
	public void setLoanEndDateStr(String loanEndDateStr) {
		this.loanEndDateStr = loanEndDateStr;
	}
	@Override
	public String toString() {
		return "FinanceDetails [id=" + id + ", financeName=" + financeName + ", financeOwnerName=" + financeOwnerName
				+ ", address=" + address + ", deliquency=" + deliquency + ", loanStatus=" + loanStatus
				+ ", commentsAboutCustomer=" + commentsAboutCustomer + ", delinquencyAmount=" + delinquencyAmount
				+ ", repaymentType=" + repaymentType + ", loanAmount=" + loanAmount + ", dueAmount=" + dueAmount
				+ ", loanStartDate=" + loanStartDate + ", loanStartDateStr=" + loanStartDateStr + ", loanEndDate="
				+ loanEndDate + ", loanEndDateStr=" + loanEndDateStr + "]";
	}
	
	
}

//FINANCE_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
//FINANCE_NAME VARCHAR(100) NOT NULL,
//CUSTOMER_ID INT NOT NULL,
//FINANCE_OWNER_NAME VARCHAR(100),
//DELINQUENCY VARCHAR(3),
//COMMENTS_ABOUT_CUSTOMER VARCHAR(500),
//DELINQUENCY_AMOUNT VARCHAR(10),
//REPAYMENT_TYE VARCHAR(10),
//FINANCE_DETAILS_CLOB TEXT,

