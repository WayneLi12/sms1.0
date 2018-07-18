package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Qq;

public interface QqMapper {
	List<Qq> findAll();
	
	Qq findById(long id);
	
	List<Qq> findByQuestionnaireId(long id);
	
	void save(Qq qq);
	
	void update(Qq qq);
	
	void delete(long id);
}
