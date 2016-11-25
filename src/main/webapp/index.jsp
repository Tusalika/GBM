<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function login() {
            var uv = document.getElementById("userno").value;
            var pv = document.getElementById("password").value;
            if (uv == "" | pv == "") {
                alert("用户名和密码不能为空！");
                return;
            }
            document.form1.submit();
        }
    </script>
</head>
<html>
<form id="form1" name="form1" action="UserConrol?action=login" method="post">
    <body>
    用户名：<input type="text" id="userno" name ="userno" /><br/>
    密  码：<input type="password" id="password" name ="password" />
    <input type="button" value="登录" onclick="login()"/>
    <a href="register.jsp">注册</a>
</form>
</body>
</html>
