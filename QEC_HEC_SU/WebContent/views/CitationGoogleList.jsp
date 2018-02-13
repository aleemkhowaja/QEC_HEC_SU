<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllGoogleForGrid" value="/qec/google/returnAllCitationGoogleForGrid" ></c:url>
	<!-- ------------------------------------------------------ -->
	<%-- <jsp:include page="../common/header.jsp" /> --%>
	<script src="<c:url value="/resources/theme/js/publications/citationGoogle.js" />"></script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Google</h2>
						<!-- Start Search Fields -->
						<span> 
							<input class="smallinput" type="text" name="GoogleUrl" id="GoogleUrl" placeholder="Google Url" />
							<input type="button" value="Search" id="search-google-button" />
						</span>
					</div>
					
					<table id="google-detail-grid-list" class="grid-container">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
				<div id="google-detail-grid-list" class="grid-container"></div>
				<div style="clear: both;"></div>
				<!-- include google detail page -->
				<jsp:include page="CitationGoogleDetail.jsp" />

				<script type="text/javascript">
					$(document).ready(function(){
						var token = $("meta[name='_csrf']").attr("content");
					    var header = $("meta[name='_csrf_header']").attr("content");
						 $("#google-detail-grid-list").jqGrid({
							url : "${returnAllGoogleForGrid}",
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
							colNames : [ 'Employee','Url','Action'],
							colModel : [
								{
									name : 'employeeName',
									index : 'employeeName',
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
									name : 'citationGoogleId',
							        index : 'citationGoogleId',
							        width : 150,
							        hidden : true,
									key : true,
								}
								],
								ondblClickRow: function(rowId) {
									citationGoogle_Db_Click(rowId);
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
							    sortname : 'url',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: true,
							    multiboxonly: false,
							    caption : 'Citation Google',
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
							

							$('#search-google-button').on('click',function(){
								var GoogleUrl =  $("#GoogleUrl").val();                             
								jQuery("#google-detail-grid-list").jqGrid('setGridParam',{url:"/QEC_HEC_SU/qec/google/returnAllCitationGoogleForGrid?url="+GoogleUrl}).trigger("reloadGrid");
								
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