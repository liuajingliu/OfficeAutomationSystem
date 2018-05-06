package com.icss.oa.expatriate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.pojo.Company;
import com.icss.oa.expatriate.service.CompanyService;

/**
 * �������ݷ��ʽӿ�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddCompanyServlet")
public class AddCompanyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String name = request.getParameter("name");
		String master= request.getParameter("master"); 
		int phone	= Integer.valueOf(request.getParameter("phone"));
		String request1= request.getParameter("request");
		int qq	= Integer.valueOf(request.getParameter("qq"));
		String desc= request.getParameter("desc");
		
//		��װ����
		Company cp = new Company(0, name, master, phone, request1, qq, desc);
		
//		����ҵ�����
		CompanyService service = new CompanyService();
		
		try {
			service.addCompany(cp);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("���淢���ɹ���");
		
	}

}
