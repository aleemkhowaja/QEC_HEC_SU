<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<jsp:include page="../common/header.jsp" />
    <body class="page-header-fixed compact-menu page-horizontal-bar">
    	<jsp:include page="../common/menues.jsp" />
	<div class="page-inner">
    <div class="page-title">
        <div class="container">
            <h3>Quality Assurance System 09/Jul/2017</h3>
        </div>
    </div>
    <div id="main-wrapper" class="container">
        <div class="row">
                            <div class="col-lg-3 col-md-3">
                    <div class="panel info-box panel-white color1">
                        <div class="panel-body">


                            <div class="info-box-stats">
                                <p class="counter">79</p>
                                                                <span class="info-box-title">TEACHING STAFF</span>
                            </div>


                        </div>
                    </div>
                </div>
                            <div class="col-lg-3 col-md-3">
                    <div class="panel info-box panel-white color1">
                        <div class="panel-body">


                            <div class="info-box-stats">
                                <p class="counter">15</p>
                                                                <span class="info-box-title">NON TEACHING STAFF</span>
                            </div>


                        </div>
                    </div>
                </div>
                        <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color2">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p class="counter">117</p>
                            <span class="info-box-title">Male Students</span>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color2">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p class="counter">41</p>
                            <span class="info-box-title">Female Students</span>
                        </div>
                        
                    </div>
                </div>
            </div>
                            
            
            <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color3">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p><span class="counter">122</span></p>
                            <span class="info-box-title">Impact Factor Research Papers</span>
                        </div>
                        
                    </div>
                </div>
            </div>
                            
            
            <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color3">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p><span class="counter">95</span></p>
                            <span class="info-box-title">Research Papers HEC Recognize(XYZ)</span>
                        </div>
                        
                    </div>
                </div>
            </div>
                        <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color4">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p class="counter">162</p>
                            <span class="info-box-title">Male Teachers</span>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="panel info-box panel-white color4">
                    <div class="panel-body">
                        <div class="info-box-stats">
                            <p class="counter">59</p>
                            <span class="info-box-title">Female Teachers</span>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div><!-- Row -->
        <div class="row">
            <div class="col-lg-12 col-md-12">

                <div class="panel panel-white">
                    <div class="row">
                        
                        <div class="col-sm-12">
                            <div id="journal_Hec_Category"></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-white">
                    <div class="row">

                        <div class="col-sm-12">
                            <div id="impact_factor"></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-white">
                    <div class="row">

                        <div class="col-sm-12">
                            <div id="emp_travelgrands_new"></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-white">
                    <div class="row">

                        <div class="col-sm-12">
                            <div id="femp_travelgrands_new"></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-white">
                    <div class="row">

                        <div class="col-sm-12">
                            <div id="community_services"></div>
                        </div>
                    </div>
                </div>
                 <div class="panel panel-white">
                    <div class="row">

                        <div class="col-sm-12">
                            <div id="ifh"></div>
                        </div>
                    </div>
                </div>

            </div>





        </div>
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
<script>
    var data2=[            [0, "1"],
            [1, "1"],
];
    var ticks=[
            [0, "01/01/2016"],
            [1, "10/02/2016"],
    ];</script>


<%-- <script src="<c:url value="/resources/theme/js/pages/dashboard.js" />"></script> --%>
</main><!-- Page Content -->
<nav class="cd-nav-container" id="cd-nav">
    <header>
        <h3>Navigation</h3>
        <a href="index.html#0" class="cd-close-nav">Close</a>
    </header>
    <ul class="cd-nav list-unstyled">
        <li class="cd-selected" data-menu="index">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-home"></i>
                </span>
                <p>Dashboard</p>
            </a>
        </li>
        <li data-menu="profile">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-user"></i>
                </span>
                <p>Profile</p>
            </a>
        </li>
        <li data-menu="inbox">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-envelope"></i>
                </span>
                <p>Mailbox</p>
            </a>
        </li>
        <li data-menu="#">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-tasks"></i>
                </span>
                <p>Tasks</p>
            </a>
        </li>
        <li data-menu="#">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-cog"></i>
                </span>
                <p>Settings</p>
            </a>
        </li>
        <li data-menu="calendar">
            <a href="javsacript:void(0);">
                <span>
                    <i class="glyphicon glyphicon-calendar"></i>
                </span>
                <p>Calendar</p>
            </a>
        </li>
    </ul>
</nav>
<div class="cd-overlay"></div>

<script src="<c:url value="/resources/theme/js/qec-charts/monthImpactFactorByHec.js" />"></script>
<script src="<c:url value="/resources/theme/js/qec-charts/travelGrants.js" />"></script>
<script src="<c:url value="/resources/theme/js/qec-charts/hecXYResearcPapers.js" />"></script>
<!-- Javascripts -->



</body>
</html>