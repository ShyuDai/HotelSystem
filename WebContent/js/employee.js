function sendAjaxRequestToEmployeeServletToGetAllEmployees(pageNo){
	 $.ajax({
         url:"employeeServlet",//要请求的服务器url
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
                 var $aIndex=$("<a id=''  onclick='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())'/>");
                 //$a.attr("id",i);
                 $aIndex.val(1);
                 $aIndex.text("首页"+"         ");
                 $showPage.append($aIndex);

                 var $aLast=$("<a id=''  onclick='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())'/>");
                 //$a.attr("id",i);
                 $aLast.val(pageNo-1);
                 $aLast.text("上一页"+"         ");
                 $showPage.append($aLast);
             }

             var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
             var end=start+21<pageCount?start+21:pageCount;//页面显示21页


             for(var i=start;i<=end;i++){
                  // alert(i);
                   var $a=$("<a id=''  onclick='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())'/>");
                 // $a.attr("id",i);
                  $a.val(i);
                  $a.text("第"+i+"页"+"         ");
                  $showPage.append($a);
              }


              if(pageNo<pageCount){
            	  var $aNext=$("<a id=''  onclick='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())'/>");
                  //$a.attr("id",i);
            	  $aNext.val(pageNo+1);
            	  $aNext.text("下一页"+"         ");
            	  $showPage.append($aNext);

                  var $aEnd=$("<a id=''  onclick='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())'/>");
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
            
             var $pageNoInput=$("<input onblur='sendAjaxRequestToEmployeeServletToGetAllEmployees($(this).val())' />");
             $pageNoInput.val(pageNo);


             $tiaozhuan.append($pageNoInput);
             $tiaozhuan.append("页");
             $showPage.append($tiaozhuan);

             var $myTable=$("#myTable");//创建表格节点
             $myTable.empty();//每次请求成功后把表格下面的元素清空
             
        
             var $head = $("<thead>\n" +
                 " <tr>\n" +
                 " <td align='center'>序号</td >\n" +
                 " <td  align='center'>员工号</td >\n" +
                 " <td  align='center'>员工姓名</td >\n" +
                 " <td  align='center'>性别</td >\n" +
                 " <td  align='center'>年龄(岁)</td >\n" +
                 " <td  align='center'>入职日期</td >\n" +
                 " <td  align='center'>工龄(年)</td >\n" +
                 " <td  align='center'>职位</td >\n" +
                 " <td  align='center'>等级</td >\n" +
                 " <td  align='center'>月薪(元)</td >\n" +
                 " <td  align='center'>所属部门</td >\n" +
                 " <td  align='center'>部门经理</td >\n" +
                 " <td  align='center'>备注</td >\n" +
                 " <td  align='center'>操作</td >\n" +
                 " <tr>\n" +
                 " </thead>");

             $myTable.append($head);

             var $Tbody=$("<tbody></tbody>");
             $myTable.append($Tbody);
             var list =eval(result.list);
             $.each(list, function(i, employee) {
                 var $employeeTr = $("<tr></tr>");
                 
                 var $tdNO = $("<td align='center'></td>");
                 var $tdEmpNo = $("<td align='center'></td>");
                 var $tdEmpName = $("<td align='center'></td>");
                 var $tdEmpSex = $("<td align='center'></td>");
                 var $tdEmpAge= $("<td align='center'></td>");
                 
                 var $tdEmpEntryDate = $("<td align='center'></td>");
                 var $tdEmpWorkingYears = $("<td align='center'></td>");
                 var $tdRoleName = $("<td align='center'></td>");
                 var $tdLevel = $("<td align='center'></td>");
                 var $tdMonthPay= $("<td align='center'></td>");
                 
                 var $tdDepName = $("<td align='center'></td>");
                 var $tdDepManager= $("<td align='center'></td>");
                 var $tdEmpRemark= $("<td align='center'></td>");
                 var $tdOperation= $("<td align='center'></td>");
                 
                
                 $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                 $tdEmpNo.text(employee.empNo);
                 $tdEmpName.text(employee.empName);
                 $tdEmpSex.text(employee.empSex);
                 $tdEmpAge.text(employee.empAge);
                 
                 $tdEmpEntryDate.text(employee.empEntryDate);
                 $tdEmpWorkingYears.text(employee.empWorkingYears);
                 $tdRoleName.text(employee.roleName);
                 $tdLevel.text(employee.level+"级");
                 $tdMonthPay.text(employee.monthPay);
                 
                 $tdDepName.text(employee.depName);
                 $tdDepManager.text(employee.depManager);
                 $tdEmpRemark.text(employee.empRemark);
                 
                 var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                 $imgUpdate.val(employee);
                 var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                 $imgDelete.val(employee);
                
                
                 $tdOperation.append($imgUpdate);
                 $tdOperation.append("        ")
                 $tdOperation.append($imgDelete);
                 
                 
                 
                 $employeeTr.append($tdNO);
                 $employeeTr.append($tdEmpNo);
                 $employeeTr.append($tdEmpName);
                 $employeeTr.append($tdEmpSex);
                 $employeeTr.append($tdEmpAge);
                 
                 $employeeTr.append($tdEmpEntryDate);
                 $employeeTr.append($tdEmpWorkingYears);
                 $employeeTr.append($tdRoleName);
                 $employeeTr.append($tdLevel);
                 $employeeTr.append($tdMonthPay);
                 
                 $employeeTr.append($tdDepName);
                 $employeeTr.append($tdDepManager);
                 $employeeTr.append($tdEmpRemark);
                 $employeeTr.append($tdOperation);
                 
                 $Tbody.append($employeeTr);
             });
         }
     });
	
 }

