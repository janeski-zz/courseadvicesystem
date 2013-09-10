package ooti.caa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author mjaneski
 * @version 1.0
 */
@Entity
public class Course {

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private boolean active;

	/**
	 * 
	 */
	private String courseName;

	private Set<StudyProgram> studyProgrammes;
	private Set<Student> followingStudents;
	private Set<Student> completedStudents;

	private Date created;
	private Date updated;
	/**
	 * 
	 */
	public Course() {
		active = true;
		studyProgrammes = new HashSet<StudyProgram>();
		followingStudents = new HashSet<Student>();
		completedStudents = new HashSet<Student>();
	}

	public void finalize() throws Throwable {

	}
	/**
	 * @return
	 */
	@Id
	@GeneratedValue
	public int getId(){
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActive(boolean newVal) {
		active = newVal;
	}

	public String getCourseName() {
		return courseName;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCourseName(String newVal) {
		courseName = newVal;
	}

	@ManyToMany(mappedBy = "courses")
	public Set<StudyProgram> getStudyProgrammes() {
		return studyProgrammes;
	}

	public void setStudyProgrammes(Set<StudyProgram> studyProgrammes) {
		this.studyProgrammes = studyProgrammes;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date date) {
		created = date;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date date) {
		updated = date;
	}

	@ManyToMany(mappedBy = "followingCourses")
	public Set<Student> getFollowingStudents() {
		return followingStudents;
	}

	public void setFollowingStudents(Set<Student> followingStudents) {
		this.followingStudents = followingStudents;
	}

	@ManyToMany(mappedBy = "completedCourses")
	public Set<Student> getCompletedStudents() {
		return completedStudents;
	}

	public void setCompletedStudents(Set<Student> completedStudents) {
		this.completedStudents = completedStudents;
	}
}