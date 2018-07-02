/**
 * 
 */
var prev;
function displayNotification(mid){
	//alert(prev);
	if( prev !=null){
	$(prev).hide();
	}
	$("#display123"+mid).show();
	
	prev="#display123"+mid;
	//alert("display123"+mid);
	return false;
}
$(document).ready(function(){
	$.ajax({
		"url":path+"/NotificationRegardingAction",
		"success":function(data){
			/*
			alert(data);
			*/
			 $('#anuj-dev-task-noti').html("");
			 //$('#d1').html("");
			 
			 $("#anuj-dt-noti-count").html(data.length);
			 $.each(data,function(ind,obj){
				
			/* alert(obj.moduleTaskId.taskDescription);
			alert(obj.moduleTaskId.taskTitle);
			alert(obj.moduleTaskId.projectModuleId.moduleDescription)
		  */
		  
		  
		  $('#anuj-dev-task-noti').append("<li>"+
			"<span class='caret'></span><a href='"+path+"/NotificationApprovlTasks?dtId="+obj.developerTaskId+"'> "+
			""+obj.moduleTaskId.taskTitle +" task belongs <br> to  "+ obj.moduleTaskId.projectModuleId.moduleTitle+" module <br> in "+obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectTitle+" project <br> is assigned to you"+
					"</a><hr>"+
					"</li>");
		  /*("<a href='#' onclick='return displayNotification("+obj.moduleTaskId.projectModuleId.projectModuleId+")'> Module notification"+obj.moduleTaskId.projectModuleId.projectModuleId+"</a>");
		          $('#d1').append("<div style='display:none' id='display123"+obj.moduleTaskId.projectModuleId.projectModuleId+"'><li > "+
		        		  "<a href='#'>"+
		        		  "<span class='glyphicon glyphicon glyphicon-envelope pull-right'></span>"+
		        		  "<label>PROJECTID: "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectId+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT TITLE : "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectTitle+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT DESCRIPTION : "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectDescription+
		        		  "</label>"+
		        		   "<br>"+ 
		        		   "<label>MODULE DESCRIPTION : "+
			        		  obj.moduleTaskId.projectModuleId.moduleDescription+
			        		  "</label>"+
			        		   "<br>"+
		        		  "<label>TASK TITLE : "+
		        		  obj.moduleTaskId.taskTitle+
		        		  "</label>"+
		        		   "<br>"+
		        		  "<label>TASK DESCRIPTIN: "+
		        		  obj.moduleTaskId.taskDescription+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>PROJECT MODULE ID: "+
		        		  obj.moduleTaskId.projectModuleId.projectModuleId+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label> MODULE TITLE: "+
		        		  obj.moduleTaskId.projectModuleId.moduleTitle+
		        		  "</label>"+
		        		  "<br>"+
		        		  "<label>STATUSID : "+
		        		  obj.approvalStatusId.statusId+
		        		  "</label>"+
		        		   "<br>"+
		        		   "<label>STATUS : "+
			        		  obj.approvalStatusId.status+
			        		  "</label>"+
			        		   "<br>"+
			        		   "<label>DEVELOPER TASK ID : "+
				        		  obj.developerTaskId+
				        		  "</label><div>"+
				        		   "<br>"+
		        		   "<label>TASK DESCRIPTIN: "+
		        		  obj.moduleTaskId.taskDescription+
		        		  "</label>"+
		        		  "<br>"+ 
		        		   "<label>PROJECT DESCRIPATION: "+
		        		  obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectDescription+
		        		  "</label>"+
		        		  "<br>"+ 
		        		  
		        		 
		        		  
		        		  
		        		  
		        		  "'</a>"+
		        			 
		        		 obj.moduleTaskId.projectModuleId.moduleDescription+ 
		        		 
			        		  
		        		  "</li>"+
		        		  " <li class='divider'>"+
		        		  +"<a href='#'><span class='glyphicon glyphicon glyphicon-envelope pull-right'></span></li>");
		    */      
			});
			
		},
		"error":function(){
			
			//alert("PLEASE TRY LATER");
			
			
		}
		
	});
	
	
	
});