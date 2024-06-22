package max.hibernate.First_Maven_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
        //SessionFactory sf=new Configuration().configure().buildSessionFactory();
        
        Student std1=new Student();
        std1.setId(102);
        std1.setName("Ravi kant Tiwari");
        std1.setCity("Sultanpur");
        System.out.println(std1);
        
        //creating object of Address Class
        Address address=new Address();
        address.setStreet("Street3");
        address.setCity("Gurugram");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.234);
        
        //reading image file
        FileInputStream fis = new FileInputStream("src/main/java/image2.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        fis.close();
        address.setImage(data);
        
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();  //when we save the data only then transaction is required
        session.save(std1);
        session.save(address);
        tx.commit();
        session.close();
        System.out.println("Done");
        
    }
}
