package com.sp.xmgl.po;

import java.util.HashSet;
import java.util.Set;

/**
 * XmglCustomer entity. @author MyEclipse Persistence Tools
 */

public class XmglCustomer implements java.io.Serializable {

	// Fields

	private Short customerid;
	private String customername;
	private Set xmglProjects = new HashSet(0);
	private Set xmglCosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public XmglCustomer() {
	}

	/** full constructor */
	public XmglCustomer(String customername, Set xmglProjects, Set xmglCosts) {
		this.customername = customername;
		this.xmglProjects = xmglProjects;
		this.xmglCosts = xmglCosts;
	}

	// Property accessors

	public Short getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Short customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
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