<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'juese.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" href="layui/css/layui.css"> -->

<link rel="stylesheet" href="layui/css/layui.css">

<link rel="stylesheet" href="css/public.css" media="all">
</head>


<body class="childrenBody">

	<div class="m_content">

		<div class="layuimini-container">
			<div class="layuimini-main">
				<blockquote class="layui-elem-quote quoteBox">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="text" name="uname" id="likename" class="layui-input"
								placeholder="请输入查找的登录名" />
						</div>
					</div>
					<div class="layui-inline">
						<button type="button" class="layui-btn" lay-filter="doSubmit"
							id="doSubmit">
							<i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
						</button>
					</div>
					<input type="text" id="loginName" value="${user.id}"
						style="display:none" />
				
				</blockquote>
			</div>

 
			<script type="text/html" id="toolbarDemo">
	     	      <c:forEach var="prod" items="${list}">
		            ${prod.mbtn}
		          </c:forEach>
            </script>  

		<table id="newsList" lay-filter="newsList"></table>


		<!-- 分配权限 -->
		<div style="height: 400px;overflow: auto;display: none;" id="dtree1">
			<ul id="dataTree3" class="dtree" data-id="0"></ul>
		</div>

		<!-- 分配角色 -->
		<div style="height: 400px;overflow: auto;display: none;" id="hairRole">
			<select name="Roleid" id="RoleName" lay-filter="RoleName">
			</select>
		</div>
		
		
		
	</div>
</div>
		<script type="text/javascript">
			var contextPath = "${ctx}";
		</script>
		<script src="jss/jquery.js"></script>
		<script src="layui/layui.js"></script> 
</body>
</html>





















































<!-- 	<script type="text/javascript" src="jss/jquery-1.8.2.min.js"></script> -->
<!-- 	<script type="text/javascript" src="layui/layui.js"></script> -->




<!-- 	<script type="text/javascript">
	layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    
    	      
    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({	
        elem : "#newsList",
        url : "news?action=oop&id=1",
        title : "菜单管理",
        height: "full-145",
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: "mname", title: "菜单名称",  align:"center"},
            {field: "type", title: "菜单类型", minWidth:100, align:"center"},
            {field: "url", title: "url地址",  align:"center"},
            {field: "mbtn", title: "描述", align:"center"}
        ]]
        
    });
	
	})
	
	
	
	
	
	 -->























<!-- 	<script type="text/javascript">
	layui.use(['form','layer','laydate','table','laytpl','dtree','jquery'],function(){
	 var $ = layui.jquery;
	 var table=layui.table;
	});
	table.render({
	elem : "#newsList",
	url : '/news?action=oop&id=1',
        // toolbar: '#toolbarDemo',
        page : true,
        title : '菜单管理',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'mname', title: '菜单名称',  align:'center'},
            {field: 'type', title: '菜单类型', minWidth:100, align:"center"},
            {field: 'url', title: 'url地址',  align:'center'},
            {field: 'mbtn', title: '描述', align:'center'}
        ]]
	})
	
	</script>
 -->



























<!-- script type="text/javascript">
	
	layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    
    	      
    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem : '#newsList',
        url : 'layui/news?action=oop',
        page : true,
        method : "post",
        title : '菜单管理',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'mname', title: '菜单名称',  align:'center'},
            {field: 'type', title: '菜单类型', minWidth:100, align:"center"},
            {field: 'url', title: 'url地址',  align:'center'},
            {field: 'mbtn', title: '描述', align:'center'}
        ]]
    });
	</script>  -->







