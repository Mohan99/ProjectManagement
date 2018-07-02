/**
 * 
 */

$(document).ready(function(){
	
	 $.ajax({ 
		url: path+"/NotificationAssignProjecturl",
		success : function(data){
			//alert("Hiiii");
		//	alert(data);
			$('#admin-asigned-project-notifications_count').html(data.length);
					    $('#admin-asigned-project-notifications').html("");
					$.each(data,function(ind,obj){
     
			 $('#admin-asigned-project-notifications').append("<li><a href='"+path+"/NotificationAssignProject1?projectId="+obj.projectId+"'>New Project "+obj.projectTitle+" Is Assigned Please check</a></li>");
	    				          

					});

		}, //function
	       "error":function(){
	    	   
	    	 //  alert("PLEASE TRY LATER");
	    	   
	       }
		
		
	});//ajax
		
	
});//doc
