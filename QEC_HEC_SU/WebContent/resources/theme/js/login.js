/*//submit login form 
$(document).on('submit', 'form.ajax-form-login', function() {
	
	// Hide previously shown notify.js notifications - Trick (notify.js automatically hides notifications when clicked)
	//$(".notifyjs-wrapper").click();
	$.ajax({
		url : $(this).attr('action'),
		type : $(this).attr('method'),
		data : $(this).serialize(),
		success : function(data) {
			$(".loginBtn").attr("disabled","true");
			alert(data.url);
			if(data.status == true) {
				$("#body").load(data.url);
				//$.notify(data.message,{position: 'right bottom',className:"success"});
				//$("#loginmsg").html(data.message);
				//$("#logout-div").css("display", "block");
			}else if(data.status == false) {
				$(".loginBtn").removeAttr("disabled");
				//$.notify(data.message,{ position: 'right bottom',className:"error"} );
				//$("#loginmsg").html(data.message);			
			}
		}
	});
	return false;
});*/