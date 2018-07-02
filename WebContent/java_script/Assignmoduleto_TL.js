function Assignmoduleto_Tl(val){
	var moduleId = ($(val).attr("moduleid"));
	var TLID = ($(val).attr("tLId"));

	alert("TLID :" + TLID);
	var url = '/ProjectManagement/assignmoduletoTl'
	var d = document.getElementById("anim");
	d.style.display = "block";
	$.ajax({
		url : url,
		data : {
			"txtTlId" : TLID,
			"txtmoduleId":moduleId
		},
		type : "get",
		success : function(result) {
			if (result.err != undefined) {
				// dealng msg
				alert(result.err + "gfjgvj");
				alert("refresh success error");
			} else {
				
				d.style.display = "none";
				alert("module assigned");
				window.location.reload();
				//alert("After loading");
				/*btnrefresh();*/
				// alert(result);
				$("#eVmsg").empty();
				$("#edVmsg").html(result);
			}
		}
	});

}