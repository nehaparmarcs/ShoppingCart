<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Removing Item</title>
</head>
<body>
<h1>Removing Item</h1>

<jsp:declaration>
	java.util.Enumeration nameOfItem;

</jsp:declaration>
<!-- setting nameOfItems to passed parameters for removing -->
<jsp:scriptlet>
	nameOfItem = request.getParameterNames();
	
	while(nameOfItem.hasMoreElements()){
		String name= (String) nameOfItem.nextElement();
		session.removeAttribute(name);
		// for removing the item from the cart .
	
	}
	
</jsp:scriptlet>

<!-- creating form for the removal(same page action) -->
<form method="get" action="removeItem.jsp">

<table>
	<% if(session.getAttribute("hat") != null) { %>
	<tr>
		<td>
			<input type="checkbox" name="hat">
		</td>
		<td>Hat</td>
	</tr>
	<% } %>
	<% if(session.getAttribute("shoes")!=null){ %>
	<tr>
		<td>
			<input type ="checkbox" name="shoes">
		</td>
		<td>
		Shoes
		</td>
	</tr>
	<% } %>
	<% if(session.getAttribute("Tshirt")!=null){ %>
	<tr>
		<td>
			<input type ="checkbox" name="Tshirt">
		</td>
		<td>
		TShirts
		</td>
	</tr>
	<% } %>
	<% if(session.getAttribute("watch")!=null){ %>
	<tr>
		<td>
			<input type ="checkbox" name="watch">
		</td>
		<td>
		Watches
		</td>
	</tr>
	<% } %>
	<% if(session.getAttribute("trousers")!=null){ %>
	<tr>
		<td>
			<input type ="checkbox" name="trousers">
		</td>
		<td>
		Trousers
		</td>
	</tr>
	<% } %>
</table>

<input type="submit" value="submit">
</form>
</body>
</html>