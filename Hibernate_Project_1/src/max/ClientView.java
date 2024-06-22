package max;

import java.util.List;

public class ClientView {
	public static void main(String[] args) 
	{
		EmpDAO empDAO=new EmpDAO();
		//By HQL
		
		List<Emp> list = empDAO.getEmpDetailByHibernate();
		System.out.println("By HQL..........");
		for(Emp e:list)
		{
			System.out.println(e.getEid()+"   "+e.getName()+"   "+e.getAddress());
		}
		
		//By Criteria
		
		list=empDAO.getEmpDetailByHibernateByCriteria();
		System.out.println("By Criteria...");
		for(Emp e:list)
		{
			System.out.println(e.getEid()+"   "+e.getName()+"   "+e.getAddress());
		}
	}

}
