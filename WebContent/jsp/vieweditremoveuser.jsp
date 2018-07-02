<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All users</title>

<style type="text/css">
.container.well.form-horizontal {
    width: 100%;
}
</style>

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/jquery-ui.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrapValidator.min.css">

</head>
<body>


<jsp:include page="../common_ui/start.jsp"></jsp:include>

<!-- DIV FOR USER SEARCH  -->
<div id="UserSearch" class="col-sm-3 col-md-3" style='float:right;margin-top:15px;' >
	<form action="" class="navbar-form" role="search"  >
		<div class="input-group">
		<input type="text" class="form-control" placeholder="Search" id="UsersSearch"  name="search">
		 <div class="input-group-btn">
		<button class="btn btn-default" onclick="return getAllusersBySearch();" type="submit" value="Search" style='height:34px;'><i class="glyphicon glyphicon-search"></i></button>
	 </div>
        </div>
	</form> 
</div>


<!-- DIV FOR DELETE POPUP -->
	<div id="dialog" style="display: none" align = "center">
    <h1>User Deleted Successfully</h1>
    <input type="button" id="btnShow" class="btn btn-success" value="Close" onclick='getAllusers()'/>
</div>

<!--DIV FOR EIDT POPUP  -->
<div id="dialog1" style="display: none" align = "center">
    <h1>User Edited Successfully</h1>
    <input type="button" id="btnShow1" class='btn btn-success' value="Close" onclick='getAllusers()'/>
</div>
	<!--DIV TO DISPLAY USER DEATALS  -->
	<div id="user"></div>
	
	<!--DIV FOR EDIT USER DEATALS  -->
	<div id="edit">
		<div  class="row">
			<form class="well form-horizontal" id="add_user_info" action=" "
				method="post" id="contact_form">
				<fieldset>
					<h1 align="center">Edit User Details</h1>
				</fieldset>
				<fieldset>
					<input type="hidden" id="uid" name="uid" />
					<div class="form-group">
						<label class="col-md-4 control-label">First Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> 
									<input id="first_name" 
									name="First_name" placeholder="First Name"  class="form-control"
									type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">Last Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input id="last_name"
									name="Last_name" placeholder="Last Name" class="form-control"
									type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label">E-Mail</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input id="email"
									name="email" placeholder="E-Mail Address" class="form-control"
									type="text">
							</div>
						</div>
					</div>


					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Mobile No</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input id="phone"
									name="phone" placeholder="Enter mobile no "
									class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<button type="submit" class="btn btn-info" onclick="return editUser()"
								id="btnupd">
								Submit <span class="glyphicon glyphicon-send"></span>
							</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	
<jsp:include page="../common_ui/end.jsp"></jsp:include>
	
	
    <script type="text/javascript" src="<%=application.getContextPath()%>/java_script/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/tether.min.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>
