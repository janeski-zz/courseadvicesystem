package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import ooti.caa.dao.UniversityDAO;
import ooti.caa.model.University;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateUniversityDAO implements UniversityDAO {

	private Session session;

	public HibernateUniversityDAO(final Session session) {
		this.session = session;
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param university
	 */
	public int addUniversity(University item) {
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
	public boolean deleteUniversity(University item){
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
	 * @param university
	 */
	public boolean updateUniversity(University item){
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
	public List<University> getAllUniversities(){
		List<University> list = new ArrayList<University>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from University");
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
	public University getUniversityById(int id) {
		University university = new University();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from University where id = :id");
			query.setParameter("id", id);
			university = (University)query.uniqueResult();
			this.session.getTransaction().commit();
			return university;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			
		}
		return university;
	}
}