package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.Evaluation;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface EvaluationDAO {

	/**
	 * method for adding Evaluation object to the database.
	 * @param item object to be added to the database
	 * @return returns the Id of the inserted Evaluation
	 */
	int addEvaluation(Evaluation item);

	/**
	 * 
	 * @param id
	 */
	boolean deleteEvaluation(Evaluation item);

	/**
	 * 
	 * @param Evaluation
	 */
	boolean updateEvaluation(Evaluation item);

	/**
	 * 
	 * @param Id
	 */
	Evaluation getEvaluationById(int Id);

	/**
	 * 
	 * @param courseId
	 */
	List<Evaluation> getEvaluationByCourseId(int courseId);
	
	List<Evaluation> getEvaluationByUserId(int userId);

	List<Evaluation> getEvaluationByAdviceId(int adviceId);

	List<Evaluation> getAllEvaluations();

}