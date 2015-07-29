package main.com.item.booking.DAO;

import java.sql.SQLException;
import java.util.Map;

import main.com.item.booking.models.Order;

public interface IOrderDAO {
	 Map readOrder() throws Exception,SQLException;
	 int bookOrder(Map<Integer, Order> m, int slotno, int vanno, int cartno) throws Exception,SQLException;
}
