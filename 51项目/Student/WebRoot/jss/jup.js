function news(url,id,js,uid){
	
	 $(".m_content").load(url+"&id="+id+"&&uid="+uid,function(){
         var sc =  document.createElement("script");
         sc.src= js; //�������ݱ���js
         $(".m_content").append(sc);
      })
	
	  var item={
	  id:id
	  };

	  
	  }