<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theft Claim Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
<a href="home.jsp" id="admin">Home</a>&nbsp;&nbsp;
	<h1>Theft Claim Form</h1>
	<div class="ex">
		<form action="TheftClaimServlet" method="post">
			<table style="with: 50%">

				<tr>
					<td>Date of Theft</td>
					<td><input type="date" name="dob1" /></td>
				</tr>
				<tr>
					<td>Date of Complaint</td>
					<td><input type="date" name="dob2" /></td>
				</tr>
				<tr>
					<td>FIR Number</td>
					<td><input type="text" name="firnumber" /></td>
				</tr>
				<tr>
					<td>Police Station Branch</td>
					<td><input type="text" name="psbranch" /></td>
				</tr>
			</table>
			
			<input type="submit" value="Claim" />
			<input type="reset" value="Reset"/>
		</form>
	</div>
</body>
</html>