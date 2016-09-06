<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述2个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>新建策略</title>
    <!-- Bootstrap core CSS -->
    <link href="css/main/bootstrap.min.css" rel="stylesheet">
    <!-- 全局配置 CSS -->
    <link href="css/reset.css" rel="stylesheet">
	<link href="css/strategy/styles.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.min.js"></script>
    
</head>
<body>
	<div class="head">
		<jsp:include page="/WEB-INF/jsp/main/NavBar.jsp"></jsp:include>
	</div>
	<div class="content">
	    <article class="htmleaf-content">
	        <!-- multistep form -->
	        <div id="msform">
	            <!-- progressbar -->
	            <ul id="progressbar">
	                <li class="active">股票选择</li>
	                <li>进出时机</li>
	                <li>风险控制</li>
	                <li>回测实测</li>
					<li>完成</li>
	            </ul>
	            <!-- fieldsets -->
	            <fieldset>
	                <h2 class="fs-title">一个良好的策略从精准选股开始</h2>
	                <h3 class="fs-subtitle">搜索 对冲 地区 概念 行业 属性 组合</h3>
	                <div class="choose-stocks">
	                	<h3>已选股票</h3>
	                	<table></table>
	                </div>
	                <input type="text" name="email" placeholder="Email地址" />
	                <input type="password" name="pass" placeholder="密码" />
	                <input type="password" name="cpass" placeholder="重复密码" />
	                <input type="button" name="next" class="next action-button" value="Next" />
	                <input type="button"  class="add" value="添加条件" />
	            </fieldset>
	            <fieldset>
	                <h2 class="fs-title">填写社交账号</h2>
	                <h3 class="fs-subtitle">填写你的常用社交网络账号</h3>
	                <input type="text" name="x-weibo" placeholder="新浪微博" />
	                <input type="text" name="t-weibo" placeholder="腾讯微博" />
	                <input type="text" name="qq" placeholder="腾讯QQ" />
	                <input type="button" name="previous" class="previous action-button" value="Previous" />
	                <input type="button" name="next" class="next action-button" value="Next" />
	            </fieldset>
	            <fieldset>
	                <h2 class="fs-title">个人详细信息</h2>
	                <h3 class="fs-subtitle">个人详细信息是保密的，不会被泄露</h3>
	                <input type="text" name="fname" placeholder="昵称" />
	                <input type="text" name="lname" placeholder="姓名" />
	                <input type="text" name="phone" placeholder="电话号码" />
	                <textarea name="address" placeholder="家庭住址"></textarea>
	                <input type="button" name="previous" class="previous action-button" value="Previous" />
	                <input type="button" name="next" class="next action-button" value="next" />
	            </fieldset>
	            <fieldset>
	                <h2 class="fs-title">一个良好的策略从精准选股开始</h2>
	                <h3 class="fs-subtitle">搜索 对冲 地区 概念 行业 属性 组合</h3>
	                <input type="text" name="email" placeholder="Email地址" />
	                <input type="password" name="pass" placeholder="密码" />
	                <input type="password" name="cpass" placeholder="重复密码" />
	                <input type="button" name="next" class="next action-button" value="Next" />
	            </fieldset>
	            <fieldset>
	                <h2 class="fs-title">注意：完成后策略无法修改，请仔细核对所填信息</h2>
	                <h3 class="fs-subtitle">点击完成，生成策略</h3>
	                <input type="text" name="email" placeholder="Email地址" />
	                <input type="password" name="pass" placeholder="密码" />
	                <input type="button" name="previous" class="previous action-button" value="Previous" />
	                <input type="button" name="submit" class="submit action-button" value="完成" />
	            </fieldset>
	        </div>
	    </article>
    </div>
    <div class="foot">
		<jsp:include page="/WEB-INF/jsp/main/Foot.jsp"></jsp:include>
	</div>
    <script src="js/strategy/jquery.easing.min.js" type="text/javascript"></script>
    <script>
        var current_fs, next_fs, previous_fs;
        var left, opacity, scale;
        var animating;
        $('.next').click(function () {
            if (animating)
                return false;
            animating = true;
            current_fs = $(this).parent();
            next_fs = $(this).parent().next();
            $('#progressbar li').eq($('fieldset').index(next_fs)).addClass('active');
            next_fs.show();
            current_fs.animate({ opacity: 0 }, {
                step: function (now, mx) {
                    scale = 1 - (1 - now) * 0.2;
                    left = now * 50 + '%';
                    opacity = 1 - now;
                    current_fs.css({ 'transform': 'scale(' + scale + ')' });
                    next_fs.css({
                        'left': left,
                        'opacity': opacity
                    });
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                easing: 'easeInOutBack'
            });
        });
        $('.previous').click(function () {
            if (animating)
                return false;
            animating = true;
            current_fs = $(this).parent();
            previous_fs = $(this).parent().prev();
            $('#progressbar li').eq($('fieldset').index(current_fs)).removeClass('active');
            previous_fs.show();
            current_fs.animate({ opacity: 0 }, {
                step: function (now, mx) {
                    scale = 0.8 + (1 - now) * 0.2;
                    left = (1 - now) * 50 + '%';
                    opacity = 1 - now;
                    current_fs.css({ 'left': left });
                    previous_fs.css({
                        'transform': 'scale(' + scale + ')',
                        'opacity': opacity
                    });
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                easing: 'easeInOutBack'
            });
        });
        $('.submit').click(function () {
            return false;
        });
    </script>
</body>
</html>