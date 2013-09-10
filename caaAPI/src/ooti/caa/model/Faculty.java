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
public class Faculty {

	private int id;
	private String name;
	private boolean active;
	private Date created;
	private Date updated;
	private University university;
	
	/*
	 * University Address.
	 */
	private String address;

	public Faculty(){
		active = true;
	}

	public void finalize() throws Throwable {

	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setId(int newVal) {
		id = newVal;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		name = newVal;
	}

	@ManyToOne
	@JoinColumn(name="University")
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	public String getAddress() {
		return address;
	}
    
	public void setAddress(String newVal) {
		address = newVal;
	}
	
	public boolean isActive(){
		return active;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActive(Boolean newVal) {
		active = newVal;
	}

	public Date getCreated(){
		return created;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCreated(Date newVal) {
		created = newVal;
	}

	public Date getUpdated(){
		return updated;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUpdated(Date newVal) {
		updated = newVal;
	}
	
	public String toString() {
		return getName() + " " + getAddress();
	}
}