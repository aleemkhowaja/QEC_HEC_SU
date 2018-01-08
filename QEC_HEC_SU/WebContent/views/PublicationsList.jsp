<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllDepartmentForGrid" value="/qec/department/returnAllDepartmentsForGrid/" ></c:url>
	<!-- ------------------------------------------------------ -->
	<jsp:include page="../common/header.jsp" />
	<script  src="<c:url value="/resources/theme/js/department/department.js" />" > </script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<jsp:include page="../common/menues.jsp" />
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Departments</h2>
							<!-- Start Search Fields -->
							<span> 
								<input class="smallinput" type="text" name="departmentName" id="departmentName" placeholder="Department Name" />
								<input type="button" value="Search" id="search-department-button" />
							</span>
					</div>
					
					<div id="tabs">
						<ul>
							<li><a href="#journalTab">Journal</a></li>
							<li><a href="#ConferenceTab">Conference</a></li>
							<li><a href="#ChapterTab">Chapter</a></li>
							<li><a href="#BookTab">Book</a></li>
							<li><a href="#ThesisTab">Thesis</a></li>
							<li><a href="#PatentTab">Patent</a></li>
							<li><a href="#GoogleTab">Google</a></li>
							<li><a href="#OtherTab">Other</a></li>
						</ul>
						<div id="journalTab">
						</div>
						<div id="conferenceTab">
						</div>
						<div id="chapterTab">
						</div>
						<div id="bookTab">
						</div>
						<div id="thesisTab">
						</div>
						<div id="patentTab">
						</div>
						<div id="googleTab">
						</div>
						<div id="otherTab">
						</div>
					</div>
        			<div id="pager"></div>
		        </div>
		   </div>
		   <script src="<c:url value="/resources/theme/js/publications/citationJournal.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationConference.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationChapter.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationBook.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationThesis.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationPatent.js" />"></script>
		   
			<script type="text/javascript">
				$(document).ready(function(){
					$("#tabs").tabs();
					var journalResponse = citationJournal_returnCitationJournalPage();
					var conferenceResponse = citationConference_returnCitationConferencePage();
					var chapterResponse = citationChapter_returnCitationChapterPage();
					var bookResponse = citationBook_returnCitationBookPage();
					var thesisResponse = citationThesis_returnCitationThesisPage();
					var patentResponse = citationPatent_returnCitationPatentPage();
					
					$("#journalTab").html(journalResponse);
					$("#conferenceTab").html(conferenceResponse);
					$("#chapterTab").html(chapterResponse);
					$("#bookTab").html(bookResponse);
					$("#thesisTab").html(thesisResponse);
					$("#patentTab").html(patentResponse);
				});
			</script>
    	</div><!-- Main Wrapper -->
    	<div class="page-footer">
        	<div class="container">
	            <div class="col-md-10">
	            <p class="no-s txt-white">2017 &copy; Quality Enhancement Cell, University of Sindh Jamshoro Pakistan | Developed by : <a href="http://gexton.com/" style="color:#fff;">Gexton</a></p>
	            </div>
	            <div class="col-md-2">
	                <a href="http://3melements.com/sindhuni/support" class="btn btn-danger">Support/ Bug Report</a>
	            </div>
       	 	</div>
    	</div>
	</body>
</html>
