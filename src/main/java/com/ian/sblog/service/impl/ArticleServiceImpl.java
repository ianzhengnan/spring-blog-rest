package com.ian.sblog.service.impl;

import java.util.List;
import java.util.Map;

import com.ian.sblog.domain.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		return articleDao.selectById(id);
	}

    @Override
    public Integer getArticleNumber(Map<String, Object> params) {
        return articleDao.count(params);
    }

}
