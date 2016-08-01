<%@page import="com.sp.xmgl.vo.Emp"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>

<script src="${pageContext.request.contextPath }/js/jquery-1.6.js"></script>
<script>
	$(document).ready(function(){
		$("input[name=savebtn]").click(function(){
			$("form[name=saveform]").submit();
		
		});
	});
		

</script>
<script src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
</head>

<body class="ContentBody">
  <form action="${pageContext.request.contextPath}/cost/cost_save.action" method="post"  name="saveform" >
   <input type="hidden" name="cost.costid" value="${cost.costid }">

<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目添加录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr align="center">
          <td class="TablePanel">
             <input name="projectname2" value="${cost.project.projectname }" />
          </td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">项目名称:</td>
					    <td width="35%"><input name='projectname' type="text" class="text" style="width:154px" value="${cost.project.projectname }" readonly="readonly"/>
				        <span class="red">*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%">
					    <select style="width:150px" name="customerid" readonly="readonly">
					    	<option value="">请选择</option>
					    	<c:forEach items="${customerList }" var="c">
					    		<c:if test="${c.customerId==cost.customer.customerId }">
					    			<option value="${c.customerId }" selected>${c.customerName }</option>
					    		</c:if>
					    	</c:forEach>
					    </select>
				        <span class="red">*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目总金额:</td>
					    <td width="35%"><input name='cost.amount' type="text" class="text" style="width:154px" value="${cost.amount }" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input name='workercount' type="text" class="text" style="width:154px" value="${cost.project.workerCount }" readonly="readonly"/>				        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<select id="select1" name="managerid" readonly="readonly">
									<option value="">请选择</option>
									<c:forEach items="${empList }" var="e">
					    				<c:if test="${e.empId==cost.emp.empId }">
					    					<option value="${e.empId }" selected>${e.empName }</option>
					    				</c:if>
					    			</c:forEach>
								</select>							</td>
							<td nowrap align="right" width="15%">预算总支出:</td>
							<td width="35%"><input name='cost.expend' type="text" class="text" style="width:154px" value="${cost.expend }" />							</td>
				        </tr>
						<tr>	
							<td nowrap="nowrap" align="right">计划时间:</td>
							<td><input name='cost.planningtime' type="text" class="text" style="width:154px" value="${cost.planningtime }" onclick="WdatePicker();" readonly/>                            </td>
							<td nowrap="nowrap" align="right">完成日期:</td>
						  <td><input name='cost.finishtime' type="text" class="text" style="width:154px" value="${cost.finishtime }" onclick="WdatePicker();" readonly/>                          </td>	
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
			<input type="button" name="savebtn" value="保存" class="button" />　
			
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


