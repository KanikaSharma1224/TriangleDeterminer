package com.triangledeterminer.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.triangledeterminer.model.APIError;

class ErrorHandlerTest {
	private ErrorHandler handler;
	private NonPositiveTriagleSideException nonPositiveSidesEx;
	private EmptyTriangleSidesException emptySidesEx;
	private TriangleDeterminerException ex;

	@BeforeEach
	public void setUp() {
		handler = new ErrorHandler();
		nonPositiveSidesEx = new NonPositiveTriagleSideException();
		emptySidesEx = new EmptyTriangleSidesException();
		ex = new TriangleDeterminerException();

	}

	@Test
	void testGenerateErrorWithNonPostiveTriangleSidesException() {
		APIError expected = nonPositiveSidesEx.generateApiError();
		assertEquals(expected.getClass(), (handler.generateErrorModel(nonPositiveSidesEx).getClass()));
	}

	@Test
	void testGenerateErrorWithEmptyTriangleSidesException() {
		APIError expected = emptySidesEx.generateApiError();
		assertEquals(expected.getClass(), (handler.generateErrorModel(emptySidesEx).getClass()));
	}

	@Test
	void testGenerateErrorWithTriangleDeterminerException() {
		APIError expected = ex.generateApiError();
		assertEquals(expected.getClass(), (handler.generateErrorModel(ex).getClass()));
	}

}
