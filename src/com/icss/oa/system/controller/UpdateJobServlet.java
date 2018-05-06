package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.JobService;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String id = request.getParameter("jobId");
		String name = request.getParameter("jobName");
		String desc = request.getParameter("jobDesc");
		
//		��װ����
		Job job = new Job(Integer.parseInt(id),name,desc);
		
		
//		����ҵ�����
		JobService service = new JobService();
		
		try {
			service.updateJob(job);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�����޸ĳɹ���");
		
	}

}
