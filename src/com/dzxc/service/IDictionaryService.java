package com.dzxc.service;

import java.util.List;

import com.dzxc.entity.Dictionary.DQuestion;

public interface IDictionaryService {
	public List<DQuestion> getQuestionList();
	public DQuestion findQuestion(String id);
	public void deleteQuestion(int id);
	public void addQuestion(DQuestion question);
	public void updateQuestion(DQuestion question);
}
