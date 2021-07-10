package com.narpavi.finance.karma.dao;

import java.util.List;

import com.narpavi.finance.karma.model.CustomerDetails;

public interface FinanceKarmaDao {
	
	public List<CustomerDetails> getAllCustomerDetails();
	public List<CustomerDetails> search(String searchKey);
	public Integer create(CustomerDetails customerDetails) throws Exception;
	public Integer update(CustomerDetails customerDetails) throws Exception;
	public Integer delete(List<Integer> customerIds) throws Exception;
}
