package main.com.item.booking.DAO;

import java.sql.SQLException;

import main.com.item.booking.models.Order;

public interface ICartonDAO {
	 int readCarton(int slotno,int vanno,int cartno) throws Exception, SQLException ;
	 int insertCarton(Order order) throws  Exception, SQLException;
}
