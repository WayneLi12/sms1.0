package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Student> findAll() throws Exception {
		// 调用studentMapper查询所有学生
		List<Student> list = studentMapper.findAll();
		return list;
	}

	@Override
	public Student findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return studentMapper.findById(id);

	}

	@Override
	public void save(Student student) throws Exception {
		// TODO Auto-generated method stub
		studentMapper.save(student);
	}

	@Override
	public void update(Student student) throws Exception {
		// TODO Auto-generated method stub
		Student stu = studentMapper.findById(student.getId());
		if(stu!=null){
			studentMapper.update(student);
		}
		else{
			throw new Exception("要修改的学生不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		//1.通过id查找
		Student student = studentMapper.findById(id);
		//2.如果该学生存在则删除，如果不存在则抛出异常
		if(student !=null){
		studentMapper.delete(id);
		}
		else{
			throw new Exception("要删除的学生不存在");
		}
	}

}
