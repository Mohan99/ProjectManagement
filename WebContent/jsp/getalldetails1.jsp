<!doctype html>
<html lang = "en">
   <head>
      <meta charset = "utf-8">
      <link href = "<%=application.getContextPath() %>/java_script/jquery-ui.css"
         rel = "stylesheet">
          <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
        
      <style>
         #accordion-2{font-size: 14px;}
         .row .bg-info{
         padding-left:30px; 
         }
      </style>
      
   </head>
   
   <body>
   	
   	<jsp:include page="../common_ui/start.jsp"></jsp:include>
   		<h2 style="color:blue;">Module Information</h2>
   
      <div id = "accordion-2">
         <h3> PROJECT INFO</h3>
         <div id="collapse1" class="panel-collapse collapse in">
					<div class='row bg-info'>
						<div style='float: left; '>
							<table>
							<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectId:
									</td>
									<td style='font-size: 20px;'><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectId.projectId}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectTitle:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectId.projectTitle}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectDescription:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto. projectManagetProjectId.projectId.projectDescription}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>expectedStartDate:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto. projectManagetProjectId.projectId.expectedStartDate}"></c:out></td>
								</tr>
								
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>expectedEndDate:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto. projectManagetProjectId.projectId.expectedEndDate}"></c:out></td>
								</tr>
								
							</table>						
					</div>
				</div>
			</div>
         <h3>PROJECT MANAGER INFO</h3>
         <div id="collapse2" class="panel-collapse collapse">
					<div class='row bg-info'>
						<div style='float: left; width: '>
							<div style='float: right; width: 300px'>
								<img src="${bean.tmImage}" class='img-thumbnail' width='200px' height='150px' />
							</div>
							<table>
							<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManagerId:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.userId}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManagerFirstname:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.firstName}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ProjectManagerLastname:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.lastName}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
									</td>
									<td style='font-size: 20px';><label><c:out
											value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.email}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.mobileNo}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Gender:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. projectManagetProjectId.projectManagerId.gender}"></c:out></label></td>
								</tr>
								
							</table>
						</div>
					</div>
				</div>


         <h3>PROJRCT MODULE INFO</h3>
        <div id="collapse3" class="panel-collapse collapse">
						<div class='row bg-info'>
							<div style='float: left; '>
								<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ModuleId:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto.projectModuleId}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>ModuleTitle:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto.moduleTitle}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Description:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto.moduleDescription}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>startDate:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto.startDate}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>endDate:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto.endDate}"></c:out></td>
								</tr>
							</table>
							</div>
						</div>
					</div>
         <h3>TEAM LEAD INFO</h3>
         <div id="collapse4" class="panel-collapse collapse">
						<div class='row bg-info'>
							<div style='float: left;'>
								<c:choose>
						<c:when test="${bean.projectModuleDto. teamLeadId.userId!=0}">
							<div style='float: right; width: 300px'>
								<img src="${bean.tmImage}" class='img-thumbnail'width='150px' height='150px'/>
							</div>
							<table>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>TeamLeadFirstname:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. teamLeadId.firstName}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>TeamLeadlastname:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. teamLeadId.lastName}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Email:
									</td>
									<td style='font-size: 20px';><c:out
											value="${bean.projectModuleDto. teamLeadId.email}"></c:out></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>MobileNo:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. teamLeadId.mobileNo}"></c:out></label></td>
								</tr>
								<tr>
									<td
										style='font-size: 25px; color: green; width: 200px; line-height: 40px;'>Gender:
									</td>
									<td style='font-size: 20px';><label><c:out
												value="${bean.projectModuleDto. teamLeadId.gender}"></c:out></label></td>
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
		      
		      <jsp:include page="../common_ui/end.jsp"></jsp:include>
	
	<script type="text/javascript" src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>
		       <script>
         $(function() {
            $( "#accordion-2" ).accordion({
               collapsible: true
            });
         });
      </script>
   
		      
		      
   </body>
</html>