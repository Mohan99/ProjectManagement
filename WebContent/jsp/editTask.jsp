
<!-- @ author Rajkishore-->

 
<%@page import="com.nacre.daoi.daoimpl.TaskManagementDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nacre.dto.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">






<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<%=application.getContextPath() %>/css/jquery-ui.css">

<link href="<%=application.getContextPath() %>/css/bootstrapValidator.min.css">
<%-- <link href="<%=application.getContextPath() %>/css/jquery-ui.css">  --%>  
 


        <title>editTask</title>
        
           
      
     </head>
    <body>
      
 
 
 <jsp:include page="../common_ui/start.jsp"></jsp:include>
    
    <div class="row" style='width:90%'>
     <form class="well form-horizontal"  id="myform" method="post" action="<%=application.getContextPath() %>/UpdateTaskAction"  enctype="multipart/form-data">
      <fieldset>

				<!-- Form Name -->
				<h1 style="text-align: center;">
					<label>Edit Task Details</label>
				</h1>
 
 
  <!-- expression language for viewing object respectively -->
 
  <c:if test="${individualtask ne null }">

     


           
           <fmt:formatDate pattern="MM/dd/yyyy" value="${individualtask.startDate}" var="sdate" />
           <fmt:formatDate pattern="MM/dd/yyyy" value="${individualtask.endDate}" var="edate" />
           <input type="hidden" name="moduletaskid" value="${individualtask.moduleTaskId}" readonly><br><br>
           
           
           
           <div class="form-group">
					<label class="col-md-4 control-label">Task Title</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="tasktitle" value="${individualtask.taskTitle}" placeholder="Task Title" id="taskTitle"
								class="form-control" type="text">
						</div>
					</div>
				</div>
           
           
           
           <div class="form-group">
					<label class="col-md-4 control-label">Task Description</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>
							<textarea class="form-control" name="taskdescription"
								placeholder="Task Description" id="taskDescription">${individualtask.taskDescription}</textarea>
						</div>
					</div>
				</div>
				
				
          
           
           <div class="form-group">
				<label class="col-md-4 control-label">Reference Document</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="taskreferencedocument"	placeholder="upload Document" class="form-control" type="file" id="file">
					</div>
				</div>
			</div>
           
           
           
           
           
            <div class="form-group">
				<label class="col-md-4 control-label">Start Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group" >
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="startdate"
							placeholder="select start Date" id="txtFromDate" class="form-control"  type="text" value="${sdate}" />
					</div>
				</div>
			</div> 
           
           
           
          
          
          
          
          
          
          <div class="form-group">
				<label class="col-md-4 control-label">End Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="enddate"
							placeholder="select End Date" id="txtToDate" class="form-control" type="text" value="${edate}" />
					</div>
				</div>
			</div>
          
          
          
          
          
           
           <div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit"  class="btn btn-warning">
						Submit  <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
         

</c:if> 
     
        </fieldset>
        </form>
        
    </div>
        <jsp:include page="../common_ui/end.jsp"></jsp:include>
 
 
<%-- <script type="text/javascript" src="<%=application.getContextPath()%>/java_script/bootstrapValidator.min.js"></script> --%>



     

 
<script src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>

<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script> 
 
<!-- <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script> -->
     
      <!-- Javascript -->
      
  <script type="text/javascript">
  
 
	
	 $( function() {
	    var dateFormat = "mm/dd/yy",
	    StartDate = $( "#txtFromDate" )
	        .datepicker({

	        	minDate: 0, 
	          /* defaultDate: "+1w", */
	          
	          changeMonth: true,
	          numberOfMonths: 1
	        })
	        .on( "change", function() {
	        	EndDate.datepicker( "option", "minDate", getDate( this ) );
	        }),
	        EndDate = $( "#txtToDate" ).datepicker({
	        //defaultDate: "+1w",
	        changeMonth: true,
	        numberOfMonths: 1
	      })
	      .on( "change", function() {
	        StartDate.datepicker( "option", "maxDate", getDate( this ) );
	      });
	 
	    function getDate( element ) {
	      var date;
	      try {
	        date = $.datepicker.parseDate( dateFormat, element.value );
	      } catch( error ) {
	        date = null;
	      }
	 
	      return date;
	    }
	  } );
	 
	
	 
 
 
 
 $(document)
 .ready(
 		function() {
 			
 		$('#myform')
 				.bootstrapValidator(
 						{
 							// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
 							feedbackIcons : {
 								valid : 'glyphicon glyphicon-ok',
 								invalid : 'glyphicon glyphicon-remove',
 								validating : 'glyphicon glyphicon-refresh'
 							},
 							fields : {
 								tasktitle : {
 									validators : {
 										stringLength : {
 											min : 2,
 										},
 										notEmpty : {
 											message : 'Please supply Task title'
 										}
 									}
 								},
 								taskdescription : {
 									validators : {
 										stringLength : {
 											min : 10,
 											max : 200,
 											message : 'Please enter at least 10 characters and no more than 200'
 										},
 										notEmpty : {
 											message : 'Please supply a description of your Task'
 										}
 									}
 								}
 							}
 						});
 	
 		 
 		});
 
 

 
 
</script> 
       

   </body>
</html>
