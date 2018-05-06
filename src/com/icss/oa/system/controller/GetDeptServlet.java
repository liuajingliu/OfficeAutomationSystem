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
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.service.DepartmentService;

/**
 * Servlet implementation class GetDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GetDeptServlet")
public class GetDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();

		String id = request.getParameter("deptId");

		DepartmentService service = new DepartmentService();

		try {
			Department emp = service.queryDeptById(Integer.parseInt(id));
			
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			System.out.println(gson.toJson(emp));
			out.print(gson.toJson(emp));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}