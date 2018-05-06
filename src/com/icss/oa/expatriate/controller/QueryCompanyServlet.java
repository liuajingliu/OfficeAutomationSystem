package com.icss.oa.expatriate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.oa.expatriate.pojo.Company;
import com.icss.oa.expatriate.service.CompanyService;

/**
 * 查询所有数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/QueryCompanyServlet")
public class QueryCompanyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		创建业务对象
		CompanyService service = new CompanyService();
		
		try {
			ArrayList<Company> list = service.queryAllCompany();
			
//			产生json格式数据
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd")  
			  .create();
			
			out.print(gson.toJson(list));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
