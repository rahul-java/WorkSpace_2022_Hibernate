package max;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee ID : ");
		int id=Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Employee Name : ");
		String name=scanner.nextLine();
		System.out.println("Enter Employee Address : ");
		String address=scanner.nextLine();
		
		EmpDAO empDAO=new EmpDAO();
		Emp emp=new Emp();
		emp.setEid(id);
		emp.setName(name);
		emp.setAddress(address);
		
		if(empDAO.insertEmpDetails(emp))
		{
			System.out.println("Success......");
		}
		else
		{
			System.out.println("Failed..........");
		}

	}

}
