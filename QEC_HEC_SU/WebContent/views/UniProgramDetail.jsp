<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveUniPrograms" value="/programs/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Program</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveUniPrograms}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="uniProgramsData" id="uniProgram_form" resolveContext="true" resolveMapping="true">
            	
            		<div class="form-group">
		                <form:label path="departmentsModel" > Select Department : </form:label>
	  	 			    <form:select path="departmentsModel" cssClass="form-control validate-required" id="uniPrograms_departmentId" items="${departmentsModelList}" itemValue="departmentId" itemLabel="name">
					 		<form:option  value="---Select Customer---" />
					 	</form:select>
	                </div>
	                
                	<div class="form-group">
                    	<form:label path="code" >Program Code : </form:label>
						<form:input path="code" cssClass="form-control validate-required" id="uniPrograms_code" placeholder="Programe Code"  />
					</div>
	                
	                <div class="form-group">
	                	<form:label path="name" > Program Name : </form:label>
						<form:input path="name" cssClass="form-control validate-required" id="uniPrograms_name" placeholder="Program Name"  />
	                </div>
                    <button id="uniPrograms-save-btn" type="submit" class="btn" >Save</button>
                       
                    <!-- Hidden fields -->
                    <form:hidden path="uniProgramsId" id="uniPrograms_uniProgramsId" />
                    <form:hidden path="departmentsModel" id="uniPrograms_departmentId" /> 
                </form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
 