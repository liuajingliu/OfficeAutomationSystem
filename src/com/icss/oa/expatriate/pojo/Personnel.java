package com.icss.oa.expatriate.pojo;

/**
 * @author Administrator
 * 人才实体类
 */
public class Personnel {
	private int 	id;
	
	private String 	name;
	
	private String 	eduction;
	
	private String 	skill;
	
	private int 	salary;
	
	private String 	status;

	public Personnel() {
		super();
	}

	public Personnel(int id, String name, String eduction, String skill,
			int salary, String status) {
		super();
		this.id = id;
		this.name = name;
		this.eduction = eduction;
		this.skill = skill;
		this.salary = salary;
		this.status = status;
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

	public String getEduction() {
		return eduction;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Personnel [id=" + id + ", name=" + name + ", eduction="
				+ eduction + ", skill=" + skill + ", salary=" + salary
				+ ", status=" + status + "]";
	}
}
