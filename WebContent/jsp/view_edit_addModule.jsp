<!--@author pavan kumar y  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>

<!-- ------------------------------------- -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>viewModule | PMM</title>

</head>
<body id="div1">
<jsp:include page="../common_ui/start.jsp"></jsp:include>
	
	<div class="row"  >

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
						<button type="button" class="btn btn-default" data-dismiss="modal"
							onclick="clearResponseMsg();" id="btnClear">Ok</button>
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
						<button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
					</div>
				</div>

			</div>
		</div>
		
		
		
		<!--  <div class="row" style="text-align: right;">

			Trigger the modal with a button
 			<div class="col-md-12">


				<button type="button" class="btn btn-info" data-toggle="modal"
					onclick="onClickAddProject();" data-target="#myAddModal">Add
					Module</button>
				<hr />
			</div>
		</div>  -->
		
		
		<div id="msg"></div>
	
			<c:if test="${result ne null }" var="msg">
			<div class="alert alert-success alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
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
		
		
		

		<div class="table-responsive" >
			<table class="table ">
				<table class="table table-bordered rowcolor " id="example"
					class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>MODULE TITLE</th>
							<th>MODULE REFERENCE DCUMENT</th>
							<th>START DATE</th>
							<th>END DATE</th>
							<th>COMPLETION PERCENTAGE</th>
							<th>STATUS</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody id="view" class="alter_color">
						<c:forEach var="viewModule" items="${sessionScope.viewModules}">
							<tr>									
												
								<td><c:out value="${viewModule.moduleTitle}"></c:out></td>
						  <c:choose>
                          <c:when test="${viewModule.documentNameWithExtension ne null || ' '}">
                           <td>
                          <a href="DownloadModuleRefDocAction?pId=${viewModule.projectModuleId}">
							${viewModule.documentNameWithExtension}</a>
						 </td>
						  </c:when>	
						 <c:otherwise>
						     <td><h5 style="color:blue">no document</h5></td>
						 </c:otherwise>	
										
							</c:choose>
						 
						 
						 							 			
								
								<td><fmt:formatDate pattern="MM/dd/yyyy"
										value="${viewModule.startDate}" /></td>
								<td><fmt:formatDate pattern="MM/dd/yyyy"
										value="${viewModule.endDate}" /></td>
								<td><c:out
										value="${viewModule.moduleCompletionPercent}"></c:out></td>
						         <td><c:out value="${viewModule.statusId.status}"></c:out></td>


								<td>	
									<a href="<%=application.getContextPath()%>/viewmoduleinfo?mid=${viewModule.projectModuleId}" class="btn btn-success" role="button" title="Edit Record">view</a>
									
									<a href="<%=application.getContextPath()%>/GetModuleDataForEdit?mid=${viewModule.projectModuleId}" class="btn btn-info" role="button" title="Edit Record">Edit</a>
										
									<input class="btn btn-danger" 
									moduleId='${viewModule.projectModuleId}' type="button" onclick='deleteValue(this);'
									data-toggle="modal" data-target="#myDeleteModal" value="Remove" /></td>

 							</tr>
						</c:forEach>

					</tbody>
				</table>
			</table>

	

			<%--  <input class="btn btn-primary" id="btnedit"
									onclick='editVal(this);' type="button" name="edit"
									moduleId='${viewModule.projectModuleId}'
									moduleTitle='${viewModule.moduleTitle}'
									moduleDescription='${viewModule.moduleDescription}'
 									refDocument='${viewModule.projectReferenceDocument}' 
									startDate='${viewModule.startDate}'
									completionpercentage='${viewModule.moduleCompletionPercent}'
									endDate='${viewModule.endDate}'
									status='${viewModule.statusId.statusId}' value="Edit" /> --%>
			 
			<!-- This Modal For Add Record...
			Modal -->
				<div id="myAddModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					Modal content
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add Module Details</h4>
						</div>
						<div class="modal-body">


							<div class="container">
								<form class="form-horizontal" role="form" action="">
									<input type="hidden" name="moduleid" id="addmoduleid" />
									<div class="form-group">
										<label class="control-label col-sm-2">ModuleTitle:</label>
										<div class="col-sm-3">
											<input type="text" name="txttitle" value="" id="addtitle"
												class="form-control" onblur="editValidation();" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ModuleDescription
											:</label>
										<div class="col-sm-3">
											<input type="text" name="txtdescription" value=" " id="adddescription"
												 onblur="editValidation();"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ReferenceDocument:</label>
										<div class="col-sm-3">
											<input type="file" name="txtdoc" value=" " id="adddoc"
												onblur="editValidation();" class="form-control"
												id="addlast_name_Id" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2">StartDate:</label>
										<div class="col-sm-3">
											<input type="text" name="txtsdate" id="addsdate"
												placeholder="mm/dd/yyyy" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">EndDate:</label>
										<div class="col-sm-3">
											<input type="text" name="txtedate" id="addedate"
												placeholder="mm/dd/yyyy" class="form-control" />
										</div>
									</div>
									
							</div>

							<div class="modal-footer">
								<input type="button" class="btn btn-success" value="Update"
									data-dismiss="modal" onclick="btnSub();"
									data-target="#edmsgModal" data-toggle="modal" /> &nbsp;&nbsp;
								<button type="reset" class="btn btn-danger" data-dismiss="modal">Cancel</button>
							</div>
							</form>
						</div>

					</div>

				</div>

			</div> 
			
			

		</div><!-- This Modal For Edit Record... -->
			<!-- Modal -->
			<div id="myEditModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Edit Module Details</h4>
						</div>
						<div class="modal-body">

							<form class="form-horizontal" method="post" role="form"
								enctype="multipart/form-data" name="form1" action=""
								id="fileForm">
								<div class="container">

									<input type="hidden" name="moduleid" id="moduleid" />
									<div class="form-group">

										<label class="control-label col-sm-2">ModuleTitle:</label>
										<div class="col-sm-3">
											<input type="text" name="txttitle" value="" id="title"
												class="form-control" onblur="editValidation();" />
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">ModuleDescription
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
											<input type="file" name="txtdoc" value=" " id="doc"
												onblur="editValidation();" class="form-control"
												id="last_name_Id" />
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
										
								</div>


								<div class="modal-footer">
									<input type="button" class="btn btn-success" value="Update"
										data-dismiss="modal" onclick="btnEditProject();"
										data-target="#edmsgModal" data-toggle="modal" /> &nbsp;&nbsp;
									<button type="reset" class="btn btn-danger"
										data-dismiss="modal">Cancel</button>
								</div>
							</form>
						</div>
					</div>

				</div>

			</div>

		</div>
		
		<div id="edit"></div>
			<!-- This Modal For Delete Record...
			Modal -->
			<div class="modal fade" id="myDeleteModal">
				<div class="modal-dialog">
					Modal content
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Delete Record</h4>
						</div>
						<div class="modal-body">
							<p>Are You Sure... Do You Want to Delete This Records</p>
						</div>
						<form action="">
							<input type="hidden" value="" name="txtprojectId"
								id="delmoduleId" />
							<div class="modal-footer">
								<input type="button" class="btn btn-danger" value="Ok"
									onclick="btnDeleteValue();" data-dismiss="modal"
									data-target="#edmsgModal" data-toggle="modal" />
								<button type="button" class="btn btn-success"
									data-dismiss="modal">Cancel</button>
							</div>
						</form>
					</div>

				
			</div>

		</div>


	
	
	
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
	
	
	
	
<!-- Loader style  -->
<link href="<%=request.getContextPath()%>/css/preloader_Project.css"
	type="text/css" rel="stylesheet" />
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/projectTable.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/jquery-ui.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/css/dataTables.bootstrap.min.css">


<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>

	rel="stylesheet">
<script src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/jquery.dataTables.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/java_script/dataTables.bootstrap.min.js" />
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>



<script
	src="<%=request.getContextPath()%>/java_script/DeleteModule.js"></script>

	
<script
	src="<%=request.getContextPath()%>/java_script/viewModuleInfo.js"></script>
	
	
	
	
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

		/* datepicker for add module */
		<script type="text/javascript">
		$(function() {
			$("#addsdate").datepicker({
				numberOfMonths : 1,
				onSelect : function(selected) {
					var dt = new Date(selected);
					dt.setDate(dt.getDate() + 1);
					$("#addedate").datepicker("option", "minDate", dt);
				}
			});
			$("#addedate").datepicker({
				numberOfMonths : 1,
				onSelect : function(selected) {
					var dt = new Date(selected);
					dt.setDate(dt.getDate() - 1);
					$("#addsdate").datepicker("option", "maxDate", dt);
				}
			});
		});
	</script>
</body>
</html>
