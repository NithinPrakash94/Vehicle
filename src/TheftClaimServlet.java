

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ClaimBO;
import domain.Claim;


@WebServlet("/TheftClaimServlet")
public class TheftClaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheftClaimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("ACCSERVLET");
		String date = request.getParameter("dob1");
		String date2 = request.getParameter("dob2");
		String fir = request.getParameter("firnumber");
		String police = request.getParameter("psbranch");
		
		 Cookie ck[]=request.getCookies(); 
		  String cid =ck[0].getValue();
		  String pid=ck[1].getValue();
		  
		  ClaimBO cbo = new ClaimBO();
		  Claim a= cbo.entertheft(cid,pid,date,date2,fir,police);
		  RequestDispatcher rd = request.getRequestDispatcher("theftclaimed.jsp");

			out.println("<font color=red>Vehicle Registered successfully</font><br>");
			
			request.setAttribute("ClaimID", a.getClaim_id()); 
			request.setAttribute("PolicyID", pid);
			request.setAttribute("CustomerID", cid);
			request.setAttribute("Amount", a.getClaim_amnt());
			request.setAttribute("Weightage", "70");
			request.setAttribute("Type", "Theft");
			rd.forward(request, response);
		  
		  
	}

}
