package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.bumengbiao;
import entity.juese;

import entity.button;
import entity.gongzibiao;
import entity.menu;
import entity.menutwo;
import entity.tree;
import entity.yuangong;
import entity.page;
import entity.zhichengbiao;











import service.service;
import service.serviceImpl;
import utils.AbstractServlet;
import utils.PrintUtil;
import utils.ReturnResult;
@WebServlet("/news")
public class news extends AbstractServlet {
	
	
	private static final long serialVersionUID = 1L;

	public news() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	    //菜单管理
		public String oop(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String ids = request.getParameter("id");

			int id = Integer.parseInt(ids);
			List<menu> list = new serviceImpl().selectlistids(id);
			request.setAttribute("list", list);
			return "/caidan";

	 	}	
		

		public void oops(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			List<menu> list = new serviceImpl().selectids();
			page<menu> page = new page<menu>();
			page.setCode(0);
			page.setCount(list.size());
			page.setMsg("");
			page.setData(list);

			PrintUtil.write(page, response);

		}
		
		
		
		
		
		
		
		
		  //菜单管理
				public String cop(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					String ids = request.getParameter("id");

					int id = Integer.parseInt(ids);
					List<menu> list = new serviceImpl().selectlistids(id);
					request.setAttribute("list", list);
					return "/caidan";

			 	}	
				

				public void cops(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {

					List<gongzibiao> list = new serviceImpl().gongzichaxuns();
					page<gongzibiao> page = new page<gongzibiao>();
					page.setCode(0);
					page.setCount(list.size());
					page.setMsg("");
					page.setData(list);

					PrintUtil.write(page, response);

				}
				
				
				public int gongziinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
				    String name=request.getParameter("uname");
					String roke1=request.getParameter("money");
					int role11=Integer.parseInt(roke1);
			
					
					gongzibiao seYuangong=new gongzibiao();
					
					seYuangong.setName(name);
					seYuangong.setMoney(role11);
					service service=new serviceImpl();
					int row=service.gongziadds(seYuangong);
					 
					System.out.println(row);
					return row;
					}
					
				public int gongzidel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
					String ids=request.getParameter("userid");
				    int id=Integer.parseInt(ids);
					service menuService=new serviceImpl();
					int count=menuService.gongzidels(id);
					System.out.println(count);
					return count;
					}
					
					
				
				

				public int gongzixiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					int id=Integer.parseInt(request.getParameter("mid"));
				    String name=request.getParameter("uname");
					String roke1=request.getParameter("money");
					int role11=Integer.parseInt(roke1);
			
					
					gongzibiao seYuangong=new gongzibiao();
					seYuangong.setId(id);
					seYuangong.setName(name);
					seYuangong.setMoney(role11);
					service service=new serviceImpl();
					int row=service.gongzixiugais(seYuangong);
					 
					System.out.println(row);
					return row;
					}
				
				
				public ReturnResult gonzixiugaichaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();	
				 	int id = Integer.parseInt(request.getParameter("userid"));

					 service list=new serviceImpl();
					 gongzibiao count= list.gongzixiiugaichaxun(id);
					 result.returnSuccess(count);
					
					return result;
					}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	

	// 员工管理
	public String aop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("id");
		System.out.println(ids);
		int id = Integer.parseInt(ids);
		List<menu> list = new serviceImpl().selectlistids(id);
		request.setAttribute("list", list);
		return "/yonghu";

	}

	public void aops(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<yuangong> list = new serviceImpl().selects();
		page<yuangong> page = new page<yuangong>();
		page.setCode(0);
		page.setCount(list.size());
		page.setMsg("");
		page.setData(list);

		PrintUtil.write(page, response);

	}
	
	
	
	
	public ReturnResult allRole1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult result = new ReturnResult();
		List<bumengbiao> list = new serviceImpl().bumengbiaos();
		result.returnSuccess(list);
		return result;
	}
	
	public ReturnResult allRole2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult result = new ReturnResult();
		List<juese> list = new serviceImpl().juesesbiaos();
		result.returnSuccess(list);
		return result;
	}
	
	public ReturnResult allRole3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult result = new ReturnResult();
		List<zhichengbiao> list = new serviceImpl().zhichengbiaos();
		result.returnSuccess(list);
		return result;
	}
	
	
	public int yuangonginsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    String name=request.getParameter("uname");
	String roke1=request.getParameter("role1");
	int role11=Integer.parseInt(roke1);
	String roke2=request.getParameter("role2");
	int role22=Integer.parseInt(roke2);
	String roke3=request.getParameter("role3");
	int role33=Integer.parseInt(roke3);
	System.out.println(name);
	System.out.println(role11);
	System.out.println(role22);
	System.out.println(role33);
	
	yuangong seYuangong=new yuangong();
	
	seYuangong.setName(name);
	seYuangong.setBumenid(role11);
	seYuangong.setJueseid(role22);
	seYuangong.setZhichengid(role33);
	service service=new serviceImpl();
	 int row= service.inserts(seYuangong);
	System.out.println(row);
	return row;
	}
	
	
	

	public int yuangongdel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String idString=request.getParameter("userid");
	int id=Integer.parseInt(idString);
	service service=new serviceImpl();
	 int row=service.yuangongdels(id);
	
	return row;

	}
	
	
	public ReturnResult yuangonchaxn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult result = new ReturnResult();	
     	int id = Integer.parseInt(request.getParameter("userid"));
        service service=new serviceImpl();
        yuangong count=service.xiugaichaxuns(id);
        result.returnSuccess(count);
			return result;
	}

	public int queryUserIsRole(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int count=1;
		return count;
		
	}
	
	
	
