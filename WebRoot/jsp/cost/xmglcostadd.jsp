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

<!-- <script >
	var xmlHttp;
	//创建一个XMLHttpRequest对象
	function createXMLHttpRequest(){
	  xmlHttp= false;
	  //开始初始化XMLHttpRequest对象
	  if(window.XMLHttpRequest) { //除IE外 所有浏览器
	      xmlHttp= new XMLHttpRequest();
	  }else if(window.ActiveXObject){ // IE浏览器
	      try{
		   xmlHttp= new ActiveXObject("Msxml2.XMLHTTP");//通用http协议创建
	          }catch(e){
	             try{
	                  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");//MS方式创建
	              }catch(e){
	
	         }
	  }
	}
	  if (! xmlHttp) { // 异常，创建对象实例失败
	      window.alert("不能创建XMLHttpRequest对象实例.");
	      return false;
	   }
	}
	function projectonchange(){
		createXMLHttpRequest();
			xmlHttp.onreadystatechange=projectonchangeCallback;
			xmlHttp.open("POST","${pageContext.request.contextPath}/servlet/ajaxservlet?projectselect="+document.getElementById("projectselect").value);
			xmlHttp.send(null);
	}
	function projectonchangeCallback(){
		if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
				var str = xmlHttp.responseText;
				//将字符串 转成 json对象     eval(str)函数   解析javascript代码
					var obj = eval("("+str+")");	
					//所属单位
					var cusSelect = document.getElementById("customer");
					for(var i = cusSelect.options.length-1;i>=0;i--){
						cusSelect.remove(i);
					}
					for(var i = 0;i<obj.customers.length;i++){
						var cusid = obj.customers[i].customerid;
						var cusname = obj.customers[i].customername;
						var option = document.createElement("option");
						option.text = cusname;
						option.value = cusid;
						cusSelect.add(option);
					}
					//项目经理
					var empSelect = document.getElementById("emp");
					//清除empSelect中的所有option 除了请选择的option
					for(var i = empSelect.options.length-1;i>=0;i--){
						empSelect.remove(i);
					}
					for(var i = 0;i<obj.customers.length;i++){
						var empid = obj.customers[i].empid;
						var empname = obj.customers[i].empname;
						var option = document.createElement("option");
						option.text = empname;
						option.value = empid;
						empSelect.add(option);
					}
					//开发人数
					var workinput = document.getElementById("workercount");
					workinput.value="";
					for(var i = 0;i<obj.customers.length;i++){
						var workercount = obj.customers[i].workercount;
						var input = document.createElement("value");
						input.value = workercount;
						workinput.value=input;
					}
				
					 
				}
			}
		}
</script> -->
<script>
$(function(){
$("#projectselect").change(function(){
	
				$.ajax({
					url:"${pageContext.request.contextPath}/servlet/ajaxservlet",
					type:"post",
					
					data:{id:$("#projectselect").val()},
					success:function(data,status){
						//清空
						for(var i = $("#customer option").length-1;i>=0;i--){
							$("#customer")[0].remove(i);
						}
						for(var i = $("#emp option").length-1 ; i >= 0 ; i--){
							$("#emp")[0].remove(i);
						}
						//拼二级的option
						$(data.customers).each(function(){
							var option = document.createElement("option");
							option.text = this.customername;
							option.value = this.customerid;
							$("#customer")[0].add(option);
						});
						$(data.customers).each(function(){
							$("#amount").val(this.amount);
						});
						$(data.customers).each(function(){
							$("#workercount").val(this.workercount);
						});
						$(data.customers).each(function(){
							var option = document.createElement("option");
							option.text = this.empname;
							option.value = this.empid;
							$("#emp")[0].add(option);
						});
						$(data.customers).each(function(){
							$("#expend").val(this.expend);
						});
						$(data.customers).each(function(){
							$("#planningtime").val(this.planningtime);
						});
						$(data.customers).each(function(){
							$("#finishtime").val(this.finishtime);
						});
					},
					dataType:"json"
				});
			});
});

	 $(function(){
		$("input[name=savebtn]").click(function (){
			$("form[name=saveform]").submit();
		});
	});


</script>


<script src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
</head>

<body class="ContentBody">
<form action="${pageContext.request.contextPath}/cost/cost_addSave.action" method="post"  name="saveform" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >成本添加录入</th>
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
					    <td width="35%">
					    <select style="width:150px" name="cost.project.projectid" id="projectselect"  >
					    	<option value="">请选择</option>
					    	<c:forEach items="${projectList }" var="p">
								<option value="${p.projectid }">${p.projectname }</option>
							</c:forEach>
					    </select>
				        <span class="red" >*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%">
					    <select style="width:150px" id="customer" name="customerid">
					    	<option value="">请选择</option>
					    	<c:forEach items="${customerList }" var="c">
					    		<option value="${c.customerId }">${c.customerName }</option>
					    	</c:forEach> 
					    </select>
				        <span class="red" >*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目总金额:</td>
					    <td width="35%"><input name='cost.amount' type="text" class="text" style="width:154px" id="amount" value="" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input id="workercount" name='workercount' type="text" class="text" style="width:154px" value="" />			        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<select id="emp" name="managerid">
									<option value="">请选择</option>
									<c:forEach items="${empList }" var="e">
										<option value="${e.empId }">${e.empName }</option>
									</c:forEach>
								</select></span>							</td>
							<td nowrap align="right" width="15%">预算总支出:</td>
							<td width="35%"><input name='cost.expend' id="expend" type="text" class="text" style="width:154px" value="" />					</td>
				        </tr>
						<tr>	
							<td nowrap="nowrap" align="right">计划日期:</td>
							<td><input name='cost.planningtime' id="planningtime" type="text" class="text" style="width:154px" readonly="readonly" value="" onclick="WdatePicker();" />                            </td>
							<td nowrap="nowrap" align="right">完成日期:</td>
						  <td><input name='cost.finishtime' id="finishtime" type="text" class="text" style="width:154px" value="" onclick="WdatePicker();" readonly="readonly"/>                          </td>	
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


