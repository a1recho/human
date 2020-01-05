<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人力资源管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script src="Js/js.js"></script>
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
                        <!------->

                        <br>
                        <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1"
                               bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150">
                            <tr>
                                <td height="22" colspan="4" align="center"><strong class="word_yellow">-详细应聘信息-</strong>
                                </td>
                            </tr>
                            <form name="jobForm" method="post" action="recruitmentUpdate" onSubmit="return jobValidate();">
                                <tr align="center">
                                    <td width="30%" height="27" bgcolor="#E8FFA7">招聘职位：</td>
                                    <td width="29%" height="22" align="left" bgcolor="#E8FFA7"><input name="postName"
                                                                                                      type="text"
                                                                                                      value="<%=request.getParameter("PostName")%>"
                                                                                                      readonly class="input">
                                    </td>
                                    <td width="18%" bgcolor="#E8FFA7">要求性别：</td>
                                    <td width="23%" align="left" bgcolor="#E8FFA7"><input name="sex" type="text" readonly value="<%=request.getParameter("sex")%>">
                                </tr>
                                <tr align="center">
                                    <td width="30%" height="27" bgcolor="#E8FFA7">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
                                    <td height="22" align="left" bgcolor="#E8FFA7"><input name="age" type="text"
                                                                                          class="input" readonly value="<%=request.getParameter("age")%>"></td>
                                    <td height="22" bgcolor="#E8FFA7">学历要求：</td>
                                    <td height="22" align="left" bgcolor="#E8FFA7"><input name="education" type="text"
                                                                                          class="input" readonly value="<%=request.getParameter("education")%>"></td>
                                </tr>
                                <tr align="center">
                                    <td width="30%" height="27" bgcolor="#E8FFA7">是否工作经验优先：</td>
                                    <td height="22" align="left" bgcolor="#E8FFA7"><input name="experience" type="text"
                                                                                          class="input" readonly value="<%=request.getParameter("experience")%>"></td>
                                    <td width="30%" height="27" align="center" bgcolor="#E8FFA7">联系电话：</td>
                                    <td height="22" align="left" bgcolor="#E8FFA7"><input name="phone" type="text"
                                                                                          class="input" readonly value="<%=request.getParameter("phone")%>"></td>
                                </tr>
                                <tr>
                                    <td width="30%" height="22" align="center" bgcolor="#E8FFA7">岗位详细要求：</td>
                                    <td height="22" colspan="3" align="left" bgcolor="#E8FFA7"><textarea name="content"
                                                                                                         cols="50"
                                                                                                         rows="6"
                                                                                                         class="input" readonly><%=request.getParameter("content")%> </textarea>
                                        <input type="hidden" name="id" value="<%=request.getParameter("idNo")%>">
                                    </td>
                                </tr>

                                <tr>
                                    <td height="30" colspan="4" align="center" bgcolor="#E8FFA7">&nbsp;
                                        <input  type="button" class="button" onclick="window.location.href='listRecruitmentForUser'" value="返回">
                                    </td>
                                </tr>
                            </form>
                        </table>

                        <!-------------->        </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
