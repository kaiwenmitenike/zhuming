package com.sp.xmgl.po;

import java.util.Date;

/**
 * XmglUploading entity. @author MyEclipse Persistence Tools
 */

public class XmglUploading implements java.io.Serializable {

	// Fields

	private Integer uploadingId;
	private XmglProject xmglProject;
	private String uploadingName;
	private String uploadingMan;
	private Date uploadingDate;
	private String fileSize;
	private String fileLeixing;
	private String filePath;

	// Constructors

	/** default constructor */
	public XmglUploading() {
	}

	/** full constructor */
	public XmglUploading(XmglProject xmglProject, String uploadingName,
			String uploadingMan, Date uploadingDate, String fileSize,
			String fileLeixing, String filePath) {
		this.xmglProject = xmglProject;
		this.uploadingName = uploadingName;
		this.uploadingMan = uploadingMan;
		this.uploadingDate = uploadingDate;
		this.fileSize = fileSize;
		this.fileLeixing = fileLeixing;
		this.filePath = filePath;
	}

	// Property accessors

	public Integer getUploadingId() {
		return this.uploadingId;
	}

	public void setUploadingId(Integer uploadingId) {
		this.uploadingId = uploadingId;
	}

	public XmglProject getXmglProject() {
		return this.xmglProject;
	}

	public void setXmglProject(XmglProject xmglProject) {
		this.xmglProject = xmglProject;
	}

	public String getUploadingName() {
		return this.uploadingName;
	}

	public void setUploadingName(String uploadingName) {
		this.uploadingName = uploadingName;
	}

	public String getUploadingMan() {
		return this.uploadingMan;
	}

	public void setUploadingMan(String uploadingMan) {
		this.uploadingMan = uploadingMan;
	}

	public Date getUploadingDate() {
		return this.uploadingDate;
	}

	public void setUploadingDate(Date uploadingDate) {
		this.uploadingDate = uploadingDate;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileLeixing() {
		return this.fileLeixing;
	}

	public void setFileLeixing(String fileLeixing) {
		this.fileLeixing = fileLeixing;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}