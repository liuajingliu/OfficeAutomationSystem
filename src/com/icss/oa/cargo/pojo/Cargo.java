package com.icss.oa.cargo.pojo;

public class Cargo {
	private int id;
	
	private String name;
	
	private String desc;
	
	private int price;
	
	private int num;

	public Cargo(int id, String name, String desc, int price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.num = num;
	}

	public Cargo() {
		super();
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", price=" + price + ", num=" + num + "]";
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
