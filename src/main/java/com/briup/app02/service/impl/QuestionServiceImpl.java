package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Question;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.dao.extend.QuestionVMMapper;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.vm.QuestionVM;

@Service
public class QuestionServiceImpl implements IQuestionService{
	
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	

	@Override
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Question> list = questionMapper.findAll();
		return list;
	}
	
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		// TODO Auto-generated method stub
		List<QuestionVM> list = questionVMMapper.findAllQuestionVM();
		return list;
	}

	@Override
	public Question findById(long id) throws Exception {
		// TODO Auto-generated method stub
		
		return questionMapper.findById(id);
	}
	
	@Override
	public QuestionVM findQuestionVMById(long id) throws Exception {
		// TODO Auto-generated method stub
		
		return questionVMMapper.findQuestionVMById(id);
	}

	@Override
	public void save(Question question) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.save(question);
	}

	@Override
	public void update(Question question) throws Exception {
		// TODO Auto-generated method stub
		Question q = questionMapper.findById(question.getId());
		if(q != null){
			questionMapper.update(question);
		}
		else{
			throw new Exception("要更新的问题不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Question q = questionMapper.findById(id);
		if(q != null){
			questionMapper.delete(id);
		}
		else{
			throw new Exception("要删除的问题不存在");
		}
	}
	
}
