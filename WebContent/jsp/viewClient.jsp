<!-- 

 @author  Kunal Marathe , N.Sravanthi

-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path"  value="<%=application.getContextPath() %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View/Edit Client</title></head>
<body> <!--  onload="JavaScript:AutoRefresh(36000);" -->


	<jsp:include page="../common_ui/start.jsp"></jsp:include>

<script type="text/javascript">
$('#imgmsg').delay(1000).fadeOut();
</script>


<div class='row'>
<div class='col-md-12'  id="top">
<c:choose>
<c:when test="${ImgMsg ne null }">
 <div class="alert alert-success alert-dismissable fade in">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> ${ImgMsg}
  </div>
</c:when>
<c:when test="${err ne null }">
 <div class="alert alert-danger alert-dismissable fade in">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>FAILED!</strong> ${err}
  </div>

</c:when>

</c:choose>
<c:remove var="ImgMsg"/>
<c:remove var="err"/>
<%-- <% 
Object id=session.getAttribute("ImgMsg");
Object err=session.getAttribute("err");

if(id!=null){
		%>

 <div class="alert alert-success alert-dismissable fade in">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> ${ImgMsg}
  </div>
  
  
<%
session.removeAttribute("ImgMsg");

} 
else if(err!=null){

%>

 <div class="alert alert-danger alert-dismissable fade in">
    <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>FAILED!</strong> ${err}
  </div>
  <%

session.removeAttribute("err");  
} %>
 --%>
 </div>
</div>

<div class='col-md-12'>


<!-- DIV FOR USER SEARCH  -->
<!-- <div id="alertMsg"  style='float:left;margin-top:15px;' > -->
<div id="UserSearch" class="col-sm-3 col-md-3" style='float:right;margin-top:8px;' >
 <form action="" class="navbar-form" role="search"  >
 		<div class="input-group">
		<input type="text" class="form-control"  placeholder="Search" id="UsersSearch"  name="search">
		 <div class="input-group-btn">
		<button class="btn btn-default" onclick="return  searchData();" type="submit" value="Search" style='height:34px;'><i class="glyphicon glyphicon-search"></i></button>
	 </div>
	 </div>
	  </form>
         </div>
	 
<!-- 		<input type="text" id="search"  name="search"><input style="margin-left:165%;"  onclick="return searchData();" type="submit" value="Search" > -->
 </div>

	<div id="display123" style="
    margin-top: 6%;">

		<!-- $(proj).append("<div class='container well form-horizontal ' style='width: 800px;'><div id='first"+data[index].clientId+"'><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px;'><label>"+data[index].clientName+" </label></td></tr></table></div><div><button class=' btn btn-info' id='abc"+data[index].clientId+"' onClick='moreInfo("+data[index].clientId+")'  style='float: right;'>More Info</button></div></div></div>");
 -->
	</div>


	<div id='client'>
		<!-- <div id='clientInfo'"+cId+"><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px;'><label>"+cName+" </label></td></tr><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Description</td><td style='font-size: 20px;'><label>"+cDesc+" </label></td></tr></table></div><div style='float: right'><img alt='not available' src='cLogo' width='130px' height='100'  /></div><br><span><button class="btn btn-info" id='editClient1' style='margin-top: 10px;'   style='float: right;'>Edit</button><button class='btn btn-info' style='margin-top: 10px;' id='clientAddress'  style='float: right;'>Address</button></span></div>				 -->
	</div>

					
	
	
	
	
	
	<jsp:include page="../common_ui/end.jsp"></jsp:include>
	
<script type="text/javascript"
	src="${path }/java_script/bootstrapValidator.min.js"></script>
 
 <link rel="stylesheet"
	href="${path }/css/bootstrapValidator.min.css">
