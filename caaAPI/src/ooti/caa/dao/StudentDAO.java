package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.Student;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface StudentDAO {

	/**
	 * 
	 * @param Student
	 */
	public int addStudent(Student item);

	/**
	 * 
	 * @param id
	 */
	public boolean deleteStudent(Student item);

	/**
	 * 
	 * @param Student
	 */
	public boolean updateStudent(Student item);

	public Student getStudentById(int id);
	
	public Student getStudentByEmail(String email);

	public List<Student> getAllStudents();

	public List<Student> getAllStudentsByFacultyId(int facultyId);

	public List<Student> getAllStudentsByStudyProgramId(int studyProgramId);
}