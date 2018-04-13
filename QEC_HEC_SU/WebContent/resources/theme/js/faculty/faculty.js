/**
 * Submit Form while Save/Update
 */
	function faculty_crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/faculty/save.htm';
			var facultyData = {};
			$('#faculty_form input, #faculty_form select, #faculty_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					facultyData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}
			});
			
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(facultyData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) 
					{
						jQuery("#faculty-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						faculty_Clear_FromData();
					}
					else 
					{
						toaster_error(data);
					}
				}
			});
			event.preventDefault();
		}
		return flag;
	}

/**
 * get record and set data in form while double click on Grid Row
 * @param rowId
 */
function faculty_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/faculty/getFacultyById';
	var rowData = jQuery("#faculty-detail-grid-list").getRowData(rowId); 
	var facultyId = rowData['facultyId'];
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{facultyId : facultyId},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			faculty_Set_FormData(data);
			var myElem = document.getElementById('faculty-delete-btn');
			if (myElem == null)
			{
				$("#faculty-save-btn").after("<input type='button' id='faculty-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='faculty_deleteDeaprtment();'/>");
			}
		 }
	});
	
/*	$.post(url,
	beforeSend: function(xhr) 
	{
		xhr.setRequestHeader(header, token);
	},
	{
		facultyId : facultyId,
	}
	 function(data) {
		faculty_Set_FormData(data);
		
		var myElem = document.getElementById('faculty-delete-btn');
		if (myElem == null)
		{
			$("#faculty-save-btn").after("<input type='button' id='faculty-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='faculty_deleteDeaprtment();'/>");
		}
		
	});*/
}

/**
 * Delete Record from db while click on Delete Button
 */
function faculty_deleteDeaprtment() 
{
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/faculty/deleteFacultyById';
		var facultyId = $("#faculty_facultyId").val();
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         data:{facultyId : facultyId},
			 async:false,
			 beforeSend: function(xhr) 
	         {
				 xhr.setRequestHeader(header, token);
	         },
			 success : function(data) {
				if(data != undefined) {
					
					jQuery("#faculty-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					faculty_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	//event.preventDefault();
}

/**
 * Set Form Data while get record from db
 * @param data
 */
function faculty_Set_FormData(data)
{
	$("#faculty_facultyId").val(data.facultyId);
	$("#faculty_facultyName").val(data.facultyName);
	pageAniamateScroll();
}

/**
 * Clear form after save/Update/Delete 
 */
function faculty_Clear_FromData()
{
	$("#faculty_facultyId").val("");
	$("#faculty_facultyName").val("");
	$("#faculty_description").val("");
	//remove Delete Button
	remove_child_Elements('faculty-delete-btn');
}

