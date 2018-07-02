<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><!-- 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>

<style type="text/css">
.user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}

</style>
</head>
<body>
<jsp:include page="../common_ui/header.jsp"></jsp:include>
<div class='row'>
<div class='col-md-3'>

<jsp:include page="../common_ui/menu.jsp"></jsp:include>
</div>

<c:if test="${not empty dtDet}">

<c:forEach var="det" items="${dtDet}">

<div class="container">
 <div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${det.promgrimage}"width="50px"
                     alt="User Pic">
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Project Manager Information</strong><br>
                <span class="text-muted">Project Manager</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".cyruxx">
                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row user-infos cyruxx">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Project Manager information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${det.promgrimage}"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>Project Manager</strong><br>
                                <dl>
                                     <dt>Project Id</dt>
                                     <dd>${det.projectId}</dd>
                                     
                                     <dt>Project Title</dt>
                                     <dd>${det.projectTitle}</dd>
                                     
                                     <dt>Project Description</dt>
                                     <dd> ${det.projectDescription}</dd>
                                     
                                     <dt>Expected Start Date </dt>
                                     <dd>${det.expectedStartDate}</dd>
                                     
                                     <dt>Expected End Date</dt>
                                     <dd> ${det.exceptedEndDate}</dd>
                                     
                                     <dt>Project Module Id</dt>
                                     <dd>${det.projectModuleid}</dd>
                                     
                                    <dt>Project Manager Name:</dt>
                                    <dd> ${det.promgrFirstName}</dd>
                                    
                                    <dt>Email:</dt>
                                    <dd>${det.promgremail}</dd>
                                    
                                    <dt>Mobile No:</dt>
                                    <dd>${det.promgrMobileNo}</dd>
                                    
                                   
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>Project Manager</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                          <td>Project Id:</td>
                                          <td>${det.projectId}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Title</td>
                                          <td>${det.projectTitle}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Description</td>
                                          <td> ${det.projectDescription}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected Start Date</td>
                                          <td>${det.expectedStartDate}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected End Date</td>
                                          <td> ${det.exceptedEndDate}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Module Id</td>
                                          <td>${det.projectModuleid}</td>
                                    </tr>
                                    <tr>
                                        <td>Project Manager Name:</td>
                                        <td>${det.promgrFirstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${det.promgremail}</td>
                                    </tr>
                                    <tr>
                                        <td>Mobile No:</td>
                                        <td>${det.promgrMobileNo}</td>
                                    </tr>
                                    <tr>
                                        <td>Warnings</td>
                                        <td>0</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                   </div>
            </div>
        </div>


                <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${det.temledimage}"width =50px"
                     alt="User Pic">
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Team Leader</strong><br>
                <span class="trext-muted">Team Leader</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".user2">
                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row user-infos user2">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">TeamLeader Information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${det.temledimage}"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>TeamLeader Information</strong><br>
                                <dl>
                                     <dt>Module Title</dt>
                                     <dd>${det.moduleTitle}</dd>
                                     <dt>Module Description</dt>
                                     <dd>${det.moduleDescription}</dd>
                                     
                                    <dt>TeamLeader Name:</dt>
                                    <dd>${det.temledFirstName}</dd>
                                    <dt>Email:</dt>
                                    <dd>${det.temledemail}</dd>
                                    <dt>Mobile No</dt>
                                    <dd>${det.temledMobileNo}</dd>
                                    
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>TeamLeader Information</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                         <td>Module Title</td>
                                         <td>${det.moduleTitle}</td>
                                    </tr>
                                    <tr>
                                         <td>Module Description</td>
                                         <td>${det.moduleDescription}</td>
                                    </tr>
                                    <tr>
                                        <td>TeamLeader Name:</td>
                                        <td>${det.temledFirstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${det.temledemail}</td>
                                    </tr>
                                    <tr>
                                        <td>Mobile No</td>
                                        <td>${det.temledMobileNo}</td>
                                    </tr>
                                   
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${det.devimage}" width ="50px"
                     alt="User Pic">
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Developer Information</strong><br>
                <span class="text-muted">Developer</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".user3">
                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row user-infos user3">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Developer  information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${det.devimage}"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>Developer information</strong><br>
                                <dl>
                                     <dt>Task Title</dt>
                                     <dd>${det.taskTitle}</dd>
                                     <dt>Task Description</dt>
                                     <dd> ${det.taskDescription}</dd>
                                    
                                    <dt>Developer Name:</dt>
                                    <dd>${det.devFirstName}</dd>
                                    <dt>Email:</dt>
                                    <dd>${det.devemail}</dd>
                                    <dt>Mobile No</dt>
                                    <dd>${det.devMobileNo}</dd>
                                    
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>Developer Information</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                       <td>Task Title</td>
                                       <td>${det.taskTitle}</td>
                                    </tr>
                                     <tr>
                                       <td>Task Descriptiontd>
                                       <td> ${det.taskDescription}</td>
                                    </tr>
                                    <tr>
                                        <td>Developer Name:</td>
                                        <td>${det.devFirstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${det.devemail}</td>
                                    </tr>
                                    <tr>
                                        <td>Mobile No</td>
                                        <td>${det.devMobileNo}</td>
                                    </tr>
                                   
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <span class="pull-left">
                        <button class="btn btn-lg btn-success" type="button"
                                data-toggle="tooltip" id='accept'
                                data-original-title="ACCEPT TASK" dtId ='${det.devloperTaskId }'><i class="glyphicon glyphicon-ok"></i></button>
                        </span>
                        <span class="pull-right">
                            <button class="btn btn-lg btn-danger" type="button"
                                    data-toggle="tooltip" id='reject'dtId ='${det.devloperTaskId }'
                                    data-original-title="REJECT TASK"><i class="glyphicon glyphicon-remove"></i></button>
                        </span>
                    </div>
                </div>
            </div>
        </div>


        
        
    </div>
</div>
</c:forEach>
</c:if>
</div>
<jsp:include page="../common_ui/footer.jsp"></jsp:include>

<script>
$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
            }
            else
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
            }
        })
    });


    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
        alert("This is a demo.\n :-)");
    });

    $('#accept').click(function(){
    	alert("hiee");
    	var dtId =$(this).attr("dtId");
    	acceptOrReject(dtId,true);
    	  });// second
    	  

    	    $('#reject').click(function(){
    	    	alert("hiee");

    	    	var dtId =$(this).attr("dtId");
    	    	acceptOrReject(dtId,false);
    	    	  });// second
});
function acceptOrReject(dtId,isAccept){
	
	$.ajax({
		"url":path+"/NotificationUpdateTask",
		"data":{"dtId":dtId,"isAccept":isAccept},
		"success":function(data){
var msg;
if(data.success!=undefined){
	msg=data.success;
}else if(data.fail!=undefined){
	msg=data.fail;
	
}else{
	msg="PLESE TRY LATER";
	
}
			alert(msg);
			window.location.replace("<%=application.getContextPath()%>/common_ui/welcome.jsp?success="+msg);
			
		}
		
	});

}






</script>



</body>
</html>