package com.ian.sblog.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ian.sblog.dao.UserDao;
import com.ian.sblog.domain.User;
import com.ian.sblog.service.UserService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
@Service
public class UserServiceImpl implements UserService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User logon(String username, String password) {
		log.debug("UserServiceImpl >> logon");
		return userDao.selectByUsernameAndPassword(username, password);
	}

	@Override
	public void register(User user) {
		userDao.save(user);
	}
	
	@Override
	public boolean checkUsername(User user) {
		User exitUser = userDao.selectByUsername(user.getUsername());
		if (exitUser != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void removeUser(Integer id) {
		userDao.deleteById(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public List<User> getUsers(Map<String, Object> params) {
		return userDao.selectByPage(params);
	}

	@Override
	public Integer count(Map<String, Object> params) {
		return userDao.count(params);
	}
	
}
