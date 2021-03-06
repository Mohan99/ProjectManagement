

<!-- @ author Rajkishore-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>View Details</title>

</head>
<style type="text/css">

element.style {
    width: 700px;
}
</style>
<body>


<jsp:include page="../common_ui/start.jsp"></jsp:include>

<c:if test="${beans ne null }">

<div class='row'>


 
 
 		<div class="col-md-12">
				<h2 style="color: red">Task Details Information</h2>
	<div class="panel panel-default" style="background-color: #f2f2f2;">
	<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1">Project Information</a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse" >
								<div class='container well form-horizontal' style='width: 100%;'>
									<div class="col-md-8" style='float: left; width: 900px;'>
										<table>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Project Name:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${beans.projectDto.projectTitle}"></c:out></label></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Project Description:
												</td>
												<td style='font-size: 20px';><c:out
														value="${beans.projectDto.projectDescription}"></c:out></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
	</div>
	
	             
							<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse2">Project Manager Information</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse">
							<div class='container well form-horizontal' style='width: 100%;'>
								<div style='float: left; width: 700px;'>
									<div style='float: right; width: 300px'>
										<img src="${beans.pmImage}" width='200px' height='150px' />
									</div>
									<table>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManager:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.projectManager.firstName}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
											</td>
											<td style='font-size: 20px';><c:out
													value="${beans.projectManager.email}"></c:out></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.projectManager.mobileNo}"></c:out></label></td>
										</tr>
										
										
									</table>
								</div>
							</div>
						</div>
                       </div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3">Module Information</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse">
								<div class='container well form-horizontal' style='width: 100%;'>
									<div style='float: left; width: 700px;'>
										
										<table>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Module Name:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${beans.projectModuleDto.moduleTitle}"></c:out></label></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ModuleDescription:
												</td>
												<td style='font-size: 20px';><c:out
														value="${beans.projectModuleDto.moduleDescription}"></c:out></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
							</div>
					<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse4">Team Lead Information</a>
								</h4>
							</div>
		     
		      
						<div id="collapse4" class="panel-collapse collapse">
							<div class='container well form-horizontal' style='width: 100%;'>
								<div style='float: left; width: 700px;'>
									<div style='float: right; width: 300px'>
										<img src="${beans.tlImage}" width='200px' height='150px' />
									</div>
									<table>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>TeamLeader:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.teamLeader.firstName}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
											</td>
											<td style='font-size: 20px';><c:out
													value="${beans.teamLeader.email}"></c:out></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.teamLeader.mobileNo}"></c:out></label></td>
										</tr>
										
										
									</table>
								</div>
							</div>
						</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse5">Task Information</a>
								</h4>
							</div>
							<div id="collapse5" class="panel-collapse collapse">
								<div class='container well form-horizontal' style='width: 100%;'>
								<div style='float: left; width: 700px;'>
									
										<table>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Task Name:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${beans.moduleTaskDto.taskTitle}"></c:out></label></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>TaskDescription:
												</td>
												<td style='font-size: 20px';><c:out
														value="${beans.moduleTaskDto.taskDescription}"></c:out></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
							</div>
					<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse6">Developer Information</a>
								</h4>
							</div>
		
						<div id="collapse6" class="panel-collapse collapse">
							<div class='container well form-horizontal' style='width: 100%;'>
								<div style='float: left; width: 700px;'>
								
								<c:choose>
								<c:when test="${beans.developer.firstName ne null || ' '}">
									<div style='float: right; width: 300px'>
										<img src="${beans.dImage}" width='200px' height='150px' />
									</div>
									<table>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Developer:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.developer.firstName}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
											</td>
											<td style='font-size: 20px';><c:out
													value="${beans.developer.email}"></c:out></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${beans.developer.mobileNo}"></c:out></label></td>
										</tr>
										
										
									</table>
									</c:when>
							<c:otherwise>
				     	   <div style='float: left; width: 300px'><h3 style="color: red">Developer Task not Assigned</h3></div>
				        	</c:otherwise>
				          </c:choose>
								</div>
							</div>
						</div>
</div>

          
<div style="margin-left: 42%;margin-bottom: 3%">

<a href="<%=request.getContextPath()%>/ViewDeveloperTaskAction" class="btn btn-info btn-lg" title="Back to View Task">
          <span class="glyphicon glyphicon-arrow-left"></span> Back
        </a>
	
				
          </div>
          
          
</div>  
        
          </div>
         
          
</div>



<jsp:include page="../common_ui/end.jsp"></jsp:include>

 




</c:if>
</body>

</html>