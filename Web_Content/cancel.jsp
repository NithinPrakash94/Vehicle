<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Cancel Page</title>
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
		<form action="CancelServlet" method="post">
		<center>
<h2>Policy Cancellation</h2>
			<tr>
					<h3><td>Please enter your policy number	</td></h3>
			<td><input type="text" name="username"/></td><br>		
		
			</tr>
			
			<input type="submit" class="button button2" value="cancel">			
		</center>
		</form>
	</body>
</html>