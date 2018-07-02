function deleteValue(val) {
	alert();
	var moduleId = ($(val).attr("moduleId"));
	alert("edit_moduleid"+moduleId)
	$("#delmoduleId").val(moduleId);
}

function btnDeleteValue() {
	// alert("delete:" + $('#delUserId').val());
	var moduleId = $('#delmoduleId').val();
	 alert("from btn deletetttt"+moduleId);
	var url='/ProjectManagement/DeleteModuleAction'
	var d = document.getElementById("anim");
	d.style.display = "block";
	$.ajax({
		url : url,
		data : {
			"txtmoduleId" : moduleId
		},
		type : "get",
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err + "gfjgvj");
				alert("refresh success error");
				$("#div1").load('/ProjectManagement/ViewAjaxAction');

			} else {
				
				d.style.display = "none";
				alert("refresh success");
				//$("#div1").load('/ProjectManagement/viewmodules');
				$("#div1").load('/ProjectManagement/viewmodules');
				//alert("After loading");
				/*btnrefresh();*/
				// alert(result);
				$("#edVmsg").empty();
				$("#edVmsg").html(result);
			}
		}
	});

}
