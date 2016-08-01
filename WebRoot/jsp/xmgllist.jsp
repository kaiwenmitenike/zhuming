
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="p" uri="/mytaglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
<script src="<%=request.getContextPath()%>/js/datepicker/WdatePicker.js"></script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
   location.href='${pageContext.request.contextPath}/servlet/projectinfoservlet?flag=add';
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
function queryonclick(){
	queryForm.submit();
}
function deleteonclick(){
	//判断  是否有勾选的记录
	var cbs = document.getElementsByName("delid");
	var flag = true;
	for(var i = 0;i<cbs.length;i++){
		if(cbs[i].checked){
			flag =false;
			break;
		}
	}
	if(flag){
		alert("请勾选要删除的记录！");
		return;
	}
	//是否确认删除
	if(confirm("是否要删除选中的记录？")){
		deleteForm.submit();
	}
	
}

</SCRIPT>

<body onload="on_load()">

<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
 <form name="queryForm" action="<%=request.getContextPath()%>/servlet/projectinfoservlet?flag=select" method="post"> 
		  
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
           <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
			<td width="550">查看内容：按时间：
			
             <input name="startDate" type="text" size="12" value="<fmt:formatDate value="${project.startDate }" pattern="yyyy-MM-dd"/>" onclick="WdatePicker();" readonly/><span class="newfont06">至</span>
			 <input name="endDate" type="text" size="12" value="<fmt:formatDate value="${project.endDate }" pattern="yyyy-MM-dd"/>" onclick="WdatePicker();" readonly/>	
			 <input name="Submit" type="button" class="right-button02" value="查 询" onclick="queryonclick();"/></td>
			 <td width="132" align="left"><a href="#" onclick="sousuo()">
			   <input name="Submit" type="button" class="right-button07" value="高级搜索" /></a></td>	
		  </tr>
        </table>
         </td>
      </tr>
    </table></td>
  </tr>
 </form>
  <tr>
  
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td>
          <form name="deleteForm" action="<%=request.getContextPath()%>/servlet/projectinfoservlet?flag=delete" method="post">
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选项目信息" onclick="deleteonclick();"/>
	              <input name="Submit2" type="button" class="right-button08" value="添加项目" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="10" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 项目信息列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE" >项目名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">客户名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">项目经理</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">开发人数</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">立项时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">更新时间</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">任务优先级</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">状态</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${projectList }" var="p">
                  		<tr align='center'>
                  		<td bgcolor='#FFFFFF'><input type='checkbox' name='delid' value="${p.projectid }"/></td>
                  		<td height='20' bgcolor='#FFFFFF'><a href='xiangmuzongbiao.htm' nowrap>${p.projectname }</a></td>
                  		<td bgcolor='#FFFFFF'>${p.customer.customerName }</td>
                  		<td bgcolor='#FFFFFF'>${p.manager.empName }</td>
                  		<td bgcolor='#FFFFFF'>${p.workerCount }</td>
                  		<td bgcolor='#FFFFFF'>${p.builddate }</td>
                  		<td bgcolor='#FFFFFF'>${p.updatedate }</td>
                  		<td bgcolor='#FFFFFF'>${p.level.levelName }</td>
                  		<td bgcolor='#FFFFFF'>${p.state.stateName }</td>
                  		<td bgcolor='#FFFFFF'><a href="${pageContext.request.contextPath }/servlet/projectinfoservlet?flag=edit&projectid=${p.projectid}">编辑</a>|<a href="${pageContext.request.contextPath }/servlet/projectinfoservlet?flag=info&projectid=${p.projectid}">查看</a></td>
                  		</tr>
                  </c:forEach>
                            
                </table>
                </form>
                </td>
              </tr>
            </table></td>
        </tr>
      </table>
      
      <p:page url="${pageContext.request.contextPath }/servlet/projectinfoservlet?flag=select" page="${page }" />
      </td>
  </tr>
</table>


<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
