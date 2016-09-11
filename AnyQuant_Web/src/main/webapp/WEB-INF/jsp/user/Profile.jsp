<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/user/profile.css">
<link href="css/user/cropper.css" rel="stylesheet">
<link href="css/user/sitelogo.css" rel="stylesheet">
<link href="css/main/bootstrap.min.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">

<script src="js/jquery-3.1.0.min.js"></script>
<script src="js/user/jquery.carouFredSel-6.0.4-packed.js"></script>
<script src="js/user/cropper.min.js"></script>
<script src="js/user/sitelogo.js"></script>
<script src="js/tool/table.js"></script>

<script type="text/javascript">
	$(function(){
	      
          
          //等级显示
          $(".c1").animate({

			  height: "70%"
	
		  },1000);
          
          //tabs
          $('#tabs').carouFredSel({
			circular: false,
			items: 1,
			width: '100%',
			auto: false,
			pagination: {
				container: '#pager',
				anchorBuilder: function( nr ) {
					return '<a href="#">' + $(this).find('h3').text() + '</a>';
				}
			}
		});
		$('#tabs h3').hide();

		
		//设置用户头像和用户名
		var userName=getCookie("userName");
		$("p.userName").text(userName);
		$(".userIcon img").attr("src","graphics/user/icon/"+userName+".jpg");
		
		//头像
         $('.userIcon img').jqthumb({
             width: 150,
             height: 150,
             after:null
         });

      })
</script>
<title>个人资料</title>
</head>
<body>

	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>
	</div>
	
	<div class="userIcon">
		<div class="row">
			<div id="crop-avatar" class="col-md-6">
				<div class="avatar-view" title="Change Logo Picture">
			    	<img  alt="Logo">
			    </div>
			</div>
		</div>
		
		
	

	<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
		
		<p class="userName"></p>
		
	</div>
	
	
	<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form class="avatar-form" action="/AnyQuant_Web/uploadIcon.action" enctype="multipart/form-data" method="post">
					<div class="modal-header" style="width:898px">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title" id="avatar-modal-label">Change Logo Picture</h4>
					</div>
					<div class="modal-body">
						<div class="avatar-body">
							<div class="avatar-upload">
								<input class="avatar-src" name="avatar_src" type="hidden">
								<input class="avatar-data" name="avatar_data" type="hidden">
								<label for="avatarInput">图片上传</label>
								<input class="avatar-input" id="avatarInput" name="avatar_file" type="file"></div>
							<div class="row" style="width:868px">
								<div class="col-md-9">
									<div class="avatar-wrapper"></div>
								</div>
								<div class="col-md-3">
									<div class="avatar-preview preview-lg"></div>
									<div class="avatar-preview preview-md"></div>
									<div class="avatar-preview preview-sm"></div>
								</div>
							</div>
							<div class="row avatar-btns" style="width:868px">
								<div class="col-md-9">
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>
									</div>
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>
									</div>
								</div>
								<div class="col-md-3">
									<button class="btn btn-success btn-block avatar-save" type="submit"><i class="fa fa-save"></i> 保存修改</button>
								</div>
							</div>
						</div>
					</div>
	  		</form>
	  	</div>
	  </div>
	  </div>
	
	<div id="wrapper">
		<div id="pager"></div>
		<div id="tabs">
			<div id="blue">
				<h3>我的策略</h3>
				<div class="component">
					<table border="1" class="bordered">
						
							<tr>
								<th>Name</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Mobile</th>
							</tr>
						
						
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
							
							<tr>
								<td class="user-name">gary coleman</td>
								<td class="user-email">gary.coleman21@example.com</td>
								<td class="user-phone">(398)-332-5385</td>
								<td class="user-mobile">(888)-677-3719</td>
							</tr>
							<tr>
								<td class="user-name">rose parker</td>
								<td class="user-email">rose.parker16@example.com</td>
								<td class="user-phone">(293)-873-2247</td>
								<td class="user-mobile">(216)-889-4933</td>
							</tr>
						

					</table>

				</div>




			</div>
			<div id="pink">
				<h3>收藏策略</h3>
			</div>
			<div id="white">
				<h3>收藏股票</h3>
				<table id="stockList" border="1" class="bordered">
					<tr>
						<th>id</th>
						<th>开盘价</th>
						<th>收盘价</th>
						<th>涨跌额</th>
						<th>涨跌幅</th>
						<th>最低价</th>
						<th>最高价</th>
						<th>成交量</th>
						<th>成交额</th>
						<th>换手率</th>
					</tr>
					
				</table>
			</div>
		</div>
	</div>
	
	
	
	
	
	
</body>
</html>