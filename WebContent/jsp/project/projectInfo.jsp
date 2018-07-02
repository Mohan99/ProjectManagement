<!-- @ author Raghav-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Info</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<jsp:include page="../../common_ui/start.jsp"></jsp:include>
			<div class="container">
		
				<h2 style="color: red">Project Information</h2>
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapse1">Project Info</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse in">
							<div class='container well form-horizontal'>
								<div style='float: left; width: 900px;'>
									<table>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectTitle:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pdto.projectTitle}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Description:
											</td>
											<td style='font-size: 20px';><c:out
													value="${projectInfo.pdto.projectDescription}"></c:out></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Start
												Date:</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pdto.expectedStartDate}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>End
												Date:</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pdto.expectedEndDate}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ComletionPercentage:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pdto.projectCompletionPercentage}"></c:out></label></td>
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
									href="#collapse2">Project Manager Info</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse">
							<div class='container well form-horizontal'>
								<div style='float: left; width: 900px;'>
									<div style='float: right; width: 300px'>
										<img src="${projectInfo.pmImage}" width='200px' height='150px' />
									</div>
									<table>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManager:
										
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pmdto.projectManagerId.firstName}"></c:out></label></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
											</td>
											<td style='font-size: 20px';><c:out
													value="	${projectInfo.pmdto.projectManagerId.email}"></c:out></td>
										</tr>
										<tr>
											<td
												style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
											</td>
											<td style='font-size: 20px';><label><c:out
														value="${projectInfo.pmdto.projectManagerId.mobileNo}"></c:out></label></td>
										</tr>
									</table>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3">Client Info</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse">
								<div class='container well form-horizontal'>
									<div style='float: left; width: 900px;'>
										<div style='float: right; width: 300px'>
											<img src="${projectInfo.clientLogo}" width='200px'
												height='150px' />
										</div>
										<table>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Clinet:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${projectInfo.cdto.clientName}"></c:out></label></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ContactPerson:
												</td>
												<td style='font-size: 20px';><c:out
														value="${projectInfo.cpdto.contactPersonName}"></c:out></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${projectInfo.cpdto.email}"></c:out></label></td>
											</tr>
											<tr>
												<td
													style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
												</td>
												<td style='font-size: 20px';><label><c:out
															value="${projectInfo.cpdto.mobileNo}"></c:out></label></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<a href="<%=request.getContextPath()%>/ViewProjectAction"><input
				type="button" value="Back"></a>
		
<jsp:include page="../../common_ui/end.jsp"></jsp:include>

</body>
</html>