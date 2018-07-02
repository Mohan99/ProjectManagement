/**
 * 
 */

/*function add(){
	alert("display");
//	document.getElementById("display1234").Style="block";
	$("#msg").show();
	return false;
}
*/$(document).ready(function(){
	$.ajax({
		"url":path+"/ModuleNotification",
		
			"success":function(notifications){/*
				$("#pawan-noti-content").css("overflow","scroll");*/
				$("#pawan-noti").html(0);
				if(notifications.length>0){
					$("#pawan-noti").html(notifications.length);
					$("#pawan-noti-content").html("");
					$.each(notifications,function(ind,obj){
						
					 	debugger;
					 	
					 	$("#pawan-noti-content").append('<li><a href="'+path+'/moduleNotificationDetailsServlet?moduleId='+obj.projectModuleId.projectModuleId+'">'+
					 			''+obj.projectModuleId.moduleTitle+''+
					 			'&nbsp;	 update status of task to on date'+
					 			'<br>'+obj.updationDate+'  &nbsp;	 '+
					 			'having difficulty  '+obj.dificulties+'<br> click here'+

							
					 	'</a></li>');
					 	
						/*obj.moduleTaskId.projectModuleId.moduleTitle;
						
						obj.moduleTaskId.projectModuleId.teamLeadId.firstName;
						
						obj.updationDate;
						obj.statusInfo;
						obj.dificulties;
					*/
					});
					
					
				}
			},
			"error":function(){
				$("#pawan-noti-content").html("NOT BLE TO FETCH");
			}
		
	});
	
	
});
	
