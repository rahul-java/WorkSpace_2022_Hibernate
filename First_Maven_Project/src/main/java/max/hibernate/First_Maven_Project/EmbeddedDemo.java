package max.hibernate.First_Maven_Project;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Configuration cfg=new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	     SessionFactory sf = cfg.buildSessionFactory();
	     
	     Student std1=new Student();
	     std1.setId(111);
	     std1.setName("Ankit");
	     std1.setCity("Allahabad");
	     
	     Certificate certificate1=new Certificate();
	     certificate1.setCourse("MCA");
	     certificate1.setDuration("3 Year");
	     std1.setCerti(certificate1);
	     
	     Student std2=new Student();
	     std2.setId(222);
	     std2.setName("Anil Shukla");
	     std2.setCity("Prayagraj");
	     
	     Certificate certificate2=new Certificate();
	     certificate2.setCourse("BSc");
	     certificate2.setDuration("3 Year");
	     std2.setCerti(certificate2);
	     
	     Session session=sf.openSession();
	     Transaction tx=session.beginTransaction();
	     
	     session.save(std1);
	     session.save(std2);
	     
	     tx.commit();
	}

}
