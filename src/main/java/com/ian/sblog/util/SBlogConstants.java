package com.ian.sblog.util;

public interface SBlogConstants {

	// 数据库表常亮
	String USERTABLE = "bg_user";
	String ARTICLETABLE = "bg_article";
	String CATEGORYTABLE = "bg_category";
	String COMMENTTABLE = "bg_comment";
	String FOLLOWTABLE = "bg_follow";
	String PICTURETABLE = "bg_picture";
	String STAREDARTICLETABLE = "bg_stared_article";
	
//	// 登录
	String LOGIN = "/account/login";
//	// 用户的session对象
	String USER_SESSION = "user_session";
//	// 默认每页4条数据
	int PAGE_DEFAULT_SIZE = 5;
}
