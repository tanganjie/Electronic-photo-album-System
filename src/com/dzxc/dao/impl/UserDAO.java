package com.dzxc.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dzxc.dao.IUserDAO;
import com.dzxc.entity.User.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.dzxc.entity.User.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends HibernateDaoSupport implements IUserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASS_WORD = "passWord";
	public static final String HEAD = "head";
	public static final String REG_DATE = "regDate";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#save(com.dzxc.entity.User.User)
	 */
	@Override
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#delete(com.dzxc.entity.User.User)
	 */
	@Override
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"com.dzxc.entity.User.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByExample(com.dzxc.entity.User.User)
	 */
	@Override
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
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
	 * @see com.dzxc.dao.impl.IUserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByUserName(java.lang.Object)
	 */
	@Override
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByPassWord(java.lang.Object)
	 */
	@Override
	public List findByPassWord(Object passWord) {
		return findByProperty(PASS_WORD, passWord);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByHead(java.lang.Object)
	 */
	@Override
	public List findByHead(Object head) {
		return findByProperty(HEAD, head);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByRegDate(java.lang.Object)
	 */
	@Override
	public List findByRegDate(Object regDate) {
		return findByProperty(REG_DATE, regDate);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByQuestion(java.lang.Object)
	 */
	@Override
	public List findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findByAnswer(java.lang.Object)
	 */
	@Override
	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dzxc.dao.impl.IUserDAO#merge(com.dzxc.entity.User.User)
	 */
	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUserDAO) ctx.getBean("UserDAO");
	}
}