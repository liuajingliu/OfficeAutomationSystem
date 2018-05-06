package com.icss.oa.card.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.card.service.CardService;

/**
 * 删除部门数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/DelCardServlet")
public class DelCardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id = Integer.valueOf(request.getParameter("cardId"));
		
		CardService service = new CardService();
		
		try {
			service.deleteCard(Id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
