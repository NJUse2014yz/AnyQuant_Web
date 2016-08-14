<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="css/user/login.css">
<link rel="stylesheet" href="css/user/loginIconFont.css">
<script src="js/jquery-3.1.0.js"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>

	

	<div class="login-banner"></div>

	<div class="login-box">

		<div class="box-con tran">

			<div class="login-con f-l">

				<div class="form-group">

					<input id="userName" type="text" placeholder="用户名" required/>

					<span class="error-notic">用户名不存在</span>

				</div>

				<div class="form-group">

					<input id="password" type="password" placeholder="密码" required/>

					<span class="error-notic">密码不正确</span>

				</div>

				<div class="form-group">

					<button type="submit" class="tran pr">

						<a id="login" class="tran">登录</a>

						<img class="loading" src="images/loading.gif" style="display:block">

					</button>

				</div>

				<div class="from-line"></div>

				<div class="form-group">

					<a href="javascript:;" class="move-signup a-tag tran blue-border">还没有帐号？免费注册<i class="iconfont tran">&#xe606;</i></a>

				</div>

				<div class="form-group">

					<a href="/AnyQuant_Web" class="move-reset a-tag tran">游客登录<i class="iconfont tran">&#xe606;</i></a>

				</div>

			</div>

			<!-- 登录 -->



			<div class="signup f-l">

				<div class="form-group">

					<div class="signup-form">

						<input id="signupUserName" type="text" placeholder="用户名" class="email-mobile" onblur="verify.verifyEmail(this)">


					</div>

					<span class="error-notic">用户名已存在</span>

				</div>

				<div class="signup-email">



					<div class="form-group">

						<input id="signupPassword" type="password" placeholder="密码（字母、数字，至少6位）" onblur="verify.PasswordLenght(this)">

						<span class="error-notic">密码长度不够</span>

					</div>

					<div class="form-group">

						<button type="submit" class="tran pr">

							<a id="signup" class="tran">注册</a>

							<img class="loading" src="images/loading.gif">

						</button>

					</div>

				</div><!-- 邮箱注册 -->

				

				<div class="from-line"></div>

				<div class="form-group">

					<a href="javascript:;" class="move-login a-tag tran blue-border">已有帐号？登录<i class="iconfont tran">&#xe606;</i></a>

				</div>

				<div class="form-group">

					<a href="/AnyQuant_Web" class="move-reset a-tag tran">游客登录<i class="iconfont tran">&#xe606;</i></a>

				</div>

			</div>

			<!-- 注册 -->

	</div>

	<script>
		
		function verifyPassword(){
		    var userName=$("#userName").val();
		    var password=$("#password").val();
		    $.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/verifyPassword.action',
				data:'userName='+userName+'&password='+password,
				success:function(isValid){
				    if(!isValid){
						showNotic("#password");
						return;
				    }
				    hideNotic("#password");
				 	 //登录
					window.location.href="${pageContext.request.contextPath}/login.action?userName="+
						userName+"&password="+password;
				}
		    });
		}
	
		var _handle='';//储存电话是否填写正确

		$(function(){

		    //登录按钮
		    $("a#login").on("click",function(){
				var userName=$("#userName").val();
				var password=$("#password").val();
				
				if(userName==null||password==null)
				    return;
				//先验证用户名是否存在
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/isUserNameExists.action',
					data:'userName='+userName,
					success:function(isExists){
					    if(!isExists){
							showNotic("#userName");
							return;
					    }
					    else
							hideNotic("#userName");
						//验证密码是否正确
						verifyPassword();
						
						
					}
				
		    	});
			 });
		    
		    
		    var isValidUserName=false;
		    //注册按钮
		    $("#signup").on("click",function(){
			 var userName=$("#signupUserName").val();
				var password=$("#signupPassword").val();
				//先验证用户名是否存在
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/isUserNameExists.action',
					data:'userName='+userName,
					success:function(isExists){
					    if(isExists){
							showNotic("#signupUserName");
							isValidUserName=false;
							return;
					    }
					    isValidUserName=true;
						hideNotic("#signupUserName");
						window.location.href="${pageContext.request.contextPath}/register.action?userName="
							+userName+"&password="+password;
					}
				});
				
				
			
		    });
		    
		    
			$(".signup-form input").on("focus",function(){

				$(this).parent().addClass("border");

			});

			$(".signup-form input").on("blur",function(){

				$(this).parent().removeClass("border");

			})

			//注册方式切换

			$(".signup-select").on("click",function(){

				var _text=$(this).text();

				var $_input=$(this).prev();

				$_input.val('');

				

				if(_text=="邮箱注册"){

					$(".signup-tel").fadeOut(180);

					$(".signup-email").fadeIn(200);

					$(this).text("手机注册");

					$_input.attr("placeholder","邮箱");

					$_input.attr("onblur","verify.verifyEmail(this)");

					$(this).parents(".form-group").find(".error-notic").text("邮箱格式不正确")

				}

			});

			//步骤切换

			var _boxCon=$(".box-con");

			$(".move-login").on("click",function(){

				$(_boxCon).css({

					'marginLeft':0

				})

			});

			$(".move-signup").on("click",function(){

				$(_boxCon).css({

					'marginLeft':-320

				})

			});

			$(".move-other").on("click",function(){

				$(_boxCon).css({

					'marginLeft':-640

				})

			});

			$(".move-reset").on("click",function(){

				$(_boxCon).css({

					'marginLeft':-960

				})

			});

			$("body").on("click",".move-addinf",function(){

				$(_boxCon).css({

					'marginLeft':-1280

				})

			});



			

		});

		

		//表单验证

		function showNotic(_this){

			$(_this).parents(".form-group").find(".error-notic").fadeIn(100);

            

		}//错误提示显示

		function hideNotic(_this){

			$(_this).parents(".form-group").find(".error-notic").fadeOut(100);

		}//错误提示隐藏

		var verify={

			

			

			PasswordLenght:function(_this){

				var _length=$(_this).val().length;

				if(_length<6){

					showNotic(_this)

				}else{

            		hideNotic(_this)

            	}

			},//验证设置密码长度

			

		}

	</script>


</body>
</html>