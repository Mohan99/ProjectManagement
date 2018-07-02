<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<link href="<%=application.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=application.getContextPath()%>/css/header.css" rel="stylesheet">

<link href="<%=application.getContextPath()%>/css/menu.css" rel="stylesheet">
<link href="<%=application.getContextPath()%>/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/bootstrap.min.js"></script>

<script>
var path = "<%=application.getContextPath()%>";
</script>

<%-- HEADER --%>
<div class="row header" style="background-color: darkcyan;">
	<!-- <div class="col-md-1" ></div> -->
	<div class="col-md-1"><div class="profile-header-img1"><img src="<%=application.getContextPath() %>/images/pm2.jpg" class="img-thumbnail"  alt="nacre" style=" height:80px;" ></div></div>
	<div class="col-md-3" >

	
	</div> 

	<div class="col-md-6" >
	<h1 style="color: white;">
	 PROJECT MANAGEMENT 
	</h1>
	</div>
	<!-- <div class="col-md-1"></div> -->
	
	<div class="col-md-2">

	<c:if test="${not empty USERDTO}">
	<%@include file="profile.jsp" %>
    		</c:if>
	</div>
</div>

<c:if test="${not empty USERDTO}">
	<%@include file="headerMenu.jsp" %>

	</c:if>


<div class='extrapadd'>
</div>
   


