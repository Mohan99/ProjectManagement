<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	

div#task,div#module ,div#project {

	padding:5px;
	margin: 2px;
}


h3,h1{
text-align: center;
}
</style>
<body>
<jsp:include page="../common_ui/start.jsp"></jsp:include>



 
 <c:choose>


		<c:when test="${taskDetails ne null}">
<h1>Notification Regarding Task status</h1>
<div class='row'>

			<div id="project" class='bg-info col-md-4'>
				<h3>Project</h3>
				<table>
					<tr>
						<td>ProjectId :</td>
						<td>${taskDetails.projectId}</td>
					</tr>
					<tr>
						<td>Project Title :</td>
						<td>${taskDetails.projectTitle}</td>
					</tr>
					<tr>
						<td>Project Description :</td>
						<td>${taskDetails.projectDescription}</td>
					</tr>
					<tr>
						<td>Project Completion Percentage :</td>
						<td>${taskDetails.projectCompletionPercentage}</td>
					</tr>
					<tr>
						<td>Project Manager First Name :</td>
						<td>${taskDetails.projMngFirstName}</td>
					</tr>
					<tr>
						<td>Project ManagerLast Name :</td>
						<td>${taskDetails.projMngLastName}</td>
					</tr>
					<tr>
						<td>Project Manager Email :</td>
						<td>${taskDetails.projMngEmail}</td>
					</tr>
					<tr>
						<td>Project  Manager Mobile No :</td>
						<td>${taskDetails.projMngMobileNo}</td>
					</tr>
					<tr>
						<td>Project Manager photo :</td>
						<td><img alt="no profile pic" class="img-circle" src="${taskDetails.projMngImage}" width="100px" height="80px"/> </td>
					</tr>
					
				</table>
			</div>
			
			<div id="module" class='bg-info col-md-3'>
				<h3>Module</h3>
				<table>
					<tr>
						<td>ModuleId :</td>
						<td>${taskDetails.projectModuleId}</td>
					</tr>
					<tr>
						<td>Module Title :</td>
						<td>${taskDetails.moduleTitle}</td>
					</tr>
					<tr>
						<td>Module Description :</td>
						<td>${taskDetails.moduleDescription}</td>
					</tr>
					<tr>
						<td>Module Completion Percentage :</td>
						<td>${taskDetails.moduleCompletionPercentage}</td>
					</tr>
					<tr>
						<td>Team Leader First Name :</td>
						<td>${taskDetails.tlFirstName}</td>
					</tr>
					<tr>
						<td>Team Leader Last Name :</td>
						<td>${taskDetails.tlLastName}</td>
					</tr>
					<tr>
						<td>Team Leader Email :</td>
						<td>${taskDetails.tlEmail}</td>
					</tr>
					<tr>
						<td>Team Leader Mobile No :</td>
						<td>${taskDetails.tlMobileNo}</td>
					</tr>
					<tr>
						<td>Team Leader photo :</td>
						<td><img alt="no profile pic" class="img-circle" src="${taskDetails.tlImage}" width="100px" height="80px"/> </td>
					</tr>
					
				</table>
			</div>

			<div id="task" class='bg-info col-md-4'>
				<h3>Task</h3>
				<table>
					<tr>
						<td>Developer TaskId :</td>
						<td>${taskDetails.developerTaskId}</td>
					</tr>
					<tr>
						<td>Task Title :</td>
						<td>${taskDetails.taskTitle}</td>
					</tr>
					<tr>
						<td>task Description :</td>
						<td>${taskDetails.taskDescription}</td>
					</tr>
					<tr>
						<td>task Completion Percentage :</td>
						<td>${taskDetails.taskCompletionPercentage}</td>
					</tr>
					<tr>
						<td>task Status Info :</td>
						<td>${taskDetails.statusInfo}</td>
					</tr>
					<tr>
						<td>Updation Date :</td>
						<td>${taskDetails.updationDate}</td>
					</tr>
					<tr>
						<td>TaskStatusId  :</td>
						<td>${taskDetails.taskStatusId}</td>
					</tr>
					<tr>
						<td>ModuleTaskId  :</td>
						<td>${taskDetails.moduleTaskId}</td>
					</tr>
					<tr>
						<td>Developer First Name :</td>
						<td>${taskDetails.devFirstName}</td>
					</tr>
					<tr>
						<td> Developer Last Name :</td>
						<td>${taskDetails.devLastName}</td>
					</tr>
					<tr>
						<td>Developer Email :</td>
						<td>${taskDetails.devEmail}</td>
					</tr>
					<tr>
						<td>Developer Mobile No :</td>
						<td>${taskDetails.devMobileNo}</td>
					</tr>
					<tr>
						<td>Developer photo :</td>
						<td><img alt="no profile pic" class="img-circle" src="${taskDetails.devImage}" width="100px" height="80px"/> </td>
					</tr>

				</table>
			</div> 
			
			</div>
		</c:when>
		<c:otherwise></c:otherwise>

	</c:choose>
  <jsp:include page="../common_ui/end.jsp"></jsp:include>
  
	 
	
 
</body>
</html>
