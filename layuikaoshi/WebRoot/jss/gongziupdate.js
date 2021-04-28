layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  


  $("#tijiao").click(function(){
	  var mid = $("#mid").val();
	  var name = $("#uname").val();
	  var money = $("#money").val();
	 
	  var data = {
			  "mid":mid,
			  "uname":name,
			  "money":money,
		
	  }

	  $.ajax({
	  		url:"/layuikaoshi/news?action=gongzixiugai",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("ÐÞ¸Ä³É¹¦");
				       layer.closeAll("iframe");
					 
			           parent.location.reload();
				}else{
					layer.msg("Ê§°Ü");
				}
				
			}
	  })
	  return false;
  })
  
});
