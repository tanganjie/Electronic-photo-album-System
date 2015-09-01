package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.Photo.Photo;

public interface IPhotoDAO {

	public abstract void save(Photo transientInstance);

	public abstract void delete(Photo persistentInstance);

	public abstract List findByExample(Photo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByPhotoDesc(Object photoDesc);

	public abstract List findByPicUrl(Object picUrl);

	public abstract List findBySmallPicUrl(Object smallPicUrl);

	public abstract List findByUploadDate(Object uploadDate);

	public abstract List findByAlbumId(Object albumId);

	public abstract List findAll();

	public abstract Photo merge(Photo detachedInstance);

	public Photo findById(java.lang.Integer id);
	
	public List queryForPage(final String hql, final int offset, final int length);
	
	public int getAllRowCount(String hql);
}