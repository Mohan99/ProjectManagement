$(document).click(function() {
	// alert("clear");
	var clear = document.getElementById('Vmsg');
	clear.innerHTML = "";

});
function clearResponseMsg() {
	// alert(document.getElementById('Vmsg'));
	var clear = document.getElementById('Vmsg');
	clear.innerHTML = "";

}

function editValidation() {
	// alert("editVlaidation");
	var title = document.getElementById("title");
	var description = document.getElementById("description");
	var location = document.getElementById("loc");
	var sDate = document.getElementById("sdate");
	var sDate = document.getElementById("edate");
	var percentage = document.getElementById("percentage");
	var extension = document.getElementById("exdoc");
	var status = document.getElementById("status");

	var title_regex = /^[a-zA-Z]+$/;

	if (title.value.length == 0 || title.value == "") {
		title.placeholder = 'please enter Project Title';
		/* alert("please enter Project Title") */
		title.focus();
		return false;
	} else if (description.value.length < 10 || description.value == "") {
		description.placeholder = 'Atleast have 10 charecters';
		description.focus();
		return false;
	} else if (location.value.length == 0 || location.value == "") {
		location.placeholder = 'Choose Client Location';
		location.focus();
		return false;
	} else if (percentage.value.length == 0 || percentage.value == ""
			|| percentage.value > 100) {
		percentage.placeholder = 'Please give Completion Percentage below 100';
		percentage.focus();
		return false;
	} else if (status.value.length == 0 || status.value == "") {
		status.placeholder = 'Please give the Status of the Project';
		status.focus();
		return false;
	} else {
		return true;
	}

}

function btnrefresh() {
	var url = '/ProjectManagement/ViewAjaxAction'

	$.ajax({
		url : url,
		type : "get",
		success : function(res) {
			if (res.err != undefined) {

			} else {
				/*window.location.reload();*/
				 $("#div1").load(url) ;
				/*
				 * $("#view").empty(); $("#view").html(res);
				 */
			}
		}
	});

}

function btnDelete() {
	var projectId = $('#delProjectId').val();

	var url = '/ProjectManagement/DeleteProjectAction'
	var d = document.getElementById("anim");
	d.style.display = "block";
	$.ajax({
		url : url,
		data : {
			"txtprojectId" : projectId

		},
		type : "get",
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err);

			} else {
				/*location.reload(true);*/
				btnrefresh();
				d.style.display = "none";
				// alert(result);
				$("#edVmsg").empty();
				$("#edVmsg").html(result);
			}
		}
	});

}

function btnEditProject() {
	var pid = $('#projectid').val();
	var pTitle = $('#title').val();
	var description = $('#description').val();
	var refDoc = $('#refdoc').val();
	var location = $('#loc').val();
	var sdate = $('#sdate').val();
	var edate = $('#edate').val();
	var percentage = $('#percentage').val();
	var status = $('#status').val();

	/*
	 * alert(pid + "," + pTitle + "," + description + "," + location + "," +
	 * refDoc)
	 */

	var url = '/ProjectManagement/EditProjectAction?pid=' + pid + '&txttitle='
			+ pTitle + '&txtdescription=' + description + '&txtdoc=' + refDoc
			+ '&txtloc=' + location + '&txtSdate=' + sdate + '&txtEdate='
			+ edate + '&txtpercentage=' + percentage + '&txtstatus=' + status
	$.ajax({
		url : url,
		type : "POST",
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err);

			} else {
				/*location.reload(true);*/
				btnrefresh();
				/* d.style.display = "none"; */
				$("#edVmsg").empty();
				$("#edVmsg").html(result);
			}
		}

	});
}
