<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCitationConference" value="/qec/conference/save.htm"></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Conference</h2>
			<!-- Start Search Fields -->
			
				<div class="col-md-8">
                    <form:form servletRelativeAction="${saveCoordinator}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="conference" id="citationConference_form" resolveContext="true" resolveMapping="true">
                   					    
	                    <div  class="form-group">
	                   		<form:label path="employeeId" > Select Employee * </form:label>
  	 			       		<form:select path="employeeId" cssClass="form-control validate-required" id="citationConference_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 			</form:select>
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="title" > Title * </form:label>
							<form:input path="title" cssClass="form-control validate-required" id="citationConference_title" placeholder="Title"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="url" > Url * </form:label>
							<form:input path="url" cssClass="form-control validate-required" id="citationConference_url" placeholder="Url"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="authors" > Authors * </form:label>
							<form:input path="authors" cssClass="form-control validate-required" id="citationConference_author" placeholder="Authors"  />
							<p> Multiple author add by comma separated. </p>
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="publicationDate" > Publication Date * </form:label>
							<form:input path="publicationDate" cssClass="form-control validate-required" id="citationConference_publication_date" placeholder="Publication Date"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="conference" > Conference * </form:label>
							<form:input path="conference" cssClass="form-control validate-required" id="citationConference_conference" placeholder="Conference"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="volume" > Volume * </form:label>
							<form:input path="volume" cssClass="form-control validate-required" id="citationConference_volume" placeholder="Volume"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="issue" > Issue * </form:label>
							<form:input path="issue" cssClass="form-control validate-required" id="citationConference_issue" placeholder="Issue"  />
	                    </div>
	                    
	                     <div class="form-group">
	                    	<form:label path="pages" > Pages * </form:label>
							<form:input path="pages" cssClass="form-control validate-required" id="citationConference_pages" placeholder="Pages"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="publisher" > Publisher * </form:label>
							<form:input path="publisher" cssClass="form-control validate-required" id="citationConference_publisher" placeholder="Publisher"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label 	path="description" > Description * </form:label>
							<form:textarea 	path="description" cssClass="form-control validate-required" id="citationConference_description" placeholder="Description"  />
	                    </div>
	                    
	                  	<div class="form-group">
	                    	<form:label 	path="impactFactor" > Impact Factor : </form:label>
							<form:select 	path="impactFactor" cssClass="form-control validate-required"  id="citationConference_impactFactor">
					 			<form:option	value="" label="Select Impact Factor" />
					 			<form:options  	items="${impactFactorList}" />
				 			</form:select>
	                    </div> 
	                    <div class="form-group">
	                    	<form:label 	path="impactFactorValue" > Impact Factor Value * </form:label>
							<form:textarea 	path="impactFactorValue" cssClass="form-control validate-required" id="citationConference_impactFactorValue" placeholder="Ratio"  />
	                    </div>
	                    <div class="form-group">
	                    	<form:label 	path="hecRecognize" > Hec Recognize : </form:label>
							<form:select 	path="hecRecognize" cssClass="form-control validate-required"  id="citationConference_hecRecognize">
					 			<form:option	value="" label="Select Hec Recognize" />
					 			<form:options  	items="${hecRecognizeList}" />
				 			</form:select>
	                    </div> 
	                                        
                        <button id="citationConference-save-btn" type="submit" class="btn" onclick="return citationConference_Crud();" >Save</button>
                        <!-- Hidden fields -->
                         <form:hidden path="citationConferenceId" id="citationConference_citationConferenceId" />
                        <form:hidden path="isDeleted" id="citationConference_isDeleted" /> 
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
