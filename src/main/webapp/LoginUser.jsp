<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login">
		user   : <br>
		<select name="user">
		 <option value="admin">admin</option>
		 <option value="surveyor">surveyor</option>
		 <option value="respondent">respondent</option>
		</select>
		email  : <input type="text" name="email">
		password: <input type="text" name="password">
		<input type="submit" value="login"><br><br>
		
		<a href = "createSurveyor.jsp">Create Surveyor</a><br><br>
		<a href = "createRespondent.jsp">Create Respondent</a>
	</form>
</body>
</html>