<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllEmployeeForGrid" value="/qec/employee/returnAllEmployeeForGrid" ></c:url>
	<!-- ------------------------------------------------------ -->
	<jsp:include page="../common/header.jsp" />
	<script  src="<c:url value="/resources/theme/js/employee/employee.js" />" > </script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<jsp:include page="../common/menues.jsp" />
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Users</h2>
							<!-- Start Search Fields -->
							<span> 
								<input class="smallinput" type="text" name="fullName" id="fullName" placeholder="Employee Name" />
								<input type="button" value="Search" id="search-employee-button" />
							</span>
					</div>
					
					<table id="employee-detail-grid-list">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
				<div id="employee-detail-grid-list" class="grid-container"></div>
				<div style="clear: both;"></div>
				
				<jsp:include page="EmployeeDetail.jsp" />
				
				<script type="text/javascript">
					
					$(document).ready(function(){
						
						 $("#employee-detail-grid-list").jqGrid({
							url : "${returnAllEmployeeForGrid}",
							datatype : "json",
							mtype : 'POST',
							width : 1000,
							height : 400,
							colNames : [ 'Full Name','Surname','Father Name','Email','Gender','Moblie No','Employee Id'],
							colModel : [
								{
									name : 'fullName',
									index : 'fullName',
									width : 150,
									editable : false,
								},
								{
									name : 'surname',
									index : 'surname',
									width : 150,
									editable : false,
								},
								{
									name : 'fatherName',
							        index : 'fatherName',
							        width : 150,
							        editable : false
								},
								{
									name : 'email',
									index : 'email',
									width : 150
								}, 
								{
									name : 'gender',
							        index : 'gender',
							        width : 150,
							        editable : false,
								},
								{
									name : 'mobile',
							        index : 'mobile',
							        width : 150,
							        editable : false
								},
								{
									name : 'employeeId',
							        index : 'employeeId',
							        width : 150,
							        hidden : true,
									key : true,
								}
								],
								ondblClickRow: function(rowId) {
									employee_Db_Click(rowId);
								},
							    pager : '#pager',
							    rowNum : 10,
							    height: 'auto',
							    rowList : [ 10,20,30,40 ],
							    sortname : 'fullName',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: true,
							    multiboxonly: false,
							    caption : 'Employee',
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
							

							$('#employee-detail-grid-list').on('click',function(){
								var fullName =  $("#fullName").val();                             
								jQuery("#employee-detail-grid-list").jqGrid('setGridParam',{url:"returnAllEmployeeForGrid?fullName="+fullName}).trigger("reloadGrid");
								
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
