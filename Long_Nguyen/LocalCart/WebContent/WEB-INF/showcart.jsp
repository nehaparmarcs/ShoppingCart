<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.12.3.min.js" />"></script>

<script type="text/javascript">
function RemoveItem(id) {
	alert(id);
	alert("in javascript RemoveItem: " + id);
	$.ajax({ 
	    url: "/removeItem", 
	    type: 'POST', 
	    dataType: 'json', 
	    data: "{\"id\": \"" + id + "\"}",
	    contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(data) { 
	        alert("success");
	    },
	    error:function(data,status,er) { 
	        alert("er:"+er);
	    }
	});
	
}
</script>
</head>
<body>
	<table>
		<c:forEach items="${cart.itemList}" var="item">
			<tr>
				<td>
					<button type="button" class="removebutton"
						onclick="RemoveItem(${item.id})">Delete</button>
				</td>
				<td>${item.toString()}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>