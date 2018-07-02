<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="<%=application.getContextPath() %>" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.prof{
width: 100%;
}
</style>
</head>
<body>

	<jsp:include page="../common_ui/start.jsp"></jsp:include>
	<c:if test="${success ne  null}">
		<b><i><h2 style="color: green; text-align: center">${success }</h2></i></b>
	</c:if>
	<c:remove var="success"/>
					
	
		<div class="row prof">
			<div
				class="col-md-12 toppad">
				<div class="panel panel-info" id="view">
					<div class="panel-heading">
					
						<b><h1 class="panel-title" style="color: red; text-align: center;font-size: 20px">USER PROFILE</h1></b>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
									<c:choose>
							<c:when test="${image ne null }" >
									<img alt="no pic available" src="${image }" width="200px" height="200px"
									class="img-circle img-responsive">
							</c:when>
							<c:otherwise>
									<img  src="no pic available"  alt="no pic available" width="100px" height="50px"
									class="img-circle img-responsive">
							</c:otherwise>
							</c:choose>
							</div>
							<c:if test="${user ne null }">
									<div class=" col-md-9 col-lg-9 ">
										<table class="table table-user-information">
											<tbody>
												<tr>
													<td><b>FirstName:</b></td>
													<td>${user.firstName}</td>
												</tr>
												<tr>
													<td><b>LastName:</b></td>
													<td>${user.lastName}</td>
												</tr>
												<tr>
													<td><b>Email:</b></td>
													<td>${user.email}</td>
												</tr>
												<tr>
													<td><b>MobileNo:</b></td>
													<td>${user.mobileNo}</td>
												</tr>
												<tr>
													<td><b>Gender:</b></td>
													<td>${user.gender}</td>
												</tr>
												<tr>
													<td><b>Role:</b></td>
													<td>${user.roleId.role}</td>
												</tr>

												<tr>
													<td><b>Address:</b></td>
													<td>${user.addressId.address}</td>
												</tr>
												<tr>
													<td><b>PinCode:</b></td>
													<td>${user.addressId.pinCode}</td>
												</tr>

												<tr>
													<td><b>Country:</b></td>
													<td>${user.addressId.cityId. stateId.countryID.country}
													</td>
												</tr>

												<tr>
													<td><b>State:</b></td>
													<td>${user.addressId.cityId.stateId.state}</td>
												</tr>

												<tr>
													<td><b>City :</b></td>
													<td>${user.addressId.cityId.city}</td>
												</tr>

											</tbody>
										</table>
									</div>
								
							</c:if>
						</div>
				<!-- 	<div class="panel-footer"
						 class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
				 -->		<span>
							<div class="col-md-5  toppad  pull-right col-md-offset-3 " style="margin-right: 172px">
							<form action="<%=application.getContextPath() %>/jsp/editProfile.jsp" method="post">
								<input  style="background-color: lightcoral;text-align:center;border-radius: 25px; width:100px; height:32px";  type="submit" value=" EditProfile"/> 
								</form>
							</div>
						</span>
					</div>
				</div>
				</div>
		</div>
	
	
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript"
	src="${path }/java_script/bootstrapValidator.min.js"></script>

<link rel="stylesheet"
	href="${path }/css/bootstrapValidator.min.css">
<script src="${path }/java_script/tether.min.js"></script>
<script>
	$(document).ready(function(){
	 $.ajax({ url: "<%=application.getContextPath()%>/CountryAction.ajax",
	        context: document.body,
			success : function(data) {
 				var country = document
						.getElementById("countryid");
				$(country).empty();
				$
						.each(
								data,
								function(
										index) {
										$(
											country)
											.append(
													"<option  value=" + data[index].countryId + ">"
															+ data[index].country
															+ "</option>");
								});
 			}
}); 
	});


	$(document).ready(function() {
		$("select.country").change(function() {
			alert("hi.......")
			var selectedCountry = $(".country option:selected").val();
			//alert(selectedCountry);
			var state = document
			.getElementById("st");
	$(state).empty();
	var city = document
	.getElementById("cityId");
$(city).empty();

 			$.ajax({
				type : "POST",
				url : "<%=application.getContextPath()%>/StateAction.ajax",
														data : {
															"cId" : selectedCountry
														},
														success : function(data) {
															$
																	.each(
																			data,
																			function(
																					index) {
 																				$(
																						state)
																						.append(
																								"<option  value=" + data[index].stateID + ">"
																										+ data[index].state
																										+ "</option>");
																			});
														}
													});
										});
					});
	
	$(document).ready(function() {
		$("select.state").change(function() {
			var selectedState = $(".state option:selected").val();
			var city = document
			.getElementById("cityId");
	$(city).empty();
			$.ajax({
				type : "POST",
				url : "<%=application.getContextPath()%>/CityAction.ajax",
														data : {
															"sId" : selectedState
														},
														success : function(data) {
															$
																	.each(
																			data,
																			function(
																					index) {
																				$(
																						city)
																						.append(
																								"<option  value=" + data[index].cityId + ">"
																										+ data[index].City
																										+ "</option>");
																			});
														}
													});
										});
					});
	</script>
<!-- <style>
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
	border-top: 2px solid tan;
}

.table-user-information>tbody>tr:first-child {
	border-top: 0;
}
.table-user-information>tbody>tr>td {
	border-top: 0;
}

.toppad {
	margin-top: 20px;
}
/* .container{
background-image: url("twitter-patterns-3.jpg");
}
 */
#edit {
	display: none;
}

</style>
 --><script type="text/javascript">
	function edit() {
	/* 	$("#edit").show();
		$("#view").hide(); */
		
	}

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
							//	alert("This is a demo.\n :-)");
						});
					});
</script>
	
	
	
</body>
</html>