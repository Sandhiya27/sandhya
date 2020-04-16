<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h3 align="center">Welcome!!!!!!!!!</h3>
	<form:form action="/FormValidationSpringMVC/registerSuccess"
		method="post" modelAttribute="User">
		<table align="center">
		<caption align="top">User registration form</caption>
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

			<tr>
				<td>Enter your Name:</td>
				<td><form:input path="UserName"/></td>
				<td><form:errors path="UserName" cssClass="error"/></td>
			</tr>

			<tr>
				<td>Enter Mobile No:</td>
				<td><form:input path="Mobile"/></td>
				<td><form:errors path="Mobile" cssClass="error"/></td>

			</tr>

			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Select Course:</td>
				<td><form:select path="technology">
						<form:options items="${CousrseList}" />
					</form:select></td>
				<td><form:errors path="technology" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Select Location:</td>
				<td><form:select path="city">
						<form:options items="${LocationList}" />
					</form:select></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>


