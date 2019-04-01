
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<% String user =(String)session.getAttribute("user1");
    if(user!=null){
        out.print(user);/*相当于响应字符输出流   jsp里面的代码更改了不需要重启tomcat*/

    }
%>--%>
<% String user = (String)session.getAttribute("name");

%>
<h1><% if (user!=null){
    out.write(user);

}else {
    out.write("helo");
}

%>,登陆成功</h1>

<a href="/cookie/login2.jsp；jsessionid=<%=session.getId()%>">跳到login2.jsp</a>
</body>
</html>
