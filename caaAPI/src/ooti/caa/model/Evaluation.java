package ooti.caa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation {

	private int id;
	private boolean evaluation;
	private Advice advice;
	private Student student;
	private boolean active;
	private Date created;
	private Date updated;
	
	public Evaluation(Advice advice, Student student,boolean evaluation) {
		
		this.active= true;
		this.advice = advice;
		this.student = student;
		this.evaluation = evaluation;
	}

	public Evaluation() {
		this.active = true;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isEvaluation() {
		return evaluation;
	}
	
	public void setEvaluation(boolean evaluation) {
		this.evaluation = evaluation;
	}

	@ManyToOne
	@JoinColumn(name="Advice")
	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	@ManyToOne
	@JoinColumn(name="Student")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
