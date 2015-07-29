package com.patterns.create.AbstractFactoryPattern;

public class Mango implements Shape,Taste{

	public void color() {
		// TODO Auto-generated method stub
		System.out.print("It's mango=green!");
	}

	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.print("sour");
	}

	
}
