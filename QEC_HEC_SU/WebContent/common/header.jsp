<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
	<!-- Title -->
    <title>QEC | University Of Sindh Jamshoro</title>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta charset="UTF-8">
    <meta name="description" content="Admin Dashboard Template" />
    <meta name="keywords" content="admin,dashboard" />
    <meta name="author" content="Steelcoders" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <c:url var="home" value="/" scope="request" />
        
    <!-- Styles -->
    <link href="<c:url value="/resources/theme/css/jquery-ui.css" />" rel="stylesheet">
    <%--  <link href="<c:url value="http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" />" rel="stylesheet" type="text/css"> --%>
    <link href="<c:url value="/resources/theme/plugins/pace-master/themes/blue/pace-theme-flash.css" />" rel="stylesheet" type="text/css">
        
    <link href="<c:url value="/resources/theme/plugins/uniform/css/uniform.default.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/fontawesome/css/font-awesome.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/line-icons/simple-line-icons.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/waves/waves.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/switchery/switchery.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/3d-bold-navigation/css/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/slidepushmenus/css/component.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/weather-icons-master/css/weather-icons.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/plugins/metrojs/MetroJs.min.css" />" rel="stylesheet" type="text/css">
   <%--  <link href="<c:url value="/resources/theme/plugins/toastr/toastr.min.css" />" rel="stylesheet" type="text/css"> --%>
    <!-- notification -->
    <link href="<c:url value="/resources/theme/css/toast/iziToast.min.css" />" rel="stylesheet">
    
    <!-- Theme Styles -->
    <link href=" <c:url value="/resources/theme/css/modern.min.css" />" rel="stylesheet" type="text/css"/>
    <link href=" <c:url value="/resources/theme/css/custom.css" />" rel="stylesheet" type="text/css"/>
    <script  src="<c:url value="/resources/theme/plugins/3d-bold-navigation/js/modernizr.js" />" > </script>
    <link href=" <c:url value="/resources/theme/css/style.css" />" rel="stylesheet" type="text/css"/>
		
	<!-- jq grid -->
	<link href=" <c:url value="/resources/theme/js/jqgrid/style/ui.jqgrid.css" />" rel="stylesheet" type="text/css"/>
	<link href=" <c:url value="/resources/theme/js/jqgrid/style/searchFilter.css" />" rel="stylesheet" type="text/css"/>
	<link href=" <c:url value="/resources/theme/js/jqgrid/style/ui.multiselect.css" />" rel="stylesheet" type="text/css"/>
	
	<!--  High charts css -->
	<link href=" <c:url value="/resources/theme/plugins/highcharts/css/highcharts.css" />" rel="stylesheet" type="text/css"/>
	
	<!-- Smoke Validation -->
	<link href=" <c:url value="/resources/theme/js/formValidation/css/smoke.min.css" />" rel="stylesheet" type="text/css"/>
	
	<!-- bootstrap Date and time picker  -->
	<link href=" <c:url value="/resources/theme/plugins/bootstrap-datetimepicker\css\bootstrap-datetimepicker.min.css" />" rel="stylesheet" type="text/css"/>
	
    <!-- Javascripts -->
    <script src="<c:url value="/resources/theme/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/resources/theme/js/jquery-ui.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/pace-master/pace.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/jquery-blockui/jquery.blockui.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/bootstrap/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/switchery/switchery.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/uniform/jquery.uniform.min.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/classie/classie.js" />"></script>
    <script src="<c:url value="/resources/theme/plugins/waves/waves.min.js" />"></script>
    <script src="<c:url value="/resources/theme/js/login.js" />"></script>
    <script  src="<c:url value="/resources/theme/js/jquery.flot.js" />" > </script>
	<%-- <script src="<c:url value="/resources/theme/js/style.js" />"></script>
	<script src="<c:url value="/resources/theme/js/jquery.timepicker.min.js" />"></script> --%>
	<script src="<c:url value="/resources/theme/plugins/toastr/toastr.min.js" />"></script> 
	<script src="<c:url value="/resources/theme/js/modern.js" />"></script>
	
	<script src="<c:url value="/resources/theme/js/toast/iziToast.min.js" />"></script>
		
	<!--  jq grid-->
	<script src="<c:url value="/resources/theme/js/jqgrid/i18n/grid.locale-en.js" />"></script>
	<script src="<c:url value="/resources/theme/js/jqgrid/jquery.jqGrid.js" />"></script>

	<!-- Highcharts -->
	<script src="<c:url value="/resources/theme/plugins/highcharts/js/highcharts.js" />"></script>
	<script src="<c:url value="/resources/theme/plugins/highcharts/js/exporting.js" />"></script>
	
	<!-- Smoke Validation Form -->
	<script src="<c:url value="/resources/theme/js/formValidation/js/smoke.min.js" />"></script>
	
	<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet" />
	
	<!-- Datepicker  -->
	<!-- bootstrap Date and time picker  -->
	<script  src="<c:url value="/resources/theme/plugins/bootstrap-datetimepicker\js\bootstrap-datetimepicker.min.js" />" > </script>
	
	<!-- common script -->
	<script src="<c:url value="/resources/theme/js/script.js" />"></script>
	
	<script>
		$( function() {
	    	$('.datepicker').datepicker({
	    		dateFormat: 'dd-m-yy',
	    		showButtonPanel: true,
	    		changeMonth: true,
	    		buttonImage: "calendar.gif",
	    		buttonText: "Calendar"
	    	});
	    	
	    	$(".ui-widget-header").css("background","#1B75A1;");
		} );
  	</script>
    <style>
		.page-content 
		{
			/*background:url(http://3melements.com/sindhuni/assets/images/sindh_uni_gate.jpg) center -150px no-repeat;*/
		    background-size:cover;
		}
		.page-inner
		{
			/*background:rgba(0,0,0,.4);*/
		    /* background:rgba(27, 117, 161, 0.88) */
		}
		.login-box 
		{
			margin: auto;
		    background: rgb(27, 117, 161);
		    border-radius: 3px;
		    padding: 6px;
		    width: 100%;
		    max-width: 100%;
		}
		.ui-jqgrid-titlebar 
		 {
			background: #275064;
		 }
		 .ui-datepicker-div ui-widget-header
		 {
			background: #1B75A1;
		 }
    </style>
</head>
<label id="validate-required-error" style="display: none;" class="non-readonly" >Field is required.</label>
<label id="validate-regex-error" style="display: none;" class="non-readonly" >Please Enter Valid Value.</label>