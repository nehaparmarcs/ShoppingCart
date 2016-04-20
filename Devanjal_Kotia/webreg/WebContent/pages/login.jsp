<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping Cart</title>

    
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

   
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart loginjsp</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<%
String userid=request.getParameter("usr");
String pwd=request.getParameter("pwd"); 
Class.forName("com.mysql.jdbc.Driver");
System.out.println("user is "+userid );
System.out.println("password "+pwd );
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select * from users where user='"+userid+"'"); 
if(rs.next()) 
{ 
if(rs.getString(2).equals(pwd)) 
{ 
//out.println("welcome "+userid); 

} 
else 
{ 
out.println("Invalid password try again"); 
} 
} 
else 
%>

<div id="wrapper">

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Shopping Cart</a>
            </div>
            
            <ul class="nav navbar-top-links navbar-right">
               
                </li>
                
                   
                </li>
               
            </ul>
           >

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Home</a>
                        </li>
                       
                   
                        <li>
                            <a href="login.html"><i class="fa fa-dashboard fa-fw"></i> Login</a>
                        </li>
                     
                        <li>
                            <a href="Registration.html"><i class="fa fa-dashboard fa-fw"></i> Sign Up</a>
                        </li>
                </div>
                
            </div>
            
        </nav>

        
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">

    <%
    if(rs.next()) 
    { 
    if(rs.getString(2).equals(pwd)) 
    { 
    out.println("welcome "+userid); 

    } 
    else 
    { 
    out.println("Invalid password try again"); 
    } 
    } 
    else  

%>
                        </h1>
                        <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    
                     </div>
            </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>
</html>