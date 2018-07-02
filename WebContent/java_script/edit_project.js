function editVal(val) {
	var projectId = ($(val).attr("projectId"));
	var title = ($(val).attr("projectTitle"));
	var description = ($(val).attr("projectDescription"));
	var location = ($(val).attr("clientLocation"));
	var sdate = ($(val).attr("startDate"));
	var edate = ($(val).attr("endDate"));
	var percentage = ($(val).attr("completionPercentage"));
	var extension = ($(val).attr("docExtension"))
	var status = ($(val).attr("status"));

	/*alert(projectId + "," + title + "," + description + "," +","+referenceDoc +","+ location + ","
			+ sdate + "," + edate + "," + percentage + "," + extension + ","
			+ status)*/

	$("#projectid").val(projectId);
	$("#title").val(title);
	$("#description").val(description);
	$("#loc").val(location);
	$("#sdate").val(sdate);
	$("#edate").val(edate);
	$("#percentage").val(percentage);
	$("#exdoc").val(extension);
	$("#status").val(status);

}

function deleteVal(val) {
	var projectId = ($(val).attr("projectId"));
	$("#delProjectId").val(projectId);
}

function viewVal(val) {
	var projectId = ($(val).attr("projectId"));
	var url = '/ProjectManagement/ProjectInfoAction?pid=' + projectId
		$.ajax({
			url : url,
			type : "get",
			success : function(res) {
				if (res.err != undefined) {

				} else {
					window.location.assign(url);
					/*$("#div1").load(url)*/
					/*$("#view").empty();
					$("#view").html(res);*/
				}
			}
		});
}

function taskVal(val) {
	var projectId = ($(val).attr("projectId"));
	var url = '/ProjectManagement/jsp/taskStatus.jsp?projectManagerPid=' + projectId

	$.ajax({
		url : url,
		type : "get",
		success : function(res) {
			if (res.err != undefined) {

			} else {
				/*$("#div1").load(url)*/
				/*$("#view").empty();
				$("#view").html(res);*/
			}
		}
	});
}
