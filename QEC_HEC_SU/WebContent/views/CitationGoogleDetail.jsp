<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCitationGoogle" value="/qec/google/save.htm" ></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Google</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveCoordinator}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="google" id="citationGoogle_form" resolveContext="true" resolveMapping="true">
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="google_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 		</form:select>
	               </div>
                    
	               <div class="form-group">
	                   	<form:label path="url" > Url * </form:label>
						<form:input path="url" cssClass="form-control validate-required" id="google_url" placeholder="Url" onchange="citationGoogle_loadGoogle();" />
	               </div>
	               
	               <div class="form-group" id="google_content">
	               
	               </div>
	                    
                   <button id="citationGoogle-save-btn" type="submit" class="btn" onclick="return citationGoogle_Crud(event);" >Save</button>
                   
                   <!-- Hidden fields -->
                   <form:hidden path="citationGoogleId" id="citationGoogle_citationGoogleId" />
                   <form:hidden path="isDeleted" id="google_isDeleted" /> 
				</form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