<script src="${path }/java_script/tether.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
//	$(".contact_person_form"+locationId).hide();
	getAllClient();
	//alert(+".................");	
});

	 function moreInfo(cid){
		 /*		 alert(cid);
 		 alert(data[cid]);
 */	     

		 $("#first"+cid).hide(1000);
	        $("#clientInfo"+cid).show(1000);
	        $("#clientAddress"+cid).show(1000);
	        $("#descButton"+cid).show(1000);
	        
/* 	   	 $("#client").append("<div id='clientInfo'"+cid+"><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px;'><label>"+cName+" </label></td></tr><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Description</td><td style='font-size: 20px;'><label>"+cDesc+" </label></td></tr></table></div><div style='float: right'><img alt='not available' src='cLogo' width='130px' height='100'  /></div><br><span><button class='btn btn-info' id='editClient1' style='margin-top: 10px;'   style='float: right;'>Edit</button><button class='btn btn-info' style='margin-top: 10px;' id='clientAddress'  style='float: right;'>Address</button></span></div>");
 */
/* 	        $("#clientInfo"+cid).show(1000);
 */
 
	 }

/* 	 id='hideEditClientBtn"+data[index].clientId+"' onclick='hideEdit("+data[index].clientId+")'
 */	 
	 function hideEdit(cid){
		 $("#pqr"+cid).hide(1000);
		 $("#descButton"+cid).show(1000);
	 }
	 function hideDesc(cid){
		 $("#pqr"+cid).hide(1000);
		 $("#first"+cid).show(1000);
	        $("#clientInfo"+cid).hide(1000);		 
	 }
	 
	 function editDesc(cid){
		 
		 $("#pqr"+cid).show(1000);
		 $("#descButton"+cid).hide(1000);
		 
 	 }
	 
	 function hidecontactPerson(locationId){
		 $("#hidecontactLocation"+locationId).hide(1000);
		 $("#contactLocation"+locationId).show(1000);
		 $("#cnt"+locationId).hide(1000);
	 }

		 
	 function editContactPerson(personId){
//		 $("#editcontact"+personId).show(1000);
	 }
	 function deleteContactPerson(personId){
		 $(document).ready(function() {
				$.ajax({
					type : "POST",
					url : "<%=application.getContextPath()%>/DeleteContactPerson",
															data : {
																"id":personId
															},
															success : function(data) {
															//	alert(data);
																if(data!=null||data!=""){
																	$("#top").empty();
																	$("#top").append(
																			' <div class="alert alert-success alert-dismissable fade in" style="float:left;margin-top:8px;">'
																			  + ' <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
																   +'<strong>Success!</strong> '+data+'</div>');
																  
																}
																//hidecontactPerson(personId);
																/*  $("#msg"+cpid).show();
																	$("#msg"+cpid).empty();
															
																	contactPerson(locId); */
																getAllClient();
																	
															}
				});});
	 }
	 
	 function contactPerson(locationId){
		
		 $("#contactLocation"+locationId).hide(1000);
		 $("#hidecontactLocation"+locationId).show(1000);
//alert("contact person");
	 		$(document).ready(function() {
 				$.ajax({
 					type : "POST",
 					url : "<%=application.getContextPath()%>/ViewContactPerson.ajax",
 															data : {
 																"locationId" : locationId
 															},
 															success : function(data) {
 															//	alert("success"+data);
 																 $("#cnt"+locationId).empty();
 																$("#cnt"+locationId).show(1000);
 				
 																if(data[0] != null){
 																$
 																		.each(
 																				data,
 																				function(
 																						index) {
 																					 $("#cnt"+locationId).append("<table><tr><td style='width: 200px;color: blue;font-size: 22px;'>Contact Person</td></tr><tr id='msg"+data[index].clientContactPersonId+"''></tr><tr> <td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'> Person Name</td> <td style='font-size: 20px;'><label>"+data[index].contactPersonName+"</label></td></tr><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Person Email</td><td style='font-size: 20px;'><label>"+data[index].email+"</label></td></tr>");
 																					 $("#cnt"+locationId).append("<tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Person Mobile</td> <td style='font-size: 20px;'><label>"+data[index].mobileNo+" </label></td><td>	<button class='btn btn-info' id='editContact2' onclick='editContactPerson("+data[index].clientContactPersonId+")' data-toggle='collapse' data-target='#editcontact"+data[index].clientContactPersonId+"'   style='float: right;margin-right: 0px;width: 98px;'>Edit Info</button><button class='btn btn-danger' id='deleteContact2' onclick='deleteContactPerson("+data[index].clientContactPersonId+")'  style='float: right;width: 91px;'>Delete</button></td></tr>");
 																					 $("#cnt"+locationId).append("<tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'></td><td style='font-size: 20px;width:350px;'><label></label></td><td></td></tr></table>");
  														//							 $("#cnt"+locationId).append("<div id='editcontact"+data[index].clientContactPersonId+"' style='display:none;  ><div><form  class='well form-horizontal' action='ch' method='post' id='contact_person_form'><div class='form-group'><label class='col-md-4 control-label'>Person Name</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> <input name='person_name' class='form-control'  placeholder='Person Name' value='"+data[index].contactPersonName+"' class='form-control' type='text'></div></div></div><div class='form-group'><label class='col-md-4 control-label'>E-Mail</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-envelope'></i></span> <input name='email' class='form-control' placeholder='E-Mail Address' value='"+data[index].email+"' class='form-control' type='text'></div></div></div><div class='form-group'><label class='col-md-4 control-label'>Mobile No</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-earphone'></i></span> <input name='phone' placeholder='Enter mobile no ' value='"+data[index].mobileNo+"' class='form-control' type='text'></div></div></div><div class='form-group'><label class='col-md-4 control-label'></label><div class='col-md-4'><button type='submit' class='btn btn-warning' name='contact'  value='cntPerson'> Update </span></button></div></div></form></div></div>");
  																				 $("#cnt"+locationId).append("<div id='editcontact"+data[index].clientContactPersonId+"'  class='collapse' style=' width:700px; ' ><form class='well form-horizontal' action='' method='post' id='contact_person_form'><input id='' type='hidden' value='"+data[index].clientContactPersonId+"' name = 'id'><div class='form-group'> <label class='col-md-4 control-label'>Person Name</label><div class='col-md-4 inputGroupContainer'> <div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> <input style='width:300px' id='cpName"+data[index].clientContactPersonId+"' name='person_name' placeholder='Person Name' class='form-control'style='width:300px' type='text' value='"+data[index].contactPersonName+"'></div><span style='color:red' id='contatctPersonName"+data[index].clientContactPersonId+"' ></span></div></div><div class='form-group'><label class='col-md-4 control-label'>E-Mail</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-envelope'></i></span> <input style='width:300px' id='cpEmail"+data[index].clientContactPersonId+"' name='email'  placeholder='E-Mail Address' class='form-control' type='text' value='"+data[index].email+"'></div><span style='color:red' id='contatctPersonEmail"+data[index].clientContactPersonId+"' ></span></div></div><div class='form-group'><label class='col-md-4 control-label'>Mobile No</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-earphone'></i></span> <input style='width:300px' name='phone' id='cpMobile"+data[index].clientContactPersonId+"' placeholder='Enter mobile no ' class='form-control' type='text' value='"+data[index].mobileNo+"' ></div><span style='color:red' id='contatctPersonMobile"+data[index].clientContactPersonId+"' ></span></div></div><div class='form-group' id='cnt1'><label class='col-md-4 control-label'></label><div class='col-md-4'><button type='submit' class='btn btn-warning' onclick='return sendClientContactEditData("+data[index].clientContactPersonId+","+locationId+")' name='contact' value='cntPerson'>Update <span class='glyphicon glyphicon-send'></span></button></div></div></form>");
  																				 
 																				});
 																}else{
 																	                $("#cnt"+locationId).append("<h3 style='color:red;text-align:center'>No Contat Person found</h3><span><button class='btn btn-info' id='addContact2'  data-toggle='collapse' data-target='#addcontact"+locationId+"'   style='/* float: right; */margin-right: 329px;width: 142px;padding-right: 0px;border-right-width: 0px;padding-left: 2px;border-bottom-width: 1px;margin-bottom: 0px;margin-left: 328px;'>AddContactPerson</button>");//style='margin-left: 2%; margin-left: 324px;width: 160px; '>AddContactPerson</button>
 																
 																	                $("#cnt"+locationId).append("<div id='addcontact"+locationId+"'  class='collapse' style=' width:700px; ' ><form class='well form-horizontal' action='' method='post' id='contact_person_form' ><input id='' type='hidden' value='"+locationId+"' name = 'id'><div class='form-group'> <label class='col-md-4 control-label'>Person Name</label><div class='col-md-4 inputGroupContainer'> <div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> <input style='width:300px' id='cpAddName"+locationId+"' name='person_name' placeholder='Person Name' class='form-control'style='width:300px' type='text' ></div><span style='color:red' id='cpSpanName"+locationId+"'></span></div></div><div class='form-group'><label class='col-md-4 control-label'>E-Mail</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-envelope'></i></span> <input style='width:300px' id='cpAddEmail"+locationId+"' name='email'  placeholder='E-Mail Address' class='form-control' type='text' ></div><span style='color:red' id='cpSpanEmail"+locationId+"'></span></div></div><div class='form-group'><label class='col-md-4 control-label'>Mobile No</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-earphone'></i></span> <input style='width:300px' name='phone' id='cpAddMobile"+locationId+"' placeholder='Enter mobile no ' class='form-control' type='text'  ></div><span style='color:red' id='cpSpanMobile"+locationId+"'></span></div></div><div class='form-group' id='cnt1'><label class='col-md-4 control-label'></label><div class='col-md-4'><button type='submit' class='btn btn-warning' onclick='return sendClientContactAddData("+locationId+")' name='contact' value='cntPerson'>Add <span class='glyphicon glyphicon-send'></span></button></div></div></form>");
																		
 																}
 															}
 														});
 											});
	 }
	 
 	 function viewLocation(cid){
 		 
 		// $("#clientAddress"+cid).hide(1000);
 		 
 		$(document).ready(function() {
 				$.ajax({
 					type : "POST",
 					url : "<%=application.getContextPath()%>/ViewClientLocation.ajax",
 															data : {
 																"clientId" : cid
 															},
 															success : function(data) {
 																$("#loc"+cid).empty();
 																$("#loc"+cid).append("<div style='width: 800px;'class='collapse' id='xyz"+cid+"' id='address'><table><tr><td style='width: 200px;color: blue;font-size: 22px;'>Client Location</td></tr>");
 																$
 																		.each(
 																				data,
 																				function(
 																						index,obj) {
 											 										$("#loc"+cid)
 																							.append("<tr><td  style='width: 200px;color: blue;font-size: 22px;'>Location "+(index+1)+" </td><td style='font-size: 20px; width:300px;'><label>"+data[index].address+","+data[index].pinCode+","+data[index].city+"</label></td><td style='float: right;' ><button class='btn btn-info' id='contactLocation"+data[index].clientLocationId+"' style='margin-top: 12px;'   onclick='contactPerson("+data[index].clientLocationId+")'>Client Contact Person</button><button class='btn btn-info' style='display:none;margin-top:28%;'  id='hidecontactLocation"+data[index].clientLocationId+"' onclick='hidecontactPerson("+data[index].clientLocationId+")'>Client Location</button></td> </tr> </table></div>");
 											 										$("#loc"+cid).append("<div id='cnt"+obj.clientLocationId+"'></div>");
 														 						});
 															}
 														});
 											});
 						}
 	 
 	 function sendClientEditData(cid){
 		 var cName = document.getElementById("cName"+cid).value;
 		 var cDesc = document.getElementById("cDesc"+cid).value;
 		 var flag = true;

			document.getElementById("nameValid"+cid).innerHTML="";
	 		document.getElementById("descValid"+cid).innerHTML="";

 		 if(cName.length <5){
 			 document.getElementById("nameValid"+cid).innerHTML="client Name  length must hava at least 5 character";
 			flag = false;
 		 }
 		 if(cDesc.length <=20){
 			document.getElementById("descValid"+cid).innerHTML="client Description  length must hava at least 20 character";
 			flag = false;
 		 }
 		 if(flag){
 		$.ajax({ url: "<%=application.getContextPath()%>/EditClient",
				data : {
				"clientId" : cid,
				"cName": cName,
				"cDesc" : cDesc
			},
										success : function(data) {
										//	alert(data);
										//if(data!=null||data!=""){
											
																	$("#top").empty();
											
											$("#top").append(
															' <div class="alert alert-success alert-dismissable fade in" style="float:left;margin-top:8px;">'
																			  + ' <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
																   +'<strong>Success!</strong> '+data+'</div>');		  
										//}
//											hideEdit(cid);
											//hideDesc(cid);
											getAllClient();
//										moreInfo(cid);
									//	abc(cid).click();
										/* $("#abc"+(cid)).click(){
											
										} */
			
										}
									});
 		 }
 		 return false;
 	 }
 	 
 	 
	 function sendClientContactEditData(cpid,locId){
		 var ph = new RegExp( "^[7-9][0-9]{9}$");
		 var em =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  		 var cpName = document.getElementById("cpName"+cpid).value;
 		 var cpEmail = document.getElementById("cpEmail"+cpid).value;
 		 var cpMobile = document.getElementById("cpMobile"+cpid).value;
 		var patt = new RegExp(em);
 		var flag = true;
 		
 		document.getElementById("contatctPersonName"+cpid).innerHTML="";
		document.getElementById("contatctPersonEmail"+cpid).innerHTML="";
		document.getElementById("contatctPersonMobile"+cpid).innerHTML="";

 		 if(cpName.length < 4 || cpName == "      "){
 			document.getElementById("contatctPersonName"+cpid).innerHTML="having minimum length 5";
 			flag = false;
 		 } 
 		 if(!patt.test(cpEmail)){
  			document.getElementById("contatctPersonEmail"+cpid).innerHTML="invalid email syntax";
  			flag = false;
 		 }  
 		 if(!ph.test(cpMobile)){
  			document.getElementById("contatctPersonMobile"+cpid).innerHTML="10 digit number start with 7,8 or 9";
  			flag = false;
 		 } 
 		 
 		 if(flag){	 
 		$.ajax({ url: "<%=application.getContextPath()%>/EditContactPerson",
				data : {
				"contactPersonId" : cpid,
				"cpName": cpName,
				"cpEmail" : cpEmail,
				"cpMobile" : cpMobile
			},
										success : function(data) {
										//	alert(data);
										
																	$("#top").empty();
											
											$("#top").append(' <div class="alert alert-success alert-dismissable fade in" style="float:left;margin-top:8px;">'
																			  + ' <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
																   +'<strong>Success!</strong> '+data+'</div>');		 
//											hideEdit( cid);
                                      $("#msg"+cpid).show();
											$("#msg"+cpid).empty();
									
											contactPerson(locId);
										$("#msg"+cpid).append(data);
											document.getElementById("msg"+cpid).value=data;
										}
									});
 		 
	 }
 		  	 return false;
 	 }
	 
