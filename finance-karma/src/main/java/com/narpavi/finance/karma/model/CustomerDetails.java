package com.narpavi.finance.karma.model;

public class CustomerDetails {
	
	private Integer id;
	private CustomerDetail customerDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", customerDetail=" + customerDetail + "]";
	}
	
}
