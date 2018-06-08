<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployeeTraining" value="/qec/employeeTraining/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Employee Training</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveEmployeeTraining}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="employeeTraining" id="employeeTraining_form" resolveContext="true" resolveMapping="true">
                	
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="employeeTraining_employeeId" >
				 			<form:option value="" label="---Select Employee ---"></form:option>
				 			<form:options items="${employeeList}" itemValue="employeeId" itemLabel="fullName" />
				 		</form:select>
					</div>
	                
	                <div class="form-group">
						<form:label path="dateof" > Date : </form:label>
						<form:input path="dateof" cssClass="form-control validate-required datetimepicker" id="employeeTraining_dateof" placeholder="Date"  />
					</div> 
					    
					    
	                <div class="form-group">
	                	<form:label  path="name" > Event Name * </form:label>
						<form:input path="name" cssClass="form-control validate-required" id="employeeTraining_eventName" placeholder="Event Name"  />
	               	</div>
	               	
	               	<div class="form-group">
	               		<form:radiobutton path="trainingCondition" value="Attended" />  Attended
	                	<form:radiobutton path="trainingCondition" value="Organized" /> Organized
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:radiobutton path="locality" value="HEC" /> HEC
	                	<form:radiobutton path="locality" value="National" />  National
	                	<form:radiobutton path="locality" value="International" /> Inter-National
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="instituteName" > Institution Name * </form:label>
						<form:input path="instituteName" cssClass="form-control validate-required" id="employeeTraining_institutionName" placeholder="Institution Name"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<label for="employeeTraining_file"> Evidence File/Document * </label>
						<input type="file" id="employeeTraining_file" name="employeeTraining_file" multiple="multiple"/>
	               	</div>
	               	               	
                    <button id="employeeTraining-save-btn" type="submit" class="btn" onclick="return employeeTraining_Crud(event);">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="employeeTrainingsId" id="employeeTraining_employeeTrainingId" />        
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	var date_input=$('input[name="dateof"]'); //our date input has the name "dateof"
	
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
		dateFormat: "yy-mm-dd",
		container: container,
		todayHighlight: true,
		autoclose: true,
		orientation : "bottom right"
	})
})
</script>
