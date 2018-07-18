package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.bean.Question;
import com.briup.app02.dao.OptionMapper;
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
	@Autowired
	private OptionMapper optionMapper;

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

	@Override
	public void saveQuestionVM(QuestionVM questionVM) throws Exception {
		/*
		 * 1.将question和option从questionVM中剥离出来
		 * 2.question  , List<Option> list
		 * 3.调用QuestionMapper.save(question)
		 * 4.获取刚刚保存的question的id
		 * 5.将所有的选项的外检设置为刚刚获取到question的id
		 * for(Option option : list)
		 * option.setQuestionId(id)
		 * optionMapper.save(option);
		 */
		
		Long questionId = questionVM.getId();
		String questionName = questionVM.getName();
		String questionType = questionVM.getQuestiontype();
		Question question = new Question(questionId, questionName, questionType);
		List<Option> options = questionVM.getOptions();
		//2.保存
		questionMapper.save(question);
		//3.获取刚刚保存问题的id
		Long question_id = question.getId();
		//4.保存选项
		for(Option option : options){
			option.setQuestion_id(question_id);
			optionMapper.save(option);
		}	
	}
}



