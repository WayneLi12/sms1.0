package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private IOptionService optionService;
	
	@GetMapping("findAllOption")
	public MsgResponse findAllOption(){
		try {
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id){
		try {
			Option option= optionService.findById(id);
			return MsgResponse.success("查询成功", option);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveOption")
	public MsgResponse saveOption(Option option){
		try {
			optionService.save(option);
			return MsgResponse.success("保存成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateOptionInfo")
	public MsgResponse updateOptionInfo(Option option){
		try {
			optionService.update(option);
			return MsgResponse.success("更新成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteOption")
	public MsgResponse deleteOption(long id){
		try {
			optionService.delete(id);
			return MsgResponse.success("删除成功",null);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
	}
}
