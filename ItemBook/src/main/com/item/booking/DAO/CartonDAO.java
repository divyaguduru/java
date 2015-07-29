	package main.com.item.booking.DAO;
	import java.sql.Connection;

	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Date;
	import main.com.item.booking.models.Carton;
	import main.com.item.booking.models.Order;
			
	public class CartonDAO implements ICartonDAO {
				 
	  int COUNT = 0;
	  OrderDAO orderdao=new OrderDAO();
	   Connection connect = null;
	  Statement statement = null;
	  PreparedStatement preparedStatement = null;
	   ResultSet resultSet = null;
				 
				  
		public int readCarton(int slotno,int vanno,int cartno) throws Exception,SQLException{
					
					Order.setSlotno(slotno);
					Order.setVanno(vanno);
					Order.setCartno(cartno);
					Carton.setSlotno(slotno);
					Carton.setVanno(vanno);
					Carton.setCartno(cartno);
			
			
		try {
			  
	    Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/divyadb","root","root");
		String selectSQL = "SELECT COUNT(*) FROM Carton WHERE slotno=? AND vanno=? AND cartno=?";
				
		 preparedStatement = connect.prepareStatement(selectSQL);
		 preparedStatement.setInt(1, slotno);
		 preparedStatement.setInt(2, vanno);
		 preparedStatement.setInt(3, cartno);
		
		 resultSet = preparedStatement.executeQuery();
		 if (resultSet.next())
		 {
		     int numberOfRows = resultSet.getInt(1);
		     System.out.println("numberOfRows= " + numberOfRows);
		     if(numberOfRows == 0)
		     {
			 Carton.setFreespace(Carton.getCartonarea()-Order.getOrderarea());
		     return 0;
		    	 
		     }
		     else
		     {
		        return 2;
		     }
		   }
		 		    	
		 }
		    catch (Exception e) {
		       e.printStackTrace();
		    } 
		    finally {
		     connect.close();
		    }
			return 0;

		  }
			
			
		
		
		
		public int insertCarton(Order order) throws SQLException {
			
		try {
				     
		  Class.forName("com.mysql.jdbc.Driver");
		  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/divyadb","root","root");
		  preparedStatement = connect.prepareStatement("insert into  Carton(slotno,vanno,cartno,freespace,height,breadth,width,cartonarea) values (?,?,?,?,?,?,?,?)");
		  preparedStatement.setInt(1, Carton.getSlotno());
		  preparedStatement.setInt(2, Carton.getVanno());
		  preparedStatement.setInt(3, Carton.getCartno());
		  preparedStatement.setDouble(4, Carton.getFreespace());
		  preparedStatement.setDouble(5, Carton.getHeight());
		  preparedStatement.setDouble(6, Carton.getWidth());
		  preparedStatement.setDouble(7, Carton.getBreadth());
		  preparedStatement.setDouble(8, Carton.getCartonarea());
		  preparedStatement.executeUpdate();
		   return 0;  
		} 
		catch (Exception e) {
		  e.printStackTrace();
		} 
		finally {
		 connect.close();
		}
			return 1;
			
		}
		
		
		
	public double freespaceCarton(Carton cart) throws Exception,SQLException{
			Order.setSlotno(Carton.getSlotno());
			Order.setVanno(Carton.getVanno());
			Order.setCartno(Carton.getCartno());
			
	 try {
			      
	     Class.forName("com.mysql.jdbc.Driver");
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/divyadb","root","root");
		  String selectSQL = "SELECT MIN(freespace) FROM Carton WHERE slotno=? AND vanno=? AND cartno=?";
		
		 preparedStatement = connect.prepareStatement(selectSQL);
		 preparedStatement.setInt(1, Order.getSlotno());
		 preparedStatement.setInt(2, Order.getVanno());
		 preparedStatement.setInt(3, Order.getCartno());
		
		 resultSet = preparedStatement.executeQuery();
	
		 if (resultSet.next())
		 {
		     double space = resultSet.getDouble(1);
		     System.out.println("numberOfRows!$%SDF#@$$$$$$= " + space);
		     if(space == 0){
		     return 1;
		     }
		     else
		     {
		    	Carton.setFreespace(resultSet.getDouble(1));
		       return 0;    
		     } 
		 	
		 } 
          }
		    catch (Exception e) {
		        e.printStackTrace();
		      } 
		      finally {
		       connect.close();
		      }
			return 1;
		
				    
		 }
		}
		 
				   
			
		
