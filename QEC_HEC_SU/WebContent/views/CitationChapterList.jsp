<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllChapterForGrid" value="/qec/chapter/returnAllCitationChapterForGrid" ></c:url>
	<!-- ------------------------------------------------------ -->
	<%-- <jsp:include page="../common/header.jsp" /> --%>
	<script src="<c:url value="/resources/theme/js/publications/citationChapter.js" />"></script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Chapter</h2>
						<!-- Start Search Fields -->
						<span> 
							<input class="smallinput" type="text" name="chapterTitle" id="chapterTitle" placeholder="Chapter Title" />
							<input type="button" value="Search" id="search-chapter-button" />
						</span>
					</div>
					
					<table id="chapter-detail-grid-list" class="grid-container">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
				<div id="chapter-detail-grid-list" class="grid-container"></div>
				<div style="clear: both;"></div>
				<!-- include chapter detail page -->
				<jsp:include page="CitationChapterDetail.jsp" />

				<script type="text/javascript">
					$(document).ready(function(){
						var token = $("meta[name='_csrf']").attr("content");
					    var header = $("meta[name='_csrf_header']").attr("content");
						 $("#chapter-detail-grid-list").jqGrid({
							url : "${returnAllChapterForGrid}",
							loadBeforeSend : function(jqXHR) {
				                // you should modify the next line to get the CSRF tocken
				                // in any way (for example $('meta[name=csrf]').attr('content')
				                // if you have <meta name="csrf" content="abcdefjklmnopqrstuvwxyz="/>)
				                jqXHR.setRequestHeader(header, token);
				            },
							datatype : "json",
							mtype : 'POST',
							width : 1000,
							height : 400,
							colNames : [ 'Title','Url','Authors','Publication Date','Book','Volume','Issue','Pages','Action'],
							colModel : [
								{
									name : 'title',
									index : 'title',
									width : 150,
									editable : false,
								},
								{
									name : 'url',
									index : 'url',
									width : 150,
									editable : false,
								},
								{
									name : 'authors',
							        index : 'authors',
							        width : 150,
							        editable : false
								},
								{
									name : 'publicationDate',
									index : 'publicationDate',
									width : 150
								}, 
								{
									name : 'book',
							        index : 'book',
							        width : 150,
							        editable : false,
								},
								{
									name : 'volume',
							        index : 'volume',
							        width : 150,
							        editable : false
								},
								{
									name : 'issue',
							        index : 'issue',
							        width : 150,
							        editable : false
								},
								{
									name : 'pages',
							        index : 'pages',
							        width : 150,
							        editable : false
								},
								{
									name : 'citationChapterId',
							        index : 'citationChapterId',
							        width : 150,
							        hidden : true,
									key : true,
								}
								],
								ondblClickRow: function(rowId) {
									citationChapter_Db_Click(rowId);
								},
								ajaxEditOptions: {
						            beforeSend: function(jqXHR) {
						                // you should modify the next line to get the CSRF tocken
						                // in any way (for example $('meta[name=csrf]').attr('content')
						                // if you have <meta name="csrf" content="abcdefjklmnopqrstuvwxyz="/>)
						                jqXHR.setRequestHeader(header, token);
						            }
						        },
							    pager : '#pager',
							    rowNum : 10,
							    height: 'auto',
							    rowList : [ 10,20,30,40 ],
							    sortname : 'title',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: true,
							    multiboxonly: false,
							    caption : 'Citation Chapter',
							    jsonReader : {
							    	repeatitems : false,
							    }
							});
						// activate the toolbar searching
				            $('#jqGrid').jqGrid('filterToolbar',{
				                // JSON stringify all data from search, including search toolbar operators
				                stringResult: true,
				                // instuct the grid toolbar to show the search options
				                searchOperators: true
				            });
						
				            /* jQuery("#department-detail-grid-list").jqGrid('navGrid','#pager',{del:false,add:false,edit:false,search:true});
				            jQuery("#department-detail-grid-list").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true}); */
							

							$('#search-chapter-button').on('click',function(){
								var chapterTitle =  $("#chapterTitle").val();                             
								jQuery("#chapter-detail-grid-list").jqGrid('setGridParam',{url:"/QEC_HEC_SU/qec/chapter/returnAllCitationChapterForGrid?title="+chapterTitle}).trigger("reloadGrid");
								
				         });
						   
				  });
				</script>
    		</div><!-- Row -->
    	</div><!-- Main Wrapper -->
    	<style>
		.grid-container
		 {
		 	margin-left: 0%
		 }
	</style>
	</body>
	
	
</html>