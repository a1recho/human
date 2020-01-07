<%@ page contentType="text/html; charset=GBK" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" height="615" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" height="100%">
            <table width="635" height="236" border="0" cellpadding="0" cellspacing="0" class="textB">
                <tr align="center">
                    <td height="282" colspan="2" background="images/login_top.jpg">&nbsp;</td>
                </tr>
                <tr align="center">
                    <td width="18" height="120" background="images/login_left.jpg" class="tableBorder_lb">&nbsp;</td>
                    <td width="607" height="120" bgcolor="#FFFFFF" class="tableBorder_br">
                        <form name="usersForm" method="post" action="/updatePassword">
                            <b>用 户 名：</b><input name="username" type="text"
                                                          class="input"><br><br>
                            <b>旧 密 码：</b><input name="password" type="password"
                                                                class="input"><br><br>
                            <b>新 密 码：</b><input name="newPassword" type="password"
                                                class="input"><br><br>
                            <b>重复密码：</b><input name="rePassword" type="password"
                                               class="input"><br><br>
                            <input type="submit" value="确认修改">

                        </form>
                    </td>
                </tr>
            </table>
    </tr>
</table>
</body>
</html>