<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'qiandao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  </head>
  
  <body>
  <div class="m_content">
  <div class="layuimini-container">
	<div class="layuimini-main">
		<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">
			<div class="layui-input-inline"><input type="text" name="uname" id="likename" class="layui-input" placeholder="请输入查找的登录名" />
				</div>
			</div>
			<div class="layui-inline">
			<button type="button" class="layui-btn" lay-filter="doSubmit" id="doSubmit">
		            <i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
				</button>
			</div> 
			<input type="text" id="loginName" value="${user.id }" style="display:none"/>
		</blockquote> 
		
		
			
			
			
				<script type="text/html" id="toolbarDemo">
	     	     <c:forEach var="prod" items="${list}">
		            ${prod.mbtn}
                  
		         </c:forEach>
               </script>
		
			
			
			
			
	
		
		
		<!--    <span id="btns"></span> -->
		
	
	</div>
		<table id="newsList" lay-filter="newsList"></table>
</div>
	
	
	
	<!-- 分配角色 -->
	<div style="height: 400px;overflow: auto;display: none;" id="hairRole">
		<select name="Roleid" id="RoleName" lay-filter="RoleName">
	      	
		</select>
	</div>
	
	
	
	
	</div>
	
	
		
		
		
		
		<!-- <script>
			layui.use('table', function() {
				var table = layui.table;
		
				//第一个实例
				table.render({
					elem : '#newsList',
					url : 'news?action=yonghu' //数据接口
					,
					page : true //开启分页
					,
					cols : [ [ {
						fixed : "left",
						type : "checkbox",
						width : 50,
					}, {
						field : 'id',
						title : '序列号',
						align : 'center'
					}, {
						field : 'userName',
						title : '真实姓名',
						minWidth : 100,
						align : "center"
					}, {
						field : 'password',
						title : '密码',
						align : 'center'
					}, {
						field : '性别',
						title : 'sex',
						align : 'center',
						templet:function(d){
                        return d.sex == "1" ? "男" : "女";
						
						}
		
					} ] ],
					done : function(d) {
						d.data.forEach(function(item, i) {
							$("#btns").append(item.mbtn);
						})
					}
		
				});
		
			});
		</script>
   -->
  
  </body>
</html>
