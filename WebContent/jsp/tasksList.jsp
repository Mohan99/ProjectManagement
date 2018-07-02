

<!-- Chakravarthi k-->

 
  
  
<%@page import="com.nacre.daoi.daoimpl.TaskManagementDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nacre.dto.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        

<link href="<%=application.getContextPath() %>/css/dataTables.bootstrap.min.css">
        
    </head>
    <body>

<jsp:include page="../common_ui/start.jsp"></jsp:include>
    <div >
     
     		<c:if test="${result ne null }" var="msg">
			<div class="alert alert-success alert-dismissable">
  <a href="<%=application.getContextPath()%>/GetTaskDetailsByDev" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>
			<%-- 
			<h3 style="color: green; text-align: center;">
				<b>${result}</b>
			</h3> --%>
			
		</c:if>
		<c:remove var='result' />


			<c:if test="${err ne null }" var="msg">
						<div class="alert alert-danger alert-dismissable">
  <a href="<%=application.getContextPath()%>/GetTaskDetailsByDev" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Failure!</strong> ${err}
</div>	
</c:if>

		<c:remove var='err'  />

			
     
     <h1 style="text-align: center;">
					<label>Tasks Details</label>
				</h1>
				
    <table class="table table-striped" id="example"> 
   
       <thead>
            <tr style="background-color:#f2f2f2;height: 40px;">
           
            <th>TaskTitle</th>
            <th>TaskDescription</th>
            <th>StartDate</th>
            <th>EndDate</th>
            
            <th>TaskCompletionPercentage</th>
            <th>Action</th>
            
          </tr> 
          </thead>   
    <tbody>         
 <c:if test="${tasks ne null }">

<%-- ${tasks } --%>
<c:forEach var="task" items="${tasks}">
  
  <!-- expression language for viewing object respectively -->


          
          <tr style="background-color:#f2f2f2">
             
             <td>${task.taskTitle}</td>
             <td>${task.taskDescription}</td>
             
             <%-- <td>${task.documentNameWithExtension}</td> --%>
             <td><fmt:formatDate pattern="MM/dd/yyyy" value="${task.startDate}"/></td>
             <td> <fmt:formatDate pattern="MM/dd/yyyy" value="${task.endDate}"/></td>
             <%-- <td>${task.projectModuleId.projectModuleId}</td>
             <td>${task.statusId.statusId}</td> --%>
             <td>${task.taskCompletionPercent}</td>
             <td >
             
             <a href="#" class="btn btn-primary btn-md" role="button" title="Veiw Details">Update Status</a>
             </td>
             
          </tr>
        
        



</c:forEach>

</c:if>
</tbody>
   </table>     
        
       
        
        </div>
        <!-- </div> -->
        
        <jsp:include page="../common_ui/end.jsp"></jsp:include>
          <script src="<%=application.getContextPath() %>/java_script/dataTables.bootstrap.min.js"></script>
  
  <!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
        
        <title>viewTask</title>
        
    </body>
</html>
