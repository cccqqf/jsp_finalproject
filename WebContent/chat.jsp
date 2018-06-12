<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天室</title>
<link href="./css/chat.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./css/buttons.css">
<script type="text/javascript"
	src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
<script type="text/javascript" src="./js/chat.js"></script>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="./js/buttons.js"></script>
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script type="text/javascript">
	
</script>
<!-- 只有使用字体图标时才需要加载 Font-Awesome -->
<link
	href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body id="body" onload="connection();loadhis();"
	onunload="unconnection();">
	<div class="bg">
		<div class="main_div">

			<!-- 先写这么多功能，万一用到了呢 -->
			<header class="div_header"> <span
				class="button-dropdown button-dropdown-primary"
				data-buttons="dropdown"
				style="float: left; opacity: 0.9; z-index: 1">
				<button class="button button-primary button-large"
					style="border-radius: 15px 0px 0px 0px;">功能</button>
				<ul class="button-dropdown-list is-below">
					<li><a id="function1"> 在线人数</a></li>
					<li><a href="">Option Link 2</a></li>
					<li class="button-dropdown-divider"><a href="">Option Link
							3</a></li>
				</ul>
			</span> </header>


			<div id="showmsg"></div>
			<footer>
			<div id="sendmsg" class="div_footer">
				<textarea id="msg" class="msgtextarea"></textarea>
				<br /> <br />
				<button id="send"
					class="button button-glow button-border button-rounded button-primary"
					style="float: right">发送</button>
			</div>
			</footer>
			<div class="theme-popover">
				<div class="theme-poptit">
					<a style="float: right; font-size: 30px;" title="关闭" class="close">×</a>
					<h2>功能</h2>
				</div>
				<div id="main_function"></div>
			</div>
		</div>
	</div>
</body>
</html>