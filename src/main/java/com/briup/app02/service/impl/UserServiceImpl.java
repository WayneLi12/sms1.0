package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.dao.extend.UserVMMapper;
import com.briup.app02.service.IUserService;
import com.briup.app02.vm.UserVM;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserVMMapper userVMMapper;
	
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<User> list = userMapper.findAll();
		return list;
	}
	
	@Override
	public List<UserVM> findAllUserVM() throws Exception {
		// TODO Auto-generated method stub
		return userVMMapper.findAllUserVM();
	}

	@Override
	public User findById(long id) throws Exception {
		// TODO Auto-generated method stub
		User user = userMapper.findById(id);
		return user;
	}
	
	@Override
	public UserVM findUserVMById(long id) throws Exception {
		// TODO Auto-generated method stub
		return userVMMapper.findUserVMById(id);
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.save(user);
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		User u = userMapper.findById(user.getId());
		if(u != null){
			userMapper.update(user);
		}
		else{
			throw new Exception("要更新的教师不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		User u = userMapper.findById(id);
		if(u != null){
			userMapper.delete(id);
		}
		else{
			throw new Exception("要删除的教师不存在");
		}
	}

}
