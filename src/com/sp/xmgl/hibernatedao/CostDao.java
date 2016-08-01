package com.sp.xmgl.hibernatedao;

import java.util.List;

import com.sp.xmgl.po.XmglCost;

public class CostDao extends BaseDao{
	public XmglCost selectById(short id){//±à¼­°´Å¥
		session = this.getSession();
		return (XmglCost)session.get(XmglCost.class, id);
	}
	
	/*public List<XmglCost> select(XmglCost c){
		session = this.getSession();
		String hql = " from " ;
		return null;
	}*/
}
