<%@ page import="java.io.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<!-- The title name has to be changed when the name of the website is decided -->
<style>
	*{font-size: 12ppx;font-family:Verdana}
	input{border: 1px solid #fffff}	
</style>

</head>
<body>
<%
Integer hitCounts=(Integer)application.getAttribute("hitsCounter");

	if(hitCounts==null || hitCounts==0)
{
	//first visit on this website
	out.println("Welcome to our website");
	//set the hit count to 1
	hitCounts=1;
}
	else
	{
		//if second or subsequent visit
		out.println("Welcome back to our website");
		//count this hit aswell into the hit counts
		hitCounts += 1;
	}
	//binding the object to this session
	application.setAttribute("hitsCounter",hitCounts);
	
%>
<p>Total number of visits to this website for user:<%= hitCounts %></p>
</body>
</html>