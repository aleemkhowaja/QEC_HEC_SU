/**
 * remove child elements of html
 */

function remove_child_Elements(id) 
{
    var elem = document.getElementById(id);
    if(elem != null)
    {
    	elem.parentNode.removeChild(elem);
        return false;
    }
}

function validateFloatValues()
{
	$(".validate-float-value").keypress(function (event) {
		$(this).val($(this).val().replace(/[^0-9\.]/g,''));
        if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
            event.preventDefault();
        }
    });
	checkIfPasteCorrectData('validate-float-value');
}


function validateIntegerValues()
{
	$(".validate-integer-value").keypress(function (e) {	
		if(navigator.userAgent.indexOf("Firefox") != -1 ) {			
			var eventASCII = e.keyCode;
			if(!(eventASCII==9 || (eventASCII >= 35 && eventASCII <= 40) || eventASCII == 46 ))
				return testIntegerValues(e);
			}else{
			return testIntegerValues(e);
			}
	});
	checkIfPasteCorrectData('validate-integer-value');
}

function testIntegerValues(e)
{
	if(e.which!=8 && e.which!=13)
		if(!/^[0-9]*$/.test($(e.target).val()+String.fromCharCode(e.which))){
			return false;
		}
}

function checkIfPasteCorrectData(className)
{
	$("."+className).on("paste", function(e) {
	    var that = this;
	    that.style.color = "#fff";
	    setTimeout(function() {
	        that.value = that.value.replace(/\D/g, "");
	        that.style.color = "#000";
	    }, 100);
	});
}


function validateGenericAllRegex1()
{
	var flag=true;
	$(".validate-form .validate-required-error").remove();
	$(".validate-regex").each(function(i)
	{
		if($(this).val()!="")
		{
			if(!testRegexString($(this).attr("regex"), $(this).val()))
			{
				$(this).closest("div").before($("#validate-regex-error").clone());
				var $validateRequiredError = $(this).closest("div").prev() ;
				$validateRequiredError.removeAttr("id");
				$validateRequiredError.attr("class","validate-regex-error non-readonly msgerror");

				var $validateRequiredMessage = $(this).attr("validate-regex-message");
				if($validateRequiredMessage != undefined)
				{			
					//var $defaultErrorMessage = $validateRequiredError.find(".msgerror");
					$validateRequiredError.html($validateRequiredMessage);
				}		
				if(flag)
				{
					flag=false;
				}
			}
		}
	});
}

function returnPage(url, event)
{
	var responseData = null;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			$(".page-inner").load("../common/loader.jsp");
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);
		},
		async:true,
		success : function(response) 
		{
			$(".page-inner").html(response);
			validateIntegerValues();
			validateFloatValues();
//			responseData = response;
		}
	});
	//return responseData;
}

function pageAniamateScroll(){
	$('body,html').animate({ scrollTop: 400}, 800);
}
