package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.service.IClazzService;

@Service
public class ClazzServiceImpl implements IClazzService{
	
	@Autowired
	private ClazzMapper clazzMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Clazz> list = clazzMapper.findAll();
		return list;
	}

	@Override
	public Clazz findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return clazzMapper.findById(id);
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.save(clazz);
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		Clazz c = clazzMapper.findById(clazz.getId());
		if(c != null){
			clazzMapper.update(clazz);
		}
		else{
			throw new Exception("要更新的班级不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Clazz clazz = clazzMapper.findById(id);
		if(clazz != null){
			clazzMapper.delete(id);
		}
		else{
			throw new Exception("要删除的班级不存在");
		}
	}
	
	
}
