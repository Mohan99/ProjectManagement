<!-- kunal COmments -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Project</title>
</head>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
#success_message {
	display: none;
}
.panel-body{
background-color: lightgrey;
}
</style><!-- 
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->

<!-- 
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
 -->
<!-- <script
	src="https://npmcdn.com/bootstrap@4.0.0-alpha.5/dist/js/bootstrap.min.js"></script>

 --><body>


<jsp:include page="../common_ui/start.jsp"></jsp:include>

	<div>
		<h1 style="text-align: center;">Assign Project To
			Project Manager</h1>
			
		<div  id='msg'>		
</div>

<c:remove var="result"/>				

	    <div id="projectSearch" class="col-sm-3 col-md-3" style="float:right;">
        <form class="navbar-form" role="search" >
        <div class="input-group">
            <input type="text" class="form-control"  placeholder="Search" id="search"  name="search">
            <div class="input-group-btn">
                <button class="btn btn-default" onclick="return searchProjectData();" type="submit" value="Search"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
    </div>

<!-- 	<div id="projectSearch">
			<br><br>
			
 	<form action="" style='float:right'>
		<input type="text" id="search"  name="search"><input
			onclick="return searchProjectData();" type="submit" value="Search" >
	</form>  
	</div>
 -->	
 
 	    <div id="projectManagerSearch" class="col-sm-3 col-md-3" style="float:right;">
        <form class="navbar-form" role="search" >
        <div class="input-group">
            <input type="text" class="form-control"  placeholder="Search" id="managersearch"  name="search">
            <div class="input-group-btn">
                <button class="btn btn-default" onclick="return searchProjectManagerData();" type="submit" value="Search"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
    </div>
 
 <!-- 	<div id="projectManagerSearch">
			<br><br>
	<form action="" style='float:right'>
		<input type="text" id="managersearch"  name="search"><input
			onclick="return searchProjectManagerData();" type="submit" value="Search" >
	</form> </div>
 -->	
<br><br><br>
			
		<div id="displayProject">
		</div>
		
	
	<div id="displayProjectManager">
		</div>
	</div>
	</div>
	</div>


<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=application.getContextPath() %>/java_script/bootstrapValidator.min.js"></script>

 <link rel="stylesheet"
	href="<%=application.getContextPath() %>/css/bootstrapValidator.min.css">
<script src="<%=application.getContextPath() %>/java_script/tether.min.js"></script>
	
<script type="text/javascript">

