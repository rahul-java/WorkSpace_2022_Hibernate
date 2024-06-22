package max.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
        Employee emp1=new Employee();
        emp1.setE_id(21);
        emp1.setE_name("Rahul");
        
        Employee emp2=new Employee();
        emp2.setE_id(22);
        emp2.setE_name("RaviKant");
        
        Projects proj1=new Projects();
        proj1.setP_id(201);
        proj1.setProjectName("Library Management System");
        
        Projects proj2=new Projects();
        proj2.setP_id(202);
        proj2.setProjectName("CHATBOT");
        
        List<Projects> p_list=new ArrayList<Projects>();
        p_list.add(proj1);
        p_list.add(proj2);
        
        List<Employee> e_list=new ArrayList<Employee>();
        e_list.add(emp1);
        e_list.add(emp2);
        
        emp1.setProjects(p_list);
        proj2.setEmps(e_list);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(emp1);
        session.save(emp2);
        session.save(proj1);
        session.save(proj2);
        
        tx.commit();
        session.close();
	}

}
