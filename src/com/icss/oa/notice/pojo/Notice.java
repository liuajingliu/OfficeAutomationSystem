package com.icss.oa.notice.pojo;

import java.util.Date;

/**
 * @author Administrator 公告实体类`
 */
public class Notice {
	private int id;

	private String title;

	private Date date;

	private String desc;

	public Notice() {
		
	}

	public Notice(int id, String title, Date date, String desc) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
