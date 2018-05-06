package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.oa.system.pojo.User;
import com.icss.oa.system.service.UserService;

/**
 * ��½��֤���ݽӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		����˺ź�����
		int userName = Integer.valueOf(request.getParameter("userName"));
		String userPwd = request.getParameter("userPwd");		
		
//		��װΪ����
		User user = new User(userName,userPwd);
		System.out.println(user);
		
//		����ҵ�����
		UserService service = new UserService();
		
		try {
			int result = service.checkLogin(user);
			
//			�����½�ɹ����ڻỰ�м�¼
			if (result == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("empId", userName);
			}
			
			out.print(result);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}