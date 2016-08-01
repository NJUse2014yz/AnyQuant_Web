function lineChart(htmlId,series,title) {
	var chart=new Highcharts.Chart({
		
		title: {
            text: title,
            x: -20 //center
        },
        chart:{
        	type:"spline",
        	renderTo : htmlId
        },
        credits:{
            enabled:false // 禁用版权信息
       },
       
        xAxis:{
//        	labels:{
//        		enabled:false
//        	}
	       type: 'datetime',
	       dateTimeLabelFormats: { // don't display the dummy year
	           month: '%b %e'
	       }
        },
        plotOptions: {
        	spline:{
        		marker:{
        			enabled:true,
        			radius:3
        		}
        	}
        },
        yAxis: {
        	title:{
        		text:null
        	},
        	gridLineWidth :0//在图上没有纵轴间隔线
        },
        legend: {
            layout: 'horizontal',
            align: 'center',
            verticalAlign: 'bottom',
            borderWidth: 0
        },
        series: series
  });
	return chart;
}

function lineChart2(data,htmlId,valueNames,seriesNames,title) {
    var chart = new Highcharts.Chart({

	title : {
	    text : title,
	    x : -20
	// center
	},
	chart : {
	    type : "spline",
	    renderTo : htmlId
	},
	credits : {
	    enabled : false
	// 禁用版权信息
	},

	xAxis : {
	    categories : [ '第一天', '第二天', '第三天', '第四天', '第五天', '第六天', '第七天']
	},
	plotOptions : {
	    spline : {
		marker : {
		    enabled : true,
		    radius : 3
		}
	    }
	},
	yAxis : {
	    title : {
		text : null
	    },
	    gridLineWidth : 0
	// 在图上没有纵轴间隔线
	},
	legend : {
	    layout : 'horizontal',
	    align : 'center',
	    verticalAlign : 'bottom',
	    borderWidth : 0
	},
	series : createDataSeries2(data, valueNames, seriesNames)
    });
    return chart;
}

/**
 * 根据属性名从data中取出数据放到series中
 * 
 * @param data
 *                数据
 * @param dateName
 *                日期属性名
 * @param valueNames
 *                值属性名
 * @param seriesNames
 *                各个series名
 * @returns {Array}
 */
function createDataSeries(data,dateName,valueNames,seriesNames){
	var series=[];
	var seriesNum=valueNames.length;//有多少个series
	for(var i=0;i<seriesNum;i++){
		var seriesData=[];
		//根据属性名取出数据
		$.each(data,function(j,vo){
			var dateUTC=getDateUTC(vo[dateName]);
			seriesData.push([dateUTC,vo[valueNames[i]]]);
		});
		series.push({
			name:seriesNames[i],
			data:seriesData
		});
	}
	return series;
}

function createDataSeries2(data,valueNames,seriesNames){
	var series=[];
	var seriesNum=valueNames.length;//有多少个series
	for(var i=0;i<seriesNum;i++){
		var seriesData=[];
		//根据属性名取出数据
		$.each(data,function(j,vo){
		    seriesData.push(vo[valueNames[i]]);
		});
		series.push({
			name:seriesNames[i],
			data:seriesData
		});
	}
	return series;
}

/**
 * 转换日期utc格式
 * @param date 日期的原始格式 20141205
 * @returns
 */
function getDateUTC(date){
    
    date+="";
    
    var year = Number(date.slice(0,4));
   
    var month=Number(date.slice(4,6))-1;
   
    var day = Number(date.slice(6,8));
    
    var dateUTC = Date.UTC(year,month,day,0,0);//得出的UTC时间
    return dateUTC;
}