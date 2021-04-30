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
        url : 'news?action=jops',
        page : true,
        toolbar: '#toolbarDemo',
        method : "post",
        title : '角色管理',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed: "left",type: "checkbox", width:50},
            {field: 'id', title: '序列号',  align:'center'},
            {field: 'jname', title: '角色', Width:100, align:"center"},
           
           
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
    
     //�������¼�
	  table.on('toolbar(newsList)', function(obj){
		  
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	   
	    switch(obj.event){
	      case 'hairMenu':	//����Ȩ��
				if(data.length == 0 || data.length > 1){
					layer.msg("��ѡ��һ����ݽ��в���")
					return ;
				}else{
					hairMenu(userid);
				}
	      break;
	      
	      case 'addUser':	//�����û�
	    	  addUser();
	      break;
	      
	      case 'hairRole':	//�����ɫ
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("��ѡ��һ����ݽ��в���")
					return ;
				}else{
					//HairRole(userid);
				}
	      break;
	      
	      case 'upUser':	//�޸��û���Ϣ
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("��ѡ��һ����ݽ��в���");
					return ;
				}else{
					upUser(userid);
				}
	      break;
		        
	      case 'deddddlUser':	//ɾ���û�
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("��ѡ��һ����ݽ��в���");
					return ;
				}else{
					layer.confirm('ȷ��ɾ���û���', {icon: 3, title:'��ʾ'}, function(index){
						var loginName = $("#loginName").val();
						if(userid == loginName){
							layer.msg("�����ڵ�¼��ǰ�˺�,�޷�ɾ��")
						}else{
							deddddlUser(userid);
							layer.close(index);
						}
		            });
				}
	      break;
	    };
	  });
    
    //�޸��û�
    function upUser(userid){
    	
    	layui.layer.open({
    		title : "�޸��û���Ϣ",
    		type : 2,
    		content : "/Student/jsp/juese/jueseupdate.jsp",
    		area:['400px','540px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"/Student/news?action=juesexiugaichaxun",
    				type:"post",
    				data:{"userid":userid},
    				success:function(data){
    					var info = eval('(' + data + ')');
          				var body = layui.layer.getChildFrame('body', index);
          				body.find("#id").val(info.data.id);
    					body.find("#rname").val(info.data.jname);
    					
    				
    				$.ajax({
    						  url:"/Student/news?action=jiaoyuan",
    						  type:"post",
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row =info.data;
    							  var role = body.find("#role1");
    							  $.ajax({
    								  url:"/Student/news?action=queryUserIsRole",	//��ѯ�û��Ƿ��н�ɫ�з���1,û�з���0
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
    	    							//��ȡ�´��ڶ���
    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
    			                        //������Ⱦ
    			                        iframeWindow.layui.form.render();
    								  }
    							  })
    							  
    						  }
    					  })
    					  /*------������ֵ--------*/
    					//��ֵ��ѡ��
    				/*$.ajax({
    						url:"/MenuTest/RoleServlet?action=allRoleUserid",
    						type:"post",
    						data:{"userid":userid},
    						success:function(data){
    							var info2 = eval("("+data+")")
    							if(info2 == 0){
    								var select = 'dd[lay-value="0"]';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//�˵���ʽ
    							}else{
    								var select = 'dd[lay-value='+info2.data.roleid+']';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//�˵���ʽ
    							}
    						}
    					})*/
                        //��ȡ�´��ڶ���
                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                        //������Ⱦ
                        iframeWindow.layui.form.render();
    				}
    			})
    		}
    	})
    }
    
    
    
    
    
    
    
    
    
    
    //ɾ���û�
    function deddddlUser(userid){
    	$.ajax({
    		url:"/Student/news?action=juesedel",
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
    
    
    
    
    
    //����Ȩ��
    function hairMenu(userid){
    	
    	layui.layer.open({
    		title : "����Ȩ��",
    		type : 1,
    		content : $('#dtree1'),
    		area:['300px','500px'],
    		success:function(){
    		    //��dtree���������
    			dtree.render({
				  elem: "#dataTree3",
				  url: "/layui2/news?action=treeid",
				  
				  dataStyle: "layuiStyle",  //ʹ��layui������ݸ�ʽ
				  dataFormat: "list",  //����data�ķ��Ϊlist
				  response:{message:"msg",statusCode:0},  //�޸�response�з�����ݵĶ���
				  checkbar:true,
				  line: true,  // ��ʾ����
		           done: function(res, $ul, first){
		        
		        	  
					  $.ajax({
						  url:"/layui2/news?action=yonghuidquanxian",
						  type:"post",
						  data:{"userid":userid},
						  success:function(res){
							  var cs = eval('(' + res + ')');
						
                   			  $.each(cs,function(index,row){
								dtree.chooseDataInit("dataTree3",[row.id]); // ��ʼ��ѡ��
							
							
							  })
						  }
						  
					  })
					  
  		    	  }
				  
    			});
    		},
   		      btn:['����Ȩ��'],
		        yes : function(index, layero){
    		    var params = dtree.getCheckbarNodesParam("dataTree3");
    			var infos = JSON.stringify(params);
    		   alert(infos);
    			var cs = eval('(' + infos + ')');
    			var menuidList = new Array();	//����ѡ��ֵ��Ȩ��id                                                  
    			
    			$.each(cs,function(index,row){
					menuidList[index] = row.nodeId;
				
			
    			}),	
    			$.ajax({
    				url:"/layui2/news?action=quanxianxinzeng",
    				data:{"array":menuidList,"userid":userid},
    				type:"post",
    				traditional:true,
    				success:function(data){
    					var demo = eval('(' + data + ')');
    					if(demo.status == 1){
    						layer.msg(demo.message);
    						layer.close(index);	//�ر�
    					}else{
    						layer.msg("����ʧ��");
    					}
    				}
    			})
    		}	
    	})
    }

    
    
/*    //�����ɫ
    function HairRole(userid){
    	layer.open({
    		type:1,
    		title:"�����ɫ",
    		area:['200px','100px'],
    		content:$('#hairRole'),
    		success:function(){
    			//��ѯȫ����ɫ
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
    
    //�����û�
    function addUser(){
    	layui.layer.open({
    		title : "新增角色",
    		type : 2,
    		content : "/Student/jsp/juese/jueseadd.jsp",
    		area:['400px','490px'],
    	})
    }
    
     

})