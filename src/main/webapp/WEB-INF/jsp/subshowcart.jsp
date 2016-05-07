<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


