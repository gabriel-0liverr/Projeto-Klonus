<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	
	<ul>
		<c:forEach items="${players}" var="player">
			<li>
				<span>${player.username} - ${player.score} pts</span>
			</li>
		</c:forEach>
	</ul>

</body>
</html>