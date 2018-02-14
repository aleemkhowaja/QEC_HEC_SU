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

}

function testIntegerValues(e)
{
	if(e.which!=8 && e.which!=13)
		if(!/^[0-9]*$/.test($(e.target).val()+String.fromCharCode(e.which))){
			return false;
		}
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
