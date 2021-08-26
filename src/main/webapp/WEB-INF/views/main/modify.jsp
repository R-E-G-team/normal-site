<%@ page import="java.util.Map" %>
<%@ page import="com.example.reg.dto.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    Users users = (Users) request.getAttribute("users");
%>
<form action="/modify_action" method="post">
    <div style="width: 500px; height: 500px;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="usersNo" value="<%=users.getUserNo()%>">
        <h3>현재 이름 : <%=users.getUserName()%>
        </h3>
        <h3>바꿀 이름 : <input type="text" name="usersName"></h3>
        <input type="submit">
    </div>
</form>
</body>
</html>