package divya.webcrawler;

public class WebCrawlerDirector {
	
	void direct(String DLink){
		try
		{
			
			String link;
			if(DLink.contains("http://") || DLink.contains("https://"))
			{		 
				
				HTTPPageResponse goodpage=new HTTP_OKPage();
			    int responsecd=goodpage.response(DLink);
				
		       
			   if(responsecd!=200)
			   {
				   System.out.println("Not an HTTP OK page!Please enter another url");
				   link= WebCrawlerMain.getLink();
					direct(link);
			   }
			   else
			   {   
			
			    CrawlerExecutor c = new CrawlerLinkExecutor();
				c.execute(DLink);
				c.popLink();
		    
			   }
			   }
	        else if(DLink.equals(""))
	           {
	        	 System.out.println("You haven't entered link!Please try again!");
	        	 link= WebCrawlerMain.getLink();
				 direct(link);
	           }
	        else{
					while(!DLink.contains("https://")&&(!DLink.contains("http://")))
					{
						System.out.println("SORRY!Please add http:// or https:// to the url given");
							
						 link= WebCrawlerMain.getLink();
						 direct(link);
					}
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
