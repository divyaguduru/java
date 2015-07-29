package divya.webcrawler;

import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP_OKPage extends HTTPPageResponse {
	HttpURLConnection httpConn;
	URL url;
	
	@Override
	int response(String Link){
		
		try{
			url=new URL(Link);
			httpConn = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConn.getResponseCode();
	        System.out.println("Link responsecode:"+responseCode);
	        return responseCode;
		  }
		  catch(Exception e){
			e.printStackTrace();
		  }
		return 0;
	}

	
	
}
