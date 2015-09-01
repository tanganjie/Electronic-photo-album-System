package com.dzxc.dao;

import java.util.List;

import com.dzxc.entity.Album.Album;

public interface IAlbumDAO {

	// property constants
	public static final String ALBUM_NAME = "albumName";
	public static final String ALBUM_DESC = "albumDesc";
	public static final String CREATE_DATE = "createDate";
	public static final String USER_ID = "userId";
	public static final String KIND_ID = "kindId";
	public static final String COVER = "cover";

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#save(com.dzxc.entity.Album.Album)
	 */
	public abstract void save(Album transientInstance);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#delete(com.dzxc.entity.Album.Album)
	 */
	public abstract void delete(Album persistentInstance);

	public abstract Album findById(java.lang.Integer id);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByExample(com.dzxc.entity.Album.Album)
	 */
	public abstract List findByExample(Album instance);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public abstract List findByProperty(String propertyName, Object value);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByAlbumName(java.lang.Object)
	 */
	public abstract List findByAlbumName(Object albumName);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByAlbumDesc(java.lang.Object)
	 */
	public abstract List findByAlbumDesc(Object albumDesc);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByCreateDate(java.lang.Object)
	 */
	public abstract List findByCreateDate(Object createDate);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByUserId(java.lang.Object)
	 */
	public abstract List findByUserId(Object userId);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByKindId(java.lang.Object)
	 */
	public abstract List findByKindId(Object kindId);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByCover(java.lang.Object)
	 */
	public abstract List findByCover(Object cover);

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findAll()
	 */
	public abstract List findAll();

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#merge(com.dzxc.entity.Album.Album)
	 */
	public abstract Album merge(Album detachedInstance);

	public abstract void attachDirty(Album instance);

	public abstract void attachClean(Album instance);
	

	public List queryForPage(final String hql, final int offset, final int length);
	
	public int getAllRowCount(String hql);

}