package com.sp.xmgl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.xmgl.common.CommonDate;
import com.sp.xmgl.common.Constant;
import com.sp.xmgl.dao.CustomerDao;
import com.sp.xmgl.dao.EmpDao;
import com.sp.xmgl.dao.LevelDao;
import com.sp.xmgl.dao.ProjectDao;
import com.sp.xmgl.dao.StateDao;
import com.sp.xmgl.vo.Customer;
import com.sp.xmgl.vo.Emp;
import com.sp.xmgl.vo.Level;
import com.sp.xmgl.vo.Page;
import com.sp.xmgl.vo.Project;
import com.sp.xmgl.vo.State;

public class ProjectInfoServlet extends HttpServlet{
	private ProjectDao projectDao = new ProjectDao();
	private CustomerDao customerDao = new CustomerDao();
	private EmpDao empDao = new EmpDao();
	private StateDao stateDao = new StateDao();
	private LevelDao levelDao = new LevelDao();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		//接收flag的值
		String flag = request.getParameter("flag");
		if("query".equals(flag)){
			Project p = new Project();
			Page page = new Page();
			page.setIndex(1);
			
			List<Project> projectList = projectDao.select(p,page);
			int count = projectDao.getCount(p);
			int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
			page.setSum(sum);
			request.setAttribute("projectList", projectList);
			request.setAttribute("project", p);
			request.setAttribute("page", page);
			//跳转到jsp
			request.getRequestDispatcher("/jsp/xmgllist.jsp")
				.forward(request, response);
		}else if("add".equals(flag)){
			//调用dao
			
			List<Customer> customerList = customerDao.select();
			
			List<Emp> empList = empDao.select();
			
			List<State> stateList = stateDao.select();
			
			
			List<Level> levleList = levelDao.select();
			//将集合传到jsp中   依托一个数据容器request   
			request.setAttribute("customerList", customerList);
			request.setAttribute("empList", empList);
			request.setAttribute("stateList", stateList);
			request.setAttribute("levelList", levleList);
			
			request.getRequestDispatcher("/jsp/xmgladd.jsp")
				.forward(request, response);
		}else if("edit".equals(flag)){
			String projectId = request.getParameter("projectid");
			Project project = projectDao.selectById(Integer.parseInt(projectId));
			List<Customer> customerList = customerDao.select();
			
			List<Emp> empList = empDao.select();
			
			List<State> stateList = stateDao.select();
			
			
			List<Level> levleList = levelDao.select();
			//将集合传到jsp中   依托一个数据容器request   
			request.setAttribute("customerList", customerList);
			request.setAttribute("empList", empList);
			request.setAttribute("stateList", stateList);
			request.setAttribute("levelList", levleList);
			request.setAttribute("project", project);
			request.getRequestDispatcher("/jsp/xmglmodify.jsp").forward(request, response);
		}else if("save".equals(flag)){
			//接收请求参数
			String projectName = request.getParameter("projectName");
			String customerId = request.getParameter("customerId");
			String amt = request.getParameter("amt");
			String workerCount = request.getParameter("workerCount");
			String managerId = request.getParameter("managerId");
			String stateId = request.getParameter("stateId");
			String levelId = request.getParameter("levelId");
			String buildDate = request.getParameter("buildDate");
			Project p = new Project();
			p.setProjectname(projectName);
			p.getCustomer().setCustomerId(Integer.parseInt(customerId));
			p.setAmt(Integer.parseInt(amt));
			p.setWorkerCount(Integer.parseInt(workerCount));
			p.getManager().setEmpId(Integer.parseInt(managerId));
			p.getState().setStateId(Integer.parseInt(stateId));
			p.getLevel().setLevelId(Integer.parseInt(levelId));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(buildDate);
				p.setBuilddate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//调用dao
			
			projectDao.insert(p);
						
			//跳转
			request.getRequestDispatcher("/servlet/projectinfoservlet?flag=query").forward(request, response);
		}else if("select".equals(flag)){
			String startDate = request.getParameter("startDate");
			System.out.println(startDate);
			String endDate = request.getParameter("endDate");
			String index = request.getParameter("pageNo");
			if(index==null || "".equals(index)){
				index = "1";
			}
			Page page = new Page();
			page.setIndex(Integer.parseInt(index));
			Project p = new Project();
			
			p.setStartDate(CommonDate.parseDate(startDate, "yyyy-MM-dd"));
			p.setEndDate(CommonDate.parseDate(endDate, "yyyy-MM-dd"));
			List<Project> projectList = projectDao.select(p,page);
			int count = projectDao.getCount(p);
			int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
			page.setSum(sum);
			request.setAttribute("projectList", projectList);
			request.setAttribute("project", p);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/xmgllist.jsp").forward(request, response);
			
		}else if("delete".equals(flag)){
			//接收id
			String[] ids = request.getParameterValues("delid");
			if(ids!=null&&ids.length!=0){
				int[] delIds = new int[ids.length];
				for(int i = 0;i<ids.length;i++){
					delIds[i] = Integer.parseInt(ids[i]);
				}
				
				projectDao.delete(delIds);
			}
			request.getRequestDispatcher("/servlet/projectinfoservlet?flag=query").forward(request, response);
		}else if("update".equals(flag)){
			String projectName = request.getParameter("projectName");
			String customerId = request.getParameter("customerId");
			String amt = request.getParameter("amt");
			String workerCount = request.getParameter("workerCount");
			String managerId = request.getParameter("managerId");
			String stateId = request.getParameter("stateId");
			String levelId = request.getParameter("levelId");
			String buildDate = request.getParameter("buildDate");
			String projectId = request.getParameter("projectId");
			Project p = new Project();
			p.setProjectname(projectName);
			p.getCustomer().setCustomerId(Integer.parseInt(customerId));
			p.setAmt(Integer.parseInt(amt));
			p.setWorkerCount(Integer.parseInt(workerCount));
			p.getManager().setEmpId(Integer.parseInt(managerId));
			p.getState().setStateId(Integer.parseInt(stateId));
			p.getLevel().setLevelId(Integer.parseInt(levelId));
			p.setBuilddate(CommonDate.parseDate(buildDate, "yyyy-MM-dd"));
			p.setProjectid(Integer.parseInt(projectId));
			projectDao.update(p);
			request.getRequestDispatcher("/servlet/projectinfoservlet?flag=query").forward(request, response);
		}else if("info".equals(flag)){
			String projectId = request.getParameter("projectid");
			Project project = projectDao.selectById(Integer.parseInt(projectId));
			List<Customer> customerList = customerDao.select();
			
			List<Emp> empList = empDao.select();
			
			List<State> stateList = stateDao.select();
			
			
			List<Level> levleList = levelDao.select();
			//将集合传到jsp中   依托一个数据容器request   
			request.setAttribute("customerList", customerList);
			request.setAttribute("empList", empList);
			request.setAttribute("stateList", stateList);
			request.setAttribute("levelList", levleList);
			request.setAttribute("project", project);
			request.getRequestDispatcher("/jsp/xmglinfo.jsp").forward(request, response);
		}
	}
}
