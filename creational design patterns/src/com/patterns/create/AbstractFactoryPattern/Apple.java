package com.patterns.create.AbstractFactoryPattern;


public class Apple implements Shape,Taste {

	public void color() {
		// TODO Auto-generated method stub
		System.out.print("It's apple");
	}

	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.print("sweet");
	}

}