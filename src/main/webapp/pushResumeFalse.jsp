<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="100%" height="100%" border="1">
    <tr>
        <td align="center" >您已经投过简历了，不可重复投递！！！</td>
        <% response.setHeader("refresh","3;URL=/listRecruitmentForUser");%>
    </tr>
</table>
</body>
</html>