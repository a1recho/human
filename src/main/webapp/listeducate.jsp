<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>������Դ����ϵͳ</title>
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
   <table width="94%"  border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF" bgcolor="#97B14E" >
  <tr>
    <td height="22" colspan="6" align="center" bgcolor="#97B150" class="word_yellow">-
	  <%
	String educate=null;
	try{
		educate=request.getParameter("educate").toString();
	}catch(Exception e){
		educate="0";
	}
	if("1".equals(educate)){
		out.print("��ѵ�ܽ�");
	  }else{
		out.print("��ѵ�ƻ�");
	  }
	%>
	-</td>
  </tr>
  <tr class="tdhui">
    <td height="22" align="center" bgcolor="#E8FFA7" >��ѵ����</td>
    <td height="22" align="center" bgcolor="#E8FFA7" >��ʦ</td>
    <td height="22" align="center" bgcolor="#E8FFA7" >��ѵ��Ա</td>
    <td height="22" align="center" bgcolor="#E8FFA7" >��ʼʱ��</td>
    <td height="22" align="center" bgcolor="#E8FFA7" >����ʱ��</td>
    <td height="22" align="center" bgcolor="#E8FFA7" >ִ�в���</td>
  </tr>
  <%
  %>
  <tr>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><%%></td>
    <td height="22" align="center" bgcolor="#FFFFFF" ><a href="detaileducate.do?educate=<%=educate%>&action=detaileducate&id=<%%>">��ϸ</a>&nbsp;&nbsp;<a href="modifyeducate.do?action=deleteeducate&educate=<%%>">ɾ��</a>
      <%if(!"1".equals(educate)){%>&nbsp;&nbsp;<a href="updateeducate.do?educate=1&action=detaileducate&id=<%%>">��ѵ���</a><%}%></td>
  </tr>
  <%
  %>
  <tr>
    <td height="22" colspan="6" align="center" bgcolor="#E8FFA7" >�Բ���û����Ϣ������</td>
  </tr>
  <%%>
</table>		
		
<!-------------->		</td>
      </tr>
    </table>
    <jsp:include page="copyright.html"/></td>
  </tr>
</table>

</body>
</html>
