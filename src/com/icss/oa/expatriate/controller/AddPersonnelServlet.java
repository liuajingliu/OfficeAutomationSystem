package com.icss.oa.expatriate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.pojo.Personnel;
import com.icss.oa.expatriate.service.PersonnelService;


/**
 * 增加数据访问接口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddPersonnelServlet")
public class AddPersonnelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
//		String name = request.getParameter("name");
//		String educt= request.getParameter("educt"); 
//		String skill= request.getParameter("skill");
//		int salary	= Integer.valueOf(request.getParameter("salary"));
		
		String name = "123123";
		String educt = "大学";
		String skill  = "asdasdasdeqweqw";
		int salary	 = 5000;		
//		封装数据
		Personnel ps = new Personnel(0, name, educt, skill, salary, "");
		
//		创建业务对象
		PersonnelService service = new PersonnelService();
		
		try {
			service.addPersonnel(ps);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("公告发布成功！");
		
	}

}
