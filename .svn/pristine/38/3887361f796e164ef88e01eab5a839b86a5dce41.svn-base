<%@page import="com.sp.xmgl.vo.Level"%>
<%@page import="com.sp.xmgl.vo.State"%>
<%@page import="com.sp.xmgl.vo.Emp"%>
<%@page import="com.sp.xmgl.vo.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.sp.xmgl.vo.Project"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%

	Project p = (Project)request.getAttribute("project");
	List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
	List<Emp> empList = (List<Emp>)request.getAttribute("empList");
	List<State> stateList = (List<State>)request.getAttribute("stateList");
	List<Level> levelList = (List<Level>)request.getAttribute("levelList");
%>
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
<script>
	function saveonclick(){
		
		updateForm.submit();
	}
</script>
</head>

<body class="ContentBody">
  <form action="<%=request.getContextPath() %>/servlet/projectinfoservlet?flag=update" method="post"  name="updateForm" >
  <input type="hidden" name="projectId" value="<%=p.getProjectid()%>">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目修改页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		
		<tr align="center">
          <td class="TablePanel">XXX项目</td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">项目名称:</td>
					    <td width="35%"><input name='projectName' type="text" class="text" style="width:154px" value="<%=p.getProjectname() %>" disabled/>
				        <span class="red">*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%"><select name="customerId" style="width:150px" disabled>
					    	<option value="">请选择</option>
					    	<%
					    		for(Customer c:customerList){
					    			if(c.getCustomerId()==p.getCustomer().getCustomerId()){
					    				out.print("<option value='"+c.getCustomerId()+"' selected>"+c.getCustomerName()+"</option>");
					    			}else{
					    				out.print("<option value='"+c.getCustomerId()+"'>"+c.getCustomerName()+"</option>");
					    			}
					    		}
					    	%>
					    	</select>
				        <span class="red">*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目金额:</td>
					    <td width="35%"><input name='amt' disabled type="text" class="text" style="width:154px" value="<%=p.getAmt()%>" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input name='workerCount' disabled type="text" class="text" style="width:154px" value="<%=p.getWorkerCount() %>" />				        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<select id="select1" name="managerId" disabled>
								<option value="">请选择</option>
							<%
					    		for(Emp c:empList){
					    			if(c.getEmpId()==p.getManager().getEmpId()){
					    				out.print("<option value='"+c.getEmpId()+"' selected>"+c.getEmpName()+"</option>");
					    			}else{
					    				out.print("<option value='"+c.getEmpId()+"'>"+c.getEmpName()+"</option>");
					    			}
					    		}
					    	%>
								</select>							</td>
							<td nowrap align="right" width="18%">完成状态:</td>
							<td width="35%">
							<select id="select1" name="stateId" disabled>
							<option value="">请选择</option>
							<%
					    		for(State c:stateList){
					    			if(c.getStateId()==p.getState().getStateId()){
					    				out.print("<option value='"+c.getStateId()+"' selected>"+c.getStateName()+"</option>");
					    			}else{
					    				out.print("<option value='"+c.getStateId()+"'>"+c.getStateName()+"</option>");
					    			}
					    		}
					    	%>
							</select>							</td>
				        </tr>
						<tr>
							<td nowrap="nowrap" align="right">立项日期:</td>
							<td><input name='buildDate' type="text" disabled class="text" style="width:154px" value="<%=p.getBuilddate() %>" />                            </td>
							<td  align="right" >优先级:</td>
						  <td ><select name="levelId" disabled>
                              <option value="">请选择</option>
                              <%
					    		for(Level c:levelList){
					    			if(c.getLevelId()==p.getLevel().getLevelId()){
					    				out.print("<option value='"+c.getLevelId()+"' selected>"+c.getLevelName()+"</option>");
					    			}else{
					    				out.print("<option value='"+c.getLevelId()+"'>"+c.getLevelName()+"</option>");
					    			}
					    		}
					    	%>
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
