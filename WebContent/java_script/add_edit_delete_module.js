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
	var location = document.getElementById("doc");
	var sDate = document.getElementById("sdate");
	var sDate = document.getElementById("edate");
	var percentage = document.getElementById("percentage");
	var extension = document.getElementById("exdoc");

	var title_regex = /^[a-zA-Z]+$/;

	if (title.value.length == 0 || title.value == "") {
		title.placeholder = 'please enter Project Title';
		title.focus();
		return false;
	} else if (description.value.length < 4 || description.value == "") {
		description.placeholder = 'Atleast have 10 charecters';
		description.focus();
		return false;
	} else if (location.value.length == 0 || location.value == "") {
		location.placeholder = 'Choose Client Location';
		location.focus();
		return false;
	} else if (percentage.value.length == 0 || percentage.value == "") {
		percentage.placeholder = 'Please give Completion Percentage';
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

/*
 * function btnrefresh() { var url = '/ProjectManagement/ViewAjaxAction'
 * 
 * $.ajax({ url : url,
 * 
 * type : "get", success : function(res) { if (res.err != undefined) {
 *  } else { $("#view").empty(); $("#view").html(res); } } }); }
 */
function btnrefresh() {
	alert("refresh ");
	var url = '/ProjectManagement/ViewAjaxmoduleAction'
	$.ajax({
		url : url,
		type : "get",
		success : function(res) {
			if (res.err != undefined) {
				alert("refresh err");
				$("#div1").load(url);
			} else {
				alert("refresh success");
				$("#div1").load(url);
				/*
				 * $("#view").empty(); $("#view").html(res);
				 */
			}
		},
		error : function() {
			alert("refresh error");
		}
	});

}

function btnSub() {
	var mid = $('#addmoduleid').val();
	var mTitle = $('#addtitle').val();
	var description = $('#adddescription').val();
	var refDoc = $('#adddoc').val();
	var sdate = $('#addsdate').val();
	var edate = $('#addedate').val();
	alert(mid + "," + mTitle + "," + description + "," +refDoc+ "," + sdate
			+ "," + edate);

	var url = '/ProjectManagement/AddModuleAction?mid=' + mid + '&txttitle='
			+ mTitle + '&txtdescription=' + description + '&txtdoc=' + refDoc
			+ '&txtSdate=' + sdate + '&txtEdate='
			+ edate 
	$.ajax({
		url : url,
		/*
		 * data : { "projectId" : pid, "txttitle" : pTitle, "txtdescription" :
		 * description, "txtdoc" : new
		 * FormData(document.getElementById("refdoc")), "txtloc" : location,
		 * "txtSdate" : sdate, "txtEdate" : edate, "txtpercentage" : percentage,
		 * "txtstatus" : status
		 *  },
		 */
		type : "POST",
		/*
		 * enctype : 'multipart/form-data', cache : false, processData : false,
		 * contentType : false,
		 */
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err);
				alert("submission err");
				//$("#div1").load('/ProjectManagement/ViewAjaxAction');

			} else {
				
				/* d.style.display = "none"; */
				alert("submission success");
				$("#div1").load('/ProjectManagement/viewmodules');
				//$("#div1").load('/ProjectManagement/ViewAjaxAction');
				$("#edVmsg").empty();
				$("#edVmsg").html(result);
			}
		}

	});

}

function btnDelete() {
	// alert("delete:" + $('#delUserId').val());
	var moduleId = $('#delmoduleId').val();
	// alert("from btn deletetttt"+moduleId);
	alert("delete success" + moduleId);
	var url = '/ProjectManagement/DeleteProjectAction'
	var d = document.getElementById("anim");
	d.style.display = "block";
	$.ajax({
		url : url,
		data : {
			"txtprojectId" : moduleId
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

function btnEditProject() {
	var mid = $('#moduleid').val();
	var mTitle = $('#title').val();
	var description = $('#description').val();
	var refDoc = $('#doc').val();
	var sdate = $('#sdate').val();
	var edate = $('#edate').val();
	var percentage = $('#percentage').val();

	
	alert(mid + "," + mTitle + "," + description + "," +refDoc+ "," + sdate
			+ "," + edate);
	
	
	var url = '/ProjectManagement/EditModuleAction?mid=' + mid + '&txttitle='
			+ mTitle + '&txtdescription=' + description + '&txtdoc=' + refDoc
			+ '&txtSdate=' + sdate + '&txtEdate='
			+ edate + '&txtpercentage=' + percentage
	$.ajax({
		url : url,
		/*
		 * data : { "projectId" : pid, "txttitle" : pTitle, "txtdescription" :
		 * description, "txtdoc" : new
		 * FormData(document.getElementById("refdoc")), "txtloc" : location,
		 * "txtSdate" : sdate, "txtEdate" : edate, "txtpercentage" : percentage,
		 * "txtstatus" : status
		 *  },
		 */
		type : "POST",
		/*
		 * enctype : 'multipart/form-data', cache : false, processData : false,
		 * contentType : false,
		 */
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err);

			} else {
				
				alert("success");
				$("#div1").load('/ProjectManagement/viewmodules');
				//btnrefresh();
				
				/* d.style.display = "none"; */
				$("#edVmsg").empty();
				$("#edVmsg").html(result);
			}
		}

	});
}
