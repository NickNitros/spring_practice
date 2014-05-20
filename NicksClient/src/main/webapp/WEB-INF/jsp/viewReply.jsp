<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Replies</title>
<style>
body {
	text-align: center;
}

.error {
	color: #ff0000;
}

.errorBlock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.replyBlock {
	color: #000;
	background-color: #EEEEff;
	border: 3px solid #0000ff;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<h1>Replies</h1>
	<c:if test="${!empty error}">
		<div class="errorBlock">${error}</div>
	</c:if>
	<c:if test="${empty replies}">
		<div class="errorBlock">There are no replies.</div>
	</c:if>
	<c:if test="${!empty replies}">
		<c:forEach items="${replies}" var="reply">
			<div class="replyBlock">
				<table width="100%" style="text-align: center">
					<tr>
						<td>${reply.text}</td>
					</tr>
					<tr>
						<td>By ${reply.user.name}</td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</c:if>
	<a href="./addReply.html">Add a Reply</a> | <a href="./main.html">Back to Topics</a>
</body>
</html>