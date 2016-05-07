<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addToCart(userid, id, name, desc, itemPrice, quantity, imgPath) {
		$(document).ready(function() {
			$("#cartCount").html("");
		});
		$.ajax({
			url : "addItemtoCart",
			type : 'POST',
			contentType : 'application/json',
			data : "{\"userid\": \"" + userid + "\"" + ",\"id\": \"" + id
					+ "\"" + ",\"name\": \"" + name + "\"" + ",\"desc\": \""
					+ desc + "\"" + ",\"itemPrice\":" + itemPrice
					+ ",\"quantity\":" + quantity + ",\"imgPath\": \""
					+ imgPath + "\"" + "}",
			success : function(data) {
				$(document).ready(function() {
					$("#cartCount").html(data);
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

<form action="login1" method="post">
<c:set var="item" value="${detailItem}" />
<!--  
${item.imgPath}
${item.desc}
${item.itemPrice}
${item.quantity} [end]-->



</form>
<div class="container">
	<div id="addMsg"></div>
	
		<div class="row marginTop">
		
		<!-- temp
		
		
		
		
		
		
		 -->
		
			<div class="col-md-6 marginTop">
				<h2 class="center"> <span class="glyphicon glyphicon-fire"></span>${item.desc}</h2>
				<img src="${item.imgPath}" />
				<p class="center bold"></p>
				
				
			</div>
		<!--	<div class="row marginTop"> -->
				<div class="col-md-4 marginTop">
						<h1>${item.name}</h1>

					<p>${item.desc}</p>	
					<h3>List Price:</h3><h3> ${item.itemPrice}</h3>
					<h3>Quantity</h3><h3>${item.quantity}</h3>
					
					                               
                               
                                                	<button type="button" class="btn btn-lg btn-success btn-block"
		onclick="addToCart('mark', '${item.itemID}','${item.name}' , '${item.desc}', '${item.itemPrice}', 1, '${item.imgPath}')">Add
		to Cart</button>
                                    
		
					<!--  <p><a href="addItem2" class="btn btn-success" role="button"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a> </p> -->
				</div>
				
		<!-- </div> -->
			
		
		</div>
		
	</div>

</body>
</html>