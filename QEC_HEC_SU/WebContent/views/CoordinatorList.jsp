<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllUsersForGrid" value="/users/returnAllUsersForGrid" ></c:url>
	<!-- ------------------------------------------------------ -->
	<jsp:include page="../common/header.jsp" />
	<script  src="<c:url value="/resources/theme/js/coordinator/coordinator.js" />" > </script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<jsp:include page="../common/menues.jsp" />
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Users</h2>
							<!-- Start Search Fields -->
							<span> 
								<input class="smallinput" type="text" name="fullName" id="fullName" placeholder="User Name" />
								<input type="button" value="Search" id="search-users-button" />
							</span>
					</div>
					
					<table id="users-detail-grid-list">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
				<div id="users-detail-grid-list" class="grid-container"></div>
				<div style="clear: both;"></div>
				
				 <jsp:include page="CoordinatorDetail.jsp" />
				
				
				<script type="text/javascript">
					
					$(document).ready(function(){
						
						 $("#users-detail-grid-list").jqGrid({
							url : "${returnAllUsersForGrid}",
							datatype : "json",
							mtype : 'POST',
							width : 1000,
							height : 400,
							colNames : [ 'user Id','Full name','Email','User Name','Employee Name'],
							colModel : [ /* {
									departmentsModel.name : 'departmentName',
							    	index : 'departmentName',
							    	width : 150
								},  */
								  {
									name : 'userId',
									index : 'userId',
									hidden : true,
									key : true,
									width : 150
								}, 
								{
									name : 'fullName',
							        index : 'fullName',
							        width : 150,
							        editable : false,
								},
								/* {
									name : 'departmentName',
							        index : 'departmentName',
							        width : 150,
							        editable : false,
								}, */
								{
									name : 'email',
							        index : 'email',
							        width : 150,
							        editable : false
								},
								{
									name : 'username',
									index : 'username',
									width : 150,
							        editable : false,
								},
								{
									name : 'employeeFullName',
							        index : 'employeeFullName',
							        width : 150,
							        editable : false
								}],
								ondblClickRow: function(rowId) {
									coordinator_Db_Click(rowId);
								},
							    pager : '#pager',
							    rowNum : 10,
							    height: 'auto',
							    rowList : [ 10 ],
							    sortname : 'fullName',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: true,
							    multiboxonly: false,
							    caption : 'Users',
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
							

							$('#search-users-button').on('click',function(){
								var fullName =  $("#fullName").val();                             
								jQuery("#users-detail-grid-list").jqGrid('setGridParam',{url:"returnAllUsersForGrid?fullName="+fullName}).trigger("reloadGrid");
								
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
