package com.sp.xmgl.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sp.xmgl.dao.CostDao;
import com.sp.xmgl.vo.Cost;
import com.sp.xmgl.vo.Project;

public class AjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		String id=request.getParameter("id");
		System.out.println(id);
		//System.out.println(projectselect);
		CostDao costDao= new CostDao();
		List<Cost> projectList = costDao.select(Integer.parseInt(id));
		//JSONObject emps = new JSONObject();
		JSONObject customers = new JSONObject();
		//JSONArray empArray = new JSONArray();
		JSONArray cusArray = new JSONArray();
		for(Cost c:projectList){
			JSONObject customer = new JSONObject();
			customer.put("projectid", c.getProject().getProjectid());
			customer.put("customerid", c.getCustomer().getCustomerId());
			customer.put("customername", c.getCustomer().getCustomerName());
			customer.put("expend", c.getExpend());
			customer.put("panningtime", c.getPlanningtime());
			customer.put("finishtime", c.getFinishtime());
			customer.put("amount", c.getAmount());
			customer.put("workercount", c.getProject().getWorkerCount());
			customer.put("empid", c.getEmp().getEmpId());
			customer.put("empname", c.getEmp().getEmpName());
			cusArray.add(customer);
		}
		customers.put("customers", cusArray);
		pw.print(customers);
		String str = customers.toString();
		System.out.println(str);
		
		
		
	}
}
