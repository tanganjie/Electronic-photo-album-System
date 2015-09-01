package com.dzxc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dzxc.dao.IPhotoDAO;
import com.dzxc.entity.Photo.Photo;

/**
 * A data access object (DAO) providing persistence and search support for Photo
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.dzxc.entity.Photo.Photo
 * @author MyEclipse Persistence Tools
 */

public class PhotoDAO extends HibernateDaoSupport implements IPhotoDAO {
	private static final Logger log = LoggerFactory.getLogger(PhotoDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String PHOTO_DESC = "photoDesc";
	public static final String PIC_URL = "picUrl";
	public static final String SMALL_PIC_URL = "smallPicUrl";
	public static final String UPLOAD_DATE = "uploadDate";
	public static final String ALBUM_ID = "albumId";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#save(com.dzxc.entity.Photo.Photo)
	 */
	@Override
	public void save(Photo transientInstance) {
		log.debug("saving Photo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#delete(com.dzxc.entity.Photo.Photo)
	 */
	@Override
	public void delete(Photo persistentInstance) {
		log.debug("deleting Photo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Photo findById(java.lang.Integer id) {
		log.debug("getting Photo instance with id: " + id);
		try {
			Photo instance = (Photo) getHibernateTemplate().get(
					"com.dzxc.entity.Photo.Photo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByExample(com.dzxc.entity.Photo.Photo)
	 */
	@Override
	public List findByExample(Photo instance) {
		log.debug("finding Photo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Photo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Photo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByTitle(java.lang.Object)
	 */
	@Override
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByPhotoDesc(java.lang.Object)
	 */
	@Override
	public List findByPhotoDesc(Object photoDesc) {
		return findByProperty(PHOTO_DESC, photoDesc);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByPicUrl(java.lang.Object)
	 */
	@Override
	public List findByPicUrl(Object picUrl) {
		return findByProperty(PIC_URL, picUrl);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findBySmallPicUrl(java.lang.Object)
	 */
	@Override
	public List findBySmallPicUrl(Object smallPicUrl) {
		return findByProperty(SMALL_PIC_URL, smallPicUrl);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByUploadDate(java.lang.Object)
	 */
	@Override
	public List findByUploadDate(Object uploadDate) {
		return findByProperty(UPLOAD_DATE, uploadDate);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findByAlbumId(java.lang.Object)
	 */
	@Override
	public List findByAlbumId(Object albumId) {
		return findByProperty(ALBUM_ID, albumId);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Photo instances");
		try {
			String queryString = "from Photo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotoDAO#merge(com.dzxc.entity.Photo.Photo)
	 */
	@Override
	public Photo merge(Photo detachedInstance) {
		log.debug("merging Photo instance");
		try {
			Photo result = (Photo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Photo instance) {
		log.debug("attaching dirty Photo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Photo instance) {
		log.debug("attaching clean Photo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPhotoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IPhotoDAO) ctx.getBean("PhotoDAO");
	}
	
	public List queryForPage(final String hql, final int offset, final int length){
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException{
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	public int getAllRowCount(String hql){
		return this.getHibernateTemplate().find(hql).size();
	}
}