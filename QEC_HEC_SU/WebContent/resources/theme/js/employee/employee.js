/**
 *  Author Aleem
 */

	/**
	 * employee save/update
	 */
	function employee_crud()
	{
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/employee/save.htm';
			var employeeData = {};
			employeeData['title'] = $("#employee_title").val();
			employeeData['fullName'] = $("#employee_fullName").val();
			employeeData['surname'] = $("#employee_surname").val();
			employeeData['fatherName'] = $("#employee_fatherName").val();
			employeeData['gender'] = $("#employee_gender").val();
			employeeData['email'] = $("#employee_email").val();
			employeeData['maritalStatus'] = $("#employee_maritalStatus").val();
			employeeData['postalAddress'] = $("#employee_postalAddress").val();
			employeeData['nic'] = $("#employee_nic").val();
			employeeData['mobile'] = $("#employee_mobile").val();
			employeeData['phone'] = $("#employee_phone").val();
			employeeData['religion'] = $("#employee_religion").val();
			employeeData['departmentId'] = $("#employee_department").val();
			employeeData['employeeId'] = $("#employee_employeeId").val();
			employeeData['isDeleted'] = false;
			
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(employeeData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#employee-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						employee_Clear_FromData();
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
	 * Clear form after save/Update/Delete 
	 */
	function employee_Clear_FromData()
	{
		$("#employee_title").val("");
		$("#employee_fullName").val("");
		$("#employee_surname").val("");
		$("#employee_fatherName").val("");
		$("#employee_gender").val("");
		$("#employee_email").val("");
		$("#employee_maritalStatus").val("");
		$("#employee_postalAddress").val("");
		$("#employee_nic").val("");
		$("#employee_mobile").val("");
		$("#employee_phone").val("");
		$("#employee_religion").val("");
		$("#employee_department").val("");
		$("#employee_employeeId").val("");
		//remove Delete Button
		//remove_child_Elements('employee-delete-btn');
	}