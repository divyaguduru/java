package divya.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WebCrawlerMain {
	
	public static void main(String[] args) throws IOException{
			
		try {
			       
			       String link=getLink();
				   WebCrawlerDirector wcdirector=new WebCrawlerDirector();
				   wcdirector.direct(link);
		    }
		    catch (Exception e)
		    {
					e.printStackTrace();
		    }
		}
	
	
  public static String getLink() {
		try
		{
			System.out.println("Please enter the url"); 
			
			InputStreamReader isr = new InputStreamReader(System.in);
	    	BufferedReader br = new BufferedReader(isr);
	    	String s = br.readLine();
	    	return s;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		     return null;
		}
		
	
}
