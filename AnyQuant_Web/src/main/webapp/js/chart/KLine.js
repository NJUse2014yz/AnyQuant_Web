function paintKLine(id, stockId) {
	var ohlc = [], volume = [], m5 = [], //todo
	m10 = [], m30 = [];
	
	// set the allowed units for data grouping
	groupingUnits = [ [ 'week', // unit name
	[ 1 ] // allowed multiples
	], [ 'month', [ 1, 2, 3, 4, 6 ] ] ];
	
	// create the chart
	var chart = new Highcharts.StockChart({
		chart : {
			renderTo : id
		},credits:{
            enabled:false // 禁用版权信息
	       },
		 plotOptions : {
	          candlestick : {
	            color : '#6d9e81',
	            upColor : '#cc5444'
	          }
		 },
		rangeSelector : {
			buttons : [ {
				type : 'month',
				count : 3,
				text : '日k'
			}, {
				type : 'month',
				count : 18,
				text : '周k'
			}, {
				type : 'year',
				count:  9,
				text : '月k'
			} ],
			selected : 0,
			inputEnabled : false
		},

		yAxis : [ {
			labels : {
				align : 'left',
				x : 1
			},
			height : '60%',
			lineWidth : 2
		}, {
			labels : {
				align : 'left',
				x : 1
			},

			top : '65%',
			height : '35%',
			offset : 0,
			lineWidth : 2
		} ],
		

		series : [ {
			type : 'candlestick',
			name : 'AAPL',
			data : ohlc,
			dataGrouping : {
				units : groupingUnits
			}
		}, {
			type : 'column',
			name : 'Volume',
			data : volume,
			yAxis : 1,
			dataGrouping : {
				units : groupingUnits
			}
		}, {
			type : 'spline',
			name : '五日均值',
			data : m5,
			dataGrouping : {
				units : groupingUnits
			}
		}, {
			type : 'spline',
			name : '十日均值',
			data : m10,
			dataGrouping : {
				units : groupingUnits
			}

		}, {
			type : 'spline',
			name : '三十日均值',
			data : m30,
			dataGrouping : {
				units : groupingUnits
			}
		} ]
	});
	
	chart.showLoading("加载中。。。");
	
	//填充数据
	$.getJSON('/AnyQuant_web/getKLineData.action?id=' + stockId,
			function(data) {

				// split the data set into ohlc and volume
				 dataLength = data.length,

				i = 0;

				for (i; i < dataLength; i += 1) {
					var dateUTC=parseInt(getDateUTC(data[i]["date"]));
					
					ohlc.push([ 
					    dateUTC, // the date
					    parseFloat(data[i]["openPrice"]), // open
					    parseFloat(data[i]["highPrice"]), // high
					    parseFloat(data[i]["lowPrice"]), // low
					    parseFloat(data[i]["closePrice"]) // close
					]);

					m5.push([ dateUTC,  parseFloat(data[i]["m5"]) ]);

					m10.push([ dateUTC,  parseFloat(data[i]["m10"]) ]);

					m30.push([ dateUTC,  parseFloat(data[i]["m30"]) ]);

					volume.push([ 
			              dateUTC, // the date
			              parseFloat(data[i]["volume"]) // the volume
					]);
				}

				chart.series[0].setData(ohlc);
				chart.series[1].setData(volume);
				chart.series[2].setData(m5);
				chart.series[3].setData(m10);
				chart.series[4].setData(m30);
				chart.hideLoading();
			});
	
	
}

/**
 * 转换日期utc格式
 * @param date 日期的原始格式 20141205
 * @returns
 */
function getDateUTC(date){
    var dArr = new Array();
    date+="";
    for(var hh=0;hh<3;hh++){
        var numb ;
        if(hh==0){
            numb = Number(date.slice(0,4));
        }
        else {
            numb= Number(date.slice((hh-1)*2+4,hh*2+4));
        };
        dArr.push(numb);
    }
    var dateUTC = Number(Date.UTC(dArr[0],dArr[1],dArr[2],0,0));//得出的UTC时间
    return dateUTC;
}
