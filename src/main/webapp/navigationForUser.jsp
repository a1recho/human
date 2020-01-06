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
            <td onMouseOver="change(ImgJob,NJob,'NJob_r',1)" onMouseOut="change(ImgJob,NJob,'NJob_b',0)"><a href="#"><img id="ImgJob" src="images/NJob_b.GIF" width="110" height="48" border="0"></a><div id="NJob" style="background-color:#F3FFD5; border:#75A102 1px solid; width:230px; position:absolute; left:110px; display:none; top: 34px;">
                <table width="100%" border="0" height="35px" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="center"><a href="/listRecruitmentForUser">招聘信息</a>&nbsp;<a href="/listResumeForUser">我的应聘&nbsp;</a><a href="/Resume.jsp">添加简历信息&nbsp;</a></td>
                    </tr>
                </table>
            </div></td>
            <td><a href="/loginOut"><img src="images/NExit_b.GIF" width="98" height="48" border="0" onMouseOver="change(this,null,'NExit_r',1)" onMouseOut="change(this,null,'NExit_b',0)"></a></td>
            <td><img src="images/NNull.GIF" width="130" height="48"></td>
        </tr>
    </table>

</div>