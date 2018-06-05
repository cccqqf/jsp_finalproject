<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>low的一批聊天室</title>
<link href="./css/chat.css" rel="stylesheet" type="text/css" />	
<link rel="stylesheet" href="./css/buttons.css">
<script type="text/javascript"
	src="http://sandbox.runjs.cn/uploads/rs/55/sjckzedf/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="./js/chat.js">
	
	</script>
</head>
<body id="body" onload="connection()" class="body body-blur">
	<div class="main_div main_div-front">
	<header><!-- 显示在线人数什么的 --><h1>欢迎使用</h1></header>
	<div id="showmsg">
		  
	</div>
	
	<footer>
		<div id="sendmsg">
			${sessionScope.name}
			<textarea  id="msg" class="msgtextarea"></textarea>
			<button  id="send" class="button button-glow button-border button-rounded button-primary">发送</button>
		</div>
	</footer>
	
</div>

</body>
</html>