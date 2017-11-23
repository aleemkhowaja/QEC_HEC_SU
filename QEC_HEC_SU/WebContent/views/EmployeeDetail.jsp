<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployee" value="/qec/employee/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Employee</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveEmployee}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="employee" id="employee_form" resolveContext="true" resolveMapping="true">
                	
                	<div class="form-group">
                    	<form:label path="title" >Title * </form:label>
                    	<form:select path="title" cssClass="form-control validate-required" id="employee_title" items="${employeeTitleList}" >
                    	</form:select>
					</div>
	                
	                <div class="form-group">
	                	<form:label  path="fullName" > Full Name * </form:label>
						<form:input path="fullName" cssClass="form-control validate-required" id="employee_fullName" placeholder="Full Name"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="surname" > Surname  </form:label>
						<form:input path="surname" cssClass="form-control validate-required" id="employee_surname" placeholder="Surname"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="fatherName" > Father Name * </form:label>
						<form:input path="fatherName" cssClass="form-control validate-required" id="employee_fatherName" placeholder="Father Name"  />
	               	</div>
	               	
	               	<div class="form-group">
                    	<form:label path="gender" >Gender * </form:label>
                    	<form:select path="gender" cssClass="form-control validate-required" id="employee_gender" items="${genderList}" >
                    	</form:select>
					</div>
					
					<div class="form-group">
	                	<form:label  path="email" >Email * </form:label>
						<form:input path="email" cssClass="form-control validate-required" id="employee_email" placeholder="Email"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="maritalStatus" >Marital status * </form:label>
						<form:select path="maritalStatus" cssClass="form-control validate-required" id="employee_maritalStatus" items="${maritalStatusList}" >
						</form:select>
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="dob" >Date of Birth * </form:label>
						<form:input path="dob" cssClass="form-control" id="employee_date validate-required" placeholder="Date"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="postalAddress" >Postal Address * </form:label>
						<form:textarea path="postalAddress" cssClass="form-control validate-required" id="employee_postalAddress" placeholder="Postal Address"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="nic" >CNIC * </form:label>
						<form:input path="nic" cssClass="form-control" id="employee_nic validate-required" placeholder="CNIC"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="mobile" >Mobile No * </form:label>
						<form:input path="mobile" cssClass="form-control" id="employee_mobile validate-required" placeholder="Mobile No"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="phone" >Phone No * </form:label>
						<form:input path="phone" cssClass="form-control" id="employee_phone" placeholder="Phone No"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="religion" >Religion * </form:label>
						<form:select path="religion" cssClass="form-control validate-required" id="employee_religion" items="${religionList}" >
						</form:select>
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="departmentId" >Department * </form:label>
						<form:select path="departmentId" cssClass="form-control validate-required" id="employee_department" itemValue="departmentId" itemLabel="name" items="${departmentList}" >
						</form:select>
	               	</div>
	               	
                    <button id="employee-save-btn" type="submit" class="btn" onclick="return employee_crud();">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="employeeId" id="employee_employeeId" />        
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
