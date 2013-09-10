package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.Advice;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface AdviceDAO {

	/**
	 * method for adding Advice object to the database.
	 * @param item object to be added to the database
	 * @return returns the Id of the inserted advice
	 */
	int addAdvice(Advice item);

	/**
	 * 
	 * @param id
	 */
	boolean deleteAdvice(Advice item);

	/**
	 * 
	 * @param advice
	 */
	boolean updateAdvice(Advice item);

	/**
	 * 
	 * @param Id
	 */
	Advice getAdviceById(int Id);

	/**
	 * 
	 * @param courseId
	 */
	List<Advice> getAdviceByCourseId(int courseId);
	
	List<Advice> getAdviceByUserId(int userId);
	
	List<Advice> getAdviceByUserIdByCourseId(int userId, int courseId);

	List<Advice> getAllAdvices();

}