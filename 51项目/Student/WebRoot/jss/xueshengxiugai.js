layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;



  var myDate=new Date();
  var time=myDate.getFullYear() + '-' + parseInt(myDate.getMonth() + 1) + '-' + myDate.getDate();
  
  $("#tijiao").click(function(){
	  var id = $("#id").val();
	  var loginname = $("#name").val();
	  var name = $("#name").val();
	  var password = $("#password").val();
	  var role = $("select[name='role1']").val();
	  var data = {
			  "id":id,
			  "name":name,
			  "loginname":loginname,
			  "password":password,
			  "role":role,	 
	  }
	  $.ajax({
	  		url:"/Student/news?action=xueshengxiugai",
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
					layer.msg("修改失败");
				}
				
			}
	  })
	  return false;
  })
  
});
