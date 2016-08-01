package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.User;

public class UserDao extends BaseDao{
	
	public List<User> select(User user){
		List<User> list = new ArrayList<User>();
		conn = this.getConnection();
		String sql = "select username,password from xmgl_user where 1=1 ";
		if(user.getUsername()!=null&&!"".equals(user.getUsername())){
			sql += " and username = ?";
		}
		if(user.getPassword()!=null&&!"".equals(user.getPassword())){
			sql += " and password = ?";
		}
		try {
			stmt = conn.prepareStatement(sql);
			int index = 1;
			if(user.getUsername()!=null&&!"".equals(user.getUsername())){
				stmt.setString(index++, user.getUsername());
			}
			if(user.getPassword()!=null&&!"".equals(user.getPassword())){
				stmt.setString(index++, user.getPassword());
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				list.add(u);
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
