<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>大型导航栏</title>
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="css/main/navBar-cool.css">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="js/jquery-3.1.0.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<div class="top">
			<img alt="top" src="graphics/main/top.png">
		</div>
		<div class="contain">
			<ul class="menu">
				<li id="home"><a href="/index.action">首页</a></li>
				<li class="active"><a href="#s2">学习分区</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_web/stock.action">指标介绍</a></li>
						<li><a href="/AnyQuant_web/stockInfo.action?id=sh000001">工具介绍</a></li>
						<li><a href="/AnyQuant_web/stockInfo.action?id=sz399001">策略学习</a></li>
						<li><a href="/AnyQuant_web/compare.action">讨论区</a></li>
					</ul>
				</li>
				<li><a href="#">实践分区</a>
					<ul class="submenu">
						<li><a href="#">进出时机</a></li>
						<li><a href="#">股票选择</a></li>
						<li><a href="#">风险控制</a></li>
						<li><a href="#">策略回测</a></li>
						<li><a href="#">策略对比</a></li>
					</ul>
				</li>
				<li><a href="#">个人空间</a>
					<ul class="submenu">
						<li><a href="#">个人策略</a></li>
						<li><a href="#">收藏策略</a></li>
						<li><a href="/AnyQuant_web/personalStock.action">个人资料</a></li>
						<li><a href="#">消息空间</a></li>
					</ul>
				</li>
			</ul>	
		</div>
		
		<div id="login-area">
			<!--未登陆的界面 -->
			<ul class="unlogin">
				<li class="header-signup">
                    <a href="/askForRegister.action">注册</a>
                </li>	
				<li class="header-signin">
                    <a class="login" href="/askForLogin.action">登录</a>
                </li>			
			</ul>
		</div>
	</body>
</html>