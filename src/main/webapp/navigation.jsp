<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<script language="javascript">
function change(img,subMenu,path,type){
	img.src="images/"+path+".GIF";
	if(subMenu!=null){
		if(type==0){
			subMenu.style.display="none";
		}else{
			subMenu.style.display="";
		}
	}
}
</script>

<div style="position:absolute">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td onMouseOver="change(ImgUser,NUser,'NUser_r',1)" onMouseOut="change(ImgUser,NUser,'NUser_b',0)"><a href="#"><img id="ImgUser" src="images/NUser_b.GIF" width="106" height="48" border="0"></a><div id="NUser" style="background-color:#F3FFD5; border:#75A102 1px solid; width:200px; position:absolute; display:none; left:1px; top: 34px;">

                <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="center"><a href="/listUser">���Ա����Ϣ</a>&nbsp;&nbsp;<a href="adduser.jsp">�����Ա��</a></td>
                    </tr>
                </table></div></td>
            <td onMouseOver="change(ImgJob,NJob,'NJob_r',1)" onMouseOut="change(ImgJob,NJob,'NJob_b',0)"><a href="#"><img id="ImgJob" src="images/NJob_b.GIF" width="110" height="48" border="0"></a><div id="NJob" style="background-color:#F3FFD5; border:#75A102 1px solid; width:230px; position:absolute; left:110px; display:none; top: 34px;">
                <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="center"><a href="">ӦƸ��Ϣ</a><td align="center"><a href="/listRecruitment">�ѷ���</a>&nbsp;<a href="recruitment.jsp">���ӦƸ��Ϣ&nbsp;</a></td>
                    </tr>
                </table>
            </div></td>
            <td onMouseOver="change(ImgDept,dept,'dept_r',1)" onMouseOut="change(ImgDept,dept,'dept_b',0)"><a href="#"><img id="ImgDept" src="images/dept_b.GIF" width="111" height="48" border="0"></a><div id="dept" style="background-color:#F3FFD5; border:#75A102 1px solid; width:240px; position:absolute; display:none;left:222px;  top: 34px;">
                <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="center"><a href="listDept">��������</a></td>
                    </tr>
                </table>
            </div></td>
            <td onMouseOver="change(ImgPost,post,'post_r',1)" onMouseOut="change(ImgPost,post,'post_r',0)"><a href="#"><img id="ImgPost" src="images/post_r.GIF" width="110" height="48" border="0"></a><div id="post" style="background-color:#F3FFD5; border:#75A102 1px solid; width:180px; position:absolute; display:none; left:332px;  top: 34px;">
                <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="center"><a href="/listPost">ְλ����</a></td>
                    </tr>
                </table>
            </div></td>
            <td><a href="logout.jsp"><img src="images/NExit_b.GIF" width="98" height="48" border="0" onMouseOver="change(this,null,'NExit_r',1)" onMouseOut="change(this,null,'NExit_b',0)"></a></td>
            <td><img src="images/NNull.GIF" width="130" height="48"></td>
        </tr>
    </table>

</div>