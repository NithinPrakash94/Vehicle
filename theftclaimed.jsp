<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="home.jsp" id="admin">Home</a>&nbsp;&nbsp;
 <center>
            <p>Theft Claimed Successfully</p>
             </center>
        
        Claim_ID: <input type="text" name="claim_id" value="<%= request.getAttribute("ClaimID") %>"><br>   
        Policy_ID:<input type="text" name="policy_id" value="<%= request.getAttribute("PolicyID") %>"><br>     
        Customer_ID:<input type="text" name="customer_id" value="<%= request.getAttribute("CustomerID") %>"><br>     
        Amount:<input type="text" name="amount" value="<%= request.getAttribute("Amount") %>"><br>
         Weightage:<input type="text" name="weightage" value="<%= request.getAttribute("Weightage") %>"><br>   
             Type:<input type="text" name="type" value="<%= request.getAttribute("Type") %>"><br>
          
        
         
</body>
</html>