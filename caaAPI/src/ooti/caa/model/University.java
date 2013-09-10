package ooti.caa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author mjaneski
 * @version 1.0
 */

@Entity
public class University {

	/**
	 * Generated unique id.
	 */
	private int id;

	/**
	 * University full name.
	 */
	private String name;

	/**
	 * University short name.
	 */
	private String shortName;

	/*
	 * University Address.
	 */
	private String address;

	/**
	 * 
	 */
	private boolean active;

	/**
	 * Date created.
	 */
	private Date created;

	/**
	 * Date updated.
	 */
	private Date updated;

	/**
	 * Constructor.
	 */
	public University() {
		active = true;
	}

	public void finalize() throws Throwable {

	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public String getshortName() {
		return shortName;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(String newVal) {
		address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setshortName(String newVal) {
		shortName = newVal;
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

	public boolean getActive() {
		return active;
	}

	public String toString() {
		return getshortName() + " " + getAddress();
	}
}