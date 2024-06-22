package max.hibernate.First_Maven_Project;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name="student_details") // it will change the class name entity as new student_details

//@Entity
//@Table(name="mystudents") // it will create table name as mystudents

@Entity
public class Student {

	@Id
private int id;
private String name;
private String city;

private Certificate certi;

public Certificate getCerti() {
	return certi;
}

public void setCerti(Certificate certi) {
	this.certi = certi;
}

public Student(int id, String name, String city) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
}

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.id+" : "+this.name+" : "+this.city;
}



}
