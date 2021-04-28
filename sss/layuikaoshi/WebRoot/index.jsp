<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="d.nh">
                <div>
                    <label >用户名：</label>
                    <input id="user" type="text" class="l_user" name="username" placeholder="请输入用户名" required/>
                </div>
                <div >
                    <label >密码：</label>
                    <input id="mima" type="password"  class="l_pwd"name="pwd" placeholder="请输入密码" required/>
                </div>
                <div >
                   <button type="reset" class="layui-btn layui-btn-warm">重置</button>
                   <button type="submit" class="layui-btn layui-btn-normal" value="登陆" >登陆</button>
                </div>

    </form>
  </body>
</html>
