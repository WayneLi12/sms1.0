package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.dao.extend.SurveyVMMapper;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.vm.SurveyVM;

@Service
public class SurveyServiceImpl implements ISurveyService{

	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;
	

	@Override
	public List<Survey> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Survey> list = surveyMapper.findAll();
		return list;
	}

	
	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		List<SurveyVM> list = surveyVMMapper.findAllSurveyVM();
		return list;
	}
	
	@Override
	public Survey findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.findById(id);
	}
	
	@Override
	public SurveyVM findSurveyVMById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.findSurveyVMById(id);
	}

	@Override
	public void save(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.save(survey);
	}

	@Override
	public void update(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		Survey s = surveyMapper.findById(survey.getId());
		if(s != null){
			surveyMapper.update(survey);
		}
		else{
			throw new Exception("要修改的调查不存在");
		}
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Survey s = surveyMapper.findById(id);
		if(s != null){
			surveyMapper.delete(id);
		}
		else{
			throw new Exception("要删除的调查不存在");
		}
	}

}
