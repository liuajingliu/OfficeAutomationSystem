package com.icss.oa.expatriate.pojo;

public class Company {
	private int id;
	
	private String name;
	
	private String master;
	
	private long phone;
	
	private String request;
	
	private long qq;
	
	private String desc;
	public Company() {
		super();
	}
	
	public Company(int id, String name, String master, int phone,
			String request, int qq, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.master = master;
		this.phone = phone;
		this.request = request;
		this.qq = qq;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", master=" + master
				+ ", phone=" + phone + ", request=" + request + ", qq=" + qq
				+ ", desc=" + desc + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(int qq) {
		this.qq = qq;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
