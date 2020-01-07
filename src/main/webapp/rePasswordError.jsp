<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码失败</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" height="100%" border="1">
    <tr>
        <td align="center" >用户不存在或密码错误！！！</td>
        <% response.setHeader("refresh","3;URL=forget.jsp");%>
    </tr>
</table>
</body>
</html>
