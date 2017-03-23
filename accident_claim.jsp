<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accident Claim Data</title>
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
	<h1>Accident Claim Form</h1>
	<div class="ex">
		<form action="AccidentclaimServlet" method="post">
			<table style="with: 50%"> 
			<%--based on policy id entered, the username and premium amount paid should be displayed--%>
				<tr>
					<td>Accident Type

					<select name="acc" id="acc">
					<option value="Fire">Fire</option>
					<option value="RoadAccident">RoadAccident</option>
					<option value="MaliciousActs">MaliciousActs</option>
					<option value="Self-Destruction">Self-Destruction</option>
					<option value="PartsFailure">PartsFailure</option>
					</select>
					</td>
					</tr>
			
			
			</table>
			
			<input type="submit" value="Claim" />
			<input type="reset" value="Reset"/>
		</form>
	</div>
</body>
</html>