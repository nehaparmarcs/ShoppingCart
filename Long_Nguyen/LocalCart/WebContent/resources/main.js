function RemoveItem(itemJson) {
	alert("in javascript RemoveItem: " + itemJson);
	$.ajax({ 
	    url: "/removeItem", 
	    type: 'POST', 
	    dataType: 'json', 
	    data: "" + itemJson,
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