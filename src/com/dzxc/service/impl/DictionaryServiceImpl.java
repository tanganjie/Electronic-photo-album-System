package com.dzxc.service.impl;

import java.util.List;

import com.dzxc.base.service.BaseService;
import com.dzxc.entity.Dictionary.DQuestion;
import com.dzxc.service.IDictionaryService;

public class DictionaryServiceImpl extends BaseService implements IDictionaryService {

	@Override
	public List<DQuestion> getQuestionList() {
		// TODO Auto-generated method stub
		return this.getdQuestionDAO().findAll();
	}

	@Override
	public DQuestion findQuestion(String id) {
		// TODO Auto-generated method stub
		return this.getdQuestionDAO().findById(Integer.parseInt(id));
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		this.getdQuestionDAO().delete(this.getdQuestionDAO().findById(id));
	}

	@Override
	public void addQuestion(DQuestion question) {
		// TODO Auto-generated method stub
		this.getdQuestionDAO().save(question);
	}

	@Override
	public void updateQuestion(DQuestion question) {
		// TODO Auto-generated method stub
		this.getdQuestionDAO().merge(question);
	}
}
