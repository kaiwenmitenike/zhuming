<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script>
	function saveonclick(){
		
		//验证
		
		saveForm.submit();
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<form action="${pageContext.request.contextPath}/servlet/projectinfoservlet?flag=save" method="post"  name="saveForm"  >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目添加录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">项目名称:</td>
					    <td width="35%"><input name='projectName' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%">
					    <select style="width:150px" name="customerId">
					    	<option value="">请选择</option>
					    	<c:forEach items="${customerList }" var="c">
					    		<option value="${c.customerId }">${c.customerName }</option>
					    	</c:forEach>
					    </select>
				        <span class="red">*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目金额:</td>
					    <td width="35%"><input name='amt' type="text" class="text" style="width:154px" value="" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input name='workerCount' type="text" class="text" style="width:154px" value="" />				        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<select id="select1" name="managerId">
									<option value="">请选择</option>
									<c:forEach items="${empList }" var="e">
										<option value="${e.empId }">${e.empName }</option>
									</c:forEach>
								</select>							</td>
							<td nowrap align="right" width="18%">完成状态:</td>
							<td width="35%">
							<select id="select1" name="stateId">
										<option value="">请选择</option>
									<c:forEach items="${stateList }" var="s">
										<option value="${s.stateId}">${s.stateName }</option>
									</c:forEach>	
							</select>							</td>
				        </tr>
						<tr>	
							
						</tr>
						<tr>
							<td nowrap="nowrap" align="right">立项日期:</td>
							<td><input name='buildDate' type="text" class="text" style="width:154px" value="" />                            </td>	
							<td  align="right" >优先级:</td>
							<td ><select name="levelId" >
                               			<option value="">请选择</option>
                               		<c:forEach items="${levelList }" var="e">
										<option value="${e.levelId}">${e.levelName }</option>
									</c:forEach>
                            </select></td>
						</tr>
					  </table>
			  <br />
				</fieldset>			</TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
 
	
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button" name="Submit" value="保存" class="button" onclick="saveonclick();"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>