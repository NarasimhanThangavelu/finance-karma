package com.narpavi.finance.karma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narpavi.finance.karma.model.ServiceResponse;

public class BaseMockTest extends EasyMockSupport {
	
	public EasyMockRule rule = new EasyMockRule(this);
	@Autowired
	private ObjectMapper objectMapper;
	
	public BufferedReader getBufferedReader(String fileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		return br;
	}
	
	public ServiceResponse getServiceResponse(ResultActions actions) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException {
		ModelAndView modelView = actions.andReturn().getModelAndView();
		ServiceResponse serviceResponse = null;
		if (null == modelView) {
			serviceResponse = objectMapper.readValue(actions.andReturn().getResponse().getContentAsString(), ServiceResponse.class);
		} else {
			ModelMap modelMap = modelView.getModelMap();
			serviceResponse = (ServiceResponse)modelMap.get("response");
		}
		return serviceResponse;
		
	}
}
