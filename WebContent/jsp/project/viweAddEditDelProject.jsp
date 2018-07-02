<!-- @author Raghav -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="err.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/style.css">

<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/css/projectTable.css" />
	
<link rel="stylesheet"
		href="<%=application.getContextPath()%>/css/dataTables.bootstrap.min.css">
	
	<link
		href="<%=application.getContextPath()%>/css/jquery-ui-1.10.4.css"
		rel="stylesheet">

	
<!-- Loader style  -->
<link href="<%=request.getContextPath()%>/css/preloader_Project.css"
	type="text/css" rel="stylesheet" />

<!-- ------------------------------------- -->

<title>viewProject | PMM</title>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body id="div1">
<jsp:include page="../../common_ui/start.jsp"></jsp:include>

			<!-- Modal -->
			<div id="msgModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Response Message</h4>
						</div>
						<div class="modal-body">

							<div class="loader" id="anim" style="display: none"></div>
							<p id="Vmsg" style="color: green;"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="clearResponseMsg();" id="btnClear">Ok</button>
						</div>
					</div>

				</div>
			</div>

			<!-- Modal -->
			<div id="edmsgModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Edit Delete Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Response Message</h4>
						</div>
						<div class="modal-body">

							<div class="loader" id="anim" style="display: none"></div>
							<p id="edVmsg" style="color: green;"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Ok</button>
						</div>

					</div>
				</div>
			</div>

			<div class="table-responsive" >

				<table class="table ">
					<table class="table table-bordered rowcolor " id="example"
						class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>PROJECT TITLE</th>
								<!-- <th>PROJECT DESCRIPTION</th> -->
								<th>REFERENCE DCUMENT</th>
								<th>CLIENT LOCATION</th>
								<!-- <th>EXPECTED START DATE</th>
							<th>EXPECTED END DATE</th> -->
								<th>PERCENTAGE</th>
					 			<th>PROJECT STATUS</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody id="view" class="alter_color">


							<c:forEach var="viewProject" items="${sessionScope.viewProjects}">

								<tr>
									<td><c:out value="${viewProject.projectTitle}"></c:out></td>
									<%-- <td><c:out value="${viewProject.projectDescription}"></c:out></td>
								 --%>
									<td><a
										href="DownloadProjectFileAction?pId=${viewProject.projectId}">
											${viewProject.documetnNameWithExtension}</a></td>
									<td><c:out
											value="${viewProject.clientLocationId.addressId.address}"></c:out></td>
									<%-- 		<td><fmt:formatDate pattern="yyyy/MMM/dd"
										value="${viewProject.expectedStartDate}" /></td>
								<td><fmt:formatDate pattern="yyyy/MMM/dd"
										value="${viewProject.expectedEndDate}" /></td>
						 --%>
									<td><c:out
											value="${viewProject.projectCompletionPercentage}"></c:out></td>
										<td><c:out value="${viewProject.status.status}"></c:out></td>

									<td><input class="btn btn-success" id="btnview"
										onclick='viewVal(this);' type="button" name="view"
										data-toggle="modal" projectId='${viewProject.projectId}'
										value="View" /> <input class="btn btn-primary" id="btnedit"
										onclick='editVal(this);' type="button" name="edit"
										data-toggle="modal" data-target="#myEditModal"
										projectId='${viewProject.projectId}'
										projectTitle='${viewProject.projectTitle}'
										projectDescription='${viewProject.projectDescription}'
										refDocument='${viewProject.projectReferenceDocument}'
										clientLocation='${viewProject.clientLocationId.addressId.address}'
										startDate='${viewProject.expectedStartDate}'
										endDate='${viewProject.expectedEndDate}'
										completionPercentage='${viewProject.projectCompletionPercentage}'
										docExtension='${viewProject.documetnNameWithExtension}'
										status='${viewProject.status.statusId}' value="Edit" /> <input
										class="btn btn-danger" onclick='deleteVal(this);'
										projectId='${viewProject.projectId}' type="button"
										data-toggle="modal" data-target="#myDeleteModal"
										value="Delete" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</table>


				<!-- This Modal For Edit Record... -->
				<!-- Modal -->
				<div id="myEditModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Edit Project Details</h4>
							</div>
							<div class="modal-body">

								<form class="form-horizontal" method="post"
									enctype="multipart/form-data" name="form1" action=""
									id="fileForm">
									<div class="container">

										<input type="hidden" name="projectid" id="projectid" />
										<div class="form-group">

											<label class="control-label col-sm-2">ProjectTitle:</label>
											<div class="col-sm-3">
												<input type="text" name="txttitle" value="" id="title"
													class="form-control" onblur="editValidation();" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">ProjectDescription
												:</label>
											<div class="col-sm-3">
												<input type="text" name="txtdescription" value=" "
													id="description" onblur="editValidation();"
													class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">ReferenceDocument:</label>
											<div class="col-sm-3">
												<input type="file" name="txtdoc" value=" " id="refdoc"
													onblur="editValidation();" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">ClientLocation:</label>
											<div class="col-sm-3">
												<input type="text" name="txtloc" value="" id="loc"
													class="form-control" onblur="editValidation();" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">StartDate:</label>
											<div class="col-sm-3">
												<input type="text" name="txtsdate" id="sdate"
													placeholder="mm/dd/yyyy" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">EndDate:</label>
											<div class="col-sm-3">
												<input type="text" name="txtedate" id="edate"
													placeholder="mm/dd/yyyy" class="form-control" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">CompletionPercentage:</label>
											<div class="col-sm-3">
												<input type="text" name="txtpercentage" value=""
													id="percentage" class="form-control"
													onblur="editValidation();" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2">Status:</label>
											<div class="col-sm-3">
												<input type="text" name="txtstatus" value="" id="status"
													class="form-control" onblur="editValidation();" />
											</div>
										</div>
									</div>


									<div class="modal-footer">
										<input type="button" class="btn btn-success" value="Update"
											data-dismiss="modal" onclick="btnEditProject();"
											data-target="#edmsgModal" data-toggle="modal" />
										&nbsp;&nbsp;
										<button type="reset" class="btn btn-danger"
											data-dismiss="modal">Cancel</button>
									</div>
								</form>
							</div>
						</div>

					</div>

				</div>

			</div>
			<!-- This Modal For Delete Record... -->
			<!-- Modal -->
			<div class="modal fade" id="myDeleteModal">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Delete Project</h4>
						</div>
						<div class="modal-body">
							<p>Are You Sure... Do You Want to Delete This Project</p>
						</div>
						<form action="">
							<input type="hidden" value="" name="txtprojectId"
								id="delProjectId" />
							<div class="modal-footer">
								<input type="button" class="btn btn-danger" value="Ok"
									onclick="btnDelete();" data-dismiss="modal"
									data-target="#edmsgModal" data-toggle="modal" />
								<button type="button" class="btn btn-success"
									data-dismiss="modal">Cancel</button>
							</div>
						</form>
					</div>

				</div>
			</div>




