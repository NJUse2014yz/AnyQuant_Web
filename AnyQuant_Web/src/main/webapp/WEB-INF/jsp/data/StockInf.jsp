<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/main/main.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/stock/card.css">
<link rel="stylesheet" type="text/css" href="css/stock/head.css">
<link rel="stylesheet" type="text/css" href="css/stock/chart.css">
<link rel="stylesheet" type="text/css" href="css/stock/StockInf.css">
<link rel="stylesheet" type="text/css" href="css/stock/searchComponent/default.css" />
<link rel="stylesheet" type="text/css" href="css/stock/searchComponent/component.css" />
<link rel="stylesheet" type="text/css" href="css/tool/poshytip.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link type="text/css" rel="stylesheet" href="css/tool/starRaty/application.css">
<link rel="stylesheet" type="text/css" href="css/user/button3d.css">
<style type="text/css">
	
	.bordered td:hover{
		background: #fbf8e9;
	    -o-transition: all 0.1s ease-in-out;
	    -webkit-transition: all 0.1s ease-in-out;
	    -moz-transition: all 0.1s ease-in-out;
	    -ms-transition: all 0.1s ease-in-out;
	    transition: all 0.1s ease-in-out; 
	
	}
</style>

<script src="js/jquery-1.12.3.js"></script>
<script type="text/javascript" src="js/tool/starRaty/jquery.raty.js"></script>
<script src="js/tool/jquery.poshytip.js"></script>
<script src="js/searchComponent/modernizr.custom.js"></script>
<script src="js/chart/KLine.js"></script>
<script src="js/chart/Line.js"></script>
<script src="js/chart/bar.js"></script>
<script src="js/Highstock-4.2.5/js/highstock.js"></script>
<script src="js/cookie.js"></script>

<script type="text/javascript">
$(function(){
	
	$('.likeImage').poshytip({
		className: 'tip-yellow', 
	    showOn: 'hover', 
	    alignTo: 'target', 
	    alignX: 'center', 
	    alignY: 'bottom', 
	    hideTimeout:1,
	    offsetX: 5,
	    offsetY:-4,
	    content:'收藏'
	});
	
	$('.strategyImage').poshytip({
		className: 'tip-yellow', 
	    showOn: 'hover', 
	    alignTo: 'target', 
	    alignX: 'right', 
	    alignY: 'center', 
	    hideTimeout:1,
	    offsetX: 0,
	    offsetY:-4,
	    content:'查看策略'
	});
})

</script>
<style type="text/css">

.background {
	position: fixed;
	top: 0%;
	left: 0px;
	background-color:rgb(231,235,238);
	height: 100%;
	width: 100%;
	z-index: -10;
}
</style>
<title>单只股票信息</title>
</head>
<body>
	
	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/navBar.jsp"></jsp:include>
	</div>


	
	<div class="background"></div>

	<!-- stocktitle -->
	<div class="stockHead">
		<h1 class="companyName">${latestInfo.name}</h1>
		<img class="likeImage" onclick='likeStock()' src="graphics/data/like.png"></img>
		<img class="strategyImage" onclick='strategy()' src="graphics/data/strategy.gif"></img>
		<div class="pairStock">对冲股票:</div>
		<div class="orange button pairStockName" onclick=""></div>
	</div>


	<!-- search -->
		<c:if test="${isStock=='true'}">
		<div class="column">
			<div id="sb-search" class="sb-search sb-search-open">
				<form>
					<input class="sb-search-input" placeholder="请输入股票代码" type="text" value="" name="search" id="search">
					<input class="sb-search-submit"  value="">
					<span class="sb-icon-search"></span>
				</form>
			</div>
		</div>
		</c:if>
		

	<!-- cards -->
	<div class="card pinkCard">
		<img class="card" alt="rmb" src="graphics/data/rmb.gif"> <small>开盘价</small>
		<h2></h2>

	</div>

	<div class="card greenCard">
		<img class="card" alt="down" src="graphics/data/down.gif"> <small>涨跌幅</small>
		<h2>${latestInfo.incrPer}%</h2>
	</div>

	<div class="card blueCard">
		<img class="card" alt="trade" src="graphics/data/trade.gif"> <small>换手率</small>
		<h2></h2>
<!-- 		<h2> --</h2> -->
	
	</div>

	<div class="card grayCard">
		<img class="card" alt="profit" src="graphics/data/profit.gif"><small>RSI</small>
		<h2 id="rsih2"></h2>
	</div>

	<div class="card orangeCard">
		<img class="card" alt="value" src="graphics/data/rmb.gif"><small>收盘价</small>
		<h2></h2>
	</div>
	<!-- cards -->
	
	<!-- news -->
