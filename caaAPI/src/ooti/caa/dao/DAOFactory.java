package ooti.caa.dao;

import ooti.caa.dao.AdviceDAO;
import ooti.caa.dao.CourseDAO;
import ooti.caa.dao.EvaluationDAO;
import ooti.caa.dao.FacultyDAO;
import ooti.caa.dao.StudentDAO;
import ooti.caa.dao.StudyProgramDAO;
import ooti.caa.dao.UniversityDAO;
import ooti.caa.hibdao.HibernateDAOFactory;

/**
 * @author mjaneski
 * @version 1.0
 */
public abstract class DAOFactory {

	/**
	 * Id number for the Hibernate factory.
	 */
	public static final int HIBERNATE = 1;

	/**
	 * DAOFactory constructor.
	 */
	public DAOFactory() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * getDAOFactory returns appropriate DAO factory according to the
	 * whichFactory parameter.
	 * @param whichFactory factoryId of the preferred factory
	 * @return returns appropriate DAO factory
	 */
	public static DAOFactory getDAOFactory(final int whichFactory) {
		    switch (whichFactory) {
		      case HIBERNATE:
		          return HibernateDAOFactory.getInstance();
			default: return HibernateDAOFactory.getInstance();
		    }
	}

	/**
	 * @return CourseDAO object
	 */
	public abstract CourseDAO getCourseDAO();

	/**
	 * @return AdviceDAO object
	 */
	public abstract AdviceDAO getAdviceDAO();

	/**
	 * @return StudyProgramDAO object
	 */
	public abstract StudyProgramDAO getStudyProgramDAO();

	/**
	 * @return UniversityDAO object
	 */
	public abstract UniversityDAO getUniversityDAO();

	/**
	 * @return FacultyDAO object
	 */
	public abstract FacultyDAO getFactoryDAO(); 
	
	/**
	 * @return StudentDAO object
	 */
	public abstract StudentDAO getStudentDAO();
	
	/**
	 * @return EvaluationDAO object
	 */
	public abstract EvaluationDAO getEvaluationDAO();

}