<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- CHAKRAVARTHI -->
<style type="text/css">
#success_message {
	display: none;
}
.container.well.form-horizontal {
    width: 95% !important;
}
</style>

<body>
<jsp:include page="../common_ui/header.jsp"></jsp:include>
	
	
	<div class=row>
	<div class="col-md-3">
	<jsp:include page="../common_ui/tl_menu.jsp"></jsp:include>
	</div>
	<div class='col-md-9'>
<div>
	<div id="msg"></div>
		<c:if test="${result ne null }" var="msg">
					<div class="alert alert-success alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Success!</strong> ${result}
</div>
		</c:if>
<c:remove var="result"/>

		<c:if test="${err ne null }" var="msg">
			<div class="alert alert-danger alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong>Failed!</strong> ${err}
</div>	
</c:if>

		<c:remove var='err'  />

		<h1 style="text-align: center; color: blue;">Assign Task To Developer</h1>
		<div id="displayTask">
	</div>
	<div id="displayDeveloper">
	</div>
	</div>
	</div>
	</div>


<jsp:include page="../common_ui/footer.jsp"></jsp:include>
	<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
 
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
<script type="text/javascript">

 $(document).ready(function(){
  displayTask();
	 
 });
 function displayTask(){
 $(document).ready(function(){
		
		$.ajax({ url: "<%=application.getContextPath()%>/TaskAction",
		        context: document.body,
				success : function(data) {
						 				var task = document.getElementById("displayTask");
	 									$(task).empty();
	 									if(data.length ==0){
										$(task)
											.append("<h2 style='text-align:center;color:red; margin-top:100px;'><label>No Task found to Assign<label></h2>");
											}
										$.each(
												data,
							function(index,obj) {
												$(task).append("<div class='container well form-horizontal' ><div style='float: left; width: 900px;' ><table ><tr><td style='font-size: 25px; color: green;width: 200px;line-height: 40px;' >ProjectName  </td><td style='font-size: 20px';><label>"+obj.projectTitle+"</label></td></tr><tr><td style='font-size: 25px; color: green;width: 200px;line-height: 40px;' >ModuleName  </td><td style='font-size: 20px';><label>"+obj.moduleTitle+"</label></td></tr><tr><td style='font-size: 25px; color: green;width: 200px;line-height: 40px;' >TaskName  </td><td style='font-size: 20px';><label>"+obj.taskTitle+"</label></td></tr><tr><td style='font-size: 25px; color: green;width: 200px'>Task Description  </td><td style='font-size: 18px'> <label>"+obj.taskDescription+"</label> </td></tr> </table></div><div style='float: right'><br><br><br><button class='btn btn-warning' style='float: right;' onclick='developer("+obj.moduleTaskId+")'>Assign Developer</button></div></div>");
									});
	 			}
	});
		});
 }
		function developer(taskId){
			$("#displayTask").hide();
			$("#msg").empty();
	$(document).ready(function(){

		$.ajax({ url: "<%=application.getContextPath()%>/DeveloperAction",
		        context: document.body,
				success : function(data) {
	 				var dev = document.getElementById("displayDeveloper");
					$(dev).empty();
					$(dev).show();
					
					$.each(data,
							
						   function(index){
					
						$(dev).append("<div class='container well form-horizontal' style='width:800px' ><div style='float: left;width: 300px'><img src='"+data[index].image+"' width='200px' height='150px'/></div><div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;' >DeveloperName  </td><td style='font-size: 18px';><label>"+data[index].firstName+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px;line-height: 40px;'>Email </td> <td style='font-size: 18px'><label>"+data[index].email+"</label></td></tr><tr><td style='font-size: 20px; color: green;width: 150px'>Mobile No  </td><td style='font-size: 18px'> <label>"+data[index].mobileNo+"</label> </td></tr> </table><button class='btn btn-warning' style='float: right;' onclick='return assignTaskToDeveloper("+taskId+","+data[index].userId+")' >Assign Task To Developer </button></div><div style='float: left;width: 300px'></div>");						
											});
	 			}
	});
		});
		}
		
		function assignTaskToDeveloper(taskId,uId){
			
			$(document).ready(function(){
				$.ajax({ 
											url: "<%=application.getContextPath()%>/AssignTaskAction",
											context : document.body,
											type:'POST',
											data : {
												"taskId" : taskId,
												"uId" : uId
											},
											success : function(data) {
												
												if(data.success!=undefined && data.success!=null){
													
													$("#msg").html(
															
													'			<div class="alert alert-success alert-dismissable">'+
													  '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
													  '<strong>Success!</strong>'+data.success+
													'</div>'
													);
																	
													
												}else if(data.err!=undefined && data.err!=null)
												{

													$("#msg").html(
															
													'			<div class="alert alert-danger alert-dismissable">'+
													  '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
													  '<strong>Success!</strong>'+data.err+
													'</div>'
													);
													
												}
												
											$("#displayTask").show();
											$("#displayDeveloper").hide();
											
											displayTask();
											}
										});
							});
			return false;

		}
 </script>
	
</body>