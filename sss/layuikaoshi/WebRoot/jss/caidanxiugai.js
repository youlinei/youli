layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
       
/*     --- ��֤Ȩ�����Ƿ���� ---------------------------------------------------------------
    $("#mname").blur(function(){
    	var mname = $("#mname").val();  //Ȩ��
    	$.post("/admin/MenuServlet?action=isMenuName&mname="+mname,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('Ȩ�����Ѵ���');
    		}
		 })
    })
     --- ��֤Ȩ�����Ƿ���� -- end -------------------------------------------------------------
    
     --- ��֤����·���Ƿ���� ----------------------------------------------------------------
    $("#mfunction").blur(function(){
    	var mfunction = $("#mfunction").val();  //����·��
    	$.post("/admin/MenuServlet?action=isMenuUrl&mfunction="+mfunction,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('����·���Ѵ���');
    		}
		 })
    })
     --- ��֤����·���Ƿ���� -- end --------------------------------------------------------------
    */
    /* -- �޸�Ȩ�� --------------------------------------------------------------- */
    $("#menuAjax").click(function(){
    	var mid = $("#mid").val();  //Ȩ��
    	var mname = $("#mname").val();  //Ȩ����
    	alert(mname);
	    var mfunction = $("#mfunction").val();  //����·��
	    var type2 = $("#type2").val();  //��������
	    var icon = $("#icon").val();  //iconͼ��
	    var mbtn = $("#mbtn").val();  //��ť����
	    var father = $("#father").val();  //����
	    var data2 = {
        		"mid":mid,
        		"mname":mname,
        		"mfunction":mfunction,
        		"type2":type2,
        		"icon":icon,
        		"father":father,
        		"mbtn":mbtn
    	};
	  /*  //Ȩ����
        if(mname == "" || mname == null){
        	layer.msg("Ȩ��������Ϊ��");
        	return false;
        }
        
        //����·��
        if(mfunction == "" || mfunction == null){
        	layer.msg("����·������Ϊ��");
        	return false;
        }
    	
        //����
        if(type2 == 0 || type2.size == 0){
        	layer.msg("��ѡ������");
        	return false;
        }
        
        if(type2 != 1){
        	if(father == 0){
        		layer.msg("�˵���ť����û���ϼ�");
            	return false;
        	}
        }
        if(type2 == 3){
        	if(mbtn == null || mbtn.length < 30 || mbtn==""){
            	layer.msg("��ť�����ʽ����");
            	return false;
            }
        }
        if(type2 == 3){
        	mbtn = mname;
        }*/
        //�޸�
        //ajax�ύ
        $.ajax({
        	url:"/layuikaoshi/news?action=caidanxiugai",
        	type:"post",
        	data:data2,
        	success:function(data){
        		var info = eval('(' + data + ')')
        		if(info.status == 1){
    	 			top.layer.msg("Ȩ���޸ĳɹ�");
    	 			layer.closeAll("iframe");
    	            //ˢ�¸�ҳ��
    	            parent.location.reload();
    	 		}else{
    	 			top.layer.msg("Ȩ���޸�ʧ��");
    	 		}
        	}
        })
        return false;
    })
    /* -- �޸�Ȩ�� -- end ------------------------------------------------------------- */
   
    
    /*-----------����ѡ��������ĵ���¼�----------*/
    form.on('select(type2)', function(data){
    	var type = data.value;
        var dom = $("#goodsid");
        var mname = $("#mname").val();  //Ȩ��
        dom.html("");
        if(type == 3){
        	$("#mbtn").val('');
        	$("#iconclass").css("display","none");
        	$("#btnclss").css("display","block");
        	//��ť��ѯ
        	$.get("/layui2/news?action=button",function (res) {
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
        $.get("/layuikaoshi/news?action=menuByType2&type="+type,function (res) {
        	var cs = eval('(' + res + ')');
            var data = cs.data;
            var dom = $("#father");
            if(type == 1){
            	var html = '<option value="0">Ŀ¼û����һ��</option>';
            }else{
            	var html = '<option value="0">��ѡ��</option>';
                $.each(data,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.mname+'</option>';
                });
            }
            dom.html(html);
            //������Ⱦ�����б�
            form.render("select");
        });
    });
    /*-----------����ѡ��������ĵ���¼�-- end --------*/

    
})
	/*---- �����ȡ��ť�����¼� ------*/
	function tongyiType(obj){
		$("#mbtn").val('');
    	var info =  $(obj).html();
    	$("#mbtn").val(info);
    }
	/*---- �����ȡ��ť�����¼� -- end ----*/
    