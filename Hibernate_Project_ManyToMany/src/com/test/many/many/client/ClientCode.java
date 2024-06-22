package com.test.many.many.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;


import org.hibernate.Transaction;

import com.test.many.many.pojo.College;
import com.test.many.many.pojo.Student;
import com.test.many.many.utill.ResourceManager;

public class ClientCode {
	
	public static void main(String[] args) {
		
		try {
			
			Student student = new Student();
			student.setBranch("A");
			student.setCollegename("IIT Delhi");
			student.setRollno(5555555);
			student.setStudentname("A Sharma");
			
			Student student1 = new Student();
			student1.setBranch("B");
			student1.setCollegename("IIT Delhi");
			student1.setRollno(6666666);
			student1.setStudentname("B Singh");
			Student student2 = new Student();
			student2.setBranch("C");
			student2.setCollegename("IIT Delhi");
			student2.setRollno(7777777);
			student2.setStudentname("C Pandey");
			
			Set<Student> studt = new HashSet<Student>();
			
			studt.add(student);
			studt.add(student2);
			studt.add(student1);
			
			College college = new College();
			college.setAffilationTo("IIT");
			college.setCollegeid(888);
			college.setCollegename("IIT Delhi");
			
			Set<College> colleges = new HashSet<College>();
			colleges.add(college);
			college.setStudents(studt);
			
			student.setColleges(colleges);
			
			
			
			
			Session session = ResourceManager.currentSession();
			Transaction tx = session.beginTransaction();
			session.save(college);
			session.save(student);
			tx.commit();
			
			System.out.println("table is created into data base and new table is created ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
//inverse by default false
//if inverse =true both hbm file or false than data inserted in new table
// if inverse =false any one hbm file than data inserted in new table which is primary key.
//you use lazy=true only the object of class will be loaded without the dependencies
//if you make lazy=false all the dependencies be loaded

//or
//If lazy=ture..loads only parent records (primary key records) only and its recommondad for memroy optimizations. lazy=false loads parent records and child records as well
//in single query
