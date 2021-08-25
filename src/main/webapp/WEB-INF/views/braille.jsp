<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div style="width: 500px; height: 500px;">
    <c:forEach var="entry" items="${map}" varStatus="status">
        <div style="position:relative;
                left:${entry.value[0]}%;
                top:${entry.value[1]}%;
                font-size: 50px">${entry.key}</div>
    </c:forEach>
</div>
</body>
</html>