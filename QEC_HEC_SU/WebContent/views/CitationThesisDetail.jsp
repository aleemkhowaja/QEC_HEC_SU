<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCitationThesis" value="/qec/thesis/save.htm" ></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Thesis</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveCitationThesis}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="thesis" id="citationThesis_form" resolveContext="true" resolveMapping="true">
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="citationThesis_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 		</form:select>
	               </div>
	                   
	               <div class="form-group">
	               		<form:label path="title" > Title * </form:label>
						<form:input path="title" cssClass="form-control validate-required" id="citationThesis_title" placeholder="Title"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="url" > Url * </form:label>
						<form:input path="url" cssClass="form-control validate-required" id="citationThesis_url" placeholder="Url"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="authors" > Authors * </form:label>
						<form:input path="authors" cssClass="form-control validate-required" id="citationThesis_author" placeholder="Authors"  />
						<p> Multiple author add by comma separated. </p>
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="publicationDate" > Publication Date * </form:label>
						<form:input path="publicationDate" cssClass="form-control validate-required" id="citationThesis_publication_date" placeholder="Publication Date"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="institution" > Institution * </form:label>
						<form:input path="institution" cssClass="form-control validate-required" id="citationThesis_institution" placeholder="Institution"  />
	               </div>
	                    	                    
	               <div class="form-group">
	                   	<form:label 	path="description" > Description * </form:label>
						<form:textarea 	path="description" cssClass="form-control validate-required" id="citationThesis_description" placeholder="Description"  />
	               </div>
	                    
                   <button id="citationThesis-save-btn" type="submit" class="btn" onclick="return citationThesis_Crud();" >Save</button>
                   
                   <!-- Hidden fields -->
                   <form:hidden path="citationThesisId" id="citationThesis_citationThesisId" />
                   <form:hidden path="isDeleted" id="citationThesis_isDeleted" /> 
				</form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
