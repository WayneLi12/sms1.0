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

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findQuestionnaireById")
	public MsgResponse findQuestionnaireById(long id){
		try {
			Questionnaire q = questionnaireService.findById(id);
			return MsgResponse.success("查询成功", q);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.save(questionnaire);
			return MsgResponse.success("保存成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateQuestionnaireInfo")
	public MsgResponse updateQuestionnaireInfo(Questionnaire questionnaire){
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("更新成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteQuestionnaire")
	public MsgResponse deleteQuestionnaire(long id){
		try {
			questionnaireService.delete(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
