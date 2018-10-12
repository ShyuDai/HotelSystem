function sendAjaxRequestToGetRoomTypes(){
	 $.ajax({
         url:"roomServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:1},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
         async:true,   //是否为异步请求
         cache:false,  //是否缓存结果
         type:"POST", //请求方式为POST
         dataType:"json",   //服务器返回的数据是什么类型
         success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
             var json = eval(result); //转化成数组
              var $roomtype=$("#roomtype");
              $roomtype.empty();
             $.each(json, function(i, roomtype) {
            	 var $roomtypeOption=$("<option></option>");
            	 $roomtypeOption.text(roomtype.roomtypename);
            	 $roomtypeOption.val(roomtype.roomtypeid);
            	 $roomtype.append($roomtypeOption);
             });
             
             
         }
     });
	 
 }
 
 function sendAjaxRequestToRoomServletToGetAllRooms(pageNo){
	 $.ajax({
         url:"roomServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:2,pageNo:pageNo,attruCode:0,value:0},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
         async:true,   //是否为异步请求
         cache:false,  //是否缓存结果
         type:"POST", //请求方式为POST
         dataType:"json",   //服务器返回的数据是什么类型
         success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
             //var json = eval(result); //转化成数组
             //alert(result.pageCount);
             
             var $showPage=$("#showPage");
             $showPage.empty();

             var pageCount =parseInt(result.pageCount);//页数
             var pageNo=parseInt(result.pageNo);//当前页码

             //alert(pageNo);

             if(pageNo>1){
                 var $aIndex=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())'/>");
                 //$a.attr("id",i);
                 $aIndex.val(1);
                 $aIndex.text("首页"+"         ");
                 $showPage.append($aIndex);

                 var $aLast=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aLast);
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
                   var $a=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
            	  $showPage.append($aNext);

                  var $aEnd=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())'/>");
                  //$a.attr("id",i);
                  $aEnd.val(pageCount);
                  $aEnd.text("末页"+"         ");
                  $showPage.append($aEnd);
             }
              var $showToatalCount=$("<div><div>");
             $showToatalCount.text("总共"+result.toatalCount+"条记录");
             $showToatalCount.css("color","red");
             $showPage.append($showToatalCount);

             var $tiaozhuan=$("<div><div>");
             $tiaozhuan.text("跳转到：");
            
             var $pageNoInput=$("<input onblur='sendAjaxRequestToRoomServletToGetAllRooms($(this).val())' />");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>客房编号</td >\n" +
                 " <td  align='center'>客房类型</td >\n" +
                 " <td  align='center'>客房详情</td >\n" +
                 " <td  align='center'>客房状态</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, room) {
                 var $roomTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdNumber = $("<td align='center'></td>");
                 var $tdType = $("<td align='center'></td>");
                 var $tdIntroduce = $("<td align='center'></td>");
                 var $tdStatus = $("<td align='center'></td>");
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdNumber.text(room.roomnumber);
                 $tdType.text(room.roomtypename);
                 $tdIntroduce.text(room.roomintroduce);
                 switch (parseInt(room.roomstatus)) {
				case 0:
					$tdStatus.text("空闲");
					break;
					
				case 1:
					$tdStatus.text("预定");
					break;
					
				case 2:
					$tdStatus.text("入住");
					break;
					
				case 3:
					$tdStatus.text("打扫中");
					break;
					
				case 4:
					$tdStatus.text("维修中");
					break;
					
				case 5:
					$tdStatus.text("接取中");
					break;

				default:
					$tdStatus.text("空闲");
					break;
				}
                 
                 
                 $roomTr.append($tdNO);
                 $roomTr.append($tdNumber);
                 $roomTr.append($tdType);
                 $roomTr.append($tdIntroduce);
                 $roomTr.append($tdStatus);
   
                 $Tbody.append($roomTr);
             });
         }
     });
	 
 }
 
 
 //向roomServlet发送ajax请求，获取Json数据并解析(flag:表示roomServlet中的某个方法，pageNo表示页码,attruCode表示是room表中要查询的某个元素对象的代号,value表示属性的参数值
 function sendAjaxRequestToRoomServletToGetRoomsByStatus(pageNo,value) {
	 //alert($('#roomstatus').find('option:selected').val());
	 var status=$('#roomstatus').find('option:selected').val();
     $.ajax({
         url:"roomServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:2,pageNo:pageNo,attruCode:6,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
         async:true,   //是否为异步请求
         cache:false,  //是否缓存结果
         type:"POST", //请求方式为POST
         dataType:"json",   //服务器返回的数据是什么类型
         success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
             //var json = eval(result); //转化成数组
             //alert(result.pageCount);
             
             var $showPage=$("#showPage");
             $showPage.empty();

             var pageCount =parseInt(result.pageCount);//页数
             var pageNo=parseInt(result.pageNo);//当前页码

             //alert(pageNo);

             if(pageNo>1){
                 var $aIndex=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")'/>");
                 //$a.attr("id",i);
                 $aIndex.val(1);
                 $aIndex.text("首页"+"         ");
                 $showPage.append($aIndex);
                 
                 var $aLast=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aLast);
                 
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
            	 var $a=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
                  $showPage.append($aNext);
                  
                  var $aEnd=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")'/>");
                  //$a.attr("id",i);
                  $aEnd.val(pageCount);
                  $aEnd.text("末页"+"         ");
                  $showPage.append($aEnd);
                  

             }
              var $showToatalCount=$("<div><div>");
             $showToatalCount.text("总共"+result.toatalCount+"条记录");
             $showToatalCount.css("color","red");
             $showPage.append($showToatalCount);

             var $tiaozhuan=$("<div><div>");
             $tiaozhuan.text("跳转到：");

             var $pageNoInput=$("<input onblur='sendAjaxRequestToRoomServletToGetRoomsByStatus($(this).val(),"+status+")' />");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>客房编号</td >\n" +
                 " <td  align='center'>客房类型</td >\n" +
                 " <td  align='center'>客房详情</td >\n" +
                 " <td  align='center'>客房状态</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, room) {
                 var $roomTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdNumber = $("<td align='center'></td>");
                 var $tdType = $("<td align='center'></td>");
                 var $tdIntroduce = $("<td align='center'></td>");
                 var $tdStatus = $("<td align='center'></td>");
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdNumber.text(room.roomnumber);
                 $tdType.text(room.roomtypename);
                 $tdIntroduce.text(room.roomintroduce);
                 switch (parseInt(room.roomstatus)) {
				case 0:
					$tdStatus.text("空闲");
					break;
					
				case 1:
					$tdStatus.text("预定");
					break;
					
				case 2:
					$tdStatus.text("入住");
					break;
					
				case 3:
					$tdStatus.text("打扫中");
					break;
					
				case 4:
					$tdStatus.text("维修中");
					break;
					
				case 5:
					$tdStatus.text("接取中");
					break;

				default:
					$tdStatus.text("空闲");
					break;
				}
                 
                 
                 $roomTr.append($tdNO);
                 $roomTr.append($tdNumber);
                 $roomTr.append($tdType);
                 $roomTr.append($tdIntroduce);
                 $roomTr.append($tdStatus);
   
                 $Tbody.append($roomTr);
             });
         }
     });
 }
 
 //向roomServlet发送ajax请求，获取Json数据并解析(flag:表示roomServlet中的某个方法，pageNo表示页码,attruCode表示是room表中要查询的某个元素对象的代号,value表示属性的参数值
 function sendAjaxRequestToRoomServletToGetRoomsByType(pageNo,value) {
     var type=$("#roomtype").find("option:selected").val();
    // alert(type);
     $.ajax({
         url:"roomServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:2,pageNo:pageNo,attruCode:3,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
         async:true,   //是否为异步请求
         cache:false,  //是否缓存结果
         type:"POST", //请求方式为POST
         dataType:"json",   //服务器返回的数据是什么类型
         success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
             //var json = eval(result); //转化成数组
             //alert(result.pageCount);
             
             var $showPage=$("#showPage");
             $showPage.empty();

             var pageCount =parseInt(result.pageCount);//页数
             var pageNo=parseInt(result.pageNo);//当前页码

             //alert(pageNo);

             if(pageNo>1){
            	 var $aIndex=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
                 //$a.attr("id",i);
            	 $aIndex.val(1);
            	 $aIndex.text("首页"+"         ");
                 $showPage.append($aIndex);

                 var $aLast=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aLast);
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
            	 var $a=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
                  $showPage.append($aNext);

                  var $aEnd=$("<a id=''  onclick='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
                  //$a.attr("id",i);
                  $aEnd.val(pageCount);
                  $aEnd.text("末页"+"         ");
                  $showPage.append($aEnd);

             }
              var $showToatalCount=$("<div><div>");
             $showToatalCount.text("总共"+result.toatalCount+"条记录");
             $showToatalCount.css("color","red");
             $showPage.append($showToatalCount);

             var $tiaozhuan=$("<div><div>");
             $tiaozhuan.text("跳转到：");

             var $pageNoInput=$("<input id=''  onblur='sendAjaxRequestToRoomServletToGetRoomsByType($(this).val(),"+type+")'/>");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>客房编号</td >\n" +
                 " <td  align='center'>客房类型</td >\n" +
                 " <td  align='center'>客房详情</td >\n" +
                 " <td  align='center'>客房状态</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, room) {
                 var $roomTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdNumber = $("<td align='center'></td>");
                 var $tdType = $("<td align='center'></td>");
                 var $tdIntroduce = $("<td align='center'></td>");
                 var $tdStatus = $("<td align='center'></td>");
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdNumber.text(room.roomnumber);
                 $tdType.text(room.roomtypename);
                 $tdIntroduce.text(room.roomintroduce);
                 switch (parseInt(room.roomstatus)) {
				case 0:
					$tdStatus.text("空闲");
					break;
					
				case 1:
					$tdStatus.text("预定");
					break;
					
				case 2:
					$tdStatus.text("入住");
					break;
					
				case 3:
					$tdStatus.text("打扫中");
					break;
					
				case 4:
					$tdStatus.text("维修中");
					break;
					
				case 5:
					$tdStatus.text("接取中");
					break;

				default:
					$tdStatus.text("空闲");
					break;
				}
                 
                 
                 $roomTr.append($tdNO);
                 $roomTr.append($tdNumber);
                 $roomTr.append($tdType);
                 $roomTr.append($tdIntroduce);
                 $roomTr.append($tdStatus);
   
                 $Tbody.append($roomTr);
             });
         }
     });
 }
 
 //多条件查询房间信息
 function SearchRoomByKey(pageNo, value){

     $.ajax({
         url:"roomServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:2,pageNo:pageNo,attruCode:7,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
         async:true,   //是否为异步请求
         cache:false,  //是否缓存结果
         type:"POST", //请求方式为POST
         dataType:"json",   //服务器返回的数据是什么类型
         success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
             //var json = eval(result); //转化成数组
             //alert(result.pageCount);
             
             var $showPage=$("#showPage");
             $showPage.empty();

             var pageCount =parseInt(result.pageCount);//页数
             var pageNo=parseInt(result.pageNo);//当前页码

             //alert(pageNo);

             if(pageNo>1){
            	 var $aIndex=$("<a id=''  onclick='SearchRoomByKey($(this).val(),"+$("#search").val()+")'/>");
                 //$a.attr("id",i);
            	 $aIndex.val(1);
            	 $aIndex.text("首页"+"         ");
            	 $showPage.append($aIndex);
                 var $aLast=$("<a id=''   onclick='SearchRoomByKey($(this).val(),"+$("#search").val()+")'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aLast);
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
            	 var $a=$("<a id=''  onclick='SearchRoomByKey($(this).val(),"+$("#search").val()+")'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='SearchRoomByKey($(this).val(),"+$("#search").val()+")'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
            	  $showPage.append($aNext);
            	  
                  var $aEnd=$("<a id=''  onclick='SearchRoomByKey($(this).val(),"+$("#search").val()+")'/>");
                  //$a.attr("id",i);
                  $aEnd.val(pageCount);
                  $aEnd.text("末页"+"         ");
                  $showPage.append($aEnd);
             }
              var $showToatalCount=$("<div><div>");
             $showToatalCount.text("总共"+result.toatalCount+"条记录");
             $showToatalCount.css("color","red");
             $showPage.append($showToatalCount);

             var $tiaozhuan=$("<div><div>");
             $tiaozhuan.text("跳转到：");

             var $pageNoInput=$("<input onblur='SearchRoomByKey($(this).val(),"+$("#search").val()+")' />");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>客房编号</td >\n" +
                 " <td  align='center'>客房类型</td >\n" +
                 " <td  align='center'>客房详情</td >\n" +
                 " <td  align='center'>客房状态</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, room) {
                 var $roomTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdNumber = $("<td align='center'></td>");
                 var $tdType = $("<td align='center'></td>");
                 var $tdIntroduce = $("<td align='center'></td>");
                 var $tdStatus = $("<td align='center'></td>");
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdNumber.text(room.roomnumber);
                 $tdType.text(room.roomtypename);
                 $tdIntroduce.text(room.roomintroduce);
                 switch (parseInt(room.roomstatus)) {
				case 0:
					$tdStatus.text("空闲");
					break;
					
				case 1:
					$tdStatus.text("预定");
					break;
					
				case 2:
					$tdStatus.text("入住");
					break;
					
				case 3:
					$tdStatus.text("打扫中");
					break;
					
				case 4:
					$tdStatus.text("维修中");
					break;
					
				case 5:
					$tdStatus.text("接取中");
					break;

				default:
					$tdStatus.text("空闲");
					break;
				}
                 
                 
                 $roomTr.append($tdNO);
                 $roomTr.append($tdNumber);
                 $roomTr.append($tdType);
                 $roomTr.append($tdIntroduce);
                 $roomTr.append($tdStatus);
   
                 $Tbody.append($roomTr);
             });
         }
     });
	
 }
 
 
 
    $(function(){
    	sendAjaxRequestToRoomServletToGetAllRooms(1);//加载所有的房间信息
    	sendAjaxRequestToGetRoomTypes();//加载所有房间类型信息
    	/* var $roomstatus=$("#roomstatus");//下拉框根据状态选择房间
    	$roomstatus.change(function(){
    		sendAjaxRequestToRoomServlet(2,1,6,$roomstatus.find("option:selected").val());
    	}); */
    });