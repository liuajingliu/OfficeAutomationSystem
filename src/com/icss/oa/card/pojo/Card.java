package com.icss.oa.card.pojo;

public class Card {
	private int cardId;
	
	private String name;
	
	private String job;
	
	private String phone;
	
	private String qq;
	
	private String addr;
	
	private String email;
	
	private String company;
	
	private Cardcase cardcase;
	
	public Cardcase getCardcase() {
		return cardcase;
	}


	public void setCardcase(Cardcase cardcase) {
		this.cardcase = cardcase;
	}


	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", name=" + name + ", job=" + job
				+ ", phone=" + phone + ", qq=" + qq + ", addr=" + addr
				+ ", email=" + email + ", company=" + company + ", cardcase="
				+ cardcase + "]";
	}


	public Card(int cardId, String name, String job, String phone, String qq,
			String addr, String email, String company, Cardcase cardcase) {
		super();
		this.cardId = cardId;
		this.name = name;
		this.job = job;
		this.phone = phone;
		this.qq = qq;
		this.addr = addr;
		this.email = email;
		this.company = company;
		this.cardcase = cardcase;
	}


	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
