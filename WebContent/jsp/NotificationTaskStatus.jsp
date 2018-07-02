<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/bootstrap.css">

<link rel="stylesheet" href="<%=application.getContextPath()%>/css/bootstrap-theme.css">
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/bootstrap.js"></script>
<style type="text/css">

body {
    background:#f0f0f0;
}
.nav {
    left:50%;
    margin-left:-150px;
    top:50px;
    position:absolute;
}
.nav>li>a:hover, .nav>li>a:focus, .nav .open>a, .nav .open>a:hover, .nav .open>a:focus {
    background:#fff;
}
.dropdown {
    background:#fff;
    border:1px solid #ccc;
    border-radius:4px;
    width:400px;    
}
.dropdown-menu>li>a {
    color:#428bca;
}
.dropdown ul.dropdown-menu {
    border-radius:4px;
    box-shadow:none;
    margin-top:20px;
    width:400px;
}
.dropdown ul.dropdown-menu:before {
    content: "";
    border-bottom: 10px solid #fff;
    border-right: 10px solid transparent;
    border-left: 10px solid transparent;
    position: absolute;
    top: -10px;
    right: 16px;
    z-index: 10;
}
.dropdown ul.dropdown-menu:after {
    content: "";
    border-bottom: 12px solid #ccc;
    border-right: 12px solid transparent;
    border-left: 12px solid transparent;
    position: absolute;
    top: -12px;
    right: 14px;
    z-index: 9;
}
</style>
<script type="text/javascript">

function displayNotification(mid){
	
	$("#display123").Toggle();
	return true;
}

$(document).ready(function(){
	$.ajax({
		"url":"<%=application.getContextPath()%>/NotificationTaskServlet",
	
		"success":function(data){
			
			alert(data);
			
			 $('#dev-asigned-task-notifications').html("");
			 
			$.each(data,function(ind,obj){
				$('#dev-asigned-task-notifications').append("<div id='s' style='margin-left:20px;margin-top:10px;' ><li > <a href='<%=application.getContextPath()%>/taskNotificationDetailsServlet?taskId="+obj.developerTaskId.developerTaskId+"'> DeveloperTaskId:"+obj.developerTaskId.developerTaskId+" belongs to TaskTitle:"+obj.developerTaskId.moduleTaskId.taskTitle+" on UpdationDate:"+obj.updationDate+" is assigned to you</a></div>");
			
		    	});  //each
			
		},  //success
		
		"error":function(){}
		
	});  //ajax
	
});  //document

</script>

</head>
<body>    
           <ul class="nav navbar-nav">
            <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Notification Task Status <span class="glyphicon glyphicon-user pull-right"></span></a>
          <ul class="dropdown-menu" id='dev-asigned-task-notifications'>
            <li><a href="#">moduleTaskId <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">taskTitle <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">taskDescription <span class="badge pull-right"> 42 </span></a></li>
            <li class="divider"></li>
            <li><a href="#">developerTaskId <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
            <li class="divider"></li>
            
            <li><a href="#">taskStatusId <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
            <li class="divider"></li>
            
            <li><a href="#">statusInfo <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
            <li class="divider"></li>
            
            <li><a href="#">updationDate <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
          </ul>
        </li>
      </ul>
</body>
</html>