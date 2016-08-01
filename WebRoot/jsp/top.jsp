<%@page contentType="text/html; charset=UTF-8" %>
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
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script>
	function zhuxiaoonclick(){
		topForm.submit();
	}

</script>
</head>

<body>
<!-- <input type="button" value="注销" onclick="zhuxiaoonclick();"> -->
<form name="topForm" action="<%=request.getContextPath()%>/servlet/loginservlet?flag=out" method="post" target="_parent"></form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="../images/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%"><a href="http://www.eyingda.com/admin-templates/" target="_blank"><img src="../images/logo.gif" width="557" height="59" border="0" /></a></td>
        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">&copy; 2009 <a href="http://www.eyingda.com" target="_black" style="color:#0099FF;text-decoration:none;">www.eyingda.com</a> QQ:17443217 Email:17443217@qq.com</td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
