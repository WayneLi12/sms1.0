package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/Qq")
public class QqController {

	@Autowired
	private IQqService qqService;
	
	@GetMapping("findAllQq")
	public MsgResponse findAllQq(){
		try {
			List<Qq> list = qqService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findQqById")
	public MsgResponse findQqById(long id){
		try {
			Qq q = qqService.findById(id);
			return MsgResponse.success("查询成功", q);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveQq")
	public MsgResponse saveQq(Qq q){
		try {
			qqService.save(q);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateQqInfo")
	public MsgResponse updateQqInfo(Qq q){
		try {
			qqService.update(q);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("deleteQq")
	public MsgResponse deleteQq(long id){
		try {
			qqService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
