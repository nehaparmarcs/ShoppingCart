<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>

<script type="text/javascript">
function RemoveItem(userid, id) {
	$.ajax({ 
	    url: "/removeItem", 
	    type: 'POST', 
	    contentType: 'application/json',
	    data: "{\"userid\": \"" + userid + "\"" + ",\"id\": \"" + id + "\"}",
	    success: function(data) { 
	    	$(document).ready(function(){
	    		alert(data);
	    		$("#carttable").html(data);
	    	});
	    },
	    error:function(data,status,er) { 
	        alert("er:"+er);
	    }
	});
	
}

function UpdateItemQuantity(userid, id, sel) {
	var quantity = sel.value;  
	$.ajax({ 
	    url: "/updateItemQuantity", 
	    type: 'POST', 
	    contentType: 'application/json',
	    data: "{\"userid\": \"" + userid + "\"" + ",\"id\": \"" + id + "\"" + ",\"quantity\":" + quantity + "}",
	    success: function(data) { 
	    	document.open();
	        document.write(data);
	        document.close();
	    },
	    error:function(data,status,er) { 
	        alert("er:"+er);
	    }
	});
}

function CheckOut(userid) {  
	$.ajax({ 
	    url: "/checkOut", 
	    type: 'POST', 
	    contentType: 'application/json',
	    data: "{\"userid\": \"" + userid + "\"}",
	    success: function(data) { 
	    	document.open();
	        document.write(data);
	        document.close();
	    },
	    error:function(data,status,er) { 
	        alert("er:"+er);
	    }
	});
}
</script>
</head>
<body>
	<div id="carttable">
		<table>
			<c:forEach items="${cart.itemList}" var="item">
				<tr>
					<td>
						<button type="button" class="removebutton"
							onclick="RemoveItem('mark', ${item.id})">Delete</button>
					</td>
					<td>${item.name}</td>
					<td>${item.desc}</td>
					<td>${item.totalPrice}</td>
					<td><select name="quantity"
						onchange="UpdateItemQuantity('mark', ${item.id}, this)">
							<c:forEach var="num" items="${numberList}">
								<option value="${num}"
									${num == item.quantity ? 'selected="selected"' : ''}>${num}</option>
							</c:forEach>
					</select></td>

				</tr>
			</c:forEach>

		</table>
		<div>Total: ${cart.total}</div>

		<div>
			<button type="button" onClick="CheckOut('mark')"
				${cart.itemList.size() == 0 ? 'disabled' : ''}>Checkout</button>
		</div>

	</div>
</body>
</html>