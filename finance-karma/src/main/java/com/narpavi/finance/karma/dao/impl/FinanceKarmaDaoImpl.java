package com.narpavi.finance.karma.dao.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.narpavi.finance.karma.dao.FinanceKarmaDao;
import com.narpavi.finance.karma.model.CustomerDetails;
import com.narpavi.finance.karma.model.FinanceDetails;
import com.narpavi.finance.karma.util.StringUtils;

public class FinanceKarmaDaoImpl extends BaseDaoImpl implements FinanceKarmaDao {

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		return this.getSqlSession().selectList("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.getAllCustomerDetails");
	}

	@Override
	public List<CustomerDetails> search(String searchKey) {
		if (!StringUtils.isBlank(searchKey)) {
			searchKey = searchKey+"*";
		} else {
			return getAllCustomerDetails();
		}
		return this.getSqlSession().selectList("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.searchCustomerDetails", searchKey);
	}

	@Override
	public Integer create(CustomerDetails customerDetails) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", 0);
		paramMap.put("details", customerDetails.getCustomerDetail());
		paramMap.put("customerDetailClob", customerDetails.getCustomerDetail());
		Integer status = this.getSqlSession().insert("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.createCustomerDetail", paramMap);
		if (status > 0) {
			Map<String, Object> branchMap = new HashMap<String, Object>();
			branchMap.put("id", paramMap.get("id"));
			
			for (FinanceDetails financeDetails : customerDetails.getCustomerDetail().getFinanceDetails()) {
				branchMap.put("financeDetail", financeDetails);
				branchMap.put("financeDetailsClob", financeDetails);
				branchMap.put("delinqAmount", String.valueOf(financeDetails.getDelinquencyAmount()));
				status = this.getSqlSession().insert("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.createFinanceDetail", branchMap);
				BigInteger in = (BigInteger)branchMap.get("financeId");
				financeDetails.setId(in.intValue());
			}
		}
		
		updateClob(customerDetails, paramMap.get("id"));
		return status;
	}
	
	private void updateClob(CustomerDetails customerDetails, Object empId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custId", empId);
		paramMap.put("customerDetailClob", customerDetails.getCustomerDetail());
		this.getSqlSession().insert("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.updateCustomerDetailClob", paramMap);
	}

	@Override
	public Integer update(CustomerDetails customerDetails) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", customerDetails.getId());
		paramMap.put("customerDetailClob", customerDetails.getCustomerDetail());
		
		Map<String, Object> financeParamMap = new HashMap<String, Object>();
		for (FinanceDetails financeDetails : customerDetails.getCustomerDetail().getFinanceDetails()) {
			financeParamMap.put("custId", paramMap.get("id"));
			financeParamMap.put("financeDetail", financeDetails);
			financeParamMap.put("financeDetailsClob", financeDetails);
			if (null != financeDetails.getId() && financeDetails.getId() > 0) {
				this.getSqlSession().update("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.updateFinanceDetail", financeParamMap);
			} else {
				financeParamMap.put("id", paramMap.get("id"));
				this.getSqlSession().insert("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.createFinanceDetail", financeParamMap);
				BigInteger in = (BigInteger)financeParamMap.get("financeId");
				financeDetails.setId(in.intValue());
			}
		}
		return this.getSqlSession().update("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.updateCustomerDetails", paramMap);
	}

	@Override
	public Integer delete(List<Integer> customerIds) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("customerIds", customerIds);
		Integer status = 0;
			for (Integer empID : customerIds) {
				paramMap.put("custID", empID);
				this.getSqlSession().delete("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.deleteFinanceDetail", paramMap);
				status = status + this.getSqlSession().delete("com.narpavi.finance.karma.dao.CustomerDetailsDaoMapper.deleteCustomerDetail", paramMap);
			}
		return status;
	}

}
