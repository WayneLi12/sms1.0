package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private IQuestionService questionService;
	
	@ApiOperation(value="查询所有问题")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有问题",notes="级联查询出属于该题目的选项")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询所有问题")
	@GetMapping("findQuestionById")
	public MsgResponse findQuestionById(long id){
		try {
			Question q = questionService.findById(id);
			return MsgResponse.success("查询成功", q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存问题")
	@PostMapping("saveQuestion")
	public MsgResponse saveQuestion(Question question){
		try {
			questionService.save(question);
			return MsgResponse.success("保存成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新问题")
	@PostMapping("updateQuestionInfo")
	public MsgResponse updateQuestionInfo(Question question){
		try {
			questionService.update(question);
			return MsgResponse.success("更新成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除问题")
	@GetMapping("deleteQuestion")
	public MsgResponse deleteQuestion(long id){
		try {
			questionService.delete(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
