package com.ian.sblog.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Comment;
import org.apache.poi.ss.formula.functions.T;

public interface ArticleService {

	void createArticle(Article article);
	
	void removeArticle(Integer id);
	
	void updateArticle(Article article);
	
	/**
	 * 根据参数查询文章，支持分页
	 * @param params
	 * @return
	 */
	List<Article> getArticles(Map<String, Object> params);
	
	Article getArticleById(Integer id);

	Integer getArticleNumber(Map<String, Object> params);

}
