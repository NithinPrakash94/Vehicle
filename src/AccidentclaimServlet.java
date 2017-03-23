

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Claim;
import business.ClaimBO;

@WebServlet("/AccidentclaimServlet")
public class AccidentclaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccidentclaimServlet() {
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
		String acctype = request.getParameter("acc");
	
		
		 Cookie ck[]=request.getCookies(); 
		  String cid =ck[0].getValue();
		  String pid=ck[1].getValue();
		  
		  ClaimBO cbo = new ClaimBO();
		  Claim a= cbo.enter(acctype,cid,pid);
		  RequestDispatcher rd = request.getRequestDispatcher("accidentclaimed.jsp");

			out.println("<font color=red>Vehicle Registered successfully</font><br>");
			
			request.setAttribute("ClaimID", a.getClaim_id()); 
			request.setAttribute("PolicyID", pid);
			request.setAttribute("CustomerID", cid);
			request.setAttribute("Amount", a.getClaim_amnt());
			request.setAttribute("Weightage", a.getWeightage());
			request.setAttribute("Type", a.getAccident_type());
			
			rd.forward(request, response);
		  
		  
	}

}
