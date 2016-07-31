<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>导航栏</title>
	<link href="css/main/navBar.css" type="text/css" rel="stylesheet"/>
	
	<script src="js/cookie.js"></script>
	</head>
	
	<body>
	
		<div class="top">
			<img alt="top" src="graphics/main/top.png">
		</div>
		<div class="container">
			<ul class="menu">
				<li><a href="${pageContext.request.contextPath}/index.action">首页</a></li>
				<li><a href="#">股票数据</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_web/stock.action">全部</a></li>
						<li><a href="/AnyQuant_web/stockInfo.action?id=sh000001">上证指数</a></li>
						<li><a href="/AnyQuant_web/stockInfo.action?id=sz399001">深证成指</a></li>
						<li><a href="/AnyQuant_web/compare.action">股票对比</a></li>
					</ul>
				</li>
				<li class="active"><a href="#s2">学习分区</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_web/analysis.action?id=sh600000">用户讨论区</a></li>
						<li><a href="/AnyQuant_web/strategy.action?id=sh600000">工具方法介绍</a></li>
						<li><a href="#">策略学习</a></li>
					</ul>
				</li>
				<li><a href="#">实践分区</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_web/industry.action">进出时机</a></li>
						<li><a href="/AnyQuant_web/industry.action">股票选择</a></li>
						<li><a href="/AnyQuant_web/industry.action">风险控制</a></li>
						<li><a href="/AnyQuant_web/industry.action">策略对比</a></li>
						<li><a href="/AnyQuant_web/industry.action">策略回测</a></li>
					</ul>
				</li>
				<li><a href="#">个人空间</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_web/personalStock.action">个人资料</a></li>
						<li><a href="#">消息空间</a></li>
						<li><a href="#">个人策略</a></li>
						<li><a href="#">收藏策略</a></li>
					</ul>
				</li>
			</ul>	
		</div>
		
		<div id="login-area">
			<!--未登陆的界面 -->
			<ul class="unlogin">
				<li class="header-signup">
                    <a href="${pageContext.request.contextPath}/askForRegister.action">注册</a>
                </li>	
				<li class="header-signin">
                    <a class="login" href="${pageContext.request.contextPath}/askForLogin.action">登录</a>
                </li>			
			</ul>
			
			<!-- 已登录的界面 -->
			<ul class="logined">
				<li class="header-signup">
                    <a class="logout">注销</a>
                </li>	
				<li id="signined" class="header-signin">
                    <a>已登录</a>
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