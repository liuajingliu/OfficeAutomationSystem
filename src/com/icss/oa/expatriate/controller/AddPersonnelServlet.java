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
 * �������ݷ��ʽӿ�
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
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
//		String name = request.getParameter("name");
//		String educt= request.getParameter("educt"); 
//		String skill= request.getParameter("skill");
//		int salary	= Integer.valueOf(request.getParameter("salary"));
		
		String name = "123123";
		String educt = "��ѧ";
		String skill  = "asdasdasdeqweqw";
		int salary	 = 5000;		
//		��װ����
		Personnel ps = new Personnel(0, name, educt, skill, salary, "");
		
//		����ҵ�����
		PersonnelService service = new PersonnelService();
		
		try {
			service.addPersonnel(ps);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("���淢���ɹ���");
		
	}

}
