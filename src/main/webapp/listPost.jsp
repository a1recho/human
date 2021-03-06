<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.domain.Post" %>


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
                                <td height="22" colspan="7" align="center"><strong class="word_yellow">-职位信息-</strong>
                                </td>
                            </tr>
                            <tr class="tdhui">
                                <td width="13%" height="22" align="center" bgcolor="#E8FFA7">职位编号</td>
                                <td width="13%" height="22" align="center" bgcolor="#E8FFA7">职位名称</td>
                                <td width="30%" height="22" align="center" bgcolor="#E8FFA7">职位描述</td>
                                <td width="17%" align="center" bgcolor="#E8FFA7">执行操作</td>
                            </tr>
                            <%
                                List<Post> posts = (List<Post>) request.getAttribute("posts");
                                Iterator<Post> iterator = posts.iterator();
                                if(iterator.hasNext()!=false){
                                    while (iterator.hasNext()){
                                        Post post = iterator.next();
                            %>
                            <tr>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=post.getId()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=post.getPostName()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF"><%=post.getPostContent()%>
                                </td>
                                <td height="22" align="center" bgcolor="#FFFFFF">
                                    <a href="postUpdate.jsp?id=idNo&idNo=<%=post.getId()%>&id=PostName&PostName=<%=post.getPostName()%>&id=PostContent&PostContent=<%=post.getPostContent()%>">修改信息</a>&nbsp;
                                    <a href="deletePost?id=idNo&idNo=<%=post.getId()%>">删除</a></td>
                            </tr>
                            <%
                                }
                            } else {
                            %>
                            <tr>
                                <td height="22" colspan="7" align="center" bgcolor="#E8FFA7">对不起，没有职位信息！！！</td>
                            </tr>
                            <%}%>
                        </table>
                        <div align="center"><input type="button" value="返回" onclick="window.location.href='manage.jsp'">
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
