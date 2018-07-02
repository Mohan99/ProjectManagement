<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Project</title>
</head>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 -->


<!-- <link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
 -->

<!-- <script
	src="https://npmcdn.com/bootstrap@4.0.0-alpha.5/dist/js/bootstrap.min.js"></script>
 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
 -->

<style>
button#new {
	width: 300px;
}

button#addProj {
	width: 300px;
}

button#existing {
	width: 200px;
}

#success_message {
	display: none;
}

#add_client_info {
	display: none;
}

#clientSearch {
	display: none;
}

#contact_person_form {
	display: none;
}

#displayClient {
	display: none;
}

/* #btn {
	display: block;
} */
</style>

<c:if test="${ signal eq 2 }" var="abc">
	<style>
#btn {
	display: inline;
}

#proj_info_form {
	display: none;
}
</style>
</c:if>
<c:if test="${ signal eq 3 }" var="abc">

	<style>
#btn {
	display: inline;
}

#proj_info_form {
	display: none;
}

#contact_person_form {
	display: block;
}

#proj_info_display {
	display: none;
}

#moreContact {
	display: none;
}
</style>
</c:if>
<c:if test="${ signal eq 4 }" var="abc">
	<style>
#btn {
	display: block;
}

#proj_info_form {
	display: none;
}

#contact_person_form {
	display: none;
}

#displayClient {
	display: block;
}
</style>
</c:if>

