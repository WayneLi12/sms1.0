package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;
import com.briup.app02.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Grade> list = gradeMapper.findAll();
		return list;
	}

	@Override
	public Grade findById(long id) throws Exception {
		// TODO Auto-generated method stub
		Grade grade = gradeMapper.findById(id);
		return grade;
	}

	@Override
	public void save(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.save(grade);
	}

	@Override
	public void update(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		Grade gra = gradeMapper.findById(grade.getId());
		if(gra != null){
			gradeMapper.save(grade);
		}
		else{
			throw new Exception("要修改的年级不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Grade gra = gradeMapper.findById(id);
		if(gra != null){
			gradeMapper.delete(id);
		}
		else{
			throw new Exception("要删除的学生信息不存在");
		}
	}
	
}
