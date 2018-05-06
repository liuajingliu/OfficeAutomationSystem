package com.icss.oa.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.pojo.CarPicture;
import com.icss.oa.car.pojo.car;
import com.icss.oa.common.DBContion;

/**
 * 车辆DAO
 * @author Administrator
 *
 */

public class CarDao {
	
	/**
	 * 车辆插入
	 * @param c
	 * @throws SQLException 
	 */
	
	public void insert(car c) throws SQLException {
	
		Connection conn = DBContion.getConnection();
		
		String sql = "insert into car values (car_seq.nextval,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, c.getCarType());
		pstmt.setString(2, c.getCarNum());
		pstmt.setString(3, c.getCarStatus());
		pstmt.setLong(4, c.getCarPic().getCpId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 车辆删除
	 * @throws SQLException 
	 */
	
	public void delete(int carId) throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		String sql = "delete from car c,car_pic p where c.cp_id = p.cp_id,c.car_id = ?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, carId);
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 修改车辆
	 * @throws SQLException 
	 */
	public void update(car c) throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE car     c,");
		sb.append("       car_pic p ");		
		sb.append("SET    c.car_type = ?,");
		sb.append("       c.car_num = ?,");
		sb.append("       c.car_status = ?,");
		sb.append("       p.cp_desc = ?,");
		sb.append("       p.cp_photo = ? ");
//		sb.append("       p.cp_size = ? ");
		sb.append("WHERE  c.car_id = ?, c.cp_id = p.cp_id");
		
		String sql = sb.toString();
		System.out.println(sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, c.getCarType());
		pstmt.setString(2, c.getCarNum());
		pstmt.setString(3, c.getCarStatus());
		pstmt.setString(4, c.getCarPic().getCpDesc());
//		pstmt.setLong(6, c.getCarPic().getCpPicSize());
		pstmt.setBinaryStream(5, c.getCarPic().getCpPic());
		pstmt.setInt(6, c.getCarId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 查询车辆
	 * @throws SQLException 
	 */
	
	public car queryById(int carId) throws SQLException {
		
		car ccCar = null;
		
		Connection conn = DBContion.getConnection();
		
		String sql = "select c.*,p.* from car c,car_pic p where c.cp_id = p.cp_id,c.car_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, carId);
		
		ResultSet re = pstmt.executeQuery();
		
		if(re.next()) {
			
			CarPicture cp = new CarPicture(re.getInt(4),re.getString(7),re.getBinaryStream(8)/*,re.getLong(9)*/);
			
			ccCar = new car(re.getInt(1),re.getString(2),re.getString(3),re.getString(5),cp);
		}
		
		re.close();
		pstmt.close();
		conn.close();
			
		return ccCar;
		
	}
	
	/**
	 * 查询所有车辆
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<car> queryAll() throws SQLException {
		
		ArrayList<car> list = new ArrayList<>();
		
		Connection conn = DBContion.getConnection();
		
		String sql = "select c.*,p.* from car c,car_pic p where c.cp_id = p.cp_id";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet re = pstmt.executeQuery();
		
		while (re.next()) {
			
			CarPicture cp = new CarPicture(re.getInt(4),re.getString(7),re.getBinaryStream(8)/*,re.getLong(9)*/);
			car ccCar = new car(re.getInt(1),re.getString(2),re.getString(3),re.getString(5),cp);
			
			list.add(ccCar);
			
		}
		
		re.close();
		pstmt.close();
		conn.close();
		
		return list;
		
	}
	
	/**
	 * 查询空闲车辆
	 */
	public ArrayList<car> queryFree() throws SQLException {
		
		ArrayList<car> list = new ArrayList<>();
		
		Connection conn = DBContion.getConnection();
		
		String sql = "select c.*,p.* from car c,car_pic p where c.car_status = 'free',c.cp_id = p.cp_id";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet re = pstmt.executeQuery();
		
		while (re.next()) {
			
			CarPicture cp = new CarPicture(re.getInt(4),re.getString(7),re.getBinaryStream(8)/*,re.getLong(9)*/);
			car ccCar = new car(re.getInt(1),re.getString(2),re.getString(3),re.getString(5),cp);
			
			list.add(ccCar);
			
		}
		
		re.close();
		pstmt.close();
		conn.close();
		
		return list;
		
	}
	
	/**
	 * 修改车辆状态
	 * @throws SQLException 
	 */
	
	public void updateCarStatus(int carId) throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		String sql = "update car set car_status = 'busy' where car_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, carId);
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}

}

















