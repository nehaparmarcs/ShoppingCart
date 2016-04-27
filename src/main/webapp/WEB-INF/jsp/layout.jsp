<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Shopping Cart Application</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <title><tiles:getAsString name="title"/></title>
  <style type="text/css">
        a.bg-primary{padding:15px 10px;}
        a.bg-primary:hover,a.bg-primary:focus{color:white;}
        .tagline{margin-bottom:100px;}
    </style> 
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12" id="header">
                <tiles:insertAttribute name="header" />
            </div>
        </div>
        <div class="row">
            <div id="body">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
            <div class="row">
            <div class="col-md-12" id="footer" style="margin-top:50px;border-top:1px solid gray">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>

    </div>
  </body>
</html>