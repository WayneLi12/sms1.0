package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	List<Option> findAll();

	Option findById(long id);

	void save(Option option);

	void update(Option option);

	void delete(long id);
}
