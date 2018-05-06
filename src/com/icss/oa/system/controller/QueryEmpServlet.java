package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.service.EmployeeService;

/**
 * Servlet implementation class QueryDeptServlet
 */
@SuppressWarnings("serial")
@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		获得页码		
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));		
//		每页记录数		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));	
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		创建业务对象
		EmployeeService service = new EmployeeService();
		
		try {
			Pager pager = new Pager(service.getEmpCount(),pageNum,pageSize);
			ArrayList<Employee> list = service.queryAll(pager);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager", pager);
			map.put("list", list);
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(map));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
