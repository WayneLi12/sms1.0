package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.OptionVM;

public interface OptionVMMapper {
	List<OptionVM> findAllOptionVM();
	
	OptionVM findOptionVMById(long id);
}
