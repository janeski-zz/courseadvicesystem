package ooti.caa.hibdao;

import ooti.caa.dao.AdviceDAO;
import ooti.caa.dao.CourseDAO;
import ooti.caa.dao.DAOFactory;
import ooti.caa.dao.EvaluationDAO;
import ooti.caa.dao.FacultyDAO;
import ooti.caa.dao.StudentDAO;
import ooti.caa.dao.StudyProgramDAO;
import ooti.caa.dao.UniversityDAO;
import ooti.caa.hibdao.HibernateAdviceDAO;
import ooti.caa.hibdao.HibernateCourseDAO;
import ooti.caa.hibdao.HibernateEvaluationDAO;
import ooti.caa.hibdao.HibernateStudentDAO;
import ooti.caa.hibdao.HibernateStudyProgramDAO;
import ooti.caa.hibdao.HibernateUniversityDAO;
import ooti.caa.hibdao.HibernateFacultyDAO;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author mjaneski
 * @version 1.0
 */
public class HibernateDAOFactory extends DAOFactory {

	/**
	 * instance of HibernateDAOFactory.
	 */
	private static HibernateDAOFactory instance = null;

	/**
	 * SessionFactory object.
	 */
	private static SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * ServiceRegistry object.
	 */
	private static ServiceRegistry serviceRegistry;


	public final void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * HibernateDAOFactory constructor.
	 */
	private HibernateDAOFactory() {

	}


	/**
	 * @return HibernateDAOFactory singleton instance
	 */
	public static final HibernateDAOFactory getInstance() {
		if (instance == null) {
			instance = new HibernateDAOFactory();
		}
		return instance;
	}

	/**
	 * @return AdviceDAO object
	 */
	@Override
	public final AdviceDAO getAdviceDAO() {
		return new HibernateAdviceDAO(getSessionFactory().openSession());
	}

	/**
	 * @return CourseDAO object
	 */
	@Override
	public final CourseDAO getCourseDAO() {
		return new HibernateCourseDAO(getSessionFactory().openSession());
	}

	/**
	 * @return AdviceDAO object
	 */
	@Override
	public final UniversityDAO getUniversityDAO() {
		return new HibernateUniversityDAO(getSessionFactory().openSession());
	}

	/**
	 * @return CourseDAO object
	 */
	@Override
	public final StudyProgramDAO getStudyProgramDAO() {
		return new HibernateStudyProgramDAO(getSessionFactory().openSession());
	}

	/**
	 * @return SessionFactory object.
	 */
	private static SessionFactory buildSessionFactory() {
	        try {
	        	Configuration configuration = new Configuration();
	            configuration.configure();
	            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            return sessionFactory;
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	/**
	 * @return the SessionFactory object
	 */
	private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public FacultyDAO getFactoryDAO() {
		return new HibernateFacultyDAO(getSessionFactory().openSession());
	}

	@Override
	public StudentDAO getStudentDAO() {
		return new HibernateStudentDAO(getSessionFactory().openSession());
	}

	@Override
	public EvaluationDAO getEvaluationDAO() {
		return new HibernateEvaluationDAO(getSessionFactory().openSession());
	}

}