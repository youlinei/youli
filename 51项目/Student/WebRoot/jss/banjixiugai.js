layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;



  var myDate=new Date();
  var time=myDate.getFullYear() + '-' + parseInt(myDate.getMonth() + 1) + '-' + myDate.getDate();
  
  $("#tijiao").click(function(){
	  var id = $("#id").val();
	  var rname = $("#rname").val();
	  var role = $("select[name='role1']").val();
	  var data = {
			  "id":id,
			  "rname":rname,
			  "role":role,
			 
	  }
	  $.ajax({
	  		url:"/Student/news?action=banjiupdate",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("�޸ĳɹ�");
					setTimeout(function(){
						layer.closeAll("iframe");
			            //ˢ�¸�ҳ��
			            parent.location.reload();
		        	},1000);
				}else{
					layer.msg("�޸�ʧ��");
				}
				
			}
	  })
	  return false;
  })
  
});
