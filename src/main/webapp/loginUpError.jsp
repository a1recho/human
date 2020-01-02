<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/1/1
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册失败</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" height="100%" border="1">
    <tr>
        <td align="center" >用户已经存在或格式错误！！！</td>
        <% response.setHeader("refresh","3;URL=form.jsp");%>
    </tr>
</table>
</body>
</html>
