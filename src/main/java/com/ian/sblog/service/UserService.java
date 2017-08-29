package com.ian.sblog.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ian.sblog.domain.User;

public interface UserService {

	User logon(@Param("username") String username, @Param("password") String password);
	
	void register(User user);
	
	public boolean checkUsername(User user);
	
	void removeUser(Integer id);
	
	void updateUser(User user);
	
	List<User> getUsers(Map<String, Object> params);
	
	Integer count(Map<String, Object> params);
}
