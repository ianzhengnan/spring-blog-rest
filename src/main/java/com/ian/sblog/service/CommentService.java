package com.ian.sblog.service;

import java.util.List;
import java.util.Map;

import com.ian.sblog.domain.Comment;

public interface CommentService {

	void createComment(Comment comment);
	
	void updateComment(Comment comment);
	
	void removeComment(Integer id);
	
	List<Comment> getComments(Map<String, Object> params);
	
}
