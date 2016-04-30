<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>


</head>
<body>
	<table>
		<tr>
			<td>Order# ${order.orderNum }</td>
		</tr>
		<tr>
			<td>Date ${order.orderDate }</td>
		</tr>
		<c:forEach items="${order.items}" var="item">
			<tr>

				<td>${item.name}</td>
				<td>${item.desc}</td>
				<td>${item.quantity}</td>
				<td>${item.totalPrice}</td>

			</tr>
		</c:forEach>

	</table>
	<div>Total: ${order.total}</div>




</body>
</html>