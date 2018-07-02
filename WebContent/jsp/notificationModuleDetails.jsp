<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Project</title>
</head>
<style>
* {
	padding: 5px;
}

div#module {
	width: 350px;
	height: 450px;
	float: left;
	margin-left: 40px;
	background-color: lightgrey;
}

.img-circle {
	border-radius: 100%;
}

div#project {
	width: 390px;
	height: 450px;
	float: left;
	margin-left: 80px;
	background-color: lightgrey;
}

div#task {
	margin-left: 30px;
	width: 350px;
	height: 560px;
	float: left;
	background-color: lightgrey;
}

table {
	border-color: blue;
	border-radius: 5px;
}

h3, h1 {
	text-align: center;
}

.user-row {
	margin-bottom: 14px;
}

.user-row:last-child {
	margin-bottom: 0;
}

.dropdown-user {
	margin: 13px 0;
	padding: 5px;
	height: 100%;
}

.dropdown-user:hover {
	cursor: pointer;
}

.table-user-information>tbody>tr {
	border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information>tbody>tr:first-child {
	border-top: 0;
}

.table-user-information>tbody>tr>td {
	border-top: 0;
}
</style>

<body>
	<jsp:include page="../common_ui/start.jsp" />

	<c:choose>
		<c:when test="${not empty bean}">


			<%-- 			<div class='row'>
				<!-- project -->

				<div class='col-md-6' >

					<table>
						<tr>
							<th style="color:red;font-size: 20px;">Project Information</th>
						</tr>
						<tr>
							<td>projectTitle</td>
							<td>${bean.projectTitle }</td>
						</tr>
						<tr>
							<td>projectDescription</td>
							<td>${bean.projectDescription }</td>
						</tr>
					</table>
					<div class='panel-info' style="margin-top: 25px;">
						<div class="panel-heading">Project Manager Info :</div>
						<div class="panel-body">
							<div class='row'>
								<div class='col-md-3'>
									<img src="${bean.pMimage }" class='img-circle' width="100px"
										height="100px" />
								</div>
								<div class='col-md-9'>
									<div class='row'>
										<div class='col-md-4'>NAME:</div>
										<div class='col-md-8'>${bean.pMfirstName}
												${bean.pMlastName }</div>
										<div class='col-md-4'>EMAIL :</div>
										<div class='col-md-8'>${bean.pMemail }</div>
										<div class='col-md-4'>MOBILE NUMBER :</div>
										<div class='col-md-8	'>${bean.pMMobileNo }</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- module -->

				<div class='col-md-6'>

					<div class='row'>
						<table>
							<tr>
							<th style="color:red;font-size: 20px;">Module Information</th>
						</tr>
							<tr>
								<td>moduleTitle</td>
								<td>${bean.moduleTitle }</td>
							</tr>
							<tr>
								<td>moduleDescription</td>
								<td>${bean.moduleDescription }</td>
							</tr>
							<tr>
								<td>startDate</td>
								<td>${bean.startDate }</td>
							</tr>
							<tr>
								<td>endDate</td>
								<td>${bean.endDate }</td>
							</tr>
							<tr>
								<td>moduleCompletionPercent</td>
								<td>${bean.moduleCompletionPercent }</td>
							</tr>
						</table>

						<div class='panel-info'>

							<div class="panel-heading">Team Lead Info :</div>
							<div class="panel-body">
								<div class='row'>
									<div class='col-md-3'>
										<img src=" ${bean.tLimage }" class='img-circle' width="100px"
											height="100px" />

									</div>
									<div class='col-md-9'>
										<div class='row'>
											<div class='col-md-4'>NAME:</div>
											<div class='col-md-8'>${bean.tLfirstName }
												${bean.tLlastName }</div>
											<div class='col-md-4'>EMAIL :</div>
											<div class='col-md-8'>${bean.tLemail }</div>

											<div class='col-md-4'>MOBILE NUMBER :</div>
											<div class='col-md-8	'>${bean.tLmobileNo }</div>

										</div>
									</div>

								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
 --%>

			
			<div >
				<div
					class="well col-xs-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
					<div class="row user-row">
						<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
						</div>
						<div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
							<strong>Project Information</strong><br> <span
								class="text-muted"></span>
										</div>
						<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user"
							data-for=".cyruxx">
							<i class="glyphicon glyphicon-chevron-down text-muted"></i>
						</div>
					</div>
					<div class="row user-infos cyruxx">


						<div
							class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
							<div class="panel panel-primary">
								<div class="panel-heading">

									<h3 class="panel-title">Project Information</h3>
								</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
											<img src="${bean.pMimage }" class='img-circle' width="100px"
										height="100px"  alt="user pic"/>
										</div>
										<div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
											<img class="img-circle"
												src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
												alt="User Pic">
										</div>
										<div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
											<strong></strong><br>
											<dl>
												<dt>User level:</dt>
												<dd>Administrator</dd>
												<dt>Registered since:</dt>
												<dd>11/12/2013</dd>
												<dt>Topics</dt>
												<dd>15</dd>
												<dt>Warnings</dt>
												<dd>0</dd>
											</dl>
										</div>
										<div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
											<strong></strong><br>
											<table class="table table-user-information">
												<tbody>
													<tr>
														<td><b>Project Title</b></td>
														<td>${bean.projectTitle }</td>
													</tr>
													<tr>
														<td><b>Project Description</b></td>
														<td>${bean.projectDescription }</td>
													</tr>

													<tr>
														<td><b>Project Manager First Name</b></td>
														<td>${bean.pMfirstName}</td>
													</tr>
													<tr>
														<td><b>Project Manager Last Name</b></td>
														<td>${bean.pMlastName }</td>
													</tr>
													<tr>
														<td><b>Project Manager Email</b></td>
														<td>${bean.pMemail }</td>
													</tr>
													<tr>
														<td><b>Project Manager Mobile No</b></td>
														<td>${bean.pMMobileNo }</td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="panel-footer">
								</div>
							</div>
						</div>
					</div>
							
					
<div class="row user-row">
						<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
						</div>
						<div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
							<strong>
									Module Information</strong><br> <span
								class="text-muted"></span>
										</div>
						<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user"
							data-for=".cyruxx">
							<i class="glyphicon glyphicon-chevron-down text-muted"></i>
						</div>
					</div>
<div class="row user-infos cyruxx">


						<div
							class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
							<div class="panel panel-primary">
								<div class="panel-heading">

									<h3 class="panel-title">Module Information</h3>
								</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
											<img src="${bean.pMimage }" class='img-circle' width="100px"
										height="100px"  alt="user pic"/>
										</div>
										<div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
											<img class="img-circle"
												src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
												alt="User Pic">
										</div>
										<div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
											<strong></strong><br>
											<dl>
												<dt>User level:</dt>
												<dd>Administrator</dd>
												<dt>Registered since:</dt>
												<dd>11/12/2013</dd>
												<dt>Topics</dt>
												<dd>15</dd>
												<dt>Warnings</dt>
												<dd>0</dd>
											</dl>
										</div>
										<div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
											<strong></strong><br>
											<table class="table table-user-information">
												<tbody>
									<tr>
								<td><b>Module Title</b></td>
								<td>${bean.moduleTitle }</td>
							</tr>
							<tr>
								<td><b>Module Description</b></td>
								<td>${bean.moduleDescription }</td>
							</tr>
							<tr>
								<td><b>StartDate</b></td>
								<td>${bean.startDate }</td>
							</tr>
							<tr>
								<td><b>endDate</b></td>
								<td>${bean.endDate }</td>
							</tr>
							<tr>
								<td><b>moduleCompletionPercent</b></td>
								<td>${bean.moduleCompletionPercent }</td>
							</tr>
													<tr>
														<td><b>Team Leader First Name</b></td>
														<td>${bean.tLfirstName}</td>
													</tr>
													<tr>
														<td><b>Team Leader Last Name</b></td>
														<td>${bean.tLlastName }</td>
													</tr>
													<tr>
														<td><b>PTeam Leader Email</b></td>
														<td>${bean.tLemail }</td>
													</tr>
													<tr>
														<td><b>Team Leader Mobile No</b></td>
														<td>${bean.tLmobileNo }</td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="panel-footer"></div>
							</div>
						</div>
					</div>



				</div>
			</div>

		</c:when>
		<c:otherwise></c:otherwise>

	</c:choose>
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
	<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var panels = $('.user-infos');
						var panelsButton = $('.dropdown-user');
						panels.hide();

						//Click dropdown
						panelsButton
								.click(function() {
									//get data-for attribute
									var dataFor = $(this).attr('data-for');
									var idFor = $(dataFor);

									//current button
									var currentButton = $(this);
									idFor
											.slideToggle(
													400,
													function() {
														//Completed slidetoggle
														if (idFor
																.is(':visible')) {
															currentButton
																	.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
														} else {
															currentButton
																	.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
														}
													})
								});

						$('[data-toggle="tooltip"]').tooltip();

						$('button').click(function(e) {
							e.preventDefault();
							alert("This is a demo.\n :-)");
						});
					});
</script>
	
</body>