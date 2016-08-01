/**
 * 成交量七天预测
 * @param htmlId
 */
function bar(htmlId) {
    var chart=new Highcharts.Chart({
        chart: {
            type: 'column',
            renderTo:htmlId
        },
        title: {
            text: '成交量未来七天预测'
        },
        xAxis: {
            categories: [
                '第一天',
                '第二天',
                '第三天',
                '第四天',
                '第五天',
                '第六天',
                '第七天'
                
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            
        },
        
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name:"成交量",
            data: null

        }]
    });
    
    return chart;
}

function setBarData(chart,data){
    var barData=[];
    $.each(data,function(i,vo){
    	barData.push(vo["volumn"]);
    });
    chart.series[0].setData(barData);
}


