package com.ian.sblog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ian.sblog.dao.provider.UserDynaSqlProvider;
import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.User;
import static com.ian.sblog.util.SBlogConstants.*;

import java.util.List;
import java.util.Map;

public interface UserDao {

	/**
	 * Get user by username and password
	 * @param username
	 * @param password
	 * @return
	 */
	@Select("select * from " + USERTABLE + " where username = #{username} and password = #{password}")
	User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	/**
	 * Get user by username
	 * @param username
	 * @return
	 */
	@Select("select * from " + USERTABLE + " where username = #{username}")
	User selectByUsername(@Param("username") String username);
	
	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	@Select("select * from " + USERTABLE + " where id = #{id}")
	User selectById(Integer id);
	
	/**
	 * Delete user by id
	 * @param id
	 */
	@Delete("delete from " + USERTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	// Dynamic operations
	/**
	 * Dynamic update user
	 * @param user
	 */
	@UpdateProvider(type = UserDynaSqlProvider.class, method = "updateUser")
//	@Update("update ")
	void updateUser(User user);
	
	/**
	 * Dynamic query users
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
	List<User> selectByPage(Map<String, Object> params);
	
	/**
	 * Dynamic get user count
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
	
	/**
	 * Dynamic insert user
	 * @param user
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "insertUser")
	void save(User user);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select art.* from +" + ARTICLETABLE + " as art, " + STAREDARTICLETABLE + " as stared "
			+ "where art.id = stared.article_id and stared.user_id = #{userId}")
	List<Article> getStaredArticle(Integer userId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select users.* from " + USERTABLE + " as users, " + FOLLOWTABLE + " as follows "
			+ "where users.id = follows.follower_id and follows.user_id = #{id}")
	List<User> getFollowers(Integer id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("select users.* from " + USERTABLE + " as users, " + FOLLOWTABLE + " as follows "
			+ "where users.id = follows.user_id and follows.follower_id = #{id}")
	List<User> getFollowings(Integer id);
	
	/**
	 * follow someone with id #{id}
	 * @param id
	 * @param follower_id
	 */
	@Insert("insert into " + FOLLOWTABLE + "(user_id, follower_id) values(#{id}, #{followerId}) ")
	void follow(Integer id, Integer followerId);
	
	@Delete("delete from " + FOLLOWTABLE + " where user_id = #{id} and follower_id = #{followerId)")
	void unFollow(Integer id, Integer followerId);
	
}
