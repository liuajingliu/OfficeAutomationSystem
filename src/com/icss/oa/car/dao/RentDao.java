package com.icss.oa.car.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.pojo.car;
import com.icss.oa.car.pojo.rent;
import com.icss.oa.common.DBContion;
import com.icss.oa.common.Pager;

/**
 * 车辆借出表
 * @author Administrator
 *
 */

public class RentDao {
	
	/**
	 * 记录插入
	 * @param c
	 * @throws SQLException 
	 */
	
	public void insert(rent r) throws SQLException {
	
		Connection conn = DBContion.getConnection();
		
		String sql = "insert into rent values (rent_seq.nextval,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, r.getRentPath());
		pstmt.setDate(2, r.getRentStart());
		pstmt.setDate(3, r.getRentEnd());
		pstmt.setString(4, r.getRentStatus());
		pstmt.setInt(5, r.getCcCar().getCarId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}

	/**
	 * 记录删除
	 * @throws SQLException 
	 */
	
	public void delete(int rentId) throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		String sql = "delete from rent where rent_id = ?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rentId);
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 修改记录
	 * @throws SQLException 
	 */
	public void update(rent r) throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		String sql = "update rent set rent_path = ?,rent_start = ?,rent_end = ?,rent_status = ?,car_id = ? where rent_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, r.getRentPath());
		pstmt.setDate(2, r.getRentStart());
		pstmt.setDate(3, r.getRentEnd());
		pstmt.setString(4, r.getRentStatus());
		pstmt.setInt(5, r.getCcCar().getCarId());
		pstmt.setInt(6, r.getRentId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 查询记录
	 * @throws SQLException 
	 */
	
	public rent queryById(int rentId) throws SQLException {
		
		rent r = null;
		
		Connection conn = DBContion.getConnection();
		
		String sql = "select * from rent where rent_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rentId);
		
		ResultSet re = pstmt.executeQuery();
		
		if(re.next()) {
			
			car ccCar = new car();
			ccCar.setCarId(re.getInt(3));
			
			r = new rent(re.getString(4),re.getDate(5),re.getDate(6),re.getString(7),ccCar);
		}
		
		re.close();
		pstmt.close();
		conn.close();
			
		return r;
		
	}
	
	/**
	 * 查询所有记录
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<rent> queryAll(Pager pager) throws SQLException {
		
		ArrayList<rent> list = new ArrayList<rent>();
		

		Connection conn = DBContion.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT rownum rnum,");		
		sb.append("               ee.* ");
		sb.append("        FROM   (SELECT r.rent_id,");
		sb.append("                       r.rent_path,");
		sb.append("                       r.rent_start,");
		sb.append("                       r.rent_end,");
		sb.append("                       r.emp_id,");
		sb.append("                       r.car_id,");
		sb.append("                       c.car_type,");
		sb.append("                       c.car_num,");
		sb.append("                       e.emp_name,");
		sb.append("                       e.emp_phone ");
		sb.append("                FROM   rent r ");
		sb.append("                INNER  JOIN car c ON r.car_id = c.car_id ");
		sb.append("                INNER  JOIN employee e ON r.emp_id = e.emp_id ");
		sb.append("                ORDER  BY r.rent_id) ee) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");
		
		String sql = sb.toString();
		System.out.println(sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());

		ResultSet re = pstmt.executeQuery();
		
		while (re.next()) {
			car dept = new car();
			dept.setCarId(re.getInt(7));
			dept.setCarType(re.getString(8));
			dept.setCarNum(re.getString(9));
			
//			Job job = new Job();
//			job.setJobId(rs.getInt(7));
//			job.setJobName(rs.getString(9));

			rent emp = new rent(re.getInt(2), re.getString(3), re.getDate(4),
					re.getDate(5), re.getString(6), dept);
			
			list.add(emp);
		}

		re.close();
		pstmt.close();
		conn.close();

		return list;
		
	}
	
	/**
	 * 返回总记录数
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		
		Connection conn = DBContion.getConnection();
		
		String sql = "SELECT COUNT(*) FROM rent";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		int count = rs.getInt(1);
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return count;		
	}
	
}
