<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<head>

<link rel="stylesheet" href="<%=application.getContextPath() %>/css/jquery-ui.css">
 


<style type="text/css">
#success_message {
	display: none;
}
</style>

<!-- CHAKRAVARTHI -->
</head>

 
<body >
	<jsp:include page="../common_ui/start.jsp"></jsp:include>
	<div id="msg"></div>
			<c:if test="${result ne null }" var="msg">
			<div class="alert alert-success alert-dismissable">
  <a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>
			
		</c:if>
		<c:remove var='result' />


			<c:if test="${err ne null }" var="msg">
			<div class="alert alert-danger alert-dismissable">
  <a  class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Failure!</strong> ${err}
</div>	
</c:if>

		<c:remove var='err'  />

	<div class="row" style='width:100%'>

		<form action="<%=application.getContextPath()%>/AddTaskAction" method="post" enctype="multipart/form-data" id="task_info_form">
			<fieldset>

				<!-- Form Name -->
				<h1 style="text-align: center;">
					<label>Add Task</label>
				</h1>


				<!-- Text input-->

				<div class="form-group row">
					<label class="col-md-4 control-label">Task Title</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="title" placeholder="Task Title" id="taskTitle"
								class="form-control" type="text">
						</div>
					</div>
				</div>
				<!-- Text area -->
<input type="hidden" value="<%=request.getParameter("projectmoduleid")%>" name='projectmoduleid'>
				<div class="form-group row" >
					<label class="col-md-4 control-label">Task Description</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>
							<textarea class="form-control" name="description"
								placeholder="Task Description" id="taskDescription"></textarea>
						</div>
					</div>
				</div>
			<div class="form-group row">
				<label class="col-md-4 control-label">Reference Document</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="document"	placeholder="upload Document" class="form-control" type="file" id="file">
					</div>
				</div>
			</div>


			<div class="form-group row">
				<label class="col-md-4 control-label">Start Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="date"
							placeholder="select start Date" id="StartDate" class="form-control" type="text" readonly="readonly">
					</div>
				</div>
			</div>

			<div class="form-group row">
				<label class="col-md-4 control-label">End Date</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="enddate"
							placeholder="select end Date" id="EndDate" class="form-control" type="text" readonly="readonly">
					</div>
				</div>
			</div>


			<!-- Button -->
			<div class="form-group row">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit"  class="btn btn-warning">
						Add Task  <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>


		</fieldset>
	</form>
	</div>
	
<jsp:include page="../common_ui/end.jsp"></jsp:include>
	

<script src="<%=application.getContextPath() %>/java_script/jquery-ui.js"></script>

<script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/bootstrapValidator.min.js"></script>
 

<script src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>




<script type="text/javascript">
$(document)
.ready(
		function() {
			
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
											message : 'Please supply Task title'
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
											message : 'Please supply a description of your Task'
										}
									}
								}
							}
						});
	
		 
		});
		

		
		
$( function() {
    var dateFormat = "mm/dd/yy",
    StartDate = $( "#StartDate" )
        .datepicker({

        	minDate: 0, 
          //defaultDate: "+1w",
          
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
</head>