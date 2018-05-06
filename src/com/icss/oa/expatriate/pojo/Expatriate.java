package com.icss.oa.expatriate.pojo;

import java.sql.Date;

public class Expatriate {
	private int expid;
	
	private int perid;
	
	private int comid;
	
	private Date start;
	
	private Date end;
	
	private String status;

	@Override
	public String toString() {
		return "Expatriate [expid=" + expid + ", perid=" + perid + ", comid="
				+ comid + ", start=" + start + ", end=" + end + ", status="
				+ status + "]";
	}

	public Expatriate(int expid, int perid, int comid, Date start, Date end,
			String status) {
		super();
		this.expid = expid;
		this.perid = perid;
		this.comid = comid;
		this.start = start;
		this.end = end;
		this.status = status;
	}

	public Expatriate() {
		super();
	}

	public int getExpid() {
		return expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
