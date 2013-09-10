package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ooti.caa.dao.EvaluationDAO;
import ooti.caa.model.Evaluation;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateEvaluationDAO implements EvaluationDAO {

	private Session session;

	public HibernateEvaluationDAO(Session session) {
		this.session = session;
	}

	@Override
	public int addEvaluation(Evaluation item) {
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

		}
		return 0;
	}

	@Override
	public boolean deleteEvaluation(Evaluation item) {
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

		}
		return false;
	}

	@Override
	public boolean updateEvaluation(Evaluation item) {
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

		}
		return false;
	}

	@Override
	public Evaluation getEvaluationById(int id) {
		Evaluation evaluation = new Evaluation();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Evaluation where id = :id");
			query.setParameter("id", id);
			evaluation = (Evaluation) query.uniqueResult();
			this.session.getTransaction().commit();
			return evaluation;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return evaluation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluation> getEvaluationByCourseId(int courseId) {
		List<Evaluation> list = new ArrayList<Evaluation>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Evaluation E where E.courseId = :courseId");
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
	@Override
	public List<Evaluation> getEvaluationByUserId(int userId) {
		List<Evaluation> list = new ArrayList<Evaluation>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Evaluation E where E.userId = :userId");
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
	public List<Evaluation> getEvaluationByAdviceId(int adviceId) {
		List<Evaluation> list = new ArrayList<Evaluation>();
		try {
			this.session.beginTransaction();
			Query query = this.session
					.createQuery("from Evaluation where advice.id = :adviceId");
			query.setParameter("adviceId", adviceId);
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
	public List<Evaluation> getAllEvaluations() {
		List<Evaluation> list = new ArrayList<Evaluation>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Evaluation");
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
