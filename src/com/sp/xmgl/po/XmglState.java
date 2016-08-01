package com.sp.xmgl.po;

import java.util.HashSet;
import java.util.Set;

/**
 * XmglState entity. @author MyEclipse Persistence Tools
 */

public class XmglState implements java.io.Serializable {

	// Fields

	private Byte stateid;
	private String statename;
	private Set xmglProjects = new HashSet(0);
	private Set xmglCosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public XmglState() {
	}

	/** full constructor */
	public XmglState(String statename, Set xmglProjects, Set xmglCosts) {
		this.statename = statename;
		this.xmglProjects = xmglProjects;
		this.xmglCosts = xmglCosts;
	}

	// Property accessors

	public Byte getStateid() {
		return this.stateid;
	}

	public void setStateid(Byte stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return this.statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
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