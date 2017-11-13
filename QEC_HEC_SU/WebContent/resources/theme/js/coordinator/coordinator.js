/**
 * Submit Form while Save/Update
 */
/*$(document).on('submit', '#users_form', function(event) {*/
function coordinator_Crud()
{
	var flag = validateForm();
	if(flag)
	{	
		url ='/QEC_HEC_SU/coordinator/save.htm';
		var usersData = {};
		usersData['departmentId'] = $("#users_departmentId").val();
		usersData['userId'] = $("#users_userId").val();
		usersData['username'] = $("#users_username").val();
		usersData['fullName'] = $("#users_fullName").val();
		usersData['email'] = $("#users_Email").val();
		usersData['password'] = $("#users_password").val();
		usersData['accountStatus'] = $("#users_isActive").val();
		usersData['employeeId'] = $("#users_employeeId").val();
		usersData['campusesId'] = $("#users_campusId").val();
		usersData['isDeleted'] = 0;
		
		
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(usersData),
			
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	         },
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
	event.preventDefault();
	return flag;
}

/**
 * get record and set data in form while double click on Grid Row
 * @param rowId
 */
function coordinator_Db_Click(rowId)
{
	url ='/QEC_HEC_SU/coordinator/returnCoordinatorById';
	var rowData = jQuery("#users-detail-grid-list").getRowData(rowId); 
	var userId = rowData['userId'];
	event.preventDefault();
	$.post(url, {
		userId : userId,
	}, function(data) {
		users_Set_FormData(data);
		var myElem = document.getElementById('users-delete-btn');
		if (myElem == null)
		{
			$("#users-save-btn").after("<input type='button' id='users-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='users_DeleteUsers() ;'/>");
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
	$("#users_fullName").val(data.fullName)
	$("#users_Email").val(data.email)
	$("#users_password").val(data.password)
	$("#users_isActive").val(data.isActive);
	$("#users_employeeId").val(data.employeeId);
	$("#users_campusId").val(data.campusesId);
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
	$("#users_isActive").val("");
	$("#users_employeeId").val("");
	$("#users_campusId").val("");
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
	url ='/QEC_HEC_SU/coordinator/deleteCoordinatorById';
	var usersData = {};
	usersData['userId'] = $("#users_userId").val();
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 data: JSON.stringify(usersData),
		 
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
	//event.preventDefault();
}
