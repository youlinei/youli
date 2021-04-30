<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<%-- <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 管理系统大布局 - Layui</title>

 
	<link rel="stylesheet" href="${ctx}/css/public.css" media="all" />
	<link rel="stylesheet" href="${ctx}/js/lay-module/layui_ext/dtree/dtree.css"/>
  	<link rel="stylesheet" href="${ctx}/js/lay-module/layui_ext/dtree/font/dtreefont.css">
<link rel="stylesheet" href="layui/css/layui.css">
</head>

<script type="text/javascript">
		var contextPath = "${ctx}";
	</script>
	
	
	<script type="text/javascript" src="${ctx}/jss/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/jss/jup.js"></script>
	<%-- <script type="text/javascript" src="${ctx}/jss/userList1.js"></script> --%>
	<!-- 
	<script type="text/javascript">
	function news(url,id,js,uid){
	
	 $(".m_content").load(url+"&id="+id+"&&uid="+uid,function(){
         var sc =  document.createElement("script");
         sc.src= js; //是你数据表格的js
         $(".m_content").append(sc);
      })
	
	  var item={
	  id:id
	  };
   

	  
/* 	  
	 $(".m_content").load(contextPath + "/" + url + " .m_content>*",item,function(){
	
		
	  var sc = document.createElement("script");
	  sc.src=js;
	  
	  $(".m_content").append(sc);
	  }) */
	  
	  
	  }
	
	
	
	</script> -->
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo"><font face="Agency FB">欢迎你,Admin</font></div>
			<!-- 头部区域（可配合layui 已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">

			</ul>
			<font face="Agency FB"><br></font>
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><font face="Agency FB"><a href="">nav 3</a></font></li>
				<li class="layui-nav-item"><font face="Agency FB"><a href="javascript:;">nav 
						groups</a></font>
					<dl class="layui-nav-child">
						<dd>
							<a href="">menu 11</a>
						</dd>
						<dd>
							<a href="">menu 22</a>
						</dd>
						<dd>
							<a href="">menu 33</a>
						</dd>
					</dl>
				</li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><font face="Agency FB"><a href="javascript:;"> <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img"> tester </a></font>
					<dl class="layui-nav-child">
						<dd>
							<a href="">set 1</a>
						</dd>
						<dd>
							<a href="">set 2</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item"><font face="Agency FB"><a href="">Sign out</a></font></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">

					<c:forEach var="prod" items="${list}">

						<li class="layui-nav-item layui-nav-itemed"><c:if
								test="${prod.mfatherid==0}">
								<font face="Agency FB"><a href="javascript:;">${prod.mname}</a></font>
								<dl class="layui-nav-child">
									<c:forEach var="prods" items="${list}">
										<c:if test="${prods.mfatherid==prod.id}">
											<dd>
												<%--   <a href="/layui/news?action=oop&id=1">${prods.mname}</a>  --%>
												<a href="javascript:;" onclick="news('${prods.url}','${prods.id}','${prods.js}','${easybuyUserLogin.id }')">${prods.mname}</a>
											   
											  <input type="hidden" name="kks"  id="kk"value="${easybuyUserLogin.id }">
											</dd>
										</c:if>
									</c:forEach>
								</dl>
							</c:if>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>

		<div class="layui-body">

			<div style="padding: 15px;">

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
	
		 	
		 	 
			 

			</div>
		</div>

		<div class="layui-footer">底部固定区域</div>
	</div>



	


	
	<%-- <script type="text/javascript" src="${ctx}/jss/login.js"></script> --%>
















<!-- <script type="text/javascript">
		function news(url, id) {
			var item = {
				"id" : id
			};

			$(".m_content").load(contextPath + "/" + url + " .m_content>*",
					item, function() {
						 var sc = document.createElement("script");
						 sc.src= "jss/userList.js";  //是你数据表格的js
						  $(".m_content").append(sc); 

					});
		}
	</script>  -->












	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
<div style="height: 400px;overflow: auto;display: none;" id="dtree1" >
	  <ul id="dataTree3" class="dtree" data-id="0"></ul>
	</div>
</html>