<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

#Table-box {
	width: 600px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 1px solid #31708f;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

</style>
</head>
<body bgcolor="#AAE6FA">
<center>
<div id="Table-box">
<h1>Add New Item</h1>


<form:form modelAttribute="item"  method="POST" action="addItem1">
	<table>
	
		
		<tr>
			<td><form:label path="category">Category:</form:label></td>
			<td><form:input path="category"/></td>
		</tr>
		
		<tr>
			<td><form:label path="itemID">Item ID:</form:label></td>
			<td><form:input path="itemID"/></td>
		</tr>
		
		<tr>
			<td><form:label path="name">Item Name:</form:label></td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="itemPrice">Item Price:</form:label></td>
			<td><form:input path="itemPrice"/></td>
		</tr>
		<tr>
			<td><form:label path="quantity">Quantity:</form:label></td>
			<td><form:input path="quantity"/></td>
		</tr>
		<tr>
			<td><form:label path="desc">Item Content:</form:label></td>
			<td><form:input path="desc"/></td>
		</tr>
		<tr>
        <td><form:label path="imgPath">Item Image</form:label></td>
        <td><form:input path="imgPath"/></td>
    	</tr>
		
	</table>
	
	<input type="submit" value="Add Item" />
</form:form>
</div>
</center>
</body>
</html>