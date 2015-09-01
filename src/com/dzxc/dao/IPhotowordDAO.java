package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.Photoword.Photoword;

public interface IPhotowordDAO {

	public abstract void save(Photoword transientInstance);

	public abstract void delete(Photoword persistentInstance);

	public abstract List findByExample(Photoword instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByWordDate(Object wordDate);

	public abstract List findByUserId(Object userId);

	public abstract List findByPhotoId(Object photoId);

	public abstract List findAll();

	public abstract Photoword merge(Photoword detachedInstance);
	
	public Photoword findById(java.lang.Integer id);

}