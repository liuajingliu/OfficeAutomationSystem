package com.icss.oa.expatriate.controller;

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
import com.icss.oa.expatriate.pojo.Personnel;
import com.icss.oa.expatriate.service.PersonnelService;

/**
 * ��ѯ�������ݷ��ʽӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/QueryPersonnelServlet")
public class QueryPersonnelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����ҵ�����
		PersonnelService service = new PersonnelService();
		
		try {
			ArrayList<Personnel> list = service.queryAllPersonnel();
			
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
