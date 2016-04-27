<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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
</body>
</html>