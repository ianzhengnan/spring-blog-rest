package com.ian.sblog.domain;

import java.util.Date;
import java.util.List;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String displayName;
	private String realName;
	private String email;
	private String qq;
	private String wechat;
	private String phone;
	private String photo;
	private Integer gender;
	private Integer marriage;
	private String job;
	private String employer;
	private Integer jobStatus;
	private String hobby;
	private String target;
	private String motto;
	private String selfIntro;
	private String extId;
	private String token;
	private List<Article> staredArticles;
	private List<User> followers;
	private List<User> followings;
	private Integer informType;
	private String status;
	private String blogTitle;
	private String blogSubtitle;
	private String blogTheme;
	private Date lastLogonAt;
	private Date createAt;
	private Date lastModifyAt;
	
	public User() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getMarriage() {
		return marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getSelfIntro() {
		return selfIntro;
	}

	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Article> getStaredArticles() {
		return staredArticles;
	}

	public void setStaredArticles(List<Article> staredArticles) {
		this.staredArticles = staredArticles;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<User> getFollowings() {
		return followings;
	}

	public void setFollowings(List<User> followings) {
		this.followings = followings;
	}

	public Integer getInformType() {
		return informType;
	}

	public void setInformType(Integer informType) {
		this.informType = informType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogSubtitle() {
		return blogSubtitle;
	}

	public void setBlogSubtitle(String blogSubtitle) {
		this.blogSubtitle = blogSubtitle;
	}

	public String getBlogTheme() {
		return blogTheme;
	}

	public void setBlogTheme(String blogTheme) {
		this.blogTheme = blogTheme;
	}

	public Date getLastLogonAt() {
		return lastLogonAt;
	}

	public void setLastLogonAt(Date lastLogonAt) {
		this.lastLogonAt = lastLogonAt;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastModifyAt() {
		return lastModifyAt;
	}

	public void setLastModifyAt(Date lastModifyAt) {
		this.lastModifyAt = lastModifyAt;
	}
	
	
	
}
