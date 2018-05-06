package com.icss.oa.car.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.oa.car.pojo.car;
import com.icss.oa.car.service.CarService;

@WebServlet("/AddCarServerlet")
public class AddCarServerlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
//		设置编码
		request.setCharacterEncoding("utf-8");
		
//		获得请求参数
		String carType = request.getParameter("carType");
		String carNum = request.getParameter("carNum");
		
//		封装数据
		car ccCar = new car(carType,carNum,"free",null);
		
//		创建业务对象
		CarService service = new CarService();
		
		try {
			
			service.addCarServerlet(ccCar);
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		
	}

}
