package com.divya.model;



public class Codes {

	public String getCodes(String abc){
		String x= null;
		
		String s0 = abc;
	
		
		if(s0.equalsIgnoreCase("india"))
		{
			x ="+91";
			return x;
		}
		else if(s0.equalsIgnoreCase("new zealand"))
		{
			x ="+64";
			return x;
		
		}
		else if(s0.equalsIgnoreCase("france"))
		{
			x ="+33";
			return x;
		
		}
		else if(s0.equalsIgnoreCase("japan"))
		{
			x ="+81";
			return x;
		
		}
		else if(s0.equalsIgnoreCase("canada"))
		{
			x ="+1";
			return x;
		
		}
		else
		{
			x= "No match found:Please try again";
			return x;
		}
		}
	}

