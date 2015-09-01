package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.Kind.Kind;

public interface IKindDAO {

	public abstract void save(Kind transientInstance);

	public abstract void delete(Kind persistentInstance);

	public abstract List findByExample(Kind instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByKindName(Object kindName);

	public abstract List findByKindDesc(Object kindDesc);

	public abstract List findAll();

	public abstract Kind merge(Kind detachedInstance);
	
	public Kind findById(java.lang.Integer id);

}