<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="main.com.item.booking.ItemService" %>
<%@ page import="main.com.item.booking.models.Order" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body style='background-color:lightblue;'>

		
<h1 align='center'><font color='white'>Item Slot Booking</font></h1>
<a href='http://localhost:8080/ItemBook/indexpage.html' align='center'>Home Page</a>

<p align='center'><font color='white'>Slot is booked</font></p>
<p align='center'><font color='white'></font></p>

<p align='center'><font color='white'>Vanno:${it.getVanno()}</font></p>
<p align='center'><font color='white'>Cartno:${it.getCartno()}</font></p>
 <p align='center'><font color='white'>Slotno:${it.getSlotno()}</font></p>
<p align='center'><font color='white'>Height:${it.getHeight()}</font></p>
<p align='center'><font color='white'>Breadth:${it.getBreadth()}</font></p>
<p align='center'><font color='white'>Width:${it.getWidth()}</font></p> 
     
</body>
</html>