<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/user/profile.css">
<link rel="stylesheet" type="text/css" href="css/user/percent.css">

<script src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(function(){
	      //头像
          $('.userIcon img').jqthumb({
              width: 150,
              height: 150,
              after:null
          });
          
          //等级显示
          $(".c1").animate({

			  height: "70%"
	
		  },1000);


      })
</script>
<title>个人资料</title>
</head>
<body>

	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>
	</div>
	<div class="userIcon">
		<div class="icon">
			<img alt="" src="graphics/introduction/image1.jpg"></img>
		</div>
		<div class="r_out">

			<div class="r_in">

			<div class="r_c c1"></div>

			<div class="r_num">Lv4</div>

		</div>
		<p class="userName">congye6</p>


		</div>


	</div>
</body>
</html>