<body>


	<jsp:include page="../common_ui/start.jsp"></jsp:include>
	


			<c:choose>
				<c:when test="${result ne null }">
					<div class="alert alert-success alert-dismissable" id='msg'>
						<a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Success!</strong> ${result}
					</div>
					<%-- 
	<h3 id="msg" style="color:green ; text-align: center;"><b>${result}</b></h3> --%>
				</c:when>
			</c:choose>
			<c:remove var="result" />




			<c:choose>
				<c:when test="${err ne null }">
					<div class="alert alert-danger alert-dismissable" id='msg'>
						<a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>FAILED!</strong> ${err}
					</div>

					<%-- 
	<h3 id="msg" style="color:green ; text-align: center;"><b>${result}</b></h3> --%>
				</c:when>
			</c:choose>
			<c:remove var="err" />




			<div>
				<div id="btn">
					<button class="btn btn-info" id="addProj" onclick="addProj()">Add
						Project</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-info" id="new" onclick=" newClient()">Add
						New Client</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<c:choose>
						<c:when test="${ADD_PROJECT ne null }">
							<button class="btn btn-info" id="existing"
								onclick="selectClient()">Existing Client</button>
						</c:when>
					</c:choose>

				</div>

				<div id="clientSearch" class="col-sm-3 col-md-3"
					style="float: right;">
					<form class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search"
								id="search" name="search">
							<div class="input-group-btn">
								<button class="btn btn-default"
									onclick="return searchClientData();" type="submit"
									value="Search">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>
				<form class="well form-horizontal"
					action="<%=application.getContextPath()%>/addProject" method="post"
					enctype="multipart/form-data" id="proj_info_form">
					<fieldset>

						<!-- Form Name -->
						<h3 style="text-align: center;">
							<label>Add Project</label>
						</h3>


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Project Title</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="project_title" placeholder="Project Title"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<!-- Text area -->

						<div class="form-group">
							<label class="col-md-4 control-label">Project Description</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-pencil"></i></span>
									<textarea class="form-control" name="comment"
										placeholder="Project Description"></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Reference Document</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="document"
										id="ref_doc" placeholder="upload Document"
										class="form-control" type="file">
								</div>
								<span id='ref'
									style='color: #a94442; font-size: 85%; margin-top: 5px'></span>
							</div>
						</div>

									<div class="form-group">
							<label class="col-md-4 control-label">Start Date</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="date"
										placeholder="select start Date" id="StartDate"
										class="form-control" type="text" readonly="readonly">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">End Date</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="enddate"
										placeholder="select end Date" id="EndDate"
										class="form-control" type="text" readonly="readonly">
								</div>
							</div>
						</div>




						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<center>
									<button type="submit" class="btn btn-info" name="addProject"
										value="addProjectFirst">
										Continue to next Step... <span
											class="glyphicon glyphicon-send"></span>
									</button>
								</center>
							</div>
						</div>
					</fieldset>
				</form>


				<form class="well form-horizontal" id="add_client_info"
					action="<%=application.getContextPath()%>/addProject"
					enctype="multipart/form-data" method="post" id="contact_form">
					<fieldset>

						<!-- Form Name -->
						<legend>
							<h3 style="text-align: center">Add Client</h3>
						</legend>

						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Client Name</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="client_name" placeholder="Client Name"
										class="form-control" type="text">
								</div>
							</div>
						</div>


						<!-- Text area -->

						<div class="form-group">
							<label class="col-md-4 control-label">Client Description</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-pencil"></i></span>
									<textarea class="form-control" name="comment"
										placeholder="Client Description"></textarea>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Upload Logo</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="logo"
										placeholder="upload Logo" class="form-control" type="file">
								</div>
							</div>
						</div>


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Address</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="address"
										placeholder="Address" class="form-control" type="text">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Pin Code</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="pin"
										placeholder="Pin Code" class="form-control" type="text">
								</div>
							</div>
						</div>

						<!-- Select Basic -->

						<div class="form-group">
							<label class="col-md-4 control-label">Country</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select name="cid"
										class="country form-control selectpicker" id="countryid">
										<option value=" ">Please select your Country</option>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">State</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select
										class="state form-control selectpicker" name="state" id="st">
										<option value="">Please select your State</option>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">City</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select name="city"
										class="city form-control selectpicker" id="cityId">
										<option value="">Please select your City</option>
									</select>
								</div>
							</div>
						</div>


						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="submit" class="btn btn-info" name="addClient"
									value="add_client">
									Continue to next Step.... <span
										class="glyphicon glyphicon-send"></span>
								</button>
							</div>
						</div>

					</fieldset>
				</form>

				<form class="well form-horizontal" action="../addProject"
					method="post" id="contact_person_form">
					<fieldset>

						<!-- Form Name -->
						<center>
							<legend>
								<h1>Contact Person</h1>
							</legend>
						</center>

						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Person Name</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="person_name" placeholder="Person Name"
										class="form-control" type="text">
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


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Mobile No</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-earphone"></i></span> <input name="phone1"
										placeholder="Enter mobile no " class="form-control"
										type="text">
								</div>
							</div>
						</div>

						<div id="moreContact">

							<div class="form-group">
								<label class="col-md-4 control-label">Person Name</label>
								<div class="col-md-4 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <input
											name="person_name" placeholder="Person Name"
											class="form-control" type="text">
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


							<!-- Text input-->

							<div class="form-group">
								<label class="col-md-4 control-label">Mobile No</label>
								<div class="col-md-4 inputGroupContainer">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-earphone"></i></span> <input name="phone1"
											placeholder="Enter mobile no " class="form-control"
											type="text">
									</div>
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<!-- 						<div class="col-md-4">
 -->
								<button type="button" class="btn btn-warning"
									style="width: 150px" id='cnthide' name="contact">Hide
									Contact</button>
								<button type="submit" class="btn btn-warning"
									style="width: 150px" name="contact" value="cntPerson">
									Submit <span class="glyphicon glyphicon-send"></span>
								</button>
								<!-- 					</div>
	 -->
							</div>
						</div>

						<!-- Button -->
						<div class="form-group" id='cnt1'>
							<label class="col-md-4 control-label"></label>
							<!-- 		<div class="col-md-4"> -->
							<button type="button" style="width: 200px"
								class="btn btn-warning" id='cntadd'>Add one more
								Contact</button>
							&nbsp &nbsp
							<button type="submit" style="width: 150px"
								class="btn btn-warning" name="contact" value="cntPerson">
								Submit <span class="glyphicon glyphicon-send"></span>
							</button>
							<!-- 		</div>
			 -->
						</div>

					</fieldset>
				</form>


				<c:choose>
					<c:when test="${ ADD_PROJECT ne null}">
						<div class='container well form-horizontal' id="proj_info_display"
							style='width: 900px'>
							<h2 style='text-align: center; color: maroon;'>Select Client
								For the Project</h2>
							<table>
								<tr>
									<td
										style='font-size: 22px; color: blue; width: 200px; line-height: 40px;'>Project
										Name</td>
									<td style='font-size: 18px';><label>${ADD_PROJECT.projectTitle}</label></td>
								</tr>
								<tr>
									<td style='font-size: 22px; color: blue; width: 200px'>Project
										Description</td>
									<td style='font-size: 18px'><label>${ADD_PROJECT.projectDescription}</label>
									</td>
								</tr>
							</table>
						</div>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<div id="displayClient"></div>
			</div>
		</div>
	</div>