$(document).ready(function(){
	allProject();
	});
	
	function allProject(){

		$(document).ready(function(){
			$.ajax({ url: "<%=application.getContextPath()%>/ProjectAction.ajax",
			        context: document.body,
					success : function(data) {
		 				var proj = document.getElementById("displayProject");
						$(proj).empty();
						$("#projectSearch").show();

						$("#projectManagerSearch").hide();
						$("#displayProjectManager").hide();
						$(proj).show();
						if(data.length ==0){
							$(
									proj)
									.append("<h2 style='text-align:center;color:red; margin-top:100px;'><label>No More  Project found to Assign<label></h2>");
						}
						
						$
								.each(
										data,
										function(
												index,obj) {
												$(
													proj)
													.append("<div class='panel  panel-primary' >"+
															 '<div class="panel-heading"> Project Name : '+obj.projectTitle+'</div>'+
															  '<div class="panel-body">'+
															"<div style='float: left; ' ><table ><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;' >Project Name  </td><td style='font-size: 20px';><label>"+obj.projectTitle+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Name </td> <td style='font-size: 20px'><label>"+obj.clientName+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px'>Project Desc  </td><td style='font-size: 18px;width:450px;'> <label>"+obj.projectDescription+"</label> </td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Location  </td> <td style='font-size: 20px'><label>"+obj.address+","+obj.pinCode+"</label></td></tr> </table></div><div style='float: right'><img src='"+obj.logo+"' width='200px' height='150px'class='img-circle'/><br><br><br><button class='btn btn-warning' style='float: right;margin-top:20px;' onclick='projectManager("+obj.projectId+"	)'>Assign Project Manager</button></div></div></div>");
										});
						
						}
						
		 			
		});
			});

		
	}
	
	function projectManager(projId){
		$("#displayProject").hide();
		$("#projectSearch").hide();
		$("#projectManagerSearch").show();

		$("#msg").hide();
$(document).ready(function(){
	$.ajax({ url: "<%=application.getContextPath()%>/ProjectManagerAction.ajax",
	        context: document.body,
			success : function(data) {
 				var projManger = document
						.getElementById("displayProjectManager");
				$(projManger).empty();
				$(projManger).show();
				$(projManger).append("<div><button class='btn btn-info'  style='width:300px;margin-left:590px;' onclick='allProject()' >Back To Project</button><br></div>");
				if(data.length == 0){
					$(
							projManger)
							.append("<h2 style='text-align:center;color:red; margin-top:100px;'><label>No Project Manager found to Assign<label></h2>");
				}

				$
						.each(
								data,
								function(
										index) {
										$(projManger).append("<div class='panel  panel-primary'>"+
												
												 '<div class="panel-heading" > Manager Name  :  '+data[index].firstName+'</div>'+
												  '<div class="panel-body">'+
												"<div style='float: right; width:450px;' ><table ><td style='font-size: 20px; color: blue;width: 150px;line-height: 40px;'>Email </td> <td style='font-size: 18px'><label>"+data[index].email+"</label></td></tr><tr><td style='font-size: 20px; color: blue;width: 150px'>Mobile No  </td><td style='font-size: 18px'> <label>"+data[index].mobileNo+"</label> </td></tr> </table><button class='btn btn-warning' style='float: right; width:200px;' onclick='return assignPMToProject("+projId+","+data[index].userId+")' >Assign Project Manager</button></div><div style='float: left;width: 300px'><img src='"+data[index].image+"' width='200px' height='150px' class='img-circle'/></div></div>");						
										});
 			}
});
	});
	}
	
	function assignPMToProject(projId,uId){
		$("#displayProject").show();
		$("#displayProjectManager").hide();
		$(document).ready(function(){
			$.ajax({ url: "<%=application.getContextPath()%>/assignProjectAction.ajax",
										 type: "POST",
										data : {
											"projId" : projId,
											"uId" : uId
										},
										success : function(data) {
										$("#msg").empty();
										$("#msg").show();
										$("#msg").append("<div class='alert alert-success alert-dismissable'>"+
												  "<a href='' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"+
												  "<strong>Success!  </strong>"+ JSON.parse(data)+
												  "</div>");
											allProject();
											$("#projectSearch").show();

							}
									});
						});
return false;
	}

	var projId =1;
	 function searchProjectManagerData(){
		 $("#displayProject").hide();
		 $("projectSearch").hide();
			$("#msg").hide();
		 var id = document.getElementById("managersearch").value;
			$(document).ready(function(){
				$.ajax({
					url: "<%=application.getContextPath()%>/ProjectManagerSearchAction.ajax",
				
				        context: document.body,
		 				data : {
		 	 				"search" : id
		 	 			},

						success : function(data) {
							var projManger = document.getElementById("displayProjectManager");
					$(projManger).empty();
					$(projManger).show();
					$(projManger).append("<div><button class='btn btn-info'  style=width:300px;margin-left:590px;' onclick='allProject()' >Back To Project</button><br></div>");
					if(data.length == 0){
						$(
								projManger)
								.append("<h2 style='text-align:center;color:red; margin-top:100px;'><label>No Project Manager found to Assign<label></h2>");
					}

					$
							.each(
									data,
									function(
											index) {
											$(projManger).append("<div class='panel  panel-primary'>"+
													
													 '<div class="panel-heading"> Manager Name  :  '+data[index].firstName+'</div>'+
													  '<div class="panel-body">'+
													"<div style='float: right; width:450px;' ><table ><tr><td style='font-size: 20px; color: blue;width: 150px;line-height: 40px;'>Email </td> <td style='font-size: 18px'><label>"+data[index].email+"</label></td></tr><tr><td style='font-size: 20px; color: blue;width: 150px'>Mobile No  </td><td style='font-size: 18px'> <label>"+data[index].mobileNo+"</label> </td></tr> </table><button class='btn btn-warning' style='float: right;width:200px;' onclick='return assignPMToProject("+projId+","+data[index].userId+")' >Assign Project Manager</button></div><div style='float: left;width: 300px'><img src='"+data[index].image+"' width='200px' height='150px' class='img-circle'/></div></div>");						
												});
						}
		 	 			});
				});


		 
		 return false;
	 }

	 
	 function searchProjectData(){
		 
		 var id = document.getElementById("search").value;
			$(document).ready(function(){
				$.ajax({ url: "<%=application.getContextPath()%>/ProjectSearchAction.ajax",
				        context: document.body,
		 				data : {
		 	 				"search" : id
		 	 			},

						success : function(data) {
			 				var proj = document.getElementById("displayProject");
							$(proj).empty();
							$("#displayProjectManager").hide();
							$(proj).show();
							if(data.length ==0){
								$(
										proj)
										.append("<h2 style='text-align:center;color:red; margin-top:100px;'><label>No More  Project found to Assign<label></h2>");
							}
							
							$
									.each(
											data,
											function(
													index,obj) {
													$(
														proj)
														.append("<div class='panel  panel-primary' >"+
																 '<div class="panel-heading"> Project Name : '+obj.projectTitle+'</div>'+
																  '<div class="panel-body">'+
																"<div style='float: left; ' ><table ><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;' >Project Name  </td><td style='font-size: 20px';><label>"+obj.projectTitle+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Name </td> <td style='font-size: 20px'><label>"+obj.clientName+"</label></td></tr><tr><td style='font-size: 25px; color: blue;width: 200px'>Project Desc  </td><td style='font-size: 18px'> <label>"+obj.projectDescription+"</label> </td></tr><tr><td style='font-size: 25px; color: blue;width: 200px;line-height: 40px;'>Client Location  </td> <td style='font-size: 20px'><label>"+obj.address+","+obj.pinCode+"</label></td></tr> </table></div><div style='float: right'><img src='"+obj.logo+"' width='200px' height='150px'class='img-circle'/><br><br><br><button class='btn btn-warning' style='float: right;' onclick='projectManager("+obj.projectId+"	)'>Assign Project Manager</button></div></div></div>");
											});
							
							}
							
			 			
			});
				});


		 
		 return false;
	 }
	
</script>
	
</body>
</html>