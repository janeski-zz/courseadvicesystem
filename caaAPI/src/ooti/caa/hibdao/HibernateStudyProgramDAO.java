package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ooti.caa.dao.StudyProgramDAO;
import ooti.caa.model.StudyProgram;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateStudyProgramDAO implements StudyProgramDAO {

	private Session session;

	public HibernateStudyProgramDAO(final Session session) {
		this.session = session;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param studyProgram
	 */
	public int addStudyProgram(StudyProgram item) {
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

	/**
	 * 
	 * @param id
	 */
	public boolean deleteStudyProgram(StudyProgram item) {
		try {
			this.session.beginTransaction();
			item.setUpdated(new Date());
			item.setActive(false);
			this.session.update(item);
			this.session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return false;
	}

	/**
	 * 
	 * @param studyProgram
	 */
	public boolean updateStudyProgram(StudyProgram item) {
		try {
			this.session.beginTransaction();
			item.setUpdated(new Date());
			this.session.update(item);
			this.session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<StudyProgram> getAllStudyProgram() {
		List<StudyProgram> list = new ArrayList<StudyProgram>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from StudyProgram");
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

	@Override
	public StudyProgram getStudyProgramById(int id) {
		StudyProgram studyProgram = new StudyProgram();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from StudyProgram where id = :id");
			query.setParameter("id", id);
			studyProgram = (StudyProgram)query.uniqueResult();
			this.session.getTransaction().commit();
			return studyProgram;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			
		}
		return studyProgram;
	}
}