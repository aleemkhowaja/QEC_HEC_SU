/**
 * 
 */
function citationJournal_returnCitationJournalPage()
{
	var responseData = null;
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
		success : function(response) 
		{
			responseData = response;
		}
	});
	return responseData;
}

/**
 * Submit Form while Save/Update
 */
	function citationJournal_Crud()
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/journal/save.htm';
			var citationJournalData = {}
			var $inputs = $('#citationJournal_form :input');
			$('#citationJournal_form input, #citationJournal_form select #citationJournal_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					citationJournalData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}
				// For debugging purposes...
			   // alert($(this).attr('name') + ': ' + $(this).attr('id'));
			   // ids[$(this).attr('name')] = $(this).attr('id');
			});
			
			
			//citationJournalData =  $("#citationJournal_form").serializeForm();
			/*var citationJournalData = {};
			citationJournalData['employeeId'] = $("#users_employeeId").val();
			citationJournalData['title'] = $("#journal_title").val();*/
			
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(citationJournalData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#journal-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citaionJournal_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
		event.preventDefault();
		return true;
	}