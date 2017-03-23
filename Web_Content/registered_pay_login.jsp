<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered Pay Login</title>
</head>
<style>
a:link, a:visited {
    
    color: white;
    padding: 14px 25px;
    
    font-family:Arial, Helvetica, sans-serif;
    text-decoration: none;
    display: inline-block;
}



.button {
   
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8%;
}

.button2 {
    background-color: white;
    color: black;
    
}


.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
    background-color: #e7e7e7;
}


a:hover, a:active {
    background-color: grey;
}
		h2
		{
		color: white;
		font-family:Arial, Helvetica, sans-serif;
		text-align: center;
		
		}
			h3
		{
		color: white;
		font-family:Arial, Helvetica, sans-serif;
		
		
		}
		body{
		background-image: url("car1.jpg");
		background-repeat: no-repeat;
    background-position: center;
    background-attachment: fixed;
		}
		</style>
<body>
<a href="home.jsp" id="admin">Home</a>&nbsp;&nbsp;
	
 <center>
           <h2> <p>Payment Information</p></h2>
             
            <form action="PaymentServlet" method="post">
      <table style="with: 30%">
           <tr>
           <h3><td>Policy ID:</td></h3>
           <td><input type="text" name="policy_id" value="<%= request.getAttribute("policy_id") %>"></td><br>
        </tr>
           <tr>
            <h3><td> Amount:</td></h3>
            <td><input type="text" name="amount" value="<%= request.getAttribute("amount") %>"></td><br>
           </tr>  
          <tr>
             <h3><td>Date:</td></h3>
             <td><input type="text" name="date" value="<%= request.getAttribute("Date") %>"></td><br>
       </tr>
             <tr> <h3><td>Contact:</td></h3>
             <td><input type="text" name="contact" value="<%= request.getAttribute("contact") %>"></td><br>
        </tr>
             <tr> <h3><td>Mode of Payment:</td></h3>
             <td><input type="text" name="mop" value="<%= request.getAttribute("mop") %>"></td><br>
           </tr> 
           </table>
        	<input type="submit" class="button button2" value="pay" />
			<input type="reset" class="button button2"/>
         </form>
         </center>
</body>
</html>