//修改员工
function updateEmployee(obj){
	    var emp=obj.val();

		$(".zhezhao").show();
		$(".renyuan-op").show();
		
		
		
		var $empName=$("#upEmpName");
		var $empSex=$("#upEmpSex");
		var $empAge=$("#upEmpAge");
		
		
		var $empNo=$("#upEmpNo");
		var $empRemark=$("#upEmpRemark");
		
		var $role=$("#upRoleName");
		var $department=$("#upDepName");
		//$department.change(function(){
			//alert($(this).find("option:selected").val());
			//changeDepManager($(this));
		//});
		
		$.ajax({
	        url:"employeeServlet",//要请求的服务器url
	        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
	        //data:{method:"ajaxTest",val:value},
	        data:{flag:5},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
	        async:true,   //是否为异步请求
	        cache:false,  //是否缓存结果
	        type:"POST", //请求方式为POST
	        dataType:"json",   //服务器返回的数据是什么类型
	        success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
	        
	        	$role.empty();
	            var $roleOption=$("<option></option>");
	    	    $roleOption.text(emp.roleName);
	    	    $roleOption.val(emp.roleId);
	    	    $role.append($roleOption);
	    	    
	            var list =eval(result);
	            $.each(list, function(i, role) {
	               var $option=$("<option></option>");
	               $option.val(role.roleId);
	               $option.text(role.roleName);
	               $role.append($option);
	            });
	        }
	    });
		
		$.ajax({
	        url:"employeeServlet",//要请求的服务器url
	        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
	        //data:{method:"ajaxTest",val:value},
	        data:{flag:6},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
	        async:true,   //是否为异步请求
	        cache:false,  //是否缓存结果
	        type:"POST", //请求方式为POST
	        dataType:"json",   //服务器返回的数据是什么类型
	        success:function(result){  
	        	//这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
	        
	        	$department.empty();
	    		var $depNameOption=$("<option></option>");
	    		$depNameOption.text(emp.depName);
	    		$depNameOption.val(emp.depId);
	    		$department.append($depNameOption);
	    		
	            var list =eval(result);
	            $.each(list, function(i, department) {
	               var $option=$("<option></option>");
	               $option.val(department.depId);
	               $option.text(department.depName);
	               $department.append($option);
	               //$addDepName.append($option);
	            });
	        }
	    });
		
		
		var $depManager=$("#upDepManager");
		
		$empName.val(emp.empName);
		
		if(emp.empSex=="男"){
			$("#meal").attr("checked",true);
			
		}
		
		if(emp.empSex=="女"){
			$("#femeal").attr("checked",true);
		}
		
		
		$empAge.val(emp.empAge);
		
		$empNo.val(emp.empNo);
		$empRemark.val(emp.empRemark);
	
		$depManager.val(emp.depManager);
		
		//保存更新
		var $btn_update=$("#btnNum-renyuan");
		$btn_update.click(function(){
			sendAjaxRequestToUpdateEmployee(
					emp.empId,$role.find("option:selected").val(),
					$department.find("option:selected").val(),$empName.val(),
					$(":radio:checked").val(),$empAge.val(),
					$empNo.val(),$empRemark.val()
					);
		});
	
		
}

function sendAjaxRequestToUpdateEmployee(empId,roleId,depId,empName,empSex,empAge,empNo,empRemark){
	$.post("employeeServlet",
		{
		"flag":4,
		"empId":empId,"roleId":roleId,
		"depId":depId,"empName":empName,
		"empSex":empSex,"empAge":empAge,
		"empNo":empNo,"empRemark":empRemark
		},function(data){
        if(data=="ok"){
           // alert( "用户修改成功！");
            $(".zhezhao").css("display","none");
            $(".renyuan-op").css("display","none");
        	sendAjaxRequestToEmployeeServletToGetAllEmployees(1);
        }else{
           // alert("用户修改失败！");
        }
    });
	
	
	
}

function sendAjaxRequestToSaveEmployee(roleId,depId,empName,empSex,empAge,empNo,empRemark){
	$.post("employeeServlet",
		{
		"flag":3,"roleId":roleId,
		"depId":depId,"empName":empName,
		"empSex":empSex,"empAge":empAge,
		"empNo":empNo,"empRemark":empRemark
		},function(data){
        if(data=="ok"){
        	sendAjaxRequestToEmployeeServletToGetAllEmployees(1);
        	$(".zhezhao").css("display","none");
            $(".add-op").css("display","none");
        }else{
            alert("员工添加失败！");
        }
    });
	
	
	
}



//删除员工
function deleteEmployee(obj){
	//alert("你点击了删除按钮，删除id"+obj.val());
	var emp=obj.val();
	if(confirm("你确认删除 [ "+emp.empName+" ] 吗？")){
        $.post("employeeServlet?flag=2",{"empId":emp.empId},function(data){
            if(data=="ok"){
                $(obj).parent().parent().remove();
                alert( "[ "+emp.empName+" ] 已被删除！");
            	
            }else{
                alert("删除失败！");
            }
        });
    }
}

//加载所有职位信息
function loadAllRoles(){
	 var $role=$("#role");
     var $addRole=$("#addRole");
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:5},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
        async:true,   //是否为异步请求
        cache:false,  //是否缓存结果
        type:"POST", //请求方式为POST
        dataType:"json",   //服务器返回的数据是什么类型
        success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
           
            //$addRole.empty();
            $role.empty();
            var list =eval(result);
            $.each(list, function(i, role) {
               var $option1=$("<option></option>");
               $option1.val(role.roleId);
               $option1.text(role.roleName);
               
               var $option2=$("<option></option>");
               $option2.val(role.roleId);
               $option2.text(role.roleName);
               
               $role.append($option1);
               $addRole.append($option2);
              
            });
        }
    });
	
}

