<!-- @author Raghav -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="err.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<!-- Loader style  -->
<link href="<%=request.getContextPath()%>/css/preloader_Project.css"
	type="text/css" rel="stylesheet" />

<!-- ------------------------------------- -->

<title>viewManagerProject | PMM</title>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body id="div1">
	<%@include file="../../../common_ui/start.jsp"%>
		
		<div id="msg"></div>
			<c:if test="${result ne null }" >
			<div class="alert alert-success alert-dismissable">
  <a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>
			<%-- 
			<h3 style="color: green; text-align: center;">
				<b>${result}</b>
			</h3> --%>
			
		</c:if>
		<c:remove var='result' />


			<c:if test="${err ne null }" var="msg">
			<div class="alert alert-danger alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${err}
</div>	
</c:if>

		<c:remove var='err'  />
			<div class="table-responsive">
			
					<table class="table table-bordered rowcolor " id="example"
						class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>PROJECT TITLE</th>
								<th>PROJECT DESCRIPTION</th>
								<th>EXPECTED START DATE</th>
								<th>EXPECTED END DATE</th>
								<th>PERCENTAGE</th>
								<!-- <th>PROJECT STATUS</th> -->
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody id="view" class="alter_color">


							<c:forEach var="viewProject" items="${sessionScope.viewProjects}">

								<tr>
									<td><c:out value="${viewProject.projectTitle}"></c:out></td>
									<td><c:out value="${viewProject.projectDescription}"></c:out></td>
									<%-- <td><a
										href="DownloadFileAction?pId=${viewProject.projectId}">
											${viewProject.documetnNameWithExtension}</a></td>
									<td><c:out
											value="${viewProject.clientLocationId.addressId.address}"></c:out></td> --%>
									<td><fmt:formatDate pattern="yyyy/MMM/dd"
											value="${viewProject.expectedStartDate}" /></td>
									<td><fmt:formatDate pattern="yyyy/MMM/dd"
											value="${viewProject.expectedEndDate}" /></td>
									<td><c:out
											value="${viewProject.projectCompletionPercentage}"></c:out></td>
									<%-- <td><c:out value="${viewProject.status.status}"></c:out></td> --%>

									<td><input class="btn btn-block btn-sm btn-info" id="btnview"
										onclick='viewVal(this);' type="button" name="view"
										data-toggle="modal" projectId='${viewProject.projectId}'
										value="View" /> 
										<a href="<%=application.getContextPath()%>/jsp/ProjectStatus.jsp?projectManagerPid=${viewProject.projectId}" class="btn btn-block btn-sm  btn-primary"
										onclick='taskVal(this);' projectId='${viewProject.projectId}'
										type="button" data-toggle="modal" value="Add Status" />UPDATE STATUS</a>
										<a href="<%=application.getContextPath()%>/jsp/AddModule.jsp?projectManagerPid=${viewProject.projectId}" class="btn  btn-block btn-sm btn-success"
										onclick='taskVal(this);' projectId='${viewProject.projectId}'
										type="button" data-toggle="modal" value="Add Module" />Add Module</a></td>
										
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</table>
			</div>



	<%@include file="../../../common_ui/end.jsp"%>
<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/style.css">



	<link href="<%=application.getContextPath()%>/css/jquery-ui-1.10.4.css"
		rel="stylesheet">

	<script
		src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>

	<script type="text/javascript"
		src="<%=application.getContextPath()%>/java_script/jquery.dataTables.min.js"></script>

	<link rel="stylesheet"
		href="<%=application.getContextPath()%>/css/dataTables.bootstrap.min.css">
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/java_script/dataTables.bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/css/projectTable.css" />
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/java_script/edit_project.js"></script>
	
	<script
		src="<%=request.getContextPath()%>/java_script/add_edit_delete_Project.js"></script>
		
		

</body>
</html>
