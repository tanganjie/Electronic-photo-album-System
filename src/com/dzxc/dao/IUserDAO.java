package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.User.User;

public interface IUserDAO {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByPassWord(Object passWord);

	public abstract List findByHead(Object head);

	public abstract List findByRegDate(Object regDate);

	public abstract List findByQuestion(Object question);

	public abstract List findByAnswer(Object answer);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);
	
	public User findById(java.lang.Integer id);

}