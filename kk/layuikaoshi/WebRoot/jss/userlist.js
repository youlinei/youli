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
        url : 'news?action=aops',
        page : true,
        toolbar: '#toolbarDemo',
        method : "post",
        title : '�û�����',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed: "left",type: "checkbox", width:50},
            {field: 'id', title: 'id',  align:'center'},
            {field: 'name', title: '姓名',  align:'center'},
            {field: 'bumen', title: '部门', Width:100, align:"center"},
            {field: 'zhicheng', title: '职称',  align:'center'},
            {field: 'jname', title: '角色', align:'center'}
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
    		content : "/layuikaoshi/jsp/user/userInfo.jsp",
    		area:['400px','540px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"/layuikaoshi/news?action=yuangonchaxn",
    				type:"post",
    				data:{"userid":userid},
    				success:function(data){
    					var info = eval('(' + data + ')');
          				var body = layui.layer.getChildFrame('body', index);
          				
          			   body.find("#id").val(info.data.id);			
     			        body.find("#uname").val(info.data.name);
    					
    					
    			
    				
    			
    		
    					
    					
    					
    					/*------下拉框赋值--------*/
    				$.ajax({
    						  url:"/layuikaoshi/news?action=allRole1",
    						  type:"post",
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row =info.data;
    							  var role = body.find("#role1");
    							  $.ajax({
    								  url:"/layui2/news?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
    								  data:{"userid":userid},
    								  type:"post",
    								  success:function(data){
    									  if(data == 0){
    										  var html = '<option value="0">无角色</option>';
    									  }else{
    										  var html = '';
    									  }
    	    							  $.each(row,function(index,item){
    	    								  html += '<option value="'+item.id+'">'+item.name+'</option>';
    	    								  
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
    					  
    					  
    					  
    					  
    					  		$.ajax({
    						  url:"/layuikaoshi/news?action=allRole2",
    						  type:"post",
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row =info.data;
    							  var role = body.find("#role3");
    							  $.ajax({
    								  url:"/layui2/news?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
    								  data:{"userid":userid},
    								  type:"post",
    								  success:function(data){
    									  if(data == 0){
    										  var html = '<option value="0">无角色</option>';
    									  }else{
    										  var html = '';
    									  }
    	    							  $.each(row,function(index,item){
    	    								  html += '<option value="'+item.id+'">'+item.name+'</option>';
    	    								  
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
    					  
    					  
    					  
    					  
    					  
    					  	$.ajax({
    						  url:"/layuikaoshi/news?action=allRole3",
    						  type:"post",
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row =info.data;
    							  var role = body.find("#role2");
    							  $.ajax({
    								  url:"/layui2/news?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
    								  data:{"userid":userid},
    								  type:"post",
    								  success:function(data){
    									  if(data == 0){
    										  var html = '<option value="0">无角色</option>';
    									  }else{
    										  var html = '';
    									  }
    	    							  $.each(row,function(index,item){
    	    								  html += '<option value="'+item.id+'">'+item.name+'</option>';
    	    								  
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
  		url:"/layuikaoshi/news?action=yuangongdel",
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
  
  
  
  
  
  //分配权限
  function hairMenu(userid){
  	
  	layui.layer.open({
  		title : "分配权限",
  		type : 1,
  		content : $('#dtree1'),
  		area:['300px','500px'],
  		success:function(){
  		    //给dtree树加载数据
  			dtree.render({
				  elem: "#dataTree3",
				  url: "/layuikaoshi/news?action=treeid",
				  
				  dataStyle: "layuiStyle",  //使用layui风格的数据格式
				  dataFormat: "list",  //配置data的风格为list
				  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
				  checkbar:true,
				  line: true,  // 显示树线
		           done: function(res, $ul, first){
		        
		        	  
					  $.ajax({
						  url:"/layuikaoshi/news?action=yonghuidquanxian",
						  type:"post",
						  data:{"userid":userid},
						  success:function(res){
							  var cs = eval('(' + res + ')');
						
                 			  $.each(cs,function(index,row){
								dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
							
							
							  })
						  }
						  
					  })
					  
		    	  }
				  
  			});
  		},
 		      btn:['分配权限'],
		        yes : function(index, layero){
  		    var params = dtree.getCheckbarNodesParam("dataTree3");
  			var infos = JSON.stringify(params);
  		   alert(infos);
  			var cs = eval('(' + infos + ')');
  			var menuidList = new Array();	//所有选中值的权限id                                                  
  			
  			$.each(cs,function(index,row){
					menuidList[index] = row.nodeId;
				
			
  			}),	
  			$.ajax({
  				url:"/layuikaoshi/news?action=quanxianxinzeng",
  				data:{"array":menuidList,"userid":userid},
  				type:"post",
  				traditional:true,
  				success:function(data){
  					var demo = eval('(' + data + ')');
  					if(demo.status == 1){
  						layer.msg(demo.message);
  						layer.close(index);	//关闭
  					}else{
  						layer.msg("分配失败");
  					}
  				}
  			})
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
  		content : "/layuikaoshi/jsp/user/userAdd.jsp",
  		area:['400px','490px'],
  	})
  }
  
   

})