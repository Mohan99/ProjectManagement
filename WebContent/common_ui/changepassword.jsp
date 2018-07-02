<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<form action="<%=application.getContextPath() %>/ChangePasswordAction" method="post">
<input   type="password" placeholder="OLD PASSWORD"  name="oldPassword"/ >
<c:if test="${ERROR  ne null}">
<label>${ERROR }</label>

</c:if>

<br>

<input type="password"  placeholder="NEW PASSWORD"  name="newPassword"/>

<br>
<input type="password" placeholder="CONFORM PASSWORD" name="confPassword"/>
<c:if test="${NCERROR  ne null}">
<label>${NCERROR }</label>

</c:if>
<c:remove var="ERROR"/>
<c:remove var="NCERROR"/>

<br>
<input type="submit" value="SUBMIT"/>
</form>
</body>
</html>