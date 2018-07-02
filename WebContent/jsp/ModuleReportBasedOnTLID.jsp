<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Axis Settings Example - HTML5 jQuery Chart Plugin by
	jqChart</title>
<style>
 #mid {
	position: absolute;
	right: 50px;
	top: 10px;
} 
</style>
</head>
<body>
	<jsp:include page="../common_ui/start.jsp"></jsp:include>
	<div id="mid">
		<div id="jqChartm" style="width: 440px; height: 300px;"></div>
	</div>


	<jsp:include page="../common_ui/end.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css"
		href="<%=application.getContextPath()%>/css/jquery.jqChart.css" />
	<link rel="stylesheet" type="text/css"
		href="<%=application.getContextPath()%>/css/jquery.jqRangeSlider.css" />
	<link rel="stylesheet" type="text/css"
		href="<%=application.getContextPath()%>/css/jquery-ui-1.10.4.css" />

	<script
		src="<%=application.getContextPath()%>/java_script/jquery.mousewheel.js"
		type="text/javascript"></script>
	<script
		src="<%=application.getContextPath()%>/java_script/jquery.jqChart.min.js"
		type="text/javascript"></script>
	<script
		src="<%=application.getContextPath()%>/java_script/jquery.jqRangeSlider.min.js"
		type="text/javascript"></script>

	<!--[if IE]><script lang="javascript" type="text/javascript" src="../../js/excanvas.js"></script><![endif]-->

	<script lang="javascript" type="text/javascript">
        $(document).ready(function () {
       
		                 /* Ajax call for get module Report generation data based on projetc id */
		    			$.ajax({
		    				url : "<%=application.getContextPath()%>/ModuleReport",
															data : {
															
															},
															success : function(status) {
																//alert("MD:"+status);
																/* call ShowMReport method for Display Module Report */
																ShowMReport(status);
															}//success

														});//ajax 
											});

						

						/* function to display module Report */
						function ShowMReport(datag) {
							/* Two Diamensional array to hold Project Name and Project Completion in Percentage */
							var items = [];
							/* One Diamensional array to hold module  Id */
							var projectidarr = [];
							/* One Diamensional array to hold Team Lead Names */
							var managername = [];

							for (var i = 0; i < datag.length; i++) {
								items[i] = [ datag[i].moduleTitle,
										datag[i].moduleCompletionPercent ];
								managername[i] = datag[i].firstName + " "
										+ datag[i].lastName;
							}

							var background = {
								type : 'linearGradient',
								x0 : 0,
								y0 : 0,
								x1 : 0,
								y1 : 1,
								colorStops : [ {
									offset : 0,
									color : '#d2e6c9'
								}, {
									offset : 1,
									color : 'white'
								} ]
							};

							$('#jqChartm').jqChart({
								title : {
									text : 'Module Report'
								},
								border : {
									strokeStyle : '#6ba851'
								},
								background : background,
								animation : {
									duration : 1
								},
								shadows : {
									enabled : true
								},
								axes : [ {
									type : 'linear',
									location : 'left',
									minimum : 0,
									maximum : 100,
									interval : 10
								} ],

								series : [ {
									title : '%',
									type : 'column',
									data : items,
									//cursor: 'pointer',
									// hyperlinks:projectidarr,
									as : managername

								} ]
							});

							$('#jqChartm').bind(
									'tooltipFormat',
									function(e, data) {
										return "<b>" + data.x + "</b><br />"
												+ " " + data.y + "" + " "
												+ data.series.title + "<br />"
												+ " "
												+ data.series.as[data.index];
									});

						}//showMReport()

		
</script>


</body>
</html>