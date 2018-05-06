package com.icss.oa.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.notice.service.NoticeService;


/**
 * 删除部门数据访问接口
 */
@SuppressWarnings("serial")
@WebServlet("/DelNoticeServlet")
public class DelNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id = Integer.valueOf(request.getParameter("id"));
		
		NoticeService service = new NoticeService();
		
		try {
			service.deleteNotice(Id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}
