package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	List<Option> findAll();
	
	List<Option> findByQuestionId(long question_id);

	Option findById(long id);

	void save(Option option);

	void update(Option option);

	void delete(long id);
}
