package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.ChildBean;
import max.bean.FatherBean;
import max.dao.FatherChildDAO;
import max.dto.ChildDTO;
import max.dto.FatherDTO;

@WebServlet("/PServlet")
public class PServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		FatherBean fatherBean=new FatherBean();
		fatherBean.setfAcctNo(request.getParameter("fAcctNo"));
		fatherBean.setFname(request.getParameter("fname"));
		fatherBean.setDob(request.getParameter("dob"));
		fatherBean.setGender(request.getParameter("gender"));
		fatherBean.setStCode(request.getParameter("stCode"));
		fatherBean.setDistrictCode(request.getParameter("districtCode"));
		
		FatherDTO fatherDTO=new FatherDTO();
		fatherDTO.setAcctno(fatherBean.getfAcctNo());
		fatherDTO.setName(fatherBean.getFname());
		fatherDTO.setDob(fatherBean.getDob());
		fatherDTO.setGndr(fatherBean.getGender());
		fatherDTO.setStCode(fatherBean.getStCode());
		fatherDTO.setDistCode(fatherBean.getDistrictCode());
		
		String[] cadhar=request.getParameterValues("cadhar");
		String[] cname=request.getParameterValues("cname");
		String[] age=request.getParameterValues("age");
		
		
		List<ChildDTO> child_list=new ArrayList<ChildDTO>();
		for(int i=0;i<cadhar.length;i++)
		{
			ChildDTO childDTO=new ChildDTO();
			childDTO.setAdhar(cadhar[i]);
			childDTO.setName(cname[i]);
			childDTO.setAge(age[i]);
			child_list.add(childDTO);
		}
		fatherDTO.setClist(child_list);
		
		FatherChildDAO fatherChildDAO=new FatherChildDAO();
		if(fatherChildDAO.insertFatherChildDetails(fatherDTO))
		  {
			out.print("Inserted Successfully");
		  }
		else
		{
			out.print("Error in insertion....Something Went WRONG..............");
		}
		
	}

}
