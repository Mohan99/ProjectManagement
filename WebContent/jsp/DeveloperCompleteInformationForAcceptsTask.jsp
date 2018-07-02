<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
.btn {
    border: none;
    color: white;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
}


 


</style>
</head>
<body>
<jsp:include page="../common_ui/start.jsp"></jsp:include>


<c:if test="${not empty supid}">

<c:forEach var="det1" items="${supid}">
 

<div class='row'>
 <div class=" col-md-12">
        <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="${det1.image}"width="50px"
                     alt="User Pic">
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>Developer  Information</strong><br>
                <span class="text-muted">Developer</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".cyruxx">
                <i class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>
        <div class="row user-infos cyruxx">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Developer information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-thumbnail img-responsiv" width="100px"
                                     src="${det1.image}"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>Developer</strong><br>
                                <dl>
                                     <dt>Project Id</dt>
                                     <dd>${det1.projectId}</dd>
                                     
                                     <dt>Project Title</dt>
                                     <dd> ${det1.projectTitle}</dd>
                                     
                                     <dt>Project Description</dt>
                                     <dd>${det1.projectDescription}</dd>
                                     
                                    <dt>Project Module Id</dt>
                                     <dd>${det1.projectModuleId}</dd>
                                     
                                     <dt> Module Title</dt>
                                     <dd>${det1.moduleTitle}</dd>
                                     
                                      <dt> Module Description</dt>
                                     <dd>${det1.moduleDescription}</dd>
                                     
                                      <dt> Task Title</dt>
                                     <dd>${det1.taskTitle}</dd>
                                     
                                      <dt> Task Description</dt>
                                     <dd>${det1.taskDescription}</dd>
                                    
                                      <dt> StatusId</dt>
                                     <dd>${det1.statusId }</dd>
                                     
                                      <dt> status</dt>
                                     <dd>${det1.status }</dd> 
                                                                          
                                      <dt>Developer TaskId</dt>
                                     <dd>${det1.developerTasKId}</dd>
                                     
                                    <dt>Developer Name:</dt>
                                    <dd>${det1.firstName}</dd>
                                    
                                    <dt>Email:</dt>
                                    <dd>${det1.email}</dd>
                                    
                                    <dt>Mobile No:</dt>
                                    <dd>${det1.mobileNo}</dd>
                                    
                                   
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>Developer Information</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                          <td>Project Id:</td>
                                          <td> ${det1.projectId}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Title</td>
                                          <td> ${det1.projectTitle}</td>
                                    </tr>
                                    <tr>
                                          <td>Project Description</td>
                                          <td>${det1.projectDescription}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td>Project Module Id</td>
                                          <td>${det1.projectModuleId}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td> Module Title</td>
                                          <td>${det1.moduleTitle}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td> Module Description</td>
                                          <td>${det1.moduleDescription}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td> Task Title</td>
                                          <td>${det1.taskTitle}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td>Task Description</td>
                                          <td>${det1.taskDescription}</td>
                                    </tr>
                                    
                                    <tr>
                                          <td> Status Id</td>
                                          <td>${det1.statusId }</td>
                                    </tr>
                                    
                                   <  <tr>
                                          <td> Status </td>
                                          <td>${det1.status }</td>
                                    </tr> 
                                    
                                    <tr>
                                          <td>Developer TaskId </td>
                                          <td>${det1.developerTasKId}</td>
                                    </tr>
                                    <tr>
                                        <td>Developer Name:</td>
                                        <td>${det1.firstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${det1.email}</td>
                                    </tr>
                                    <tr>
                                        <td>Mobile No:</td>
                                        <td>${det1.mobileNo}</td>
                                    </tr>
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                    
                         <%-- <span class="pull-right"> 
                            <button class="btn btn-sm btn-warning" type="button"
                                    data-toggle="tooltip" 
                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i></button> -->
                            <button class="btn btn-sm btn-danger" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Team leader Reject the Task><i class="glyphicon glyphicon-floppy-remove"></i><button class="btn Reject">Reject</button></button> -->
                        </span> --%>
                    </div>
                </div>
            </div>
        </div>




        
        
    </div>
</div>
</c:forEach>
</c:if>
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
    
    panelsButton.click(function() {
  
    			
    		});// second


    		
    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
        
        alert("Accept the task.\n :-)");
    
      

    
 
    
    
});

    		
  	
});			
    		









</script>

</body>
</html>