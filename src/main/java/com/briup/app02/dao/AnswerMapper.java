package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	List<Answer> findAll();
	
	List<Answer> findBySurveyId(long id);
	
	Answer findById(long id);
	
	void save(Answer answer);
	
	void update(Answer answer);
	
	void delete(long id);
}
