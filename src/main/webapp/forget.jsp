<%@ page contentType="text/html; charset=GBK" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>������Դ����ϵͳ</title>
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
                            <b>�� �� ����</b><input name="username" type="text"
                                                          class="input"><br><br>
                            <b>�� �� �룺</b><input name="password" type="password"
                                                                class="input"><br><br>
                            <b>�� �� �룺</b><input name="newPassword" type="password"
                                                class="input"><br><br>
                            <b>�ظ����룺</b><input name="rePassword" type="password"
                                               class="input"><br><br>
                            <input type="submit" value="ȷ���޸�">

                        </form>
                    </td>
                </tr>
            </table>
    </tr>
</table>
</body>
</html>