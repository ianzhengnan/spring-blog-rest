package com.ian.sblog.service.impl;

import java.util.List;
import java.util.Map;

import com.ian.sblog.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ian.sblog.dao.CommentDao;
import com.ian.sblog.domain.Comment;
import com.ian.sblog.service.CommentService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
@Service
public class CommentServiceImpl implements CommentService {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createComment(Comment comment) {
		log.debug("CommentServiceImpl >>> create a comment");
		commentDao.save(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

	@Override
	public void removeComment(Integer id) {
		commentDao.removeById(id);
	}

	@Override
	public List<Comment> getComments(Map<String, Object> params) {

		List<Comment> comments = commentDao.selectByParams(params);
		for (Comment comment :
				comments) {
			comment.setCreateBy(userDao.selectById(comment.getCreateBy().getId()));
		}
		return comments;
	}

}
