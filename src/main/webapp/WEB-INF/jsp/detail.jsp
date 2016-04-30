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
<form action="login1" method="post">
<c:set var="item" value="${item}" />

${item.imgPath}
${item.desc}
${item.itemPrice}
${item.quantity}

<input class="btn btn-lg btn-success btn-block" type="submit" value="Add To Cart">
<input class="btn btn-lg btn-success btn-block" type="submit" value="Buy">

</form>


</body>
</html>