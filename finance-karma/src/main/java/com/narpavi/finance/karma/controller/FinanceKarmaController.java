package com.narpavi.finance.karma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narpavi.finance.karma.model.CustomerDetails;
import com.narpavi.finance.karma.model.ServiceResponse;
import com.narpavi.finance.karma.service.FinanceKarmaService;

@Component
@RequestMapping(value = "/fkservice")
public class FinanceKarmaController {
	
	@Autowired
	private FinanceKarmaService financeKarmaService;
	
	@RequestMapping(value = "/delinquent/customers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ServiceResponse getAllEmployerDetails(Model model) {
		ServiceResponse response = new ServiceResponse();
		Map<String, Object> payLoad = new HashMap<String, Object>();
		List<CustomerDetails> allDeliquentCustomers = financeKarmaService.getAllCustomerDetails();
		payLoad.put("allDeliquentCustomers", allDeliquentCustomers);
		response.setPayload(payLoad);
		model.addAttribute("response", response);
		return response;
	}
	
	@RequestMapping(value = "/customers/search", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse search(@RequestParam(value="searchKey") String searchKey, Model model) {
		ServiceResponse response = new ServiceResponse();
		Map<String, Object> payLoad = new HashMap<String, Object>();
		List<CustomerDetails> allEmployerDetails = financeKarmaService.search(searchKey);
		payLoad.put("allDeliquentCustomers", allEmployerDetails);
		response.setPayload(payLoad);
		model.addAttribute("response", response);
		return response;
	}
	
	@RequestMapping(value = "/customers/create", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse create(@RequestBody CustomerDetails customerDetails, Model model) {
		ServiceResponse response = new ServiceResponse();
		Map<String, Object> payLoad = new HashMap<String, Object>();
		try {
			if (null == customerDetails || null == customerDetails.getCustomerDetail()) {
				payLoad.put("exceptions", "Please fill the required fields");
			} else {
			
				List<CustomerDetails> allDeliquentCustomers = null;
				boolean result = financeKarmaService.create(customerDetails);
				if (result) {
					allDeliquentCustomers = financeKarmaService.getAllCustomerDetails();
				}
				payLoad.put("allDeliquentCustomers", allDeliquentCustomers);
				}
			response.setPayload(payLoad);
			model.addAttribute("response", response);
		} catch (Exception e) {
			response.setMessage("Exceptions: " +e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/customers/update", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse update(@RequestBody CustomerDetails customerDetails, Model model) {
		ServiceResponse response = new ServiceResponse();
		Map<String, Object> payLoad = new HashMap<String, Object>();
		try {
			if (null == customerDetails || null == customerDetails.getCustomerDetail()) {
				payLoad.put("exceptions", "Please fill the required fields");
			} else {
			
				List<CustomerDetails> allDeliquentCustomers = null;
				boolean result = financeKarmaService.update(customerDetails);
				if (result) {
					allDeliquentCustomers = financeKarmaService.getAllCustomerDetails();
				}
				payLoad.put("allDeliquentCustomers", allDeliquentCustomers);
				}
			response.setPayload(payLoad);
			model.addAttribute("response", response);
		} catch (Exception e) {
			response.setMessage("Exceptions: " +e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/customers/delete", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse delete(@RequestBody List<Integer> employerIds, Model model) {
		ServiceResponse response = new ServiceResponse();
		Map<String, Object> payLoad = new HashMap<String, Object>();
		try {
			if (null == employerIds || employerIds.size() == 0) {
				payLoad.put("exceptions", "Please fill the required fields");
			} else {
			
				List<CustomerDetails> allDeliquentCustomers = null;
				boolean result = financeKarmaService.delete(employerIds);
				if (result) {
					allDeliquentCustomers = financeKarmaService.getAllCustomerDetails();
				}
				payLoad.put("allDeliquentCustomers", allDeliquentCustomers);
				}
			response.setPayload(payLoad);
			model.addAttribute("response", response);
		} catch (Exception e) {
			response.setMessage("Exceptions: " +e.getMessage());
		}
		return response;
	}
}
