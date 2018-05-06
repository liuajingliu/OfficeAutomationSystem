package com.icss.oa.expatriate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.service.PersonnelService;

/**
 * 删除数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/DelPersonnelServlet")
public class DelPersonnelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int Id = Integer.valueOf(request.getParameter("Id"));
		int Id = 550008;
		
		PersonnelService service = new PersonnelService();
		
		try {
			service.deletePersonnel(Id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
