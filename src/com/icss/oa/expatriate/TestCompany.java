package com.icss.oa.expatriate;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.expatriate.pojo.Company;
import com.icss.oa.expatriate.service.CompanyService;


public class TestCompany {
	CompanyService cs = new CompanyService();
	@Test
	public void testadd() throws SQLException {
		
		String name = "123123";
		String master = "asdasd";
		int phone	 = 15465;
		String request1  = "java";
		int qq	 = 165465;
		String desc = "miaoshu";
		
//		·â×°Êý¾Ý
		Company cp = new Company(0, name, master, phone, request1, qq, desc);
		System.out.println(cp);
		cs.addCompany(cp);
	}
	
	@Test
	public void testdelete() throws SQLException {
		int id = 650010;
		cs.deleteCompany(id);
	}
	
	@Test
	public void  testqueryAll() throws SQLException {
		ArrayList<Company> list = cs.queryAllCompany();
		for (Company notice : list) {
			System.out.println(notice);
		}
	}
}