<!-- 	<div style="position:absolute;width:1200px;left:80px;top:1600px;"> -->
<!-- 		<table id="newsList" border="1" class="bordered"> -->
			
<!-- 			<tr> -->
<!-- 				<th colspan="3">个股新闻</th> -->
<!-- 			</tr> -->
			
<%-- 			<% --%>
// 				int tdCount=0;
// 				request.setAttribute("tdCount",tdCount);
<%-- 			%> --%>
<%-- 			<c:forEach var="stockNews" items="${news}"> --%>
<%-- 				<% --%>
// 				 	tdCount++;
// 					request.setAttribute("tdCount",tdCount);
<%-- 				%> --%>
<%-- 				<c:if test="${tdCount==1}"> --%>
<!-- 					<tr> -->
<%-- 				</c:if> --%>
<%-- 					<td onclick="getNews('${stockNews.url}')">${stockNews.title}</td> --%>
<%-- 				<c:if test="${tdCount==3 }"> --%>
<!-- 					</tr> -->
<%-- 					<% --%>
// 						tdCount=0;
<%-- 					%> --%>
<%-- 				</c:if> --%>
			
<%-- 			</c:forEach> --%>
			
			
<!-- 		</table> -->
<!-- 	</div> -->
	<!-- news -->
	
	
	<div class="footer">
		<jsp:include page="/WEB-INF/jsp/main/foot.jsp"></jsp:include>
	</div>

	<!-- kline -->
	<div  class="chart kLineContainer">
		<div id="chart" class="kLine"></div>
	</div>
	<!-- kline -->
	<c:if test="${isStock=='true'}">
		<div class="chart futurePrice">
			<div id="futurePrice" class="smallChart"></div>
		</div>
		<div class="chart futureVolume">
			<div id="futureVolume" class="smallChart"></div>
		</div>
		<div class="chart futureTrade">
			<div id="futureTrade" class="smallChart"></div>
		</div>
	</c:if>
	
	<div  class="chart bias">
		<div id="bias" class="smallChart"></div>
	</div>
	<div class="chart vr">
		<div id="vr" class="smallChart"></div>
	</div>
	<div class="chart rsv">
		<div id="rsv" class="smallChart"></div>
	</div>
	<div class="chart macd">
		<div id="macd" class="smallChart"></div>
	</div>
	<div class="chart roc">
		<div id="roc" class="smallChart"></div>
	</div>
	<div class="chart obv">
		<div id="obv" class="smallChart"></div>
	</div>
	<!-- kdj -->
	<div  class="chart kdj">
		<div id="kdj" class="smallChart"></div>
	</div>
	<!-- kdj -->
	<!--rsi-->
	<div  class="chart rsi">
		<div id="rsi" class="smallChart"></div>
	</div>
	<!--rsi-->
	
	<div  class="chart boll">
		<div id="boll" class="smallChart"></div>
	</div>
	<script>
		var chartData=[];
		var pairId;
		
		
		$(function () {
		    pairStock();
		    card();
		    paintKLine('chart','${latestInfo.stockId}');
		    paintLineChart();
		    paintForecast();
		    
		});
		
		//对冲股票
		function pairStock(){
		   	$(".pairStockName").hide();
		   	if('${isStock}'!='true'){
		   	    $(".pairStock").hide();
		   	    return;
		   	}
		    $.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/getPairStock.action',
				data:'id=${latestInfo.stockId}',
				success:function(data){
				    if(data.length==0)
						return;
				    $(".pairStockName").show();
				    $(".pairStockName").text(data.sname);
					pairId=data.sid;
				    $(".pairStockName").attr("onclick","searchStock()");
				}
		    });
		}
		
		function searchStock(){
		    window.location.href="/AnyQuant_web/stockInfo.action?id="+pairId;
		}
		
		function card(){
		  //过大的数字省去小数位
		    if(parseInt("${latestInfo.open}")>1000){
				$(".pinkCard h2").text(parseInt("${latestInfo.open}"));
				$(".orangeCard h2").text(parseInt("${latestInfo.close}"));
		    }else{
				$(".pinkCard h2").text("${latestInfo.open}");
				$(".orangeCard h2").text("${latestInfo.close}");
		    }
			
		    if(parseInt("${latestInfo.turnover}")<0){
				$(".blueCard h2").text("--");
		    }else{
				$(".blueCard h2").text("${latestInfo.turnover}"+"%");
		    }
		}
		
		//预测统计图
		function paintForecast(){
		    $(".futureVolume").hide();
			$(".futurePrice").hide();
			$(".futureTrade").hide();
		    var barChart=bar('futureVolume');
		    $.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/getForecast.action',
				data:'id=${latestInfo.stockId}',
				success:function(data){
				    if(data.length==0){
						return;
				    }
				    $(".futureVolume").show();
					$(".futurePrice").show();
					$(".futureTrade").show();
				    setBarData(barChart,data);
				    lineChart2(data, "futurePrice", ["open","close"], ['开盘价','收盘价'], "未来七天股价预测");
					lineChart2(data, "futureTrade", ["turnover"], ["换手率"], "未来七天换手率预测");
				}
		    });
			
		}
		
		//折线图
		function paintLineChart(){
			var dateName="date";
			
			var rsi=["rsi5","rsi10","rsi20"];
			var rsiName=["五日相对强弱指标","十日相对强弱指标","二十日相对强弱指标"];
			
			var boll=["boll1","boll2","boll3"];
			var bollName=["布林线1","布林线2","布林线3"];
			
			var bias=["bias5","bias10","bias20"];
			var biasName=["五日乖离率","十日乖离率","二十日乖离率"];
			
			var vr=["vr"];
			var vrName=["成交量变异率"];
			
			var rsv=["rsv"];
			var rsvName=["未成熟随机值"];
			
			var kdj=["k","d","j"];
			
			var macd=["macd","diff","dea"];
			
			var obv=["obv"];
			var obvName=["能量潮"];
			
			var roc=["roc12","roc25"];
			var rocName=["12日roc","25日roc"];
			
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/getLineData.action',
				data:'id=${latestInfo.stockId}',
				success:function(data){
				    
				    $("h2#rsih2").text(data[data.length-1]["rsi"]);
				    
					var rsiSeries=createDataSeries(data, dateName, rsi, rsiName,"");
					lineChart("rsi",rsiSeries,"相对强弱指标");
					
					var bollSeries=createDataSeries(data, dateName, boll, bollName,"true");
					lineChart("boll",bollSeries,"布林线");
					
					var biasSeries=createDataSeries(data, dateName, bias, biasName);
					lineChart("bias",biasSeries,"乖离率");
					
					var vrSeries=createDataSeries(data, dateName,vr, vrName);
					lineChart("vr", vrSeries, "成交量变异率");
					
					var rsvSeries=createDataSeries(data, dateName, rsv,rsvName);
					lineChart("rsv", rsvSeries, "未成熟随机值");
					
					var kdjSeries=createDataSeries(data, dateName, kdj, kdj);
					lineChart("kdj", kdjSeries, "随机指标");
					
					var macdSeries=createDataSeries(data, dateName, macd, macd);
					lineChart("macd", macdSeries, "指数平滑曲线");
					
					var obvSeries=createDataSeries(data, dateName, obv, obvName);
					lineChart("obv", obvSeries, "能量潮");
					
					var rocSeries=createDataSeries(data, dateName, roc, rocName);
					lineChart("roc", rocSeries, "变动速率指标");
				}
			});
		}
		
		//监听对比按钮
		$('.sb-search-submit').click(function(){
			var input=$('.sb-search-input').val();//获得输入
			if(input=="${latestInfo.stockId}"){
				alert("同一支股票不能对比");
				return;
			}
				
			//验证id是否存在，id存在则跳转到对比页面
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/searchStock.action',
				data:'key='+input,
				success:function(data){
					//找不到唯一的股票则返回
					if(data.length!=1){
						alert("找不到股票");
						return;
					}
					
					//跳转到对比
					window.location.href=
	"${pageContext.request.contextPath}/compare.action?id1=${latestInfo.stockId}&id2="+input;
				}
			});
			
		});
		
		function getNews(url){
			window.location.href=url;
		}
		
		//查看策略
		function strategy(){
			window.location.href="${pageContext.request.contextPath}/analysis.action?id=${latestInfo.stockId}";
		}
		
		//收藏股票
		function likeStock(){
			var src;
			var isLikeCookie=getCookie('isLike');
			var like;
			if(isLikeCookie=='true'){
				like=false;
				src='graphics/data/unlike.png';
			}
			if(isLikeCookie=='false'){
				like=true;
				src='graphics/data/like.png';
			}
			var userName=getCookie("userName");
			var password=getCookie("password");
			
			//保存数据
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/likeStock.action',//TODO 添加controller
				data:'isLike='+like+'&userName='+userName+'&password='+password,
				success:function(data){
					$(".likeImage").attr('src',src);
				}
			});
		}
	</script>
<!-- 	<script src="js/searchComponent/classie.js"></script> -->
<!-- 	<script src="js/searchComponent/uisearch.js"></script> -->
<!-- 	<script> -->
// 		new UISearch( document.getElementById( 'sb-search' ) );
<!-- 	</script>  -->
</body>
</html>
