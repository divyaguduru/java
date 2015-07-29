package com.patterns.create.AbstractFactoryPattern;

public interface AbstractFactory {
	abstract Shape getShape(String shape);
	abstract Taste getTaste(String Taste);
}
