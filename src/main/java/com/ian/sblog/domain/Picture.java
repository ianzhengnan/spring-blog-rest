package com.ian.sblog.domain;

import java.sql.Blob;
import java.util.Date;


public class Picture {

	private Integer id;
	private Blob picture;
	private Blob thumbnail;
	private String mimeType;
	private Long fileSize;
	private String fileName;
	private String fileUrl;
	private Article article;
	private User user;
	private Date createAt;
	
	public Picture() {
		
	}
	
	public Blob getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
}
