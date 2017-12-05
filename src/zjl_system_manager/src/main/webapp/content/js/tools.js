
function toolBar(toolBarId, result) {
	var html = [];
	result.forEach(function(obj) {
		html.push("<button type='button' class='"+obj.style+"' onclick='"+obj.buttonMethod+"'");
		html.push(">");
		html.push(" <i class='"+obj.icon+"' aria-hidden='true'></i>");
		html.push(obj.buttonName);
		html.push("</button>");
	});
	$('#' + toolBarId).html(html.join(''))
}