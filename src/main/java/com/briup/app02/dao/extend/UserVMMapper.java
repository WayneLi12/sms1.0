package com.briup.app02.dao.extend;

import java.util.List;

import com.briup.app02.vm.UserVM;

public interface UserVMMapper {
	List<UserVM> findAllUserVM();
	
	UserVM findUserVMById(long id);
}
