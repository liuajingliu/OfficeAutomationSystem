package com.icss.oa.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.pojo.CarPicture;
import com.icss.oa.common.DBContion;;

/**
 * 汽车照片DAO类
 * 
 * @author Administrator
 * 
 */
public class CarPicDao {

	/**
	 * 插入汽车
	 * 
	 * @param cp
	 * @throws SQLException
	 */
	public void insert(CarPicture cp) throws SQLException {

		Connection conn = DBContion.getConnection();

		String sql = "insert into car_picture values (cp_seq.nextval,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, cp.getCpDesc());
		pstmt.setBinaryStream(2, cp.getCpPic());
//		pstmt.setLong(3, cp.getCpPicSize());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 删除图片
	 * @throws SQLException 
	 */
	public void deleteById(int cpId) throws SQLException {
		
		Connection conn = DBContion.getConnection();

		String sql = "delete from car_pic where cp_id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, cpId);

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}

	/**
	 * 查询数据
	 * 
	 * @throws SQLException
	 */
	public ArrayList<CarPicture> queryAll(int carId) throws SQLException {

		ArrayList<CarPicture> list = new ArrayList<CarPicture>();

		Connection conn = DBContion.getConnection();

		String sql = "select * from car_picture where car_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, carId);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			CarPicture cp = new CarPicture(rs.getInt(1), rs.getString(2), null/*,
					rs.getLong(4)*/);

			list.add(cp);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

	/**
	 * 根据汽车照片id，查询汽车数据
	 * 
	 * @throws SQLException
	 */
	public CarPicture queryById(int cpId) throws SQLException {
		
		CarPicture cp = null;

		Connection conn = DBContion.getConnection();

		String sql = "select * from car_pic where cp_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, cpId);

		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {

			cp = new CarPicture(rs.getInt(1), rs.getString(2), rs.getBinaryStream(3)/*, rs.getLong(4)*/);
		}
		
		rs.close();
		pstmt.close();
//		conn.close();
		
		return cp;
	}

}