package ooti.caa.dao;

import java.util.List;

import ooti.caa.model.StudyProgram;

/**
 * @author mjaneski
 * @version 1.0
 */
public interface StudyProgramDAO {

	/**
	 * 
	 * @param studyProgram
	 */
	public int addStudyProgram(StudyProgram item);

	/**
	 * 
	 * @param id
	 */
	public boolean deleteStudyProgram(StudyProgram item);

	StudyProgram getStudyProgramById(int id);
	
	/**
	 * 
	 * @param studyProgram
	 */
	public boolean updateStudyProgram(StudyProgram item);

	public List<StudyProgram> getAllStudyProgram();

}