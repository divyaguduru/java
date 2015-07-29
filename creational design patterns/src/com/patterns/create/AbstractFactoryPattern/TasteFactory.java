package com.patterns.create.AbstractFactoryPattern;

public class TasteFactory implements AbstractFactory {

	public Shape getShape(String shapeType){
		
		return null;
	}

	@Override
	public Taste getTaste(String Taste) {
		// TODO Auto-generated method stub
		if(Taste == null){
			return null;
		}
		else if(Taste.equalsIgnoreCase("sweet"))
		{
			return new Apple();
		}
		else if(Taste.equalsIgnoreCase("sour"))
		{
			return new Mango();
		}
		else if(Taste.equalsIgnoreCase("ripe"))
		{
			return new Orange();
		}
		return null;
	}

}
