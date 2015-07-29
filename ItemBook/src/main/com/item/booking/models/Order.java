package main.com.item.booking.models;

import java.util.Date;

public class Order {

	public static double orderno;
	public static double height;
	public static double width;
	public static double breadth;
	static double orderarea;
	public static int vanno;
	public static int slotno;
	public static int cartno;

		public static double getOrderarea() {
		return orderarea;
	}

	public static void setOrderarea(double orderarea) {
		Order.orderarea = orderarea;
	}

		public void setBookingDate(Date bookingDate) {
		// TODO Auto-generated method stub
		
	}

	public static double getOrderno() {
			return orderno;
		}

		public static void setOrderno(double orderno) {
			Order.orderno = orderno;
		}

		public static double getHeight() {
			return height;
		}

		public static void setHeight(double height) {
			Order.height = height;
		}

		public static double getWidth() {
			return width;
		}

		public static void setWidth(double width) {
			Order.width = width;
		}

		public static double getBreadth() {
			return breadth;
		}

		public static void setBreadth(double breadth) {
			Order.breadth = breadth;
		}

		public static int getVanno() {
			return vanno;
		}

		public static void setVanno(int vanno) {
			Order.vanno = vanno;
		}

		public static int getSlotno() {
			return slotno;
		}

		public static void setSlotno(int slotno) {
			Order.slotno = slotno;
		}

		public static int getCartno() {
			return cartno;
		}

		public static void setCartno(int cartno) {
			Order.cartno = cartno;
		}

	public Date getBookingDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
