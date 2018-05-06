package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class GetDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GetJobServlet")
public class GetJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();

		String id = request.getParameter("jobId");

		JobService service = new JobService();

		try {
			Job jb = service.queryJobById(Integer.parseInt(id));
			
			
//			����json��ʽ����
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			System.out.println(gson.toJson(jb));
			out.print(gson.toJson(jb));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}