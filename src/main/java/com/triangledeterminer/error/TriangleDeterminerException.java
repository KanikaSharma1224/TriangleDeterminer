package com.triangledeterminer.error;


import com.triangledeterminer.model.APIError;

public class TriangleDeterminerException extends Exception {

	public static String errorCode;
	public static String details;
	
	public static String getErrorCode() {
		return errorCode;
	}
	public static String getDetails() {
		return details;
	}
	
	public APIError generateApiError() {
		return new APIError(500,"Internal Server Error. Please reach out to support.","100");
	}
	
}
