package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import ooti.caa.dao.AdviceDAO;
import ooti.caa.model.Advice;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateAdviceDAO implements AdviceDAO {

	private Session session;

	/**
	 * @param session
	 */
	public HibernateAdviceDAO(final Session session) {
		this.session = session;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param advice
	 */
	public int addAdvice(Advice item) {
		try {
			this.session.beginTransaction();
			item.setCreated(new Date());
			this.session.save(item);
			this.session.getTransaction().commit();
			return item.getId();
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			this.session.close();
		}
		return 0;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean deleteAdvice(Advice item) {
		try {
			this.session.beginTransaction();
			item.setActive(false);
			item.setUpdated(new Date());
			this.session.update(item);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			this.session.close();
		}
		return false;
	}

	/**
	 * 
	 * @param advice
	 */
	public boolean updateAdvice(Advice item) {
		try {
			this.session.beginTransaction();
			item.setUpdated(new Date());
			this.session.update(item);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			this.session.close();
		}
		return false;
	}

	/**
	 * 
	 * @param Id
	 */
	public Advice getAdviceById(int id) {
		Advice advice = new Advice();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Advice where id = :id");
			query.setParameter("id", id);
			advice = (Advice) query.uniqueResult();
			this.session.getTransaction().commit();
			return advice;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return advice;
	}

	/**
	 * 
	 * @param courseId
	 */
	@SuppressWarnings("unchecked")
	public List<Advice> getAdviceByCourseId(int courseId) {
		List<Advice> list = new ArrayList<Advice>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Advice where course.id = :courseId");
			query.setParameter("courseId", courseId);
			list = query.list();
			this.session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Advice> getAllAdvices() {
		List<Advice> list = new ArrayList<Advice>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Advice");
			list = query.list();
			this.session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advice> getAdviceByUserId(int userId) {
		List<Advice> list = new ArrayList<Advice>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Advice where creator.id = :userId");
			query.setParameter("userId", userId);
			list = query.list();
			this.session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advice> getAdviceByUserIdByCourseId(int userId, int courseId) {
		List<Advice> list = new ArrayList<Advice>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Advice where creator.id = :userId and course.id = :courseId");
			query.setParameter("userId", userId);
			query.setParameter("courseId", courseId);
			list = query.list();
			this.session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return list;
	}
}