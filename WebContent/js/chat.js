jQuery(document).ready(function() {
		$("#send").click(function(){
			if(document.getElementById("msg").value!=""){
				$.ajax({
				type:'post',
				url:'sendmsg',
				data:'msg='+$("#msg").val(),
				success:function(msg){
					document.getElementById("msg").value="";
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
})
		
		
		
		
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

