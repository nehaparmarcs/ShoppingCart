<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>
<script type="text/javascript">
	function addToCart(userid, id, name, desc, itemPrice, quantity, imgPath) {
		$(document).ready(function() {
			$("#addMsg").html("");
		});
		$.ajax({
			url : "/addItemtoCart",
			type : 'POST',
			contentType : 'application/json',
			data : "{\"userid\": \"" + userid + "\"" + ",\"id\": \"" + id
					+ "\"" + ",\"name\": \"" + name + "\"" + ",\"desc\": \""
					+ desc + "\"" + ",\"itemPrice\":" + itemPrice
					+ ",\"quantity\":" + quantity + ",\"imgPath\": \""
					+ imgPath + "\"" + "}",
			success : function(data) {
				$(document).ready(function() {
					$("#addMsg").html(data);
				});
			},
			error : function(data, status, er) {
				alert("er:" + er);
			}
		});
	}
</script>
</head>
<body>
	<form:form action="/addItem" method="post" modelAttribute="itemForm">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th>id</th>
				<td><form:input type="text" path="id" /></td>
			</tr>
			<tr>
				<th>name</th>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<th>Desc</th>
				<td><form:input type="text" path="desc" /></td>
			</tr>
			<tr>
				<th>itemPrice</th>
				<td><form:input type="text" path="itemPrice" /></td>
			</tr>
			<tr>
				<th>quantity</th>
				<td><form:input type="text" path="quantity" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${error}">
		<!--  start message-red -->
		<div class="clear"></div>
		<div style="color: red;">${errorMsg}</div>
		<!--  end message-red -->
	</c:if>
	<div id="addMsg"></div>
	<a href="/viewCart?userId=mark">View Cart</a>
	<a href="/viewOrders?userId=mark">View Your Orders</a>
	<button type="button"
		onclick="addToCart('mark', '9', 't-shirt', 'the most t-shirt ever', 99.9, 1, 'thepath')">Add
		to Cart</button>
</body>
</html>