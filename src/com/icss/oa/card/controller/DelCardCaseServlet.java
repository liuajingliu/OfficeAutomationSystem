package com.icss.oa.card.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.card.service.CardcaseService;


/**
 * ɾ���������ݷ��ʽӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/DelCardCaseServlet")
public class DelCardCaseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id = Integer.valueOf(request.getParameter("Id"));
		
		CardcaseService service = new CardcaseService();
		
		try {
			service.deleteCardcase(Id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
