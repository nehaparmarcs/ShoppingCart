<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>


</head>
<body>
	<c:choose>
		<c:when test="${orderList.orders.size() == 0}">
       You have no order
    </c:when>
		<c:otherwise>
			<div>Your orders</div>
			<table>

				<c:forEach items="${orderList.orders}" var="order">
					<tr>
						<td>Date ${order.orderDate }</td>
						<td>ORDER# <a
							href="/orderDetail?userId=mark&orderNum=${order.orderNum}">${order.orderNum}</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>