<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>



<div class='row'>
<div class='col-md-3'>


  <jsp:include page="../common_ui/menu.jsp"></jsp:include>
</div><jsp:include page="../common_ui/header.jsp"></jsp:include>
<div class='col-md-9'>

 
   <c:if test="${not empty supid}">
 <c:forEach var="det1" items="${supid}">  
<div class='row'>
<!-- PRoJECT INF -->
<div class='col-md-4'>
<div>
<p>
  ProjectId:  ${det1.projectId}
   Project Title :  ${det1.projectTitle}
   Project Description:  ${det1.projectDescription}
   ProjectModuleId: ${det1.projectModuleId} 
ModuleTitle: ${det1.moduleTitle} 
ModuleDescription: ${det1.moduleDescription}
TaskTitle: ${det1.taskTitle}
TaskDescription: ${det1.taskDescription}
StatusId: ${det1.statusId }
Status: ${det1.status }
DeveloperTaskId:${det1.developerTasKId}
 
</p>
<div class="panel panel-default">
  <div class="panel-heading">Developer Information</div>
  <div class="panel-body">
  
  <img alt="" class='img-circle' width="100px" height="100px" src="${det1.image}"/>
  NAME : ${det1.firstName}
  EMAIL:${det1.email}
  MobileNo:${det1.mobileNo}
  </div>
</div>
</div>

</div>
<!-- MDULE INF -->
</div>

 </c:forEach>  
</c:if>

 

</div>


</div>
<jsp:include page="../common_ui/footer.jsp"></jsp:include>

</body>
</html>