package com.icss.oa.car.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.dao.CarDao;
import com.icss.oa.car.pojo.car;

public class CarService {
	
	private CarDao dao = new CarDao();
	
	/**
	 *  增加车辆
	 * @throws SQLException 
	 */
	public void addCarServerlet(car ccCar) throws SQLException {
		
		dao.insert(ccCar);
		
	}
	
	/**
	 * 修改车辆信息
	 */
	
	public void updateCarServerlet(car ccCar) throws SQLException {
		
		dao.update(ccCar);
		
	}
	
	/**
	 * 删除车辆
	 */
	
	public void deleteCarServerlet(int carId) throws SQLException {
		
		dao.delete(carId);
		
	}
	
	/**
	 * 查询单独车辆
	 * @throws SQLException 
	 */
	
	public car queryCarServerlet(int carId) throws SQLException {
		
		return dao.queryById(carId);
		
	}
	
	/**
	 * 查询所有车辆
	 * @throws SQLException 
	 */
	public ArrayList<car> queryAllCarServerlet() throws SQLException {
		
		return dao.queryAll();
		
	}
	
	/**
	 * 查询空闲车辆
	 */
	public ArrayList<car> queryAllFreeServerlet() throws SQLException {
		
		return dao.queryFree();
		
	}
	
	/**
	 * 修改车辆状态
	 * @throws SQLException 
	 */
	
	public void updateCarStatusServerlet(int carId) throws SQLException {
		
		dao.updateCarStatus(carId);
		
	}

}
