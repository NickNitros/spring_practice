<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Nicks Spring Forum</title>
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
	<h2>Login</h2>
	<form:form commandName="user">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<form:hidden path="name" value="tempHold"/>
		<label for="textinput1"> Enter Email: </label>
		<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<br />
		<label for="textinput2"> Enter Password: </label>
		<form:input path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<br />
		<input type="submit" class="btn" value="Login" />
	</form:form>
	<c:if test="${!empty invalid}">
		<div class="errorBlock">${invalid}</div>
	</c:if>
	<a href="./register.html">Register</a>
</body>
</html>
