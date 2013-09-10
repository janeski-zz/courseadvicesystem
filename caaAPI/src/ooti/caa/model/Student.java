package ooti.caa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private StudyProgram studyProgram;
    private boolean active;
    private Date created;
    private Date updated;
    private Set<Course> followingCourses;
    private Set<Course> completedCourses;
    private Set<Advice> evaluatedAdvices;
    
    public Student () {
    	active = true;
    	followingCourses = new HashSet<Course>();
    	completedCourses = new HashSet<Course>();
    	evaluatedAdvices = new HashSet<Advice>();
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(unique=true)
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
	@JoinColumn(name="StudyProgram")
    public StudyProgram getStudyProgram() {
    	return this.studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
    	this.studyProgram = studyProgram;
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

    @Override
    public String toString() {
        return "User [userid=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", dob=" + dob + ", email="
                + email + "]";
    }

    @ManyToMany
	@JoinTable(name = "link_student_following_course")
	public Set<Course> getFollowingCourses() {
		return followingCourses;
	}

	public void setFollowingCourses(Set<Course> followingCourses) {
		this.followingCourses = followingCourses;
	}

	@ManyToMany
	@JoinTable(name = "link_student_completed_course")
	public Set<Course> getCompletedCourses() {
		return completedCourses;
	}

	public void setCompletedCourses(Set<Course> completedCourses) {
		this.completedCourses = completedCourses;
	}

	@ManyToMany
	@JoinColumn(name="evaluators")
	public Set<Advice> getEvaluatedAdvices() {
		return evaluatedAdvices;
	}

	public void setEvaluatedAdvices(Set<Advice> evaluatedAdvices) {
		this.evaluatedAdvices = evaluatedAdvices;
	}
}