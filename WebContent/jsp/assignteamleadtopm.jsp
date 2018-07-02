<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign TL to PM</title>
<style type="text/css">
.container.well.form-horizontal {
    width: 90%;
}
</style>

</head>
<body>
<jsp:include page="../common_ui/start.jsp"></jsp:include>

<!--DIV FOR TEAMLEAD SEARCH  -->
	<div id="TeamSearch" class="col-sm-3 col-md-3" style='float:right;margin-top:15px;'>
		<form action="" class="navbar-form" role="search">
			<div class="input-group">
			<input type="text"  class="form-control" placeholder="Search" id="teamSearch" name="search">
			 <div class="input-group-btn">
			<button	class="btn btn-default" onclick="return searchTeamLead();" type="submit" value="Search" style='height:34px;'><i class="glyphicon glyphicon-search"></i></button>
		</div>
		</div>
		</form>
	</div>
	
	<!--DIV FOR PROJECT MANAGER SEARCH  -->
	<div id="PMSearch" class="col-sm-3 col-md-3" style='float:right;margin-top:15px;'>
		<form action="" class="navbar-form" role="search">
			<div class="input-group">
			<input type="text"  class="form-control" placeholder="Search" id="PmSearch" name="search">
			 <div class="input-group-btn">
			<button	class="btn btn-default" onclick="return searchPM();" type="submit" value="Search" style='height:34px;'><i class="glyphicon glyphicon-search"></i></button>
		</div>
		</div>
		</form>
	</div>
	
	<!--DIV FOR POPUP  -->
	<div id="dialog" style="display: none" align="center">
		<h1>User assigned Successfully</h1>
		<input type="button" class="btn btn-success" id="btnShow" value="Close"
			onclick='getTeamleads()' />
	</div>
	
	<!--DIV FOR DISPLAY TEAMLEAD DEATAILS  -->
	<div id="user"></div>
	
	
	<!--DIV FOR DISPLAY PROJECT MANAGER DEATILS -->
	<div id="pm"></div>
	</div>
	</div>
	
	
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
	
	<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/tether.min.js"></script>
    <script type="text/javascript" src="<%=application.getContextPath()%>/java_script/bootstrapValidator.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/jquery-ui.css">

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrapValidator.min.css">

	
	
	<script type="text/javascript">
/**
 * @author SAGARKOMMU,GANESH
 * DESCRIPTION:JSP PAGE TO ASSIGN TEAMLEADS TO PROJECT MANAGERS
 */

$(document).ready(function() {
	getTeamleads(); 
});


/* AJAX CALL TO GET TEAMLEADS */
	function getTeamleads() {
		var p="teamlead";
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetTeamLeads",
			data : {
				"p" : p
			},
			success : function(data) {
										var tl = document.getElementById("tl");
										var user = document.getElementById("user");
										var pm = document.getElementById("pm");
										$("#TeamSearch").show();
										$("#PMSearch").hide();
										$(user).show();
										$(tl).hide();
										$(user).empty();
										$(pm).hide();
										$(user).append("<h1 align='center' style='color:blue;'>LIST OF TEAMLEADS</h1>");
										if(data.length==0){
											$(user).append("<h1 align='center'style='color:red;margin-top:150px;'> No Teamleads Found to Assign</h1>");
										}else{
											$.each(data,function(index,obj) {
												$(user).append(
 																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
 																+obj.userId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
 																+obj.fname
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
 																+obj.email
 																+"</label> </td></tr> </table>"+"<button class='btn btn-info assign' uid='"+obj.userId+"' style='float: right;' >Assign to Project Manager</button></div><div style='float: left;width: 300px'><img src='"+obj.img+"' width='200px' height='150px'/></div>");
															});
											
											$(".assign").click(function(){
												var uid =$(this).attr("uid");
												PMSelection(uid);	
											});
										}

									}
		});
	}

	
	
/* GLOBAL VARIABLE TO STORE TEAMLEAD ID  */	
var dev ;

