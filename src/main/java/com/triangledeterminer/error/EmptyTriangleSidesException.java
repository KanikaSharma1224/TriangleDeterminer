package com.triangledeterminer.error;

import com.triangledeterminer.model.APIError;

public class EmptyTriangleSidesException extends TriangleDeterminerException {
	
	public APIError generateApiError() {
		return new APIError(400,"One of the triangle sides is not a number","001");
	}

}
