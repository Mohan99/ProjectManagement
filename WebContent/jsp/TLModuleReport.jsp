<!DOCTYPE html >
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
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/css/jquery.jqChart.css" />
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/css/jquery.jqRangeSlider.css" />
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/css/jquery-ui-1.10.4.css" />
</head>
<body>
	<jsp:include page="../common_ui/start.jsp"></jsp:include>
	<div>
	
	
	<div id="mid">
	<center>
		<div id="jqChartm" style="width: 900px; height: 300px;"></div>
		</center>
	</div>
	<div id="tid">
	<center>
		<div id="jqCharttm" style="width: 900px; height: 300px; margin-top: 350px" ></div>
		</center>
	</div>


	<jsp:include page="../common_ui/end.jsp"></jsp:include>


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
/*Gobal variable for holding project id as a link */
            var link=" ";
        $(document).ready(function () {
           /* Ajax call for get projet Report generation data */
			$.ajax({
				url : "<%=application.getContextPath()%>/tlModuleAction.ajax",
				data : {
					
				},
				success : function(status) {
					/* call ShowReport method for Display Project Report */
				ShowMReport(status);
				}//success

			});//ajax 
			
        });//Doc
        
        
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
 				projectidarr[i]=datag[i].projectModuleId;
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
					cursor: 'pointer',
				hyperlinks:projectidarr,
					as : managername

				} ]
			});
			
			
			  $('#jqChartm').bind('dataPointMouseDown', function (event, data) {
	                 link = data.series.hyperlinks[data.index];
	                // alert("module id: "+link);
	                 var da=" ";
	                 ShowTReport(da,link);
});

$('#jqChartm').bind(
	'tooltipFormat',
	function(e, data) {
		return "<b>" + data.x + "</b><br />" + " " + data.y
				+ "" + " " + data.series.title;/*  + " "
				+ data.series.as[data.index */
	});

}//showMReport()

/* function to display Task Report */
function ShowTReport(datag,link) {

$.ajax({
url : "<%=application.getContextPath()%>/TaskReportServlet",
data : {
	"id": link
},
success : function(status) {
ShowReport(status);
//debugger;
}//success

});//ajax 


function ShowReport(datag){
 var items=[];
 var projectidarr=[];
 var devname=[];
 
  for (var i = 0; i < datag.length; i++) {
	  
	  items[i]=[datag[i].taskTitle, datag[i].taskCompletionPercent]; 
	 
	 devname[i]=datag[i].firstName;
	   
	  
  }



var background = {
type: 'linearGradient',
x0: 0,
y0: 0,
x1: 0,
y1: 1,
colorStops: [{ offset: 0, color: '#d2e6c9' },
             { offset: 1, color: 'white' }]
};

  $('#jqCharttm').jqChart({
title: { text: 'Developer Task Report' },
border: { strokeStyle: '#6ba851' },
background: background,
animation: { duration: 1 },
shadows: {
    enabled: true
},
axes: [
    {
        type: 'linear',
        location: 'left',
        minimum: 0,
        maximum: 100,
        interval: 10
    }
],

series: [
    {
        title: '%',
                type: 'column',  
        data: items,
        cursor: 'pointer',
        
        
    }
] 
});


}
}

        
	</script>


</body>
</html>
