package ooti.caa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author mjaneski
 * @version 1.0
 */
@Entity
public class Advice {

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int usefull;

	/**
	 * 
	 */
	private int useless;

	/**
	 * 
	 */
	private String Desc;
    
	private Student creator;
	
	private Course course;
	
	private Date created;
	
	private Date updated;
	
	private boolean active;
	/**
	 * 
	 */
	public Advice() {
       usefull = 0;
       useless = 0;
       active = true;
	}

	public void finalize() throws Throwable {

	}
	
	/**
	 * @return
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
	   this.id = id;
	}

	/**
	 * 
	 */
	public void Useful() {
		usefull++;
	}

	/**
	 * 
	 */
	public void Useless() {
		useless--;
	}

	/**
	 * @return the description value
	 */
	public String getDescription() {
		return Desc;
	}

	/**
	 * Description setter.
	 * @param newWal value of the description
	 */
	public void setDescription(String newVal) {
		Desc = newVal;
	}

	/**
	 * @return useful level
	 */
	public int getUsefull() {
		return usefull;
	}

	public void setUsefull(int usefull) {
		this.usefull = usefull;
	}
	
	/**
	 * @return useless level
	 */
	public int getUseless() {
		return useless;
	}
	
	public void setUseless(int useless) {
		this.useless = useless;
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

	@ManyToOne
	@JoinColumn(name="Student")
	public Student getCreator() {
		return creator;
	}

	public void setCreator(Student creator) {
		this.creator = creator;
	}

	@ManyToOne
	@JoinColumn(name="Course")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}