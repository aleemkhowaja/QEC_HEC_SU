<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveDepartment" value="/department/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Department</h2>
			<!-- Start Search Fields -->
			
				<div class="col-md-8">
                    <form:form servletRelativeAction="${saveDepartment}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="departmentData"
                     id="department_form" resolveContext="true" resolveMapping="true">
                     
                     	<div class="form-group">
			                <form:label path="faculty" > Select Faculty : </form:label>
		  	 			    <form:select path="faculty" cssClass="form-control validate-required" id="department_facultyId" >
						 		<form:option  value=""  label="---Select Faculty ---" />
						 		<form:options items="${facultyModelList}" itemValue="facultyId" itemLabel="facultyName"  />
						 	</form:select>
	                	</div>
	                
                    	<div class="form-group">
                    		<form:label path="name" >Department Name : </form:label>
    						<form:input path="name" cssClass="form-control validate-required" id="department_departmentName" placeholder="Department Name"  />                		
	                   		
					    </div>
	                    <div class="form-group">
	                    	<form:label path="detail" > Description : </form:label>
							<form:textarea path="detail" cssClass="form-control" id="department_description" placeholder="Description"  />
	                    </div>
                       <button id="department-save-btn" type="submit" class="btn" onclick="return department_crud(event);">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="departmentId" id="department_departmentId" />        
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
