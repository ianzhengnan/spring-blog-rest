package com.ian.sblog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ian.sblog.domain.Category;
import static com.ian.sblog.util.SBlogConstants.*;

import java.util.List;

public interface CategoryDao {

	@Select("select * from " + CATEGORYTABLE + " where id = #{id}")
	Category getCategoryById(Integer id);
	
	@Select("select * from " + CATEGORYTABLE + " where user_id = #{userId}")
	List<Category> getCategoriesByUserId(Integer userId);
	
	@Insert("insert into " + CATEGORYTABLE + "(title, description, visiable, user_id, create_at) values(#{title},"
			+ " #{description}, #{visiable}, #{createBy.id}, #{createAt})")
	void save(Category category);
	
	@Update("update " + CATEGORYTABLE + " SET title = #{category.title}, description = #{category.description}, visiable = #{category.visiable}"
			+ ", user_id = #{category.createBy.id} where id = #{category.id}")
	void updateCategory(Category category);
	
	@Delete("delete from " + CATEGORYTABLE + " where id = #{id}")
	void remove(Integer id);

	@Select("select count(*) from " + ARTICLETABLE + " where category_id = #{id}")
	Integer containArticleNumber(Integer categoryId);
}
