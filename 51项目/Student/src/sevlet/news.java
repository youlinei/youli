package sevlet;

import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import entity.Student;
import entity.button;
import entity.classs;
import entity.jiaoyuan;
import entity.role;

import entity.menu;
import entity.page;
import entity.time;




import service.Service;
import service.ServiceImpl;
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
	
	
	
	public ReturnResult loginBtn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReturnResult result = new ReturnResult();
		// ��ȡ�û���������ݣ�
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		// �������㷽����
		//��½
		Student easybuyUserLogin = new ServiceImpl().denglus(name);
		//
		List<menu> list=new ServiceImpl().dengluquanxians(easybuyUserLogin.getId());
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("easybuyUserLogin", easybuyUserLogin);
			
		return result.returnSuccess("��½�ɹ�");
			
	

	}
	
	
	
	
	
	public int time(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
		int id=Integer.parseInt(request.getParameter("mid"));
		
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		String de=request.getParameter("time");
		Date data = Date.valueOf(de); //
		
	/*	Date data=Date.valueOf(de);*/
		int deltes=Integer.parseInt(request.getParameter("delte"));
		
		  time time=new time();
		 
		  time.setId(id);
		  time.setData(data);
		  time.setDeltes(deltes);
		  Service service=new ServiceImpl();
		    int count=  service.timeadds(time);

		return count;

	}
	
	
	
	
	public int timeAjax(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
		int id=Integer.parseInt(request.getParameter("mid"));
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		String de=request.getParameter("time");
		Date data = Date.valueOf(de); //
		  Service service=new ServiceImpl();
		    int count=  service.timeAjaxs(id, data);

		return count;
	
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ǩ������
		public String aop(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			String ids = request.getParameter("id");
			int uid=Integer.parseInt(request.getParameter("uid"));
			System.out.println(uid);
			int id = Integer.parseInt(ids);
			List<menu> list = new ServiceImpl().selectlistids(id);
			System.out.println(id);
			request.setAttribute("list", list);
			return "/qiandao";

		}

		public void aops(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {  
			request.getParameter("UTF-8");
			String ids=request.getParameter("id");
			System.out.println(ids);
			System.out.println(ids);
			System.out.println(ids);
			int id=Integer.parseInt(ids);
		
			List<Student> list = new ServiceImpl().StudentSelects(id);
			page<Student> page = new page<Student>();
			page.setCode(0);
			page.setCount(list.size());
			page.setMsg("");
			page.setData(list);

			PrintUtil.write(page, response);
		}
		
		
		
		
		
		
		
		
		
		// �༶����
				public String bop(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					System.out.println(id);
					List<menu> lists = new ServiceImpl().selectlistids(id);
					request.setAttribute("lists", lists);
					return "/banji";

				}
				
				

				public void bops(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		           
					List<classs> list = new ServiceImpl().ClassSeletcs();
					page<classs> page = new page<classs>();
					page.setCode(0);
					page.setCount(list.size());
					page.setMsg("");
					page.setData(list);
					PrintUtil.write(page, response);
				}
				
				public ReturnResult jiaoyuan(HttpServletRequest request, HttpServletResponse response) throws Exception {
					ReturnResult result = new ReturnResult();
					
					//
					List<jiaoyuan> list=new ServiceImpl().jiaoyuans();
				
					
					result.returnSuccess(list);
					return result;
						
				

				}
				
				
				public int banjiadd(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
				
					String name=request.getParameter("rname");
					int role=Integer.parseInt(request.getParameter("role"));
					
					
					SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
					String de=request.getParameter("time");
					Date data = Date.valueOf(de); //
					classs classs=new classs();
					classs.setName(name);
					classs.setTeacherid(role);
					Service service=new ServiceImpl();
				  int count=service.classinsets(classs);

					return count;

				}
				
				
				public int banjidel(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
				
					String name=request.getParameter("userid");
					int id=Integer.parseInt(name);
					
					
					

		
					Service service=new ServiceImpl();
				  int count=service.classdels(id);

					return count;

				}
				
				public int banjiupdate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
					int id=Integer.parseInt(request.getParameter("id"));
					String name=request.getParameter("rname");
					int role=Integer.parseInt(request.getParameter("role"));
					
					classs classs=new classs();
					
					classs.setId(id);
					classs.setName(name);
					classs.setTeacherid(role);
			      Service service=new ServiceImpl();
				  int count=service.calssxiugais(classs);

					return count;

				}
				
				
				
				public ReturnResult banjixiugaichaxun(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
					ReturnResult result = new ReturnResult();	
			     	int id = Integer.parseInt(request.getParameter("userid"));
			     	classs count=new ServiceImpl().classchaxunids(id);
			     	result.returnSuccess(count);

					return result;

				}
				
				
				public int queryUserIsRole(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ParseException {
					

					return 1;

				}
				
				
				
				
				
				
				
				
				
				
				// Ȩ�޹���
				public String qop(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					
					String ids = request.getParameter("id");
					int id = Integer.parseInt(ids);
					List<menu> list = new ServiceImpl().selectlistids(id);
					request.setAttribute("list", list);
					return "/juese";

				}

				public void qops(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {

					List<menu> list = new ServiceImpl().selectalls();
					page<menu> page = new page<menu>();
					page.setCode(0);
					page.setCount(list.size());
					page.setMsg("");
					page.setData(list);
					PrintUtil.write(page, response);

				}
				
				public List<button> button(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					List<button> list=new ServiceImpl().buttons();
		      	return list;

				}
				
				
				
				//��ѯ���Ͷ�Ӧ�ĸ���
				public ReturnResult menuByType2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					int type = Integer.parseInt(request.getParameter("type"));
					List<menu> menuByBtn3 = new ServiceImpl().typelists(type-1);
					ReturnResult result = new ReturnResult();
					result.returnSuccess(menuByBtn3);
					return result;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				//�˵� ���� 
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
					int row = new ServiceImpl().caidanadds(listsMenu);
			     result.returnSuccess(row);
					
					return result;
				}
				//�˵� ɾ��
				public int delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();
					String ids=request.getParameter("userid");
				    int id=Integer.parseInt(ids);	
				    Service menuService=new ServiceImpl();
					int count=menuService.caidandeletes(id);
					
					return count;
				}
				
				//�˵� �޸� ��ѯ����Ӧ��id��Ϣ
				public ReturnResult caidanlistxiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();	
			     	int id = Integer.parseInt(request.getParameter("userid"));

					Service list=new ServiceImpl();
					 menu count= list.caidanxiugailists(id);
					result.returnSuccess(count);
					
					return result;
				}
				
				
				
				//�˵� �޸�
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
					int row = new ServiceImpl().candanxiugais(listsMenu);
					System.out.println(row);
					result.returnSuccess(row);
					return result;
				}	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
					
				
				
				
				
				
				
				// ѧ������
				public String xop(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
					String ids = request.getParameter("id");
					int uid=Integer.parseInt(request.getParameter("uid"));
					System.out.println(uid);
					int id = Integer.parseInt(ids);
					List<menu> list = new ServiceImpl().selectlistids(id);
					System.out.println(id);
					request.setAttribute("list", list);
					return "/xuesheng";

				}

				public void xops(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {  
				
					List<Student> list = new ServiceImpl().selectallStudents();
					page<Student> page = new page<Student>();
					page.setCode(0);
					page.setCount(list.size());
					page.setMsg("");
					page.setData(list);

					PrintUtil.write(page, response);
				}	
				
				//������
				public ReturnResult banjixialakuang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();	
				    List<classs> count= new ServiceImpl().banjixialkuangs();
					result.returnSuccess(count);
					return result;
				}
				
				//�˵� ���� 
				public int xueshengadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();
					String name = request.getParameter("name");
					String loginname = request.getParameter("loginname");
					int role = Integer.parseInt(request.getParameter("role"));
					String password = request.getParameter("password");
					
				    Student student=new Student();
				     student.setXname(name);
				     student.setLoginname(loginname);
				     student.setPassword(password);
				     student.setClassid(role);
				     
					int row = new ServiceImpl().StudentAdds(student);
			  
					
					return row;
				}
				
				
				//ѧ��ɾ��
				public int xueshengdel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id=Integer.parseInt(request.getParameter("userid"));
				Service service=new ServiceImpl();
			     int count=	service.StudentDels(id);
				 return count;
				}
				
				
				
				public int xueshengxiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();
					int id=Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("name");
					String loginname = request.getParameter("loginname");
					int role = Integer.parseInt(request.getParameter("role"));
					String password = request.getParameter("password");
					
				    Student student=new Student();
				    student.setId(id);
				     student.setXname(name);
				     student.setLoginname(loginname);
				     student.setPassword(password);
				     student.setClassid(role);
				     
					int row = new ServiceImpl().StudentUpdates(student);
			  
					
					return row;
					}
				
				// �޸� ��ѯ����Ӧ��id��Ϣ
				public ReturnResult xueshengxiugaichaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					ReturnResult result = new ReturnResult();	
			     	int id = Integer.parseInt(request.getParameter("userid"));

					Service list=new ServiceImpl();
					 Student count= list.StudentUpdateSelectIds(id);
					result.returnSuccess(count);
					
					return result;
				}
				
				
			
	
	

	
	

				// �༶����
						public String jop(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
							String ids = request.getParameter("id");
							int id = Integer.parseInt(ids);
							System.out.println(id);
							List<menu> lists = new ServiceImpl().selectlistids(id);
							request.setAttribute("lists", lists);
							return "/juese";

						}
						
						

						public void jops(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException {
				           
							List<role> list = new ServiceImpl().RoleSelects();
							page<role> page = new page<role>();
							page.setCode(0);
							page.setCount(list.size());
							page.setMsg("");
							page.setData(list);
							PrintUtil.write(page, response);
						}
	
	
	
	
						
						
						
						
						
						public int jueseadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							ReturnResult result = new ReturnResult();
							String name = request.getParameter("rname");
							role role=new role();
						  role.setJname(name);
						    
						     
							int row = new ServiceImpl().RoleAdds(role);
					      
							return row;
						}
						

						public int  juesedel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							ReturnResult result = new ReturnResult();
							
	                 	int id=Integer.parseInt(request.getParameter("userid"));
						    
						     
							int row = new ServiceImpl().RoleDels(id);
					        result.returnSuccess(row);
					       
							
							return row;
						}
						
						
						public int  juesexiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							ReturnResult result = new ReturnResult();
							String name = request.getParameter("rname");
	                 	    int id=Integer.parseInt(request.getParameter("id"));
	                 	    System.out.println(name);
	                 	    System.out.println(id);
	                    	role role=new role();				
						    role.setId(id);
						    role.setJname(name); 
							int row = new ServiceImpl().RoleUpds(role);
							System.out.println(row);
					        result.returnSuccess(row);
							return row;
						}
						
						
						
						// �޸� ��ѯ����Ӧ��id��Ϣ
						public ReturnResult juesexiugaichaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							ReturnResult result = new ReturnResult();	
					     	int id = Integer.parseInt(request.getParameter("userid"));

							Service list=new ServiceImpl();
							 role count= list.RoleUpdSelects(id);
							result.returnSuccess(count);
							
							return result;
						}
						
						
						
	
	
	
	
	
	
	
	
	

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return news.class;
	}

}
