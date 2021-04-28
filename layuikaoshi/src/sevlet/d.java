package sevlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.serviceImpl;

import entity.menu;

public class d extends HttpServlet {

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

	
		// 获取用户输入的数据！
		
	
		
	
		     List<menu> list=new serviceImpl().selectids();
	
		
			 request.setAttribute("list",list);
			 request.getRequestDispatcher("/layui.jsp").forward(request, response);
		
	
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	     int idss=2;
		// 获取用户输入的数据！
		
	
		
	
		     List<menu> list=new serviceImpl().selectids();
	
		
			 request.setAttribute("list",list);
			 request.getRequestDispatcher("/layui.jsp").forward(request, response);
		
	}

}
