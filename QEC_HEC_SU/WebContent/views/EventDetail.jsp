<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEventsDetail" value="/qec/events/save.htm" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Events</h2>
			<!-- Start Search Fields -->
			
				<div class="col-md-8">
                    <form:form servletRelativeAction="${saveEventsDetail}" cssClass="m-t-md ajax-form-login validate-form" method="post" commandName="events" id="events_form" resolveContext="true" resolveMapping="true">
                    
						<div class="form-group">
							<form:label path="dateof" >Start Date : </form:label>
							<form:input path="dateof" cssClass="form-control validate-required datetimepicker" id="events_dateof" placeholder="Start Date"  />
					    </div>    
					    <div class="form-group">
                    		<form:label path="endDate" >End Date : </form:label>
							<form:input path="endDate" cssClass="form-control validate-required datetimepicker" id="events_endDate" placeholder="End Date"  />
					    </div> 
					     <div class="form-group">
                    		<form:label path="quota" >Quote : </form:label>
							<form:input path="quota" cssClass="form-control" id="events_quota" placeholder="Quote "  />
					    </div>   
						<div class="form-group">
                    		<form:label path="eventTitle" >Event title : </form:label>
							<form:input path="eventTitle" cssClass="form-control validate-required" id="events_eventTitle" placeholder="Event title"  />
					    </div>                    
                       <div class="form-group">
		                    <form:label path="departmentId" > Selcet Department : </form:label>
	  	 			        <form:select path="departmentId" cssClass="form-control validate-required" id="events_departmentId" items="${departmentsModelList}" itemValue="departmentId" itemLabel="name">
					 	    	<form:option  value="---Select Customer---" />
					 		</form:select>
	                    </div>
                       	<div class="form-group">
                    		<form:label path="eventDetail" >Event Detail : </form:label>
							<form:textarea path="eventDetail" cssClass="form-control" id="events_eventDetail" placeholder="Event Detail"  />
					    </div>
					    
					    <div class="form-group">
                    		<label for="events_file" >Event File: </label>
							 <input type="file" id="events_file" name="events_file" multiple="multiple"/>
					    </div>
					    <div class="form-group" id="qec_downloadEvent">
                       		
                       	</div>
                        <button id="events-save-btn" type="submit" class="btn" onclick="return event_Crud(event);">Save</button>
                        <!-- Hidden fields -->
						 <form:hidden path="eventsId" id="events_eventsId" />
                         <form:hidden path="fileName" id="events_fileName" />
                  
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	var start_date_input=$('input[name="dateof"]'); //our date input has the name "dateof"
	var end_date_input=$('input[name="endDate"]'); //our date input has the name "end date"
	
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	start_date_input.datepicker({
		dateFormat: "yy-mm-dd",
		container: container,
		todayHighlight: true,
		autoclose: true,
		orientation : "bottom right"
	})
	end_date_input.datepicker({
		dateFormat: "yy-mm-dd",
		container: container,
		todayHighlight: true,
		autoclose: true,
		orientation : "bottom right"
	})
})
</script>
<style>
	
</style>
 