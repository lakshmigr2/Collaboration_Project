package com.niit.dao;

import java.util.List;

import com.niit.model.Forums;

public interface ForumsDao {

	public void saveOrUpdateForums(Forums forums);

	public Forums getQuestionById(String QuestionId);
	
	public boolean delete(String QuestionId);

	public List<Forums> getAllForums();
}