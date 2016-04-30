<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>

</head>
<body>
Your ORDER# <a href="/orderDetail?userId=mark&orderNum=${order.orderNum}">${order.orderNum}</a> has been placed
</body>
</html>