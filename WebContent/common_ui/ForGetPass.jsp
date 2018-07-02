<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#fp{
position: absolute;
top:20%;
left:5%;
}

</style>
</head>
<body>
<jsp:include page="../common_ui/header.jsp"></jsp:include>
<div>
 <div class="form-gap"></div>
 	<c:if test="${err ne null }">
  	<div class="alert alert-danger alert-dismissable">
  <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>FAILED!</strong>  	${err }
</div>
 
  	</c:if>
  	<c:remove var="err"/>
 
<div class="container" id='fp'>

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default bg-info">
 
              <div class="panel-body bg-info">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can reset your password here.</p>
                  <div class="panel-body">
    
                    <form id="register-form" role="form" action="<%=application.getContextPath()%>/ForgetPasswordAction" autocomplete="off" class="form" method="post">
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="email" name="inputEmail" placeholder="email address" class="form-control"  type="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                      </div>
                      <div class="form-group">
                        <a href="<%=application.getContextPath()%>" class="btn btn-lg btn-info btn-block" >Go Back</a>
                      </div>
                      
                      <input type="hidden" class="hide" name="token" id="token" value=""> 
                    </form>
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
</div>
<jsp:include page="../common_ui/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/formValidation.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formValidationVar.js"></script>

<!-- Then include mandatoryIcon add-on -->
<script src="/vendor/formvalidation/js/addons/mandatoryIcon.min.js"></script>
<script type="text/javascript">


$('#fp')
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
          
            'inputEmail':emailvalidator
            
        }
    });

</script>
</body>
</html>