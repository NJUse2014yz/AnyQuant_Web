<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
  <head>
    <title>导航栏</title>
   	<style type="text/css">
    	.s-head{
    		display:none;
    	}
    </style>
    <script type="text/javascript">
	    window.onload=function(){  
	    	changeDivWidth();  
       	}  
	    //当浏览器窗口大小改变时，设置宽度  
	   	window.onresize=function(){  
       		changeDivWidth();  
       	}  	
	   	function changeDivWidth(){
			var width=$(window).width();
			if(width>768){
				$(".s-head").hide();
				
				$(".b-head").show();
			}else{
				$(".b-head").hide();
				$(".s-head").show();
			}
    	}
	</script>
  </head>
  <body>
  	<div class="s-head">
		<jsp:include page="/WEB-INF/jsp/main/SNavBar.jsp"></jsp:include>
	</div>
    <div class="b-head">
		<jsp:include page="/WEB-INF/jsp/main/BNavBar.jsp"></jsp:include>
	</div>
  </body>
</html>