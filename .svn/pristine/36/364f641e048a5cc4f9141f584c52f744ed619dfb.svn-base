package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Emp;
import com.sp.xmgl.vo.State;

public class StateDao extends BaseDao{
	public List<State> select(){
		List<State> list = new ArrayList<State>();
		try {
			conn = this.getConnection();
			String sql = "select stateid,statename from xmgl_state ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				State e = new State();
				e.setStateId(rs.getInt(1));
				e.setStateName(rs.getString(2));
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
