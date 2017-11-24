/**
 * Submit Form while Save/Update
 */
	function department_crud()
	{
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/department/save.htm';
			var departmentData = {};
			departmentData['name'] = $("#department_departmentName").val();
			departmentData['detail'] = $("#department_description").val();
			departmentData['departmentId'] = $("#department_departmentId").val();
			departmentData['isDeleted'] = false;
			
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(departmentData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#department-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						department_Clear_FromData();
					}
					else {
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
function department_Db_Click(rowId)
{
	url ='/QEC_HEC_SU/department/getDepartmentById';
	var rowData = jQuery("#department-detail-grid-list").getRowData(rowId); 
	var departmentId = rowData['departmentId'];
	event.preventDefault();
	$.post(url, {
		departmentId : departmentId,
	}, function(data) {
		department_Set_FormData(data);
		
		var myElem = document.getElementById('department-delete-btn');
		if (myElem == null)
		{
			$("#department-save-btn").after("<input type='button' id='department-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='department_deleteDeaprtment();'/>");
		}
		
	});
}

/**
 * Delete Record from db while click on Delete Button
 */
function department_deleteDeaprtment() 
{
	url ='/QEC_HEC_SU/department/deleteDepartmentById';
	var departmentData = {};
	departmentData['name'] = $("#department_departmentName").val();
	departmentData['detail'] = $("#department_description").val();
	departmentData['departmentId'] = $("#department_departmentId").val();
	
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 data: JSON.stringify(departmentData),
		 async:false,
		 success : function(data) {
			if(data != undefined) {
				
				jQuery("#department-detail-grid-list").trigger("reloadGrid");
				toaster_success(data);
				department_Clear_FromData();
			}
			else {
				toaster_error(data);
			}
		}
	});
	//event.preventDefault();
}

/**
 * Set Form Data while get record from db
 * @param data
 */
function department_Set_FormData(data)
{
	$("#department_departmentId").val(data.departmentId);
	$("#department_departmentName").val(data.name);
	$("#department_description").val(data.detail);
}

/**
 * Clear form after save/Update/Delete 
 */
function department_Clear_FromData()
{
	$("#department_departmentId").val("");
	$("#department_departmentName").val("");
	$("#department_description").val("");
	//remove Delete Button
	remove_child_Elements('department-delete-btn');
}

