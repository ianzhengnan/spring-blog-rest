package com.ian.sblog.dao;

import static com.ian.sblog.util.SBlogConstants.PICTURETABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ian.sblog.domain.Picture;

public interface PictureDao {

	@Select("select * from " + PICTURETABLE + " where article_id = #{articleId}")
	List<Picture> getPicturesByArticle(Integer articleId);
	
	@Select("select * from " + PICTURETABLE + " where user_id = #{userId}")
	List<Picture> getPictureByUser(Integer userId);
	
	@Insert("insert into " + PICTURETABLE + "(picture, thumbnail, mime_type, file_size, file_name, file_url, article_id, user_id, create_at) "
			+ "VALUES(#{picture.picture}, #{picture.thumbnail}, #{picture.mimeType}, #{picture.fileSize}, #{picture.fileName}, #{picture.fileUrl}, "
			+ "#{picture.article.id}, #{picture.user.id}, #{picture.createAt})")
	void save(Picture picture);
	
	@Delete("delete from " + PICTURETABLE + " where id = #{id}")
	void removePicture(Integer id);
}
