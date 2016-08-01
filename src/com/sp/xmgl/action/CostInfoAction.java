package com.sp.xmgl.action;

import java.util.List;

import com.sp.xmgl.dao.CustomerDao;
import com.sp.xmgl.dao.EmpDao;
import com.sp.xmgl.dao.LevelDao;
import com.sp.xmgl.dao.ProjectDao;
import com.sp.xmgl.dao.StateDao;
import com.sp.xmgl.hibernatedao.CostDao;
import com.sp.xmgl.po.XmglCost;
import com.sp.xmgl.vo.Cost;
import com.sp.xmgl.vo.Customer;
import com.sp.xmgl.vo.Emp;
import com.sp.xmgl.vo.Page;
import com.sp.xmgl.vo.Project;

public class CostInfoAction {
	private ProjectDao projectDao = new ProjectDao();
	private CustomerDao customerDao = new CustomerDao();
	private EmpDao empDao = new EmpDao();
	private StateDao stateDao = new StateDao();
	private LevelDao levelDao = new LevelDao();
	//private CostDao costDao= new CostDao();
	
	private CostDao costDao =new CostDao();
	
	//private Cost cost;
	private XmglCost cost;
	
	private Project p;
	private Page page;
	private List<Cost> costList;
	private List<Project> projectList;
	private List<Emp> empList;
	private List<Customer> customerList;
	private String selectid;
	private String index;
	private String [] ids;
	private String costid;
	
	public XmglCost getCost() {
		return cost;
	}
	public void setCost(XmglCost cost) {
		this.cost = cost;
	}
	public String getCostid() {
		return costid;
	}
	public void setCostid(String costid) {
		this.costid = costid;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getSelectid() {
		return selectid;
	}
	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	/*public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}*/
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Cost> getCostList() {
		return costList;
	}
	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}
	/*public String query(){//进入主页面
		cost = new Cost();
		page = new Page();
		page.setIndex(1);
		costList= costDao.select(cost,page);
		int count = costDao.getCount(cost);
		int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
		page.setSum(sum);
		return "query";
	}
	public String add(){//进入添加页面
		p = new Project();
		projectList = projectDao.select(p);
		empList = empDao.select();
		customerList= customerDao.select();
		return "add";
	}
	public String addSave(){//添加页面保存
		costDao.updatePId(cost);
		return "addsave";
	}
	public String select(){
		if(index==null || "".equals(index)){
			index = "1";
		}
		page = new Page();
		page.setIndex(Integer.parseInt(index));
		cost = new Cost();
		cost.setSelectid(Integer.parseInt(selectid));
		costList = costDao.select(cost,page);
		int count = costDao.getCount(cost);
		int sum = (count+Constant.PAGECOUNT-1)/Constant.PAGECOUNT;
		page.setSum(sum);
		return "select";
	}
	public String delete(){
		if(ids!=null&&ids.length!=0){
			int[] delIds = new int[ids.length];
			for(int i = 0;i<ids.length;i++){
				delIds[i] = Integer.parseInt(ids[i]);
			}
			costDao.delete(delIds);
		}
		return "delete";
	}*/
	public String edit(){
		System.out.println(costid);
		cost=costDao.selectById(Short.parseShort(costid));
		customerList = customerDao.select();
		empList = empDao.select();
		return "edit";
	}
	
	/*public String save(){//编辑页面保存
		costDao.update(cost);
		return "save";
	}*/
	
}
