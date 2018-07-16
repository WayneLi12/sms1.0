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

@RestController
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired
	private IClazzService clazzService;

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
