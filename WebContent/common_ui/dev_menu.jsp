<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value='<%=application.getContextPath()%>'></c:set>


<!-- navigation bar -->
<div class="nav-side-menu">
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">

                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Services <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <!-- <li>View Report</li> -->
                  <li><a href="${path }/ViewDeveloperTaskAction">View Task</a></li>
                  
                  <li><a href="${path }/jsp/taskReport.jsp">View Task Reports</a></li>
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
                

            </ul>
     </div>
     </div>
