package main.com.item.booking.BO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import main.com.item.booking.DAO.IOrderDAO;
import main.com.item.booking.DAO.OrderDAO;
import main.com.item.booking.models.Order;

public class OrderBO {
	double height,breadth,width,area;
	Order order=new Order();
	IOrderDAO orderdao=new OrderDAO();
	
	public double orderArea(Map<Integer, Order> m){
			
		int noofitems=m.size();
		double area=0;
		for(int i=0;i<noofitems;i++){
			
			height=m.get(i).getHeight();
			breadth=m.get(i).getBreadth();
			width=m.get(i).getWidth();		
			area=area+(height*breadth*width);
			}
		Order.setOrderarea(area);
		return  area;
		
		}
	 

	public int orderSlot(Map<Integer, Order> m, int slotno, int vanno, int cartno) throws Exception{
			Order.setSlotno(slotno);
			Order.setVanno(vanno);
			Order.setCartno(cartno);
			
			
			int x=orderdao.bookOrder(m,slotno,vanno,cartno);
			
			if(x==0)
			{
				return 0;
			}
			return 1;
		}
		
	public Map getItemOrder() throws Exception{
		Map<Integer,Order> m1=new HashMap<Integer,Order>();
	
			m1=orderdao.readOrder();
			
			
				return m1;
			
		}
		
		
		
}
