layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

 /* $.ajax({
	  url:"/MenuTest/RoleServlet?action=allRole",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.rname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })*/
  
 
  
  
  $("#tijiao").click(function(){
	  var id=$("#id").val();
	  var uname = $("#uname").val();
	  var role1 = $("select[name='role1']").val();
	  var role2 = $("select[name='role2']").val();
	  var role3 = $("select[name='role3']").val();
	  var data = {
			  "id":id,
			  "uname":uname,
			  "role1":role1,
			  "role2":role2,
			  "role3":role3,
	  }
/*	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('密码必须6到12位，且不能出现空格');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('用户名不能为空');
		  return false;
	  }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
		  layer.alert("邮箱格式不正确！请重新输入");
		  return false;
	  }else if(phone.length != 11){
		  layer.alert("手机格式不正确! 请重新输入");
		  return false;
	  }else if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
			  return false;
		  }
	  }*/
	  $.ajax({
	  		url:"/layuikaoshi/news?action=yuangongxiugai",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("修改成功");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("失败");
				}
				
			}
	  })
	  return false;
  })
  
});
