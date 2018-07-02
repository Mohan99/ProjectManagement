/**
 * 
 */
var preve;
function displayNotification(mid){
	//alert(prev);
	if( preve !=null){
	$(preve).hide();
	}
	$("#display123"+mid).show();
	
	preve="#display123"+mid;
	//alert("display123"+mid);
	return false;
}


$(document).ready(function(){
	$('#accept')click(function(e){
		/*alert("hiee");*/
		$.ajax({
			"url":path+"/NotificationAccepted",
			"success":function(data){
				
				 $('#anuj-dt-Accept-noti').html("");
				 
				 $('#anuj-dt-Accept-count').html(data.length);
				 $.each(data,function(int,obj){
					 
				 })
				// )}// second
		     // second
			}
		  });// second
		});// second
			
		});// second
				
			
		
		
		
	
	
$(document).ready(function(){
	$.ajax({
		"url":path+"/NotificationAccepted",
		"success":function(data){
			/*
			alert(data+"vijay");*//*
		alert(	$("#anuj-dt-Approve-or-Reject-noti").html());*/
			 $('#anuj-dt-Approve-or-Reject-noti').html("");
			 //$('#d1').html("");
			 
			 $("#anuj-dt-Approve-or-Reject-count").html(data.length);
			 $.each(data,function(ind,obj){
				
			/* alert(obj.moduleTaskId.taskDescription);
			alert(obj.moduleTaskId.taskTitle);
			alert(obj.moduleTaskId.projectModuleId.moduleDescription)
		  */
		  
		  
		  $('#anuj-dt-Approve-or-Reject-noti').append("<li>"+
			"<span class='caret'></span><a href='"+path+"/NotificationRegardingApproveTaskTL?sup="+obj.developerTaskId+"'> "+
			""+obj.moduleTaskId.projectModuleId.projectModuleId+" task belongs <br> to  "+ obj.moduleTaskId.projectModuleId.moduleTitle+" module <br> in "+obj.moduleTaskId.projectModuleId.projectManagetProjectId.projectId.projectTitle+" project <br> "+
					"</a><hr>"+
		
		        		 
		        		  
		        		  
		        		  
		        		  "'</a>"+
		        			 
		        		 obj.moduleTaskId.projectModuleId.moduleDescription+ 
		        		 
			        		  
		        		  "</li>"+
		        		  " <li class='divider'>"+
		        		  +"<a href='#'><span class='glyphicon glyphicon glyphicon-envelope pull-right'></span></li>");
		          
			});
			
		},
		"error":function(){
			
			//alert("PLEASE TRY LATER");
			
			
		}
		
	});
	 
	
});