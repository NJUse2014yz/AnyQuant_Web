/**
 * @param title 饼图标题
 * @param data 数据数组
 * @param htmlId 
 * @param name 名称的属性名
 * @param value 值的属性名
 */
function pieChart(title,data,htmlId,name,value){
	
	var pieData=[];
	
	//将data中的值取到pieData中
	$.each(data,function(i,vo){
		pieData.push([vo[name],vo[value]]);
	});
	
	$('#'+htmlId).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: title
        },credits:{
            enabled:false // 禁用版权信息
	     },
        tooltip: {
    	    pointFormat: '<b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
//            pie: {
//                allowPointSelect: true,
//                cursor: 'pointer',
//                dataLabels: {
//                    enabled: true,
//                    color: '#000000',
//                    connectorColor: '#000000',
//                    format: '{point.name}: {point.percentage:.1f} %'
//                }
//            }
        	
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
       			showInLegend:true
            }
        },
        series: [{
            type: 'pie',
            data: pieData
        }]
    });
}


	/*data=[
     ['Fire',   45.0],
     ['IE',       26.8],
     {
         name: 'Chrome',
         y: 12.8,
         sliced: true,
         selected: true
     },
     ['Safa',    8.5],
     ['Ope',     6.2],
     ['Oth',   0.7]
     ];*/

