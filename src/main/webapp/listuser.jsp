<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="com.domain.Employee" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人力资源管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="top.jsp"/>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF"  >
  <tr>
    <td width="191" height="497" rowspan="2" valign="top" >&nbsp;</td>
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
<table width="94%"  border="0" align="center" cellpadding="0" cellspacing="1" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B150" >
  <tr>
    <td height="22" colspan="7" align="center" ><strong class="word_yellow">-浏览员工信息-</strong></td>
  </tr>
  <tr class="tdhui">
    <td width="17%" height="22" align="center" bgcolor="#E8FFA7" >员工姓名</td>
    <td width="10%" height="22" align="center" bgcolor="#E8FFA7" >性别</td>
    <td width="16%" height="22" align="center" bgcolor="#E8FFA7" >年龄</td>
    <td width="10%" height="22" align="center" bgcolor="#E8FFA7" >职位</td>
    <td width="15%" height="22" align="center" bgcolor="#E8FFA7" >所在部门</td>
    <td width="15%" height="22" align="center" bgcolor="#E8FFA7" >月薪</td>
    <td width="17%" align="center" bgcolor="#E8FFA7" >执行操作</td>
  </tr>
  <%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()){
       Employee e = iterator.next();


  %>
  <tr>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getEmployeeName()%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getSex()%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getAge()%>&nbsp;</td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getPostName()%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getDeptName()%>&nbsp;</td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%=e.getSalary()%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><a href="selectuser.do?action=selectuser&id=">修改</a>&nbsp;&nbsp;<a href="modifyuser.do?action=deleteuser&id=">删除</a></td>
  </tr>
  <%}
  %>
  <tr>
    <td height="22" colspan="7" align="center" bgcolor="#E8FFA7" >对不起，没有添加员工信息！！！</td>
  </tr>
  <%%>
</table>		
		
<!-------------->		</td>
      </tr>
    </table>
   </td>
  </tr>
</table>
</body>
</html>
