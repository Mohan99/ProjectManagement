
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty roleID}">



<style>

.header-menu{
position: fixed;
top:80px;
width:100%;
z-index: 500;
}
.tm-padd{
padding: 30px;
}
</style>

	<div class='row nav-margin header-menu'>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   

 	<div class='row'>
<div class='col-md-2'>

 <ul class="nav navbar-nav">
      <li class="active">
  		<a href="#" title="home"><i class="fa fa-home"></i></a> </li>
     
     </ul>
</div>
 	
<div class='col-md-6'>
</div>
 	
<div class='col-md-4'>    
    <ul class="nav navbar-nav navbar-right">
   
   
  	<%--ADMIN NOTIFICATIONS --%>
   <c:if test="${roleID eq 1 }">
<!-- ADMIN PROJECT STATUS -->
<script type="text/javascript" src="<%=application.getContextPath() %>/java_script/Noti_teja_Admin_Proj_status.js"></script>
   
  		<!-- ADMIN PROJECT STATUS -->
  		  <li>
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span   id='project-status-notifications_count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu"  id='project-status-notifications'>
          <li><a href="#">ADMIN PROJECT STATUS</a></li>
       
        </ul>
  		
  		</li>
  		
   
   
   
   </c:if>

<%--PM NOTIFICATIONS --%>
   <c:if test="${roleID eq 2 }">
<!-- PM PROJECTS ASSIGNED -->
<script type="text/javascript" src="<%=application.getContextPath() %>/java_script/noti_PM_assigened_projects_teja.js"></script>
    <!-- project Manager NOTIFICATIONS ABOUT ASSIGNED PROJECT -->
     <li>
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span   id='admin-asigned-project-notifications_count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu"  id='admin-asigned-project-notifications'>
          <li><a href="#">PM ASSIGNED PROJECTS</a></li>
       
        </ul>
  		
  		</li>
   <!-- MODULE STATUS PAWAN -->
   
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/NotificationRegardingtotaskPawan.js">
</script>
      <li>
  		<a href="#" title="message" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i>  <span id='pawan-noti'>0</span><span class="caret"></span></a>
  		
  		 <ul class="dropdown-menu" id='pawan-noti-content'>
       
        </ul>
  		</li>
   
   
   
   </c:if>

<%--TL NOTIFICATIONS --%>
   <c:if test="${roleID eq 3 }">
<!-- TEAMLEAD ASSIGNED MODULE NOTI -->
<script type="text/javascript" src="<%=application.getContextPath() %>/java_script/Notification_assignedModule_TL_TEJA.js"></script>

   <!-- TL ASSIGNED MODULE TEJA --> 
   
   <li>
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span   id='projectmanager-asigned-module-notifications_count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu"  id='projectmanager-asigned-module-notifications'>
          <li><a href="#">TL ASSIGNED MODULES</a></li>
       
        </ul>
  		
  		</li>


   
<!-- NOTIFICATION TASK STATUS PRAVEEN-->
   <script type="text/javascript" src="<%=application.getContextPath() %>/java_script/NotiTaskStatusPraveen.js"></script>
   <li>
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span   id='praveen-noti-count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu"  id='praveen-noti-content'>
          <li><a href="#">PLEASE WAIT</a></li>
       </ul>
  		
  		</li>
  		
  		
  		
   <!-- ANUJ TEAM LEAD VIEW ACCEPTED OR REJECTED TASK NOTI -->
   	
<!-- Second task for Notification Regarding to Approve or reject -->
<script src="<%=application.getContextPath() %>/java_script/NotificationForDeveloperAboutApproveOrRejectTask_anuj.js"></script>

   	
   	<li style="margin-left:40px;">
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span id='anuj-dt-Approve-or-Reject-count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu" id='anuj-dt-Approve-or-Reject-noti'>
          <li><a href="#">NOT AVAILABLE</a></li>
       
        </ul>
  		
  		</li>
   
   
   
   
   </c:if>

<%--DEV NOTIFICATIONS --%>
   <c:if test="${roleID eq 4 }">
   <!-- // first task for notification regarding Assign TASK -->

<script src="<%=application.getContextPath() %>/java_script/NotificationsforDeveloperAboutAssignedTask_anuj.js"></script>
   
   <!-- // first task -->
      <li style="margin-left:40px;">
    <a href="#" title="notification" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i> <span id='anuj-dt-noti-count'>0</span><span class="caret"></span></a>
  		 <ul class="dropdown-menu" id='anuj-dev-task-noti'>
          <li><a href="#">NOT AVAILABLE</a></li>
       
        </ul>
  		
  		<!-- Approve or reject second task -->
  		</li>
  	
   
   
   
   
   </c:if>
  		
  		
          
     <li class='active'>
  		<a href="<%=application.getContextPath()%>/LogoutAction" title="logout"><i class="fa fa-power-off"></i></a> </i>
  		</li>
    </ul>
  </div>
</div>
</div>

</nav>
</div>
<div class='tm-padd'></div>
</c:if>
