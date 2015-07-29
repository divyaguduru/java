package com.patterns.create.AbstractFactoryPattern;

public class AbstractFactoryPattern {
public static void main(String[] args){
	ShapeFactory sf = new ShapeFactory();
	
	Shape s1 = sf.getShape("Mango");
	s1.color();
	
	Shape s2 = sf.getShape("Orange");
	s2.color();
	
	Shape s3 = sf.getShape("Apple");
	s3.color();
	
TasteFactory sf1 = new TasteFactory();
	
	Taste s11 = sf1.getTaste("Mango");
	s11.taste();
	
	Taste s21 = sf.getTaste("Orange");
	s21.taste();
	
	Taste s31 = sf.getTaste("Apple");
	s31.taste();
	
	
}
	
}

