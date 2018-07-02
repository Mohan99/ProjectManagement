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
    width:300px;    
}
.dropdown-menu>li>a {
    color:#428bca;
}
.dropdown ul.dropdown-menu {
    border-radius:4px;
    box-shadow:none;
    margin-top:20px;
    width:300px;
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
var prev;
function displayNotification(mid){
	//alert(prev);
	if( prev !=null){
	$(prev).hide();
	}
	$("#display123"+mid).show();
	
	prev="#display123"+mid;
	//alert("display123"+mid);
	return false;
}
$(document).ready(function(){
	$.ajax({
		"url":"<%=application.getContextPath()%>/NotificationRegardingAction",
		"success":function(data){
			
			alert(data);
			
			 $('#dev-asigned-task-notifications').html("");
			 $('#d1').html("");
			 $.each(data,function(ind,obj){
				
			/* alert(obj.moduleTaskId.taskDescription);
			alert(obj.moduleTaskId.taskTitle);
			alert(obj.moduleTaskId.projectModuleId.moduleDescription)
		  */
		  
		  
		  $('#dev-asigned-task-notifications').append("<a href='#' onclick='return displayNotification("+obj.moduleTaskId.projectModuleId.projectModuleId+")'> Module notification"+obj.moduleTaskId.projectModuleId.projectModuleId+"</a>");
		          $('#d1').append("<div style='display:none' id='display123"+obj.moduleTaskId.projectModuleId.projectModuleId+"'><li > "+
		        		  "<a href='#'>"+
		        		  "<span class='glyphicon glyphicon glyphicon-envelope pull-right'></span>"+
		        		  /* "<label>PROJECTID: "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectId+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT TITLE : "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectTitle+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT DESCRIPTION : "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectDescription+
		        		  "</label>"+
		        		   "<br>"+ 
		        		   "<label>MODULE DESCRIPTION : "+
			        		  obj.moduleTaskId.projectModuleId.moduleDescription+
			        		  "</label>"+
			        		   "<br>"+
		        		  "<label>TASK TITLE : "+
		        		  obj.moduleTaskId.taskTitle+
		        		  "</label>"+
		        		   "<br>"+
		        		  "<label>TASK DESCRIPTIN: "+
		        		  obj.moduleTaskId.taskDescription+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT MODULE ID: "+
		        		  obj.moduleTaskId.projectModuleId.projectModuleId+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label> MODULE TITLE: "+
		        		  obj.moduleTaskId.projectModuleId.moduleTitle+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>STATUSID : "+
		        		  obj.approvalStatusId.statusId+
		        		  "</label>"+
		        		   "<br>"+
		        		   "<label>STATUS : "+
			        		  obj.approvalStatusId.status+
			        		  "</label>"+
			        		   "<br>"+
			        		   "<label>DEVELOPER TASK ID : "+
				        		  obj.developerTaskId+
				        		  "</label><div>"+
				        		   "<br>"+  */
		        		  /* "<label>TASK DESCRIPTIN: "+
		        		  obj.moduleTaskId.taskDescription+
		        		  "</label>"+
		        		  "<br>"+ */
		        		  /* "<label>PROJECT DESCRIPATION: "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectDescription+
		        		  "</label>"+
		        		  "<br>"+ */
		        		  
		        		 
		        		  
		        		  
		        		  
		        		  "'</a>"+
		        			 
		        		/* obj.moduleTaskId.projectModuleId.moduleDescription+ */
		        		 
			        		  
		        		  "</li>"+
		        		  " <li class='divider'>"+
		        		  +"<a href='#'><span class='glyphicon glyphicon glyphicon-envelope pull-right'></span></li>");
		          
			});
			
		},
		"error":function(){}
		
	});
	
	
	
});
</script>


</head>
<body>  

    <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Assigned Task <span class="glyphicon glyphicon-user pull-right"></span></a>
          <ul class="dropdown-menu" id='dev-asigned-task-notifications'>
         <!--  dev-asigned-task-notifications  --> <li><a href="#">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">Messages <span class="badge pull-right"> 42 </span></a></li>
            <li class="divider"></li>
            <li><a href="#">Favourites Snippets <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
            <li class="divider"></li>
            
            <li><a href="#">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a></li>
          </ul>
        </li>
      </ul>
      <div id='d1'></div>
</body>
</html>