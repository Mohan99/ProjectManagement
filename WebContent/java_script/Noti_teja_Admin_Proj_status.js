/**
 * 
 */

$(document).ready(function(){
	 
	 $.ajax({ 
		
		 url: path+"/ProjectStatusurl",
		success : function(data){
/*			alert("hi");
			alert(data);
*/
			 $('#project-status-notifications_count').html(data.length);
			 $('#project-status-notifications').html("");
				$.each(data,function(ind,obj){
					
							 $('#project-status-notifications').append("<li><a href='"+path+"/NotificationProjectStatus1?projectId="+obj.projectId+"'>" +obj.projectTitle+" is Updated on "+obj.updationDate+" CHECK STATUS</a></li>");
				});
			 	
			}, 
		"error":function(){}

	});//ajaX

});//doc]
