package com.triangledeterminer.error;

import com.triangledeterminer.model.APIError;

public class NonPositiveTriagleSideException extends TriangleDeterminerException {

	public APIError generateApiError() {
		return new APIError(400,"All traingle sides must be positive.","002");
	}
	
}
