<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="./css/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="http://sandbox.runjs.cn/uploads/rs/55/sjckzedf/jquery-1.8.0.min.js"></script>
<script>
jQuery(document).ready(function() {
	$("#register").click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
			$('.login_box').css({opacity:0.5});		
	})
	
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
		$('.login_box').css({opacity:1});
	})
	
	$("#regusername").blur(function(){
		$.ajax({
			type:'post',
			url:'isregister',
			data:'regusername='+$("#regusername").val(),
			success:function(msg){
                document.getElementById("regmessage").innerHTML=msg;    
            }
	});
	});
});
</script>
</head>
<body>
	<!-- 登录 -->
	<div class="login_box">
		<div class="login_l_img">
			<img src="./images/login-img.png" />
		</div>
		<div class="login">
			<div class="login_logo">
				<a href="#"><img src="images/login_logo.png" /></a>
			</div>
			<div class="login_name">
				<p>后台管理系统</p>
				
			</div>
			<p style="color:red">${loginmessage}</p><br/>
			
			<form method="post" action="loginAction">
				<input name="username" type="text" id="username " placeholder="用户名"> 
				<input name="password" type="password" id="password"  placeholder="密码"/>
				<input value="登录" style="width: 100%;" type="submit"> <br />
				<br /> <a id="register" style="float: right;" href="javascript:;">注册账号</a>
			</form>
		</div>
		
	</div>
	
	<!-- 注册 -->
		<div class="theme-popover">
			<div class="theme-poptit">
				<a  style="float:right;font-size:20px;"  title="关闭" class="close">×</a>
				<h2 style="float:center">注册</h2>
			</div>
			<div class=" dform" >
				<p id="regmessage" style="color:red"></p>
				<br/>
				<form action="registerAction" method="post">
					<input name="regname" type="text"  placeholder="请输入姓名" id="regname" autocomplete="off"/> 
					<input name="regusername" type="text"  placeholder="请输入用户名"id="regusername"  autocomplete="off"/> 
					<input name="regpassword" type="password" id="regpassword" placeholder="请输入注册密码"/>

					<input  type="submit" name="regsubmit" value=" 注     册 " />
				</form>
			</div>
		</div>
</body>
</html>