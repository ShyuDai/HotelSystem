<%@ page import="com.hs.utils.PageResult" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/9/20
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>

        $.post("maniyGetGoodsServlet",null,function (data) {
            console.log(data);
            $.each(data,function (i,good) {
                $("#goods").append(good.gname+"<input class='roomservice' type='text' name='"+good.gcount+"'>");
            })

        },"json");


            function save() {

               var $name =$("#name").val();
               var $roomnumber=$("#roomnumber").val();
               var $roomtypeid=$("#type > option:selected").val();
               var goods=[];
               $(".roomservice").each(function (i,good) {
                    console.log(good.name+" : "+good.value)
                    goods=goods+good.name+":"+good.value+",";
               });

                $.post("maniySaveRoomService",{name:$name,roomnumber:$roomnumber,roomtypeid:$roomtypeid,goods:goods},function (data) {
                    console.log(data);
                    if(data==1){

                    }
                },"json");

            };




    </script>
</head>

<body data-type="Room-service.html">


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
                                <a href="Customer-service.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>顾客查询</span>
                                </a>
								<a href="Room-service.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>房间查询</span>
                                </a>
                                <a href="Employee-service.html">
                                    <i class="am-icon-angle-right"></i>
                                    <span>人员调控</span>
                                </a>  
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-user"></i>
                            <span>&nbsp;财务界面</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="HistoryServlet?currentPage=1&flag=1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>历史用户信息</span>
                                </a>

                                <a href="OrderInfoYzwServlet?currentPage=1&flag=4">
                                    <i class="am-icon-angle-right"></i>
                                    <span>盈利状况</span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                            <i class="am-icon-users"></i>
                            <span>后勤界面</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="maniyGetRoomServlet">
                                    <i class="am-icon-angle-right"></i>
                                    <span>清洁房间</span>
                                </a>

                                <a href="maniyGetRoomServiceServlet" class="active">
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

            客户名称：<input type="text" name="name" id="name">

            房间编号：<input type="text" name="roomnumber" id="roomnumber">
            <br>
            房间类型：
            <select id="type">
                <option value="1" selected="selected">标准大床间</option>
                <option value="2">豪华商务标间</option>
                <option value="3">温馨家庭间</option>
                <option value="4">豪华娱乐间</option>
            </select>
            <br>
            <div id="goods">
            <%--方便面<input class="roomservice" type="text" name="1">--%>
            <%--怡宝水<input class="roomservice" type="text" name="2"><br>--%>
            <%--卫龙辣条<input ttype="text" name="goods">--%>
            <%--刮胡刀<input type="text" name="goods"><br>--%>

            <%--毛巾<input type="text" name="goods"><br>--%>
            </div>
            <button type="button" id="btn" onclick="save()" >提交</button>

            <hr>


            <table id="tb" border="1">
                <tr>

                    <td>服务对象</td>
                    <td>房间编号</td>
                    <td>房间类型</td>
                    <td>服务名称</td>
                    <td>服务总价</td>
                    <td>服务时间</td>
                    <td>服务人员</td>

                </tr>
                <c:forEach var="roomService" items="${pageResult.list}" varStatus="index">
                    <tr>

                        <td>${roomService.name}</td>
                        <td>${roomService.roomnumber}</td>
                        <td>${roomService.roomtypename}</td>
                        <td>${roomService.servicename}</td>
                        <td>${roomService.servicetotalprice}</td>
                        <td>${roomService.servicetime}</td>
                        <td>${roomService.empnumber}</td>
                    </tr>
                </c:forEach>
            </table>
            <hr>
            <%
                PageResult pageResult = (PageResult) request.getAttribute("pageResult");
                int pageNO =pageResult.getPageNo();
                int pageCount =pageResult.getPageCount();

                int start =pageNO-5<= 0?1:pageNO-5;
                int end= start+10<pageCount? start+10: pageCount;

                if(pageNO >1){
            %>
            <a href="maniyGetRoomServiceServlet?pageNo=1">首页</a>
            <a href="maniyGetRoomServiceServlet?pageNo=<%=pageNO-1%>">上一页</a>

            <%
                }
                for(int i=start;i<end;i++){
            %>
            <a style="color:<%=(i==pageNO?"red":"")%>" href="maniyGetRoomServiceServlet?pageNo=<%=i%>">第<%=i%>页</a>
            <%
                }
                if(pageNO<pageCount){
            %>
            <a href="maniyGetRoomServiceServlet?pageNo=<%=pageNO+1%>">下一页</a>
            <a href="maniyGetRoomServiceServlet?pageNo=<%=pageCount%>">末页</a>

            <%
                }
            %>


            <form action="maniyGetRoomServiceServlet">
                第<input type="text"name="pageNo" value="${pageResult.pageNo}">页
                <input  type="submit" value="确定">
            </form>

            一共有<span>${pageResult.toatalCount}</span>条记录

        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>