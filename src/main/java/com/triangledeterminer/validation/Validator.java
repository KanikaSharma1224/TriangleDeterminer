package com.triangledeterminer.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.triangledeterminer.error.EmptyTriangleSidesException;
import com.triangledeterminer.error.NonPositiveTriagleSideException;
import com.triangledeterminer.error.TriangleDeterminerException;
import com.triangledeterminer.model.Triangle;

@Service
public class Validator {
	private static final Logger logger = LogManager.getLogger(Validator.class);

	public void validateTriangle(Triangle triangle) throws TriangleDeterminerException {
		// TODO Auto-generated method stub
		/*
		 * 1. non empty sides 2. non negative and non zero
		 */
		validateNonEmptySides(triangle);
		validateNonNegativeSides(triangle);
		logger.info("Validate finished");
	}

	private void validateNonEmptySides(Triangle triangle) throws TriangleDeterminerException {
		logger.info("Empty Triangle Sides Exception");
		if (triangle == null)
			throw new EmptyTriangleSidesException();
		if (triangle.getSide1() == 0.0 || triangle.getSide2() == 0.0 || triangle.getSide3() == 0.0)
			throw new EmptyTriangleSidesException();
	}

	private void validateNonNegativeSides(Triangle triangle) throws TriangleDeterminerException {
		if (triangle == null)
			throw new EmptyTriangleSidesException();
		if (triangle.getSide1() < 0.0 || triangle.getSide2() < 0.0 || triangle.getSide3() < 0.0)
			throw new NonPositiveTriagleSideException();

	}

}
