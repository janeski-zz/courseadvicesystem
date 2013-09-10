package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.Course;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface CourseDAO {

	/**
	 * 
	 * @param Course
	 */
	int addCourse(Course item);

	/**
	 * 
	 * @param int
	 */
	boolean deleteCourse(Course item);

	/**
	 * 
	 * @param Course
	 */
	boolean updateCourse(Course item);

	/**
	 * 
	 * @param int
	 */
	Course getCourseById(int id);

	List<Course> getAllCourses();

	List<Course> getAllCoursesByStudyProgramId(int studyProgramId);

	List<Course> getAllCoursesByUserId(int userId);
}