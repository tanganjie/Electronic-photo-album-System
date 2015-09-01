package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.Dictionary.DQuestion;
import com.dzxc.entity.User.User;

public interface IDQuestionDAO {

	public abstract void save(DQuestion transientInstance);

	public abstract void delete(DQuestion persistentInstance);

	public abstract List findByExample(DQuestion instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRemark(Object remark);

	public abstract List findAll();

	public abstract DQuestion merge(DQuestion detachedInstance);
	public DQuestion findById(java.lang.Integer id);

}