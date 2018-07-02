<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value='<%=application.getContextPath()%>'></c:set>
<!-- navigation bar -->
<div class="nav-side-menu">
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">

                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fa fa-gift fa-lg"></i> Task Management <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="${path}/jsp/addTask.jsp">Add Task</a></li>
                    <li><a href="${path }/viewTaskAction">View/Edit/Remove Task</a></li>
                    
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Services <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li><a href="${path}/jsp/TLModuleReport.jsp">View Module Report</a></li>
                  <li>  <a href="${path}/jsp/assignTask.jsp">  Assign Task to Developer</a></li>
                  <li><a href="${path }/jsp/modulelist.jsp">View Modules</a></li>
                  
                </ul>

                 <li data-toggle="collapse" data-target="#profile" class="collapsed">
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Profile<span class="arrow"></span>
                  </a>
                  </li>
                  
                  <ul class="sub-menu collapse" id="profile">
                  <li><a href="${path }/ViewProfileAction">View Profile</a></li>
                  <li><a href="${path }/common_ui/change_pass.jsp">Change Password</a></li>
                </ul>
                

                 <!-- <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Users
                  </a>
                </li> -->
            </ul>
     </div>
     </div>
     
