<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployeeMphilPhdStudent" value="/qec/employeeMphilPhdStudents/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Employee Mphil/Phd Student</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveEmployeeMphilPhdStudent}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="employeeMphilPhdStudent" id="employeeMphilPhdStudent_form" resolveContext="true" resolveMapping="true">
                	
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Supervisor * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="employeeMphilPhdStudent_employeeId" >
				 			<form:option value="" label="---Select Employee ---"></form:option>
				 			<form:options items="${employeeList}" itemValue="employeeId" itemLabel="fullName" />
				 		</form:select>
					</div>
	                
	                <div class="form-group">
	                	<form:label  path="studentName" > Student Name * </form:label>
						<form:input  path="studentName" cssClass="form-control validate-required" id="employeeMphilPhdStudent_studentName" placeholder="Student Name"  />
	               	</div>
	               	
	               	<div class="form-group">
	                    <form:label path="dtype" > Degree : </form:label>
						<form:select path="dtype" cssClass="form-control validate-required"  id="employeeMphilPhdStudent_degreeType">
					 		<form:option value="" label="Select Degree Type" />
					 		<form:options  	items="${degreeTypeList}" />
				 		</form:select>
	                </div> 
	               	
	               	<div  class="form-group">
	                	<form:label path="departmentId" > Select Department * </form:label>
  	 			       	<form:select path="departmentId" cssClass="form-control validate-required" id="employeeMphilPhdStudent_departmentId" >
				 			<form:option value="" label="---Select Department ---"></form:option>
				 			<form:options items="${departmentList}" itemValue="departmentId" itemLabel="name" />
				 		</form:select>
					</div>
	                
	                <div class="form-group">
						<form:label path="startDate" > Start Date : </form:label>
						<form:input path="startDate" cssClass="form-control validate-required datetimepicker" id="employeeMphilPhdStudent_startDate" placeholder="Start Date"  />
					</div>
					
					<div class="form-group">
						<form:label path="registrationDate" > Registration Date : </form:label>
						<form:input path="registrationDate" cssClass="form-control validate-required datetimepicker" id="employeeMphilPhdStudent_registrationDate" placeholder="Registration Date"  />
					</div>
					    
					    
	                <div class="form-group">
	                	<form:label  path="studentId" > Student Id * </form:label>
						<form:input path="studentId" cssClass="form-control validate-required" id="employeeMphilPhdStudent_studentId" placeholder="Student Id"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<label for="employeeMphilPhdStudent_file"> Registration Evidence * </label>
						<input type="file" id="employeeMphilPhdStudent_file" name="employeeMphilPhdStudent_file" multiple="multiple"/>
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="approvedTopic" > Approved Topic * </form:label>
						<form:input path="approvedTopic" cssClass="form-control validate-required" id="employeeMphilPhdStudent_approvedTopic" placeholder="Approved Topic"  />
	               	</div>
	               	
                    <button id="employeeMphilPhdStudent-save-btn" type="submit" class="btn" onclick="return employeeMphilPhdStudent_Crud(event);">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="employeeMphilPhdStudentsId" id="employeeMphilPhdStudent_employeeMphilPhdStudentsId" />        
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	var startDate_input = $('input[name="startDate"]'); //our date input has the name "start date"
	var registrationDate_input = $('input[name="registrationDate"]'); //our date input has the name "registration date"
	
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	
		startDate_input.datepicker({
			dateFormat: "yy-mm-dd",
			container: container,
			todayHighlight: true,
			autoclose: true,
			orientation : "bottom right"
		})
		
		registrationDate_input.datepicker({
			dateFormat: "yy-mm-dd",
			container: container,
			todayHighlight: true,
			autoclose: true,
			orientation : "bottom right"
		})
})
</script>
