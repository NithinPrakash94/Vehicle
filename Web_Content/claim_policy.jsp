<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Policy</title>
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
<a href="home.jsp" id="user">Home</a>&nbsp;&nbsp;
	<h2>Claim Policy</h2>
	<div class="ex">
		<form action="ClaimServlet" method="post">
			<table style="with: 50%">
			<% 
	  try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
  Connection connection =DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/vis?user=root&password=password-1");

  Cookie ck[]=request.getCookies(); 
  int id =Integer.parseInt(ck[0].getValue());
       PreparedStatement s = null;
      String sql = "SELECT Policy_id,Policy_amount,Policy_date from vehicle_registration where Vehicle_ownerid = ?";
				s = connection.prepareStatement(sql);
				s.setInt(1,id);
	      
	            ResultSet rSet = s.executeQuery();
%>
	

<center>
    <tr>
    <h3><td> Select Policy</td></h3>
     <td>  <select name="Policyid" id="Policyid" >
        <%  while(rSet.next()){ %>
            <option><%= rSet.getString(1)%></option>             
        <% } %>
        </select> 
     </td>
        </tr><%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
        
					<h3><td>Claim Type</td></h3>
					<td><input type="radio" name="claim" value="accident" checked>Accident Claim</td>
					<td><input type="radio" name="claim" value="theft" checked>Theft Claim</td>
					
				</tr>
			 </table>
			<input type="submit" class="button button2" value="submit" />
			</center>
		</form>
	</div>

</body>
</html>