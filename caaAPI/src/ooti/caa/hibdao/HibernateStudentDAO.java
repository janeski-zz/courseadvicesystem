package ooti.caa.hibdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ooti.caa.dao.StudentDAO;
import ooti.caa.model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateStudentDAO implements StudentDAO {

	private Session session;

	public HibernateStudentDAO(final Session session) {
		this.session = session;
	}

	@Override
	public int addStudent(Student item) {
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
	public boolean deleteStudent(Student item) {
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

	@Override
	public boolean updateStudent(Student item) {
		try {
			this.session.beginTransaction();
			item.setUpdated(new Date());
			this.session.saveOrUpdate(item);
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

	@Override
	public Student getStudentById(int id) {
		Student student = new Student();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Student where id = :id");
			query.setParameter("id", id);
			student = (Student)query.uniqueResult();
			this.session.getTransaction().commit();
			return student;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Student");
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
	public List<Student> getAllStudentsByFacultyId(int facultyId) {
		List<Student> list = new ArrayList<Student>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Student S where S.FacultyId = :facultyId");
			query.setParameter("facultyId", facultyId);
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
	public List<Student> getAllStudentsByStudyProgramId(int studyProgramId) {
		List<Student> list = new ArrayList<Student>();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Student S where S.StudyProgramId = :studyProgramId");
			query.setParameter("studyProgramId", studyProgramId);
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
	public Student getStudentByEmail(String email) {
		Student student = new Student();
		try {
			this.session.beginTransaction();
			Query query = this.session.createQuery("from Student where email = :email");
			query.setParameter("email", email);
			student = (Student)query.uniqueResult();
			this.session.getTransaction().commit();
			return student;
		} catch (HibernateException e) {
			if (this.session.getTransaction() != null) {
				this.session.getTransaction().rollback();
			}
		} finally {
			
		}
		return student;
	}

}
