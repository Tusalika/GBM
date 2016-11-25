<%--
  Created by IntelliJ IDEA.
  User: Adminitster
  Date: 2016/11/25
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function reg() {
        var useno = document.getElementById("userno").value;
        var usename = document.getElementsById("username").value;
        var usepwd = document.getElementById("password").value;
        var usepwd1 = document.getElementsById("password1").value;
        var dep = document.getElementsById("depart").value;
        var sex = document.getElementsById("sex").value;
        if (useno == "" | usepwd == "" | usepwd1 == "") {
            alert("用户名和密码不能为空！");
            return;
        } else if (usepwd != usepwd1) {
            alert("两次密码必须一致")
        }
        document.form1.submit();
    }
</script>
<body>
<form id="form1" name="form1" action="UserConrol?action=register" method="post">
    请输入你的账号:<input type="text" id="userno" name="userno"/><br/>
    给自己起个名字吧：<input type="text" id="username" name="username"/><br/>
    请自己设置个密码：<input type="text" id="password" name="password"/><br/>
    确认一下你的密码是否太简单了：<input type="text" id="password1" name="password1"/><br/>
    告诉我你是哪个系的：<input type="text" id="depart" name="depart"/><br/>
    最后你可以告诉我你的性别<input type="radio" name="sex" id="m" value="男"/>男
    <input type="radio" name="sex" id="w" value="女"/>女
    <br/>
    <input type="button" value="确认注册" onclick="reg()"/>
</form>
</body>
</html>
