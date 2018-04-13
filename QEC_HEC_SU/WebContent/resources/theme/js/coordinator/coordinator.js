/**
 * Submit Form while Save/Update
 */
function coordinator_Crud(event)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	var flag = validateForm();
	if(flag)
	{	
		url ='/QEC_HEC_SU/qec/coordinator/save.htm';
		var usersData = {};
		usersData['departmentId'] = $("#users_departmentId").val();
		usersData['userId'] = $("#users_userId").val();
		usersData['username'] = $("#users_username").val();
		usersData['fullName'] = $("#users_fullName").val();
		usersData['email'] = $("#users_Email").val();
		usersData['password'] = $("#users_password").val();
		if(($("#users_status").val() != undefined) && ($("#users_status").val() != ""))
		{
			usersData['isActive'] = $("#users_status").val() == 0 ? false : 1;
		}
		usersData['employeeId'] = $("#users_employee").val();
		usersData['campusesId'] = $("#users_campusId").val();
		usersData['isDeleted'] = 0;
		usersData['oldUsername'] = $("#users_oldUsername").val();
		
		
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(usersData),
			
	         beforeSend: function(xhr) 
	         {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) 
			 {
				if(data != undefined)
				{
					jQuery("#users-detail-grid-list").trigger("reloadGrid");
					if(data == "Duplicate")
					{
						toaster_error("Username Already Exist");
					}
					else
					{
						toaster_success(data);
						users_Clear_FromData();
					}
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
 * get record and set data in form while double click on Grid Row
 * @param rowId
 */
function coordinator_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/qec/coordinator/returnCoordinatorById';
	var rowData = jQuery("#users-detail-grid-list").getRowData(rowId); 
	var userId = rowData['userId'];
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{userId : userId},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			 users_Set_FormData(data);
			 var myElem = document.getElementById('users-delete-btn');
				if (myElem == null)
				{
					$("#users-save-btn").after("<input type='button' id='users-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='users_DeleteUsers() ;'/>");
				}
		 }
	});
}

/**
 * Set Form Data while get record from db
 * @param data
 */
function users_Set_FormData(data)
{
	$("#users_departmentId").val(data.departmentId);
	$("#users_userId").val(data.userId)
	$("#users_username").val(data.username)
	$("#users_oldUsername").val(data.username)
	$("#users_fullName").val(data.fullName)
	$("#users_Email").val(data.email)
	$("#users_password").val(data.password)
	$("#users_status").val(data.isActive == 'true' ? 1 : 0);
	$("#users_employee").val(data.employeeId);
	$("#users_campusId").val(data.campusesId);
	pageAniamateScroll();
}

/**
 * Clear form after save/Update/Delete 
 */
function users_Clear_FromData()
{
	$("#users_departmentId").val("");
	$("#users_userId").val("");
	$("#users_username").val("");
	$("#users_fullName").val("");
	$("#users_Email").val("");
	$("#users_password").val("");
	$("#users_status").val("");
	$("#users_employee").val("");
	$("#users_campusId").val("");
	$("#users_oldUsername").val("")
	users_Remove_DeleteButton();
}

/**
 * Remove Delete Button After Delete the Record 
 */
function users_Remove_DeleteButton() 
{
    var elem = document.getElementById('users-delete-btn');
    elem.parentNode.removeChild(elem);
    return false;
}

/**
 * Delete Record from db while click on Delete Button
 */
function users_DeleteUsers() 
{
	
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/coordinator/deleteCoordinatorById';
		var usersData = {};
		usersData['userId'] = $("#users_userId").val();
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(usersData),
			 beforeSend: function(xhr) {
	        	 xhr.setRequestHeader(header, token);
	         },
	         /*beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	         },*/
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					
					jQuery("#users-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					users_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	//event.preventDefault();
}
