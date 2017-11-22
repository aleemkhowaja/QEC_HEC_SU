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
			url ='/QEC_HEC_SU/employee/save.htm';
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
		department_Remove_DeleteButton();
	}