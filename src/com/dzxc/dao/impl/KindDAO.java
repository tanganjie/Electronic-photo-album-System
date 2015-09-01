package com.dzxc.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dzxc.dao.IKindDAO;
import com.dzxc.entity.Kind.Kind;

/**
 * A data access object (DAO) providing persistence and search support for Kind
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.dzxc.entity.Kind.Kind
 * @author MyEclipse Persistence Tools
 */

public class KindDAO extends HibernateDaoSupport implements IKindDAO {
	private static final Logger log = LoggerFactory.getLogger(KindDAO.class);
	// property constants
	public static final String KIND_NAME = "kindName";
	public static final String KIND_DESC = "kindDesc";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#save(com.dzxc.entity.Kind.Kind)
	 */
	@Override
	public void save(Kind transientInstance) {
		log.debug("saving Kind instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#delete(com.dzxc.entity.Kind.Kind)
	 */
	@Override
	public void delete(Kind persistentInstance) {
		log.debug("deleting Kind instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kind findById(java.lang.Integer id) {
		log.debug("getting Kind instance with id: " + id);
		try {
			Kind instance = (Kind) getHibernateTemplate().get(
					"com.dzxc.entity.Kind.Kind", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#findByExample(com.dzxc.entity.Kind.Kind)
	 */
	@Override
	public List findByExample(Kind instance) {
		log.debug("finding Kind instance by example");
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
	 * @see com.dzxc.dao.impl.IKindDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Kind instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Kind as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#findByKindName(java.lang.Object)
	 */
	@Override
	public List findByKindName(Object kindName) {
		return findByProperty(KIND_NAME, kindName);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#findByKindDesc(java.lang.Object)
	 */
	@Override
	public List findByKindDesc(Object kindDesc) {
		return findByProperty(KIND_DESC, kindDesc);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Kind instances");
		try {
			String queryString = "from Kind";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IKindDAO#merge(com.dzxc.entity.Kind.Kind)
	 */
	@Override
	public Kind merge(Kind detachedInstance) {
		log.debug("merging Kind instance");
		try {
			Kind result = (Kind) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Kind instance) {
		log.debug("attaching dirty Kind instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Kind instance) {
		log.debug("attaching clean Kind instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IKindDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IKindDAO) ctx.getBean("KindDAO");
	}
}