//加载所有部门信息
function loadAllDepartments(){
	 var $department=$("#department");
     var $addDepName=$("#addDep");
    
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:6},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
        async:true,   //是否为异步请求
        cache:false,  //是否缓存结果
        type:"POST", //请求方式为POST
        dataType:"json",   //服务器返回的数据是什么类型
        success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
        	//alert(result[0].deptId);
            $department.empty();
            $addDepName.empty();
            var list =eval(result);
            $.each(result, function(i, department) {
               var $option1=$("<option></option>");
               $option1.val(department.depId);
               $option1.text(department.depName);
               
               var $option2=$("<option></option>");
               $option2.val(department.depId);
               $option2.text(department.depName);
               
               $department.append($option1);
               $addDepName.append($option2);
            });
        }
    });
	
}

//加载所有的部门经理信息
function loadAllDepManagers(){
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:1,attruCode:11,value:"2"},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
        async:true,   //是否为异步请求
        cache:false,  //是否缓存结果
        type:"POST", //请求方式为POST
        dataType:"json",   //服务器返回的数据是什么类型
        success:function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
            var $depManager=$("#depManager");
            $depManager.empty();
            var list =eval(result.list);
            $.each(list, function(i, employee) {
               var $option=$("<option></option>");
               $option.val(employee.depManager);
               $option.text(employee.depManager);
               $depManager.append($option);
            });
        }
    });
	
}


