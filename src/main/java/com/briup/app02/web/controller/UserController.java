package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.UserVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="教师相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="查询所有教师")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("查找成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有教师",notes="并且级联查询到所带班级")
	@GetMapping("findAllUserVM")
	public MsgResponse findAllUserVM(){
		try {
			List<UserVM> list = userService.findAllUserVM();
			return MsgResponse.success("查找成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查找教师")
	@GetMapping("findUserById")
	public MsgResponse findUserById(long id){
		try {
			User user = userService.findById(id);
			return MsgResponse.success("查找成功", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查找教师")
	@GetMapping("findUserVMById")
	public MsgResponse findUserVMById(long id){
		try {
			UserVM user = userService.findUserVMById(id);
			return MsgResponse.success("查找成功", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存教师")
	@PostMapping("saveUserInfo")
	public MsgResponse saveUserInfo(User user){
		try {
			userService.save(user);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新教师")
	@PostMapping("updateUser")
	public MsgResponse updateUser(User user){
		try {
			userService.update(user);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除教师")
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id){
		try {
			userService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
