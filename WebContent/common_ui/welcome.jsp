<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Project Management World</title>
</head>
<body>



 <jsp:include page="../common_ui/start.jsp"></jsp:include>
<%--  <jsp:include page="../common_ui/menu.jsp"></jsp:include>
 --%> 
<img src="../images/images3.jpg" alt="WELCOME TO YOUR PAGE" width="107%" height="500px" style="margin-left:-56px; margin-top:-7px;">
 <jsp:include page="../common_ui/end.jsp"></jsp:include>

<%-- <a href="<%=application.getContextPath() %>/common_ui/changepassword.jsp">Change Password</a>
<a href="<%=application.getContextPath() %>/LogoutAction">Logout</a>
<a href="<%=application.getContextPath() %>/common_ui/forgetpassword.jsp">Forget Password</a>
 --%>

</body>
</html>