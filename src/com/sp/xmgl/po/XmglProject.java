package com.sp.xmgl.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * XmglProject entity. @author MyEclipse Persistence Tools
 */

public class XmglProject implements java.io.Serializable {

	// Fields

	private Short projectid;
	private XmglState xmglState;
	private XmglCustomer xmglCustomer;
	private XmglLevel xmglLevel;
	private XmglEmp xmglEmp;
	private String projectname;
	private Short workercount;
	private Date builddate;
	private Date updatedate;
	private Date createdate;
	private Integer amt;
	private Integer salary;
	private Set xmglCosts = new HashSet(0);
	private Set xmglUploadings = new HashSet(0);

	// Constructors

	/** default constructor */
	public XmglProject() {
	}

	/** full constructor */
	public XmglProject(XmglState xmglState, XmglCustomer xmglCustomer,
			XmglLevel xmglLevel, XmglEmp xmglEmp, String projectname,
			Short workercount, Date builddate, Date updatedate,
			Date createdate, Integer amt, Integer salary, Set xmglCosts,
			Set xmglUploadings) {
		this.xmglState = xmglState;
		this.xmglCustomer = xmglCustomer;
		this.xmglLevel = xmglLevel;
		this.xmglEmp = xmglEmp;
		this.projectname = projectname;
		this.workercount = workercount;
		this.builddate = builddate;
		this.updatedate = updatedate;
		this.createdate = createdate;
		this.amt = amt;
		this.salary = salary;
		this.xmglCosts = xmglCosts;
		this.xmglUploadings = xmglUploadings;
	}

	// Property accessors

	public Short getProjectid() {
		return this.projectid;
	}

	public void setProjectid(Short projectid) {
		this.projectid = projectid;
	}

	public XmglState getXmglState() {
		return this.xmglState;
	}

	public void setXmglState(XmglState xmglState) {
		this.xmglState = xmglState;
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

	public XmglEmp getXmglEmp() {
		return this.xmglEmp;
	}

	public void setXmglEmp(XmglEmp xmglEmp) {
		this.xmglEmp = xmglEmp;
	}

	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Short getWorkercount() {
		return this.workercount;
	}

	public void setWorkercount(Short workercount) {
		this.workercount = workercount;
	}

	public Date getBuilddate() {
		return this.builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getAmt() {
		return this.amt;
	}

	public void setAmt(Integer amt) {
		this.amt = amt;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Set getXmglCosts() {
		return this.xmglCosts;
	}

	public void setXmglCosts(Set xmglCosts) {
		this.xmglCosts = xmglCosts;
	}

	public Set getXmglUploadings() {
		return this.xmglUploadings;
	}

	public void setXmglUploadings(Set xmglUploadings) {
		this.xmglUploadings = xmglUploadings;
	}

}