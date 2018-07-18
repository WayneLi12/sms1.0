package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.SurveyVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description="调查相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询所有调查",notes="但是不可以级联查找到教师，班级，课程，问卷，答卷")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey() {
		try {
			List<Survey> list = surveyService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找所有调查",notes="并且可以级联查找到教师，班级，课程，问卷，答卷")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM() {
		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查找调查",notes="但是不可以级联查找到教师，班级，课程，问卷，答卷")
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id) {
		try {
			Survey survey = surveyService.findById(id);
			return MsgResponse.success("查询成功", survey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查找调查",notes="并且可以级联查找到教师，班级，课程，问卷，答卷")
	@GetMapping("findSurveyVMById")
	public MsgResponse findSurveyVMById(long id) {
		try {
			SurveyVM surveyVM = surveyService.findSurveyVMById(id);
			return MsgResponse.success("查询成功", surveyVM);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存调查")
	@PostMapping("saveSurvey")
	public MsgResponse saveSurvey(Survey survey) {
		try {
			surveyService.save(survey);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="更新调查")
	@PostMapping("updateSurveyInfo")
	public MsgResponse updateSurveyInfo(Survey survey) {
		try {
			surveyService.update(survey);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id删除调查")
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(long id) {
		try {
			surveyService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
