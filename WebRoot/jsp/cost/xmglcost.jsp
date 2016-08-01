<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="p" uri="/mytaglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>项目管理系统  成本by www.eyingda.com</title>
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
</head>
<script src="${pageContext.request.contextPath }/js/jquery-1.6.js"></script>
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


/*  function link(){
   location.href='${pageContext.request.contextPath}/servlet/costinfoservlet?flag=add';
} */
$(function(){
	$("input[name='addbtn']").click(function(){
		location.href='${pageContext.request.contextPath}/cost/cost_add.action';
	});
});
 
/* function deleteonclick(){
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
} */
 $(function(){
	$("input[name='deletebtn']").click(function(){
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
		
	});
});
/* function queryonclick(){
	queryForm.submit();
} */
$(function(){
	$("input[name=query]").click(function (){
		$("form[name=queryForm]").submit();
	});
});
	
</SCRIPT>

<body >

<table width="100%" border="0" cellspacing="0" cellpadding="0">
 <form name="queryForm" action="${pageContext.request.contextPath }/cost/cost_select.action" method="post"> 
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
			<td width="550">查看内容： 按项目名称：
              <select name="selectid">
              		<option value="">请选择</option>
					    <c:forEach items="${costList }" var="c">
							<option value="${c.project.projectid }" >${c.project.projectname }</option>
						</c:forEach>
			  </select>
              <input name="query" type="button" class="right-button02" value="查 询" /></td>
			 <td width="132" align="left"><a href="#" onclick="sousuo()">
			   <input name="Submit" type="button" class="right-button07" value="高级搜索" /></a></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </form>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td>
          	<form name="deleteForm" action="${pageContext.request.contextPath }/cost/cost_delete.action" method="post">
          	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
			
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="deletebtn" type="button" class="right-button08" value="删除所选项目信息" />
	              <input name="addbtn" type="button" class="right-button08" value="添加项目" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 成本信息列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="13%" height="20" align="center" bgcolor="#EEEEEE">项目名称</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">单位</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">项目总金额</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">项目负责人</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">项目开发人数</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">成本总支出</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">立项时间</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">计划开始时间</td>
					<td width="7%" align="center" bgcolor="#EEEEEE">实际完成时间</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">任务优先级</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">完成状态</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${costList }" var="c">
                  		<tr align='center'>
                  		<td bgcolor='#FFFFFF'><input type='checkbox' name='delid' value="${c.costid }"/></td>
                  		<td height='20' bgcolor='#FFFFFF'><a href="${pageContext.request.contextPath }/cost/cost_edit.action?costid=${c.costid }">${c.project.projectname }</a></td>
                  		<td bgcolor='#FFFFFF'>${c.customer.customerName }</td>
                  		<td bgcolor='#FFFFFF'>${c.amount }</td>
                  		<td bgcolor='#FFFFFF'>${c.emp.empName }</td>
                  		<td bgcolor='#FFFFFF'>${c.project.workerCount }</td>
                  		<td bgcolor='#FFFFFF'>${c.expend }</td>
                  		<td bgcolor='#FFFFFF'>${c.project.builddate }</td>
                  		<td bgcolor='#FFFFFF'>${c.planningtime }</td>
                  		<td bgcolor='#FFFFFF'>${c.finishtime }</td>
                  		<td bgcolor='#FFFFFF'>${c.level.levelName }</td>
                  		<td bgcolor='#FFFFFF'>${c.state.stateName }</td>
                  		<td bgcolor='#FFFFFF'><a href="${pageContext.request.contextPath }/cost/cost_edit.action?costid=${c.costid }">编辑</a></td>
                  		</tr>
                 </c:forEach>
                </table></td>
              </tr>
            </table>
            </form>
            </td>
        </tr>
      </table>
 		<p:page url="${pageContext.request.contextPath }/servlet/projectinfoservlet?flag=select" page="${page }" />
 </td>
  </tr>
</table>

</body>
</html>
