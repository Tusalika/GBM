<%@ page import="com.yang.service.IUserService" %>
<%@ page import="com.yang.service.UserServiceImpl" %>
<%@ page import="com.yang.vo.TestUser" %>
<%--
  Created by IntelliJ IDEA.
  TestUser: Adminitster
  Date: 2016/11/22
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    IUserService service = new UserServiceImpl();
    String userno = request.getParameter("userno");
    String pwd = request.getParameter("password");
    TestUser user = new TestUser();
    user.setUser_no(userno);
    user.setPwd(pwd);
    if (service.login(user)) {
        session.setAttribute("user", user);
        response.sendRedirect("success.jsp");
    } else {//失败了
%>
<script type="text/javascript">

    alert("非法入侵");
    window.location = "index.jsp";
</script>
<%

    }

%>
