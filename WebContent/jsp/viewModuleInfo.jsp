<!-- @ author pavankumar y-->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
     
<!doctype html>
<html lang = "en">
   <head>
      <meta charset = "utf-8">
      <link href = "<%=request.getContextPath()%>/css/jquery-ui.css"
         rel = "stylesheet">
      <style>
         #accordion-2{font-size: 14px;}
      </style>
      
   </head>
   
   <body>
   <jsp:include page="../common_ui/start.jsp"></jsp:include>
   		<h2 style="color:blue;">Module Information</h2>
   
      <div id = "accordion-2">
         <h3> PROJECT INFO</h3>
         <div id="collapse1" class="panel-collapse collapse in">
					<div class='container well form-horizontal' style='width:900px;'>
						<div style='float: left; width: 900px;'>
							<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectTitle:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${sessionScope.moduleInfo.projectDto.projectTitle}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Description:
									</td>
									<td style='font-size: 20px';><c:out
											value="${moduleInfo.projectDto.projectDescription}"></c:out></td>
								</tr>
							</table>						
					</div>
				</div>
			</div>
         <h3>PROJECT MANAGER INFO</h3>
         <div id="collapse2" class="panel-collapse collapse">
					<div class='container well form-horizontal' style='width:900px;'>
						<div style='float: left; width: 900px;'>
							<div style='float: right; width: 300px'>
								<img src="${moduleInfo.pmimage}" width='200px' height='150px' />
							</div>
							<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManager:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${moduleInfo.userDto.firstName}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
									</td>
									<td style='font-size: 20px';><c:out
											value="${moduleInfo.userDto.email}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${moduleInfo.userDto.mobileNo}"></c:out></label></td>
								</tr>
							</table>
						</div>
					</div>
				</div>


         <h3>PROJRCT MODULE INFO</h3>
        <div id="collapse3" class="panel-collapse collapse">
						<div class='container well form-horizontal' style='width:900px;'>
							<div style='float: left; width: 900px;'>
								<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ModuleTitle:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${moduleInfo.projectModuleDto.moduleTitle}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Description:
									</td>
									<td style='font-size: 20px';><c:out
											value="${moduleInfo.projectModuleDto.moduleDescription}"></c:out></td>
								</tr>
							</table>
							</div>
						</div>
					</div>
         <h3>TEAM LEAD INFO</h3>
         <div id="collapse4" class="panel-collapse collapse">
						<div class='container well form-horizontal' style='width:900px;'>
							<div style='float: left; width: 900px;'>
								<c:choose>
						<c:when test="${moduleInfo.userid != 0}">
							<div style='float: right; width: 300px'>
								<img src="${moduleInfo.image}" width='200px' height='150px' />
							</div>
							<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>TeamLead:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${moduleInfo.fname}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
									</td>
									<td style='font-size: 20px';><c:out
											value="${moduleInfo.email}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${moduleInfo.mobileNo}"></c:out></label></td>
								</tr>
							</table>
							</c:when>
							<c:otherwise>
				     	  <div><h3 style="color: red">Team Lead not Assigned</h3></div>
				        	</c:otherwise>
				          </c:choose>
							</div>
						</div>
					</div>
					
		      </div>

<%-- <a href="<%=request.getContextPath()%>/viewmodules"><input
	          	type="button" value="Back" style="width:100px;height:40px;color:orange;"></a>
	          	 --%>
<a href="<%=application.getContextPath()%>/viewmodules" class="btn btn-info" role="button" title=" Record">Back</a>
	          	
	          	
	          	
<jsp:include page="../common_ui/end.jsp"></jsp:include>
 <script src = "<%=request.getContextPath()%>/java_script/jquery-ui.js"></script>
      <script>
         $(function() {
            $( "#accordion-2" ).accordion({
               collapsible: true
            });
         });
      </script>
      
     
   </body>
</html>