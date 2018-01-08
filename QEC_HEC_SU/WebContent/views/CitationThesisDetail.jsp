<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCoordinator" value="/coordinator/save.htm" ></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Thesis</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveCoordinator}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="thesis" id="thesis_form" resolveContext="true" resolveMapping="true">
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="thesis_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 		</form:select>
	               </div>
	                   
	               <div class="form-group">
	               		<form:label path="title" > Title * </form:label>
						<form:input path="title" cssClass="form-control validate-required" id="thesis_title" placeholder="Title"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="url" > Url * </form:label>
						<form:input path="url" cssClass="form-control validate-required" id="thesis_url" placeholder="Url"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="authors" > Authors * </form:label>
						<form:input path="authors" cssClass="form-control validate-required" id="thesis_author" placeholder="Authors"  />
						<p> Multiple author add by comma separated. </p>
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="publicationDate" > Publication Date * </form:label>
						<form:input path="publicationDate" cssClass="form-control validate-required" id="thesis_publication_date" placeholder="Publication Date"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="institution" > Institution * </form:label>
						<form:input path="institution" cssClass="form-control validate-required" id="thesis_volume" placeholder="Institution"  />
	               </div>
	                    	                    
	               <div class="form-group">
	                   	<form:label 	path="description" > Description * </form:label>
						<form:textarea 	path="description" cssClass="form-control validate-required" id="thesis_description" placeholder="Description"  />
	               </div>
	                    
                   <button id="users-save-btn" type="submit" class="btn" onclick="return coordinator_Crud();" >Save</button>
                   
                   <!-- Hidden fields -->
                   <form:hidden path="citationThesisId" id="thesis_citationThesisId" />
                   <form:hidden path="isDeleted" id="thesis_isDeleted" /> 
				</form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
