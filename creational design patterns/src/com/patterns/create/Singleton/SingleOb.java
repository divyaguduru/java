package com.patterns.create.Singleton;

public class SingleOb {

	private static SingleOb dfvar=new SingleOb();
	
	static SingleOb getinstance(){
		return dfvar;
	}
	
	void showMessage(){
		System.out.print("created");
	}
}
