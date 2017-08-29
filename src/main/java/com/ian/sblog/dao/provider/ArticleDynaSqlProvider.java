package com.ian.sblog.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ian.sblog.domain.Article;

import static com.ian.sblog.util.SBlogConstants.ARTICLETABLE;

public class ArticleDynaSqlProvider {

	public String selectWithParams(Map<String, Object> params) {
		
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(ARTICLETABLE);
				if(params.get("article") != null) {
					Article article = (Article)params.get("article");
					if (article.getSubject() != null && !article.getSubject().equals("") ) {
						WHERE(" subject like CONCAT('%', #{article.subject}, '%')");
					}
					if (article.getCategory() != null) {
						WHERE(" category_id = #{article.category.id}");
					}
					if(article.getStatus() != null && !article.getStatus().equals("")) {
						WHERE(" status = #{article.status}");
					}
					if(article.getCreateBy() != null) {
						WHERE(" user_id = #{article.createBy.id}");
					}
				}
			}
		}.toString();
		
		sql += " order by top desc, last_modify_at desc";
			
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		
		return sql;
	}
	
	public String updateArticle(Article article) {
		String sql = new SQL() {
			{
				UPDATE(ARTICLETABLE);
				if (article.getSubject() != null && !article.getSubject().equals("")) {
					SET(" subject = #{subject}");
				}
				if (article.getContent() != null && !article.getContent().equals("")) {
					SET(" content = #{content}");
				}
				if (article.getCategory() != null){
					SET(" category_id = #{category.id}");
				}
				if (article.getCreateBy() != null) {
					SET(" user_id = #{createBy.id}");
				}
				if (article.getTop() != null) {
					SET(" top = #{top}");
				}
				if (article.getVisitCount() != null && !article.getVisitCount().equals(0)) {
					SET(" visit_count = #{visitCount}");
				}
				if (article.getCommentCount() != null && !article.getCommentCount().equals(0)) {
					SET(" comment_count = #{commentCount}");
				}
				if (article.getShareCount() != null && !article.getShareCount().equals(0)) {
					SET(" shared_count = #{sharedCount}");
				}
				if (article.getStarCount() != null && !article.getStarCount().equals(0)) {
					SET(" stared_count = #{sharCount}");
				}
				if (article.getStatus() != null && !article.getStatus().equals("")) {
					SET(" status = #{status}");
				}
				if (article.getLastModifyAt() != null) {
					SET(" last_modify_at = #{lastModifyAt}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
		return sql;
	}
	
	public String save(Article article) {
		String sql = new SQL() {
			{
				INSERT_INTO(ARTICLETABLE);
				if (article.getSubject() != null && !article.getSubject().equals("")) {
					VALUES(" subject", "#{subject}");
				}
				if (article.getContent() != null && !article.getContent().equals("")) {
					VALUES(" content", "#{content}");
				}
				if (article.getCategory() != null){
					VALUES(" category_id", "#{category.id}");
				}
				if (article.getTop() != null){
					VALUES(" top", "#{top}");
				}
				if (article.getCreateBy() != null) {
					VALUES(" user_id", "#{createBy.id}");
				}
				if (article.getVisitCount() != null && !article.getVisitCount().equals(0)) {
					VALUES(" visit_count", "#{visitCount}");
				}
				if (article.getCommentCount() != null && !article.getCommentCount().equals(0)) {
					VALUES(" comment_count", "#{commentCount}");
				}
				if (article.getShareCount() != null && !article.getShareCount().equals(0)) {
					VALUES(" shared_count", "#{sharedCount}");
				}
				if (article.getStarCount() != null && !article.getStarCount().equals(0)) {
					VALUES(" stared_count", "#{sharCount}");
				}
				if (article.getStatus() != null && !article.getStatus().equals("")) {
					VALUES(" status", "#{status}");
				}
				if (article.getLastModifyAt() != null) {
					VALUES(" last_modify_at", "#{lastModifyAt}");
				}
			}
		}.toString();
		return sql;
	}

	public String count(Map<String, Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(ARTICLETABLE);
				if(params.get("article") != null) {
					Article article = (Article)params.get("article");
					if (article.getSubject() != null && !article.getSubject().equals("") ) {
						WHERE(" subject like CONCAT('%', #{article.subject}, '%')");
					}
					if (article.getCategory() != null) {
						WHERE(" category_id = #{article.category.id}");
					}
					if(article.getStatus() != null && !article.getStatus().equals("")) {
						WHERE(" status = #{article.status}");
					}
					if(article.getCreateBy() != null) {
						WHERE(" user_id = #{article.createBy.id}");
					}
				}
			}
		}.toString();
		return sql;
	}


}
