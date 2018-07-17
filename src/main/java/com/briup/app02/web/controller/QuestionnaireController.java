package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.bean.Questionnaire;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷的相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@ApiOperation(value="查询所有问卷")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询问卷")
	@GetMapping("findQuestionnaireById")
	public MsgResponse findQuestionnaireById(long id){
		try {
			Questionnaire q = questionnaireService.findById(id);
			return MsgResponse.success("查询成功", q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存问卷")
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.save(questionnaire);
			return MsgResponse.success("保存成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新问卷")
	@PostMapping("updateQuestionnaireInfo")
	public MsgResponse updateQuestionnaireInfo(Questionnaire questionnaire){
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("更新成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除问卷")
	@GetMapping("deleteQuestionnaire")
	public MsgResponse deleteQuestionnaire(long id){
		try {
			questionnaireService.delete(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
