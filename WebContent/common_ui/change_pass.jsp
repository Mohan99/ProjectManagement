<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
<link href="<%=application.getContextPath() %>/java_script/formvalidation/css/formValidation.min.css">
</head>
<body>
	<jsp:include page="./start.jsp"></jsp:include>

	<!-- <form class="form-horizontal"> -->
	<form class="form-horizontal" id='cp-form'  data-fv-addons="mandatoryIcon"
    data-fv-addons-mandatoryicon-icon="glyphicon glyphicon-asterisk"

    data-fv-framework="bootstrap"
    data-fv-icon-valid="glyphicon glyphicon-ok"
    data-fv-icon-invalid="glyphicon glyphicon-remove"
    data-fv-icon-validating="glyphicon glyphicon-refresh"
		action="<%=application.getContextPath()%>/ChangePasswordAction"
		method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>CHANGE PASSWORD</legend>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="piCurrPass">OLD
					PASSWORD</label>
				<div class="col-md-4">
					<input id="piCurrPass" name="oldPassword" type="password"
						placeholder="" class="form-control input-md"  required="">
<c:if test="${ERROR  ne null}">
<label class='label label-danger'>${ERROR }</label>

</c:if>

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="piNewPass">NEW
					PASSWORD</label>
				<div class="col-md-4">
					<input id="piNewPass" name="newPassword"type="password"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="piNewPassRepeat">CONFORM
					PASSWORD</label>
				<div class="col-md-4">
					<input id="piNewPassRepeat" name="confPassword" type="password"
						placeholder="" class="form-control input-md" required="">
<c:if test="${NCERROR  ne null}">
<label class='label label-danger'>${NCERROR }</label>

</c:if>
<c:remove var="ERROR"/>
<c:remove var="NCERROR"/>


				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="bCancel"></label>
				<div class="col-md-8">
					<button id="bGodkend" name="bGodkend" type="submit" class="btn btn-success">SUBMIT</button>
				</div>
			</div>

		</fieldset>
	</form>

	<jsp:include page="./end.jsp"></jsp:include>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/formValidation.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formValidationVar.js"></script>

<!-- Then include mandatoryIcon add-on -->
<script src="/vendor/formvalidation/js/addons/mandatoryIcon.min.js"></script>
<script type="text/javascript">


$('#cp-form')
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
          
            'oldPassword':passwordValidators,
            'newPassword':passwordValidators,
            'confPassword':confPwd
        }
    });

</script>
</body>
</html>