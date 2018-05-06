package com.icss.oa.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.EmployeeService;

/**
 * 增加部门数据访问接口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String name = request.getParameter("empName");
		String phone = request.getParameter("empPhone");
		Date birthday = Date.valueOf(request.getParameter("empBirthday"));
		String email = request.getParameter("empEmail");
		String qq = request.getParameter("empQQ");
		int dept_id = Integer.valueOf(request.getParameter("deptId"));
		int job_id = Integer.valueOf(request.getParameter("jobId"));
				
//		封装数据
		Employee emp = new Employee(0, name, phone, birthday, email, qq, new Department(dept_id), new Job(job_id));
		System.out.println(emp);
//		创建业务对象
		EmployeeService service = new EmployeeService();
		
		try {
			service.addEmp(emp);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("部门增加成功！");
		
	}

}
