package com.test.many.many;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.many.many.pojo.College;
import com.test.many.many.pojo.Student;
import com.test.many.many.utill.ResourceManager;

public class Fatch {
	public static void main(String[] args) {
		try {
			
			Session session = ResourceManager.currentSession();
			Criteria q = session.createCriteria(Student.class);
		    
			List<Student> t = q.list();
		
		      for(Student p : t)
		      {
		    	  System.out.println("*****************************Student Details*******************");
		    	  System.out.println(p.getRollno()+"\t"+p.getBranch()+"\t"+p.getStudentname()+"\t"+p.getCollegename());
		    	Set<College> f = p.getColleges();
		    	System.out.println("College Set Size : "+f.size());
		    	for(College c:f)
		    	{
		    		System.out.println("=====================College Details========================");
		    		System.out.println(c.getCollegeid()+"\t"+c.getAffilationTo()+"\t"+c.getCollegename());
		    	}
		      }
		
		
		System.out.println("list : "+t.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
