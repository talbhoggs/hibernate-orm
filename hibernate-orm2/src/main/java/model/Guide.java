package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {
	
	// Student table
	// ----------------------------------------------------
	// id	staff_id	name	salary
	//-----------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="staff_id")
	private String staffid;
	
	private String name;
	
	private Integer salary;
	
	@OneToMany(mappedBy="guide",cascade={CascadeType.PERSIST})
	private Set<Student> students = new HashSet<Student>();
	
	private Guide() {}

	public Guide(String staffid, String name, Integer salary) {
		this.staffid = staffid;
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student> getStudents(){
		return students;
	}
	
	// helper method for bidirectional relation
	
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
		
	}
	
	
	
}
