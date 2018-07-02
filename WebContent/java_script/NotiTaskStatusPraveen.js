/**
 *@author praveen 
 */
$(document).ready(function(){
	$.ajax({
		"url":path+"/NotificationTaskServlet",
	
		"success":function(data){
			
			//alert(data);
			$('#praveen-noti-count').html(data.length);
			 $('#praveen-noti-content').html("");
			 
			$.each(data,function(ind,obj){
				$('#praveen-noti-content').append('<li>'+
						'<a href="'+path+'/taskNotificationDetailsServlet?taskId='+obj.developerTaskId.developerTaskId+'">'+
						"BC"+obj.developerTaskId.moduleTaskId.taskTitle+"task status is Updated on "+obj.updationDate+
						'</a>'+
						'</li>' );
			
		    	});  //each
			
		},  //success
		
		"error":function(){
		//	alert("PLEASE TRY LATER");
			
		}
		
	});  //ajax
	
});  //document