function sendClientContactAddData(locId){
	
  		 var cpName = document.getElementById("cpAddName"+locId).value;
 		 var cpEmail = document.getElementById("cpAddEmail"+locId).value;
 		 var cpMobile = document.getElementById("cpAddMobile"+locId).value;
 		 
		 var ph = new RegExp( "^[7-9][0-9]{9}$");
		 var em =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
 		var patt = new RegExp(em);
 		var flag = true;
			document.getElementById("cpSpanName"+locId).innerHTML=""; 
  			document.getElementById("cpSpanEmail"+locId).innerHTML="";
  			document.getElementById("cpSpanMobile"+locId).innerHTML="";

 		 if(cpName.length < 4 || cpName == "      "){
 			document.getElementById("cpSpanName"+locId).innerHTML="having minimum length 5";
 			flag = false;
 		 }
 		 if(!patt.test(cpEmail)){
  			document.getElementById("cpSpanEmail"+locId).innerHTML="invalid email syntax";
 			flag = false;

 		 }
 		 if(!ph.test(cpMobile)){
  			document.getElementById("cpSpanMobile"+locId).innerHTML="10 digit number start with 7,8 or 9";
  			flag  = false;
 		 } 

 		 if(flag){ 		 
 			 	
 		$.ajax({ url: "<%=application.getContextPath()%>/AddContactPerson",
				data : {
				"locationId" : locId,
				"cpName": cpName,
				"cpEmail" : cpEmail,
				"cpMobile" : cpMobile
			},
										success : function(data) {
											if(data!=null){
											//alert(data);
											$("#top").empty();
											$("#top").append(
													' <div class="alert alert-success alert-dismissable fade in" style="float:left;margin-top:8px;">'
													  + ' <a href="" class="close" data-dismiss="alert" aria-label="close">&times;</a>'
										   +'<strong>Success!</strong> '+data+'</div>');
											//  $("#cnt"+locationId).show();
//											hideEdit( cid);
// $("#msg"+cpid).show();
											//$("#msg"+cpid).empty();
							                //getAllClient();
							                hidecontactPerson(locId);
										    //contactPerson(locId);
									        //	$("#msg"+cpid).append(data);
											//document.getElementById("msg"+cpid).value=data;
							 		}
										}
									});
 		 
 		 }
 		 
 		 
 		 return false;
 	 }
 	 
 	 
 	 function searchData(){
 		 
 		 var id = $('#UsersSearch').val();
 		$(document).ready(function(){
 			//alert(id);
 		// var msg='${sessionScope.ImgMsg}';
 		
 			if(id ==''){
 				getAllClient();
 			} 
 			else{	
 			$.ajax({ url: "<%=application.getContextPath()%>/ClientDetailsBasedOnSearch",
 				data : {
 				"searchValue" : id
 				
 			},
 										success : function(data) {
 											var proj = document
 													.getElementById("display123");
 											$(proj).empty();
 											
 												$(proj)
												.append("<div id='main123'>");

 												if(data.length == 1 &&  data == ""){	
 													$(proj).append("<h2 style='color:red;text-align:center'>No Client Found please check your spell.... <h2>");
 		 										}
 												$.each(data,function(index) { 	 											
														$(proj)
													.append(
															"<div class='container well form-horizontal ' style='width: 800px;' id='first"+data[index].clientId+"'><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px; width:400px;'><label>"
																	+ data[index].clientName
																	+ " </label></td><td><img src='"+data[index].logo+"' style='width:60px;height:40px'</td></tr></table></div><div><button class=' btn btn-info' id='abc"
																	+ data[index].clientId
																	+ "' onClick='moreInfo(" 
																	+ data[index].clientId
																	+ ")' style='float: right;width: 125px;'>More Info</button></div></div></div>");
														$(proj)                                                                                                  
													.append(
															"<div style='display:none;width: 800px;' class='container well form-horizontal ' id='clientInfo"+data[index].clientId+"' ><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px;'><label>"
																	+ data[index].clientName
																	+ " </label></td></tr><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Description</td><td style='font-size: 20px;'><label>"
																	+ data[index].clientDescription
																	+ " </label></td></tr></table></div><div style='float: right'><img alt='not available' src='" +data[index].logo+ "' width='130px' height='100'  /><br><span style='color:red;' id='logovalid"+data[index].clientId+"' ></span><form action='<%=application.getContextPath()%>/uploadLogo' method='post' enctype='multipart/form-data'><input type='hidden' name='id' class='btn btn-info' value='"+data[index].clientId+"'><input type='file'  accept='image/x-png,image/gif,image/jpeg' id='lgvalid"+data[index].clientId+"' style='width:100px' name='logo'/><input type='submit' value='upload'  onClick ='return logovalidation("+data[index].clientId+");'class='btn btn-info'/><form></div><br><div style='margin-top:150px;'><button class='btn btn-danger' style='float:right;width: 12%;padding-left: 9px;border-left-width: 0px;padding-right: 9px;margin-left: 0px;margin-right: 131px;' onclick='hideDesc("+data[index].clientId+")' id='clientAddress'>Close</button></div><div style='float: right;margin-top: 0px;height: 34px;width: 187px;' id='descButton"+data[index].clientId+"'><button class='btn btn-info' data-toggle='collapse' data-target='#pqr"+data[index].clientId+"'  id='editClient1'  style='width: 20%;padding-left: 25px;padding-right: 57px;'>Edit</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class='btn btn-info' data-toggle='collapse'   onclick='viewLocation("+data[index].clientId+")' id='clientAddress"+data[index].clientId+"'  style='width: 82px;padding-right: 0px;border-left-width: 0px;margin-right: 0px;margin-left: 0px;padding-left: 1px;height: 34px;'>Address</button>&nbsp;&nbsp;&nbsp;&nbsp;<br></div><div class='collapse' id='pqr"+data[index].clientId+"' style='margin-top:1%;padding-top: 7%;'><form ><input type='hidden' value='"+data[index].clientId+"'   name='contactid'/><div class='form-group'><label class='col-md-4 control-label'>Client Name</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> <input name='client_name' style='width:250px; margin-right:-20px;' placeholder='Client Name' class='form-control' id='cName"+data[index].clientId+"' value='"+data[index].clientName+"' type='text'></div><span style='color:red' id='nameValid"+data[index].clientId+"'></span></div></div><div class='form-group'><label -20px class='col-md-4 control-label'>Client Description</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-pencil'></i></span><textarea style='width:250px; margin-right:-20px;' id='cDesc"+data[index].clientId+"' class='form-control'  name='comment'	placeholder='Client Description'>"+data[index].clientDescription+"</textarea></div><span style='color:red' id='descValid"+data[index].clientId+"'></span></div></div><div class='form-group'><label class='col-md-4 control-label'></label><div class='col-md-4'><button type='submit' class='btn btn-warning' onclick='return sendClientEditData("+data[index].clientId+")' name ='addClient' value='add_client'>Update <span class='glyphicon glyphicon-send'></span></button></div></div></form></div><div style='width: 800px; float:left;' id='loc"+data[index].clientId+"'></div></div>");

						});
												$(proj)
												.append("</div >");
 											

 										}
 									});
 			}
 						});
 		
 		 
 		
 		 return false;
 	 }
 	 
 	function logovalidation(id){
 	    var fuData = document.getElementById('lgvalid'+id);
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') {
        	document.getElementById('logovalid'+id).innerHTML="Please upload an image";
        	return false;
        } else {
            var Extension = FileUploadPath.substring(
                    FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

//The file uploaded is an image

if (Extension == "gif" || Extension == "png" || Extension == "bmp"
                    || Extension == "jpeg" || Extension == "jpg") {

// To Display
                if (fuData.files && fuData.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function(e) {
                        $('#blah').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(fuData.files[0]);
                }

            } 

//The file upload is NOT an image
else {
	document.getElementById('logovalid'+id).innerHTML="Invalid file allow images";
	return false;
            }
        } 	
        return true;
        }
 	 
	function getAllClient(){
		//alert();
	//$(document).ready(function(){
		$.ajax({ url: "<%=application.getContextPath()%>/ViewAllClient",
									success : function(data) {
										//alert(data+"data");
										var proj = document
												.getElementById("display123");
				 											$(proj).empty();
				 											$(proj)
															.append("<div id='main123'>  ");
				 											if(data.length == 0  ){

				 												$(
				 														proj)
				 														.append("<h2 style='text-align:center;color:red'>No Client Found </h2>");

				 											}
		 													$.each(data,function(index) {
		 													
																$(proj)
																.append(
																		"<div class='container well form-horizontal ' style='width: 800px;' id='first"+data[index].clientId+"'><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px; width:400px;'><label>"
																				+ data[index].clientName
																				+ " </label></td><td><img src='"+data[index].logo+"' style='width:60px;height:40px'</td></tr></table></div><div><button class=' btn btn-info' id='abc"
																				+ data[index].clientId
																				+ "' onClick='moreInfo(" 
																				+ data[index].clientId
																				+ ")' style='float: right;width: 125px;'>More Info</button></div></div></div>");
																	$(proj)                                                                                                  
																.append(
																		"<div style='display:none;width: 800px;' class='container well form-horizontal ' id='clientInfo"+data[index].clientId+"' ><div style='float: left;'><table style='width: 600px;'><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Name</td><td style='font-size: 20px;'><label>"
																				+ data[index].clientName
																				+ " </label></td></tr><tr><td style='font-size: 20px; color: blue; width: 200px; line-height: 40px;'>Client Description</td><td style='font-size: 20px;'><label>"
																				+ data[index].clientDescription
																				+ " </label></td></tr></table></div><div style='float: right'><img alt='not available' src='" +data[index].logo+ "' width='130px' height='100'  /><br><span style='color:red;' id='logovalid"+data[index].clientId+"' ></span><form action='<%=application.getContextPath()%>/uploadLogo' method='post' enctype='multipart/form-data'><input type='hidden' name='id' class='btn btn-info' value='"+data[index].clientId+"'><input type='file'  accept='image/x-png,image/gif,image/jpeg' id='lgvalid"+data[index].clientId+"' style='width:100px' name='logo'/><input type='submit' value='upload'  onClick ='return logovalidation("+data[index].clientId+");'class='btn btn-info'/><form></div><br><div style='margin-top:150px;'><button class='btn btn-danger' style='float:right;width: 12%;padding-left: 9px;border-left-width: 0px;padding-right: 9px;margin-left: 0px;margin-right: 131px;' onclick='hideDesc("+data[index].clientId+")' id='clientAddress'>Close</button></div><div style='float: right;margin-top: 0px;height: 34px;width: 187px;' id='descButton"+data[index].clientId+"'><button class='btn btn-info' data-toggle='collapse' data-target='#pqr"+data[index].clientId+"'  id='editClient1'  style='width: 20%;padding-left: 25px;padding-right: 57px;'>Edit</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class='btn btn-info' data-toggle='collapse'   onclick='viewLocation("+data[index].clientId+")' id='clientAddress"+data[index].clientId+"'  style='width: 82px;padding-right: 0px;border-left-width: 0px;margin-right: 0px;margin-left: 0px;padding-left: 1px;height: 34px;'>Address</button>&nbsp;&nbsp;&nbsp;&nbsp;<br></div><div class='collapse' id='pqr"+data[index].clientId+"' style='margin-top:1%;padding-top: 7%;'><form ><input type='hidden' value='"+data[index].clientId+"'   name='contactid'/><div class='form-group'><label class='col-md-4 control-label'>Client Name</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span> <input name='client_name' style='width:250px; margin-right:-20px;' placeholder='Client Name' class='form-control' id='cName"+data[index].clientId+"' value='"+data[index].clientName+"' type='text'></div><span style='color:red' id='nameValid"+data[index].clientId+"'></span></div></div><div class='form-group'><label -20px class='col-md-4 control-label'>Client Description</label><div class='col-md-4 inputGroupContainer'><div class='input-group'><span class='input-group-addon'><i class='glyphicon glyphicon-pencil'></i></span><textarea style='width:250px; margin-right:-20px;' id='cDesc"+data[index].clientId+"' class='form-control'  name='comment'	placeholder='Client Description'>"+data[index].clientDescription+"</textarea></div><span style='color:red' id='descValid"+data[index].clientId+"'></span></div></div><div class='form-group'><label class='col-md-4 control-label'></label><div class='col-md-4'><button type='submit' class='btn btn-warning' onclick='return sendClientEditData("+data[index].clientId+")' name ='addClient' value='add_client'>Update <span class='glyphicon glyphicon-send'></span></button></div></div></form></div><div style='width: 800px; float:left;' id='loc"+data[index].clientId+"'></div></div>");

									});
															$(proj)
															.append("</div >");

									}
								});
					//});
	}
	
	
	 $("#AddContactPerson").click(function(){
	        $("#contact_person_form").show();
	    });

	
	
	

	
	
</script>
<script type="text/JavaScript">
         
            function AutoRefresh( t ) {
               setTimeout("location.reload(true);", t);
            }
            
         
      </script>
	
</body>
</html>


