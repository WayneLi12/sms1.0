package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	
	@GetMapping("findAllCourses")
	public MsgResponse findAllCourses(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("saveCourseInfo")
	public MsgResponse saveCourseInfo(Course course){
		try {
			courseService.save(course);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findCourseInfoById")
	public MsgResponse findCourseInfoById(long id){
		try {
			Course course = courseService.findById(id);
			return MsgResponse.success("查找成功", course);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("updateCourseInfo")
	public MsgResponse updateCourseInfo(Course course){
		try {
			courseService.update(course);
			return MsgResponse.success("修改课程信息成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id){
		try {
			courseService.delete(id);
			return MsgResponse.success("删除课程信息成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}













