package com.triangledeterminer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class APIError {
	@JsonIgnore
	int status;
	
	String errorCode;
	String message;
	
	public APIError() {
		super();
	}

	public APIError(int status, String message, String details) {
		this.status = status;
		this.message = message;
		this.errorCode = details;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return errorCode;
	}

	public void setDetails(String details) {
		this.errorCode = details;
	}
	
}
