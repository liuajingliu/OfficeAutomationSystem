package com.icss.oa.cargo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.cargo.pojo.Cargo;
import com.icss.oa.cargo.service.CargoService;

/**
 * 增加数据访问接口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddCargoServlet")
public class AddCargoServlet extends HttpServlet {

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
		String cargoName = request.getParameter("cargoName");
		String cargoDesc= request.getParameter("cargoDesc"); 
		int cargoPrice	= Integer.valueOf(request.getParameter("cargoPrice"));
		int cargoNum	= Integer.valueOf(request.getParameter("cargoNum"));		
//		封装数据
		Cargo cp = new Cargo(0, cargoName, cargoDesc, cargoPrice, cargoNum);
		System.out.println(cp);
//		创建业务对象
		CargoService service = new CargoService();
		
		try {
			service.addCargo(cp);
		} catch (SQLException e) {			
			e.printStackTrace();
			return;
		}
		
//		成功提示
		out.print("成功！");
		
	}

}
