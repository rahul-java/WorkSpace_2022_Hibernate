package max.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility {

	private static SessionFactory sf;
	static ThreadLocal<Session> ss=new ThreadLocal<Session>();
	static
	{
		Configuration conf=new Configuration();
		conf.configure("/max/hibernate/hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		
	}
	
	private SessionUtility() {}
	
	public static Session getSession()
	{
		Session session=ss.get();
		if(session==null)
		{	
		 session=sf.openSession();	
		 ss.set(session);
		}
		return session;
		
	}
	
	public void closeSession()
	{
		Session session=ss.get();
		if(session!=null)
		{
		  ss.set(null);
		}
	}
	
}
