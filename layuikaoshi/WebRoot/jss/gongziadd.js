layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  

  

  
  
  $("#tijiao").click(function(){
	  var name = $("#uname").val();
	  var money = $("#money").val();
	 
	  var data = {
			  "uname":name,
			  "money":money,
		
	  }

	  $.ajax({
	  		url:"/layuikaoshi/news?action=gongziinsert",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("�ɹ�");
				       layer.closeAll("iframe");
					 
			           parent.location.reload();
				}else{
					layer.msg("ʧ��");
				}
				
			}
	  })
	  return false;
  })
  
});
