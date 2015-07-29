package main.com.item.booking.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import main.com.item.booking.models.Order;

public class OrderDAO implements IOrderDAO{
	 private Connection connect = null;
	 private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  
	public int bookOrder(Map<Integer, Order> m, int slotno, int vanno, int cartno) throws Exception,SQLException
	{
		
             try 
		    {
		      Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/divyadb","root","root");
		      int num=m.size();
		      preparedStatement = connect.prepareStatement("INSERT into  orders(slotno,vanno,height1,width1,breadth1,height2,width2,breadth2,height3,width3,breadth3,height4,width4,breadth4,height5,width5,breadth5,cartno,orderarea)"
		      		+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		   		      
   		      preparedStatement.setInt(1, Order.getSlotno());
   		      preparedStatement.setInt(2, Order.getVanno());
   		      preparedStatement.setDouble(3, m.get(0).getHeight());
   		      preparedStatement.setDouble(4, m.get(0).getWidth());
   		      preparedStatement.setDouble(5, m.get(0).getBreadth());
   		   preparedStatement.setDouble(6,m.get(1).getHeight());
		      preparedStatement.setDouble(7, m.get(1).getWidth());
		      preparedStatement.setDouble(8,m.get(1).getBreadth());
		      preparedStatement.setDouble(9, m.get(2).getHeight());
   		      preparedStatement.setDouble(10, m.get(2).getWidth());
   		      preparedStatement.setDouble(11, m.get(2).getBreadth());
   		   preparedStatement.setDouble(12, m.get(3).getHeight());
		      preparedStatement.setDouble(13, m.get(3).getWidth());
		      preparedStatement.setDouble(14,m.get(3).getBreadth());
		      preparedStatement.setDouble(15,m.get(4).getHeight());
   		      preparedStatement.setDouble(16, m.get(4).getWidth());
   		      preparedStatement.setDouble(17, m.get(4).getBreadth());
   		      preparedStatement.setDouble(18, Order.getCartno());
   		      preparedStatement.setDouble(19, Order.getOrderarea());
   		      preparedStatement.executeUpdate();
		   		  
		     return 0;
		    }
		    catch (Exception e) 
		    {
		      e.printStackTrace();;
		    } 
		    finally
		    {
		      connect.close();
		    }
			return 1;
      
	}


	
	public Map readOrder() throws Exception,SQLException{
	       
		try
	       {
			Map<Integer,Order> map1=new HashMap<Integer,Order>();
			Order order=new Order();
			System.out.print("hiiiiiiii");
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/divyadb","root","root");  
				String selectSQL = "SELECT * from Orders where orderno=?";
				preparedStatement = connect.prepareStatement(selectSQL);
				preparedStatement.setDouble(1, Order.getOrderno());
				resultSet = preparedStatement.executeQuery();
								
			     while ( resultSet.next() ) 
			      {
			    	  order.setOrderno(resultSet.getDouble(1));
			    	  order.setSlotno(resultSet.getInt(2));
			    	  order.setCartno(resultSet.getInt(3));
			    	  order.setVanno(resultSet.getInt(4));
			    	  order.setOrderarea(resultSet.getDouble(5));
			    	  order.setHeight(resultSet.getDouble(6));
			    	  order.setWidth(resultSet.getDouble(7));
			    	  order.setBreadth(resultSet.getDouble(8));
			    	  map1.put(1, order);
			    	  order.setHeight(resultSet.getDouble(9));
			    	  order.setWidth(resultSet.getDouble(10));
			    	  order.setBreadth(resultSet.getDouble(11));
			    	  if(order.getHeight()!=0 && order.getBreadth()!=0 && order.getWidth()!=0)
			    	  {
			    	  map1.put(2, order);
			    	  }
			    	  order.setHeight(resultSet.getDouble(12));
			    	  order.setWidth(resultSet.getDouble(13));
			    	  order.setBreadth(resultSet.getDouble(14));
			    	  if(order.getHeight()!=0 && order.getBreadth()!=0 && order.getWidth()!=0)
			    	  {
			    	  map1.put(3, order);
			    	  }
			    	  
			    	  order.setHeight(resultSet.getDouble(15));
			    	  order.setWidth(resultSet.getDouble(16));
			    	  order.setBreadth(resultSet.getDouble(17));
			    	  if(order.getHeight()!=0 && order.getBreadth()!=0 && order.getWidth()!=0)
			    	  {
			    	  map1.put(4, order);
			    	  }
			    	  order.setHeight(resultSet.getDouble(18));
			    	  order.setWidth(resultSet.getDouble(19));
			    	  order.setBreadth(resultSet.getDouble(20));
			    	 
			    	 
			    	  if(order.getHeight()!=0 && order.getBreadth()!=0 && order.getWidth()!=0)
			    	  {
			    	  map1.put(5, order);
			    	  }
			    	   
			      }
			   System.out.println( map1.get(1).getBreadth());
			     return map1;
			     
	       }
			 catch (Exception e) {
			       e.printStackTrace();;
			    } 
			 finally {
			      connect.close();
			    }
			return null;

}
}