<jsp:include page="../common_ui/end.jsp"></jsp:include>


	<link rel="stylesheet"
		href="<%=application.getContextPath() %>/css/bootstrapValidator.min.css">



	<%--  <script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/bootstrapvalidator.min.js"></script>
	 --%>
	<link rel="stylesheet"
		href="<%=application.getContextPath() %>/css/jquery-ui.css">

	<script
		src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>

	<script type="text/javascript"
		src="<%=application.getContextPath() %>/java_script/bootstrapValidator.min.js"></script>


	<script
		src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>

	<script type="text/javascript">


$(document).ready(function(){
	$.ajax({ url: "<%=application.getContextPath()%>/CountryAction.ajax",
	        context: document.body,
			success : function(data) {
 				var country = document
						.getElementById("countryid");
				$(country).empty();
				$(countryid).append("<option  value=''>Choose Country</option>");
				$
						.each(
								data,
								function(
										index) {
										$(
											countryid)
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
			var selectedCountry = $(".country option:selected").val();
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
															$(state).append("<option  value=''>Choose State</option>");

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
															$(city).append("<option  value=''>Choose City</option>");

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

	$( function() {
	    var dateFormat = "mm/dd/yy",
	    StartDate = $( "#StartDate" )
	        .datepicker({

	        	minDate: 1, 
	          defaultDate: "+1w",
	          
	          changeMonth: true,
	          numberOfMonths: 1
	        })
	        .on( "change", function() {
	        	EndDate.datepicker( "option", "minDate", getDate( this ) );
	        }),
	        EndDate = $( "#EndDate" ).datepicker({
	        //defaultDate: "+1w",
	        changeMonth: true,
	        numberOfMonths: 1
	      })
	      .on( "change", function() {
	        StartDate.datepicker( "option", "maxDate", getDate( this ) );
	      });
	 
	    function getDate( element ) {
	      var date;
	      try {
	        date = $.datepicker.parseDate( dateFormat, element.value );
	      } catch( error ) {
	        date = null;
	      }
	 
	      return date;
	    }
	  
	    $('#StartDate').change(function(e){
	    	//alert(e);
	        e.preventDefault();
	        alert(document.getElementById('#StartDate').value);
	        $('#proj_info_form').bootstrapValidator();
	  //      lookup(); //never happens
	      });
						
						$('#proj_info_form')
								.bootstrapValidator(
										{
											// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												project_title : {
													validators : {
														stringLength : {
															min : 5,
														},
														notEmpty : {
															message : 'Please supply Project title'
														}
													}
												},
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
												},						 						 
												/* date : {
													validators : {
														 stringLength : {
															min : 10,
															message : 'Please supply Expected Start Date '
														} ,  
														
														callback: {
								                            message: 'Enter Date',
								                            callback: function (value, validator, $field) {
								           		         			
								           		         				return value.length != 0;
								           		         			
								                            }
								                        }
 												 	}
												}, */ 

											}
										});
					});

	$(document)
			.ready(
					function() {
						$('#add_client_info')
								.bootstrapValidator(
										{
											// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												client_name : {
													validators : {
														stringLength : {
															min : 5,
														},
														notEmpty : {
															message : 'Please supply Client Name'
														}
													}
												},
												address : {
													validators : {
														stringLength : {
															min : 8,
														},
														notEmpty : {
															message : 'Please supply your street address'
														}
													}
												},
												logo: {
									                validators: {
									                    notEmpty: {
									                        message: 'Please select an image'
									                    },
									                    file: {
									                        extension: 'jpeg,jpg,png',
									                        type: 'image/jpeg,image/png',
									                        maxSize: 2097152, // 2048 * 1024
									                        message: 'The selected file is not valid'
									                    }
									                }
									            },
												pin : {
													validators : {
														notEmpty : {
															message : 'Please supply your pin code'
														},regexp:{
															regexp:/^\d{6}$/,
															message:'Pin Code must contain 6 digits '
														},
														zipCode : {}
													}
												},
												cid : {
													validators : {
														notEmpty : {
															message : 'Please select your country'
														}
													}
												},
												state : {
													validators : {
														notEmpty : {
															message : 'Please select your state'
														}
													}
												},
												city : {
													validators : {
														notEmpty : {
															message : 'Please select your city'
														}
													}
												},
												comment : {
													validators : {
														stringLength : {
															min : 10,
															max : 200,
															message : 'Please enter at least 10 characters and no more than 200'
														},
														notEmpty : {
															message : 'Please supply a description of Client'
														}
													}
												}
											}
										});

					});
	$(document).ready(function() {
		$('#contact_person_form').bootstrapValidator({
			// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				person_name : {
					validators : {
						stringLength : {
							min : 5,
						},
						notEmpty : {
							message : 'Please supply Person name'
						}
					}
				},
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
		 		 phone1 : {
					validators : {
						notEmpty : {
							message : 'Please supply your phone number'
						}, 
						/* phone : {
							message : 'Please supply a vaild phone number '
						}, */ regexp:{
							regexp:/^[7-9][0-9]{9}$/,
							message:'mobile number must contain 10 digits start with 7,8 or 9 '
						},
					}
				}  
			}
		});

	});
	$(document).ready(function() {
		$('#proj_client_form').bootstrapValidator({
			// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				client_select : {
					validators : {
						notEmpty : {
							message : 'Please select Client'
						}
					}
				},
				location_select : {
					validators : {
						notEmpty : {
							message : 'Please select Client location'
						}
					}
				}

			}
		});

	});
	
	function newClient(){
		 $("#displayClient").hide(1000);
	        $("#contact_person_form").hide(1000);
	        $("#add_client_info").show(1000);
	        $("#proj_info_form").hide(1000);
	        $("#clientSearch").hide();
	        $("#proj_info_display").hide();
	        $("#msg").hide();
	}

	$(document).ready(function(){
	    $("#new").click(function(){
	        $("#displayClient").hide(1000);
	        $("#contact_person_form").hide(1000);
	        $("#add_client_info").show(1000);
	        $("#proj_info_form").hide(1000);
	        $("#clientSearch").hide();
	        $("#proj_info_display").hide();
	        $("#msg").hide();

	    });
	     
	    $("#cntadd").click(function(){
	        $("#cntadd").hide(1000);
	        $("#cnthide").show(1000);
	        $("#clientSearch").hide();
	        $("#proj_info_display").hide();
	        $("#msg").hide();

	  //      $("#contact_person_form").hide(1000);
	        $("#moreContact").show(1000);
	    });
	    
	    $("#cnthide").click(function(){
	        $("#cnthide").hide(1000);
	        $("#cnt1").show(1000);
	        $("#cntadd").show(1000);
	        $("#msg").hide();

	        $("#moreContact").hide(1000);
	    });
	});
	
	function addProj(){
        $("#displayClient").hide(1000);
        $("#contact_person_form").hide(1000);
        $("#add_client_info").hide(1000);
        $("#proj_info_form").show(1000);
        $("#clientSearch").hide();
        $("#proj_info_display").hide();
        $("#msg").hide();

	}


	$(document).ready(function(){
	    $("#existing").click(function(){
	        $("#add_client_info").hide(1000);
	        $("#contact_person_form").hide(1000);
	        $("#displayClient").show(1000);
	        $("#proj_info_form").hide(1000);
	        $("#clientSearch").show();
	        $("#proj_info_display").show();
	        $("#msg").hide();

	    });
	});    
	    
		$(document).ready(function(){
		    $("#cntadd").click(function(){
		        $("#cntadd").hide(1000);
		        $("#cnt1").hide(1000);
		        $("#proj_info_form").hide(1000);
		        $("#clientSearch").hide();
		        $("#proj_info_display").hide();
		        $("#msg").hide();

		    });
	});
	
		function searchClientData(){
			var search = document.getElementById("search").value;
			$(document).ready(function(){
				$.ajax({ url: "<%=application.getContextPath()%>/AllClientSearchAction.ajax",
					data:{
						"search" : search
					},
						success : function(data) {
			 				var client = document.getElementById("displayClient");
							$(client).empty();
							if(data.length == 0  ){
								$(
										client)
										.append("<h2 style='text-align:center;color:red'>No Client Found With this search</h2>");
							}
							$
									.each(
											data,
											function(
													index,obj) {
											/* 	console.log(obj.logo); */
													$(
														client)
														.append("<div class='container well form-horizontal' style='width:900px' ><div style='float: left;' ><table ><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;' >Client Name  </td><td style='font-size: 20px';><label>"+obj.clientName+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px'>Client Description  </td><td style='font-size: 18px'> <label>"+obj.clientDescription+"</label> </td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Address  </td> <td style='font-size: 20px'><label>"+obj.address+","+obj.pincode+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'> City  </td> <td style='font-size: 20px'><label>"+obj.city+"</label></td></tr> </table></div><div style='float: right'><img src='"+obj.logo+"' width='150px' height='100px'/><br><br><br><form action='<%=application.getContextPath()%>/addProject?locationId="+obj.locationId+"' method='post' ><button class='btn btn-warning' type ='submit' style='float: right;' >Select Client</button></div></div>");
											});
			 			}
			});
				});
			return false;
		}
		
		
	function selectClient(){

	$(document).ready(function(){
		$.ajax({ url: "<%=application.getContextPath()%>/AllClientAction.ajax",
		        context: document.body,
				success : function(data) {
	 				var client = document.getElementById("displayClient");
					$(client).empty();
						$
						.each(
								data,
								function(
										index,obj) {
								/* 	console.log(obj.logo); */
										$(
											client)
											.append("<div class='container well form-horizontal' style='width:900px' ><div style='float: left;' ><table ><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;' >Client Name  </td><td style='font-size: 20px';><label>"+obj.clientName+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px'>Client Description  </td><td style='font-size: 18px'> <label>"+obj.clientDescription+"</label> </td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Address  </td> <td style='font-size: 20px'><label>"+obj.address+","+obj.pincode+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'> City  </td> <td style='font-size: 20px'><label>"+obj.city+"</label></td></tr> </table></div><div style='float: right'><img src='"+obj.logo+"' width='150px' height='100px'/><br><br><br><form action='<%=application.getContextPath()%>/addProject?locationId="+obj.locationId+"' method='post' ><button class='btn btn-warning' type ='submit' style='float: right;' >Select Client</button></div></div>");
								});
		
					
	 			}
	});
		});
	}
	
	function addProject(clId){

		$(document).ready(function(){
			$.ajax({ url: "<%=application.getContextPath()%>/addProject",
					context : document.body,
					data : {
						"locationId" : clId
					},
					success : function(data) {
					}
				});
			});
		}

		$('#ref_doc').bind('change',function() {
							if(this.files[0].size <= 1024*1024) {
								document.getElementById("ref").innerHTML = "";
							}else{
								document.getElementById("ref").innerHTML = "This file size limit is: exceeds allowed size upto 1MB ";
								document.getElementById("ref_doc").value = "";
								document.getElementById("ref_doc").focus();
							}
						});
</script>
</body>
</html>