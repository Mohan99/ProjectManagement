<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="path" value="<%=application.getContextPath() %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<jsp:include page="../common_ui/start.jsp"></jsp:include>
<div class='row'>

<c:if test="${success ne  null}"   var="msg">
	<b>	<i><h2 style="color: green; text-align: center">${success }</h2></i></b>
	</c:if>
	<c:remove var="success"/>

	<div  >
		<div id="demo"  style="display:none">
			<form class="well form-horizontal" id="add_client_info11"
				action="<%=application.getContextPath()%>/EditUserLogo"
				enctype="multipart/form-data" method="post" id="contact_form">
				<center>
					<div style="text-align: center">
						<img src="${image }"  width="100px", height="80px"  alt="no pic available"/>
						<div class="form-group">
							<label class="col-md-4 control-label">upload:</label>
							<div class="col-md-4 inputGroupContainer">
								<div>

									<span><i> </i></span> <input name="file" class="form-control"
										type="file" id="fna">
								</div>
							</div>
						</div>
</div>

					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<center>
								<button style="float: right"  type="submit"
									class="btn btn-warning" >
									Upload <span class="glyphicon glyphicon-send"></span>
								</button> &nbsp;&nbsp;
								<button style="float: right" ; 
									class="btn btn-warning" onclick="editDiv()"type="button" >
									Show Edit <span class="glyphicon glyphicon-send"></span>
								</button>
							</center>
						</div>
					</div>
					</center>
			</form>
		</div>
		<div id="edit">
		<form class="well form-horizontal" id="add_client_info"
			action="${path }/EditProfileAction"
			enctype="multipart/form-data" method="post" id="contact_form" width="100",height="100">

			<fieldset>
				<center>
					<legend>
						<b><h1 style="color: red">EditProfile</h1></b>
					</legend>
				</center>

  
				<center>
						<div style="text-align:center">	
				<img src="${image }" width="100px" height="80px"   id="btnImage1"  alt="no pic available" 	>
									<div class="form-group">'
				 <button type="button" id="btnImage" onclick="return showDiv();" class="btn btn-primary"  width=" 5%" >Edit Image</button> 
	<!-- 	<button type="button" onclick="return hideDiv();"   id="btnImagehhide" style="display:none" class="btn btn-primary" >image</button>
 -->	 			</div>	
			</div>
			</center>
						<div class="form-group">
					<label class="col-md-4 control-label">FirstName:</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"> </i></span> <input name="FirstName"
								class="form-control" type="text" id="fname">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">LastName</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i></span> <input name="LastName"
								class="form-control" type="text" id="lname">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Email</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i></span> <input name="Email"
								class="form-control" type="text" id="emailData">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">MobileNo</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-earphone"></i></span> <input name="MobileNo"
								class="form-control" type="text" id="mobile">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label">Gender:</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span><input id="ge" type="radio"
								value="male" name="gender" />Male &nbsp&nbsp <input
								type="radio" id="gen"  value="female" name="gender" />Female
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Address</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-home"></i></span> <input name="address"
								id="address" class="form-control" type="text">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Pin Code</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="pin"
								class="form-control" type="text" id="pincode">
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
						<button type="reset" class="btn btn-danger" name="addClient"
							value="add_client" border-radius: 25px>
							RESET <span class="glyphicon glyphicon-send"></span>
						</button>
						&nbsp; &nbsp; &nbsp; &nbsp;
						<button style="float: right" ; type="submit"
							class="btn btn-success" name="addClient" value="add_client" border-radius: 25px>
							SUBMIT <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>
				<!-- <div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						
					</div>
				</div> -->
			</fieldset>
		</form>
		</div>
	</div>
	</div>
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript"
	src="${path }/java_script/bootstrapValidator.min.js"></script>

<link rel="${path }/css/bootstrapValidator.min.css">
<script src="${path }/java_script/tether.min.js"></script>

<script type="text/javascript">
var userCountryId;
var userStateId;
var userCityId;
function getCountry(){
	$.ajax({ url: "<%=application.getContextPath()%>/CountryAction.ajax",
        context: document.body,
		success : function(data) {
				var country = document
					.getElementById("countryid");
			$(country).empty();
			$(country).append("<option vale=''>Choose Country</option>");
			$
					.each(
							data,
							function(
									index) {
								
								if(userCountryId==data[index].countryId){
									$(
											country)
											.append(
													"<option selected value=" + data[index].countryId + ">"
															+ data[index].country
															+ "</option>");
										
								}else{
									$(
										country)
										.append(
												"<option  value=" + data[index].countryId + ">"
														+ data[index].country
														+ "</option>");
								}
									
							});
			}
});
}