<jsp:include page="../../common_ui/end.jsp"></jsp:include>
<script
		src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>

	<script type="text/javascript"
		src="<%=application.getContextPath()%>/java_script/jquery.dataTables.min.js"></script>

	<script type="text/javascript"
		src="<%=application.getContextPath()%>/java_script/dataTables.bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/java_script/edit_project.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/java_script/edit_project.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/add_edit_delete_Project.js""></script>

	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#example').DataTable(
							{
								"pagingType" : "full_numbers",
								"lengthMenu" : [ [ 3, 5, 10, 25, 50, -1 ],
										[ 3, 5, 10, 25, 50, "All" ] ],
								"pageLength" : 5
							});
				});
	</script>

	<script
		src="<%=request.getContextPath()%>/java_script/add_edit_delete_Project.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#sdate").datepicker({
				numberOfMonths : 1,
				onSelect : function(selected) {
					var dt = new Date(selected);
					dt.setDate(dt.getDate() + 1);
					$("#edate").datepicker("option", "minDate", dt);
				}
			});
			$("#edate").datepicker({
				numberOfMonths : 1,
				onSelect : function(selected) {
					var dt = new Date(selected);
					dt.setDate(dt.getDate() - 1);
					$("#sdate").datepicker("option", "maxDate", dt);
				}
			});
		});
	</script>
</body>
</html>
