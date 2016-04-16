<%@ page import ="java.io.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@include file="hitCounter.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add to Cart</title>
</head>
<body>
<h1>Adding to cart</h1>

	<jsp:declaration>
	//declaration for variables to be available to scriptlets
		java.util.Enumeration nameOfItem;
		java.util.Enumeration values;
		

	</jsp:declaration>
	
	<!-- for getting the values passed from the checkboxes(client request) to name and value -->
	<jsp:scriptlet>
	nameOfItem = request.getParameterNames();
	values = request.getParameterNames();
	
	while(nameOfItem.hasMoreElements()){ //to check if client has more items
		String name = (String) nameOfItem.nextElement();
		String value =(String) values.nextElement();	
		session.setAttribute(name, value); //setting items for this session only
		}
	</jsp:scriptlet>
	<!-- creating a form and directing the action to the same jsp page -->
	
	<form method="get" action="addToCart.jsp">
	
	
<!-- Creating tables for checkboxes -->

	<table>
	<tr>
		<td>
		<input type="checkbox" <% if(session.getAttribute("hat") !=null)
		out.print("checked"); %> name = "hat"> 
		<!-- if this item is checked then show this item and set session atttribute to hat -->
		</td>
		<td>Hat</td>
	</tr>
	<!-- Creating a few more items -->
	<tr>
		<td>
		<input type ="checkbox" <% if(session.getAttribute("shoes")!=null)
			out.print("checked");%> name = "shoes">
		</td>
		<td>Shoes</td>
	</tr>
	<tr>
		<td>
		<input type ="checkbox" <%if(session.getAttribute("Tshirt")!=null)
			out.print("checked");%> name="Tshirt">
		</td>
		<td>TShirt</td>
	</tr>
	<tr>
		<td>
		<input type ="checkbox" <% if(session.getAttribute("watch")!=null)
			out.print("checked");%> name = "watch">
		</td>
		<td>watch</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" <% if(session.getAttribute("trousers")!=null)
				out.print("checked");%> name ="trousers">
		</td>
		<td>Trousers</td>
	</tr>
	</table>
	<br>
	<input type ="submit" value ="Submit">
	</form>
</body>
</html>