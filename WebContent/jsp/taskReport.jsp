<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>
    Axis Settings Example - HTML5 jQuery Chart Plugin by jqChart 
</title>
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/jquery.jqChart.css" />
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/jquery.jqRangeSlider.css" />
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/jquery-ui-1.10.4.css" />

</head>
<body>
<jsp:include page="../common_ui/start.jsp" ></jsp:include>
    <div>
        <div id="jqChartAnkush" style="width:100%; height: 350px">
         
        </div>
    </div>
    <jsp:include page="../common_ui/end.jsp" ></jsp:include>

    
    <script src="<%=application.getContextPath()%>/java_script/jquery.mousewheel.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath()%>/java_script/jquery.jqChart.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath()%>/java_script/jquery.jqRangeSlider.min.js" type="text/javascript"></script>
    
    <!--[if IE]><script lang="javascript" type="text/javascript" src="../../js/excanvas.js"></script><![endif]-->
    
    
    
    <script lang="javascript" type="text/javascript">
        $(document).ready(function () {


			$.ajax({
				url : "<%=application.getContextPath()%>/devTaskAction.ajax",
				
				success : function(status) {
				ShowReport(status);
				//debugger;
				}//success

			});//ajax 
        
        
			function ShowReport(datag){
				 var items=[];
				 var projectidarr=[];
				 var managername=[];
			
				  for (var i = 0; i < datag.length; i++) {
					
					  items[i]=[datag[i].taskTitle,datag[i].taskCompletionPercent]; 
					  projectidarr[i] = datag[i].startDate;
						  managername=[]=  datag[i].endDate;
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
          
				  $('#jqChartAnkush').jqChart({
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
                        hyperlinks:projectidarr,
                        as:managername
                     
                        
                    }
                ] 
            });
        
			}//showReport() 
        
        });//Doc
        
    </script>

    
</body>
</html>
   