package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Question;
import com.briup.app02.vm.QuestionVM;

public interface IQuestionService {
	List<Question> findAll() throws Exception;
	
	List<QuestionVM> findAllQuestionVM() throws Exception;
	
	Question findById(long id) throws Exception;
	
	QuestionVM findQuestionVMById(long id) throws Exception;
	
	void saveQuestionVM(QuestionVM questionVM) throws Exception;
	
	void update(Question question) throws Exception;
	
	void delete(long id) throws Exception;
}
