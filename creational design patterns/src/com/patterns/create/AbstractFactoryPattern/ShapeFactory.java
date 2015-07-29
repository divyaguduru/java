package com.patterns.create.AbstractFactoryPattern;

public class ShapeFactory implements AbstractFactory{

public Shape getShape(String shapeType){
	if(shapeType == null){
		return null;
	}
	else if(shapeType.equalsIgnoreCase("Apple"))
	{
		return new Apple();
	}
	else if(shapeType.equalsIgnoreCase("Mango"))
	{
		return new Mango();
	}
	else if(shapeType.equalsIgnoreCase("Orange"))
	{
		return new Orange();
	}
	return null;
}

@Override
public Taste getTaste(String Taste) {
	// TODO Auto-generated method stub
	return null;
}

}
