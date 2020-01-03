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
                        <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="0"
                               bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150">
                            <tr>
                                <td height="22" colspan="2" align="center" class="word_yellow">-修改员工信息-</td>
                            </tr>
                            <form name="userForm" method="post" action="updateUserInformation"
                                  onSubmit="return userValidate();">
                                <tr>
                                    <td width="33%" height="27" align="center" bgcolor="#E8FFA7">员工编号：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="id" type="text"
                                                                                          class="input" value="<%=request.getParameter("idNo")%>" readonly></td>
                                </tr>
                                <tr>
                                    <td width="33%" height="27" align="center" bgcolor="#E8FFA7">员工姓名：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="employeeName" type="text"
                                                                                          class="input" value="<%=request.getParameter("name")%>"></td>
                                </tr>
                                <tr>
                                    <td width="33%" height="27" align="center" bgcolor="#E8FFA7">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="sex" type="text"
                                                                                          value="<%=request.getParameter("sex")%>">
                                    </td>
                                </tr>

                                <tr>
                                    <td width="33%" height="27" align="center" bgcolor="#E8FFA7">年龄：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="age" type="text"
                                                                                          class="input" value="<%=request.getParameter("age")%>"></td>
                                </tr>

                                <tr>
                                    <td width="33%" height="27" align="center" bgcolor="#E8FFA7">职位：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="postName" type="text"
                                                                                          class="input" value="<%=request.getParameter("PostName")%>"></td>
                                </tr>
                                <tr>
                                    <td height="27" align="center" bgcolor="#E8FFA7">所在部门：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="deptName" type="text"
                                                                                          class="input" value="<%=request.getParameter("DeptName")%>"></td>
                                </tr>

                                <tr>
                                    <td height="27" align="center" bgcolor="#E8FFA7">月薪：</td>
                                    <td height="27" align="left" bgcolor="#E8FFA7"><input name="money" type="text"
                                                                                          class="input" value="<%=request.getParameter("salary")%>"></td>
                                </tr>

                                <tr>
                                    <td height="27" colspan="2" align="center" bgcolor="#E8FFA7"><input name="Submit"
                                                                                                        type="submit"
                                                                                                        class="button"
                                                                                                        value="提交">
                                        &nbsp;&nbsp;
                                        <input name="Submit2" type="reset" class="button" value="重置"></td>
                                </tr>
                            </form>
                        </table>

                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
