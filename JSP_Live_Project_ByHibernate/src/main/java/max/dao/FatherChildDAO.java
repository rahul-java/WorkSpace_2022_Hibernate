package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import max.JDBCConnection;
import max.bean.ChildBean;
import max.bean.ChildViewBeen;
import max.bean.FatherBean;
import max.bean.FatherViewBeen;
import max.dto.ChildDTO;
import max.dto.FatherDTO;
import max.hibernate.SessionUtility;

public class FatherChildDAO {

	static Connection con = null;
	static PreparedStatement ps = null;

	public boolean insertFatherChildDetails(FatherDTO fatherDTO) {
		
		try {
			
			Session session = SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Integer n = (Integer)session.save(fatherDTO);
			tx.commit();
			System.out.println(n);
			if(n>0)
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	// By Criteria
	public List<FatherDTO> viewFatherChilddetails()
	{
		try {
			Session session = SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(FatherDTO.class);
			
			//cr.addOrder(Order.asc("name"));  //ascending order by name
			//cr.add(Restrictions.ilike("name", "%Rahul%"));   //search name as "rahul"
			//cr.add(Restrictions.ilike("name", "%v%"));    // search name for"v"
			
			List<FatherDTO> list = cr.list();
			
			// for watching the diffrence between lazy="true/false" in hbm.xml
			for(FatherDTO f :list)
			{
				System.out.println("*******************************");
				System.out.println(f.getFid()+"\t"+f.getName());
				List<ChildDTO> cl = f.getClist();
				for(ChildDTO c:cl)
				{
					System.out.println(c.getCid()+"\t"+c.getName());
				}
			}
			
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	//By HQL
	public List<FatherDTO> viewFatherChilddetails()
	{
		try {
			Session session = SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from FatherDTO where fid=:fatherID");
			q.setParameter("fatherID", 20);
			List<FatherDTO> list = q.list();
			System.out.println(list.size());
			for(FatherDTO f:list)
			{
				System.out.println(f.getClist().size());
			}
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	public List<FatherDTO> viewFatherChilddetails(int f_id)
	{
		try {
			Session session = SessionUtility.getSession();
			Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(FatherDTO.class);
			cr.add(Restrictions.eq("fid", f_id));
			//List<FatherDTO> list = cr.list();
			List<FatherDTO> list=cr.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
