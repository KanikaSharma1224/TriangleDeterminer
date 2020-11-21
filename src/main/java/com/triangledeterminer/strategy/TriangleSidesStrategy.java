package com.triangledeterminer.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.triangledeterminer.model.Triangle;
import com.triangledeterminer.model.TriangleStrategy;
import com.triangledeterminer.model.Type;

public class TriangleSidesStrategy implements TriangleStrategy {
	private Logger logger = LogManager.getLogger(TriangleSidesStrategy.class);

	@Override
	public Type determineType(Triangle triangle) {
		float side1 = triangle.getSide1();
		float side2 = triangle.getSide2();
		float side3 = triangle.getSide3();
		
		logger.info("In DetermineType Side1 : {}, Side2 : {}, Side3 : {} ", triangle.getSide1(), triangle.getSide2(),
				triangle.getSide3());

		if ((side1 == side2) && (side1 == side3)) {
			return Type.EQUILATERAL;
		}

		if ((side1 == side2) || (side1 == side3) || (side2 == side3)) {
			return Type.ISOSCELES;
		}

		if ((side1 != side2) && (side1 != side3) && (side2 != side3)) {
			return Type.SCALENE;
		}

		return null;

	}

}
