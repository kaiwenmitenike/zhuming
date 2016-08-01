package com.sp.xmgl.po;

import java.util.HashSet;
import java.util.Set;

/**
 * XmglEmp entity. @author MyEclipse Persistence Tools
 */

public class XmglEmp implements java.io.Serializable {

	// Fields

	private Short empid;
	private String empname;
	private Short jobid;
	private Short salary;
	private Set xmglProjects = new HashSet(0);
	private Set xmglCosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public XmglEmp() {
	}

	/** full constructor */
	public XmglEmp(String empname, Short jobid, Short salary, Set xmglProjects,
			Set xmglCosts) {
		this.empname = empname;
		this.jobid = jobid;
		this.salary = salary;
		this.xmglProjects = xmglProjects;
		this.xmglCosts = xmglCosts;
	}

	// Property accessors

	public Short getEmpid() {
		return this.empid;
	}

	public void setEmpid(Short empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Short getJobid() {
		return this.jobid;
	}

	public void setJobid(Short jobid) {
		this.jobid = jobid;
	}

	public Short getSalary() {
		return this.salary;
	}

	public void setSalary(Short salary) {
		this.salary = salary;
	}

	public Set getXmglProjects() {
		return this.xmglProjects;
	}

	public void setXmglProjects(Set xmglProjects) {
		this.xmglProjects = xmglProjects;
	}

	public Set getXmglCosts() {
		return this.xmglCosts;
	}

	public void setXmglCosts(Set xmglCosts) {
		this.xmglCosts = xmglCosts;
	}

}