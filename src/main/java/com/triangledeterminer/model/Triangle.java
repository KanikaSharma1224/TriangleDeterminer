package com.triangledeterminer.model;

public class Triangle implements Shape {
	private float side1;
	private float side2;
	private float side3;
	
	
	public Triangle() {		
	}
	
	public void setSide1(float side1) {
		this.side1 = side1;
	}
	
	public void setSide2(float side2) {
		this.side2 = side2;
	}
	
	public void setSide3(float side3) {
		this.side3 = side3;
	}
	
	public float getSide1() {
		return this.side1;
	}
	
	public float getSide2() {
		return this.side2;
	}
	
	public float getSide3() {
		return this.side3;
	}
	

}
