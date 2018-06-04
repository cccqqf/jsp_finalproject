<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>low的一批聊天室</title>
<script type="text/javascript"
	src="http://sandbox.runjs.cn/uploads/rs/55/sjckzedf/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			$("#send").click(function(){
				$.ajax({
					type:'post',
					url:'sendmsg',
					data:'name='+$("#name").text()+'&msg='+$("#msg").val(),
					success:function(msg){
						document.getElementById("msg").value="";
					}
				})
			})
		})
		
		
		function connection(){
			$.ajax({
				type:'post',
				url:'getmsgservlet',
				success:function(msg){
					var show=document.getElementById("showmsg");
					show.innerHTML=show.innerHTML+msg;
					connection();
				}
			})
		}
	</script>
	
	
</head>
<body id="body" onload="connection()" >

<h1>登录成功</h1>
<p id="name">${sessionScope.name}</p>
<div>
<hr/>
	<div id="showmsg">
		<%
			/*List<String>messages=new ArrayList<String>();
			if(application.getAttribute("messages")!=null){
				messages=(List<String>)application.getAttribute("messages");
				for(String message:messages){
					out.print(message+"<br/>");
				}
			}
			
			out.print("<hr/>");*/
		
		%>
	</div>
	<div id="sendmsg">
			${sessionScope.name}
			<textarea rows="5" cols="40" id="msg"></textarea>
			<button  id="send">发送</button>
	</div>
</div>
</body>
</html>