package br.com.desafio.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.desafio.util.HibernateUtil;

public abstract class GenericDAO<Entity> {
	
	private Class<Entity> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void save(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void update(Entity entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("deprecation")
	public List<Entity> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query = session.createCriteria(this.classe);
			List<Entity> result = query.list();
			return result;
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Entity getById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.find(classe, id);

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
