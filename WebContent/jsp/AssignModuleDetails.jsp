<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.util.*,java.io.*,java.lang.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Module Details</title>
<!--
 @author Thejaswi S
 --><style type="text/css">
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
<jsp:include page="../common_ui/start.jsp"></jsp:include>
 <div>
<c:if test="${not empty moduledetails}">

 <c:forEach items="${moduledetails}" var="mdetails" >
 

<div class="container">
 <div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="row user-row">
        <center><strong>Assign Module Information</strong></center><br> 
            
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${mdetails.projectManagerImage}"width="50px"
                     alt="ProjectManager Pic"/>
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Project And Project Manager Information</strong><br>
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
                        <h3 class="panel-title">Project And Project Manager Information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${mdetails.projectManagerImage}"
                                     alt="ProjectManager Pic"/>
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>Project Manager </strong><br>
                                <dl>
                                     <dt>Project Id</dt>
                                     <dd>${mdetails.projectId}</dd>
                                     
                                     <dt>Project Title</dt>
                                     <dd>${mdetails.projectTitle}</dd>
                                     
                                     <dt>Project Description</dt>
                                     <dd> ${mdetails.projectDescription}</dd>
                                     
                                     <dt>Expected Start Date </dt>
                                     <dd>${mdetails.expectedStartDate}</dd>
                                     
                                     <dt>Expected End Date</dt>
                                     <dd> ${mdetails.expectedEndDate}</dd>
                                     
                                     <dt>ProjectCompletionPercentage : </dt>
                                     <dd>${mdetails.projectCompletionPercentage}</dd>
   
                                    
                                      
                                      <dt>ProjectManagerName : </dt>
                                     <dd>${mdetails.projectManagerName}</dd>
                                    
                                   <dt>ProjectManagerEmail : </dt>
                               <dd>${mdetails.projectManagerEmail}</dd>
                               
                                <dt>ProjectManagerMobileNo : </dt>
                               <dd>${mdetails.projectManagerMobileNo}</dd>
                                   
                                <dt>ProjectManagerGender : </dt>
                               <dd>${mdetails.projectManagerGender}</dd>
                               
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>Project Manager</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                          <td>Project Id:</td>
                                          <td>${mdetails.projectId}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Title</td>
                                          <td>${mdetails.projectTitle}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Description</td>
                                          <td> ${mdetails.projectDescription}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected Start Date</td>
                                          <td>${mdetails.expectedStartDate}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected End Date</td>
                                          <td>${mdetails.expectedEndDate}</td>
                                    </tr>
                                    <tr>
                                          <td>ProjectCompletionPercentage : </td>
                                          <td> ${mdetails.projectCompletionPercentage}</td>
                                    </tr>
                                    <tr>
                                        <td>Project Manager Name:</td>
                                        <td>${mdetails.projectManagerName}</td>
                                    </tr>
                                    <tr>
                                    <td>ProjectManagerEmail : </td>
                                    <td>${mdetails.projectManagerEmail}</td>
                                    </tr>

                                    <tr>
                                    <td>ProjectManagerMobileNo : </td>
                                    <td>${mdetails.projectManagerMobileNo}</td>
                                    </tr>
                                    
                                    <tr>
                                    <td>ProjectManagerGender : </td>
                                    <td>${mdetails.projectManagerGender}</td>
                                    </tr>                          
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-sm btn-primary" type="button"
                                data-toggle="tooltip"
                                data-original-title="Send message to user"><i class="glyphicon glyphicon-envelope"></i></button>
                        <span class="pull-right">
                            <button class="btn btn-sm btn-warning" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i></button>
                            <button class="btn btn-sm btn-danger" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Remove this user"><i class="glyphicon glyphicon-remove"></i></button>
                        </span>
                    </div>
                </div>
            </div>
        </div>


                <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${mdetails.teamLeaderImage}"width =50px"
                     alt="User Pic"/>
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Module And TeamLeader Information</strong><br>
                <span class="trext-muted">TeamLeader</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".user2">
                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row user-infos user2">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Module And TeamLeader Information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${mdetails.teamLeaderImage}"
                                     alt="User Pic"/>
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>TeamLeader Information</strong><br>
                                <dl>
                                     <dt>ProjectModuleId : </dt>
                                     <dd>${mdetails.projectModuleId}</dd>
                                     
                                     <dt>ModuleTitle</dt>
                                     <dd>${mdetails.moduleTitle}</dd>
                                     
                                     <dt>ModuleDescription</dt>
                                     <dd>${mdetails.moduleDescription}</dd>
                                     
                                     <dt>ModuleStartDte : </dt>
                                     <dd>${mdetails.moduleStartDate}</dd>

                                     <dt>ModuleEndDate : </dt>
                                     <dd>${mdetails.moduleEndDate}</dd>
                                     
                                     
                                    <dt>TeamLeaderName:</dt>
                                    <dd>${mdetails.teamLeaderName}</dd>
                                    
                                    <dt>TeamLeaderEmail : </dt>
                                    <dd>${mdetails.teamLeaderEmail}</dd>

                                    <dt>TeamLeaderMobileNo : </dt>
                                    <dd>${mdetails.teamLeaderMobileNo}</dd>

                                    <dt>TeamLeaderGender : </dt>
                                    <dd>${mdetails.teamLeaderGender}</dd>
                                    
                                    
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>TeamLeader Information</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                    <td>ProjectModuleId : </td>
                                    <td>${mdetails.projectModuleId}</td>
                                    </tr>
                                    <tr>
                                    <td>ModuleTitle : </td>
                                    <td>${mdetails.moduleTitle}</td>
                                    </tr> 
                                    <tr>
                                    <td>ModuleDescription : </td>
                                    <td>${mdetails.moduleDescription}</td>
                                    </tr>
                                    <tr>
                                    <td>ModuleStartDte : </td>
                                    <td>${mdetails.moduleStartDate}</td>
                                    </tr>
                                    <tr>
                                    <td>ModuleEndDate : </td>
                                    <td>${mdetails.moduleEndDate}</td>
                                    </tr>
                                    <tr>
                                    <td>TeamLeaderName : </td>
                                    <td>${mdetails.teamLeaderName}</td>
                                    </tr>
                                    <tr>
                                    <td>TeamLeaderEmail : </td>
                                    <td>${mdetails.teamLeaderEmail}</td>
                                     </tr>

                                     <tr>
                                     <td>TeamLeaderMobileNo : </td>
                                     <td>${mdetails.teamLeaderMobileNo}</td>
                                     </tr>

                                     <tr>
                                     <td>TeamLeaderGender : </td>
                                     <td>${mdetails.teamLeaderGender}</td>
                                     </tr>

                                             
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-sm btn-primary" type="button"
                                data-toggle="tooltip"
                                data-original-title="Send message to user"><i class="glyphicon glyphicon-envelope"></i></button>
                        <span class="pull-right">
                            <button class="btn btn-sm btn-warning" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i></button>
                            <button class="btn btn-sm btn-danger" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Remove this user"><i class="glyphicon glyphicon-remove"></i></button>
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
 <jsp:include page="../common_ui/end.jsp"></jsp:include>
 
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
});
 </script>
 </body>
</html>