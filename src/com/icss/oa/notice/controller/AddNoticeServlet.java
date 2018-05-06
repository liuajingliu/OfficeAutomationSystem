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
 * 增加公告数据访问接口
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
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		输出流
		PrintWriter out = response.getWriter();
		
//		获得请求参数
		String title = request.getParameter("title");
		String desc  = request.getParameter("desc");
				
//		封装数据
		Notice nt = new Notice(0, title, new java.sql.Date(new java.util.Date().getTime()),desc);
		
//		创建业务对象
		NoticeService service = new NoticeService();
		
		try {
			service.addNotice(nt);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("公告发布成功！");
		
	}

}
