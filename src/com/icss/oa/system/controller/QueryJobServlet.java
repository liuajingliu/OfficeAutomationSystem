package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.JobService;


/**
 * Servlet implementation class QueryJobServlet
 */
@SuppressWarnings("serial")
@WebServlet("/QueryJobServlet")
public class QueryJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		ҵ�����
		JobService service = new JobService();
				
		try {			
			ArrayList<Job> list = service.queryAllJob();
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(list));			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}