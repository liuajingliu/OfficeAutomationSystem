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
 * ���ӹ������ݷ��ʽӿ�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddCardCaseServlet")
public class AddCardCaseServlet extends HttpServlet {

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
		String name = request.getParameter("CardCaseName");
		int empid = (int) request.getSession().getAttribute("empId");
				
//		��װ����
		Cardcase cc = new Cardcase(name, empid);
		System.out.println(cc);
//		����ҵ�����
		CardcaseService service = new CardcaseService();
		
		try {
			service.addCardcase(cc);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("���淢���ɹ���");
		
	}

}
