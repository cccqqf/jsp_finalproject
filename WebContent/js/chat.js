jQuery(document).ready(function() {
			$("#send").click(function(){
				$.ajax({
					type:'post',
					url:'sendmsg',
					data:'msg='+$("#msg").val(),
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
					show.scrollTop=show.scrollHeight;
					connection();
				}
			})
		}