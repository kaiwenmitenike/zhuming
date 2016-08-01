package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Cost;
import com.sp.xmgl.vo.Page;
import com.sp.xmgl.vo.Project;

public class CostDao extends BaseDao{
	//xmglcostadd
	public void insert(Cost c){
		conn = this.getConnection();
		String sql = "insert into xmgl_cost c (costid,expend," +
				"planningtime,finishtime,projectid,customerid,empid) " +
				"values(seq_cost.nextval,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1,c.getExpend());
			stmt.setDate(2, new java.sql.Date(c.getPlanningtime().getTime()));
			stmt.setDate(3, new java.sql.Date(c.getFinishtime().getTime()));
			stmt.setInt(4, c.getProject().getProjectid());
			stmt.setInt(5, c.getCustomer().getCustomerId());
			stmt.setInt(6, c.getEmp().getEmpId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		
	}
	
	
	//xmglcostlist 
	public List<Cost> select(Cost c){
		List<Cost> list = new ArrayList<Cost>();
		conn = this.getConnection();
		String sql = "select c.costid,p.projectname,cus.customername, " +
				"(sum(e.salary)/count(e.empid))*(c.finishtime-c.planningtime)*(p.workercount)+p.amt expend, " +
				"c.planningtime,c.finishtime,c.amount,p.workercount,e.empname,l.levelname,s.statename," +
				"p.builddate,p.projectid " +
				"from xmgl_cost c "+
				"left outer join xmgl_project p on c.projectid = p.projectid " +
				"left outer join xmgl_customer cus on p.customerid = cus.customerid "+
				"left outer join xmgl_emp e on p.managerid = e.empid "+
				"left outer join xmgl_level l on p.levelid = l.levelid "+
				"left outer join xmgl_state s on p.stateid = s.stateid " +
				"where 1=1 ";
		if(c.getSelectid()!=0){
			sql+= " and p.projectid = ? ";
		}
		sql+="group by c.costid,p.projectname,cus.customername,c.planningtime,c.finishtime," +
				"c.amount,p.workercount,e.empname,l.levelname,s.statename," +
				"p.builddate,p.projectid,p.amt";
		try {
			stmt = conn.prepareStatement(sql);
		if(c.getSelectid()!=0){
				stmt.setInt(1, c.getSelectid());
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				Cost cost = new Cost();
				cost.setCostid(rs.getInt(1));
				cost.getProject().setProjectname(rs.getString(2));
				cost.getCustomer().setCustomerName(rs.getString(3));
				cost.setExpend(rs.getDouble(4));
				cost.setPlanningtime(rs.getDate(5));
				cost.setFinishtime(rs.getDate(6));
				cost.setAmount(rs.getDouble(7));
				cost.getProject().setWorkerCount(rs.getInt(8));
				cost.getEmp().setEmpName(rs.getString(9));
				cost.getLevel().setLevelName(rs.getString(10));
				cost.getState().setStateName(rs.getString(11));
				cost.getProject().setBuilddate(rs.getDate(12));
				cost.getProject().setProjectid(rs.getInt(13));
				list.add(cost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return list;
	}
	//xmglcostedit
	public Cost selectById(int id){
		Cost cost = new Cost();
		conn = this.getConnection();
		String sql = "select c.costid,p.projectname,cus.customerid,c.expend,c.planningtime,c.finishtime,c.amount," +
					"p.workercount,e.empid " +
					"from xmgl_cost c "+
					"left outer join xmgl_project p on c.projectid = p.projectid " +
					"left outer join xmgl_customer cus on p.customerid = cus.customerid "+
					"left outer join xmgl_emp e on p.managerid = e.empid "+
					"where costid = ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				cost.setCostid(rs.getInt(1));
				cost.getProject().setProjectname(rs.getString(2));
				cost.getCustomer().setCustomerId(rs.getInt(3));
				cost.setExpend(rs.getDouble(4));
				cost.setPlanningtime(rs.getDate(5));
				cost.setFinishtime(rs.getDate(6));
				cost.setAmount(rs.getDouble(7));
				cost.getProject().setWorkerCount(rs.getInt(8));
				cost.getEmp().setEmpId(rs.getInt(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return cost;
	}
	

	public void delete(int[] ids){
		if(ids==null||ids.length==0) return;
		conn = this.getConnection();
		String sql = "delete from xmgl_cost where costid in (";
		for(int i = 0;i<ids.length;i++){
			sql += "?,";
		}
		sql = sql.substring(0, sql.length()-1);
		sql += ")";
		try {
			stmt = conn.prepareStatement(sql);
			for(int i = 0;i<ids.length;i++){
				stmt.setInt(i+1, ids[i]);
			}
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
	}
	
	//����
	public List<Cost> select(int projectid){
		List<Cost> list = new ArrayList<Cost>();
		Cost c = new Cost();
		conn= this.getConnection();
		/*String sql ="select p.projectid,c.customerid,c.customername,e.empid,e.empname ,p.workercount " +
				"from xmgl_project p " +
				"left outer join xmgl_customer c on p.customerid = c.customerid "+
				"left outer join xmgl_emp e on p.managerid = e.empid " +
				"where p.projectid = ?";*/
		/*String sql = "select p.projectid,c.customerid,c.customername,e.empid,e.empname,p.workercount," +
				"cost.amount,cost.expend,cost.planningtime,cost.finishtime " +
				"from xmgl_cost cost "+
				"left outer join xmgl_project p on cost.projectid = p.projectid " +
				"left outer join xmgl_customer c on p.customerid = c.customerid "+
				"left outer join xmgl_emp e on p.managerid = e.empid "+
				"where p.projectid = ? ";*/
		String sql="select p.projectid,cus.customerid,cus.customername, " +
				"(sum(e.salary)/count(e.empid))*(c.finishtime-c.planningtime)*(p.workercount)+p.amt expend, " +
				"c.planningtime,c.finishtime,c.amount,p.workercount,e.empid,e.empname " +
				"from xmgl_cost c "+
				"left outer join xmgl_project p on c.projectid = p.projectid " +
				"left outer join xmgl_customer cus on p.customerid = cus.customerid "+
				"left outer join xmgl_emp e on p.managerid = e.empid "+
				"left outer join xmgl_level l on p.levelid = l.levelid "+
				"left outer join xmgl_state s on p.stateid = s.stateid " +
				"where p.projectid = ? " +
				"group by p.projectid,cus.customerid,cus.customername,c.planningtime,c.finishtime," +
				"c.amount,p.workercount,e.empid,e.empname,p.amt " ;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, projectid);
			rs=stmt.executeQuery();
			while(rs.next()){
				c.getProject().setProjectid(rs.getInt(1));
				c.getCustomer().setCustomerId(rs.getInt(2));
				c.getCustomer().setCustomerName(rs.getString(3));
				c.setExpend(rs.getDouble(4));
				c.setPlanningtime(new java.util.Date(rs.getDate(5).getTime()));
				c.setFinishtime(new java.util.Date(rs.getDate(6).getTime()));
				c.setAmount(rs.getDouble(7));
				c.getProject().setWorkerCount(rs.getInt(8));
				c.getEmp().setEmpId(rs.getInt(9));
				c.getEmp().setEmpName(rs.getString(10));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}
	
	public void update(Cost c){
		conn = this.getConnection();
		String sql = "update xmgl_cost set amount = ?,expend=?,planningtime=?,finishtime=? " +
				"where costid=?" ;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, c.getAmount());
			stmt.setDouble(2, c.getExpend());
			stmt.setDate(3, new java.sql.Date(c.getPlanningtime().getTime()));
			stmt.setDate(4, new java.sql.Date(c.getFinishtime().getTime()));
			stmt.setInt(5, c.getCostid());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
	}
	public void updatePId(Cost c){
		conn = this.getConnection();
		String sql = "update xmgl_cost set amount = ?,expend=?,planningtime=?,finishtime=? " +
				"where projectid=?" ;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, c.getAmount());
			stmt.setDouble(2, c.getExpend());
			stmt.setDate(3, new java.sql.Date(c.getPlanningtime().getTime()));
			stmt.setDate(4, new java.sql.Date(c.getFinishtime().getTime()));
			stmt.setInt(5, c.getProject().getProjectid());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
	}
	
	public List<Cost> select(Cost c,Page page){
		List<Cost> list = new ArrayList<Cost>();
		conn = this.getConnection();
		String sql = "select * from " +
				"(select c.costid,p.projectname,cus.customername, " +
				"(sum(e.salary)/count(e.empid))*(c.finishtime-c.planningtime)*(p.workercount)+p.amt expend, " +
				"c.planningtime,c.finishtime,c.amount,p.workercount,e.empname,l.levelname,s.statename," +
				"p.builddate,p.projectid ,rownum rn " +
				"from xmgl_cost c "+
				"left outer join xmgl_project p on c.projectid = p.projectid " +
				"left outer join xmgl_customer cus on p.customerid = cus.customerid "+
				"left outer join xmgl_emp e on p.managerid = e.empid "+
				"left outer join xmgl_level l on p.levelid = l.levelid "+
				"left outer join xmgl_state s on p.stateid = s.stateid " +
				"where 1=1 ";
		if(c.getSelectid()!=0){
			sql+= " and p.projectid = ? ";
		}
		sql+="group by c.costid,p.projectname,cus.customername,c.planningtime,c.finishtime," +
				"c.amount,p.workercount,e.empname,l.levelname,s.statename," +
				"p.builddate,p.projectid,p.amt,rownum";
		
		sql += ") "+
				"where rn >= ? and rn<= ?";
		try {
			stmt = conn.prepareStatement(sql);
			int index=1;
			if(c.getSelectid()!=0){
					stmt.setInt(index++, c.getSelectid());
				}
			stmt.setInt(index++, (page.getIndex()-1)*page.getCount()+1);
			stmt.setInt(index++, page.getIndex()*page.getCount());
			rs = stmt.executeQuery();
			while(rs.next()){
				Cost cost = new Cost();
				cost.setCostid(rs.getInt(1));
				cost.getProject().setProjectname(rs.getString(2));
				cost.getCustomer().setCustomerName(rs.getString(3));
				cost.setExpend(rs.getDouble(4));
				cost.setPlanningtime(rs.getDate(5));
				cost.setFinishtime(rs.getDate(6));
				cost.setAmount(rs.getDouble(7));
				cost.getProject().setWorkerCount(rs.getInt(8));
				cost.getEmp().setEmpName(rs.getString(9));
				cost.getLevel().setLevelName(rs.getString(10));
				cost.getState().setStateName(rs.getString(11));
				cost.getProject().setBuilddate(rs.getDate(12));
				cost.getProject().setProjectid(rs.getInt(13));
				list.add(cost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return list;
	}
	public int getCount(Cost c){
		int count = 0;
		conn = this.getConnection();
		String sql = "select count(costid) "+
					"from xmgl_cost "+
					" where 1=1 ";
		if(c.getSelectid()!=0){
			sql+= " and costid = ? ";
		}
		try {
			stmt = conn.prepareStatement(sql);
			if(c.getSelectid()!=0){
				stmt.setInt(1, c.getSelectid());
			}
			rs = stmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return count;
	}
	
}
