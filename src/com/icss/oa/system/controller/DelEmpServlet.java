package com.icss.oa.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.service.EmployeeService;

/**
 * 删除部门数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/DelEmpServlet")
public class DelEmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("empId"));
		System.out.println("---------"+id);
		EmployeeService service = new EmployeeService();
		
		try {
			service.deleteEmp(id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
