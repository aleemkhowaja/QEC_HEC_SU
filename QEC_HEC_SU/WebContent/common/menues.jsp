   	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="overlay"></div>
    
    <!--  start page urls -->
    <c:url var="returnDepartmentPage" value="/qec/department/department.htm" ></c:url> 
    <c:url var="returnProgramsPage" value="/qec/programs/programs.htm" ></c:url> 
    <c:url var="returnCoordinatorPage" value="/qec/coordinator/coordinator.htm" ></c:url>
    <c:url var="returnEventPage" value="/qec/event/event.htm" ></c:url>
    <c:url var="returnEmployeePage" value="/qec/employee/employee.htm" ></c:url> 
    <c:url var="returnPublicationPage" value="/qec/publication/publication.htm" ></c:url>
    <c:url var="returnCitationPage" value="/qec/publication/journal.htm" ></c:url>
    <c:url var="dashboardPage" value="/qec/dashboard.htm" ></c:url>
    
    <c:url var="logout" value="/logout" ></c:url>
    
    <!-- end page urls -->  
    
    <main class="page-content content-wrap">
    	<div class="navbar">
        	<div class="navbar-inner container">
            	<div class="sidebar-pusher">
                	<a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                    	<i class="fa fa-bars"></i>
                    </a>
                </div>
                <div class="logo-box">
                	<a href="http://3melements.com/sindhuni/" class="logo-text"><img src="/QEC_HEC_SU/resources/theme/images/logo1.png" width="200"></a>
                </div><!-- Logo Box -->
                <div class="search-button">
                	<a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                </div>
                <div class="topmenu-outer">
                	<div class="top-menu">
                    	<ul class="nav navbar-nav navbar-right">
                        	<li class="dropdown">
                            	<a href="index.html#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                	<span class="user-name">admin<i class="fa fa-angle-down"></i></span>
                                	<!-- <img class="img-circle avatar" src="http://3melements.com/sindhuni/assets/images/avatar1.png" width="40" height="40" alt=""> -->
                                </a>
                                <ul class="dropdown-menu dropdown-list" role="menu">
                                	<li role="presentation"><a href="http://3melements.com/sindhuni/users/editprofile"><i class="fa fa-user"></i>Profile</a></li>
                                    <li role="presentation"><a href="${logout}"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                </ul>
                           	</li>
                     	</ul><!-- Nav -->
                  	</div><!-- Top Menu -->
                </div>
           	</div>
       </div><!-- Navbar -->
       <div class="page-sidebar sidebar horizontal-bar">
       <div class="page-sidebar-inner">
       	<ul class="menu accordion-menu">
        	<li class="nav-heading"><span>Navigation</span></li>
            <li class="active"><a href="${dashboardPage}"><span class="menu-icon icon-speedometer"></span><p>Dashboard</p></a></li>
             <li class="droplink "><a href="#"><span class="menu-icon fa fa-building"></span><p>Departments</p><span class="arrow"></span></a>
            	<ul class="sub-menu">
                    <li><a href="#" onclick="returnPage('${returnDepartmentPage}');">Departments</a></li>
                </ul>
            </li>
            
            <li class="droplink "><a href="#"><span class="menu-icon fa fa-building"></span><p>Programs</p><span class="arrow"></span></a>
	            <ul class="sub-menu">
	                <li><a href="#" onclick="returnPage('${returnProgramsPage}');">Programs</a></li>
		        </ul>
       	 	</li>
                       
           	<li class="droplink "><a href="#"><span class="menu-icon fa fa-building"></span><p>Coordinators</p><span class="arrow"></span></a>
	            <ul class="sub-menu">
	                <li><a href="#"  onclick="returnPage('${returnCoordinatorPage}');">Coordinator</a></li>
		        </ul>
       	 	</li>
       	 	<li class="droplink "><a href="#"><span class="menu-icon fa fa-building"></span><p>Events</p><span class="arrow"></span></a>
	            <ul class="sub-menu">
	                <li><a href="#"  onclick="returnPage('${returnEventPage}');">Event</a></li>
		        </ul>
       	 	</li>
			<li class="droplink "><a href="#"><span class="menu-icon fa fa-building"></span><p>Employee</p><span class="arrow"></span></a>
	            <ul class="sub-menu">
	                <li><a href="#" onclick="returnPage('${returnEmployeePage}');">Employee</a></li>
		        </ul>
       	 	</li>
            <li class=""><a href="http://3melements.com/sindhuni/login_logs"><span class="menu-icon icon-list"></span><p>Login Logs</p></a></li>

            <li class="droplink "><a href="http://3melements.com/sindhuni/research/citations">
	            <span class="menu-icon fa fa-beer"></span><p>Research</p><span class="arrow"></span></a>
    	        <ul class="sub-menu">
        	        <li><a href="#" onclick="returnPage('${returnPublicationPage}');">Publications</a></li> 
                    <li><a href="http://3melements.com/sindhuni/research/training">Training/workShops</a></li> 
                    <li><a href="http://3melements.com/sindhuni/research/phdStudents">MPHIL/PHD Students</a></li> 
                    <li><a href="http://3melements.com/sindhuni/research/travelGrands">Research/Travel Grants</a></li> 
                    <li><a href="http://3melements.com/sindhuni/research/industrialLinkages">Industrial Linkages</a></li> 
	            </ul>
             </li>
                       <li class=""><a href="http://3melements.com/sindhuni/research/communityServices">
                                <span class="menu-icon fa fa-users"></span><p>Community Services</p><span class="arrow"></span></a>
                           
                        </li>
                        <!--li class=""><a href="http://3melements.com/sindhuni/research/accreditations">
                                <span class="menu-icon fa fa-bell"></span><p>Accreditations</p><span class="arrow"></span></a>
                           
                        </li-->
                        <li class=""><a href="http://3melements.com/sindhuni/research/studentScholarships">
                                <span class="menu-icon fa fa-bell"></span><p>Student Scholarships</p><span class="arrow"></span></a>
                           
                        </li>
                        <li class=""><a href="http://3melements.com/sindhuni/program_history">
                                <span class="menu-icon fa fa-bell"></span><p>Programs Statistics</p><span class="arrow"></span></a>
                           
                        </li>
                        <li class="droplink "><a href="http://3melements.com/sindhuni/promotions"><span class="menu-icon fa fa-gift"></span><p>Awards</p><span class="arrow"></span></a>
                            <ul class="sub-menu">
                                <li><a href="http://3melements.com/sindhuni/promotions/add">Add Awards</a></li>
                                <li><a href="http://3melements.com/sindhuni/promotions">Awards List</a></li>
                                
                            </ul>
                        </li>
                        
                        <li class=""><a href="http://3melements.com/sindhuni/eventscalendar"><span class="menu-icon fa fa-calendar"></span><p>Events Calendar</p><span class="arrow"></span></a>
                           
                        </li>
                    </ul>
                </div><!-- Page Sidebar Inner -->
            </div><!-- Page Sidebar -->
            
            <script>
            
            function login_logut()
            {
            	var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
            	url ='/logout';
            	event.preventDefault();
            	$.ajax({
            		url :url,
            		 type: "POST",
                     contentType: "application/json",
                     beforeSend: function(xhr) {
                         xhr.setRequestHeader("Accept", "application/json");
                         xhr.setRequestHeader("Content-Type", "application/json");
                         xhr.setRequestHeader(header, token);
                     },
            		 async:false,
            		 success : function(data) {}
            	});
            	event.preventDefault();
            }
            
            </script>