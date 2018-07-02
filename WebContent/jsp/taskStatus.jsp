<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>TaskStatus</title>
<style type="text/css">
.col-md-4.lbl.bg-primary {
 height: 90px;
margin-bottom: 12px;
border-radius:40px;
border-top-left-radius: 1px;
    border-bottom-right-radius: 1px;
    padding-top: 1%;}
.in{
margin-bottom: 2px;

}
#mm{
height:35px;
}


</style>


</head>

<body>


<jsp:include page="../common_ui/start.jsp"></jsp:include>
<form action="<%= application.getContextPath() %>/TaskStatusUpdate"  method="post" id="msi">

<div class='row' >
<c:if test="${success!= null}">
<div class='col-md-2' > </div>
<div class='col-md-8' style="color: green">
<h1><c:out value = "${success}"/></h1>
</div>
</c:if>
<c:remove var = "success"/>
</div>

 <div class='row'>
 
<div class='col-md-5'></div>
<div class='col-md-6 heading' ><h3>Task Status</h3></div>
</div>

 <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl bg-primary'>TaskStatusInfo:</div>
 
 <div class='col-md-4 in'><textarea rows="4" cols="50" class='form-control in'  name="Task_status_info" required> </textarea></div>
 <div class='col-md-2'></div>
 
 </div>
 
 <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl  bg-primary'>Difficulties:</div>
 
 <div class='col-md-4 in' ><textarea rows="4" cols="50" class='form-control' name="difficulties" required></textarea></div>
 <div class='col-md-2'></div>
 
 </div>



<!--  <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl  bg-primary'>DeveloperTaskId:</div>
 
 <div class='col-md-4'><select  id="pmid" name="p_m_id" class='form-control'></select></div>
 <div class='col-md-2'></div>
  
 </div>
-->
 <input type="hidden" value="<%=request.getParameter("developerTaskId") %>" name="hidden1" id="hidden">
 
<!--  <input type="hidden" value="2"  id="hidden" name="hidden1">
 -->
<!-- ModuleCompletionPercentage:<input type="text" name="percentage"><br/> -->




<div class='row tp' >
 <div class='col-md-2'>
 <input type="hidden"  id="mcp" name="T_C_P" class='form-control in'  onchange="document.getElementById('mcpp').min=this.value;" readonly>
 </div>
 <div class='col-md-4 lbl  bg-primary' id="mm"> CurrentTaskCompletionPercentage: </div>
 
 <div class='col-md-4'><input type="number"  id="mcpp" name="c_t_c_p" class='form-control in'    max="100"></div>
 <div class='col-md-2'></div>
 
 </div>


<!-- ProjectModuleId:<  id="country" name="id"><option>select</option><br/> -->


 <div class='row'>
 <div class='col-md-2'></div>
 <!-- <div class='col-md-4'></div> -->
 
 <div class='col-md-8'>
								<input type="submit" class='btn btn-primary btn-block'
									 value="Submit" /></div>
 <div class='col-md-2'></div>
 
 </div>
 					  </form>
 					  
<div style="margin-left: 42%;margin-bottom: 3%; margin-top:3%;">

<a href="<%=request.getContextPath()%>/ViewDeveloperTaskAction" class="btn btn-info btn-lg" title="Back to View Task">
          <span class="glyphicon glyphicon-arrow-left"></span> Back
        </a>
	
				
          </div>
          
          
<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript">
<%-- $(document).ready(function() 
		{
		$.ajax({
			
			url : "<%=application.getContextPath()%>/GetAllTaskId",
			success : function(data) {	
			var country = $('#pmid ');
			country.append("<option>select taskId</option>");
			/* $(country).empty(); */
			for(var i=0;i<data.length;i++) {
				country.append("<option  value=' " + data[i].developerTaskId 	+ " 'name=' " +data[i].developerTaskId+ " '>" +data[i].developerTaskId +"</option>");
				};
				}
				});
		$('#pmid').change(function(){
			 --%>
			 
			 
			 $(document).ready(function() 
			{
			var cid ='<%=request.getParameter("developerTaskId") %>';
		//	alert(cid);	
			
			
			$.ajax({
					url:"<%=application.getContextPath()%>/GetTaskCompletePercentage",
					data:{"cid": cid},
					
					success:function(mcp){
					/* var c=	$('#mcp');
					c.empty(); */
					alert(mcp.taskCompletionPercent);
					 $("#mcpp").val(mcp.taskCompletionPercent);
					 $("#mcpp").attr("min",mcp.taskCompletionPercent);
					//$("#mcp").attr("value",mcp.moduleCompletionPercent);
						/* for (var ind = 0; ind < states.length; ind++) {
							c.append("<option value='"+states[ind].s_id+"' name='"+states[ind].s_name+"'>"+states[ind].s_name+"</option>");
						}//for
						 */
						
					}//success
				});//ajax
			
			
			$('#mcpp').keypress(function(e) {
			    e.preventDefault();
			    alert("TYPING IS NOT ALLOWED HERE");
			});
			});// change state
		
			//});
			
			
			
			
</script>









<%-- 
<center>
<b>Task_Status</b><br/>
<form action="<%= application.getContextPath() %>/ModuleStatusUpdate"  method="post">
<table >
<tbody>
<tr>
								<td>TaskStatusInfo:</td>
								<td><textarea rows="4" cols="50"  name="Task_status_info"> </textarea></td>
</tr>
<!-- ModuleStatusInfo:<input type="text" name="module_status"><br/> -->

<tr>
								<td>Difficulties:</td>
								<td><textarea rows="4" cols="50"  name="difficulties"></textarea></td>
</tr>

<!-- Difficulties:<input type="text" name="difficulties"><br/> -->

<tr>
					<td>DeveloperTaskId:</td>
								<td><select  id="pmid" name="p_m_id">
										
								</select></td>
								
</tr>
<!-- TaskCompletionPercentage:<input type="text" name="percentage"><br/> -->

<tr>

						<td>TaskCompletionPercentage:</td>
								<td><input type="text" name="T_C_P"></td>
								
							</tr>
	<!-- TaskCompletionPercentage:<input type="text" name="percentage"><br/> -->
	<tr>

						<td>CurrentTaskCompletionPercentage:</td>
								<td><input type="number" name="c_t_c_p"  min="0" max="100"></td>
								
	</tr>
							
<!-- ProjectModuleId:<  id="country" name="id"><option>select</option><br/> -->

<!-- <tr>
								<td>UpdationDate:</td>
								<td><input type="date" name="updationDate"></td>
</tr> -->
<!-- UpdationDate:<input type="date" name="updationDate"><br/> -->

<tr>
								<td><input type="submit"
									style="width: 100px; height: 40px;" value="Submit" /></td>
							</tr>
					  <!-- <input type="submit" value="submit"/> -->
					  </tbody>
					  </table>
					  </form>
					  </center>
 --%>
</body>
</html>

<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/formValidation.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formValidationVar.js"></script>
<link href="<%=application.getContextPath() %>/java_script/formvalidation/css/formValidation.min.css">
<!-- Then include mandatoryIcon add-on -->
<script src="/vendor/formvalidation/js/addons/mandatoryIcon.min.js"></script>
<script type="text/javascript">


$('#msi')
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

            'Task_status_info':statusValidators,

            'difficulties':statusValidators
        }
    });

</script>
