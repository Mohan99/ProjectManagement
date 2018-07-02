function viewModule(val) {
	var moduleId = ($(val).attr("moduleId"));
	var url = '/ProjectManagement/viewmoduleinfo?mid='+ moduleId

		$.ajax({
			url : url,
			type : "get",
			success : function(res) {
				if (res.err != undefined) {

				} else {
					alert("success");
					window.location.reload();
					/*$("#view").empty();
					$("#view").html(res);*/
				}
			}
		});
}

