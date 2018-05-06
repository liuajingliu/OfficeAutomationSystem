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
import com.icss.oa.card.pojo.Card;
import com.icss.oa.card.service.CardService;

/**
 * Servlet implementation class QueryDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/QueryCardServlet")
public class QueryCardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		获得请求参数
		int empid = (int) request.getSession().getAttribute("empId");
		System.out.println(empid);
//		输出流
		PrintWriter out = response.getWriter();
		
//		创建业务对象
		CardService service = new CardService();
		
		try {
			ArrayList<Card> list = service.queryAllCard(empid);
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(list));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
