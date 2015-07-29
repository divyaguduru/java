
package main.com.item.booking;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;  
import javax.ws.rs.GET;
import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
  

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.view.Viewable;

import main.com.item.booking.BO.CartonBO;
import main.com.item.booking.BO.OrderBO;
import main.com.item.booking.BO.SlotBO;
import main.com.item.booking.models.Order;
@Path("/item")  
public class ItemService{  
    private static final Date bookingDate = null;
   
	@GET
    @Path("/add")
//	@Produces(MediaType.TEXT_HTML) 
    public Response addItemOrder(@Context HttpServletResponse response,@Context HttpServletRequest request) {  
   try{
	   
		int noofitems=Integer.parseInt(request.getParameter("noofitems"));
		
		int slotno=Integer.parseInt(request.getParameter("slotno"));

		Order order =new Order();
	
		Map<Integer,Order> map=new HashMap<Integer,Order>();
		for(int i=0;i<noofitems;i++)
		{
		
			String h="height"+(i+1);
			double height =Double.parseDouble(request.getParameter(h)); 
			
			order.setHeight(height);
			String b="breadth"+(i+1);
			double breadth =Double.parseDouble(request.getParameter(b));
			order.setBreadth(breadth);
			String w="width"+(i+1);
			double width =Double.parseDouble(request.getParameter(w));
			order.setWidth(width);
			
			map.put(i,order);
		}
		 
		OrderBO ob=new OrderBO();
		CartonBO cb=new CartonBO();
		
		double orderarea=ob.orderArea(map);
	
		if(orderarea<cb.calculateArea())
	    {
		     SlotBO slotbo=new SlotBO();
	         int a=  slotbo.slotIn(map,slotno,bookingDate);
	         if(a==0)
	         {
	        	 return Response.ok(new Viewable("/successfulslotbooking.jsp",order)).build();
	         }
	         else
	         {
	        	 return Response.ok(new Viewable("/errorslotbooking.jsp",order)).build();
	         }
	       	
		}
		else
		{
			return Response.ok(new Viewable("/errorslotbooking.jsp",order)).build();
		}
       
     }
   catch(Exception e){
	   e.printStackTrace();
   }
 return null;
    
    }  
	
	@GET
    @Path("/details")  
	@Produces(MediaType.TEXT_HTML)  
	  public Response getItemOrder(@Context HttpServletResponse response,@Context HttpServletRequest request) throws Exception { 
		Map<Integer,Order> map=new HashMap<Integer,Order>();
		Order order = new Order();
		int orderno=Integer.parseInt(request.getParameter("orderno"));
	
		order.setOrderno(orderno);
		SlotBO slotbo=new SlotBO();
	map=slotbo.slotOut();
      
        
       if(map.get(1).getSlotno()!=0){
        	 return Response.ok(new Viewable("/orderdetails1.jsp",order)).build(); 
       }
       else
       {
    	   return Response.ok(new Viewable("/errororderno.jsp",order)).build();  
       }
	
}
	
	
}