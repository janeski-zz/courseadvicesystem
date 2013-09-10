package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import ooti.caa.dao.FacultyDAO;
import ooti.caa.model.Faculty;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateFacultyDAO implements FacultyDAO {

	private Session session;

	public HibernateFacultyDAO(final Session session) {
		this.session = session;
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param item
	 */
	public int addFaculty(Faculty item) {
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
	 * @param item
	 */
	public boolean deleteFaculty(Faculty item) {
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
	 * @param item
	 */
	public boolean updateFaculty(Faculty item) {
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
	public List<Faculty> getAllFaculties() {
		List<Faculty> list = new ArrayList<Faculty>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Faculty");
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
	/**
	 * 
	 * @param universityId
	 */
	public List<Faculty> getAllFacultiesByUniversityId(int universityId) {
		List<Faculty> list = new ArrayList<Faculty>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Faculty F where F.universityid = :uni");
			query.setParameter("uni", universityId);
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