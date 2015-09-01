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

import com.dzxc.dao.IAlbumDAO;
import com.dzxc.entity.Album.Album;

/**
 * A data access object (DAO) providing persistence and search support for Album
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.dzxc.entity.Album.Album
 * @author MyEclipse Persistence Tools
 */

public class AlbumDAO extends HibernateDaoSupport implements IAlbumDAO{
	private static final Logger log = LoggerFactory.getLogger(AlbumDAO.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#save(com.dzxc.entity.Album.Album)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#save(com.dzxc.entity.Album.Album)
	 */
	@Override
	public void save(Album transientInstance) {
		log.debug("saving Album instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#delete(com.dzxc.entity.Album.Album)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#delete(com.dzxc.entity.Album.Album)
	 */
	@Override
	public void delete(Album persistentInstance) {
		log.debug("deleting Album instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findById(java.lang.Integer)
	 */
	@Override
	public Album findById(java.lang.Integer id) {
		log.debug("getting Album instance with id: " + id);
		try {
			Album instance = (Album) getHibernateTemplate().get(
					"com.dzxc.entity.Album.Album", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByExample(com.dzxc.entity.Album.Album)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByExample(com.dzxc.entity.Album.Album)
	 */
	
	@Override
	public List findByExample(Album instance) {
		log.debug("finding Album instance by example");
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
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Album instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Album as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByAlbumName(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByAlbumName(java.lang.Object)
	 */
	
	@Override
	public List findByAlbumName(Object albumName) {
		return findByProperty(ALBUM_NAME, albumName);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByAlbumDesc(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByAlbumDesc(java.lang.Object)
	 */
	@Override
	
	public List findByAlbumDesc(Object albumDesc) {
		return findByProperty(ALBUM_DESC, albumDesc);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByCreateDate(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByCreateDate(java.lang.Object)
	 */
	
	@Override
	public List findByCreateDate(Object createDate) {
		return findByProperty(CREATE_DATE, createDate);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByUserId(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByUserId(java.lang.Object)
	 */
	
	@Override
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByKindId(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByKindId(java.lang.Object)
	 */
	
	@Override
	public List findByKindId(Object kindId) {
		return findByProperty(KIND_ID, kindId);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findByCover(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findByCover(java.lang.Object)
	 */
	
	@Override
	public List findByCover(Object cover) {
		return findByProperty(COVER, cover);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#findAll()
	 */
	@Override
	
	public List findAll() {
		log.debug("finding all Album instances");
		try {
			String queryString = "from Album";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.entity.Album.IAlbumDAO#merge(com.dzxc.entity.Album.Album)
	 */
	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#merge(com.dzxc.entity.Album.Album)
	 */
	@Override
	
	public Album merge(Album detachedInstance) {
		log.debug("merging Album instance");
		try {
			Album result = (Album) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#attachDirty(com.dzxc.entity.Album.Album)
	 */
	@Override
	public void attachDirty(Album instance) {
		log.debug("attaching dirty Album instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IAbumDAO#attachClean(com.dzxc.entity.Album.Album)
	 */
	@Override
	public void attachClean(Album instance) {
		log.debug("attaching clean Album instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
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

	public static IAlbumDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IAlbumDAO) ctx.getBean("AlbumDAO");
	}
}