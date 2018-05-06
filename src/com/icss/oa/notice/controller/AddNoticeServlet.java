package com.icss.oa.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.notice.pojo.Notice;
import com.icss.oa.notice.service.NoticeService;


/**
 * ���ӹ������ݷ��ʽӿ�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet {

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
		String title = request.getParameter("title");
		String desc  = request.getParameter("desc");
				
//		��װ����
		Notice nt = new Notice(0, title, new java.sql.Date(new java.util.Date().getTime()),desc);
		
//		����ҵ�����
		NoticeService service = new NoticeService();
		
		try {
			service.addNotice(nt);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		�ɹ���ʾ
		out.print("���淢���ɹ���");
		
	}

}
