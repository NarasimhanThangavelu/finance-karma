package com.narpavi.finance.karma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.narpavi.finance.karma.dao.FinanceKarmaDao;
import com.narpavi.finance.karma.model.CustomerDetails;

public class FinanceKarmaService {
	
	@Autowired
	private FinanceKarmaDao financeKarmaDao;
	
	public List<CustomerDetails> getAllCustomerDetails() {
		return financeKarmaDao.getAllCustomerDetails();
	}

	public List<CustomerDetails> search(String searchKey) {
		return financeKarmaDao.search(searchKey);
	}

	public boolean create(CustomerDetails customerDetails) throws Exception {
		boolean returnValue = false;
		Integer status = financeKarmaDao.create(customerDetails);
		if (status > 0) {
			returnValue = true;
		}
		return returnValue;
	}

	public boolean update(CustomerDetails customerDetails) throws Exception {
		boolean returnValue = false;
		Integer status = financeKarmaDao.update(customerDetails);
		if (status > 0) {
			returnValue = true;
		}
		return returnValue;

	}

	public boolean delete(List<Integer> customerIds) throws Exception {
		boolean returnValue = false;
		Integer status = financeKarmaDao.delete(customerIds);
		if (status > 0) {
			returnValue = true;
		}
		return returnValue;
	}
}
