<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
	
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllDepartmentForGrid" value="/department/returnAllDepartmentsForGrid/" ></c:url>
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
					
					<table id="department-detail-grid-list">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
    		<!-- <div id="centercontent" class="content"> -->
				<div id="department-detail-grid" class="grid-container"></div>
				<div style="clear: both;"></div>
				
				<jsp:include page="DepartmentDetail.jsp" />
				
				<script type="text/javascript">
					
					$(document).ready(function(){
						var token = $("meta[name='_csrf']").attr("content");
					    var header = $("meta[name='_csrf_header']").attr("content");
						$("#department-detail-grid-list").jqGrid({
							url : "${returnAllDepartmentForGrid}",
							datatype : "json",
							beforeSend: function(xhr) 
					        {
								 xhr.setRequestHeader(header, token);
					        },
							mtype : 'POST',
							width : 1000,
							height : 100,
							colNames : [ 'DepartmentId', 'Department Name','Details'],
							colModel : [ 
							      
								{
									name : 'departmentId',
									index : 'departmentId',
									width : 150,
									hidden : true,
									key : true
								},
							    {
									name : 'name',
							    	index : 'name',
							    	width : 150
								}, 
								{
							        name : 'detail',
							        index : 'detail',
							        width : 150,
							        editable : false
								}],
								ondblClickRow: function(rowId) {
									department_Db_Click(rowId);
								},
							    pager : '#pager',
							    rowNum : 10,
							    height: 'auto',
							    rowList : [ 10,20,30,40 ],
							    sortname : 'name',
							    sortorder : 'asc',
							    viewrecords : true,
							    /* gridview : true,
							    multiselect: true,
							    multiboxonly: false, */
							    caption : 'Departments',
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
							

							$('#search-department-button').on('click',function(){
								var departmentName =  $("#departmentName").val();
								jQuery("#department-detail-grid-list").jqGrid('setGridParam',{url:"returnAllDepartmentsForGrid?departmentName="+departmentName}).trigger("reloadGrid");
				         });
						   
				  });
						
			        	

				</script>
    	</div><!-- Row -->
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
    </div></div>
	</body>
</html>
