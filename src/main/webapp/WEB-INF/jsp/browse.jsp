<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="Your Online shop"/>
<spring:url value="/css/images" var="imgPath" scope="request"/>

<%

%>


	<c:if test="${not empty ${items}"> 
		<c:forEach items="${items}" var="item">
		<!-- It will Link to details page on clicking item link -->
			<a href="">
			<span class="pull-right inter_arrw"><img src="${item.imgPath}" alt="${item.desc}"/></span>
			</a>
			<span class="pull-right inter_arrw">Item Description</span>
			<span class="pull-right inter_arrw">${item.desc}</span>
			<span class="pull-right inter_arrw">Item Price</span>
			<span class="pull-right inter_arrw">${item.itemPrice}</span>
			<span class="pull-right inter_arrw">Quantity</span>
			<span class="pull-right inter_arrw">${item.quantity}</span>
		</c:forEach>
		<p></p>
	</div>
	</c:if> 

</body>
</html>