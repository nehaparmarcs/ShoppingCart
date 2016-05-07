<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<style>.wraptocenter {
    display: table-cell;
    
    width: 80px;
    height: 50px;
    border: 5px solid gray;
  min-height:90px;
    
    margin: 4px solid white;
    float: left;
}
.wraptocenter img { max-width: 190px; max-height: 190px; }
.wraptoabc {
    display: table-cell;
    
    width: 300px;
    height: 100px;
    border: 8px solid white;
    
    margin: 2px;
    float: left;
    
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<section>
		<div class="jumbotron">
			<div class="container">
				<h2>Welcome to Shopping Cart Application</h2>
			</div>
		</div>
	</section>
	
<c:out value="Your Online shop"/><br>


 
		<c:forEach items="${items}" var="item">
		<!-- It will Link to details page on clicking item link -->
		<div class="wraptocenter">
			
				
				<a class="navbar-brand" href="details?itemID=${item.itemID}">
					<span class="pull-right inter_arrw"><img src="${item.imgPath}" alt="${item.desc}"/></span>
					</a>
				</div>
				
				<div class="wraptoabc">
			
			
				
					<p><span>${item.desc}</span></p>
				
			
					<span>Price: </span>
				
					<span >${item.itemPrice}</span><br>
				
			
				
					<span>Quantity:</span>
				
					<span>${item.quantity}</span>
				
			
		</div>
		
		</c:forEach>

</body>
</html>