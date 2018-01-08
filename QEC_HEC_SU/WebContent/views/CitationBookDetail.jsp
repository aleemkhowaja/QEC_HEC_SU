<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- start controller urls -->
<c:url var="saveCoordinator" value="/coordinator/save.htm" ></c:url>
<!-- end controller urls -->

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Book</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveCoordinator}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="book" id="book_form" resolveContext="true" resolveMapping="true">
                	<div  class="form-group">
	                	<form:label path="employeeId" > Select Employee * </form:label>
  	 			       	<form:select path="employeeId" cssClass="form-control validate-required" id="book_employeeId" items="${employeeList}" itemValue="employeeId" itemLabel="fullName">
				 		</form:select>
	               </div>
	                   
	               <div class="form-group">
	               		<form:label path="title" > Title * </form:label>
						<form:input path="title" cssClass="form-control validate-required" id="book_title" placeholder="Title"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="url" > Url * </form:label>
						<form:input path="url" cssClass="form-control validate-required" id="book_url" placeholder="Url"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="authors" > Authors * </form:label>
						<form:input path="authors" cssClass="form-control validate-required" id="book_author" placeholder="Authors"  />
						<p> Multiple author add by comma separated. </p>
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="publicationDate" > Publication Date * </form:label>
						<form:input path="publicationDate" cssClass="form-control validate-required" id="book_publication_date" placeholder="Publication Date"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="volume" > Volume * </form:label>
						<form:input path="volume" cssClass="form-control validate-required" id="book_volume" placeholder="Volume"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="issue" > Issue * </form:label>
						<form:input path="issue" cssClass="form-control validate-required" id="book_issue" placeholder="Issue"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label path="pages" > Pages * </form:label>
						<form:input path="pages" cssClass="form-control validate-required" id="book_pages" placeholder="Pages"  />
	               </div>
	                    
	               <div class="form-group">
	                  	<form:label path="publisher" > Publisher * </form:label>
						<form:input path="publisher" cssClass="form-control validate-required" id="book_publisher" placeholder="Publisher"  />
	               </div>
	                    
	               <div class="form-group">
	                   	<form:label 	path="description" > Description * </form:label>
						<form:textarea 	path="description" cssClass="form-control validate-required" id="book_description" placeholder="Description"  />
	               </div>
	                    
                   <button id="users-save-btn" type="submit" class="btn" onclick="return coordinator_Crud();" >Save</button>
                   
                   <!-- Hidden fields -->
                   <form:hidden path="citationBookId" id="book_citationBookId" />
                   <form:hidden path="isDeleted" id="book_isDeleted" /> 
				</form:form>
        	</div>
		</div>
        <div id="pager"></div>
	</div>
</div>
