/**
 * 
 */
function citationThesis_returnCitationThesisPage()
{
	var responseData = null;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	url='thesis.htm';
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);
		},
		async:false,
		success : function(response) 
		{
			responseData = response;
		}
	});
	return responseData;
}
/*$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	url='journal.htm';
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);
		},
		async:false,
		success : function(response) {
			("#journalTab").html( response );
		}
	});
});*/