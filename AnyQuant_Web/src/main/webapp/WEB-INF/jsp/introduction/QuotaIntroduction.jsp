<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/introduction/introduction.css">
<link href="css/index.css" rel="stylesheet">

<script src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>指标介绍</title>
</head>
<body>

	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>
	</div>
	
	<div class="mainContainer">
		
	</div>
	
	<script type="text/javascript">
		var quotas=["rsi","obv","kdj","vr","rsi","obv","macd","rsv"];
		$(function(){
		    var before="<div class='box corner'><h1 onclick='detail(this)'>";
		    var after="</h1></div>";
		    $.each(quotas,function(i,quota){
				$("div.mainContainer").append(before+quota+after);
		    });
		    
		});
		
		function detail(dom){
		    window.location.href=$(dom).text();
		}
		
	
	
	</script>
	
</body>
</html>