<script type="text/javascript">
/**
 * @author SAGARKOMMU,GANESH
 * DESCRIPTION:JSP PAGE TO VIEW ,EDIT ,REMOVE USERS
 */
	
	 $(document).ready(function() {
		getAllusers(); 
	}); 

	 $(document)
		.ready(
				function() {
					$('#add_user_info').bootstrapValidator(
									{
										// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											First_name : {
												validators : {
													stringLength : {
														min : 5,
													},
													 regexp: {
									                        regexp: /^[a-zA-Z_\s.]+$/,
									                        message: 'The username can only consist of alphabetical, number, dot and underscore'
									                    },
												
													notEmpty : {
														message : 'The First Name is required and cannot be empty'
													}
												}
											},
											Last_name : {
												validators : {
													stringLength : {
														min : 3,
													},
													regexp: {
								                        regexp: /^[a-zA-Z_\s.]+$/,
								                        message: 'The username can only consist of alphabetical, number, dot and underscore'
								                    },
													notEmpty : {
														message : 'The Lastname is required'
													}
												}
											},
											email: {
								                validators: {
								                    notEmpty: {
								                        message: 'The email address is required and cannot be empty'
								                    },
								                    regexp: {
								                        regexp: /^[a-zA-Z0-9][a-zA-Z0-9-.]*@gmail[.]com$/,
								                        message: "Invalid Email number"
								                    },
												
								                    emailAddress :{
								                    	message : 'Please supply a valid email address'
								                    }
								                }
								            },
	   
								            phone: {
												validators : {
													notEmpty : {
														message : 'Please supply your phone number'
													},
												    regexp: {
								                        regexp: /^[7-9][0-9]{9}$/,
								                        message: "Invalid Phone number"
								                    }
												}
								        }
										}
										});
				});
			
	/* AJAX CALL TO GET ALL USERS  */
	function getAllusers() {
		$(edit).hide();
		$(dialog).hide();
		$("#UserSearch").show();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetAllUsers",
			success : function(data) {
				var user = document.getElementById("user");
				$(user).show();
				$(user).empty();
				$(user).append("<h1 align='center'>LIST OF USERS</h1>");
				if(data.length==0){
					$(user).append("<h1 align='center'style='color:red;margin-top:150px;'>No Users Found</h1>");
				}else
			$.each(	data,function(index) {
				$(user).append(
							"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
							+data[index].userId
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
							+data[index].fname
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
							+data[index].email
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Mobile</td><td style='font-size: 18px'> <label>"
							+data[index].mobileNo
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Role</td><td style='font-size: 18px'> <label>"
							+data[index].role
							+"</label> </td></tr> </table><div><button class='btn btn-success' style='float: right;margin-left:5px;' onclick='return editForm("+data[index].userId+")'>Edit</button></div>&nbsp;&nbsp;&nbsp;<button class='btn btn-primary' style='float: right;' onclick='return removeUser("+data[index].userId+")'>Remove</button></div><div style='float: left;width: 300px'><img class='img-thumbnail' src='"+data[index].img+"' width='150px' height='100px'/></div>");
			});
		
			}

		});

		
	}
	
	/* AJAX CALL GET USERS BY SEARCH */
	function getAllusersBySearch() {
		var search = document.getElementById("UsersSearch").value;
		$(edit).hide();
		$(dialog).hide();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetAllUserBySearch",
			data:{
				"search" : search
			},
			success : function(data) {
				var user = document.getElementById("user");
				$(user).show();
				$(user).empty();
				$(user).append("<h1 align='center'>LIST OF USERS</h1><div id = 'msg'></div>")
			$.each(	data,function(index) {
				$(user).append(
							"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
							+data[index].userId
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
							+data[index].fname
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
							+data[index].email
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Mobile</td><td style='font-size: 18px'> <label>"
							+data[index].mobileNo
							+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Role</td><td style='font-size: 18px'> <label>"
							+data[index].role
							+"</label> </td></tr> </table><div><button class='btn btn-success' style='float: right;margin-left:5px;' onclick='return editForm("+data[index].userId+")'>Edit</button></div>&nbsp;&nbsp;&nbsp;<button class='btn btn-primary' style='float: right;' onclick='return removeUser("+data[index].userId+")'>Remove</button></div><div style='float: left;width: 300px'><img class='img-thumbnail' src='"+data[index].img+"' width='150px' height='100px'/></div>");
			});
		
			}

		});
		return false;
		
	}

	/* AJAX CALL TO GET DATA INTO FORM TO EDIT */	
	function editForm(uid){
		$("#UserSearch").hide();
		$(edit).show();
		$(user).hide();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetUser",
			data : {
				"userid" : uid
			},
			success : function(data) {
				$('#uid').val( data.userId);
				$('#first_name').val(data.firstName);
				
				var ln = data.lastName;
				if(ln==undefined){
					ln="";
				}
				
				$('#last_name').val(ln);
				$('#email').val(data.email);
				document.getElementById('phone').value = data.mobileNo;
			}

		});
		return false;
	}
	
	/*AJAX CALL TO UPDATE USER DETAILS AFTER EIDT  */
	function editUser(){
		var uid=$("#uid").val();
        var First_name=$("#first_name").val();
        var Last_name=$("#last_name").val();
        var email=$("#email").val();
        var phone=$("#phone").val();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/EditUser",
			data : {
				"uid" :uid,
		  "First_name":First_name,
		   "Last_name":Last_name,
			   "email":email,
			   "phone": phone
			},
			success : function(data) {
				editPopUp();
				}
		});
		return false;
	}

	/*AJAX CALL TO REMOVE USER  */
	function removeUser(userId){
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/RemoveUserAction",
			data : {
				"userId" : userId
			},
			success : function(data) {
				removePopUp();
			}

		});
	}
	
	/*AJAX CALL TO GET REMOVE POPUP  */
	function removePopUp() {
        $("#dialog").dialog({
            modal: true,
            autoOpen: true,
            width: 400,
            height: 250
        });
        $("#btnShow").click(function () {
            $('#dialog').dialog('close');
        });
    }
	
	/*AJAX CALL TO GET EDIT POPUP  */
	function editPopUp() {
        $("#dialog1").dialog({
            modal: true,
            autoOpen: true,
            width: 400,
            height: 250
        });
        $("#btnShow1").click(function () {
            $('#dialog1').dialog('close');
        });
    }

</script>
</body>
</html>