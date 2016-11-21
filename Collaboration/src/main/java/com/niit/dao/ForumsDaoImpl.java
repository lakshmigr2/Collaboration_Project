package com.niit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.model.Forums;

import java.util.List;

import javax.transaction.Transactional;

@Repository("forumsDAO")
@Transactional
public class ForumsDaoImpl implements ForumsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public ForumsDaoImpl() {
		super();
	}

	public ForumsDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateForums(Forums forums) {

		Session session = sessionFactory.openSession();
		try {
			session.saveOrUpdate(forums);
			session.flush();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public Forums getQuestionById(String QuestionId) {
		Session session = sessionFactory.openSession();
		return (Forums) session.get(Forums.class, QuestionId);
	}

	
	
	@Transactional
	public boolean delete(String forumsId) {
		// TODO Auto-generated method stub
		try {

			Forums forums = getQuestionById(forumsId);
			sessionFactory.getCurrentSession().delete(forums);
			sessionFactory.getCurrentSession().flush();

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Transactional
	public List<Forums> getAllForums() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Forums");
		List<Forums> forumss = query.list();
		return forumss;
	}

	

	

}