layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
       
   /*  --- 閿熸枻鎷疯瘉鏉冮敓鏂ゆ嫹閿熸枻鎷烽敓瑙掑嚖鎷烽敓鏂ゆ嫹閿燂拷---------------------------------------------------------------
    $("#mname").blur(function(){
    	var mname = $("#mname").val();  //鏉冮敓鏂ゆ嫹
    	$.post("/MenuTest/MenuServlet?action=isMenuName&mname="+mname,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('鏉冮敓鏂ゆ嫹閿熸枻鎷烽敓绐栬揪鎷烽敓鏂ゆ嫹');
    		}
		 })
    })
    
     --- 閿熸枻鎷疯瘉閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓锟�---------------------------------------------------------------
    $("#mfunction").blur(function(){
    	var mfunction = $("#mfunction").val();  //閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹
    	$.post("/MenuTest/MenuServlet?action=isMenuUrl&mfunction="+mfunction,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹閿熺獤杈炬嫹閿熸枻鎷�);
    		}
		 })
    })
*/

    /* -- 閿熸枻鎷烽敓鏂ゆ嫹鏉冮敓鏂ゆ嫹 --------------------------------------------------------------- */
    form.on('submit(menuUser)',function(data){
    	var mid=$("#mid").val();
    	var mname = $("#mname").val();  //鏉冮敓鏂ゆ嫹
	    var mfunction = $("#mfunction").val();  //閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹
	    var type2 = $("#type2").val();  //閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	    var icon = $("#icon").val();  //icon鍥鹃敓鏂ゆ嫹
	    var mbtn = $("#mbtn").val();  //閿熸枻鎷烽挳閿熸枻鎷烽敓鏂ゆ嫹
	    var father = $("#father").val();  //閿熸枻鎷烽敓鏂ゆ嫹
	   
        
		$.post("/Student/news?action=addMenu&mname="+mname+"&mfunction="+mfunction+"&type2="+type2+"&icon="+icon+"&mbtn="+mbtn+"&father="+father,function(data){
			var info = eval("("+data+")");
	 		if(info.status == 1){
	 			top.layer.msg("添加成功");
	 			layer.closeAll("iframe");
	          
	            parent.location.reload();
	 		}else{
	 			top.layer.msg("失败");
	 		}
		 })
        return false;
    })
    
    
    /*-----------閿熸枻鎷烽敓鏂ゆ嫹閫夐敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风墶閿熸枻鎷烽敓閾扮》鎷�---------*/
    form.on('select(type2)', function(data){
    	var type = data.value;
        var dom = $("#goodsid");
        var mname = $("#mname").val();  //鏉冮敓鏂ゆ嫹
        dom.html("");
        if(type == 3){
        	$("#mbtn").val('');
        	$("#iconclass").css("display","none");
        	$("#btnclss").css("display","block");
        	//閿熸枻鎷疯閿熸枻鎷烽敓鍙府鎷烽挳
        	$.get("/Student/news?action=button",function (res) {
        		var cs = eval('(' + res + ')');
        		var btntype = $('#btnType');
        		var html = '<span value="0"></span>';
                $.each(cs,function (index, item) {
                    html += '<span class="btnType4" onclick="tongyiType(this)">'+item.button+'</span> ';
                });
                btntype.html(html);
        	})
        }else{
        	$("#iconclass").css("display","block");
        	$("#btnclss").css("display","none");
        }
        //
        $.get("/Student/news?action=menuByType2&type="+type,function (res) {
        	var cs = eval('(' + res + ')');
            var data = cs.data;
            var dom = $("#father");
            if(type == 1){
            	var html = '<option value="0">123</option>';
            }else{
            	var html = '<option value="0">请选择</option>';
                $.each(data,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.mname+'</option>';
                });
            }
            dom.html(html);
            //閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋煋閿熸枻鎷烽敓鏂ゆ嫹閿熷彨鎲嬫嫹
            form.render("select");
        });
    });
    /*-----------閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�---------*/
    
})
	function tongyiType(obj){
		$("#mbtn").val('');
    	var info =  $(obj).html();
    	$("#mbtn").val(info);
    }
    