package com.sp.xmgl.po;

import java.util.Date;

/**
 * XmglCost entity. @author MyEclipse Persistence Tools
 */

public class XmglCost implements java.io.Serializable {

	// Fields

	private Short costid;
	private XmglState xmglState;
	private XmglEmp xmglEmp;
	private XmglCustomer xmglCustomer;
	private XmglLevel xmglLevel;
	private XmglProject xmglProject;
	private Double amount;
	private Double expend;
	private Date planningtime;
	private Date finishtime;
	private int selectid;
	// Constructors

	

	/** default constructor */
	public XmglCost() {
	}

	/** full constructor */
	public XmglCost(XmglState xmglState, XmglEmp xmglEmp,
			XmglCustomer xmglCustomer, XmglLevel xmglLevel,
			XmglProject xmglProject, Double amount, Double expend,
			Date planningtime, Date finishtime) {
		this.xmglState = xmglState;
		this.xmglEmp = xmglEmp;
		this.xmglCustomer = xmglCustomer;
		this.xmglLevel = xmglLevel;
		this.xmglProject = xmglProject;
		this.amount = amount;
		this.expend = expend;
		this.planningtime = planningtime;
		this.finishtime = finishtime;
	}

	// Property accessors

	public Short getCostid() {
		return this.costid;
	}

	public void setCostid(Short costid) {
		this.costid = costid;
	}

	public XmglState getXmglState() {
		return this.xmglState;
	}

	public void setXmglState(XmglState xmglState) {
		this.xmglState = xmglState;
	}

	public XmglEmp getXmglEmp() {
		return this.xmglEmp;
	}

	public void setXmglEmp(XmglEmp xmglEmp) {
		this.xmglEmp = xmglEmp;
	}

	public XmglCustomer getXmglCustomer() {
		return this.xmglCustomer;
	}

	public void setXmglCustomer(XmglCustomer xmglCustomer) {
		this.xmglCustomer = xmglCustomer;
	}

	public XmglLevel getXmglLevel() {
		return this.xmglLevel;
	}

	public void setXmglLevel(XmglLevel xmglLevel) {
		this.xmglLevel = xmglLevel;
	}

	public XmglProject getXmglProject() {
		return this.xmglProject;
	}

	public void setXmglProject(XmglProject xmglProject) {
		this.xmglProject = xmglProject;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getExpend() {
		return this.expend;
	}

	public void setExpend(Double expend) {
		this.expend = expend;
	}

	public Date getPlanningtime() {
		return this.planningtime;
	}

	public void setPlanningtime(Date planningtime) {
		this.planningtime = planningtime;
	}

	public Date getFinishtime() {
		return this.finishtime;
	}

	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public int getSelectid() {
		return selectid;
	}

	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
}