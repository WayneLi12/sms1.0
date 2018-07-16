package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;
import com.briup.app02.service.IAnswerService;

@Service
public class AnswerServiceImpl implements IAnswerService{

	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Answer> list = answerMapper.findAll();
		return list;
	}

	@Override
	public Answer findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return answerMapper.findById(id);
	}

	@Override
	public void save(Answer answer) throws Exception {
		// TODO Auto-generated method stub
		answerMapper.save(answer);
	}

	@Override
	public void update(Answer answer) throws Exception {
		// TODO Auto-generated method stub
		Answer a = answerMapper.findById(answer.getId());
		if(a != null){
			answerMapper.update(answer);
		}
		else{
			throw new Exception("要修改的答案不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Answer a = answerMapper.findById(id);
		if(a != null){
			answerMapper.delete(id);
		}
		else{
			throw new Exception("要删除的答案不存在");
		}
	}
}
