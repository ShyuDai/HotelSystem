

function sendAjaxRequestToCustomerServletToGetAllCustomers(pageNo){
	 $.ajax({
         url:"customerServlet",//要请求的服务器url
         //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
         //data:{method:"ajaxTest",val:value},
         data:{flag:1,pageNo:pageNo,attruCode:0,value:0},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                 var $aIndex=$("<a id=''  onclick='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())'/>");
                 //$a.attr("id",i);
                 $aIndex.val(1);
                 $aIndex.text("首页"+"         ");
                 $showPage.append($aIndex);

                 var $aLast=$("<a id=''  onclick='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aIndex);
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
                   var $a=$("<a id=''  onclick='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
            	  $showPage.append($aNext);
            	  
                  var $aEnd=$("<a id=''  onclick='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())'/>");
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
            
             var $pageNoInput=$("<input onblur='sendAjaxRequestToCustomerServletToGetAllCustomers($(this).val())' />");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>顾客姓名</td >\n" +
                 " <td  align='center'>顾客性别</td >\n" +
                 " <td  align='center'>身份证号</td >\n" +
                 " <td  align='center'>电话号码</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, customer) {
                 var $roomTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdName = $("<td align='center'></td>");
                 var $tdSex = $("<td align='center'></td>");
                 var $tdIdCard = $("<td align='center'></td>");
                 var $tdPhone = $("<td align='center'></td>");
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdName.text(customer.name);
                 $tdSex.text(customer.sex);
                 $tdIdCard.text(customer.idcard);
                 $tdPhone.text(customer.phone);
				
                 
               
                 $roomTr.append($tdNO);
                 $roomTr.append($tdName);
                 $roomTr.append($tdSex);
                 $roomTr.append($tdIdCard);
                 $roomTr.append($tdPhone);
   
                 $Tbody.append($roomTr);
             });
         }
     });
 }

function SearchCustomerBySex(pageNo,value){
	var sex=$("#sex").val();
	$.ajax({
        url:"customerServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:3,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='SearchCustomerBySex($(this).val(),'"+sex+"')'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='SearchCustomerBySex($(this).val(),'"+sex+"')'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
            	var $a=$("<a id=''  onclick='SearchCustomerBySex($(this).val(),'"+sex+"')'/>");
                 $a.val(i);
                 $a.attr("sex",sex);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
            	 var $aNext=$("<a id=''  onclick='SearchCustomerBySex($(this).val(),'"+sex+"')'/>");
                 //$a.attr("id",i);
            	 $aNext.val(pageNo+1);
            	 $aNext.text("下一页"+"         ");
                 $showPage.append($aNext);
                 
                 var $aEnd=$("<a id=''  onclick='SearchCustomerBySex($(this).val(),'"+sex+"')'/>");
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
           
            var $pageNoInput=$("<input onblur='SearchCustomerBySex($(this).val(),'"+sex+"')' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>顾客姓名</td >\n" +
                " <td  align='center'>顾客性别</td >\n" +
                " <td  align='center'>身份证号</td >\n" +
                " <td  align='center'>电话号码</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, customer) {
                var $roomTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdName = $("<td align='center'></td>");
                var $tdSex = $("<td align='center'></td>");
                var $tdIdCard = $("<td align='center'></td>");
                var $tdPhone = $("<td align='center'></td>");
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdName.text(customer.name);
                $tdSex.text(customer.sex);
                $tdIdCard.text(customer.idcard);
                $tdPhone.text(customer.phone);
				
                
              
                $roomTr.append($tdNO);
                $roomTr.append($tdName);
                $roomTr.append($tdSex);
                $roomTr.append($tdIdCard);
                $roomTr.append($tdPhone);
  
                $Tbody.append($roomTr);
            });
        }
    });
	
	
}

function SearchCustomerByKey(pageNo,value){
	$.ajax({
        url:"customerServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:6,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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

            if(pageNo>parseInt(1)){
                var $a=$("<a id=''  onclick='SearchCustomerByKey($(this).val())'/>");
                //$a.attr("id",i);
                $a.val(1);
                $a.text("首页"+"         ");

                var $a=$("<a id=''  onclick='SearchCustomerByKey($(this).val())'/>");
                //$a.attr("id",i);
                $a.val(pageNo-1);
                $a.text("上一页"+"         ");
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='SearchCustomerByKey($(this).val())'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $a=$("<a id=''  onclick='SearchCustomerByKey($(this).val())'/>");
                 //$a.attr("id",i);
                 $a.val(pageNo+1);
                 $a.text("下一页"+"         ");

                 var $a=$("<a id=''  onclick='SearchCustomerByKey($(this).val())'/>");
                 //$a.attr("id",i);
                 $a.val(pageCount);
                 $a.text("末页"+"         ");

            }
             var $showToatalCount=$("<div><div>");
            $showToatalCount.text("总共"+result.toatalCount+"条记录");
            $showToatalCount.css("color","red");
            $showPage.append($showToatalCount);

            var $tiaozhuan=$("<div><div>");
            $tiaozhuan.text("跳转到：");
           
            var $pageNoInput=$("<input onblur='SearchCustomerByKey($(this).val())' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>顾客姓名</td >\n" +
                " <td  align='center'>顾客性别</td >\n" +
                " <td  align='center'>身份证号</td >\n" +
                " <td  align='center'>电话号码</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, customer) {
                var $roomTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdName = $("<td align='center'></td>");
                var $tdSex = $("<td align='center'></td>");
                var $tdIdCard = $("<td align='center'></td>");
                var $tdPhone = $("<td align='center'></td>");
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdName.text(customer.name);
                $tdSex.text(customer.sex);
                $tdIdCard.text(customer.idcard);
                $tdPhone.text(customer.phone);
				
                
              
                $roomTr.append($tdNO);
                $roomTr.append($tdName);
                $roomTr.append($tdSex);
                $roomTr.append($tdIdCard);
                $roomTr.append($tdPhone);
  
                $Tbody.append($roomTr);
            });
        }
    });
}


$(function(){
	sendAjaxRequestToCustomerServletToGetAllCustomers(1);
	
});
 
 