function getState(cid){
	var state = document
	.getElementById("st");

	$.ajax({
		type : "POST",
		url : "<%=application.getContextPath()%>/StateAction.ajax",
												data : {
													"cId" : cid
												},
												success : function(data) {
					
													$(state).append("<option vale=''>Choose State</option>");
													
													$
															.each(
																	data,
																	function(
																			index) {
																		if(userStateId==data[index].stateID){
																			$(
																				state)
																				.append(
																						"<option selected value=" + data[index].stateID + ">"
																								+ data[index].state
																								+ "</option>");
																		}else{
																			$(
																					state)
																					.append(
																							"<option  value=" + data[index].stateID + ">"
																									+ data[index].state
																									+ "</option>");
																		}
																		});
												}
											});
	
	
}

function getCity(stId){
/* alert(stId);
 */	var city = document
	.getElementById("cityId");
	
	$.ajax({
		type : "POST",
		url : "<%=application.getContextPath()%>/CityAction.ajax",
												data : {
													"sId" : stId
												},
												success : function(data) {
													
													$(city).append("<option vale=''>Choose city</option>");
													
													$
													
													.each(
																	data,
																	function(
																			index) {
																		
																		if(data[index].cityId==userCityId){
																			$(city)
																			.append(
																					"<option selected  value=" + data[index].cityId + ">"
																							+ data[index].City
																					+ "</option>");
																		
																		}else{
																		$(city)
																				.append(
																						"<option  value=" + data[index].cityId + ">"
																								+ data[index].City
																						+ "</option>");
																		}
																		});
												}
											});

}

$(document).ready(function(){
	//document.getElementById("product").style.display = "none";
	$.ajax({
		url: "<%=application.getContextPath()%>/ViewProfileAction",
	
									data : {
										"ajax" : "ajax"
									},
									success : function(data) {
										//	alert(data[0]);
										document.getElementById("fname").value = data.firstName;
										
										
										var ln = data.lastName;
										if(ln==undefined){
											ln='';
										}
										document.getElementById("lname").value = ln;
										
										
										document.getElementById("emailData").value = data.email;
										
										document.getElementById("mobile").value = data.mobileNo;
										
										if(data.gender!=undefined){
											
										if(data.gender=="male"){
											document.getElementById("ge").checked=true;
										}else if(data.gender=="female"){
											document.getElementById("gen").checked=true;
										}
									}else{
										document.getElementById("ge").checked=false;
										document.getElementById("gen").checked=false;
									}
										
										var add =data.addressId.address;
										if(add== undefined){
											add="";
											
										}
										document.getElementById("address").value = add;
									var pin =data.addressId.pinCode;
										if(pin==undefined){
											pin="";
										}
										document.getElementById("pincode").value = pin;
										//	document.getElementById("cid").value=data[0].addressId.cityId.stateId.countryID.country;
										//		document.getElementById("st").value=data[0].addressId.cityId.stateId;
										//					document.getElementById("lname").value="";
										//				document.getElementById("cty").value=data[0].addressId.cityId.City;
										//						document.getElementById("mobile").value="";
										$("#countryid").empty();
										
										
										userCountryId=data.addressId.cityId.stateId.countryID.countryId;
										userCityId=data.addressId.cityId.cityId;
										userStateId=data.addressId.cityId.stateId.stateID;
										
										getCountry();
										
										if(userCountryId!=undefined){
											getState(userCountryId);
												
										if(userStateId!=undefined){
											getCity(userStateId);
											
										}
										}
										
										
										
										/* 
										$("#countryid")
												.append(
														"<option value='"+data.addressId.cityId.stateId.countryID.countryId+"'>"
																+ data.addressId.cityId.stateId.countryID.country
																+ "</option>");
										$("#st").empty();
										$("#st")
												.append(
														"<option value='"+data.addressId.cityId.stateId+"'>"
																+ data.addressId.cityId.stateId.state
																+ "</option>");

										$("#cityId").empty();
										$("#cityId")
												.append(
														"<option value='"+data.addressId.cityId.cityId+"'>"
																+ data.addressId.cityId.City
																+ "</option>"); */

									}
								});
					});
	


