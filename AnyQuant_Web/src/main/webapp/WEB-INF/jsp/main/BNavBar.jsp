<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>大型导航栏</title>
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 768px)" href="css/main/navBar-cool.css">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- 	    <script src="js/jquery-3.1.0.min.js"></script> -->
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
		<script src="js/cookie.js"></script>
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
						<li><a href="#">指标介绍</a></li>
						<li><a href="#">工具介绍</a></li>
						<li><a href="#">策略学习</a></li>
						<li><a href="#">讨论区</a></li>
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
						<li><a href="#">个人资料</a></li>
						<li><a href="#">消息空间</a></li>
					</ul>
				</li>
			</ul>	
		</div>
		
		<div id="login-area">
		
		
			<!-- 已登录的界面 -->
			<ul class="logined">
				<li class="header-signup">
                    <a class="logout">注销</a>
                </li>	
				<li id="signined" class="header-signin">
                    <a>已登录</a>
                </li>	
			
			</ul>
			<!--未登陆的界面 -->
			<ul class="unlogin">
				<li class="header-signup">
                    <a href="/AnyQuant_Web/askForLogin.action">注册</a>
                </li>	
				<li class="header-signin">
                    <a class="login" href="/AnyQuant_Web/askForLogin.action">登录</a>
                </li>			
			</ul>
			
			
		</div>
		
		
		<script type="text/javascript">
			$(function(){
				showUserInfo();
			});
			//判断是否已经登录
			function showUserInfo(){
				var userName=getCookie("userName");

				if(userName!='""'){
					$("ul.unlogin").hide();
					$("ul.logined").show();
					$("#signined a").text(userName);
				}
				else{
					$("ul.logined").hide();
					$("ul.unlogin").show();
				}
					
			}
			//注销
			$(".logout").click(function(){
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/logout.action',
					data:'',
					success:function(data){
						showUserInfo();
					}
				});
			});
		</script>
	</body>
</html>