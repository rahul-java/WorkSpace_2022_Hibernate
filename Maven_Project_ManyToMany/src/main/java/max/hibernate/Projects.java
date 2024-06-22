package max.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects {

	@Id
	private int p_id;
	@Column(name="project_name")
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> emps;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projects(int p_id, String projectName, List<Employee> emps) {
		super();
		this.p_id = p_id;
		this.projectName = projectName;
		this.emps = emps;
	}
	
	
}
