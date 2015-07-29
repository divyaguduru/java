package com.patterns.create.AbstractFactoryPattern;

public class Orange implements Shape,Taste {

public void color(){
	// TODO Auto-generated method stub
	System.out.print("It's Orange!");
}

@Override
public void taste() {
	// TODO Auto-generated method stub
	System.out.print("ripe");
}
}
