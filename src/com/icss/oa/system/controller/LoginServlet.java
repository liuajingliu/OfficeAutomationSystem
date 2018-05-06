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
 * 登陆验证数据接口
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
//		获得账号和密码
		int userName = Integer.valueOf(request.getParameter("userName"));
		String userPwd = request.getParameter("userPwd");		
		
//		封装为对象
		User user = new User(userName,userPwd);
		System.out.println(user);
		
//		创建业务对象
		UserService service = new UserService();
		
		try {
			int result = service.checkLogin(user);
			
//			如果登陆成功，在会话中记录
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