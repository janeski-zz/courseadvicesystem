package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ooti.caa.dao.CourseDAO;
import ooti.caa.model.Course;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateCourseDAO implements CourseDAO {

	private Session session;

	public HibernateCourseDAO(final Session session) {
		this.session = session;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param Course
	 */
	public int addCourse(Course item) {
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
	 * @param int
	 */
	public boolean deleteCourse(Course item) {
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
	 * @param Course
	 */
	public boolean updateCourse(Course item) {
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
	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<Course>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Course");
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

	/**
	 * 
	 * @param int
	 */
	public Course getCourseById(int id) {
		Course course = new Course();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from course where id = :id");
			query.setParameter("id", id);
			course = (Course)query.uniqueResult();
			this.session.getTransaction().commit();
			return course;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			
		}
		return course;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCoursesByStudyProgramId(int studyProgramId) {
		List<Course> list = new ArrayList<Course>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("select c from Course c join c.studyProgrammes as s where s.id = :studyProgram");
			query.setParameter("studyProgram", studyProgramId);
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
	public List<Course> getAllCoursesByUserId(int userId) {
		List<Course> list = new ArrayList<Course>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Course C where C.userid = :user");
			query.setParameter("user", userId);
			
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