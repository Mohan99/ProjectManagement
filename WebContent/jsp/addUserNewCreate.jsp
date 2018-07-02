<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
@author Avinash
*@Add single user Details UI
*@Multi add user Details UI
*@Disply the message used Jstl tag Attribute
*@Disply the role used Ajax 
*
-->
<html>
<head>
<style type="text/css">
#success_message {
	display: none;
}

#btn-su, #btn-mu {
	margin-bottom: 15px;
}
</style>

</head>
<!-- Disply message Suceessfully  -->
<body>



 <jsp:include page="../common_ui/start.jsp"></jsp:include>
 


	<c:if test="${Error ne null }">
		<div class="alert alert-danger alert-dismissable">
			<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>CHECK!</strong> ${Error}.
		</div>

	</c:if>

	<c:remove var="Error" />
	
	<c:if test="${Success ne null }">

		<div class="alert alert-success alert-dismissable">
			<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong> ${Success}
		</div>

	</c:if>
	<c:remove var="Success" />
	
	<c:if test="${invalidEmails1 ne null}">
		<center>

					<div class="alert alert-danger alert-dismissable">
						<a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>MAIL NOT SENT!</strong> ${Error}.
					</div>
					${invalidEmails1.firstName} ${invalidEmails1.email} ${invalidEmails1.mobileNo}
						${invalidEmails1.password} ${invalidEmails1.gender}
			</center>
		
	</c:if>
	<c:remove var="invalidEmails1" />
	
	
	
	<c:if test="${invalidEmails ne null}">

		<%--  <c:out value="${invalidEmails}"></c:out>
         --%>

					<div class="alert alert-danger alert-dismissable">
						<a class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>MAIL NOT SENT!</strong>FOLLOWING ARE  ${Error} 
					</div>
		<c:forEach var="udto" items="${invalidEmails}">
				<div class='row bg-danger'>
				<div class='col-md-3'>
			FIRST NAME :
					${udto.firstName}
					</div>
						<div class='col-md-3'>
					 EMAIL : ${udto.email} 
					 </div>
					 	<div class='col-md-3'>
					MOBILE NO : ${udto.mobileNo}
					 </div>
			</div>

		</c:forEach>
	</c:if>


	<c:remove var="invalidEmails" />

	<!-- Add user Details -->

	<div class="">
		<form class="well form-horizontal" 
		action="<%=application.getContextPath()%>/AddUserDetails" method="post" id="contact_form">
			<fieldset>

				<!-- Form Name -->
			
					<legend>
						<font>
						Add Single User</font>
					</legend>
					<button type="button" id='btn-su' class='btn btn-primary btn-block'>Click
						Here To Add Multiple Users</button>

			
				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">First Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="fname"
								placeholder="First Name" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Last Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="lname"
								placeholder="Last Name" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								placeholder="E-Mail Address" class="form-control" type="text">
						</div>
					</div>
				</div>


				<!-- Text input mobile no -->

				<div class="form-group">
					<label class="col-md-4 control-label">Mobile No</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="mobileno"
								placeholder="(845)555-1212" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Select Gender-->

				<div class="form-group">
					<label class="col-md-4 control-label">Gender</label>

					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<!-- <input name="gender"
							placeholder="Male/Female" class="form-control" type="text"> -->
							<select name="gender" class="form-control selectpicker">
								<option value=" ">Select Gender</option>
								<option>Male</option>
								<option>Female</option>


							</select>
						</div>
					</div>
				</div>




				<!-- Select Role -->
				<div class="form-group">
					<label class="col-md-4 control-label">Role</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select name="role" 
								 class="form-control selectpicker" id="role1">
								<option value=" ">Select role</option>

							</select>
						</div>
					</div>
				</div>



				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for
					contacting us, we will get back to you shortly.
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-warning">
							Add <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form>
		<!-- Add multiple user -->
		<form class="well form-horizontal"
			action="<%=application.getContextPath()%>/AddMultiUserExcels"
			
		   method="post" enctype="multipart/form-data" id="contact_form_mu">
			
			
			<fieldset>

				<!-- Form Name -->
					<legend>
						<font>Add Multiple User</font>
					</legend>
					<button id='btn-mu' type="button" class='btn btn-primary btn-block'>Click
						Here To Add Single User</button>
			



				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Excel </label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<input name="file"
								class="form-control" type="file">
						</div>
					</div>
				</div>



				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-warning">
							Add <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	<!-- /.container -->
	 <jsp:include page="../common_ui/end.jsp"></jsp:include>
	 <script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/bootstrapValidator.min.js"></script>

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrapValidator.min.css"/>
<script src="<%=application.getContextPath()%>/java_script/tether.min.js"></script>

	 

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#contact_form').bootstrapValidator(
										{
											// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												fname : {
													validators : {
														stringLength : {
															min : 2,
														},
														notEmpty : {
															message : 'Please supply your first name '
														},
														regexp: {
									                        regexp: /^[A-Za-z\s.'-]+$/,
									                        message: "Alphabetical characters, hyphens and spaces"
									                    }
													}
												},
												lname : {
													validators : {
														stringLength : {
															min : 2,
														},
														notEmpty : {
															message : 'Please supply your last name'
														},
														regexp: {
									                        regexp: /^[A-Za-z\s.'-]+$/,
									                        message: "Alphabetical characters, hyphens and spaces"
									                    }
													}
												},
												/* email : {
													validators : {
														notEmpty : {
															message : 'Please supply your email address'
														},
														regexp: {
									                        regexp: /^[a-zA-Z0-9][a-zA-Z0-9-.]*@gmail[.]com$/, 
									                        message: "Invalid email "
									                    },
									                
														emailAddress : {
															message : 'Please supply a valid email address'
														}
													}
												}, */
												
												email : {
													validators : {
														notEmpty : {
															message : 'Please supply your email address'
														},
														emailAddress : {
															message : 'Please supply a valid email address'
														}
													}
												},
												mobileno : {
													validators : {
														notEmpty : {
															message : 'Please supply your phone number'
														},
														phone : {
															country : 'US',
															message : 'Please supply a vaild phone number with area code'
														}
													}
												},
												
												gender : {
													validators : {
														notEmpty : {
															message : 'Please supply Gender'
														},
														genderAdd : {
															country : 'IN',
															message : 'Please supply a vaild Gender'
														}
													}
												},
												
												role : {
													validators : {
														notEmpty : {
															message : 'Please supply your Role'
														},
														roleAddress : {
															message : 'Please supply a vaild role '
														}
													}
												},
												
												/* file : {
													validators : {
														notEmpty : {
															message : 'Please supply file link'
														},
														file : {
															message : 'Please supply a file link'
														}
													}
												}, */
												
												
												 
												  comment : {
													validators : {
														stringLength : {
															min : 10,
															max : 200,
															message : 'Please enter at least 10 characters and no more than 200'
														},
														notEmpty : {
															message : 'Please supply a description of your project'
														}
													}
												}  
											}
										})
								
					});
	
	
	$(document)
	.ready(
			function() {
				$('#contact_form_mu').bootstrapValidator(
								{
									// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
									feedbackIcons : {
										valid : 'glyphicon glyphicon-ok',
										invalid : 'glyphicon glyphicon-remove',
										validating : 'glyphicon glyphicon-refresh'
									},
									fields : {
										
										file : {
											validators : {
												notEmpty : {
													message : 'Please supply file link'
												},
												file : {
													message : 'Please supply a file link',
													exension:'xlsx',
													type:'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
													maxSize:346688,
													message:'the seleted file is not invalid'
												}
											}
										},
									}
								})
						
			});

	
/* ROLE ID CALL AJAX */
	$(document).ready(function(){
		//alert();
            $.ajax({
		    url:"<%=application.getContextPath()%>/RoleDisplay",
					success : function(data) {
						//alert(data + "............");

						$('#role1').empty();
						for (var ind = 0; ind < data.length; ind++) {

							$('#role1').append(
									"<option value='"+data[ind].roleId+"'>"
											+ data[ind].role + "</option>");
						}

					}

				});

			});

	$(document).ready(function() {

		$("#btn-su").click(function() {

			$("#contact_form").hide();
			$("#contact_form_mu").show();

		});

		$("#btn-mu").click(function() {
			$("#contact_form").show();
			$("#contact_form_mu").hide();

		});
		$("#contact_form_mu").hide();

	});

</script>

	
	</body>
	</html>
	