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
 * ���Ӳ������ݷ��ʽӿ�
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
		
//		���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		�����
		PrintWriter out = response.getWriter();
		
//		����������
		String name = request.getParameter("empName");
		String phone = request.getParameter("empPhone");
		Date birthday = Date.valueOf(request.getParameter("empBirthday"));
		String email = request.getParameter("empEmail");
		String qq = request.getParameter("empQQ");
		int dept_id = Integer.valueOf(request.getParameter("deptId"));
		int job_id = Integer.valueOf(request.getParameter("jobId"));
				
//		��װ����
		Employee emp = new Employee(0, name, phone, birthday, email, qq, new Department(dept_id), new Job(job_id));
		System.out.println(emp);
//		����ҵ�����
		EmployeeService service = new EmployeeService();
		
		try {
			service.addEmp(emp);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("�������ӳɹ���");
		
	}

}
