<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="Your Online shop"/>


 <table>
		<c:forEach items="${items}" var="item">
		<!-- It will Link to details page on clicking item link -->
		
			<tr>
				<td colspan="2">
					<a class="navbar-brand" href="details?itemID=${item.itemID}">
					<span class="pull-right inter_arrw"><img src="${item.imgPath}" alt="${item.desc}"/></span>
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p><span class="pull-right inter_arrw">${item.desc}</span></p>
				</td>
			</tr>
			<tr>
				<td>
					<span class="pull-right inter_arrw">Price: </span>
				</td>
				<td>
					<span class="pull-right inter_arrw">${item.itemPrice}</span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="pull-right inter_arrw">Quantity</span>
				</td>
				<td>
					<span class="pull-right inter_arrw">${item.quantity}</span>
				</td>
			</tr>
		
		
		</c:forEach>
</table>

</body>
</html>