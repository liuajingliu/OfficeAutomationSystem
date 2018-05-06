package com.icss.oa.expatriate;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.expatriate.pojo.Personnel;
import com.icss.oa.expatriate.service.PersonnelService;

public class TestPersonnel {
	PersonnelService cs = new PersonnelService();
	@Test
	public void testadd() throws SQLException {
		
		String name = "123123";
		String educt = "大学";
		String skill  = "asdasdasdeqweqw";
		int salary	 = 5000;
		
//		封装数据
		Personnel ps = new Personnel(0, name, educt, skill, salary, "");
		System.out.println(ps);
		cs.addPersonnel(ps);
	}
	
	@Test
	public void testdelete() throws SQLException {
		int id = 600010;
		cs.deletePersonnel(id);
	}
	
	@Test
	public void  testqueryAll() throws SQLException {
		ArrayList<Personnel> list = cs.queryAllPersonnel();
		for (Personnel ps : list) {
			System.out.println(ps);
		}
	}
}

