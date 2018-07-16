package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserService userService;
	
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<User> list = userService.findAll();
		return list;
	}

	@Override
	public User findById(long id) throws Exception {
		// TODO Auto-generated method stub
		User user = userService.findById(id);
		return user;
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		userService.save(user);
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		User u = userService.findById(user.getId());
		if(u != null){
			userService.update(user);
		}
		else{
			throw new Exception("要更新的教师不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		User u = userService.findById(id);
		if(u != null){
			userService.delete(id);
		}
		else{
			throw new Exception("要删除的教师不存在");
		}
	}

}
