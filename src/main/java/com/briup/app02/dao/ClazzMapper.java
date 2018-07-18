package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;
import com.briup.app02.bean.Grade;

public interface ClazzMapper {
	List<Clazz> findAll();
	
	List<Clazz> findUserById(long id);
	
	List<Grade> findGradeById(long id);
	
	Clazz findById(long id);
	
	void save(Clazz clazz);
	
	void update(Clazz clazz);
	
	void delete(long id);
}
