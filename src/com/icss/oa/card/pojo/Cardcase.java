package com.icss.oa.card.pojo;

public class Cardcase {
	private int cardcaseId;
	
	private String cardName;
	
	private int empId;

	@Override
	public String toString() {
		return "Cardcase [cardName=" + cardName + ", empId=" + empId + "]";
	}
	
	
	public Cardcase(int cardcaseId, String cardName) {
		super();
		this.cardcaseId = cardcaseId;
		this.cardName = cardName;
	}


	public Cardcase(int cardcaseId, String cardName, int empId) {
		super();
		this.cardcaseId = cardcaseId;
		this.cardName = cardName;
		this.empId = empId;
	}

	public Cardcase(String cardName, int empId) {
		super();
		this.cardName = cardName;
		this.empId = empId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCardcaseId() {
		return cardcaseId;
	}

	public void setCardcaseId(int cardcaseId) {
		this.cardcaseId = cardcaseId;
	}
	
}
