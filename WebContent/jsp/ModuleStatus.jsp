<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<%=application.getContextPath() %>/java_script/formvalidation/css/formValidation.min.css">
<title>Module_Status</title>
 <style type="text/css">
.col-md-4.lbl.bg-primary {
    height: 90px;
margin-bottom: 12px;
border-radius:40px;
border-top-left-radius: 1px;
    border-bottom-right-radius: 1px;
    padding-top: 1%;
}
}
.in{
margin-bottom: 2px;

}
#mm{
height:35px;
}

</style>

<!-- <script type="text/javascript" src="../java_script/jquery-3.1.1.js"></script> -->


</head>

<body>


<jsp:include page="../common_ui/start.jsp"></jsp:include>
<form action="<%= application.getContextPath() %>/ModuleStatusUpdate"  method="post" id="msi">

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
<div class='col-md-6 heading' ><h3>Module Status</h3></div>
</div>

 <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl bg-primary'>ModuleStatusInfo:</div>
 
 <div class='col-md-4'><textarea rows="4" cols="50" class='form-control in'  name="module_status" > </textarea></div>
 <div class='col-md-2'></div>
 
 </div>
 
 <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl  bg-primary'>Difficulties:</div>
 
 <div class='col-md-4'><textarea rows="4" cols="50" class='form-control' name="difficulties" ></textarea></div>
 <div class='col-md-2'></div>
 
 </div>



<!--  <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl  bg-primary'>ProjectModuleId:</div>
 
 <div class='col-md-4'><select  id="pmid" name="p_m_id" class='form-control'></select></div>
 <div class='col-md-2'></div>
 
 </div> -->
 
 
<input type="hidden" id="hidden" value="<%= request.getParameter("projectmoduleid") %> "  name="hidden1">
 <!-- <input type="hidden" id="hidden" value="1" name="hidden1" >  -->
 

<!-- ModuleCompletionPercentage:<input type="text" name="percentage"><br/> -->



 <div class='row'>
 <div class='col-md-2'></div>
 <div class='col-md-4 lbl  bg-primary' id="mm">ModuleCompletionPercentage:</div>
 
 <div class='col-md-4'><input type="text" name="percentage" class='form-control' id='mcp' readonly></div>
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

	<a href="<%=request.getContextPath()%>/jsp/modulelist.jsp" class="btn btn-info btn-lg" title="Back to View Task">
          <span class="glyphicon glyphicon-arrow-left"></span> Back
    </a>
	
				
</div>


<jsp:include page="../common_ui/end.jsp"></jsp:include>
<script type="text/javascript">

	 $(document).ready(function() 
			 {
		
			var cid = $('#hidden').val();
		//	alert("cid value"+cid);
				$.ajax({
					url:"<%=application.getContextPath()%>/getModuleStatusId",
					data:{"cid": cid},
					success:function(mcp){
					var c=	$('#mcp');
					c.empty();
					 document.getElementById("mcp").value=mcp.moduleCompletionPercent; 
					//$("#mcp").attr("value",mcp.moduleCompletionPercent);
						/* for (var ind = 0; ind < states.length; ind++) {
							c.append("<option value='"+states[ind].s_id+"' name='"+states[ind].s_name+"'>"+states[ind].s_name+"</option>");
						}//for
						 */
						
					}//success
				});//ajax
			});
		
			//});
			
			
			
			
</script>

<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/formValidation.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formvalidation/js/framework/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/java_script/formValidationVar.js"></script>

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

            'module_status':statusValidators,

            'difficulties':statusValidators
        }
    });

</script>




 
 </body>
</html>