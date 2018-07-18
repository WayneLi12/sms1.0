package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.GradeVM;

public interface GradeVMMapper {

	List<GradeVM> findAllGradeVM();
	
	GradeVM findGradeVMById(long id);
}
