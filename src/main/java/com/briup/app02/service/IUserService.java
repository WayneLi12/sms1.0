package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.User;
import com.briup.app02.vm.UserVM;

public interface IUserService {
	List<User> findAll() throws Exception;
	
	List<UserVM> findAllUserVM() throws Exception;
	
	User findById(long id) throws Exception;
	
	UserVM findUserVMById(long id) throws Exception;
	
	void save(User user) throws Exception;
	
	void update(User user) throws Exception;
	
	void delete(long id) throws Exception;
}
