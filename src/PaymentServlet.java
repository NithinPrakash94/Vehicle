import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Policy;
import business.CustomerBO;
import business.PaymentBO;
import business.VehicleBO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String policyid = request.getParameter("policy_id");
		float amount = Float.parseFloat(request.getParameter("amount"));
		String mop = request.getParameter("mop");
		String contact = request.getParameter("contact");
		
		if(policyid.isEmpty()||mop.isEmpty())//registered pay
		{	
			RequestDispatcher rd = request.getRequestDispatcher("pay_premium.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
			
			
		}
		else
		{	
			  Cookie ck[]=request.getCookies(); 
			  String s =ck[1].getValue();
			  String date3=null;
			  boolean x=false;
			    
			 
			   ArrayList<Policy> al=new ArrayList<Policy>();
		    	VehicleBO vbo= new VehicleBO();
		    	Policy p=new Policy();
		    	p=vbo.policyinfo(policyid);
		  
				
					  
					  if(policyid.equals(p.getPolicyid()))
					          {   date3=p.getM_date();
				                 System.out.println(date3);
				               }
					  DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					    Date date = new Date();
				        System.out.println(sdf.format(date));
					  
					  
					 Date d1=null;
					 String d;
					  Date d2 = null;
						try {
							d=sdf.format(date);
							d1=sdf.parse(d);
							d2 = sdf.parse(date3);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						long diff = d1.getTime() - d2.getTime();
						if(diff>0 && s.equals("Direct Pay"))
						{
							RequestDispatcher rd = request.getRequestDispatcher("pay_premium.jsp");
							out.println("<br><font color=red>Due date over</font><br>");
							rd.include(request, response);
							
						}
						
						else if(amount!=p.getP_amount())
						{
							RequestDispatcher rd = request.getRequestDispatcher("pay_premium.jsp");
							out.println("<font color=red>Amount Wrong</font>");
							rd.include(request, response);
						}
						else 
							x=true;
				 
			if(x)
			{
			       if(diff < 0)
			       {
			    	   diff=diff*(-1);
			    	   float y=  (float) ((float)diff*amount*0.0056);
			           amount=amount+y;
			       }
			 
                   if(mop.equals("credit"))
					{
						amount=(float) (amount*1.023);
					}
			System.out.println(s);
			PaymentBO payBO=new PaymentBO();
			
			boolean x1 = false;
			try {	 System.out.println("Successful2");
			
			x1=payBO.pay(policyid,amount,mop,contact,s);
				//return payment id and next payment date from payment BO
			//if payment date is greater than due date, calculate late payment charge
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x1){
			
			RequestDispatcher rd = request.getRequestDispatcher("registered_pay.jsp");
			out.println("<font color=red>Registered pay done successfully</font>");
			//display payment id and next payment date
			rd.forward(request, response);
			}
		
	
		}
	}

}
}