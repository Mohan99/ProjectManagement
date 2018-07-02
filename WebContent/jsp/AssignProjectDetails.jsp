<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.util.*,java.io.*,java.lang.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Project Details</title>
<!--
 @author Thejaswi S
 -->
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

<jsp:include page="../common_ui/start.jsp"></jsp:include>
<div>
<c:if test="${not empty projectdetails}">

 <c:forEach items="${projectdetails}" var="pdetails" >
 

<div class="container">
 <div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="row user-row">
        <center><strong>Assign Project Information</strong></center><br> 
            
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${pdetails.projectManagerImage}"width="50px"
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
                                     src="${pdetails.projectManagerImage}"
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
                                     <dd>${pdetails.projectId}</dd>
                                     
                                     <dt>Project Title</dt>
                                     <dd>${pdetails.projectTitle}</dd>
                                     
                                     <dt>Project Description</dt>
                                     <dd> ${pdetails.projectDescription}</dd>
                                     
                                     <dt>Expected Start Date </dt>
                                     <dd>${pdetails.expectedStartDate}</dd>
                                     
                                     <dt>Expected End Date</dt>
                                     <dd> ${pdetails.expectedEndDate}</dd>
                                     
                                     <dt>ProjectCompletionPercentage : </dt>
                                     <dd>${pdetails.projectCompletionPercentage}</dd>
   
                                    
                                      
                                      <dt>ProjectManagerName : </dt>
                                     <dd>${pdetails.projectManagerName}</dd>
                                    
                                   <dt>ProjectManagerEmail : </dt>
                               <dd>${pdetails.projectManagerEmail}</dd>
                               
                                <dt>ProjectManagerMobileNo : </dt>
                               <dd>${pdetails.projectManagerMobileNo}</dd>
                                   
                                <dt>ProjectManagerGender : </dt>
                               <dd>${pdetails.projectManagerGender}</dd>
                               
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>Project Manager</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                          <td>Project Id:</td>
                                          <td>${pdetails.projectId}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Title</td>
                                          <td>${pdetails.projectTitle}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Description</td>
                                          <td> ${pdetails.projectDescription}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected Start Date</td>
                                          <td>${pdetails.expectedStartDate}</td>
                                    </tr>
                                    <tr>
                                          <td>Expected End Date</td>
                                          <td> ${pdetails.expectedEndDate}</td>
                                    </tr>
                                    <tr>
                                          <td>ProjectCompletionPercentage : </td>
                                          <td> ${pdetails.projectCompletionPercentage}</td>
                                    </tr>
                                    
                                    
                                    <tr>
                                        <td>Project Manager Name:</td>
                                        <td>${pdetails.projectManagerName}</td>
                                    </tr>
                                    <tr>
                                    <td>ProjectManagerEmail : </td>
                                    <td>${pdetails.projectManagerEmail}</td>
                                    </tr>

                                    <tr>
                                    <td>ProjectManagerMobileNo : </td>
                                    <td>${pdetails.projectManagerMobileNo}</td>
                                    </tr>
                                    
                                    <tr>
                                    <td>ProjectManagerGender : </td>
                                    <td>${pdetails.projectManagerGender}</td>
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