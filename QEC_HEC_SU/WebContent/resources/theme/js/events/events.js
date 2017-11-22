/**
 * Submit Form while Save/Update
 */
function event_Crud()
{
	var flag = validateForm();
	if(flag)
	{	
		url ='/QEC_HEC_SU/qec/events/save.htm';
		var eventsData = {};
		eventsData['departmentId'] = $("#events_departmentId").val();
		eventsData['eventsId'] =$("#events_eventsId").val() || null;
		eventsData['eventTitle'] =$("#events_eventTitle").val();
		eventsData['dateof'] =$("#events_dateof").val();
		eventsData['endDate'] = $("#events_endDate").val();
		eventsData['quota'] = $("#events_quota").val();
		eventsData['eventDetail'] = $("#events_eventDetail").val();
		 
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(eventsData),
			
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	         },
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					jQuery("#events-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					events_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	event.preventDefault();
	return flag;
}
	
/**
 *  get record and set data in form while double click on Grid Row
 * @param rowId
 * @returns
 */
function events_Db_Click(rowId)
{
	url ='/QEC_HEC_SU/qec/events/returnEventByEventId';
	var rowData = jQuery("#events-detail-grid-list").getRowData(rowId); 
	var eventsId = rowData['eventsId'];
	event.preventDefault();
	$.post(url, {
		eventsId : eventsId,
	}, function(data) {
		events_Set_FormData(data);
		var myElem = document.getElementById('events-delete-btn');
		if (myElem == null)
		{
			$("#events-save-btn").after("<input type='button' id='events-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='events_deleteEvents() ;'/>");
		}
		
	});
}

/**
 * Set Form Data while get record from db
 * @param data
 * @returns
 */
function events_Set_FormData(data)
{

	$("#events_departmentId").val(data.departmentId)
	$("#events_eventsId").val(data.eventsId)
	$("#events_eventTitle").val(data.eventTitle)
	$("#events_dateof").val(data.dateof)
	$("#events_quota").val(data.quota)
	$("#events_eventDetail").val(data.eventDetail);
	$("#events_endDate").val(data.endDate);
	
}

/**
 * Clear form after save/Update/Delete 
 * @returns
 */
function events_Clear_FromData()
{
	
	$("#events_departmentId").val("")
	$("#events_eventsId").val("")
	$("#events_eventTitle").val("")
	$("#events_dateof").val("")
	$("#events_quota").val("")
	$("#events_eventDetail").val("")
	$("#events_endDate").val("")
	events_Remove_DeleteButton();
}

/**
 * 
 * @returns
 */
function users_Remove_DeleteButton() 
{
    var elem = document.getElementById('events-delete-btn');
    elem.parentNode.removeChild(elem);
    return false;
}


function events_deleteEvents() 
{
	url ='/QEC_HEC_SU/events/deleteEventsById';
	var eventsData = {};
	eventsData['departmentId'] = $("#events_departmentId").val();
	eventsData['eventsId'] =$("#events_eventsId").val()|| null;
	eventsData['eventTitle'] =$("#events_eventTitle").val();
	eventsData['dateof'] =$("#events_dateof").val();
	eventsData['endDate'] = $("#events_endDate").val();
	eventsData['quota'] = $("#events_quota").val();
	eventsData['eventDetail'] = $("#events_eventDetail").val();
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 data: JSON.stringify(eventsData),
		 
         beforeSend: function(xhr) {
             xhr.setRequestHeader("Accept", "application/json");
             xhr.setRequestHeader("Content-Type", "application/json");
         },
		 async:false,
		 success : function(data) {
			if(data != undefined) {
				
				jQuery("#events-detail-grid-list").trigger("reloadGrid");
				toaster_success(data);
				events_Clear_FromData();
			}
			else {
				toaster_error(data);
			}
		}
	});
	//event.preventDefault();
}
