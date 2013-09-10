package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.University;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface UniversityDAO {

	/**
	 * 
	 * @param university
	 */
	public int addUniversity(University item);

	/**
	 * 
	 * @param id
	 */
	public boolean deleteUniversity(University item);

	/**
	 * 
	 * @param university
	 */
	public boolean updateUniversity(University item);

	public University getUniversityById(int id);
	
	public List<University> getAllUniversities();

}