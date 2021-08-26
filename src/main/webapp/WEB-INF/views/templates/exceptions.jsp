<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>

</head>
<body>
<%
    List<Float> percent = (List<Float>) request.getAttribute("percent");
    List<String> hax = (List<String>) request.getAttribute("hax");
    float sum = 0f;
    for(int i = 0; i < percent.size(); i++) {
        sum += percent.get(i);
    }
    for(int i = 0; i < percent.size(); i++) {
        String [] arr = hax.get(i).split("/");
%>
<div style="display: inline-block; width: <%=percent.get(i) / sum * 100 %>%; height: 5000px; background-color: rgb(<%=arr[0]%>, <%=arr[1]%>, <%=arr[2]%>)"></div>
<%}%>
</body>
</html>