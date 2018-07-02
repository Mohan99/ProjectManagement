<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AssignDevToTL</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/jquery-ui.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrapValidator.min.css">

<style type="text/css">
.container.well.form-horizontal {
    width: 100%;
}
</style>
</head>
	
<body>
<jsp:include page="../common_ui/start.jsp"></jsp:include>
<!--DIV FOR DEVELOPERS SEARCH  -->
	<div id="DevloperSearch"  class="col-sm-3 col-md-3" style='float:right;margin-top:15px;'>
	<form action="" class="navbar-form" role="search" >
		<div class="input-group">
		<input type="text" class="form-control" placeholder="Search" id="devSearch"  name="search">
		<div class="input-group-btn">
		<button class="btn btn-default" onclick="return searchDeveloper();" type="submit" value="Search" style='height:34px;' ><i class="glyphicon glyphicon-search"></i></button>
		</div>
        </div>
	</form>
 </div>
	
<!--DIV FOR TEAMLEADS SEARCH  -->
	<div id="TeamSearch" class="col-sm-3 col-md-3" style='float:right;margin-top:15px;'>
	<form action="" class="navbar-form" role="search">
		<div class="input-group">
		<input type="text" class="form-control" placeholder="Search" id="teamSearch"  name="search">
		 <div class="input-group-btn">
		<button class="btn btn-default" onclick="return searchTeamLead();" type="submit" value="Search" style='height:34px;' ><i class="glyphicon glyphicon-search"></i></button>
		</div>
        </div>
	
	</form> 
	</div>

<!--DIV FOR POPUP  -->
<div id="dialog" style="display: none" align = "center">
    <h1>User assigned Successfully</h1>
    <input type="button" class="btn btn-success" id="btnShow" value="Close" onclick='getDevelopers()'/>
</div>

<!--DIV FOR DEVELOPERS DEATAILS  -->
	<div id="user"></div>
	<!--DIV FOR TEAMLEADS  -->
	<div id="tl"></div>
	

<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/tether.min.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/java_script/jquery-ui.js"></script>

<script type="text/javascript">


/**
 * @author SAGARKOMMU,GANESH
 * DESCRIPTION:JSP PAGE TO ASSIGN DEVELOPERS TO TEAMLEADS
 */

var dev;
$(document).ready(function() {
	getDevelopers(); 
});
		/* AJAX CALL TO GET ALL DEVELOPERS  */
		function getDevelopers() {
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetDevelopers",
									success : function(data) {
											var user = document.getElementById("user");
											var tl = document.getElementById("tl");
											$(tl).hide();
											$("#DevloperSearch").show();
											$("#TeamSearch").hide();
											$(user).show();
											$(user).empty();
											$(user).append("<h1 align='center'>LIST OF DEVELOPERS</h1>");
											if(data.length==0){
												$(user).append("<h1 align='center'style='color:red;margin-top:150px;'>No Developers To Assign</h1>");
											}else
											$.each(data,function(index,obj) {
												$(user).append(
 																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
 																+obj.userId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
 																+obj.fname
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
 																+obj.email
 																+"</label> </td></tr> </table>"+"<button class='btn btn-info assign' uid='"+obj.userId+"' style='float: right;' >Assign to Team Lead</button></div><div style='float: left;width: 300px'><img src='"+obj.img+"' width='200px' height='150px'/></div>");
															});
											$(".assign").click(function(){
												var uid =$(this).attr("uid");
												TLSelection(uid);	
											});
										}

									});
	}
	
	/* AJAX CALL TO GET ALL TEAMLEADS  */
	function TLSelection(dev1){
		dev=dev1;
		$("#DevloperSearch").hide();
						$("#TeamSearch").show();
						var p="developer";
						$.ajax({
							type : "POST",
							url : "<%=application.getContextPath()%>/GetTeamLeads",
							data : {
								"p" :p 
							},
											success : function(data) {
												var tl = document.getElementById("tl");
												var user = document.getElementById("user");
												$(user).hide();
												$(tl).show();
												$(tl).empty();
												$(tl).append("<h1 align='center'>LIST OF TEAMLEADS</h1>")
												$.each(data,function(index,obj) {
																	$(tl).append(
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
													assignDev(tld,dev);
													
												});
										}

									});
		
		return false;
	}
	
	/* AJAX CALL TO ASSIGN DEVELOPERS  */
	function assignDev(userId,dev){
		var devId=dev;
		var tlId=userId;
		var p="developer";
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/AssignUsers",
			data : {
				"devId" :devId,
				  "tlId":tlId,
		 		  "p":p
			},
			success : function(data) {
				PopUp();
				
			}

		});
	}
	
	
	/* AJAX CALL TO SEARCH DEVELOPERS  */
	function searchDeveloper() {
		var search = document.getElementById("devSearch").value;
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetDevelopersBySearch",
			data :{
				"search" : search
			},
									success : function(data) {
											var user = document.getElementById("user");
											var tl = document.getElementById("tl");
											$(tl).hide();
											$(user).show();
											$(user).empty();
											$(user).append("<h1 align='center'>LIST OF DEVELOPERS</h1>");
											if(data.length==0){
												$(user).append("<h1 align='center'style='color:red;margin-top=150px;'>No Developer Found</h1>");
											}else
											$.each(data,function(index) {
												$(user).append(
 																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
 																+data[index].userId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
 																+data[index].fname
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
 																+data[index].email
 																+"</label> </td></tr> </table><button class='btn btn-success' style='float: right;' onclick='TLSelection("+data[index].userId+")'>Assign to Team Lead</button></div><div style='float: left;width: 300px'><img src='"+data[index].img+"' width='200px' height='150px'/></div>");
															});
										}

									});
		return false;
	}
	
	/* AJAX CALL TO SEARCH TEAMLEADS  */
	function searchTeamLead() {
		var search = document.getElementById("teamSearch").value;
		var p="developer";
		$("#DevloperSearch").hide();
		$("#TeamSearch").show();
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/GetTeamLeadsBySearch",
			data :{
				"search" : search,
				"page":p
			},
									success : function(data) {
											var user = document.getElementById("user");
											var tl = document.getElementById("tl");
											$(tl).hide();
											$(user).show();
											$(user).empty();
											$(user).append("<h1 align='center'>LIST OF Team Lead</h1>");
											if(data.length==0){
												$(user).append("<h1 align='center'style='color:red;margin-top=150px;'>No Team Lead Found</h1>");
											}else
											$.each(data,function(index) {
												$(user).append(
 																"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
 																+data[index].userId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Name </td> <td style='font-size: 18px'><label>"
 																+data[index].fname
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
 																+data[index].email
 																+"</label> </td></tr> </table><button class='btn btn-info' style='float: right;' onclick='assignDev("+data[index].userId+","+dev+")'>Assign</button></div><div style='float: left;width: 300px'><img src='"+data[index].img+"' width='200px' height='150px'/></div>");
															});
										}

									});
		return false;
	}

	/* AJAX CALL TO SUCESSPOPUP  */
	function PopUp() {
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
	
	
	
	
	
	
</script>

</body>
</html>