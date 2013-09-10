package ooti.caa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author mjaneski
 * @version 1.0
 */

@Entity
public class StudyProgram {

	private int id;
	private boolean active;
	private String Name;
    private Faculty faculty;
    private Set<Course> courses = new HashSet<Course>();
	/**
	 * Date created.
	 */
	private Date created;

	/**
	 * Date updated.
	 */
	private Date updated;

	public StudyProgram() {
		active = true;
		this.courses = new HashSet<Course>();
	}

	public void finalize() throws Throwable {

	}

	@Id
	@GeneratedValue
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActive(boolean newVal){
		active = newVal;
	}

	public String getName(){
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	@ManyToOne
	@JoinColumn(name="Faculty")
	public Faculty getFaculty() {
		return this.faculty;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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
	
	public void setActive(Boolean bool) {
		active = bool;
	}
	
	public Boolean getActive() {
		return active;
	}

	@ManyToMany
	@JoinTable(name = "link_studyprogram_course")
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}