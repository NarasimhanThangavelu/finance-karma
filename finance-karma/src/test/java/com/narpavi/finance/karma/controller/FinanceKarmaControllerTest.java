package com.narpavi.finance.karma.controller;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.narpavi.finance.karma.BaseMockTest;
import com.narpavi.finance.karma.model.CustomerDetails;
import com.narpavi.finance.karma.model.ServiceResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonControllerConfig.class})
public class FinanceKarmaControllerTest extends BaseMockTest {
	
	private static final String SAMPLE_REQUEST_JSON = "./src/test/resources/sampleReqAndResponse/sampleReq.json";
	
	@Autowired
	FinanceKarmaController financeKarmaController;
	MockMvc mockMvc;
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(financeKarmaController).build();
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void getAllCustomerDetails() throws Exception {
	 
		ResultActions actions =
		mockMvc.perform(MockMvcRequestBuilders.get("/fkservice/delinquent/customers")).andExpect(MockMvcResultMatchers.status().isOk());
		ServiceResponse serviceResponse = getServiceResponse(actions); 
		Map<String, Object> payLoadMap = (Map<String, Object>)serviceResponse.getPayload(); 
		List<CustomerDetails> allCustomerDetails = (List<CustomerDetails>)payLoadMap.get("allDeliquentCustomers");
		Assert.assertNotNull(allCustomerDetails);
	}
//	
//	@SuppressWarnings("unchecked")
//	@Test 
//	public void givenSearchKeyThenReturnCustomerDetails() throws Exception {
//	 
//		ResultActions actions =
//		mockMvc.perform(MockMvcRequestBuilders.get("/financekarmaservice/customers/search?searchKey=OFS")).andExpect(MockMvcResultMatchers.status().isOk());
//		ServiceResponse serviceResponse = getServiceResponse(actions); 
//		Map<String, Object> payLoadMap = (Map<String, Object>)serviceResponse.getPayload(); 
//		List<CustomerDetails> allCustomerDetails = (List<CustomerDetails>)payLoadMap.get("allDeliquentCustomers");
//		Assert.assertNotNull(allCustomerDetails);
//	}
	
//	@SuppressWarnings("unchecked")
//	@Test 
//	public void givenCustomerDetailsThenReturnCreateCustomerDetails() throws Exception {
//		
//		BufferedReader br = getBufferedReader(SAMPLE_REQUEST_JSON);
//		
//		String json = br.lines().collect(Collectors.joining());
//
//		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post("/financekarmaservice/customers/create").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isOk());
//		ServiceResponse serviceResponse = getServiceResponse(actions); 
//		Map<String, Object> payLoadMap = (Map<String, Object>)serviceResponse.getPayload(); 
//		List<CustomerDetails> allCustomerDetails = (List<CustomerDetails>)payLoadMap.get("allDeliquentCustomers");
//		Assert.assertNotNull(allCustomerDetails);
//	}
	
	
}
