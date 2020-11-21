package com.triangledeterminer.model;

public class TraingleType {

	private Type triangleType;

	public TraingleType(String triangleType) {
		super();
		System.out.println("Triangle Type : " + triangleType);
		this.triangleType = Type.valueOf(triangleType);
	}

	public Type getTriangleType() {
		return triangleType;
	}

	public void setTriangleType(Type triangleType) {
		this.triangleType = triangleType;
	}
	
}
