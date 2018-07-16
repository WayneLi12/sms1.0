package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.User;

public interface UserMapper {
	List<User> findAll();
	
	UserMapper findById(long id);
	
	void save(UserMapper user);
	
	void update(UserMapper user);
	
	void delete(long id);
}
