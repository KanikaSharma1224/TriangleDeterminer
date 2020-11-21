package com.triangledeterminer.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.triangledeterminer.model.APIError;

@ControllerAdvice
public class ErrorHandler {
	private static final Logger logger = LogManager.getLogger(ErrorHandler.class);

	public static APIError generateErrorModel(Exception ex) {
		if (ex instanceof TriangleDeterminerException)
			return ((TriangleDeterminerException) ex).generateApiError();
		else if (ex instanceof IllegalStateException || ex instanceof HttpMessageNotReadableException) {
			return new APIError(400, "Please enter valid input with 3 sides and all decimal numbers", "003");
		}
		return new TriangleDeterminerException().generateApiError();
	}

}
