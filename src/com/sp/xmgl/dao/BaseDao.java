package com.sp.xmgl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs ;
	protected ResultSetMetaData rsmd;
	private static String driver ;
	private static String url;
	private static String username;
	private static String password;
	private static int initialSize;
	private static int maxActive;
	private static int maxIdle;
	private static BasicDataSource dbs;
	static{
		
		ResourceBundle rb = ResourceBundle.getBundle("db");
		driver = rb.getString("driver");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		initialSize = Integer.parseInt(rb.getString("initialSize"));
		maxActive = Integer.parseInt(rb.getString("maxActive"));
		maxIdle = Integer.parseInt(rb.getString("maxIdle"));
		
		dbs = new BasicDataSource();
		dbs.setDriverClassName(driver);
		dbs.setUrl(url);
		dbs.setUsername(username);
		dbs.setPassword(password);
		dbs.setInitialSize(initialSize);
		dbs.setMaxActive(maxActive);
		dbs.setMaxIdle(maxIdle);
		
		
	}
	public Connection getConnection(){
		try {
			conn = dbs.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
