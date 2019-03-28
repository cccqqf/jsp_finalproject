<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>
<link href="./css/search.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"
	src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
<script type="text/javascript">
	function btnclick(){
		document.getElementById('result').innerHTML = "";
		if(document.getElementById("searchinput").value!=""){
			$.ajax({
				type:'post',
				url:'searchaction',
				data:'content='+$("#searchinput").val(),
				success:function(msg){
					var content=document.getElementById("result");
					content.innerHTML=content.innerHTML+msg;
				}
			})
		}
	}
</script>
</head>
<body >
	<div class="bar6" style="width:800px;margin-top:20px">
        <div id="searchform" >
            <input id="searchinput" type="text" placeholder="输入姓名或消息" class="bar6">
            <button id="searchbutton"  class="bar6" onclick="btnclick()"></button>
        </div>
    </div>
    <div style="height:400px;width:800px;margin-top:20px;overflow:auto" id="result">
    </div>
</body>
</html>