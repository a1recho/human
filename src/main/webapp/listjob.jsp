<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC"
       bordercolordark="#FFFFFF">
    <tr>
        <td width="191" height="497" rowspan="2" valign="top">&nbsp;</td>
        <td width="772" height="48" valign="top">
            <jsp:include page="navigation.jsp"/>

        </td>
        <td width="40" rowspan="2" valign="top">&nbsp;</td>
    </tr>
    <tr>
        <td height="249" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="431" valign="top" bgcolor="#C5DF7E">
                        <!------->

                        <br>
                        <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1"
                               bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150">
                            <tr>
                                <td height="22" colspan="7" align="center" class="word_yellow">-应聘信息-</td>
                            </tr>
                            <tr class="tdhui">
                                <td height="22" align="center" bgcolor="#E8FFA7">姓名</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">性别</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">年龄</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">职位</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">所学专业</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">工作经验</td>
                                <td height="22" align="center" bgcolor="#E8FFA7">执行操作</td>
                            </tr>
                            <%


                            %>
                            <tr>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%%></td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><a
                                        href="detailjob.do?action=detailjob&id=<%%>">详细</a>&nbsp;&nbsp;<a
                                        href="modifyjob.do?action=deletejob&id=<%%>">删除</a>
                                    <%%>
                                    &nbsp;&nbsp;<a href="modifyjob.do?action=updatejob&id=<%%>&isstock=1">入库</a></td>
                                <%%>
                            </tr>
                            <%
                            %>
                            <tr>
                                <td height="22" colspan="7" align="center" bgcolor="#E8FFA7">对不起，没有信息！！！</td>
                            </tr>
                            <%%>
                        </table>

                        <!-------------->        </td>
                </tr>
            </table>
            <jsp:include page="copyright.html"/>
        </td>
    </tr>
</table>

</body>
</html>
