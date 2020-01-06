<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.domain.Resume" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                        <br>
                        <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1"
                               bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150">
                            <tr>
                                <td height="22" colspan="7" align="center"><strong class="word_yellow">-浏览应聘信息-</strong>
                                </td>
                            </tr>
                            <tr class="tdhui">
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">应聘职位</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">姓名</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">性别</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">年龄</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">学历</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">工作经验</td>
                                <td width="15%" height="22" align="center" bgcolor="#E8FFA7">联系电话</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">备注</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">操作</td>
                            </tr>
                            <%
                                List<Resume> resumes = (List<Resume>) request.getAttribute("resumes");
                                Iterator<Resume> iterator = resumes.iterator();
                                if (iterator.hasNext() != false) {
                                    while (iterator.hasNext()) {
                                        Resume re = iterator.next();
                            %>
                            <tr>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getPostName()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getName()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getSex()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getAge()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getEducation()%>&nbsp</td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getExperience()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getPhone()%>&nbsp;</td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getContent()%>&nbsp;</td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><a href="/deletePushResume/<%=re.getId()%>/<%=re.getPostName()%>">拒绝&nbsp;</a></td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr>
                                <td height="22" colspan="7" align="center" bgcolor="#E8FFA7">对不起，没有应聘信息！！！</td>
                            </tr>
                            <%}%>
                        </table>
                        <div align="center"> <input type="button" value="返回" onclick="window.location.href='manage.jsp'"></div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>