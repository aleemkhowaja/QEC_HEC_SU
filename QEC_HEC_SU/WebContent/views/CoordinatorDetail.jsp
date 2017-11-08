<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveUsers" value="/users/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add User</h2>
			<!-- Start Search Fields -->
			
				<div class="col-md-8">
                    <form:form servletRelativeAction="${saveUsers}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="userModel" id="users_form" resolveContext="true" resolveMapping="true">
                    	<div class="form-group">
                    		<form:label path="fullName" >Full Name * </form:label>
							<form:input path="fullName" cssClass="form-control validate-required" id="users_fullName" placeholder="Full Name"  />
					    </div>
					    <div class="form-group">
					    	<form:label path="departmentsModel" > Select Department : </form:label>
  	 			       		<form:select path="departmentsModel" cssClass="form-control" id="users_departmentId" items="${departmentsModelList}" itemValue="departmentId" itemLabel="name">
							</form:select>
					    </div>
	                     <%-- <div class="form-group">
	                    	<form:label path="campusesId" > Campuses : </form:label>
							<form:select path="campusesId" cssClass="form-control" id="users_campusId" items="${campusesModelsList}" itemValue="campusesId" itemLabel="name">
				 		</form:select>
				 		
	                    </div> --%>
	                    <div  class="form-group">
	                   <form:label path="employeeModel" > Select Employee * </form:label>
  	 			       <form:select path="employeeModel" cssClass="form-control validate-required" id="users_employeeId" items="${employeeModelsList}" itemValue="employeeId" itemLabel="fullName">
				 			
				 		</form:select>
	                    </div>
	                    <div class="form-group">
	                    	<form:label path="email" > Email * </form:label>
							<form:input path="email" cssClass="form-control validate-required" id="users_Email" placeholder="Email"  />
	                    </div>
	                     <div class="form-group">
	                    	<form:label path="username" > User Name * </form:label>
							<form:input path="username" cssClass="form-control validate-required" id="users_username" placeholder="User Name"  />
	                    </div>
	                     <div class="form-group">
	                    	<form:label path="password" > Password * </form:label>
							<form:input path="password" cssClass="form-control validate-required" id="users_password" placeholder="Password"  />
	                    </div>
	                  <div class="form-group">
	                    	<form:label path="isActive" id="users_isActive" > Account Status : </form:label>
							<form:select path="isActive" cssClass="form-control">
				 			<form:option value="0" label="Active" />
				 			<form:option value="1" label="In Active" />
				 		</form:select>
	                    </div> 
                        <button id="users-save-btn" type="submit" class="btn" onclick="return coordinator_crud();" >Save</button>
                        <!-- Hidden fields -->
                         <form:hidden path="userId" id="users_userId" />
<%--                         <form:hidden path="departmentsModel" id="users_departmentId" /> --%>
                        <form:hidden path="isActive" id="users_isActive" /> 
                        <form:hidden path="employeeModel" id="users_employeeId" />
                        <%-- <form:hidden path="campusId" id="users_campusId" />   --%>
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
