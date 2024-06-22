package max.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int e_id;
	private String e_name;
	
	@ManyToMany
	@JoinTable
	(
			name="emp_proj_join_table",
	        joinColumns={@JoinColumn(name="eid")},
	        inverseJoinColumns={@JoinColumn(name="pid")}
	)
	private List<Projects> projects;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int e_id, String e_name, List<Projects> projects) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.projects = projects;
	}
	
	
}
