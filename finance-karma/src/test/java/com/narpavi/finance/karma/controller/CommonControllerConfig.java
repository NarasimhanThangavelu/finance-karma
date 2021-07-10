package com.narpavi.finance.karma.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narpavi.finance.karma.service.FinanceKarmaService;

@Configuration
@ImportResource("classpath:com/narpavi/finance/karma/dao/config/common-dao-config.xml")
public class CommonControllerConfig {
	
	@Bean
	public FinanceKarmaController financeKarmaController() {
		return new FinanceKarmaController();
	}
	
	@Bean public FinanceKarmaService financeKarmaService() { 
		return new FinanceKarmaService();
	}
	
	/*
	 * @Bean public FinanceKarmaService EmployerService() { return new
	 * EmployerService(); }
	 * 
	 * @Bean public ObjectMapper objectMapper() { return new ObjectMapper(); }
	 */
	@Bean public ObjectMapper objectMapper() { return new ObjectMapper(); }
}
