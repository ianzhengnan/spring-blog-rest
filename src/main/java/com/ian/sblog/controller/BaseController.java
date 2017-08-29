package com.ian.sblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ian.sblog.service.ArticleService;
import com.ian.sblog.service.CategoryService;
import com.ian.sblog.service.CommentService;
import com.ian.sblog.service.UserService;

//@Controller 这个注解不能继承到子类, 不能说此类没有用了，还有用！
public class BaseController {

	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected UserService us;
	@Autowired
	protected ArticleService arts;
	@Autowired
	protected CategoryService cats;
	@Autowired
	protected CommentService cs;
	
	
}
