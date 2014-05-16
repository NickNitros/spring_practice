<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
body {
	text-align: center;
}

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<h2>Register User</h2>
	<form:form commandName="user">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<label for="textinput1"> Enter Name: </label>
		<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br />
		<br />
		<label for="textinput2"> Enter Email: </label>
		<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<br />
		<label for="textinput3"> Enter Password: </label>
		<form:input path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<br />
		<input type="submit" class="btn" value="Login" />
	</form:form>
</body>
</html>