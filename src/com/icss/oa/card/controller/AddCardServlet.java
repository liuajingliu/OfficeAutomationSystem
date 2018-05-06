package com.icss.oa.card.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.card.pojo.Cardcase;
import com.icss.oa.card.service.CardcaseService;


/**
 * 增加公告数据访问接口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddCardServlet")
public class AddCardServlet extends HttpServlet {

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
		String name = request.getParameter("CardCaseName");
		int empId	= Integer.valueOf(request.getParameter("empId"));
				
//		封装数据
		Cardcase cc = new Cardcase(name, empId);
		
//		创建业务对象
		CardcaseService service = new CardcaseService();
		
		try {
			service.addCardcase(cc);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("公告发布成功！");
		
	}

}
