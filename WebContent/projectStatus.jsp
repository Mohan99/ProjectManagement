<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url : "<%=application.getContextPath()%>/GetAllProject",
		success : function(data) {
			//alert("Avej:"+data);
			var c=	$('#pmid');
			c.append("<option>select project</option>");
			
			for (var ind = 0; ind < data.length; ind++) {
			c.append("<option value='"+data[ind].ProjectManagerProjectId+"' name='"+data[ind].ProjectManagerProjectId+"'>"+data[ind].ProjectManagerProjectId+"</option>");
			}//for
		}//success function
	});//ajax
$('#pmid').change(function(){
		
		var cid = $(this).val();
			$.ajax({
				url:"<%=application.getContextPath()%>/GetProjectCompletionPercentage",
				data:{"cid": cid},
				success:function(mcp){
				var c=	$('#mcp');
				c.empty();
				 document.getElementById("mcp").value=mcp.projectCompletionPercentage; 
				//$("#mcp").attr("value",mcp.moduleCompletionPercent);
					/* for (var ind = 0; ind < states.length; ind++) {
						c.append("<option value='"+states[ind].s_id+"' name='"+states[ind].s_name+"'>"+states[ind].s_name+"</option>");
					}//for
					 */
					
				}//success
			});//ajax
		});// change state
	
});//document ready
</script>

</head>
<body>
<form action="">
	statusInfo:<br><textarea rows="4" cols="45" name="statusInfo"></textarea><br>
difficulties: <br><textarea rows="4" cols="45" name="diff"></textarea><br>
ProjectManagerProjectId:<select  id="pmid" name="pmid"></select><br>
seenStatusId:
<select  id="ssi" name="ssi">			
	<!-- <option value="12">seen</option> -->
	<option value="13">unseen</option>
</select><br>
updationDate:<input type="date" name="update"><br>
ProjectComplete% :<input type="text" id="mcp" name="mcp"><br>
<input type="submit" value="submit"><input type="reset" value="reset">
	
</form>
</body>
</html>