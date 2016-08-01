package com.sp.xmgl.po;

import java.util.HashSet;
import java.util.Set;

/**
 * XmglLevel entity. @author MyEclipse Persistence Tools
 */

public class XmglLevel implements java.io.Serializable {

	// Fields

	private Short levelid;
	private String levelname;
	private Set xmglProjects = new HashSet(0);
	private Set xmglCosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public XmglLevel() {
	}

	/** full constructor */
	public XmglLevel(String levelname, Set xmglProjects, Set xmglCosts) {
		this.levelname = levelname;
		this.xmglProjects = xmglProjects;
		this.xmglCosts = xmglCosts;
	}

	// Property accessors

	public Short getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Short levelid) {
		this.levelid = levelid;
	}

	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
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