package com.narpavi.finance.karma.model;

public class ServiceResponse {
	
	private String status = "SUCCESS";
	private String message;
	private Object payload;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		if (status.equals("ERROR")) {
			message = "A system error occured.";
		}
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	
}
