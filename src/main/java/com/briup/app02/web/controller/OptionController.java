package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.OptionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private IOptionService optionService;
	
	@ApiOperation(value="查询所有选项",notes="只能查询出选项的基本信息，无法级联查询到问题")
	@GetMapping("findAllOption")
	public MsgResponse findAllOption(){
		try {
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="查询所有选项",notes="查询出选项的基本信息，并且可以级联查询到问题")
	@GetMapping("findAllOptionVM")
	public MsgResponse findAllOptionVM(){
		try {
			List<OptionVM> list = optionService.findAllOptionVM(); 
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询选项",notes="查询出想选项的基本信息，无法级联查询到问题")
	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id){
		try {
			Option option= optionService.findById(id);
			return MsgResponse.success("查询成功", option);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询选项",notes="查询出选项的基本信息，并且可以级联查询到问题")
	@GetMapping("findOptionVMById")
	public MsgResponse findOptionVMById(long id){
		try {
			OptionVM optionVM = optionService.findOptionVMById(id);
			return MsgResponse.success("查询成功", optionVM);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
