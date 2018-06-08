<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllEmployeeTrainingForGrid" value="/qec/employeeTraining/returnAllEmployeeTrainingForGrid" ></c:url>
	<!-- ------------------------------------------------------ -->
	<%-- <jsp:include page="../common/header.jsp" /> --%>
	<script  src="<c:url value="/resources/theme/js/employeeTraining/employeeTraining.js" />" > </script>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-inner">
		    <div class="page-title">
		        <div class="container">
		        	<div class="adv_ser_row" >
		        		<h2>Employee Trainings</h2>
							<!-- Start Search Fields -->
							<span> 
								<input class="smallinput" type="text" name="name" id="employeeTraining_name" placeholder="Employee Training Name" />
								<input type="button" value="Search" id="search-employee-training-button" />
							</span>
					</div>
					
					<table id="employee-training-detail-grid-list">
                		<tr>
                			<td />
                		</tr>
        			</table>
        			<div id="pager"></div>
		        </div>
		    </div>
    		<div id="main-wrapper" class="container">
				<div id="employee-training-detail-grid-list" class="grid-container"></div>
				<div style="clear: both;"></div>
				
				<jsp:include page="EmployeeTrainingDetail.jsp" />
				
				<script type="text/javascript">
					
					$(document).ready(function(){
						var token = $("meta[name='_csrf']").attr("content");
					    var header = $("meta[name='_csrf_header']").attr("content");
						 $("#employee-training-detail-grid-list").jqGrid({
							url : "${returnAllEmployeeTrainingForGrid}",
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
							colNames : [ 'Employee Name','Employee Training Title','Place','Localiy','Institution Name','Training Condition','Employee Training Id'],
							colModel : [
								{
									name : 'employee.fullName',
									index : 'employee.fullName',
									width : 150,
									editable : false,
								},
								{
									name : 'name',
									index : 'name',
									width : 150,
									editable : false,
								},
								{
									name : 'place',
							        index : 'place',
							        width : 150,
							        editable : false
								},
								{
									name : 'locality',
									index : 'locality',
									width : 150
								}, 
								{
									name : 'instituteName',
							        index : 'instituteName',
							        width : 150,
							        editable : false,
								},
								{
									name : 'trainingCondition',
							        index : 'trainingCondition',
							        width : 150,
							        editable : false
								},
								{
									name : 'employeeTrainingsId',
							        index : 'employeeTrainingsId',
							        width : 150,
							        hidden : true,
									key : true,
								}
								],
								ondblClickRow: function(rowId) {
									employeeTraining_Db_Click(rowId);
								},
							    pager : '#pager',
							    rowNum : 10,
							    height: 'auto',
							    rowList : [ 10,20,30,40 ],
							    sortname : 'name',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: true,
							    multiboxonly: false,
							    caption : 'Employee Training',
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
							

							$('#search-employee-training-button').on('click',function()
							{
								var employeeTrainingName =  $("#employeeTraining_name").val();                             
								jQuery("#employee-training-detail-grid-list").jqGrid('setGridParam',{url:"employeeTraining/returnAllEmployeeTrainingForGrid?employeeTrainingName="+employeeTrainingName}).trigger("reloadGrid");
								
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
