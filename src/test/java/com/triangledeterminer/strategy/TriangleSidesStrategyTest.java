package com.triangledeterminer.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.triangledeterminer.model.Triangle;
import com.triangledeterminer.model.Type;

class TriangleSidesStrategyTest {
	private TriangleSidesStrategy sideStrategy;
	private Triangle triangle;

	@BeforeEach
	public void setUp() {
		sideStrategy = new TriangleSidesStrategy();
		triangle = new Triangle();
	}

	@Test
	void testGivesEquilateralTypeWhenTriangleAllThreeSidesAreEqual() {
		triangle.setSide1(2.5f);
		triangle.setSide2(2.5f);
		triangle.setSide3(2.5f);
		assertSame(Type.EQUILATERAL, sideStrategy.determineType(triangle));
	}

	@Test
	void testGivesIsocelesTypeWhenTriangleTwoSidesAreEqual() {
		triangle.setSide1(3.3f);
		triangle.setSide2(2.5f);
		triangle.setSide3(3.3f);
		assertSame(Type.ISOSCELES, sideStrategy.determineType(triangle));
	}

	@Test
	void testGivesScaleneTypeWhenTriangleThreeSidesAreUnequal() {
		triangle.setSide1(1.5f);
		triangle.setSide2(2.5f);
		triangle.setSide3(3.5f);
		assertSame(Type.SCALENE, sideStrategy.determineType(triangle));
	}

}
