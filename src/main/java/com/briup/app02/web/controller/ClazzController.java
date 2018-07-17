package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired
	private IClazzService clazzService;

	@ApiOperation(value="查询所有班级",notes="只能查询出班级的基本信息，无法级联查询到年级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz() {
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有班级",notes="查询出班级的基本信息，并且级联查询到年级和班主任")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM() {
		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询班级",notes="只能查询出班级的基本信息，无法级联查询到年级和班主任")
	@GetMapping("findClazzById")
	public MsgResponse findClazzById(long id) {
		try {
			Clazz clazz = clazzService.findById(id);
			return MsgResponse.success("查询成功", clazz);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询班级",notes="查询出班级的基本信息，可以级联查询到年级和班主任")
	@GetMapping("findClazzVMById")
	public MsgResponse findClazzVMById(long id) {
		try {
			ClazzVM clazzVM = clazzService.findClazzVMById(id);
			return MsgResponse.success("查询成功", clazzVM);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="保存班级",notes="保存班级所有信息")
	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz) {
		try {
			clazzService.save(clazz);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="更新班级",notes="更新班级所有信息")
	@PostMapping("updateClazzInfo")
	public MsgResponse updateClazzInfo(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="删除班级",notes="删除班级所有信息")
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id) {
		try {
			clazzService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
