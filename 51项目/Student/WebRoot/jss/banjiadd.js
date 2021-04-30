layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

 $.ajax({
	  url:"/Student/news?action=jiaoyuan",
	  type:"post",
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.jiaoname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  

  var myDate=new Date();
  var time=myDate.getFullYear() + '-' + parseInt(myDate.getMonth() + 1) + '-' + myDate.getDate();
  
  $("#tijiao").click(function(){
	  var rname = $("#rname").val();
	  var role = $("select[name='role1']").val();
	  var data = {
			  "rname":rname,
			  "role":role,
			  "time":time,
	  }
	
	  
	  $.ajax({
	  		url:"/Student/news?action=banjiadd",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("添加成功");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //刷新父页面
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
				
			}
	  })
	  return false;
  })
  
});
