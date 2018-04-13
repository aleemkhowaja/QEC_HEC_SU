<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCitationPatent" value="/qec/patent/save.htm" ></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Patent</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveCitationPatent}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="patent" id="citationPatent_form" resolveContext="true" resolveMapping="true">
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="citationPatent_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 		</form:select>
	               </div>
	                   
	               <div class="form-group">
	               		<form:label path="title" > Title * </form:label>
						<form:input path="title" cssClass="form-control validate-required" id="citationPatent_title" placeholder="Title"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="url" > Url * </form:label>
						<form:input path="url" cssClass="form-control validate-required" id="citationPatent_url" placeholder="Url"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="inventors" > Inventors * </form:label>
						<form:input path="inventors" cssClass="form-control validate-required" id="citationPatent_inventors" placeholder="Inventors"  />
						<p> Multiple author add by comma separated. </p>
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="publicationDate" > Publication Date * </form:label>
						<form:input path="publicationDate" cssClass="form-control validate-required" id="citationPatent_publication_date" placeholder="Publication Date"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="patentOffice" > Patent Office * </form:label>
						<form:input path="patentOffice" cssClass="form-control validate-required" id="citationPatent_patentOffice" placeholder="Patent Office"  />
	               </div>
	               
	               <div class="form-group">
	                  	<form:label path="patentNumber" > Patent Number * </form:label>
						<form:input path="patentNumber" cssClass="form-control validate-required" id="citationPatent_patentNumber" placeholder="Patent Number"  />
	               </div>
	               
	               <div class="form-group">
	                  	<form:label path="applicationNumber" > Application Number * </form:label>
						<form:input path="applicationNumber" cssClass="form-control validate-required" id="citationPatent_applicationNumber" placeholder="Application Number"  />
	               </div>
	                    	                    
	               <div class="form-group">
	                   	<form:label 	path="description" > Description * </form:label>
						<form:textarea 	path="description" cssClass="form-control validate-required" id="citationPatent_description" placeholder="Description"  />
	               </div>
	                    
                   <button id="citationPatent-save-btn" type="submit" class="btn" onclick="return citationPatent_Crud(event);" >Save</button>
                   
                   <!-- Hidden fields -->
                   <form:hidden path="citationPatentId" id="citationPatent_citationPatentId" />
                   <form:hidden path="isDeleted" id="citationPatent_isDeleted" /> 
				</form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
