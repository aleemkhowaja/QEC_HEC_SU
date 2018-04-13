<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCitationJournal" value="/qec/journal/save.htm"></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Journal</h2>
			<!-- Start Search Fields -->
			
				<div class="col-md-8">
                    <form:form servletRelativeAction="${saveCitationJournal}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="journal" id="citationJournal_form" resolveContext="true" resolveMapping="true">
                   					    
	                    <div  class="form-group">
	                   		<form:label path="employeeId" > Select Employee * </form:label>
  	 			       		<form:select path="employeeId" cssClass="form-control validate-required" id="citationJournal_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 			</form:select>
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="title" > Title * </form:label>
							<form:input path="title" cssClass="form-control validate-required" id="citationJournal_title" placeholder="Title"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="url" > Url * </form:label>
							<form:input path="url" cssClass="form-control validate-required" id="citationJournal_url" placeholder="Url"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="authors" > Authors * </form:label>
							<form:input path="authors" cssClass="form-control validate-required" id="citationJournal_author" placeholder="Authors"  />
							<p> Multiple author add by comma separated. </p>
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="publicationDate" > Publication Date * </form:label>
							<form:input path="publicationDate" cssClass="form-control validate-required" id="citationJournal_publication_date" placeholder="Publication Date"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="journal" > Journal * </form:label>
							<form:input path="journal" cssClass="form-control validate-required" id="citationJournal_journal" placeholder="Journal"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="volume" > Volume * </form:label>
							<form:input path="volume" cssClass="form-control validate-required validate-integer-value" id="citationJournal_volume" placeholder="Volume" maxlength="10" />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="issue" > Issue * </form:label>
							<form:input path="issue" cssClass="form-control validate-required validate-integer-value" id="citationJournal_issue" placeholder="Issue" maxlength="10"  />
	                    </div>
	                    
	                     <div class="form-group">
	                    	<form:label path="pages" > Pages * </form:label>
							<form:input path="pages" cssClass="form-control validate-required" id="citationJournal_pages" placeholder="Pages"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label path="publisher" > Publisher * </form:label>
							<form:input path="publisher" cssClass="form-control validate-required" id="citationJournal_publisher" placeholder="Publisher"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label 	path="description" > Description * </form:label>
							<form:textarea 	path="description" cssClass="form-control validate-required" id="citationJournal_description" placeholder="Description"  />
	                    </div>
	                    
	                  	<div class="form-group">
	                    	<form:label 	path="impactFactor" > Impact Factor : </form:label>
							<form:select 	path="impactFactor" cssClass="form-control validate-required"  id="citationJournal_impactFactor">
					 			<form:option	value="" label="Select Impact Factor" />
					 			<form:options  	items="${impactFactorList}" />
				 			</form:select>
	                    </div> 
	                    
	                    <div class="form-group">
	                    	<form:label 	path="impactFactorValue" > Impact Factor Value * </form:label>
							<form:input path="impactFactorValue" cssClass="form-control validate-required validate-float-value" id="citationJournal_impactFactorValue" placeholder="Volume"  />
	                    </div>
	                    
	                    <div class="form-group">
	                    	<form:label 	path="hecRecognize" > Hec Recognize : </form:label>
							<form:select 	path="hecRecognize" cssClass="form-control validate-required"  id="citationJournal_hecRecognize">
					 			<form:option	value="" label="Select Hec Recognize" />
					 			<form:options  	items="${hecRecognizeList}" />
				 			</form:select>
	                    </div> 
	                                        
                        <button id="citationJournal-save-btn" type="submit" class="btn" onclick="return citationJournal_Crud(event);" >Save</button>
                        <!-- Hidden fields -->
                         <form:hidden path="citationJournalId" id="citationJournal_citationJournalId" />
                        <form:hidden  path="isDeleted" id="citationJournal_isDeleted" /> 
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
