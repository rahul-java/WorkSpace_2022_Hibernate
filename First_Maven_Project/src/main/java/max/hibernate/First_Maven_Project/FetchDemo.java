package max.hibernate.First_Maven_Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		//get() or load()
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session=sf.openSession();
        
        //get student 103
        
        Student std=(Student)session.get(Student.class, 101);
        System.out.println(std);
        
        Student std1=(Student)session.load(Student.class, 103);
        System.out.println(std1);
        
        Student std2=(Student)session.load(Student.class, 102);
       // System.out.println(std2);
        
        Address adr=(Address)session.get(Address.class, 1);
        System.out.println(adr.getStreet()+" : "+adr.getCity()+" : "+adr.getImage());
        
        Address adr1=(Address)session.get(Address.class, 1);
        System.out.println(adr1.getStreet()+" : "+adr1.getCity()+" : "+adr1.getImage());
        
       // Address adr1=(Address)session.get(Address.class, 11);
       // System.out.println(adr1);
        
        session.close();
        sf.close();
	}
}
