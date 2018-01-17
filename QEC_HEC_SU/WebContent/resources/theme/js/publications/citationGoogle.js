/**
 * 
 */

function citationGoogle_returnCitationGooglePage()
{
	var responseData = null;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	url='google.htm';
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

function citationGoogle_loadGoogle()
{
	var url = $("#google_url").val();
	
	var el=document.getElementById("google_content")
	el.innerHTML="<iframe src=\""+url+"\"></iframe>"
		
		
	//$("#google_content").load(url);
}