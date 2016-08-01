package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Customer;
import com.sp.xmgl.vo.Emp;

public class EmpDao extends BaseDao{
	public List<Emp> select(){
		List<Emp> list = new ArrayList<Emp>();
		try {
			conn = this.getConnection();
			String sql = "select empid,empname from xmgl_emp where jobid = 2";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Emp e = new Emp();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return list;
	}
}
