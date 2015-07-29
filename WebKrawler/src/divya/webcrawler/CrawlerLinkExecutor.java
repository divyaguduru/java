package divya.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CrawlerLinkExecutor implements CrawlerExecutor{
	   
	   Queue crawlerq=new CrawlerQ();
	   int linkcount =0; //for counting no. of links executed
	   String currentlink; //current link which is gonna get executed
	   String str;
	   String tagmatch= "<a href=";
	   int responseCd;
	  
	   
	   public void execute(String Link){
	   
		try{ 
		URL myurl =new URL(Link);
		InputStream in =  myurl.openConnection().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		while((str = reader.readLine()) != null) {
		
		    if((str.contains(tagmatch)))
		   {
			   Pattern pattern = Pattern.compile(
			            "((http://|https://|www.)([a-z0-9A-Z]{2,}).([a-z0-9A-Z]*[/|.])([a-z0-9./?:+=!@#$%^&*()])*)");
			   Matcher matcher = pattern.matcher(str);
			   while (matcher.find()) {
			  
			        	 if(matcher.group().substring(0)=="/" )
			        	{
			        		
			        		String insertLink=Link+matcher.group();
			        		System.out.println(insertLink);
			        		crawlerq.insert(insertLink);
			        		
			        	}
			        	 else if(!matcher.group().contains("https") && !matcher.group().contains("http"))
			        	{
			        		 break;
			        	}
			        		else
			        	{
			        	System.out.println(matcher.group());
			            crawlerq.insert(matcher.group());
			        	}
			        }
		 
		   }
		}
		
	}
   catch(IOException e){
			 e.printStackTrace();
		 }
	}
	
	
	   
	   
	   
	   
	 public void popLink(){
		
	try{
		
		while(!crawlerq.isEmpty()){
		
			linkcount++;
			
			currentlink =crawlerq.remove();
			
			System.out.print("linkcount"+linkcount);
			
			HTTPPageResponse goodpage=new HTTP_OKPage();
		    responseCd=goodpage.response(currentlink);
			
	       
		   if(responseCd!=200){
	        	
	        	popLink();
	        }
	       else
	       {
	    	    execute(currentlink);
	       }
		}	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}





	





	

}
