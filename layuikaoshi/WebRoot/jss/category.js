layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    
    	      
    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem : '#newsList',
        url : 'news?action=nops',
        page : true,
        toolbar: '#toolbarDemo',
        method : "post",
        title : '角色管理',
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed: "left",type: "checkbox", width:50},
            {field: 'id', title: 'id',  align:'center'},
            {field: 'name', title: '角色', align:'center'},
            {field: 'user', title: '姓名', align:'center'}
        ]]
    ,done : function(res, curr, count) {
        merge(res);
 }
    });
    
    
    function merge(res) {
        var data = res.data;
        var mergeIndex = 0;//定位需要添加合并属性的行数
        var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
        var columsName = ['id','name'];//需要合并的列名称s
        var columsIndex = [1,2];//需要合并的列索引值
 
        for (var k = 0; k < columsName.length; k++) { //这里循环所有要合并的列
            var trArr = $(".layui-table-body>.layui-table").find("tr");//所有行
                for (var i = 1; i < res.data.length; i++) { //这里循环表格当前的数据
                    var tdCurArr = trArr.eq(i).find("td").eq(columsIndex[k]);//获取当前行的当前列
                    var tdPreArr = trArr.eq(mergeIndex).find("td").eq(columsIndex[k]);//获取相同列的第一列
 
                    if (data[i][columsName[k]] === data[i-1][columsName[k]]) { //后一行的值与前一行的值做比较，相同就需要合并
                        mark += 1;
                        tdPreArr.each(function () {//相同列的第一列增加rowspan属性
                            $(this).attr("rowspan", mark);
                        });
                        tdCurArr.each(function () {//当前行隐藏
                            $(this).css("display", "none");
                        });
                    }else {
                        mergeIndex = i;
                        mark = 1;//一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
                    }
                }
            mergeIndex = 0;
            mark = 1;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*------------- 加载用户数据 --end------------------------------*/
  

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function(){
   
    	var like = $("#likename").val()
    	 tableIns.reload({
	      url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,
	      page: {
	        curr: 1 //重新从第 1 页开始
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
					HairRole(userid);
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
    
    
  //删除用户
    function deddddlUser(userid){
    	alert(userid)
    	$.ajax({
    		url:"/layuikaoshi/news?action=delete",
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

    
    

    //新增用户
    function addUser(){
    	layui.layer.open({
    		title : "添加用户",
    		type : 2,
    		content : "/layui2/jsp/juese/roleAdd.jsp",
    		area:['400px','490px'],
    	})
    }
    
     

})