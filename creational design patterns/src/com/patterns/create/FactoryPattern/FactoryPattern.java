package com.patterns.create.FactoryPattern;

public class FactoryPattern {
public static void main(String[] args){
	ShapeFactory sf = new ShapeFactory();
	
	Shape s1 = sf.getShape("Mango");
	s1.color();
	
	Shape s2 = sf.getShape("Orange");
	s2.color();
	
	Shape s3 = sf.getShape("Apple");
	s3.color();
}
	
}

