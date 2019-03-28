jQuery(document).ready(function() {
		$("#send").click(function(){
			if(document.getElementById("msg").value!=""){
				$.ajax({
				type:'post',
				url:'sendmsg',
				data:'msg='+$("#msg").val(),
				success:function(msg){
					document.getElementById("msg").value=""
					if(msg!=""){
						alert(msg);
					}
					
				}
				})
			}
		})
		
		$("#function1").click(function(){
			$('.theme-popover').slideDown(200);
			$("#main_function").load("onlinenumber.jsp");
		})
	
		$('.theme-poptit .close').click(function(){
			$('.theme-popover').slideUp(200);
		})
		
		$("#function2").click(function(){
			$('.theme-popover').slideDown(200);
			$("#main_function").load("search.jsp")
		})
		
		
})
		
function showdiv(name){
	var r=confirm("是否禁言此用户!");
	if (r==true){
		$.ajax({
			type:'post',
			url:'forbiduser',
			data:'name='+name,
			success:function(msg){
				alert(msg);
			}
		})
	}
}
		
		
function connection(){
	$.ajax({
		type:'post',
		url:'getmsgservlet',
		success:function(msg){
			var show=document.getElementById("showmsg");
			show.innerHTML=show.innerHTML+msg;
			show.scrollTop=show.scrollHeight;
			connection();
		}
	})
}

function loadhis(){
	$.ajax({
		type:'post',
		url:'loadhis',
		success:function(msg){
			var show=document.getElementById("showmsg");
			show.innerHTML=show.innerHTML+msg;
			show.scrollTop=show.scrollHeight;
		}
	})
}


function unconnection(){  
	$.ajax({
		type:'post',
		url:'unload',
		success:function(){
			
		}
	})
}  





