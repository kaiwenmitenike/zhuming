package com.sp.xmgl.hibernatedao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	protected Session session;
	private static SessionFactory sf;
	static {
		Configuration config = new Configuration().configure();
		sf=config.buildSessionFactory();
	}
	public Session getSession(){
		return sf.openSession();
	}
}
