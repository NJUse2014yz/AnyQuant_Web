
/**
 * 分时图
 */

var priceChart;

function priceByMinute(){
        // create the chart
        priceChart=Highcharts.StockChart({
        	chart:{
        		renderTo:'price'
        	},

            title: {
                text: 'AAPL stock price by minute'
            },
            xAxis: {
                breaks: [{ // Nights
                    from: Date.UTC(2011, 9, 6, 16),
                    to: Date.UTC(2011, 9, 7, 8),
                    repeat: 24 * 36e5
                }, { // Weekends
                    from: Date.UTC(2011, 9, 7, 16),
                    to: Date.UTC(2011, 9, 10, 8),
                    repeat: 7 * 24 * 36e5
                }]
            },

            rangeSelector : {
                buttons : [{
                    type : 'hour',
                    count : 1,
                    text : '1h'
                }, {
                    type : 'day',
                    count : 1,
                    text : '1D'
                }], 
                selected : 1,
                inputEnabled : false
            },

            series : [{
                name : 'AAPL',
                type: 'area',
                data : [],
                gapSize: 5,
                tooltip: {
                    valueDecimals: 2
                },
                fillColor : {
                    linearGradient : {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops : [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                },
                threshold: null
            }]
        });
        priceChart.showLoading();
        refreshPrice();
}

function getData(){
	$.getJSON('http://www.hcharts.cn/datas/jsonp.php?filename=new-intraday.json&callback=?', function (data) {
		priceChart.series[0].setData(data);
		priceChart.hideLoading();
	})
}


function refreshPrice(){
	// 每隔3秒自动调用方法，实现图表的实时更新
    window.setInterval(getData,3000); 
}