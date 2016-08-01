<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%

	Cookie[] cookies = request.getCookies();
	
	String username = "";
	String password = "";
	if(cookies!=null){
		System.out.println(cookies.length);
		for(Cookie c:cookies){
			/*if("username".equals(c.getName())){
				username = c.getValue();
			}
			if("password".equals(c.getName())){
				password = c.getValue();
			}
			*/
			System.out.println(c.getName());
		}
	}

%>
<%
	String flag = (String)request.getAttribute("flag");
	if("false".equals(flag)){
%>
	<script>
		alert("用户名或密码错误，请重新登录");
	</script>
<%		
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet" type="text/css" />
<script>
	function btnonclick(){
		loginForm.submit();
	}
</script>
</head>

<body>
<f:bundle basename="language">
<form name="loginForm" method="post" action="<%=request.getContextPath()%>/servlet/loginservlet?flag=login">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="<%=request.getContextPath() %>/images/top02.gif"><img src="<%=request.getContextPath() %>/images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="<%=request.getContextPath() %>/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：<br /></td>
        <td width="69%"><input name="username" type="text" size="30" value="<%=username%>"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码：<br /></td>
        <td><input name="password" type="password" size="33" value="<%=password%>"/></td>
      </tr>

      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="button" class="right-button01" value="确认登陆" onClick="btnonclick();" />
          <input name="Submit232" type="submit" class="right-button02" value="重置" /></td>
      </tr>
      
    </table></td>
  </tr>
</table>
</form>
</f:bundle>
</body>
</html>