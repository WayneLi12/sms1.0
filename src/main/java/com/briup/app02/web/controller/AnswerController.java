package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答案相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private IAnswerService answerService;
	
	@ApiOperation(value="查询所有答案")
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer() {
		try {
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查询所有答案")
	@GetMapping("findAnswerById")
	public MsgResponse findAnswerById(long id) {
		try {
			Answer answer = answerService.findById(id);
			return MsgResponse.success("查询成功", answer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存答案")
	@PostMapping("saveAnswer")
	public MsgResponse saveAnswer(Answer answer) {
		try {
			answerService.save(answer);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新答案")
	@PostMapping("updateAnswerInfo")
	public MsgResponse updateAnswerInfo(Answer answer) {
		try {
			answerService.update(answer);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id删除答案")
	@GetMapping("deleteAnswerById")
	public MsgResponse deleteAnswerById(long id) {
		try {
			answerService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