public int yuangongxiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("uname");
	String roke1=request.getParameter("role1");
	int role11=Integer.parseInt(roke1);
	String roke2=request.getParameter("role2");
	int role22=Integer.parseInt(roke2);
	String roke3=request.getParameter("role3");
	int role33=Integer.parseInt(roke3);
	System.out.println(name);
	System.out.println(role11);
	System.out.println(role22);
	System.out.println(role33);
	
	
	yuangong seYuangong=new yuangong();
	seYuangong.setId(id);
	seYuangong.setName(name);
	seYuangong.setBumenid(role11);
	seYuangong.setJueseid(role22);
	seYuangong.setZhichengid(role33);
	service service=new serviceImpl();
	int row= service.yuangongUpdates(seYuangong);
	System.out.println(row);
	return row;
	
	}






	
	
	
	
//菜单 新增 
public ReturnResult addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ReturnResult result = new ReturnResult();
	String mname = request.getParameter("mname");
	String fun = request.getParameter("mfunction");
	int type = Integer.parseInt(request.getParameter("type2"));
	String icon = request.getParameter("icon");
	String btn = request.getParameter("mbtn");
	int father = Integer.parseInt(request.getParameter("father"));
    menu listsMenu=new menu();
    listsMenu.setMname(mname);
    listsMenu.setMfunction(fun);
    listsMenu.setType(type);
    listsMenu.setIcon(icon);
    listsMenu.setMbtn(btn);
    listsMenu.setMfatherid(father);
	int row = new serviceImpl().caidanadds(listsMenu);

	result.returnSuccess(row);
	return result;
}
//菜单 删除
public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String ids=request.getParameter("userid");
      int id=Integer.parseInt(ids);
     
  
	
	service menuService=new serviceImpl();
	
	int count=menuService.caidandeletes(id);
	System.out.println(count);


	return count;
}

public List<button> button(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<button> list=new serviceImpl().buttons();
	return list;

}


//菜单 修改 查询所对应的id信息
public ReturnResult caidanlistxiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ReturnResult result = new ReturnResult();	
 	int id = Integer.parseInt(request.getParameter("userid"));

	service list=new serviceImpl();
	 menu count= list.caidanxiugailists(id);
	 result.returnSuccess(count);
	
	return result;
}








//菜单 修改
public ReturnResult caidanxiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ReturnResult result = new ReturnResult();

	String ids=request.getParameter("mid");
	int id=Integer.parseInt(ids);
	System.out.println(id);
	
	String mname = request.getParameter("mname");
	System.out.println(mname);
	
	String fun = request.getParameter("mfunction");
	System.out.println(fun);
	
	int type = Integer.parseInt(request.getParameter("type2"));
	System.out.println(type);
	
	String icon = request.getParameter("icon");
	System.out.println(icon);
	
	String btn = request.getParameter("mbtn");
	System.out.println(btn);
	
	int father = Integer.parseInt(request.getParameter("father"));
	System.out.println(father);
	
    menu listsMenu=new menu();
    listsMenu.setId(id);
    listsMenu.setMname(mname);
    listsMenu.setMfunction(fun);
    listsMenu.setType(type);
    listsMenu.setIcon(icon);
    listsMenu.setMbtn(btn);
    listsMenu.setMfatherid(father);
	int row = new serviceImpl().candanxiugais(listsMenu);
	System.out.println(row);
	result.returnSuccess(row);
	return result;
}



//查询类型对应的父级
		public ReturnResult menuByType2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int type = Integer.parseInt(request.getParameter("type"));
			List<menu> menuByBtn3 = new serviceImpl().typelists(type-1);
			ReturnResult result = new ReturnResult();
			result.returnSuccess(menuByBtn3);
			return result;
		}





		// 角色管理
				public String nop(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					String ids = request.getParameter("id");

					int id = Integer.parseInt(ids);
					List<menu> list = new serviceImpl().selectlistids(id);
					request.setAttribute("list", list);
					return "/juese";

				}

				public void nops(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {

					List<juese> list = new serviceImpl().jueseslists();
					page<juese> page = new page<juese>();
					page.setCode(0);
					page.setCount(list.size());
					page.setMsg("");
					page.setData(list);
					PrintUtil.write(page, response);

				}






				//用户 权分配
				public ReturnResult quanxianxinzeng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
					int userid = Integer.parseInt(request.getParameter("userid"));
					System.out.println(userid);
					String[] menuidList = request.getParameterValues("array");
					for (int i = 0; i < menuidList.length; i++) {
						System.out.println(menuidList[i]);
					}
					
					ReturnResult result = new ReturnResult();
					int row = new serviceImpl().quanxianadds(userid, menuidList);
					if(row != 0 ) {
					    	result.returnYes("分配权限成功");
						/*result.returnSuccess("分配权限成功");*/
					}
					return result;
				
				
				}
				
				
				//用户  分配 树状图显示
				public void treeid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				page<tree> list=new serviceImpl().treemenu();
				PrintUtil.write(list, response);
				
				}
				
				
				  //查询用户所对应的权限
				public void yonghuidquanxian(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				   String ids=request.getParameter("userid");
				   int id=Integer.parseInt(ids);
				 
				   System.out.println(id);
				   
				   service list=new serviceImpl();
				   List<menutwo> prod=list.yonghuidquanxians(id);
				   PrintUtil.write(prod, response);					
				}

	@Override
	public Class getServletClass() {
	
		return news.class;
	}

}
