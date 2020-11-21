package com.triangledeterminer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleDeterminer implements ShapeDeterminer {
	private static final Logger logger = LogManager.getLogger(TriangleDeterminer.class);

	TriangleStrategy strategy;

	@Override
	public String qualify(Shape shape) {
		// TODO Auto-generated method stub
		Triangle triangle = (Triangle) shape;
		logger.info("Triangle Side1 : {}, Side2 : {}, Side3 : {}  ", triangle.getSide1(), triangle.getSide2(),
				triangle.getSide3());

		String result = strategy.determineType(triangle).name();
		logger.info("Type after qualify method : {}", result);
		return result;

	}

	public TriangleStrategy getStrategy() {
		return null;
	}

	public void setStrategy(TriangleStrategy strategy) {
		this.strategy = strategy;
	}

}
