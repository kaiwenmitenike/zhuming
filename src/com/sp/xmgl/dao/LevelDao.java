package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Level;
import com.sp.xmgl.vo.State;

public class LevelDao extends BaseDao{
	public List<Level> select(){
		List<Level> list = new ArrayList<Level>();
		try {
			conn = this.getConnection();
			String sql = "select levelid,levelname from xmgl_level ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Level e = new Level();
				e.setLevelId(rs.getInt(1));
				e.setLevelName(rs.getString(2));
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