//根据性别查找员工
function searchEmployeeBySex(pageNo,value){
	var sex=$("#sex").find("option:selected").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:4,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeBySex($(this).val(),"+sex+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeBySex($(this).val(),"+sex+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeBySex($(this).val(),"+sex+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeBySex($(this).val(),"+sex+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeBySex($(this).val(),"+sex+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeBySex($(this).val(),"+sex+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}

//根据职位查找员工
function searchEmployeeByRole(pageNo,value){
	var role=$("#role").find("option:selected").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:9,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeByRole($(this).val(),"+role+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeByRole($(this).val(),"+role+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeByRole($(this).val(),"+role+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeByRole($(this).val(),"+role+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeByRole($(this).val(),"+role+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeByRole($(this).val(),"+role+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}

//根据部门查找员工
function searchEmployeeByDepartment(pageNo,value){
	var department=$("#department").find("option:selected").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:13,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+department+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+department+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+department+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+department+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+department+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeByDepartment($(this).val(),"+department+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}


//根据等级查找员工
function searchEmployeeByLevel(pageNo,value){
	var level=$("#level").find("option:selected").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:11,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+level+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+level+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+level+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+level+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+level+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeByLevel($(this).val(),"+level+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}

//根据部门经理 查找员工
function searchEmployeeByDepManager(pageNo,value){
	var depaManager=$("#depaManager").find("option:selected").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:16,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+depaManager+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+depaManager+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+depaManager+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+depaManager+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeByLevel($(this).val(),"+depaManager+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeByLevel($(this).val(),"+depaManager+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}



//根据年龄区间 查找员工
function searchEmployeeByEmpAgeInterval(pageNo,value){
	var value=$("#empAge").find("option:selected").val();
	var empAgeArr=value.split(",");
	
	var start=empAgeArr[0];
	var end=empAgeArr[1];
	
	//alert(start+"--->"+end);
	
	$.ajax({
      url:"employeeServlet",//要请求的服务器url
      //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
      //data:{method:"ajaxTest",val:value},
      data:{flag:7,pageNo:pageNo,attruCode:5,start:start,end:end},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
              var $aIndex=$("<a id=''  onclick='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aIndex.val(1);
              $aIndex.text("首页"+"         ");
              $showPage.append($aIndex);

              var $aLast=$("<a id=''  onclick='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aLast.val(pageNo-1);
              $aLast.text("上一页"+"         ");
              $showPage.append($aLast);
          }

          var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
          var end=start+21<pageCount?start+21:pageCount;//页面显示21页


          for(var i=start;i<=end;i++){
               // alert(i);
                var $a=$("<a id=''  onclick='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')'/>");
              // $a.attr("id",i);
               $a.val(i);
               $a.text("第"+i+"页"+"         ");
               $showPage.append($a);
           }


           if(pageNo<pageCount){
         	  var $aNext=$("<a id=''  onclick='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')'/>");
               //$a.attr("id",i);
         	  $aNext.val(pageNo+1);
         	  $aNext.text("下一页"+"         ");
         	  $showPage.append($aNext);

               var $aEnd=$("<a id=''  onclick='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')'/>");
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
         
          var $pageNoInput=$("<input onblur='searchEmployeeByEmpAgeInterval($(this).val(),'"+value+"')' />");
          $pageNoInput.val(pageNo);


          $tiaozhuan.append($pageNoInput);
          $tiaozhuan.append("页");
          $showPage.append($tiaozhuan);

          var $myTable=$("#myTable");//创建表格节点
          $myTable.empty();//每次请求成功后把表格下面的元素清空
          
     
          var $head = $("<thead>\n" +
              " <tr>\n" +
              " <td align='center'>序号</td >\n" +
              " <td  align='center'>员工号</td >\n" +
              " <td  align='center'>员工姓名</td >\n" +
              " <td  align='center'>性别</td >\n" +
              " <td  align='center'>年龄(岁)</td >\n" +
              " <td  align='center'>入职日期</td >\n" +
              " <td  align='center'>工龄(年)</td >\n" +
              " <td  align='center'>职位</td >\n" +
              " <td  align='center'>等级</td >\n" +
              " <td  align='center'>月薪(元)</td >\n" +
              " <td  align='center'>所属部门</td >\n" +
              " <td  align='center'>部门经理</td >\n" +
              " <td  align='center'>备注</td >\n" +
              " <td  align='center'>操作</td >\n" +
              " <tr>\n" +
              " </thead>");

          $myTable.append($head);

          var $Tbody=$("<tbody></tbody>");
          $myTable.append($Tbody);
          var list =eval(result.list);
          $.each(list, function(i, employee) {
              var $employeeTr = $("<tr></tr>");
              
              var $tdNO = $("<td align='center'></td>");
              var $tdEmpNo = $("<td align='center'></td>");
              var $tdEmpName = $("<td align='center'></td>");
              var $tdEmpSex = $("<td align='center'></td>");
              var $tdEmpAge= $("<td align='center'></td>");
              
              var $tdEmpEntryDate = $("<td align='center'></td>");
              var $tdEmpWorkingYears = $("<td align='center'></td>");
              var $tdRoleName = $("<td align='center'></td>");
              var $tdLevel = $("<td align='center'></td>");
              var $tdMonthPay= $("<td align='center'></td>");
              
              var $tdDepName = $("<td align='center'></td>");
              var $tdDepManager= $("<td align='center'></td>");
              var $tdEmpRemark= $("<td align='center'></td>");
              var $tdOperation= $("<td align='center'></td>");
              
             
              $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
              $tdEmpNo.text(employee.empNo);
              $tdEmpName.text(employee.empName);
              $tdEmpSex.text(employee.empSex);
              $tdEmpAge.text(employee.empAge);
              
              $tdEmpEntryDate.text(employee.empEntryDate);
              $tdEmpWorkingYears.text(employee.empWorkingYears);
              $tdRoleName.text(employee.roleName);
              $tdLevel.text(employee.level+"级");
              $tdMonthPay.text(employee.monthPay);
              
              $tdDepName.text(employee.depName);
              $tdDepManager.text(employee.depManager);
              $tdEmpRemark.text(employee.empRemark);
              
              var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
              $imgUpdate.val(employee);
              var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
              $imgDelete.val(employee);
             
             
              $tdOperation.append($imgUpdate);
              $tdOperation.append("        ")
              $tdOperation.append($imgDelete);
              
              
              
              $employeeTr.append($tdNO);
              $employeeTr.append($tdEmpNo);
              $employeeTr.append($tdEmpName);
              $employeeTr.append($tdEmpSex);
              $employeeTr.append($tdEmpAge);
              
              $employeeTr.append($tdEmpEntryDate);
              $employeeTr.append($tdEmpWorkingYears);
              $employeeTr.append($tdRoleName);
              $employeeTr.append($tdLevel);
              $employeeTr.append($tdMonthPay);
              
              $employeeTr.append($tdDepName);
              $employeeTr.append($tdDepManager);
              $employeeTr.append($tdEmpRemark);
              $employeeTr.append($tdOperation);
              
              $Tbody.append($employeeTr);
          });
      }
  });
	
	
}

//根据工龄区间 查找员工
function searchEmployeeByEmpWorkingYearsInterval(pageNo,value){
	var value=$("#empWorkingYears").find("option:selected").val();
	var empWorkingYearsArr=value.split(",");
	
	var start=empWorkingYearsArr[0];
	var end=empWorkingYearsArr[1];
	
	//alert(start+"--->"+end);
	
	$.ajax({
      url:"employeeServlet",//要请求的服务器url
      //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
      //data:{method:"ajaxTest",val:value},
      data:{flag:7,pageNo:pageNo,attruCode:7,start:start,end:end},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
              var $aIndex=$("<a id=''  onclick='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aIndex.val(1);
              $aIndex.text("首页"+"         ");
              $showPage.append($aIndex);

              var $aLast=$("<a id=''  onclick='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aLast.val(pageNo-1);
              $aLast.text("上一页"+"         ");
              $showPage.append($aLast);
          }

          var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
          var end=start+21<pageCount?start+21:pageCount;//页面显示21页


          for(var i=start;i<=end;i++){
               // alert(i);
                var $a=$("<a id=''  onclick='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')'/>");
              // $a.attr("id",i);
               $a.val(i);
               $a.text("第"+i+"页"+"         ");
               $showPage.append($a);
           }


           if(pageNo<pageCount){
         	  var $aNext=$("<a id=''  onclick='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')'/>");
               //$a.attr("id",i);
         	  $aNext.val(pageNo+1);
         	  $aNext.text("下一页"+"         ");
         	  $showPage.append($aNext);

               var $aEnd=$("<a id=''  onclick='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')'/>");
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
         
          var $pageNoInput=$("<input onblur='searchEmployeeByEmpWorkingYearsInterval($(this).val(),'"+value+"')' />");
          $pageNoInput.val(pageNo);


          $tiaozhuan.append($pageNoInput);
          $tiaozhuan.append("页");
          $showPage.append($tiaozhuan);

          var $myTable=$("#myTable");//创建表格节点
          $myTable.empty();//每次请求成功后把表格下面的元素清空
          
     
          var $head = $("<thead>\n" +
              " <tr>\n" +
              " <td align='center'>序号</td >\n" +
              " <td  align='center'>员工号</td >\n" +
              " <td  align='center'>员工姓名</td >\n" +
              " <td  align='center'>性别</td >\n" +
              " <td  align='center'>年龄(岁)</td >\n" +
              " <td  align='center'>入职日期</td >\n" +
              " <td  align='center'>工龄(年)</td >\n" +
              " <td  align='center'>职位</td >\n" +
              " <td  align='center'>等级</td >\n" +
              " <td  align='center'>月薪(元)</td >\n" +
              " <td  align='center'>所属部门</td >\n" +
              " <td  align='center'>部门经理</td >\n" +
              " <td  align='center'>备注</td >\n" +
              " <td  align='center'>操作</td >\n" +
              " <tr>\n" +
              " </thead>");

          $myTable.append($head);

          var $Tbody=$("<tbody></tbody>");
          $myTable.append($Tbody);
          var list =eval(result.list);
          $.each(list, function(i, employee) {
              var $employeeTr = $("<tr></tr>");
              
              var $tdNO = $("<td align='center'></td>");
              var $tdEmpNo = $("<td align='center'></td>");
              var $tdEmpName = $("<td align='center'></td>");
              var $tdEmpSex = $("<td align='center'></td>");
              var $tdEmpAge= $("<td align='center'></td>");
              
              var $tdEmpEntryDate = $("<td align='center'></td>");
              var $tdEmpWorkingYears = $("<td align='center'></td>");
              var $tdRoleName = $("<td align='center'></td>");
              var $tdLevel = $("<td align='center'></td>");
              var $tdMonthPay= $("<td align='center'></td>");
              
              var $tdDepName = $("<td align='center'></td>");
              var $tdDepManager= $("<td align='center'></td>");
              var $tdEmpRemark= $("<td align='center'></td>");
              var $tdOperation= $("<td align='center'></td>");
              
             
              $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
              $tdEmpNo.text(employee.empNo);
              $tdEmpName.text(employee.empName);
              $tdEmpSex.text(employee.empSex);
              $tdEmpAge.text(employee.empAge);
              
              $tdEmpEntryDate.text(employee.empEntryDate);
              $tdEmpWorkingYears.text(employee.empWorkingYears);
              $tdRoleName.text(employee.roleName);
              $tdLevel.text(employee.level+"级");
              $tdMonthPay.text(employee.monthPay);
              
              $tdDepName.text(employee.depName);
              $tdDepManager.text(employee.depManager);
              $tdEmpRemark.text(employee.empRemark);
              
              var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
              $imgUpdate.val(employee);
              var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
              $imgDelete.val(employee);
             
             
              $tdOperation.append($imgUpdate);
              $tdOperation.append("        ")
              $tdOperation.append($imgDelete);
              
              
              
              $employeeTr.append($tdNO);
              $employeeTr.append($tdEmpNo);
              $employeeTr.append($tdEmpName);
              $employeeTr.append($tdEmpSex);
              $employeeTr.append($tdEmpAge);
              
              $employeeTr.append($tdEmpEntryDate);
              $employeeTr.append($tdEmpWorkingYears);
              $employeeTr.append($tdRoleName);
              $employeeTr.append($tdLevel);
              $employeeTr.append($tdMonthPay);
              
              $employeeTr.append($tdDepName);
              $employeeTr.append($tdDepManager);
              $employeeTr.append($tdEmpRemark);
              $employeeTr.append($tdOperation);
              
              $Tbody.append($employeeTr);
          });
      }
  });
	
	
}

//根据月薪区间 查找员工
function searchEmployeeByMonthPayInterval(pageNo,value){
	var value=$("#monthPay").find("option:selected").val();
	var monthPayArr=value.split(",");
	
	var start=monthPayArr[0];
	var end=monthPayArr[1];
	
	//alert(start+"--->"+end);
	
	$.ajax({
      url:"employeeServlet",//要请求的服务器url
      //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
      //data:{method:"ajaxTest",val:value},
      data:{flag:7,pageNo:pageNo,attruCode:12,start:start,end:end},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
              var $aIndex=$("<a id=''  onclick='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aIndex.val(1);
              $aIndex.text("首页"+"         ");
              $showPage.append($aIndex);

              var $aLast=$("<a id=''  onclick='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')'/>");
              //$a.attr("id",i);
              $aLast.val(pageNo-1);
              $aLast.text("上一页"+"         ");
              $showPage.append($aLast);
          }

          var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
          var end=start+21<pageCount?start+21:pageCount;//页面显示21页


          for(var i=start;i<=end;i++){
               // alert(i);
                var $a=$("<a id=''  onclick='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')'/>");
              // $a.attr("id",i);
               $a.val(i);
               $a.text("第"+i+"页"+"         ");
               $showPage.append($a);
           }


           if(pageNo<pageCount){
         	  var $aNext=$("<a id=''  onclick='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')'/>");
               //$a.attr("id",i);
         	  $aNext.val(pageNo+1);
         	  $aNext.text("下一页"+"         ");
         	  $showPage.append($aNext);

               var $aEnd=$("<a id=''  onclick='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')'/>");
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
         
          var $pageNoInput=$("<input onblur='searchEmployeeByMonthPayInterval($(this).val(),'"+value+"')' />");
          $pageNoInput.val(pageNo);


          $tiaozhuan.append($pageNoInput);
          $tiaozhuan.append("页");
          $showPage.append($tiaozhuan);

          var $myTable=$("#myTable");//创建表格节点
          $myTable.empty();//每次请求成功后把表格下面的元素清空
          
     
          var $head = $("<thead>\n" +
              " <tr>\n" +
              " <td align='center'>序号</td >\n" +
              " <td  align='center'>员工号</td >\n" +
              " <td  align='center'>员工姓名</td >\n" +
              " <td  align='center'>性别</td >\n" +
              " <td  align='center'>年龄(岁)</td >\n" +
              " <td  align='center'>入职日期</td >\n" +
              " <td  align='center'>工龄(年)</td >\n" +
              " <td  align='center'>职位</td >\n" +
              " <td  align='center'>等级</td >\n" +
              " <td  align='center'>月薪(元)</td >\n" +
              " <td  align='center'>所属部门</td >\n" +
              " <td  align='center'>部门经理</td >\n" +
              " <td  align='center'>备注</td >\n" +
              " <td  align='center'>操作</td >\n" +
              " <tr>\n" +
              " </thead>");

          $myTable.append($head);

          var $Tbody=$("<tbody></tbody>");
          $myTable.append($Tbody);
          var list =eval(result.list);
          $.each(list, function(i, employee) {
              var $employeeTr = $("<tr></tr>");
              
              var $tdNO = $("<td align='center'></td>");
              var $tdEmpNo = $("<td align='center'></td>");
              var $tdEmpName = $("<td align='center'></td>");
              var $tdEmpSex = $("<td align='center'></td>");
              var $tdEmpAge= $("<td align='center'></td>");
              
              var $tdEmpEntryDate = $("<td align='center'></td>");
              var $tdEmpWorkingYears = $("<td align='center'></td>");
              var $tdRoleName = $("<td align='center'></td>");
              var $tdLevel = $("<td align='center'></td>");
              var $tdMonthPay= $("<td align='center'></td>");
              
              var $tdDepName = $("<td align='center'></td>");
              var $tdDepManager= $("<td align='center'></td>");
              var $tdEmpRemark= $("<td align='center'></td>");
              var $tdOperation= $("<td align='center'></td>");
              
             
              $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
              $tdEmpNo.text(employee.empNo);
              $tdEmpName.text(employee.empName);
              $tdEmpSex.text(employee.empSex);
              $tdEmpAge.text(employee.empAge);
              
              $tdEmpEntryDate.text(employee.empEntryDate);
              $tdEmpWorkingYears.text(employee.empWorkingYears);
              $tdRoleName.text(employee.roleName);
              $tdLevel.text(employee.level+"级");
              $tdMonthPay.text(employee.monthPay);
              
              $tdDepName.text(employee.depName);
              $tdDepManager.text(employee.depManager);
              $tdEmpRemark.text(employee.empRemark);
              
              var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
              $imgUpdate.val(employee);
              var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
              $imgDelete.val(employee);
             
             
              $tdOperation.append($imgUpdate);
              $tdOperation.append("        ")
              $tdOperation.append($imgDelete);
              
              
              
              $employeeTr.append($tdNO);
              $employeeTr.append($tdEmpNo);
              $employeeTr.append($tdEmpName);
              $employeeTr.append($tdEmpSex);
              $employeeTr.append($tdEmpAge);
              
              $employeeTr.append($tdEmpEntryDate);
              $employeeTr.append($tdEmpWorkingYears);
              $employeeTr.append($tdRoleName);
              $employeeTr.append($tdLevel);
              $employeeTr.append($tdMonthPay);
              
              $employeeTr.append($tdDepName);
              $employeeTr.append($tdDepManager);
              $employeeTr.append($tdEmpRemark);
              $employeeTr.append($tdOperation);
              
              $Tbody.append($employeeTr);
          });
      }
  });
	
	
}


//根据入职日期区间 查找员工
function searchEmployeeByEntryDateInterval(pageNo,startDate,endDate){
	var start=$("#startDate").val();
	var end=$("#endDate").val();
	$.ajax({
      url:"employeeServlet",//要请求的服务器url
      //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
      //data:{method:"ajaxTest",val:value},
      data:{flag:8,pageNo:pageNo,start:startDate,end:endDate},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
              var $aIndex=$("<a id=''  onclick='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')'/>");
              //$a.attr("id",i);
              $aIndex.val(1);
              $aIndex.text("首页"+"         ");
              $showPage.append($aIndex);

              var $aLast=$("<a id=''  onclick='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')'/>");
              //$a.attr("id",i);
              $aLast.val(pageNo-1);
              $aLast.text("上一页"+"         ");
              $showPage.append($aLast);
          }

          var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
          var end=start+21<pageCount?start+21:pageCount;//页面显示21页


          for(var i=start;i<=end;i++){
               // alert(i);
                var $a=$("<a id=''  onclick='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')'/>");
              // $a.attr("id",i);
               $a.val(i);
               $a.text("第"+i+"页"+"         ");
               $showPage.append($a);
           }


           if(pageNo<pageCount){
         	  var $aNext=$("<a id=''  onclick='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')'/>");
               //$a.attr("id",i);
         	  $aNext.val(pageNo+1);
         	  $aNext.text("下一页"+"         ");
         	  $showPage.append($aNext);

               var $aEnd=$("<a id=''  onclick='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')'/>");
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
         
          var $pageNoInput=$("<input onblur='searchEmployeeByEntryDateInterval($(this).val(),'"+start+",'"+end+"')' />");
          $pageNoInput.val(pageNo);


          $tiaozhuan.append($pageNoInput);
          $tiaozhuan.append("页");
          $showPage.append($tiaozhuan);

          var $myTable=$("#myTable");//创建表格节点
          $myTable.empty();//每次请求成功后把表格下面的元素清空
          
     
          var $head = $("<thead>\n" +
              " <tr>\n" +
              " <td align='center'>序号</td >\n" +
              " <td  align='center'>员工号</td >\n" +
              " <td  align='center'>员工姓名</td >\n" +
              " <td  align='center'>性别</td >\n" +
              " <td  align='center'>年龄(岁)</td >\n" +
              " <td  align='center'>入职日期</td >\n" +
              " <td  align='center'>工龄(年)</td >\n" +
              " <td  align='center'>职位</td >\n" +
              " <td  align='center'>等级</td >\n" +
              " <td  align='center'>月薪(元)</td >\n" +
              " <td  align='center'>所属部门</td >\n" +
              " <td  align='center'>部门经理</td >\n" +
              " <td  align='center'>备注</td >\n" +
              " <td  align='center'>操作</td >\n" +
              " <tr>\n" +
              " </thead>");

          $myTable.append($head);

          var $Tbody=$("<tbody></tbody>");
          $myTable.append($Tbody);
          var list =eval(result.list);
          $.each(list, function(i, employee) {
              var $employeeTr = $("<tr></tr>");
              
              var $tdNO = $("<td align='center'></td>");
              var $tdEmpNo = $("<td align='center'></td>");
              var $tdEmpName = $("<td align='center'></td>");
              var $tdEmpSex = $("<td align='center'></td>");
              var $tdEmpAge= $("<td align='center'></td>");
              
              var $tdEmpEntryDate = $("<td align='center'></td>");
              var $tdEmpWorkingYears = $("<td align='center'></td>");
              var $tdRoleName = $("<td align='center'></td>");
              var $tdLevel = $("<td align='center'></td>");
              var $tdMonthPay= $("<td align='center'></td>");
              
              var $tdDepName = $("<td align='center'></td>");
              var $tdDepManager= $("<td align='center'></td>");
              var $tdEmpRemark= $("<td align='center'></td>");
              var $tdOperation= $("<td align='center'></td>");
              
             
              $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
              $tdEmpNo.text(employee.empNo);
              $tdEmpName.text(employee.empName);
              $tdEmpSex.text(employee.empSex);
              $tdEmpAge.text(employee.empAge);
              
              $tdEmpEntryDate.text(employee.empEntryDate);
              $tdEmpWorkingYears.text(employee.empWorkingYears);
              $tdRoleName.text(employee.roleName);
              $tdLevel.text(employee.level+"级");
              $tdMonthPay.text(employee.monthPay);
              
              $tdDepName.text(employee.depName);
              $tdDepManager.text(employee.depManager);
              $tdEmpRemark.text(employee.empRemark);
              
              var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
              $imgUpdate.val(employee);
              var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
              $imgDelete.val(employee);
             
              $tdOperation.append($imgUpdate);
              $tdOperation.append("        ")
              $tdOperation.append($imgDelete);
              
              
              
              $employeeTr.append($tdNO);
              $employeeTr.append($tdEmpNo);
              $employeeTr.append($tdEmpName);
              $employeeTr.append($tdEmpSex);
              $employeeTr.append($tdEmpAge);
              
              $employeeTr.append($tdEmpEntryDate);
              $employeeTr.append($tdEmpWorkingYears);
              $employeeTr.append($tdRoleName);
              $employeeTr.append($tdLevel);
              $employeeTr.append($tdMonthPay);
              
              $employeeTr.append($tdDepName);
              $employeeTr.append($tdDepManager);
              $employeeTr.append($tdEmpRemark);
              $employeeTr.append($tdOperation);
              
              $Tbody.append($employeeTr);
          });
      }
  });
	
}

//综合搜索
function searchEmployeeByKey(pageNo,value){
	var key=$("#key").val();
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:1,pageNo:pageNo,attruCode:17,value:value},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
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
                var $aIndex=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+key+")'/>");
                //$a.attr("id",i);
                $aIndex.val(1);
                $aIndex.text("首页"+"         ");
                $showPage.append($aIndex);

                var $aLast=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+key+")'/>");
                //$a.attr("id",i);
                $aLast.val(pageNo-1);
                $aLast.text("上一页"+"         ");
                $showPage.append($aLast);
            }

            var start=pageNo-10<=0?1:pageNo-10;//每页的起始页
            var end=start+21<pageCount?start+21:pageCount;//页面显示21页


            for(var i=start;i<=end;i++){
                 // alert(i);
                  var $a=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+key+")'/>");
                // $a.attr("id",i);
                 $a.val(i);
                 $a.text("第"+i+"页"+"         ");
                 $showPage.append($a);
             }


             if(pageNo<pageCount){
           	  var $aNext=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+key+")'/>");
                 //$a.attr("id",i);
           	  $aNext.val(pageNo+1);
           	  $aNext.text("下一页"+"         ");
           	  $showPage.append($aNext);

                 var $aEnd=$("<a id=''  onclick='searchEmployeeByDepartment($(this).val(),"+key+")'/>");
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
           
            var $pageNoInput=$("<input onblur='searchEmployeeByDepartment($(this).val(),"+key+")' />");
            $pageNoInput.val(pageNo);


            $tiaozhuan.append($pageNoInput);
            $tiaozhuan.append("页");
            $showPage.append($tiaozhuan);

            var $myTable=$("#myTable");//创建表格节点
            $myTable.empty();//每次请求成功后把表格下面的元素清空
            
       
            var $head = $("<thead>\n" +
                " <tr>\n" +
                " <td align='center'>序号</td >\n" +
                " <td  align='center'>员工号</td >\n" +
                " <td  align='center'>员工姓名</td >\n" +
                " <td  align='center'>性别</td >\n" +
                " <td  align='center'>年龄(岁)</td >\n" +
                " <td  align='center'>入职日期</td >\n" +
                " <td  align='center'>工龄(年)</td >\n" +
                " <td  align='center'>职位</td >\n" +
                " <td  align='center'>等级</td >\n" +
                " <td  align='center'>月薪(元)</td >\n" +
                " <td  align='center'>所属部门</td >\n" +
                " <td  align='center'>部门经理</td >\n" +
                " <td  align='center'>备注</td >\n" +
                " <td  align='center'>操作</td >\n" +
                " <tr>\n" +
                " </thead>");

            $myTable.append($head);

            var $Tbody=$("<tbody></tbody>");
            $myTable.append($Tbody);
            var list =eval(result.list);
            $.each(list, function(i, employee) {
                var $employeeTr = $("<tr></tr>");
                
                var $tdNO = $("<td align='center'></td>");
                var $tdEmpNo = $("<td align='center'></td>");
                var $tdEmpName = $("<td align='center'></td>");
                var $tdEmpSex = $("<td align='center'></td>");
                var $tdEmpAge= $("<td align='center'></td>");
                
                var $tdEmpEntryDate = $("<td align='center'></td>");
                var $tdEmpWorkingYears = $("<td align='center'></td>");
                var $tdRoleName = $("<td align='center'></td>");
                var $tdLevel = $("<td align='center'></td>");
                var $tdMonthPay= $("<td align='center'></td>");
                
                var $tdDepName = $("<td align='center'></td>");
                var $tdDepManager= $("<td align='center'></td>");
                var $tdEmpRemark= $("<td align='center'></td>");
                var $tdOperation= $("<td align='center'></td>");
                
               
                $tdNO.text((result.pageNo - 1) * result.pageSize + (i + 1));
                $tdEmpNo.text(employee.empNo);
                $tdEmpName.text(employee.empName);
                $tdEmpSex.text(employee.empSex);
                $tdEmpAge.text(employee.empAge);
                
                $tdEmpEntryDate.text(employee.empEntryDate);
                $tdEmpWorkingYears.text(employee.empWorkingYears);
                $tdRoleName.text(employee.roleName);
                $tdLevel.text(employee.level+"级");
                $tdMonthPay.text(employee.monthPay);
                
                $tdDepName.text(employee.depName);
                $tdDepManager.text(employee.depManager);
                $tdEmpRemark.text(employee.empRemark);
                
                var $imgUpdate=$("<a  onclick='updateEmployee($(this))'>修改</a>");
                $imgUpdate.val(employee);
                var $imgDelete=$("<a  onclick='deleteEmployee($(this))'>删除</a>");
                $imgDelete.val(employee);
               
               
                $tdOperation.append($imgUpdate);
                $tdOperation.append("        ")
                $tdOperation.append($imgDelete);
                
                
                
                $employeeTr.append($tdNO);
                $employeeTr.append($tdEmpNo);
                $employeeTr.append($tdEmpName);
                $employeeTr.append($tdEmpSex);
                $employeeTr.append($tdEmpAge);
                
                $employeeTr.append($tdEmpEntryDate);
                $employeeTr.append($tdEmpWorkingYears);
                $employeeTr.append($tdRoleName);
                $employeeTr.append($tdLevel);
                $employeeTr.append($tdMonthPay);
                
                $employeeTr.append($tdDepName);
                $employeeTr.append($tdDepManager);
                $employeeTr.append($tdEmpRemark);
                $employeeTr.append($tdOperation);
                
                $Tbody.append($employeeTr);
            });
        }
    });
	
	
}

//随着下拉框改变部门经理
function changeDepManagerById(obj){
	//alert(obj.find("option:selected").val());
	 var $upDepManager=$("#upDepManager");
	 var $addDepManager=$("#addDepManager");
	$.ajax({
        url:"employeeServlet",//要请求的服务器url
        //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取
        //data:{method:"ajaxTest",val:value},
        data:{flag:9,depId:obj.find("option:selected").val()},  //这里的email对应表单中的name="email"，也是发送url中的email=value(GET方式)
        async:true,   //是否为异步请求
        cache:false,  //是否缓存结果
        type:"POST", //请求方式为POST
        dataType:"json",   //服务器返回的数据是什么类型
        success:function(dep){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型)
          //alert(dep.depManager);
          $upDepManager.val(dep.depManager);
          $addDepManager.val(dep.depManager);
        }
    });
	
}



$(function(){
	loadAllRoles();//加载所有的职位
	loadAllDepartments();//加载所有的部门
	loadAllDepManagers();//加载所有的部门经理信息
	sendAjaxRequestToEmployeeServletToGetAllEmployees(1);//加载所有的员工信息
	
	/*$(".saveEmployee").show();
	$(".employee-op").show();
	*/
	$("#searchByDate").click(function(){
		var start=$("#startDate").val();
		var end=$("#endDate").val();
		if(start!=""&&end!=""){
			//alert(start+"-->"+end);
			searchEmployeeByEntryDateInterval(1,start,end);
		}else{
			alert("请选择日期!");
		}
	});
	
	
	//添加员工出现弹出窗口
	
		
	
	
	$(".close").on('click',function(){
		$(".zhezhao").hide();
		$(".renyuan-op").hide();
		$(".add-op").hide();
		/*$(".saveEmployee").hide();
		$(".employee-op").hide();*/
	});
});
