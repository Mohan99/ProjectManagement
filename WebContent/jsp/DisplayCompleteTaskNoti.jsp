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
<%-- ${ dtDet} --%>
<c:if test="${not empty dtDet}">

<c:forEach var="det" items="${dtDet}">
<div class='row'>

<!-- PRoJECT INF -->
<div class='col-md-4'>
<div>
<p>
ProjectId:${det.projectId}
Project Title : ${det.projectTitle}
Project Description: ${det.projectDescription}
ExpectedStartDate: ${det.expectedStartDate} 
ExceptedEndDate: ${det.exceptedEndDate}
ProjectModuleid :${det.projectModuleid}


</p>
<div class="panel panel-default">
  <div class="panel-heading">Developer Information</div>
  <div class="panel-body">
  
  <img alt="" class='img-circle' width="100px" height="100px" src="${det.promgrimage}">
  NAME : ${det.promgrFirstName}
  EMAIL:${det.promgremail}
  MobileNo:${det.promgrMobileNo}
  </div>
</div>
</div>

</div>
<!-- MDULE INF -->
<div class='col-md-4'>
<div>
<p>
Module Title:${det.moduleTitle} 
Module Description:${det.moduleDescription}
</p>
<div class="panel panel-default">
  <div class="panel-heading">TeamLeader</div>
  <div class="panel-body">
  
  <img alt="" class='img-circle' width="100px" height="100px" src="${det.temledimage}">
  NAME : ${det.temledFirstName}
   EMAIL:${det.temledemail}
  MONILENo:${det.temledMobileNo}
  </div>
</div>
</div>


<!-- TASK INF -->
<div class='col-md-4'>
<div>
<p>

TaskTitle: ${det.taskTitle}
TaskDescription: ${det.taskDescription} 
</p>
<div class="panel panel-default">
  <div class="panel-heading">TeamLeader</div>
  <div class="panel-body">
  
  <img alt="" class='img-circle' width="100px" height="100px" src="${det.devimage}">
  NAME : ${det.devFirstName}
   EMAL:${det.devemail}
  MobleNo:${det.devMobileNo}
  </div>
</div>

</div>

</div>

</c:forEach>
</c:if>

 

</div>


</div>
<jsp:include page="../common_ui/footer.jsp"></jsp:include>

</body>
</html>