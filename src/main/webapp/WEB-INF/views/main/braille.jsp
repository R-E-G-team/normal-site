<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div style="width: 500px; height: 500px;">
    <%
        Map<String, int[]> map = (Map<String, int[]>) request.getAttribute("map");
        if(request.getAttribute("error") == null) {
            for(String key : map.keySet()) {
    %>
        <div style="position:relative;
                left:<%=map.get(key)[0]%>%;
                top:<%=map.get(key)[1]%>%;
                font-size: 50px"><%=key%></div>
    <%}} else {
            %>
    <h1>해당하는 글을 찾지 못했습니다.</h1>
    <%}%>
</div>
</body>
</html>