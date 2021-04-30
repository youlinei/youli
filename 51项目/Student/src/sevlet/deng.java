package sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceImpl;
import utils.PrintUtil;

import entity.Student;
import entity.menu;
import entity.page;

public class deng extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password =request.getParameter("pwd");
		System.out.println(name);
	
		// 调用三层方法！
		Student easybuyUserLogin = new ServiceImpl().denglus(name);
	
		    	List<menu> list=new ServiceImpl().dengluquanxians(easybuyUserLogin.getId());
		    	request.getSession().setAttribute("list", list);
		    	
		    	
		 

		    	request.getRequestDispatcher("/layui.jsp").forward(request, response);
			
		
		
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag svalue method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password =request.getParameter("pwd");
	
		// 调用三层方法！
		Student easybuyUserLogin = new ServiceImpl().denglus(name);
	
		List<menu> list=new ServiceImpl().dengluquanxians(easybuyUserLogin.getId());
		
		    	
		request.getSession().setAttribute("list", list);
			    
		request.getRequestDispatcher("/layui.jsp").forward(request, response);
			
	}

}
