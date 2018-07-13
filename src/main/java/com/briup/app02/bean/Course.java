package com.briup.app02.bean;

public class Course {

	private Long id;
	private String name;
	private Integer credit;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(Long id, String name, Integer credit, String description) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.description = description;
	}
	public Course(){
		
	}
}
