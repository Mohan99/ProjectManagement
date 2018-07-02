
<!--@author pavan kumar y  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AssignModuleTotl</title>

</head>
<body id="div1">
<jsp:include page="../common_ui/start.jsp"></jsp:include>
<div id="user"></div>
	<div id="tl"></div>



<div class="" >

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
		
</div>

<jsp:include page="../common_ui/end.jsp"></jsp:include>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/java_script/bootstrapValidator.min.js"></script>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/bootstrapValidator.min.css">
<script src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>

 <%--  <script type="text/javascript"
	src="<%=application.getContextPath()%>/java_script/jquery.js"></script>   --%>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/java_script/Assignmoduleto_TL.js"></script> 

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "<%=application.getContextPath()%>/getmodules",
											success : function(data) {
								if(data.success!=undefined){
															data=data.success;				
											var user = document.getElementById("user");
											var pm = document.getElementById("pm");
											var tl = document.getElementById("tl");
											$(pm).hide();
											$(tl).hide();
											$(user).show();
											$(user).empty();
											$.each(data,function(index) {
												if(data[index].userid ==0){
												$(user).append(
 															 	 "<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >ProjectTitle</td><td style='font-size: 18px';><label>"
 														    	+data[index].projectModuleDto.projectManagetProjectId.projectId.projectTitle
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>ModuleTitle </td> <td style='font-size: 18px'><label>"
 																+data[index].projectModuleDto.moduleTitle
 														    	+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Description</td><td style='font-size: 18px'> <label>"
 																+data[index].projectModuleDto.moduleDescription
 																+"</label> </td></tr> </table><button class='btn btn-warning assign'  style='float: right;' moduleid='"+data[index].projectModuleDto.projectModuleId+"'>Assign to Team Lead</button></div>"); 
																	
											      	}//if
											      	else{
											      		$(user).append(
											      		
											      				 "<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >ProjectTitle</td><td style='font-size: 18px';><label>"
 														    	+data[index].projectModuleDto.projectManagetProjectId.projectId.projectTitle
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>ModuleTitle </td> <td style='font-size: 18px'><label>"
 																+data[index].projectModuleDto.moduleTitle
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Description</td><td style='font-size: 18px'> <label>"
 																+data[index].projectModuleDto.moduleDescription
 																+"</label> </td></tr> </table><button class='btn btn-info' style='float: right;' data-toggle='collapse' data-target='#demo"+data[index].projectModuleDto.projectModuleId+"' >view Team Lead</button></div>"
 																+"</div></div>"
											      				
											      		     +"<div id='demo"+data[index].projectModuleDto.projectModuleId+"' class='container bg-warning form-horizontal collapse' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >Name</td><td style='font-size: 18px';><label>"
															+data[index].name
															+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>Email </td> <td style='font-size: 18px'><label>"
															+data[index].email
															+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>ModileNo</td><td style='font-size: 18px'> <label>"
															+data[index].mobileNo
															+"</label> </td></tr> </table><button class='btn btn-warning assign' style='float: right;'  tLId='"+data[index].userid+"' moduleid='"+data[index].projectModuleDto.projectModuleId+"' >change TeamLead</button></div>"
															+"<div id='demo"+data[index].projectModuleDto.projectModuleId+"'><img src='"+data[index].image+"' width='200px' height='150px'/></div></div>"); 
											      				
											      				
											      				
											      				
											      		
											      		
											      				/* "<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >ModuleTitle</td><td style='font-size: 18px';><label>"
 																+data[index].moduleTitle
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>ModuleID </td> <td style='font-size: 18px'><label>"
 																+data[index].projectModuleId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Description</td><td style='font-size: 18px'> <label>"
 																+data[index].moduleDescription
 																+"</label> </td></tr> </table><div id='demo"+data[index].projectModuleId+"' style='position:relative;top:30px;'><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >ModuleTitle</td><td style='font-size: 18px';><label>"
 																+data[index].moduleTitle
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>ModuleID </td> <td style='font-size: 18px'><label>"
 																+data[index].projectModuleId
 																+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Description</td><td style='font-size: 18px'> <label>"
 																+data[index].moduleDescription
 																+"</label> </td></tr> </table><div style='float: left;width: 300px;position:relative;right:300px;bottom:100px;'><img src='"+data[index].teamLeadId.image+"' width='200px' height='150px'/></div></div><button class='btn btn-info' style='float: right;' data-toggle='collapse' data-target='#demo"+data[index].projectModuleId+"' >view Team Lead</button></div>");  */
															
															 	
											      				
											      	}//else
													 });
											
											$(".assign").click(function(){
												var mid=($(this).attr("moduleid"));
												alert(mid);
												$.ajax({
													type : "POST",
													url : "<%=application.getContextPath()%>/GetTeamLeadsForModule",
																	success : function(data) {
														
																		if(data.success!=undefined){
																			
																		data =data.success;	
																		
																		var tl = document.getElementById("tl");
																		var user = document.getElementById("user");
																		
																		alert("datasdvsd"+data);
																		
																		
																		$(user).hide();
																		$(tl).show();
																		$(tl).empty();
																		
																		
																	
																		$.each(data,function(index) {
																							$(tl).append(
																										"<div class='container well form-horizontal' style='width:800px' ><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >UserID </td><td style='font-size: 18px';><label>"
																										+ data[index].userid
																										+ "</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>Name </td> <td style='font-size: 18px'><label>"
																										+ data[index].name
																										+ "</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Email</td><td style='font-size: 18px'> <label>"
																										+ data[index].email
																										+ "</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>MobileNo</td><td style='font-size: 18px'> <label>"
																										+ data[index].mobileNo
																										+ "</label> </td></tr> </table><input class='btn btn-warning'  style='float: right;'  onclick='Assignmoduleto_Tl(this);' tLId='"+data[index].userid+"' moduleid='"+mid+"' type='button' value='Assign' data-target='#edmsgModal' data-toggle='modal'/></div>"
																										+"<div style='float: left;width: 300px'><img src='"+data[index].image+"' width='200px' height='150px'/></div>");
																							            
																								});
																	}else{
																		if(data.err!=undefined){
																		alert(data.err);																	
																					
																		}
																		
																		
																	}
																	}

																});
												return false;
												
											});
											
											
											
										}//success
											else{
												if(data.err!=undefined){
													
													alert(data.err);
												}
												
											}

									}//ajax success
		});
									
						});


</script>
<!-- <style type="text/css">
#a{
position: absolute;
position:relative;
right: 10px;
top: 10;
}
</style> -->

</body>
</html>

 