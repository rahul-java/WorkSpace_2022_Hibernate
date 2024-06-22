package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpDAO {

	public boolean insertEmpDetails(Emp e)
	{
		try {
			
			Session session=SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.persist(e);
			tx.commit();
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return false;
		
	}
	
	public List<Emp> getEmpDetailByHibernate()
	{
		try {
			Session session=SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Emp");
			List<Emp> list = q.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Emp> getEmpDetailByHibernateByCriteria()
	{
		try {
			Session session=SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Emp.class);
			List<Emp> list = cr.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
