<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.domain.Recruitment" %>


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
            <jsp:include page="navigationForUser.jsp"/>

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
                                <td height="22" colspan="7" align="center"><strong class="word_yellow">-浏览招聘信息-</strong>
                                </td>
                            </tr>
                            <tr class="tdhui">
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">招聘编号</td>
                                <td width="13%" height="22" align="center" bgcolor="#E8FFA7">招聘职位</td>
                                <td width="13%" height="22" align="center" bgcolor="#E8FFA7">要求性别</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">年龄</td>
                                <td width="13%" height="22" align="center" bgcolor="#E8FFA7">学历要求</td>
                                <td width="10%" height="22" align="center" bgcolor="#E8FFA7">工作经验</td>
                                <td width="15%" height="22" align="center" bgcolor="#E8FFA7">联系电话</td>
                                <td width="17%" align="center" bgcolor="#E8FFA7">执行操作</td>
                            </tr>
                            <%
                                List<Recruitment> recruitments = (List<Recruitment>) request.getAttribute("recruitments");
                                Iterator<Recruitment> iterator = recruitments.iterator();
                                if (iterator.hasNext() != false) {
                                    while (iterator.hasNext()) {
                                        Recruitment re = iterator.next();
                            %>
                            <tr>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getId()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getPostName()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getSex()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getAge()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getEducation()%>&nbsp</td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getExperience()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=re.getPhone()%>&nbsp;</td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><a href="/pushResume/<%=re.getId()%>">投简历</a> <a
                                        href="recruitmentDetailesForUser.jsp?id=PostName&PostName=<%=re.getPostName()%>&id=sex&sex=<%=re.getSex()%>&id=age&age=<%=re.getAge()%>
&id=education&education=<%=re.getEducation()%>&id=experience&experience=<%=re.getExperience()%>&id=phone&phone=<%=re.getPhone()%>&id=content&content=<%=re.getContent()%>&id=idNo&idNo=<%=re.getId()%>">详细信息</a>&nbsp;
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr>
                                <td height="22" colspan="7" align="center" bgcolor="#E8FFA7">对不起，没有添加应聘信息！！！</td>
                            </tr>
                            <%}%>
                        </table>
                        <div align="center"> <input type="button" value="返回" onclick="window.location.href='user.jsp'"></div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
