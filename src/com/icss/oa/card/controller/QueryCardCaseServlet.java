package com.icss.oa.card.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.card.pojo.Cardcase;
import com.icss.oa.card.service.CardcaseService;

/**
 * Servlet implementation class QueryDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/QueryCardCaseServlet")
public class QueryCardCaseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		����������
		int empid = (int) request.getSession().getAttribute("empId");
		System.out.println(empid);
//		�����
		PrintWriter out = response.getWriter();
		
//		����ҵ�����
		CardcaseService service = new CardcaseService();
		
		try {
			ArrayList<Cardcase> list = service.queryAllCardcase(empid);
			
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(list));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}