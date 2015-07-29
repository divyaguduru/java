package main.com.item.booking.BO;

import java.sql.SQLException;

import main.com.item.booking.DAO.CartonDAO;
import main.com.item.booking.models.Carton;
import main.com.item.booking.models.Order;

public class CartonBO {
    
	double area,height,breadth,width,freespace,iarea,occupiedspace;
    double carea;
    Carton carton =new Carton();
    CartonDAO cartondao=new CartonDAO();
  
  public double calculateArea(){
	   breadth=Carton.getBreadth();
	   height=Carton.getHeight();
	   width=Carton.getWidth();
	   area=(height*breadth*width);
	   Carton.setCartonarea(area);
    	return area;
    }
	
	
  public int cartonCurrentArea() throws SQLException, Exception{
		 
		 Order order=new Order();
		 iarea=order.getOrderarea();
	
		 double x=cartondao.freespaceCarton(carton);
		 if(x!=1)
		 {
		 carea=Carton.getFreespace();
		 if(carea>iarea)
		 {
		 if(carea==area)
		 {
			 Carton.setFreespace(carea-iarea);
			 
			 
			 return 0;
		 }
		 else
		 {
			 Carton.setFreespace(carea-iarea);
			
			  return 0;
		 }
		
		 }
		 else{
			 System.out.println("carton empty space is less than order's area");
			 return 3;
		 }
		 }
		 else
		 {
			 System.out.println("no empty space in carton---------!@$$$$$$$$$$$");
			 return 4;
		 }
		
	 }


public int insertCarton(Order order) throws SQLException {
	CartonDAO cartondao=new CartonDAO();
	int c=cartondao.insertCarton(order);
    if(c==0)
	{
    	return 0;
	}
	return 1;
}

	 }
	
	 
	 
	 
	 

