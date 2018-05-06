package com.icss.oa.expatriate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.expatriate.service.CompanyService;

/**
 * 删除数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/DelCompanyServlet")
public class DelCompanyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int Id = Integer.valueOf(request.getParameter("Id"));
		int Id = 550008;
		
		CompanyService service = new CompanyService();
		
		try {
			service.deleteCompany(Id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
