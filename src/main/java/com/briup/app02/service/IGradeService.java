package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Grade;
import com.briup.app02.vm.GradeVM;

public interface IGradeService {
	List<Grade> findAll() throws Exception;
	
	List<GradeVM> findAllGradeVM() throws Exception;
	
	Grade findById(long id) throws Exception;
	
	GradeVM findGradeVMById(long id) throws Exception;
	
	void save(Grade grade) throws Exception;
	
	void update(Grade grade) throws Exception;
	
	void delete(long id) throws Exception;
}
