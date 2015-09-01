package com.dzxc.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dzxc.dao.IPhotowordDAO;
import com.dzxc.entity.Photoword.Photoword;

/**
 * A data access object (DAO) providing persistence and search support for
 * Photoword entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dzxc.entity.Photoword.Photoword
 * @author MyEclipse Persistence Tools
 */

public class PhotowordDAO extends HibernateDaoSupport implements IPhotowordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PhotowordDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String WORD_DATE = "wordDate";
	public static final String USER_ID = "userId";
	public static final String PHOTO_ID = "photoId";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#save(com.dzxc.entity.Photoword.Photoword)
	 */
	@Override
	public void save(Photoword transientInstance) {
		log.debug("saving Photoword instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#delete(com.dzxc.entity.Photoword.Photoword)
	 */
	@Override
	public void delete(Photoword persistentInstance) {
		log.debug("deleting Photoword instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Photoword findById(java.lang.Integer id) {
		log.debug("getting Photoword instance with id: " + id);
		try {
			Photoword instance = (Photoword) getHibernateTemplate().get(
					"com.dzxc.entity.Photoword.Photoword", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByExample(com.dzxc.entity.Photoword.Photoword)
	 */
	@Override
	public List findByExample(Photoword instance) {
		log.debug("finding Photoword instance by example");
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
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Photoword instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Photoword as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByTitle(java.lang.Object)
	 */
	@Override
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByWordDate(java.lang.Object)
	 */
	@Override
	public List findByWordDate(Object wordDate) {
		return findByProperty(WORD_DATE, wordDate);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByUserId(java.lang.Object)
	 */
	@Override
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findByPhotoId(java.lang.Object)
	 */
	@Override
	public List findByPhotoId(Object photoId) {
		return findByProperty(PHOTO_ID, photoId);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Photoword instances");
		try {
			String queryString = "from Photoword";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IPhotowordDAO#merge(com.dzxc.entity.Photoword.Photoword)
	 */
	@Override
	public Photoword merge(Photoword detachedInstance) {
		log.debug("merging Photoword instance");
		try {
			Photoword result = (Photoword) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Photoword instance) {
		log.debug("attaching dirty Photoword instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Photoword instance) {
		log.debug("attaching clean Photoword instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPhotowordDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IPhotowordDAO) ctx.getBean("PhotowordDAO");
	}
}