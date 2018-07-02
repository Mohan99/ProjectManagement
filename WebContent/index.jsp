<html>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common_ui/header.jsp"></jsp:include>

<link rel="stylesheet" href="<%=application.getContextPath() %>/css/login.css">
<div id="div1" class='row'>
	
	<div id="div3" class='col-md-6'><img src="<%=application.getContextPath() %>/images/nacre.png" class="img-circle" alt="nacre" width="70%" height="60%" ></div>
	
  	<div id="div2"class='col-md-5'>
  	<c:if test="${err ne null }">
  	<div class="alert alert-danger alert-dismissable">
  <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>FAILED!</strong>  	${err }
</div>
 
  	</c:if>
  	<c:remove var="err"/>
  	
  	<c:if test="${success ne null }">
  	<div class="alert alert-success alert-dismissable">
  <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong>  	${success }
</div>
 
  	</c:if>
  	<c:remove var="success"/>
 
  	 <form action="LoginAction" method="post" id='lf'>
  	 	<br>
  	   <div class="input-group">
      		<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
      		<input id="email" type="text" class="form-control" name="inputEmail" placeholder="Email">
    	</div><br>
    	<div class="input-group">
      		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      		<input id="password" type="password" class="form-control" name="password" placeholder="Password">
    	</div><br>
     	<div>
      
      		<input id="submit" type="submit" class="btn btn-success form-control" value="sign in" style="width: 100%; color: white;">
    	</div><br>
   
    	
		<div style="float: right;">
			<a href="<%=application.getContextPath() %>/common_ui/ForGetPass.jsp" style="text-decoration: none;"><span class="label  label-info" style="font-size: x-large;">Forgot <font color="red">Password?</font></span></a>
		</div>
 		<div class="checkbox">
  			<label><input type="checkbox" value="">Remember Me!</label>
		</div>
<%-- 		<div style="color: red"><c:out value="${name}"/></div>
 --%> 	 </form>
	</div>
	<div class='col-md-1'></div>
</div>

<jsp:include page="common_ui/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/formValidation.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formValidationVar.js"></script>

<!-- Then include mandatoryIcon add-on -->
<script src="/vendor/formvalidation/js/addons/mandatoryIcon.min.js"></script>
<script type="text/javascript">


$('#lf')
    .formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        }, addOns: {
            mandatoryIcon: {
                icon: 'glyphicon glyphicon-asterisk'
            }
        },
        fields: {
          
            'inputEmail':emailvalidator,
            'password':passwordValidators
            
        }
    });

</script>
</body>
</html>
