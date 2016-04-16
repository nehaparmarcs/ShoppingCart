<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>

<!-- including CDATA so that we can compile jsp because including XML -->
<jsp:scriptlet><![CDATA[
  java.util.Enumeration content = session.getAttributeNames();
  while(content.hasMoreElements())
  {
	  out.println(content.nextElement());
	  out.println("<br>");
  }
  
  ]]></jsp:scriptlet>>
</body>
</html>