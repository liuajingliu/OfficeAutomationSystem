package com.icss.oa.notice;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.oa.notice.pojo.Notice;
import com.icss.oa.notice.service.NoticeService;

public class TestNotice {
	NoticeService ns = new NoticeService();
	@Test
	public void testadd() throws SQLException {
		Notice nt = new Notice();
		ns.addNotice(nt);
	}
	
	@Test
	public void testdelete() throws SQLException {
		int id = 550005;
		ns.deleteNotice(id);
	}
	
	@Test
	public void  testqueryAll() throws SQLException {
		ArrayList<Notice> list = ns.queryAllNotice();
		for (Notice notice : list) {
			System.out.println(notice);
		}
	}
}
