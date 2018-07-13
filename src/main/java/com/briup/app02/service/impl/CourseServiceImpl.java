package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		List<Course> list = courseMapper.findAll();
		return list;
	}

	@Override
	public void save(Course course) throws Exception {
		courseMapper.save(course);
		
	}

	@Override
	public Course findById(long id) throws Exception {
		
		return courseMapper.findById(id);
	}

	@Override
	public void update(Course course) throws Exception {
		// TODO Auto-generated method stub
		Course cou = courseMapper.findById(course.getId());
		if(cou!=null){
			courseMapper.update(course);
		}
		else{
			throw new Exception("要修改的课程不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		
		Course cou = courseMapper.findById(id);
		if(cou!=null){
			courseMapper.delete(id);
		}
		else{
			throw new Exception("要删除的学生不存在");
		}
		
	}

}











