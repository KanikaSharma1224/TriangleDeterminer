package com.triangledeterminer.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.triangledeterminer.error.EmptyTriangleSidesException;
import com.triangledeterminer.error.NonPositiveTriagleSideException;
import com.triangledeterminer.error.TriangleDeterminerException;
import com.triangledeterminer.model.Triangle;
import com.triangledeterminer.validation.Validator;

public class ValidatorTest {

	private Validator validator;
	private Triangle triangle;

	@BeforeEach
	public void setUp() {
		validator = new Validator();
		triangle = new Triangle();

	}

	@Test
	public void testValidatesNonEmptySides() throws TriangleDeterminerException {
		triangle.setSide1(2.9f);
		triangle.setSide2(1.9f);
		triangle.setSide3(0.9f);
		assertDoesNotThrow(() -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenAllThreeSidesAreEmpty() {
		assertThrows(EmptyTriangleSidesException.class, () -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenOneTriangleSideisEmpty() {
		triangle.setSide1(3.5f);
		triangle.setSide3(2.3f);
		assertThrows(EmptyTriangleSidesException.class, () -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenTwoTriangleSidesAreEmpty() {
		triangle.setSide3(2.3f);
		assertThrows(EmptyTriangleSidesException.class, () -> validator.validateTriangle(triangle));
	}

	@Test
	public void testValidatesNonPositiveSidesException() {
		triangle.setSide1(0.9f);
		triangle.setSide2(2.8f);
		triangle.setSide3(1.5f);
		assertDoesNotThrow(() -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenAllTriangleSidesAreNegative() {
		triangle.setSide1(-0.5f);
		triangle.setSide2(-1.6f);
		triangle.setSide3(-3.2f);
		assertThrows(NonPositiveTriagleSideException.class, () -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenTwoTriangleSidesAreNegative() {
		triangle.setSide1(2.5f);
		triangle.setSide2(-1.9f);
		triangle.setSide3(-3.1f);
		assertThrows(NonPositiveTriagleSideException.class, () -> validator.validateTriangle(triangle));
	}

	@Test
	public void testThrowsExceptionWhenOneTriangleSideIsNegative() {
		triangle.setSide1(4.3f);
		triangle.setSide2(2.7f);
		triangle.setSide3(-3.1f);
		assertThrows(NonPositiveTriagleSideException.class, () -> validator.validateTriangle(triangle));
	}

}
