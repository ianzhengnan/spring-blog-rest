package com.ian.sblog.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ian.sblog.domain.User;

import static com.ian.sblog.util.SBlogConstants.*;

public class UserDynaSqlProvider {

	public String selectWithParam(Map<String, Object> params) {
		
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if (params.get("user") != null) {
					User user = (User)params.get("user");
					if (user.getUsername() != null && !user.getUsername().equals("")) {
						WHERE(" username LIKE CONCAT ('%', #{user.username}, '%')");
					}
				}
			}
		}.toString();
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		return sql;
	}

	
	public String count(Map<String, Object> params) {
	
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if (params.get("user") != null) {
					User user = (User)params.get("user");
					if (user.getUsername() != null && !user.getUsername().equals("")) {
						WHERE(" username LIKE CONCAT ('%', #{user.username}, '%'");
					}
				}
			}
		}.toString();
	
		return sql;
	}

	public String insertUser(User user) {
		return new SQL() {
			{
				INSERT_INTO(USERTABLE);
				if (user.getUsername() != null && !user.getUsername().equals("") ) {
					VALUES("username", "#{username}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if(user.getDisplayName() != null && !user.getDisplayName().equals("")) {
					VALUES("display_name", "#{displayName}");
				}
				if(user.getRealName() != null && !user.getRealName().equals("")) {
					VALUES("real_name", "#{realName}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if(user.getQq() != null && !user.getQq().equals("")) {
					VALUES("qq", "#{qq}");
				}
				if(user.getWechat() != null && !user.getWechat().equals("")) {
					VALUES("wechat", "#{wechat}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")) {
					VALUES("phone", "#{phone}");
				}
				if(user.getPhoto() != null) {
					VALUES("photo", "#{photo}");
				}
				if(user.getGender() != null && !user.getGender().equals(0)) {
					VALUES("gender", "#{gender}");
				}
				if(user.getMarriage() != null && !user.getMarriage().equals(0)) {
					VALUES("marriage", "#{marriage}");
				}
				if(user.getJob() != null && !user.getJob().equals("")) {
					VALUES("job", "#{job}");
				}
				if(user.getEmployer() != null && !user.getEmployer().equals("")) {
					VALUES("employer", "#{employer}");
				}
				if(user.getJobStatus() != null && !user.getJobStatus().equals(0)) {
					VALUES("job_status", "#{jobStatus}");
				}
				if(user.getHobby() != null && !user.getHobby().equals("")) {
					VALUES("hobby", "#{hobby}");
				}
				if(user.getTarget() != null && !user.getTarget().equals("")) {
					VALUES("target", "#{target}");
				}
				if(user.getMotto() != null && !user.getMotto().equals("")) {
					VALUES("motto", "#{motto}");
				}
				if(user.getSelfIntro() != null && !user.getSelfIntro().equals("")) {
					VALUES("self_intr", "#{selfIntro}");
				}
				if(user.getExtId() != null && !user.getExtId().equals("")) {
					VALUES("ext_id", "#{extId}");
				}
				if(user.getToken() != null && !user.getToken().equals("")) {
					VALUES("token", "#{token}");
				}
				if(user.getInformType() != null && !user.getInformType().equals(0)) {
					VALUES("inform_type", "#{informType}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")) {
					VALUES("status", "#{status}");
				}
				if(user.getBlogTitle() != null && !user.getBlogTitle().equals("")) {
					VALUES("blog_title", "#{blogTitle}");
				}
				if(user.getBlogSubtitle() != null && !user.getBlogSubtitle().equals("")) {
					VALUES("blog_subtitle", "#{blogSubtitle}");
				}
				if(user.getBlogTheme() != null && !user.getBlogTheme().equals("")) {
					VALUES("blog_theme", "#{blogTheme}");
				}
				if(user.getLastLogonAt() != null) {
					VALUES("last_logon_at", "#{lastLogonAt}");
				}
				if(user.getLastModifyAt() != null) {
					VALUES("last_modify_at", "#{lastModifyAt}");
				}
			}
		}.toString();
	}
	
	public String updateUser(User user) {
		return new SQL() {
			{
				UPDATE(USERTABLE);
				if (user.getUsername() != null && !user.getUsername().equals("") ) {
					SET("username = #{username}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")) {
					SET("password = #{password}");
				}
				if(user.getDisplayName() != null && !user.getDisplayName().equals("")) {
					SET("display_name = #{displayName}");
				}
				if(user.getRealName() != null && !user.getRealName().equals("")) {
					SET("real_name = #{realName}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")) {
					SET("email = #{email}");
				}
				if(user.getQq() != null && !user.getQq().equals("")) {
					SET("qq = #{qq}");
				}
				if(user.getWechat() != null && !user.getWechat().equals("")) {
					SET("wechat = #{wechat}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")) {
					SET("phone = #{phone}");
				}
				if(user.getPhoto() != null) {
					SET("photo = #{photo}");
				}
				if(user.getGender() != null && !user.getGender().equals(0)) {
					SET("gender = #{gender}");
				}
				if(user.getMarriage() != null && !user.getMarriage().equals(0)) {
					SET("marriage = #{marriage}");
				}
				if(user.getJob() != null && !user.getJob().equals("")) {
					SET("job = #{job}");
				}
				if(user.getEmployer() != null && !user.getEmployer().equals("")) {
					SET("employer = #{employer}");
				}
				if(user.getJobStatus() != null && !user.getJobStatus().equals(0)) {
					SET("job_status = #{jobStatus}");
				}
				if(user.getHobby() != null && !user.getHobby().equals("")) {
					SET("hobby = #{hobby}");
				}
				if(user.getTarget() != null && !user.getTarget().equals("")) {
					SET("target = #{target}");
				}
				if(user.getMotto() != null && !user.getMotto().equals("")) {
					SET("motto = #{motto}");
				}
				if(user.getSelfIntro() != null && !user.getSelfIntro().equals("")) {
					SET("self_intr = #{selfIntro}");
				}
				if(user.getExtId() != null && !user.getExtId().equals("")) {
					SET("ext_id = #{extId}");
				}
				if(user.getToken() != null && !user.getToken().equals("")) {
					SET("token = #{token}");
				}
				if(user.getInformType() != null && !user.getInformType().equals(0)) {
					SET("inform_type = #{informType}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")) {
					SET("status = #{status}");
				}
				if(user.getBlogTitle() != null && !user.getBlogTitle().equals("")) {
					SET("blog_title = #{blogTitle}");
				}
				if(user.getBlogSubtitle() != null && !user.getBlogSubtitle().equals("")) {
					SET("blog_subtitle = #{blogSubtitle}");
				}
				if(user.getBlogTheme() != null && !user.getBlogTheme().equals("")) {
					SET("blog_theme = #{blogTheme}");
				}
				if(user.getLastLogonAt() != null) {
					SET("last_logon_at = #{lastLogonAt}");
				}
				if(user.getLastModifyAt() != null) {
					SET("last_modify_at = #{lastModifyAt}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	
	
}