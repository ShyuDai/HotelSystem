<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>魔方酒店</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!-- <link rel="icon" type="image/png" href="assets/i/favicon.png"> -->
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <!-- <script src="assets/js/echarts.min.js"></script> -->
    <style>
        body{overflow:scroll;}
        body{overflow-y:scroll;}
        #his
        {
        	width: 1200px;
        	height:400px;
        	margin: 0 auto;
        }
        table td
        {
        	width: 200px;
        }
        form
        {
        	display:inline-block;
        	width: 472px;
        }
    </style>
    <script type="text/javascript">
    function base64 (content) {
       return window.btoa(unescape(encodeURIComponent(content)));         
    }
    function exportOffice(dom,tableID,fName){
            var type = 'excel';
            var table = document.getElementById(tableID);
            var excelContent = table.innerHTML;
            var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:"+type+"' xmlns='http://www.w3.org/TR/REC-html40'>";
            excelFile += "<head>";
            excelFile += "<meta http-equiv=Content-Type; content=text/html;charset=UTF-8>";
            excelFile += "<!--[if gte mso 9]>";
            excelFile += "<xml>";
            excelFile += "<x:ExcelWorkbook>";
            excelFile += "<x:ExcelWorksheets>";
            excelFile += "<x:ExcelWorksheet>";
            excelFile += "<x:Name>";
            excelFile += "{worksheet}";
            excelFile += "</x:Name>";
            excelFile += "<x:WorksheetOptions>";
            excelFile += "<x:DisplayGridlines/>";
            excelFile += "</x:WorksheetOptions>";
            excelFile += "</x:ExcelWorksheet>";
            excelFile += "</x:ExcelWorksheets>";
            excelFile += "</x:ExcelWorkbook>";
            excelFile += "</xml>";
            excelFile += "<![endif]-->";
            excelFile += "</head>";
            excelFile += "<body><table>";
            excelFile += excelContent;
            excelFile += "</table></body>";
            excelFile += "</html>";
            var base64data = "base64," + base64(excelFile);
            switch(type){
                case 'excel':
                    dom.href ='data:application/vnd.ms-'+type+';'+base64data;;//必须是a标签，否则无法下载改名
                    dom.download = fName;
                break;
            }
    }
</script>
</head>

