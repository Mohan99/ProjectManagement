

<!-- @ author Rajkishore-->

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
        
        
       <!--  https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css
https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css -->
        
        
        <link rel="stylesheet" href="<%=application.getContextPath()%>/css/dataTables.bootstrap.min.css">
         <link rel="stylesheet" href="<%=application.getContextPath()%>/css/responsive.bootstrap.min.css">
         <title>viewTask</title>

    </head>
    <body>

<jsp:include page="../common_ui/start.jsp"></jsp:include>
    <div >
    
    		<c:if test="${success ne null }" >
			<div class="alert alert-success alert-dismissable">
  <a href="<%=application.getContextPath()%>/viewTaskAction" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${success}
</div>
	</c:if>
	<c:remove var="success"/>
	<c:if test="${err ne null }" >
			<div class="alert alert-danger alert-dismissable">
  <a href="<%=application.getContextPath()%>/viewTaskAction" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>ERROR!</strong> ${err}
</div>
	</c:if>
	<c:remove var="err"/>
    
     
     		<c:if test="${result ne null }" var="msg">
			<div class="alert alert-success alert-dismissable">
  <a href="<%=application.getContextPath()%>/viewTaskAction" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>

			<%-- 
			<h3 style="color: green; text-align: center;">
				<b>${result}</b>
			</h3> --%>
			
		</c:if>
		<c:remove var='result' />


			
     
     <h2 style="text-align: center;">
					<label> View Tasks</label>
				</h2>
				
				
				
    <table id="example" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%"> 
   
       <thead>
            <tr>
           
            <th>TaskTitle</th>
            <th>TaskDescription</th>
            <th>TaskReferenceDocument</th>
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


          
          <tr>
             
             <td>${task.moduleTaskId.taskTitle}</td>
             <td>${task.moduleTaskId.taskDescription}</td>
            <c:choose>
            <c:when test="${task.moduleTaskId.documentNameWithExtension ne null||' ' }">
            
            <td>
            
            
            <a href="<%=application.getContextPath()%>/DownloadTaskDocumentActon?moduleTaskId=${task.moduleTaskId.moduleTaskId}"  title="Download Document" style="color: #197319">
          <span class="glyphicon glyphicon-download" style="color: #197319;"></span>${task.moduleTaskId.documentNameWithExtension}
          
        </a>
            
            </td>
            </c:when> 
            <c:otherwise>
                  <td>no document</td>
  </c:otherwise>
            </c:choose>
             
             <%-- <td>${task.documentNameWithExtension}</td> --%>
             <td><fmt:formatDate pattern="MM/dd/yyyy" value="${task.moduleTaskId.startDate}"/></td>
             <td> <fmt:formatDate pattern="MM/dd/yyyy" value="${task.moduleTaskId.endDate}"/></td>
             <%-- <td>${task.projectModuleId.projectModuleId}</td>
             <td>${task.statusId.statusId}</td> --%>
             <td>${task.moduleTaskId.taskCompletionPercent}</td>
             <td >
             
              
             <a href="<%=application.getContextPath()%>/ViewTaskDetailsAction?moduleTaskId=${task.moduleTaskId.moduleTaskId}" class="btn btn-info btn-lg" title="Veiw Tasks Details" >
          <span class="glyphicon glyphicon-eye-open" style="color: black;"></span> View
        </a>
             
             <div  style="float: right;margin-left: 5px;"> 
             <a href="<%=application.getContextPath()%>/jsp/taskStatus.jsp?developerTaskId=${task.developerTaskId}"  class="btn btn-info btn-lg" title="Update Tasks">
          <span  class="glyphicon glyphicon-plus" ></span> Add Status
        </a>
            
            
            
             
             
              </div>
             
             
             
             </td>
            
             
          </tr>
        
        



</c:forEach>

</c:if>
</tbody>
   </table>     
        
       
        
        </div>
       
        
        <!-- </div> -->
        
       <%-- <jsp:include page="../common_ui/end.jsp"></jsp:include> --%>
        
  <script src="<%=application.getContextPath() %>/java_script/jquery.min.js"></script>
  <script src="<%=application.getContextPath() %>/java_script/jquery.dataTables.min.js"></script>
  <script src="<%=application.getContextPath() %>/java_script/dataTables.responsive.min.js"></script>
   <script src="<%=application.getContextPath() %>/java_script/responsive.bootstrap.min.js"></script>
  <script src="<%=application.getContextPath() %>/java_script/dataTables.bootstrap.min.js"></script>
  
  
  
  
  
   <script>
        
    
    

     $(document).ready(function() {
    	    $('#example').DataTable(
    				{
    					"pagingType" : "full_numbers",
    					"lengthMenu" : [ [ 3, 5, 10, 25, 50, -1 ],
    							[ 3, 5, 10, 25, 50, "All" ] ],
    					"pageLength" : 3
    				});

    	        } );


</script>
           
       <jsp:include page="../common_ui/end.jsp"></jsp:include> 
        
    </body>
</html>
