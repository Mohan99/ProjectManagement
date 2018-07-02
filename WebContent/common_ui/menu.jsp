
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value='<%=application.getContextPath()%>'></c:set>
<!-- navigation bar -->
<div class="nav-side-menu">
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">

                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fa fa-gift fa-lg"></i> Project Management <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="${path }/jsp/add_project.jsp">Add Project</a></li>
                    <li><a href="${path }/ViewProjectAction">View/Edit/Remove Project</a></li>
                    
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Services <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li><a href="${path }/jsp/assign_project.jsp">Assign Project to ProjectManager</a></li>
                  <li><a href="${path }/jsp/ProjectReport.jsp">View Report</a></li>
                </ul>


                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-car fa-lg"></i> Client Management <span class="arrow"></span></a>
                </li>
                
                
                <ul class="sub-menu collapse" id="new">
                
                  <li><a href="${path }/jsp/viewClient.jsp">View/Edit Client</a></li>
                 <!--  <li>Edit Client</li>
                  <li>Add Contact Person</li> -->
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
                

                 <li data-toggle="collapse" data-target="#usermenu" class="collapsed">
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Users<span class="arrow"></span>
                  </a>
                </li>
                
                <ul class="sub-menu collapse" id='usermenu'>
                  <li><a href="${path }/jsp/addUserNewCreate.jsp"> Add User</a></li>
                  <li><a href="${path }/jsp/vieweditremoveuser.jsp">View/Edit/Remove User</a></li>
                  <li><a href="${path }/jsp/assignteamleadtopm.jsp">Assign TEAM LEAD to PROJECT MANAGER</a></li>
                  <li><a href="${path }/jsp/assigndeveloperstotl.jsp">Assign Developer to TEAMLEAD</a></li>
               
                </ul>
                
                
            </ul>
     </div>
     </div>
     
     