<body data-type="The-profitability.html">


       <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
                <b> &nbsp; &nbsp; &nbsp; &nbsp;Hotel Management</b> <i class="am-icon-skyatlas"></i>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">                 
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">酒店管理员</span><span class="tpl-header-list-user-ico"> <img src="assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <!-- <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li> -->
                        <!-- <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li> -->
                        <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <!-- <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li> -->
            </ul>
        </div>
    </header>







    <div class="tpl-page-container tpl-page-header-fixed">


        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                请进入相应身份模块
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="index.html" class="nav-link">
                            <i class="am-icon-home"></i>
                            <span>&nbsp;首页</span>
                        </a>
                    </li>
                    <!-- <li class="tpl-left-nav-item">
                        <a href="chart.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-bar-chart"></i>
                            <span>数据表</span>
                        </a>
                    </li>
 -->
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-user-secret"></i>
                            <span>&nbsp;经理界面</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="Query-information.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>查询信息</span>
                                </a>

                                <a href="Personnel-control.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>人员调控</span>
                                </a>  
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                            <i class="am-icon-user"></i>
                            <span>&nbsp;财务界面</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="HistoryServlet?currentPage=1&flag=1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>历史用户信息</span>
                                </a>

                                <a href="OrderInfoYzwServlet?currentPage=1&flag=4" class="active">
                                    <i class="am-icon-angle-right"></i>
                                    <span>盈利状况</span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-users"></i>
                            <span>后勤界面</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="maniyGetRoomServlet">
                                    <i class="am-icon-angle-right"></i>
                                    <span>清洁房间</span>
                                </a>

                                <a href="maniyGetRoomServiceServlet">
                                    <i class="am-icon-angle-right"></i>
                                    <span>客房服务</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    
                    <li class="tpl-left-nav-item">
                        <a href="Reception.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>&nbsp;前台界面</span>
                            <!-- <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i> -->
                        </a>
                        <!-- <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="#">
                                    <i class="am-icon-angle-right"></i>
                                    <span>预定</span>
                                </a>

                                <a href="#">
                                    <i class="am-icon-angle-right"></i>
                                    <span>入住</span>
                                </a>
                                <a href="#">
                                    <i class="am-icon-angle-right"></i>
                                    <span>换房</span>
                                </a>
                                <a href="#">
                                    <i class="am-icon-angle-right"></i>
                                    <span>退房</span>
                                </a>        
                            </li>                            
                        </ul> -->
                    </li>

                    
                    <!-- <li class="tpl-left-nav-item">
                        <a href="login.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-key"></i>
                            <span>登录</span>

                        </a>
                    </li> -->
                </ul>
            </div>
        </div>





        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                <form action="OrderInfoYzwServlet?currentPage=1&flag=5" method="post">
            		<input type="text" name="select" value="" placeholder="请输入用户名或身份证号"><input type="submit" value="查询">
            	</form>
            	<form action="OrderInfoYzwServlet?currentPage=1&flag=2" method="post">
            		<span>开始时间：</span><input id="" name="starttime" type="date"/>
            		<span>结束时间：</span><input id="" name="endtime" type="date"/>
            		<input class="mingxi-b1" type="submit" value="查询已完成订单">
            	</form>
            	<form action="OrderInfoYzwServlet?currentPage=1&flag=3" method="post"><input class="mingxi-b1" type="submit" value="查询未完成订单"></form>
            	<a onClick="exportOffice(this,'his','excel下载')" href="javascript:void(-1)">
					<input id="Button1" type="button" value="导出" />
				</a>
            	<table id="his">
                	<tr> 
                		<td>编号&nbsp;&nbsp;</td><td>客户姓名&nbsp;&nbsp;</td><td>房间类型&nbsp;&nbsp;</td><td>入住时间&nbsp;&nbsp;</td><td>退房时间&nbsp;&nbsp; </td>
                		<td>房间价格&nbsp;&nbsp;</td><td>住房消费&nbsp;&nbsp;</td><td>服务费&nbsp;&nbsp;</td><td>消费总计</td>
                	</tr>
                	<c:forEach items="${pageHelper.rows}" var="ph" varStatus="idx"> 
                		<tr>
							<td>${(pageHelper.currentPage-1)*pageHelper.pageSize+idx.count}</td>
							<td>${ph.customername}</td>
							<td>${ph.roomtypename}</td>
							<td>${ph.checkintime}</td>
							<td>${ph.checkouttime}</td>
							<td>${ph.roomprice}</td>
							<td>${ph.roomtotalprice}</td>
							<td>${ph.servicetotalprice}</td>
							<td>${ph.servicetotalprice + ph.roomtotalprice}</td>
						</tr>
                	</c:forEach>
                </table>
            </div>
        </div>
	<div id="pagehelper" align="center">
		<c:if test="${requestScope.pageHelper.currentPage==1}">
			首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上一页
		</c:if>
		<c:if test="${requestScope.pageHelper.currentPage>1}">
			<a href="OrderInfoYzwServlet?currentPage=1&flag=4">首页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="OrderInfoYzwServlet?currentPage=${requestScope.pageHelper.currentPage-1}&flag=4">上一页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 第${requestScope.pageHelper.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if
			test="${requestScope.pageHelper.currentPage<requestScope.pageHelper.totalPage}">
			<a href="OrderInfoYzwServlet?currentPage=${requestScope.pageHelper.currentPage+1}&flag=4">下一页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="OrderInfoYzwServlet?currentPage=${requestScope.pageHelper.totalPage}&flag=4">尾页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${requestScope.pageHelper.currentPage==requestScope.pageHelper.totalPage}">
			下一页&nbsp;&nbsp;&nbsp;&nbsp;尾页
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.totalPage}页
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.total}条数据

	</div>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>