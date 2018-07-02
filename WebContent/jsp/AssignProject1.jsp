<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AssignProject</title>
<!--
 @author Thejaswi S
 -->
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
    width:350px;    
}
.dropdown-menu>li>a {
    color:#428bca;
}
.dropdown ul.dropdown-menu {
    border-radius:4px;
    box-shadow:none;
    margin-top:20px;
    width:350px;
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

</head>

<body>
  <div id='msg'>
         <!--  Admin-asigned-project-notifications  --> 
          </div>
      
 <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Notification For Assign Project <span class="glyphicon glyphicon-user pull-right"></span></a>
          <ul class="dropdown-menu" id='admin-asigned-project-notifications'>
         <!--  Admin-asigned-project-notifications  --> 
         <li><a href="#">Account Settings <span class="glyphicon glyphicon-cog pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">User stats <span class="glyphicon glyphicon-stats pull-right"></span></a></li>
            <li class="divider"></li>
            <li><a href="#">Messages <span class="badge pull-right"> 42 </span></a></li>
            <li class="divider"></li>
            <li><a href="#">Favourites Snippets <span class="glyphicon glyphicon-heart pull-right"></span></a></li>
            <li class="divider"></li>
            
            <li><a href="#">Sign Out <span on class="glyphicon glyphicon-log-out pull-right"></span></a></li>
          </ul>
        </li>
      </ul>


<script type="text/javascript">
$(document).ready(function(){
	
	alert("");
	 $.ajax({ 
		url: "<%=application.getContextPath()%>/NotificationAssignProjecturl",
		success : function(data){
			alert("Hiiii");
			alert(data);
			
					    $('#admin-asigned-project-notifications').html("");
					$.each(data,function(ind,obj){
						alert("teja");
         alert("proj"+obj.projectId);
			 $('#admin-asigned-project-notifications').append("<div id='t'><li><a href='<%=application.getContextPath()%>/NotificationAssignProject1?projectId="+obj.projectId+"'>Admin projectId:"+obj.projectId+" ProjectTitle:"+obj.projectTitle+" assigned to ProjectManager</a></div>");
	    				          

					});

		}, //function
	       "error":function(){}
		
		
	});//ajax
		
	
});//doc
</script>

</body>
</html>