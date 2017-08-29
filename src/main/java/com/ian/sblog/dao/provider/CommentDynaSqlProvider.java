package com.ian.sblog.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.ian.sblog.domain.Comment;

import static com.ian.sblog.util.SBlogConstants.*;

public class CommentDynaSqlProvider {

	public String selectWithParams(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(COMMENTTABLE);
				if(params.get("comment") != null) {
					Comment comment = (Comment)params.get("comment");
					if (comment.getArticle() != null) {
						WHERE(" article_id = #{comment.article.id}");
					}
				}
				ORDER_BY("create_at desc");
			}
		}.toString();
		
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		
		return sql;
	}
	
	public String update(Comment comment) {
		String sql = new SQL() {
			{
				UPDATE(COMMENTTABLE);
				if (comment.getContent() != null && !comment.getContent().equals("")) {
					SET("content = #{content}");
				}
				if (comment.getArticle() != null){
					SET("article_id = #{article.id}");
				}
				if (comment.getCreateBy() != null){
					SET("user_id = #{createBy.id}");
				}
				if (comment.getLastModifyAt() != null){
					SET("last_modify_at = #{lastModifyAt}");
				}
				if (comment.getReplyComment() != null)	{
					SET("reply_comment_id = #{replyComment.id}");
				}
				if (comment.getCreateAt() != null){
					SET("create_at = #{createAt}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
		return sql;
	}
	
	public String save(Comment comment) {
		String sql = new SQL() {
			{
				INSERT_INTO(COMMENTTABLE);
				if (comment.getContent() != null && !comment.getContent().equals("")) {
					VALUES("content", "#{content}");
				}
				if (comment.getArticle() != null){
					VALUES("article_id", "#{article.id}");
				}
				if (comment.getCreateBy() != null){
					VALUES("user_id", "#{createBy.id}");
				}
				if (comment.getLastModifyAt() != null){
					VALUES("last_modify_at", "#{lastModifyAt}");
				}
				if (comment.getReplyComment() != null)	{
					VALUES("reply_comment_id", "#{replyComment.id}");
				}
				if (comment.getCreateAt() != null){
					VALUES("create_at", "#{createAt}");
				}
			}
		}.toString();
		return sql;
	}
}
