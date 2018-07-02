/**
 * 
 */

$(document).ready(function(){
	
	 $.ajax({ 
		url: path+"/NotificationAssignModuleurl",
		success : function(data){	
		/*	alert("hi");
			 alert(data);*/
			 $("#projectmanager-asigned-module-notifications_count").html(data.length);
			 $('#projectmanager-asigned-module-notifications').html("");
				$.each(data,function(ind,obj){
					 $('#projectmanager-asigned-module-notifications').append("<li><a href='"+path+"/NotificationAssignModule1?projectModuleId="+obj.projectModuleId+"'>NEW MODULE "+obj.moduleTitle+"  IS assigned CHECK ONCE</a></li>");    		  			          

				});
				
			   	
			}, //function
		       "error":function(){}

	});//ajax
	
});//doc
