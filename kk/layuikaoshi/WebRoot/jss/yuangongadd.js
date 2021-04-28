layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  $.ajax({
	  url:"/layuikaoshi/news?action=allRole1",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
    $.ajax({
	  url:"/layuikaoshi/news?action=allRole3",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role2");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  
    $.ajax({
	  url:"/layuikaoshi/news?action=allRole2",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role3");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.name+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  
 
  

  
  
  $("#tijiao").click(function(){
	  var name = $("#uname").val();
	  var role1 = $("select[name='role1']").val();
	  var role2 = $("select[name='role2']").val();
	  var role3 = $("select[name='role3']").val();
	  var data = {
			  "uname":name,
			  "role1":role1,
			  "role2":role2,
			  "role3":role3,
	  }
/*	  if(name.length<3){
		  layer.alert("��¼����С��3λ��")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('�������6��12λ���Ҳ��ܳ��ֿո�');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('�û�����Ϊ��');
		  return false;
	  }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
		  layer.alert("�����ʽ����ȷ������������");
		  return false;
	  }else if(phone.length != 11){
		  layer.alert("�ֻ��ʽ����ȷ! ����������");
		  return false;
	  }else if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("��¼�˺��Ѵ���! ����������")
			  return false;
		  }
	  }*/
	  $.ajax({
	  		url:"/layuikaoshi/news?action=yuangonginsert",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("添加成功");
				       layer.closeAll("iframe");
					   tableIns.reload("#newsList");
			           parent.location.reload();
				}else{
					layer.msg("失败");
				}
				
			}
	  })
	  return false;
  })
  
});
