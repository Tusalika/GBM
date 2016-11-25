<%@ page import="com.yang.vo.TestUser" %><%--
  Created by IntelliJ IDEA.
  User: Adminitster
  Date: 2016/11/22
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    欢迎<%
        TestUser user=(TestUser)session.getAttribute("user");

    %>
    <%=user.getUser_no() %>
    <%=user.getUser_name() %>

    <a href="index.jsp">重新登录</a>
    <a href="loginout.jsp">注销</a>
</body>
</html>
