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
		<div class="row r2">
			<div class="col-md-3">
				<p>这是段落2</p>
			</div>
			<div class="col-md-9">
				<p>这是段落2</p>
			</div>
		</div>
		<div class="row r3">
			<div class="col-md-4">
				<p>这是段落3</p>
			</div>
		</div>
		<div class="row r4" >
			<div class="col-md-8">
				<p>这是段落4</p>
			</div>
		</div>
		<h1>你好世界</h1>
	</div>
    <div class="foot">
		<jsp:include page="/WEB-INF/jsp/main/Foot.jsp"></jsp:include>
	</div>
	
  </body>
</html>
