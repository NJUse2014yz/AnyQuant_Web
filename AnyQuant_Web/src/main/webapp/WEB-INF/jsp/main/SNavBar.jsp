<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	    
		<title>小的导航栏</title>
		
		<!-- Bootstrap -->
	    <link href="css/main/bootstrap.min.css" rel="stylesheet">
	    <!-- 导航栏专用 -->
		<link href="css/main/navBar.css" type="text/css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="css/main/navBar-cool.css">
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="js/jquery-3.1.0.min.js"></script>
	</head>
	
	<body>
		<nav class="navbar navbar-fixed-top navbar-inverse">
	    	<div class="container">
				<div class="navbar-header">
		     　			<!-- .navbar-toggle样式用于toggle收缩的内容，即nav-collapse collapse样式所在元素 -->
		       		<button class="navbar-toggle" type="button" data-toggle="collapse"  data-target="#navbar"
                    	aria-expanded="false" aria-controls="navbar">
		         		<span class="sr-only">Toggle Navigation</span>
		         		<span class="icon-bar"></span>
		         		<span class="icon-bar"></span>
		         		<span class="icon-bar"></span>
		       		</button>
		       		<!-- 确保无论是宽屏还是窄屏，navbar-brand都显示 -->
		       		<a href="##" class="navbar-brand"><img src="graphics/main/top.png" id="logo" title="返回首页"></a>
		  		</div>
		  		<div class="collapse navbar-collapse" id="navbar">
		      		<ul class="nav navbar-nav menu">
		     			<li class="active"><a href="##">首页</a></li>
	                	<li class="dropdown">
	                		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="badge pull-right">4</span>学习分区<span class="caret"></span></a>
	                		<ul class="dropdown-menu">
								<li><a href="/AnyQuant_web/stock.action">指标介绍</a></li>
								<li><a href="/AnyQuant_web/stockInfo.action?id=sh000001">工具介绍</a></li>
								<li><a href="/AnyQuant_web/stockInfo.action?id=sz399001">策略学习</a></li>
								<li><a href="/AnyQuant_web/compare.action">讨论区</a></li>
							</ul>
	                	</li>
	                	<li class="dropdown">
	                		<a href="##" class="dropdown-toggle" data-toggle="dropdown"><span class="badge pull-right">5</span>实践分区<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">进出时机</a></li>
								<li><a href="#">股票选择</a></li>
								<li><a href="#">风险控制</a></li>
								<li><a href="#">策略回测</a></li>
								<li><a href="#">策略对比</a></li>
							</ul>
						</li>
						<li class="dropdown">
						<a href="##" class="dropdown-toggle" data-toggle="dropdown"><span class="badge pull-right">4</span>个人空间<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">个人策略</a></li>
								<li><a href="#">收藏策略</a></li>
								<li><a href="/AnyQuant_web/personalStock.action">个人资料</a></li>
								<li><a href="#">消息空间</a></li>
							</ul>
						</li>
		      		</ul>
		      		<ul class="nav navbar-nav navbar-right">
		                <li><a data-toggle="modal" href="#Login">登录</a></li>
		                <li><a data-toggle="modal" href="#Register">注册</a></li>
	                </ul>
				</div><!-- /.nav-collapse -->
	    	</div> <!-- /.container -->
		</nav> <!-- /.navbar -->
	</body>
</html>