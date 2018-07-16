package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;


@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("查找成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findGradeById")
	public MsgResponse findGradeById(long id){
		try {
			Grade grade = gradeService.findById(id);
			return MsgResponse.success("查找成功", grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveGrade")
	public MsgResponse saveGrade(Grade grade){
		try {
			gradeService.save(grade);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateGradeInfo")
	public MsgResponse updateGradeInfo(Grade grade){
		try {
			gradeService.update(grade);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteGrade")
	public MsgResponse deleteGrade(long id){
		try {
			gradeService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
