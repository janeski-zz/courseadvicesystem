package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.Faculty;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface FacultyDAO {

	/**
	 * 
	 * @param item
	 */
	public int addFaculty(Faculty item);

	/**
	 * 
	 * @param item
	 */
	public boolean deleteFaculty(Faculty item);

	/**
	 * 
	 * @param item
	 */
	public boolean updateFaculty(Faculty item);

	/**
	 * @return
	 */
	public List<Faculty> getAllFaculties();

	/**
	 * 
	 * @param universityId
	 */
	public List<Faculty> getAllFacultiesByUniversityId(int universityId);

}