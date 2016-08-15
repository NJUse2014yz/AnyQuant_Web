<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述2个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>
    
    <!-- Bootstrap core CSS -->
    <link href="css/main/bootstrap.min.css" rel="stylesheet">
    <!-- 首页 CSS -->
    <link href="css/index.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.min.js"></script>
  </head>
  <body>
  	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>
	</div>
	<img alt="背景图片" src="graphics/main/bg.jpg" class="bg">
	<img alt="背景文字" src="graphics/main/bgw.png" class="bgw">
	<div class="container">
		<div class="row r1">
			<div class="title-r1">
				<img alt="学习分区" src="graphics/main/learn-title.jpg" class="lt">
			</div>
		</div>
		<div class="modules row">
	        <ul>
	            <li class="feature col-6">
	                <span><i class="rqicon">  </i></span>
	                <a href="#" class="js-global-click" data-action="goResearch">
	                    <p class="feature-title">指标介绍</p>
	                    <div class="feature-des">
	                        <p>详细介绍包括macd等多指标在内的多个指标的金融含义</p>
	                        <p>针对指标的数据统计图讲解买入和卖出区间判断方法</p>
	                        <p>灵活的自定义编辑和绘图功能，提供无与伦比的交互式体验</p>
	                    </div>
	                </a>
	            </li>
	            <li class="feature col-6">
	                <span><i class="rqicon"></i></span>
	                <a href="#">
	                    <p class="feature-title">工具介绍</p>
	                    <div class="feature-des">
	                        <p>强大、易用的量化工具，易于编写交易策略</p>
	                        <p>免费提供10年+的日级历史数据以及多项指标的财务数据</p>
	                        <p>极速、精准的回测体验，快速开发和验证投资策略</p>
	                    </div>
	                </a>
	            </li>
	            <li class="feature col-6 feature-short">
	                <span><i class="rqicon"></i></span>
	                <a href="#">
	                    <p class="feature-title">策略学习</p>
	                    <div class="feature-des">
	                        <p>知名的交易策略学习，易于后期编写交易策略</p>
	                        <p>实时数据推送计算</p>
	                        <p>极速、精准的回测体验，快速开发和验证投资策略</p>
	                    </div>
	                </a>
	            </li>
	            <li class="feature col-6 feature-short">
	                <span><i class="rqicon"></i></span>
	                <p class="feature-title">讨论区</p>
	                <div class="feature-des">
	                    <p>对接主流券商接口，交易多种产品、多市场</p>
	                    <p>一键部署即可实盘交易</p>
	                    <p>Java核心交易系统带来极速数据更新和下单体验</p>
	                </div>
	            </li>
	        </ul>
	    </div>
		<div class="row r2">
			<div class="col-md-6">
				<p>这是段落2</p>
			</div>
			<div class="col-md-6">
				<p>这是段落2</p>
			</div>
		</div>
		<div class="row r3">
			<div class="col-md-6">
				<p>这是段落3</p>
			</div>
			<div class="col-md-6">
				<p>这是段落3</p>
			</div>
		</div>
	</div>
    <div class="foot">
		<jsp:include page="/WEB-INF/jsp/main/Foot.jsp"></jsp:include>
	</div>
	
  </body>
</html>
