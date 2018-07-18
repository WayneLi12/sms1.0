package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.Qq;

public class QuestionnaireVM {
	private Long id;
	private String name;
	private String description;
	private String createdate;
	private List<Qq> qqs;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public List<Qq> getQqs() {
		return qqs;
	}
	public void setQqs(List<Qq> qqs) {
		this.qqs = qqs;
	}
	
	
}
