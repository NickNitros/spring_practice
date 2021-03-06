<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
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

.topicBlock {
	color: #000;
	background-color: #EEEEff;
	border: 3px solid #0000ff;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<h2>Welcome</h2>
	<h3>Topic List:</h3>
	<c:if test="${empty topics}">
		<div class="errorBlock">There are no topics.</div>
	</c:if>
	<c:if test="${!empty topics}">
		<c:forEach items="${topics}" var="topic">
			<div class="topicBlock">
				<table width="100%" style="text-align: center">
					<tr>
						<td>${topic.title}</td>
					</tr>
					<tr>
						<td>${topic.description}</td>
					</tr>
					<tr>
						<td><a href="viewReply.html?id=${topic.id}">View Replies</a></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</c:if>
	<a href="./addTopic.html">Add a Topic</a>
</body>
</html>