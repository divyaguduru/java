package main.com.item.booking.models;

public class Carton {
static double height=15;


public static double breadth=30;


public static double width=15;


static double freespace;


static double occupiedspace;


static double cartonarea;


static int cartno,slotno,vanno;
 
 
 
 
public static double getCartonarea() {
	return cartonarea;
}




public static void setCartonarea(double cartonarea) {
	Carton.cartonarea = cartonarea;
}




public static double getHeight() {
	return height;
}




public static void setHeight(double height) {
	Carton.height = height;
}




public static double getBreadth() {
	return breadth;
}




public static void setBreadth(double breadth) {
	Carton.breadth = breadth;
}




public static double getWidth() {
	return width;
}




public static void setWidth(double width) {
	Carton.width = width;
}




public static double getFreespace() {
	return freespace;
}




public static void setFreespace(double freespace) {
	Carton.freespace = freespace;
}




public static double getOccupiedspace() {
	return occupiedspace;
}




public static void setOccupiedspace(double occupiedspace) {
	Carton.occupiedspace = occupiedspace;
}




public static int getCartno() {
	return cartno;
}




public static void setCartno(int cartno) {
	Carton.cartno = cartno;
}




public static int getSlotno() {
	return slotno;
}




public static void setSlotno(int slotno) {
	Carton.slotno = slotno;
}




public static int getVanno() {
	return vanno;
}




public static void setVanno(int vanno) {
	Carton.vanno = vanno;
}




public Carton() {
	// TODO Auto-generated constructor stub
}



 
}
