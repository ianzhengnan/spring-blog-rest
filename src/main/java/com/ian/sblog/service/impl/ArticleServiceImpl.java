package com.ian.sblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ian.sblog.domain.Comment;
import com.ian.sblog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ian.sblog.dao.ArticleDao;
import com.ian.sblog.domain.Article;
import com.ian.sblog.service.ArticleService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
@Service
public class ArticleServiceImpl implements ArticleService{

	private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

	private ArticleDao articleDao;

	@Autowired
	private CommentService commentService;

	@Autowired //尽量在方法而不是在属性上自动绑定，这样做更加面向对象，而且更利于做单元测试
	public void setArticleDao(ArticleDao articleDao){
		this.articleDao = articleDao;
	}
	
	@Override
	public void createArticle(Article article) {
		log.debug("ArticleServiceImpl >> create an article");
		articleDao.save(article);
		Integer id = articleDao.getLastInsertArticleID(article.getCreateBy().getId());
		article.setId(id);
	}

	@Override
	public void removeArticle(Integer id) {
		articleDao.deleteById(id);
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Override
	public List<Article> getArticles(Map<String, Object> params) {
		return articleDao.selectByParams(params);
	}
	
	@Override
	public Article getArticleById(Integer id) {
		Article article = articleDao.selectById(id);
		Comment comment = new Comment();
		comment.setArticle(article);
		Map<String, Object> params = new HashMap<>();
		params.put("comment", comment);
		List<Comment> comments = commentService.getComments(params);
		article.setComments(comments);
		return article;
	}

    @Override
    public Integer getArticleNumber(Map<String, Object> params) {
        return articleDao.count(params);
    }

}
