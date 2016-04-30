<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<style>.wraptocenter {
    display: table-cell;
    
    width: 200px;
    height: 100px;
    border: 5px solid black;
    min-height:300px;
    min.width:300px;
    margin: 2px solid white;
    
}
.wraptocenter img { max-width: 190px; max-height: 190px; }
.wraptoabc {
    display: table-cell;
    
    width: 300px;
    height: 100px;
    border: 8px solid white;
    min-height:300px;
    min.width:300px;
    margin: 5px;
    
}</style>
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
			
				<td colspan="2">
				<a href="">
					<span class="pull-right inter_arrw"><img src="${item.imgPath}" alt="${item.desc}"/></span>
					</a>
				</td></div>
				
				<div class="wraptoabc">
			
			
				
					<p><span>${item.desc}</span></p>
				
			
					<span>Price: </span>
				
					<span >${item.itemPrice}</span><br>
				
			
				
					<span>Quantity</span>
				
					<span>${item.quantity}</span>
				
			
		</div>
		
		</c:forEach>

</body>
</html>