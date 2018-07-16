package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface IClazzService {
	List<Clazz> findAll() throws Exception;
	
	Clazz findById(long id) throws Exception;
	
	void save(Clazz clazz) throws Exception;
	
	void update(Clazz clazz) throws Exception;
	
	void delete(long id) throws Exception;
}
