package com.sp.xmgl.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.xmgl.vo.Customer;

public class CustomerDao extends BaseDao{
	public List<Customer> select(){
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = this.getConnection();
			String sql = "select customerid,customername from xmgl_customer";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
				list.add(c);
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