/* AJAX CALL TO GET PROJECT MANAGERS */
function PMSelection(dev1){
		dev=dev1;
	   $("#TeamSearch").hide();
		$("#PMSearch").show();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetProjectManager",
							success : function(data) {
								var user = document.getElementById("user");
								$(user).hide();
								$(pm).show();
								$(pm).empty();
								$(pm).append("<h1 align='center'style='color:blue;'>LIST OF PROJECT MANAGERS</h1>")
								$.each(data,function(index,obj) {
													$(pm).append(
																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
																+ obj.userId
																+ "</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
																+ obj.fname
																+ "</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
																+ obj.email
																+ "</label> </td></tr> </table><button tlid='"+obj.userId+"'   class='btn btn-success tlid' style='float: right;' >Assign</button></div><div style='float: left;width: 300px'><img src='"+obj.img+"' width='200px' height='150px'/></div>");
											});
								
								
								$(".tlid").click(function(){
									var tld =$(this).attr("tlid");
									assignTl(tld,dev);
									
								});

						}

					});
return false;
	}
	
	
	
/* AJAX CALL TO ASSIGN TEAMLEADS TO PM */	
function assignTl(userId,dev){
	var devId=dev;
	var tlId=userId;
	var p="teamlead";
	$.ajax({
		type : "POST",
		url : "<%=application.getContextPath()%>/AssignUsers",
			data : {
				"devId" : devId,
				"tlId" : tlId,
				"p" : p
			},
			success : function(data) {
				popUp();
			}

		});

	}
	
/* AJAX CALL TO SEARCH TEAMLEADS */
function searchTeamLead() {
	var search = document.getElementById("teamSearch").value;
	var p="teamlead";
	$.ajax({
		type : "POST",
		url : "<%=application.getContextPath()%>/GetTeamLeadsBySearch",
		data :{
			"search" : search,
			"page":p
		},
								success : function(data) {
									var tl = document.getElementById("tl");
									var user = document.getElementById("user");
									var pm = document.getElementById("pm");
									$(user).show();
									$(tl).hide();
									$(user).empty();
									$(pm).hide();
									$(user).append("<h1 align='center' style='color:blue;'>LIST OF TEAMLEADS</h1>");
									if(data.length==0){
										$(user).append("<h1 align='center'style='color:red;margin-top:150px;'>No Team Lead Found</h1>");
									}else
										$.each(data,function(index,obj) {
										//	alert(data);
											
											$(user).append(
																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
																+obj.userId
																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
																+obj.fname
																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
																+obj.email
																+"</label> </td></tr> </table>"+
																"<button class='btn btn-info' style='float: right;' onclick=\"PMSelection('"+obj.userId+"');\">Assign to Project Manager</button></div><div style='float: left;width: 300px'><img src='"+obj.img+"' width='200px' height='150px'/></div>");
														});
									}

								});
	return false;
}

/* AJAX CALL TO SEARCH PROJECTMANAGER */	
function searchPM() {
	var search = document.getElementById("PmSearch").value;
	$("#TeamSearch").hide();
	$("#PMSearch").show();
	
	$.ajax({
		type : "POST",
		url : "<%=application.getContextPath()%>/GetProjectMangerBySearch",
					data : {
						"search" : search
					},
					success : function(data) {
						var user = document.getElementById("user");
						$(user).hide();
						$(pm).show();
						$(pm).empty();
						$(pm).append("<h1 align='center' style='color:blue;'>LIST OF PROJECT MANAGERS</h1>");
						$.each(data,function(index,obj) {
							$(pm).append(
												"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
												+obj.userId
												+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
												+obj.fname
												+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
												+obj.email
												+"</label> </td></tr> </table><button class='btn btn-info' style='float: right;' onclick='assignTl("+obj.userId+","+dev+")'>Assign</button></div><div style='float: left;width: 300px'><img src='"+data[index].img+"' width='200px' height='150px'/></div>");
										});				
						}

				});
		return false;
	}

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
</script>
	
</body>
</html>