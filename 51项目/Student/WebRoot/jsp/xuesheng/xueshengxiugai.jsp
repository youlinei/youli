<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>新增角色</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
  
    <div class="layui-form-item">
	    <label class="layui-form-label">id</label>
	    <div class="layui-input-inline">
	      	<input type="text" name="id" id="id" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  


	  <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-inline">
	      	<input type="text" name="name" id="name" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	
	  
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">登陆名</label>
	    <div class="layui-input-inline">
	      	<input type="text" name="loginname" id="loginname" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-inline">
	      	<input type="text" name="password" id="password" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	 
	 <div class="layui-form-item">
    <label class="layui-form-label">班级名</label>
    <div class="layui-input-inline">
      <select name="role1" id="role1" lay-filter="role1">
		
      </select>
   </div>
  </div>
	  
	  <br/><br/>
	  <div class="layui-form-item">
	    	<button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addRole">新增角色</button>
	  </div>
</form>
<script type="text/javascript">
			var contextPath = "${ctx}";
		</script>

<script type="text/javascript" src="${ctx}/jss/jquery.js"></script>
<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/jss/xueshengxiugai.js"></script>

</body>
</body>
</html>