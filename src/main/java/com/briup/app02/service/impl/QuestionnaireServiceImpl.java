package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.dao.extend.QuestionnaireVMMapper;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.vm.QuestionnaireVM;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{

	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;

	@Override
	public List<Questionnaire> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Questionnaire> list = questionnaireMapper.findAll();
		return list;
	}
	
	@Override
	public Questionnaire findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireMapper.findById(id);
	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.save(questionnaire);
	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		Questionnaire q = questionnaireMapper.findById(questionnaire.getId());
		if(q != null){
			questionnaireMapper.update(questionnaire);
		}
		else{
			throw new Exception("要修改的问卷不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Questionnaire q = questionnaireMapper.findById(id);
		if(q != null){
			questionnaireMapper.delete(id);
		}
		else{
			throw new Exception("要修改的问卷不存在");
		}
	}

	@Override
	public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
		// TODO Auto-generated method stub
		return questionnaireVMMapper.findAllQuestionnaireVM();
	}

	@Override
	public QuestionnaireVM findQuestionnaireVMById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireVMMapper.findQuestionnaireVMById(id);
	}
	
}
