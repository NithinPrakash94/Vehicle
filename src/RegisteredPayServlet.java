

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import domain.Policy;
import business.CustomerBO;
import business.VehicleBO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
@WebServlet("/RegisteredPayServlet")
public class RegisteredPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String policyid = request.getParameter("Policyid");
         String mop = request.getParameter("mop");
		String contact = request.getParameter("contact");
        float amount=0;
        String date=null;
        String id1=null;
        //String policyid = request.getParameter("Customer_id");
        Cookie ck[]=request.getCookies();  
        out.print("Hello "+ck[0].getValue());  
    	CustomerBO cusBO=new CustomerBO();
    
    	boolean x = false;
 
    	ArrayList<Policy> al=new ArrayList<Policy>();
    	VehicleBO vbo= new VehicleBO();
    	al=vbo.list(Integer.parseInt(ck[0].getValue()));
    	Policy p=new Policy();
		
		 Iterator itr=al.iterator();  
		  while(itr.hasNext()){ 
			  p=(Policy) itr.next();
			  System.out.println(p.getPolicyid());
			  System.out.println("Vehicle vvv");  
			  System.out.println(policyid); 
			  if(policyid.equals(p.getPolicyid()))
		               { id1=policyid;
		            	 amount=p.getP_amount();   
		                 date=p.getM_date();
		                 System.out.println(date);
		               }
		  }
	       // Cookie ck1=new Cookie("mode","Registered Pay");//creating cookie object  
	       // response.addCookie(ck1);//adding cookie in the response  
			  
		  
    	RequestDispatcher rd = request.getRequestDispatcher("registered_pay_login.jsp");
    	request.setAttribute("policy_id", id1); 
		request.setAttribute("amount", amount); 
		request.setAttribute("Date", date);
		request.setAttribute("mop", mop);
		request.setAttribute("contact", contact);
    	rd.forward(request, response);
    	
    
    }  
}