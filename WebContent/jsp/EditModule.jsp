<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style type="text/css">
#success_message {
	display: none;
}
</style>

<!-- sandip -->

 
  
<body >

<jsp:include page="../common_ui/start.jsp"></jsp:include>

	<div id="msg"></div>
	
			<c:if test="${result ne null }" var="msg">
			<div class="alert alert-success alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>
			<%-- 
			<h3 style="color: green; text-align: center;">
				<b>${result}</b>
			</h3> --%>
			
		</c:if>
		<c:remove var='result' />


			<c:if test="${err ne null }" var="msg">
			<div class="alert alert-danger alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${err}
</div>	
</c:if>

		<c:remove var='err'  />

	<div class="row" style='width:100%'>

		<form class="well form-horizontal" action="<%=application.getContextPath()%>/EditModuleAction" method="post" enctype="multipart/form-data" id="task_info_form">
			<fieldset>

				<!-- Form Name -->
				<h1 style="text-align: center;">
					<label>Edit Module</label>
				</h1>


				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Module Title</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="title" placeholder="Module Title" id="taskTitle"
								class="form-control" type="text" value="${editmodule.moduleTitle}">
					   <input type="hidden" name="hdmid" id="hidden" value="${editmodule.projectModuleId}">
						</div>
					</div>
				</div>
				<!-- Text area -->

				<div class="form-group">
					<label class="col-md-4 control-label">Module Description</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>
							<textarea class="form-control" name="description"
								placeholder="Module Description" id="taskDescription" >${editmodule.moduleDescription}</textarea>
								<input type="hidden" name="hdescription" id="hidden" value="${editmodule.moduleDescription}">
						</div>
					</div>
				</div>
			<div class="form-group">
				<label class="col-md-4 control-label">Reference Document</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="document"	placeholder="upload Document" class="form-control" type="file" id="file">
							<input type="hidden" name="hddocument" id="hddocumentid" value="${editmodule.moduleReferenceDocument}">
							
					</div>
				</div>
			</div>


			<div class="form-group">
				<label class="col-md-4 control-label">Start Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="date"
							placeholder="select start Date" id="StartDate" class="form-control" type="text" readonly="readonly" value="<fmt:formatDate pattern="MM/dd/yyyy"
										value="${editmodule.startDate}" />">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">End Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="enddate"
							placeholder="select end Date" id="EndDate" class="form-control" type="text" readonly="readonly" value="<fmt:formatDate pattern="MM/dd/yyyy"
										value="${editmodule.endDate}" />">
					</div>
				</div>
			</div>
       
       
       
         <div class="form-group">
					<label class="col-md-4 control-label">Module Completion percentage</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="modulepercent" placeholder="Module Title" id="modulepercent"
								class="form-control" type="text" value="${editmodule.moduleCompletionPercent}">
						</div>
					</div>
				</div>
	
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit"  class="btn btn-warning">
						Upadte Module  <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>


		</fieldset>
	</form>
	</div>
	
<jsp:include page="../common_ui/end.jsp"></jsp:include>
	

<link rel="stylesheet" href="<%=application.getContextPath() %>/css/jquery-ui.css">
 
<script src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/bootstrapValidator.min.js"></script>
 

<script src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>




<script type="text/javascript">
	
$(document)
.ready(
		function() {
			//alert("session in js:");
			//$('#taskDescription').html();

		$('#task_info_form')
				.bootstrapValidator(
						{
							// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								title : {
									validators : {
										stringLength : {
											min : 2,
										},
										notEmpty : {
											message : 'Please supply Module title'
										}
									}
								},
 								description : {
									validators : {
										stringLength : {
											min : 10,
											max : 200,
											message : 'Please enter at least 10 characters and no more than 200'
										},
										notEmpty : {
											message : 'Please supply a description of your Module'
										}
									}
								}
							}
						});
	
		 
		});
		
/* function addTask() {
	
	var pTitle = $('#taskTitle').val();
	var description = $('#taskDescription').val();
	var refDoc= $('#file').val();
	alert(refDoc);
	var sdate = $('#StartDate').val();
	var edate = $('#EndDate').val();

	var url = '/ProjectManagement/AddTaskAction?title=' + pTitle + '&description=' + description + '&txtdoc=' + refDoc+ '&date=' + sdate + '&enddate='+ edate;
			$.ajax({
		url : url,
		context : document.body,
		
		type : 'POST',
		
		success : function(result) {
			$("#edVmsg").append(result);
		}

	});
} */

		
		
$( function() {
    var dateFormat = "mm/dd/yy",
    StartDate = $( "#StartDate" )
        .datepicker({

        	minDate: 1, 
          defaultDate: "+1w",
          
          changeMonth: true,
          numberOfMonths: 1
        })
        .on( "change", function() {
        	EndDate.datepicker( "option", "minDate", getDate( this ) );
        }),
        EndDate = $( "#EndDate" ).datepicker({
        //defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1
      })
      .on( "change", function() {
        StartDate.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );
</script>

</body>
<!-- /.container -->