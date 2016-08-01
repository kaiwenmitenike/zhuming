package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Page;
import com.sp.xmgl.vo.Project;

public class ProjectDao extends BaseDao{
	
	public void insert(Project p){
		conn = this.getConnection();
		String sql = "insert into xmgl_project(projectid,customerid,managerid,stateid," +
				"levelid,projectname,workercount,amt,builddate,updatedate,createdate) " +
				"values(seq_project.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, p.getCustomer().getCustomerId());
			stmt.setInt(2, p.getManager().getEmpId());
			stmt.setInt(3, p.getState().getStateId());
			stmt.setInt(4, p.getLevel().getLevelId());
			stmt.setString(5, p.getProjectname());
			stmt.setInt(6,p.getWorkerCount());
			stmt.setInt(7, p.getAmt());
			stmt.setDate(8, new java.sql.Date(p.getBuilddate().getTime()));
			stmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
			stmt.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		
	}
	public void update(Project p){
		conn = this.getConnection();
		String sql = "update xmgl_project set projectname = ? ,customerid=?,amt=?,workercount=?," +
				"managerid=?,stateid=?,levelid=?,builddate=?,updatedate=? where projectid=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getProjectname());
			stmt.setInt(2, p.getCustomer().getCustomerId());
			stmt.setInt(3, p.getAmt());
			stmt.setInt(4, p.getWorkerCount());
			stmt.setInt(5, p.getManager().getEmpId());
			stmt.setInt(6, p.getState().getStateId());
			stmt.setInt(7, p.getLevel().getLevelId());
			stmt.setDate(8, new java.sql.Date(p.getBuilddate().getTime()));
			stmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
			stmt.setInt(10, p.getProjectid());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
	}
	
	public List<Project> select(Project p,Page page){
		List<Project> list = new ArrayList<Project>();
		conn = this.getConnection();
		String sql = "select * from "+
					"(select p.projectname,c.customername,e.empname,  "+
					"					p.workercount,p.builddate,p.updatedate,  "+
					"					l.levelname,s.statename,p.projectid ,rownum rn "+
					"					from xmgl_project p  "+
					"					left outer join xmgl_customer c on p.customerid = c.customerid "+ 
					"					left outer join xmgl_emp e on p.managerid = e.empid  "+
					"					left outer join xmgl_state s on p.stateid = s.stateid  "+
					"					left outer join xmgl_level l on p.levelid = l.levelid where 1=1 ";
		if(p.getStartDate()!=null){
			sql+= " and p.builddate >= ? ";
		}
		if(p.getEndDate()!=null){
			sql+= " and p.builddate <= ? ";
		}
		sql += ") "+
				"where rn >= ? and rn<= ?";
		try {
			stmt = conn.prepareStatement(sql);
			int index = 1;
			if(p.getStartDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getStartDate().getTime()));
			}
			if(p.getEndDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getEndDate().getTime()));
			}
			stmt.setInt(index++, (page.getIndex()-1)*page.getCount()+1);
			stmt.setInt(index++, page.getIndex()*page.getCount());
			rs = stmt.executeQuery();
			while(rs.next()){
				Project project = new Project();
				project.setProjectname(rs.getString(1));
				project.getCustomer().setCustomerName(rs.getString(2));
				project.getManager().setEmpName(rs.getString(3));
				project.setWorkerCount(rs.getInt(4));
				project.setBuilddate(rs.getDate(5));
				project.setUpdatedate(rs.getDate(6));
				project.getLevel().setLevelName(rs.getString(7));
				project.getState().setStateName(rs.getString(8));
				project.setProjectid(rs.getInt(9));
				list.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return list;
	}
	
	
	
	public List<Project> select(Project p){
		List<Project> list = new ArrayList<Project>();
		conn = this.getConnection();
		String sql = "select p.projectname,c.customername,e.empname, "+
					"p.workercount,p.builddate,p.updatedate, "+
					"l.levelname,s.statename,p.projectid "+
					"from xmgl_project p "+
					"left outer join xmgl_customer c on p.customerid = c.customerid "+
					"left outer join xmgl_emp e on p.managerid = e.empid "+
					"left outer join xmgl_state s on p.stateid = s.stateid "+
					"left outer join xmgl_level l on p.levelid = l.levelid where 1=1 ";
		if(p.getStartDate()!=null){
			sql+= " and p.builddate >= ? ";
		}
		if(p.getEndDate()!=null){
			sql+= " and p.builddate <= ? ";
		}
		try {
			stmt = conn.prepareStatement(sql);
			int index = 1;
			if(p.getStartDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getStartDate().getTime()));
			}
			if(p.getEndDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getEndDate().getTime()));
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				Project project = new Project();
				project.setProjectname(rs.getString(1));
				project.getCustomer().setCustomerName(rs.getString(2));
				project.getManager().setEmpName(rs.getString(3));
				project.setWorkerCount(rs.getInt(4));
				project.setBuilddate(rs.getDate(5));
				project.setUpdatedate(rs.getDate(6));
				project.getLevel().setLevelName(rs.getString(7));
				project.getState().setStateName(rs.getString(8));
				project.setProjectid(rs.getInt(9));
				list.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return list;
	}
	public Project selectById(int id){
		Project project = new Project();
		conn = this.getConnection();
		String sql = "select projectid,projectname,customerid,amt,workercount,managerid," +
				"stateid,builddate,levelid from xmgl_project where projectid = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				project.setProjectname(rs.getString("projectname"));
				project.getCustomer().setCustomerId(rs.getInt("customerid"));
				project.getManager().setEmpId(rs.getInt("managerid"));
				project.setWorkerCount(rs.getInt("workercount"));
				project.setBuilddate(rs.getDate("builddate"));
				project.getLevel().setLevelId(rs.getInt("levelid"));
				project.getState().setStateId(rs.getInt("stateid"));
				project.setProjectid(rs.getInt("projectid"));
				project.setAmt(rs.getInt("amt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return project;
	}
	public void delete(int id){
		
	}
	public void delete(int[] ids){
		if(ids==null||ids.length==0) return;
		conn = this.getConnection();
		String sql = "delete from xmgl_project where projectid in (";
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
	
	public int getCount(Project p){
		int count = 0;
		conn = this.getConnection();
		String sql = "select count(projectid) "+
					"from xmgl_project "+
					" where 1=1 ";
		if(p.getStartDate()!=null){
			sql+= " and builddate >= ? ";
		}
		if(p.getEndDate()!=null){
			sql+= " and builddate <= ? ";
		}
		try {
			stmt = conn.prepareStatement(sql);
			int index = 1;
			if(p.getStartDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getStartDate().getTime()));
			}
			if(p.getEndDate()!=null){
				stmt.setDate(index++, new java.sql.Date(p.getEndDate().getTime()));
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

