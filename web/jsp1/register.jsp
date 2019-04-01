<%--
  Created by IntelliJ IDEA.
  User: 宙哥哥
  Date: 2019/1/9
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/cookie/js" method="post">
    用户名：<input type="text" name="username"/><br/>
    验证码：<input type="text" name="code" size="3"/>
    <img id="vCode" src="/cookie/js"/>
    <a href="javascript:change()">看不清，换一张</a>
    <br/>
    <input type="submit" value="提交"/>
</form>

</body>
<script type="text/javascript">
    function change() {

        document.getElementById("vCode").src="/cookie/js?"+new Date().toString();
    }
    
</script>
</html>
