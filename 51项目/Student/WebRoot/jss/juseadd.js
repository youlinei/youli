layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;



  var myDate=new Date();
  var time=myDate.getFullYear() + '-' + parseInt(myDate.getMonth() + 1) + '-' + myDate.getDate();
  
  $("#tijiao").click(function(){
	  var rname = $("#rname").val();
	
	  var data = {
			  "rname":rname,
	  }
	
	  
	  $.ajax({
	  		url:"/Student/news?action=jueseadd",
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
