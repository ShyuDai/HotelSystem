//追加盒子函数
$(function(){
	function verify(){	
		//解决中文乱码问题的方法1,页面端发出的数据作一次encodeURI，服务端使用new String(old.getBytes("iso8859-1"),"UTF-8");
		//解决中文乱码问题的方法2,页面端发出的数据作两次encodeURI,服务端使用String name = URLDecoder.decode(old,"UTF-8");
		var url = "ToOrderRoomServletwg";
		$.get(url,null,function(data){
			data = $.parseJSON(data);
			for(i in data){
//				var innerString = "<div><b>" + data[i].roomnumber + "</b></div>";
				var innerString = "<div name='"+data[i].roomnumber+"'><span></span><b>" + data[i].roomnumber + "</b><input id='roomnum' type='hidden' value='"+data[i].roomnumber+"'></div>";
				$(".reception-table").append(innerString);
//				房间状态：
//				0--空闲，
//				1--预定，
//				2--入住，
//				3--打扫中，
//				4--维修中，
//				5--接待中。
				var d = data[i].roomstatus;
				switch (d){
					case 0:
						$("#table div:eq("+i+")").addClass('kongxian');
						break;
					case 1:
						$("#table div:eq("+i+")").addClass('yuding');
						break;
					case 2:
						$("#table div:eq("+i+")").addClass('ruzhu');
						break;
					case 3:
						$("#table div:eq("+i+")").addClass('clean');
						break;
					case 4:
						$("#table div:eq("+i+")").addClass('weixiu');
						break;
					case 5:
						$("#table div:eq("+i+")").addClass('jiedai');
						break;	
				}
			};
		});
	};
	verify();	
//	$('#table div').on('click', function() {
//		var obj = $(this).val;
////		alert(1);
//		if(obj==0){
//			//空闲，可以预定、入住
//			$(".zhezhao").show();
//			$(".ruzhu").show();
//		}
//		else if(obj==1){
//			//预定，可以入住、换房、取消
//			
//		}else if(obj==2){
//			//入住，可以退房
//		}
//	});
	$("#table").on('click','.kongxian',function(){
		$(".zhezhao").show();
		$(".kongxian-op").show();
	});
	$("#table").on('click','.ruzhu',function(){
		$(".zhezhao").show();
		$(".ruzhu-op").show();
	});
	$("#table").on('click','.yuding',function(){
		$(".zhezhao").show();
		$(".yuding-op").show();
	});
	$(".close").on('click', function() {
		$(".zhezhao").hide();
	//	$(".zhezhao2").hide();
		$(".ruzhu-op").hide();
		$(".yuding-op").hide();
		$(".kongxian-op").hide();
		$(".kongxian-op-news").hide();
		$(".kongxian-op-new").hide();
		$(".zhangdan").hide();
	});
	
	$("#btnNum1").on('click',function(){
		var kongxianVal = $('input[name="kongxian"]:checked').val();
		
		
		if(kongxianVal==2)
			{
//				$(".zhezhao").show();
				$(".kongxian-op").hide();
				$(".kongxian-op-news").show();
				
			}else if(kongxianVal==1)
				{
				$(".kongxian-op").hide();
				$(".kongxian-op-new").show();
				}
			
	})
	var roomNumber;
	$("#table").on('click','div',function(){
//		$("#table").empty();
		$(".zhangdan").empty();
//		 verify();
		roomNumber=$(this).attr('name');
		$("#hideNum").val(roomNumber);
		$("#hideNum1").val(roomNumber);
		$("#hideNum3").val(roomNumber);
		
		
		
		
	 });
	$("#ruzhu-btn").on('click',function(){
		
		//var roomNumber=$("#table div").attr('name');
//		alert(roomNumber);
		//ruzhu判断val值
		var ruzhu = $("input[name='ruzhu']:checked").val();
		
		if(ruzhu==2){//否
			$("#hideNum3").val(roomNumber);	
			var ruzhuRoom=$("#hideNum3").val();
			
//			alert($("#hideNum2").val());
//			$("#table").empty();
//			alert(ruzhu);
			
//			$.ajax({
//				 type: "POST",//方法类型
//	             dataType: "json",//预期服务器返回的数据类型
//	             url: "CheckOutwgServlet?flag=2&roomnumber="+ruzhuRoom,//url
//	             data: $('#ruzhu-form').serialize()s
//			});
				$(".ruzhu-op").hide();
				$(".zhezhao").hide();
//				$("#table").empty();
//				 verify();
//				alert(yuding);						
		}else if(ruzhu==0){//是
			$("#hideNum3").val(roomNumber);	
			var ruzhuRoom=$("#hideNum3").val();
//			alert("房间编号："+ruzhuRoom);
//			alert(ruzhuRoom+"====="+roomNumber);
			$(".ruzhu-op").hide();
//			$(".zhezhao").hide();
//			alert(roomNumber);
			$.post("CheckOutwgServlet",{flag:0,roomnumber:roomNumber},function (result) {
				$(".zhangdan").show();
//	       	 	$(".ruzhu-op").hide();
	       	 	$(".zhangdan").append("<br><span>顾客姓名:</span>"+result.customername+"<span><br>顾客电话:</span>"+result.customerphone+"<br><span>身份证号:</span>"+result.customeridcard+"<br><span>房间号:</span>"+result.roomnumber+"<br><span>房间类型:</span>"+result.roomtypename+"<br><span>服务消费:</span>￥"+result.roomprice+"<b id='zhangdan-queding'>确定</b>");
//	             alert(result.roomtypename);
                  },"json");
			
			
//			$.get("CheckOutwgServlet",{flag:0,roomnumber:ruzhuRoom},function(result){
////				data1 = $.parseJSON(data);
//					alert("数据:"+result.orderid);
//				},"json");
			
//			 $.post("CheckOutwgServlet",{flag:0,roomnumber:ruzhuRoom},function(result){
//				   alert(result.roomtypename);
//			 	},"json");
	}else{
		$(".ruzhu-op").hide();
		$(".yuding-op").hide();
		$(".zhangdan").hide();
		$(".zhezhao").hide();
		$("#table").empty();
		 verify();
	}
	});
	
	$(".zhangdan").on('click','#zhangdan-queding',function(){//确认账单无误后，点击确定，开始退房操作
		var rn=$("#hideNum3").val();
//		alert(rn);
  		 $.post("CheckOutwgServlet",{flag:1,roomnumber:rn},function(result){
  			 if(result==1){
  				 alert("success");
  				 $(".zhangdan").hide();
  				 $(".zhezhao").hide();
  				 //重新调用盒子获取box
  				 $("#table").empty();
  				 verify();
  			 }else{
  				 alert("fail");
  			 }
			 },"json");
	});
			
		
		
			$("#yuding-btn").on('click',function(){
//				
				var yuding = $("input[name='yuding']:checked").val();
				$("#hideNum2").val(roomNumber);	
//					alert($("#hideNum2").val());
				var yudingRoom=$("#hideNum2").val();
				if(yuding==0){//退房
//					alert(1);
					/*$.ajax({
						 type: "POST",//方法类型
			             dataType: "json",//预期服务器返回的数据类型
			             url: "CheckInwgServlet?flag=2" ,//url
			             data: $('#yunding-form').serialize()
					});*/
					
					$.post("CheckInwgServlet",{flag:2,roomnumber:yudingRoom},function(result){
						if(result==1){
			  				 alert("success");
			  				$(".yuding-op").hide();
							$(".zhezhao").hide();
			  				 //重新调用盒子获取box
			  				 $("#table").empty();
			  				 verify();
			  			 }else{
			  				 alert("fail");
			  				 $(".yuding-op").hide();
			  				 $(".zhezhao").hide();
			  			 }
					 },"json");
					
				}else if(yuding==2){//入驻
					$.post("CheckInwgServlet",{flag:1,roomnumber:yudingRoom},function(result){
						if(result==1){
			  				 alert("success");
			  				$(".yuding-op").hide();
							$(".zhezhao").hide();
			  				 //重新调用盒子获取box
			  				 $("#table").empty();
			  				 verify();
			  			 }else{
			  				 alert("fail");
			  				 $(".yuding-op").hide();
			  				 $(".zhezhao").hide();
			  			 }
					 },"json");
				}else{
					$(".yuding-op").hide();
	  				 $(".zhezhao").hide();
				}
			});
			$("#btn3").on('click',function(){
				var customername = $('#btn3-customername').val();
				var customerphone = $('#btn3-customerphone').val();
				var customeridcard = $('#btn3-customeridcard').val();
				var customersex = $("input[class='btn3-sex']:checked").val();
				$("#hideNum1").val(roomNumber);	
//				alert($("#hideNum2").val());
				var yudingRoom=$("#hideNum1").val();
				$.post("OrderRoomServletwg",{roomnumber:yudingRoom,customername:customername,customerphone:customerphone,customeridcard:customeridcard,customersex:customersex},function(result){
					if(result==1){
		  				 alert("success");
		  				$(".kongxian-op-new").hide();
						$(".zhezhao").hide();
		  				 //重新调用盒子获取box
		  				$("#table").empty();
		  				 verify();
		  			 }else{
		  				 alert("fail");
		  				 $(".kongxian-op-new").hide();
		  				 $(".zhezhao").hide();
		  			 }
				 },"json");
//				alert(customername+customerphone+customeridcard+customersex)
			});
//		alert(("#hideNum").val());
	});


