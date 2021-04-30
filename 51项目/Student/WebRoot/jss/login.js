/**
 * 绐椾綋鍔犺浇浜嬩欢锛�
 * 
 * @returns
 */
$(document).ready(function() {
	/**
	 * 鐧婚檰鎸夐挳鐐瑰嚮浜嬩欢锛�
	 */
	$("#log_btn").click(function() {
		loginCheck();
	});

	/**
	 * 鍥炶溅閿偣鍑讳簨浠讹紒
	 */
	//回车事件 KeyCode==13 等于enter回车键
	$('form').on('keypress', function(event) {
		if (event.keyCode == 13) {
			loginCheck();
		}
	});


	
	function loginCheck() {
		var name = $(".l_user").val();
		var pwd = $(".l_pwd").val();
		if (name == "" || name == null) {
			mizhu.alert('提示', "鐢ㄦ埛鍚嶄笉鑳戒负绌�");
			return;
		} else if (pwd == "" || pwd == null) {
			mizhu.alert('鎿嶄綔鎻愰啋', "瀵嗙爜涓嶈兘涓虹┖!");
			return;
		} else {
			$.ajax({
			
				url : "/Student/news",
				method : "post",
				data : {
					"action" : "loginBtn",
					"name" : name,
					"pwd" : pwd
				},
				success : function(jsonStr) {
					var result = eval("(" + jsonStr + ")");
					if (result.status == 1) {
						// 鐧诲綍鎴愬姛锛佽烦杞櫥褰曠晫闈紒锛�
						location.href ="http://localhost:8080/Student/layui.jsp";
					} else {
						
					}
				}
			});
		}
	}
	
});

