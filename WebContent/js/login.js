jQuery(document).ready(function() {
	$("#register").click(function(){
		$('.theme-popover').slideDown(200);
			$('.login_box').css({opacity:0.5});		
	})
	
	$('.theme-poptit .close').click(function(){
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