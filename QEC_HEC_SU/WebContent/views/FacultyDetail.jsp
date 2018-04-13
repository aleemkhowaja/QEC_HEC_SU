<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveFaculty" value="/faculty/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Faculty</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveFaculty}" cssClass="m-t-md ajax-form-login validate-form" method="post" 
                	commandName="facultyData" id="faculty_form" resolveContext="true" resolveMapping="true">
                    <div class="form-group">
                    	<form:label path="facultyName" >Faculty Name : </form:label>
    					<form:input path="facultyName" cssClass="form-control validate-required" id="faculty_facultyName" placeholder="Faculty Name"  />                		
				    </div>
                    <button id="faculty-save-btn" type="submit" class="btn" onclick="return faculty_crud(event);">Save</button>
                    <!-- Hidden fields -->
                    <form:hidden path="facultyId" id="faculty_facultyId" />        
				</form:form>
			</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