//validations for form	
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
										FirstName : {
											validators : {
												stringLength : {
													min : 5,
												},
												 regexp: {
								                        regexp: /^[a-zA-Z\s]+$/,
								                        message: 'The Name can o nly consist of alphabetical'
								                    },
											
												notEmpty : {
													message : 'The First name is required and cannot be empty'
												}
											}
										},
										LastName : {
											validators : {
												stringLength : {
													min : 3,
												},
												 regexp: {
								                        regexp: /^[a-zA-Z\s]+$/,
								                        message: 'The Name can only consist of alphabetical'
								                    },
											/* 
												notEmpty : {
													message : 'The Lastname is required'
												} */
											}
										},
										Email: {
							                validators: {
							                    notEmpty: {
							                        message: 'The email address is required and cannot be empty'
							                    },
							                    regexp: {
							                        regexp: /^[a-zA-Z0-9][a-zA-Z0-9-.]{2,}@[a-z]{2,}[.][a-z]{2,}$/,
							                        message: "Invalid Email number"
							                    },
											
							                    emailAddress :{
							                    	message : 'Please supply a valid email address'
							                    }
							                }
							            },
   
				         MobileNo: {
											validators : {
												notEmpty : {
													message : 'Please supply your phone number'
												},
											    regexp: {
							                        regexp: /^[7-9][0-9]{9}$/,
							                        message: "10 digits must start with 7,8,9"
							                    }
												
											}
							        }, 
							            gender: {
							                validators: {
							                    notEmpty: {
							                        message: 'Choose any one field cannot be empty'
							                    }
							                    }
							            },
										address : {
											validators : {
												stringLength : {
													min : 2,
												},
												/* notEmpty : {
													message : 'Please supply your  address'
												} */
											}
										},
										file : {
											validators : {
												file:{
													type:"",
													extension:"",
													maxSize:"",
													message:"please choose image"
												}
											}
										},
									 	Gender: {
											validators : {
												stringLength : {
													min : 5,
												},
												notEmpty : {
													message : 'Please Choose any one'
												}
											}
										},
										
										pin : {
											validators : {
									/* 			notEmpty : {
													message : 'Please supply your pin code'
												},
									 */			 regexp: {
								                        regexp: /^\d{6}$/,
								                        message: 'The pincode must contain 6 digits'
												 },
												  pinCode: {
												        message: 'Please supply a vaild pin code'
								                    }
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
										}
									}
								});
			});
			
			
	$('#add_client_info11')
	.bootstrapValidator(
			{
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					file: {
		                validators: {
		                    notEmpty: {
		                        message: 'Please select an image'
		                    },
		                    file: {
		                        extension: 'jpeg,jpg,JPG,gif,png',
		                        type: 'image/jpeg,image/png,image/JPG,image/gif,image/jpg',
		                        maxSize:  1048576,//2048 * 1024,//2097152
		                        message: 'plz take image in jpeg,jpg,JPG,gif,png format and upto 1mb'
		                    }
		                }
		            }
				}
			});

 	/* AJAX CALL TO POPUP*/
	function popUp() {
		$("#dialog").dialog({
			modal : true,
			autoOpen : true,
			width : 400,
			height : 250
		});
		$("#btnShow").click(function() {
			$('#dialog').dialog('close');
		});
	}
 	
function 	showDiv(){
		$('#btnImage').hide(1000);
		$('#btnImage1').hide(1000);
		$('#edit').hide(1000);
		$('#demo').show(1000);
		$('abc').show();
		$('#pqr').show(1000);
		return false;
	}
	
function 	editDiv(){
	$('#btnImage').show(1000);
/* 			$('#btnImage').hide(1000);
 */			$('#btnImage1').show(1000);
	$('#edit').show(1000);
	$('#abc1').hide(1000);
	$('#demo').hide(1000);
		return false;
	}



		$(document).ready(function() {
			$("select.country").change(function() {
				var selectedCountry = $(".country option:selected").val();
				var state = document
				.getElementById("st");
		$(state).empty();
		var city = document
		.getElementById("cityId");
	$(city).empty();
	getState(selectedCountry);
	 			
});
						});
		
		$(document).ready(function() {
			$("select.state").change(function() {
				var selectedState = $(".state option:selected").val();
		
				var city = document
				.getElementById("cityId");
		$(city).empty();

			getCity(selectedState);
			
			});
						});

	
</script>
	
</body>
</html>