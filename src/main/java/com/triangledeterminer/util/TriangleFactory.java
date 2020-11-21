package com.triangledeterminer.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.triangledeterminer.model.TriangleDeterminer;
import com.triangledeterminer.strategy.TriangleSidesStrategy;

@Configuration
public class TriangleFactory {

	@Bean(name = "TriangleSideDeterminer")
	public TriangleDeterminer getTriangleDeterminerWithSideStrategy() {
		TriangleDeterminer determiner = new TriangleDeterminer();
		determiner.setStrategy(new TriangleSidesStrategy());
		return determiner;
	}
	
}
