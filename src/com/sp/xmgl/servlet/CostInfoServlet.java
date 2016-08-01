package com.sp.xmgl.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.xmgl.common.Constant;
import com.sp.xmgl.dao.CostDao;
import com.sp.xmgl.dao.CustomerDao;
import com.sp.xmgl.dao.EmpDao;
import com.sp.xmgl.dao.LevelDao;
import com.sp.xmgl.dao.ProjectDao;
import com.sp.xmgl.dao.StateDao;
import com.sp.xmgl.vo.Cost;
import com.sp.xmgl.vo.Customer;
import com.sp.xmgl.vo.Emp;
import com.sp.xmgl.vo.Level;
import com.sp.xmgl.vo.Page;
import com.sp.xmgl.vo.Project;
import com.sp.xmgl.vo.State;

public class CostInfoServlet extends HttpServlet {
	private ProjectDao projectDao = new ProjectDao();
	private CustomerDao customerDao = new CustomerDao();
	private EmpDao empDao = new EmpDao();
	private StateDao stateDao = new StateDao();
	private LevelDao levelDao = new LevelDao();
	private CostDao costDao= new CostDao();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//接受flag的值
		String flag = request.getParameter("flag");
		if("query".equals(flag)){//xmglcost
			Cost cost = new Cost();
			Page page = new Page();
			page.setIndex(1);
			List<Cost> costList= costDao.select(cost,page);
			int count = costDao.getCount(cost);
			int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
			page.setSum(sum);
			request.setAttribute("costList", costList);
			request.setAttribute("cost", cost);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/cost/xmglcost.jsp")
			.forward(request, response);
		}else if("add".equals(flag)){//xmglcostadd新增页面
			//联动
			/*PrintWriter pw = response.getWriter();
			String projectselect=request.getParameter("projectselect");
			//System.out.println(projectselect);
			List<Project> projectList = costDao.select(Integer.parseInt(projectselect));
			StringBuffer sb = new StringBuffer("<?xml version='1.0' encoding='utf-8' ?>");
			sb.append("<customers>");
			for(Project p:projectList){
				sb.append("<customer>");
				sb.append("<customerid>"+p.getCustomer().getCustomerId()+"</customerid>");
				sb.append("<customername>"+p.getCustomer().getCustomerName()+"</customername>");
				sb.append("</customer>");
			}
			sb.append("</customers>");
			pw.print(sb);*/
			Project p = new Project();
			List<Project> projectList = projectDao.select(p);
			List<Emp> empList = empDao.select();
			List<Customer> customerList= customerDao.select();
			request.setAttribute("projectList", projectList);
			request.setAttribute("empList", empList);
			request.setAttribute("customerList", customerList);

			request.getRequestDispatcher("/jsp/cost/xmglcostadd.jsp")
			.forward(request, response);
		}else if("edit".equals(flag)){//xmglcostedit编辑按钮
			String costId = request.getParameter("costid");
			Cost cost=costDao.selectById(Integer.parseInt(costId));
			List<Customer> customerList = customerDao.select();
			List<Emp> empList = empDao.select();
			List<State> stateList = stateDao.select();
			List<Level> levleList = levelDao.select();
			//Project p = new Project();
			//List<Project> projectList = projectDao.select(p);
			//将集合传到jsp中   依托一个数据容器request   
			request.setAttribute("customerList", customerList);
			request.setAttribute("empList", empList);
			request.setAttribute("stateList", stateList);
			request.setAttribute("levelList", levleList);
			//request.setAttribute("projectList", projectList); 
			request.setAttribute("cost", cost);
			request.getRequestDispatcher("/jsp/cost/xmglcostedit.jsp")
			.forward(request, response);
		}else if("delete".equals(flag)){//删除
			String [] ids = request.getParameterValues("delid");
			if(ids!=null&&ids.length!=0){
				int[] delIds = new int[ids.length];
				for(int i = 0;i<ids.length;i++){
					delIds[i] = Integer.parseInt(ids[i]);
				}
				costDao.delete(delIds);
			}
			
			request.getRequestDispatcher("/servlet/costinfoservlet?flag=query")
			.forward(request, response);
		}else if("select".equals(flag)){
			String selectid=request.getParameter("selectid");
			String index = request.getParameter("pageNo");
			if(index==null || "".equals(index)){
				index = "1";
			}
			Page page = new Page();
			page.setIndex(Integer.parseInt(index));
			Cost cost = new Cost();
			cost.setSelectid(Integer.parseInt(selectid));
			List<Cost> costList = costDao.select(cost,page);
			int count = costDao.getCount(cost);
			int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
			page.setSum(sum);
			request.setAttribute("costList", costList);
			request.setAttribute("cost", cost);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/cost/xmglcost.jsp").forward(request, response);
		}else if("save".equals(flag)){
			String expend = request.getParameter("expend");
			String planningtime = request.getParameter("planningtime");
			String finishtime = request.getParameter("finishtime");
			String costid = request.getParameter("costid");
			Cost c= new Cost();
			c.setExpend(Double.parseDouble(expend));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(planningtime);
				c.setPlanningtime(date);
				date = sdf.parse(finishtime);
				c.setFinishtime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setCostid(Integer.parseInt(costid));
			costDao.update(c);
			request.getRequestDispatcher("/servlet/costinfoservlet?flag=query").forward(request, response);
		}
	}
}
