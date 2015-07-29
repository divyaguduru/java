package main.com.item.booking.BO;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import main.com.item.booking.DAO.CartonDAO;
import main.com.item.booking.models.Carton;
import main.com.item.booking.models.Order;

public class SlotBO {
	
	
	CartonDAO cartondao=new CartonDAO();
	CartonBO cartonbo=new CartonBO();
	OrderBO orderbo = new OrderBO();
	Carton carton =new Carton();
	CartonBO cartonboo=new CartonBO();
	Order order=new Order();

	
	int orderSlot(Map<Integer, Order> m) throws SQLException, Exception {
	
	int vanno=0,cartno=0;
		
		
		int slotno=Order.getSlotno();
		for(vanno=1;vanno<5;vanno++)
		{
			for( cartno=1;cartno<20;cartno++)
			{
				int a =cartondao.readCarton(slotno,vanno,cartno);
		
				if(a==0)
				{
					int b=orderbo.orderSlot(m,slotno,vanno,cartno);
					
					if(b==0)
					{
						int c=cartonbo.insertCarton(order);
					    if(c==0)
						{
					    	return 0;
						}
								
					}
					
				}
					else if(a==2)
					{
						int z=cartonbo.cartonCurrentArea();
						if(z==0)
						{
						  int b=orderbo.orderSlot(m,slotno,vanno,cartno);
						  if(b==0){
							int c=cartonbo.insertCarton(order);
							if(c==0)
							{
							return 0;
							}
					}
				  }	
			   }
			}
		}
		return 1;
	}
		
	
		
	public int slotIn(Map<Integer, Order> m, int slotno,Date bookingDate) throws SQLException, Exception{
	
		  double cartarea,orderarea;
		 cartarea=cartonboo.calculateArea();
	     
	        Order.setSlotno(slotno);
	       int a1=orderSlot(m);
	         if(a1==0){
	        	 System.out.println("Slot is booked");
	         return 0;
	         }
	         else{
	        	 System.out.println("There are no carts and vans available for the slot.Book in next slot");
	        	 return 1;
	         }
	        
	     }
	
	
		public Map slotOut() throws Exception {
			Map<Integer,Order> m1=new HashMap<Integer,Order>();
			
		 m1=orderbo.getItemOrder();
		 System.out.println("slotbo a");
		 if(m1!=null)
		 {
			 return m1;
		 }
		 
			 return null;
		 
		  }
	}
