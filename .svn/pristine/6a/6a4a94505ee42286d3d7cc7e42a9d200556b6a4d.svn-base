<%@page contentType="text/html; charset=UTF-8" %>
<%
if("Y".equals(session.getAttribute("isSave"))){
	Cookie cookie = new Cookie("username", session.getAttribute("username")+"");
	cookie.setMaxAge(1000*60*60*24);
	response.addCookie(cookie);
	cookie = new Cookie("password", session.getAttribute("password")+"");
	cookie.setMaxAge(1000*60*60*24);
	response.addCookie(cookie);
}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
</head>

<frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="<%=request.getContextPath() %>/jsp/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="213,*" frameborder="no" border="0" framespacing="0">
    <frame src="<%=request.getContextPath() %>/jsp/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="<%=request.getContextPath() %>/jsp/mainframe.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
