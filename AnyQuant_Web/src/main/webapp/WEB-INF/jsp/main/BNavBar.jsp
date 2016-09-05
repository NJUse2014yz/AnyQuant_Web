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
		<script src="js/user/userIcon.js"></script>
		<script type="text/javascript">
			$(function(){
	            $('.logined img').jqthumb({
	                width: 30,
	                height: 30,
	                after: function(imgObj){
	                   imgObj.css('opacity', 0).animate({opacity: 1},1000);
	                 }
	            });
	        })
        </script>
	</head>
	
	<body>
		<div class="top">
			<img alt="top" src="graphics/main/top.png">
		</div>
		<div class="contain">
			<ul class="menu">
				<li id="home"><a href="/AnyQuant_Web/">首页</a></li>
				<li class="active"><a href="#s2">学习分区</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_Web/quotaIntroduction.action">指标介绍</a></li>
						<li><a href="/AnyQuant_Web/functionIntroduction.action">工具介绍</a></li>
						<li><a href="/AnyQuant_Web/strategyIntroduction.action">策略学习</a></li>
					</ul>
				</li>
				<li><a href="#">实践分区</a>
					<ul class="submenu">
						<li><a href="/AnyQuant_Web/addStrategy.action">新建策略</a></li>
						<li><a href="/AnyQuant_Web/myStrategy.action">个人策略</a></li>
						<li><a href="/AnyQuant_Web/publicStrategy.action">策略社区</a></li>
						<li><a href="/AnyQuant_Web/strategyCompare.action">策略对比</a></li>
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
			<div class="logined">
				<img src="graphics/introduction/image1.jpg" style="width:30px;height:30px"></img>	
			
			</div>
		
			
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
					$(".logined").show();
					$("#signined a").text(userName);
				}
				else{
					$(".logined").hide();
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