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
	<%-- <jsp:include page="../common/header.jsp" /> --%>
	<script  src="<c:url value="/resources/theme/js/department/department.js" />" > </script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Publications</h2>
							<!-- Start Search Fields -->
							<!-- <span> 
								<input class="smallinput" type="text" name="departmentName" id="departmentName" placeholder="Department Name" />
								<input type="button" value="Search" id="search-department-button" />
							</span> -->
					</div>
					
					<div id="tabs">
						<ul>
							<li><a onclick="publication_tabOpen('journal');" href="#journalTab">Journal</a></li>
							<li><a onclick="publication_tabOpen('conference');" href="#ConferenceTab">Conference</a></li>
							<li><a onclick="publication_tabOpen('chapter');" href="#ChapterTab">Chapter</a></li>
							<li><a onclick="publication_tabOpen('book');"  href="#BookTab">Book</a></li>
							<li><a onclick="publication_tabOpen('thesis');" href="#ThesisTab">Thesis</a></li>
							<li><a onclick="publication_tabOpen('patent');" href="#PatentTab">Patent</a></li>
							<li><a onclick="publication_tabOpen('google');" href="#GoogleTab">Google</a></li>
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

		   <script src="<c:url value="/resources/theme/js/publications/citationConference.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationChapter.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationBook.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationThesis.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationPatent.js" />"></script>
		   <script src="<c:url value="/resources/theme/js/publications/citationGoogle.js" />"></script>
		   
		   <script src="<c:url value="/resources/theme/js/publications/citationPublication.js" />"></script>
		   
			<script type="text/javascript">
				$(document).ready(function(){
					$("#tabs").tabs();
					var tabId = "journal";
					publication_tabOpen(tabId);
				
					validateIntegerValues();
			    	validateFloatValues();
				});
				
				function publication_tabOpen(tabId)
				{
					var journalResponse = citationPublication_returnTabPage("publication/"+tabId+".htm");
					$("#"+tabId+"Tab").html(journalResponse);
					if(tabId == "journal")
					{
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#thesisTab").html("");
						$("#patentTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
						
					}
					else if(tabId == "conference")
					{
						$("#journalTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#thesisTab").html("");
						$("#patentTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
						
					}
					else if(tabId == "chapter")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#bookTab").html("");
						$("#thesisTab").html("");
						$("#patentTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
						
					}
					else if(tabId == "book")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#thesisTab").html("");
						$("#patentTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
						
					}
					else if(tabId == "thesis")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#patentTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
					}
					else if(tabId == "patent")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#thesisTab").html("");
						$("#googleTab").html("");
						$("#otherTab").html("");
					}
					else if(tabId == "google")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#patentTab").html("");
						$("#thesisTab").html("");
						$("#otherTab").html("");
					}
					else if(tabId == "other")
					{
						$("#journalTab").html("");
						$("#conferenceTab").html("");
						$("#chapterTab").html("");
						$("#bookTab").html("");
						$("#patentTab").html("");
						$("#thesisTab").html("");
						$("#googleTab").html("");
					}
				}
				
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
