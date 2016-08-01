package com.sp.xmgl.common.tag;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sp.xmgl.vo.Page;

public class PageTag extends SimpleTagSupport{
	private Page page;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext)this.getJspContext();
		JspWriter out = pageContext.getOut();
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		Map<String,String[]> map = request.getParameterMap();
		
		
		out.print("<script>");
		out.print("function nextPage(){");
		out.print("	var sum = "+page.getSum()+";");
		out.print("	if(parseInt(pageForm.pageNo.value)>=sum){");
		out.print("		alert('已经到达末页');");
		out.print("		return;");
		out.print("	}");

		out.print("	pageForm.pageNo.value = parseInt(pageForm.pageNo.value)+1;");

		out.print("	pageForm.submit();	");
		out.print("}");
		out.print("function uppage(){");
		out.print("	var sum = "+page.getSum()+";");
		out.print("	if(parseInt(pageForm.pageNo.value)<=1){");
		out.print("		alert('已经到达首页');");
		out.print("		return;");
		out.print("	}");
		out.print("	pageForm.pageNo.value = parseInt(pageForm.pageNo.value)-1;");

		out.print("	pageForm.submit();");
		out.print("}");
		out.print("function firstPage(){");
		out.print("	pageForm.pageNo.value = 1;");
		out.print("	pageForm.submit();");
		out.print("}");
		out.print("function lastPage(){");
		out.print("	pageForm.pageNo.value = "+page.getSum()+";");
		out.print("	pageForm.submit();");
		out.print("}");
		out.print("function goPage(){");
		out.print("	var sum = "+page.getSum()+";");
		out.print("	if(parseInt(pageForm.pageNo.value)<1 || parseInt(pageForm.pageNo.value)>sum){");
		out.print("		alert('页数超出范围');");
		out.print("		return;");
		out.print("	}");
		out.print("	pageForm.submit();");
		out.print("}");
		out.print("</script>");
		out.print("<form name='pageForm' method='post' action='"+url+"'>");
	Set<String> set = map.keySet();
	for(String key:set){
		if(!"pageNo".equals(key)){
			String [] values = map.get(key);
			for(String value:values){
				out.print("<input type='hidden' name='"+key+"' value='"+value+"'>");
			}
		}
	}
		out.print("      <table width='95%' border='0' align='center' cellpadding='0' cellspacing='0'>");
		out.print("        <tr>");
		out.print("          <td height='6'><img src='../images/spacer.gif' width='1' height='1' /></td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <td height='33'><table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' class='right-font08'>");
		out.print("              <tr>");
		out.print("                <td width='50%'>共 <span class='right-text09'>"+page.getSum()+"</span> 页 | 第 <span class='right-text09'>"+page.getIndex()+"</span> 页</td>");
		out.print("                <td width='49%' align='right'>[<a href='#' class='right-font08' onclick='firstPage();'>首页</a> | <a href='#' class='right-font08' onclick='uppage();'>上一页</a> | <a href='#' class='right-font08' onclick='nextPage();'>下一页</a> | <a href='#' class='right-font08' onclick='lastPage();'>末页</a>] 转至：</td>");
		out.print("                <td width='1%'><table width='20' border='0' cellspacing='0' cellpadding='0'>");
		out.print("                    <tr>");
		out.print("                      <td width='1%'><input name='pageNo' type='text' class='right-textfield03' size='1' value='"+page.getIndex()+"'/></td>");
		out.print("                      <td width='87%'><input name='Submit23222' type='button' class='right-button06' value=' ' onclick='goPage();'/>");
		out.print("                      </td>");
		out.print("                    </tr>");
		out.print("                </table></td>");
		out.print("              </tr>");
		out.print("          </table></td>");
		out.print("        </tr>");
		out.print("      </table>");
		out.print("      </form>");
	}
}
