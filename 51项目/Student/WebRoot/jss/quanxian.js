layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}����˼������������·������������ base ·��
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    
    	      
    /*------------- �����û���� --------------------------------*/
    var tableIns = table.render({
        elem : '#newsList',
        url : 'news?action=qops',
        page : true,
        toolbar: '#toolbarDemo',
        method : "post",
        title : '菜单管理',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols: [[
                {type: 'radio' },
                {field: 'id', title: '权限编号'},
                {field: 'mname', title: '权限名称'},
                {field: 'mfatherid', title: '父类id'},
                {field: 'isMenu', width: 80, align: 'center', title: '类型', templet: function (d) {
                        if (d.type == 3) {
                            return '<span class="layui-badge layui-bg-orange">按钮</span>';
                        }
                        if (d.parentId == -1) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } else {
                            return '<span class="layui-badge layui-bg-green">菜单</span>';
                        }
                }}
            ]]
	  ,done:function(d){
	  		d.data.forEach(function(item,i){
	  			$("#btns").append(item.mbtn);
	  			}
			)
	  	}
    });
    /*------------- �����û���� --end------------------------------*/
  

    /*-------- �����û� ----------------------------*/
    $("#doSubmit").click(function(){
   
    	var like = $("#likename").val()
    	 tableIns.reload({
	      url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,
	      page: {
	        curr: 1 //���´ӵ� 1 ҳ��ʼ
	      }
	    });
    })
    
  //工具栏事件
	  table.on('toolbar(newsList)', function(obj){
		  
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	   
	    switch(obj.event){
	      case 'hairMenu':	//分配权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	      
	      case 'addUser':	//新增用户
	    	  addUser();
	      break;
	      
	      case 'hairRole':	//分配角色
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					//HairRole(userid);
				}
	      break;
	      
	      case 'upUser':	//修改用户信息
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作");
					return ;
				}else{
					upUser(userid);
				}
	      break;
		        
	      case 'deddddlUser':	//删除用户
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作");
					return ;
				}else{
					layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
						var loginName = $("#loginName").val();
						if(userid == loginName){
							layer.msg("你正在登录当前账号,无法删除")
						}else{
							deddddlUser(userid);
							layer.close(index);
						}
		            });
				}
	      break;
	    };
	  });
  
  //修改用户
  function upUser(userid){
  	
  	layui.layer.open({
  		title : "修改用户信息",
  		type : 2,
  		content : "/Student/jsp/caidan/menuInfo.jsp",
  		area:['800px','800px'],
  		success:function(layero, index){
  			$.ajax({
  				url:"/Student/news?action=caidanlistxiugai",
  				type:"post",
  				data:{"userid":userid},
  				success:function(data){
  					alert(data);
  					var info = eval('(' + data + ')');
        				var body = layui.layer.getChildFrame('body', index);
		                body.find("#mid").val(info.data.id);
          				body.find("#mname").val(info.data.mname);  //权限名
          				body.find("#mfunction").val(info.data.mfunction);	//请求路径
          				var select = 'dd[lay-value='+info.data.type+']';
          				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
          				body.find("#mbtn").val(info.data.mbtn);		//按钮代码
          				body.find("#icon").val(info.data.icon);		//icon图标
  					
          				var menuid3 = info.data.mfatherid;
          				
          				//上级的下拉框
             			 $.post("/Student/news?action=caidanlistxiugai",{"userid":menuid3},function(res){
         					var cs = eval('(' + res + ')');
 		                    body.find("#fatherType2").val(cs.data.mname);
 		                 
             			 })

  					
  					/*------下拉框赋值--------*/
  				$.ajax({
  						  url:"/Student/news?action=jiaoyuan",
  						  type:"post",
  						  success:function(data){
  							  var info = eval("("+data+")");
  							  var row =info.data;
  							  var role = body.find("#role1");
  							  $.ajax({
  								  url:"/Student/news?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
  								  data:{"userid":userid},
  								  type:"post",
  								  success:function(data){
  									  if(data == 0){
  										  var html = '<option value="0">无角色</option>';
  									  }else{
  										  var html = '';
  									  }
  	    							  $.each(row,function(index,item){
  	    								  html += '<option value="'+item.id+'">'+item.jiaoname+'</option>';
  	    								
  	    								  
  	    							  });
  	    							  role.html(html);
  	    							//获取新窗口对象
  			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
  			                        //重新渲染
  			                        iframeWindow.layui.form.render();
  								  }
  							  })
  							  
  						  }
  					  })
  					  /*------下拉框赋值--------*/
  					//赋值后选中
  				/*$.ajax({
  						url:"/MenuTest/RoleServlet?action=allRoleUserid",
  						type:"post",
  						data:{"userid":userid},
  						success:function(data){
  							var info2 = eval("("+data+")")
  							if(info2 == 0){
  								var select = 'dd[lay-value="0"]';
      							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
  							}else{
  								var select = 'dd[lay-value='+info2.data.roleid+']';
      							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
  							}
  						}
  					})*/
                      //获取新窗口对象
                      var iframeWindow = layero.find('iframe')[0].contentWindow;
                      //重新渲染
                      iframeWindow.layui.form.render();
  				}
  			})
  		}
  	})
  }
  
  
  
  
  
  
  
  
  
  
  //删除用户
  function deddddlUser(userid){
  	$.ajax({
  		url:"/Student/news?action=delete",
  		data:{"userid":userid},
  		type:"post",
  		success:function(data){
  			if(data == 1){
  				layer.msg("删除成功");
  				tableIns.reload("#newsList");
  			}
  		}
  	})
  }
  
  
  
  
  
  
  
  
/*    //分配角色
  function HairRole(userid){
  	layer.open({
  		type:1,
  		title:"分配角色",
  		area:['200px','100px'],
  		content:$('#hairRole'),
  		success:function(){
  			//查询全部角色
  	    	$.ajax({
  	    		url:"/MenuTest/RoleServlet?action=hairRole",
  	    		type:"post",
  	    		dataType:"json",
  	    		success:function(data){
  	    			
  	    		}
  	    	})
  		}
  	})
  }*/
  
  //新增用户
  function addUser(){
  	layui.layer.open({
  		title : "添加用户",
  		type : 2,
  		content : "/Student/jsp/caidan/menuAdd.jsp",
  		area:['800px','890px'],
  	})
  }
  
   

})