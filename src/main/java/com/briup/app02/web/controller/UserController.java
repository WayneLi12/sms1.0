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

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
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
