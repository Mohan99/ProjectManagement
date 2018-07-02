<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Project</title>
</head>
<%-- <link rel="stylesheet" href="<%=application.getContextPath() %>/css/jquery-ui.css">
 
<script src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath() %>"java_script/jquery.min.js"></script>
 

<script src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>
 		
<script type="text/javascript">

$(document).ready(function(){
	$.ajax({ url: "<%=application.getContextPath()%>/getModuleNotification",
	        context: document.body,
			success : function(data) {
 				var noti = document
						.getElementById("noti");
				$(noti).empty();

				$
						.each(
								data,
								function(
										index) {
										$(noti).append("<a href='moduleNotificationDetailsServlet?moduleId=1'"+">Click here</a>");						
										
										});
 			}
});
	});


</script> --%>

<body>
<div id="noti">

<a href='../moduleNotificationDetailsServlet?moduleId=1'"+">Click here</a>

</div>
</body>
</html>


