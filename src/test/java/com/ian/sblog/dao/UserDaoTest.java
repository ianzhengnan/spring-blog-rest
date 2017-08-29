package com.ian.sblog.dao;

import org.testng.annotations.Test;
//import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import static org.junit.Assert.*;

import com.ian.sblog.domain.User;

public class UserDaoTest extends BaseDaoTest{

	@SpringBean("userDao")
	private UserDao userDao;
	
	@Test
//	@DataSet("test.Users.xml")
	public void findUserByUsernameAndPassword() {
		User user = userDao.selectByUsernameAndPassword("tony", "tony1234");
		assertNull("不存在用户tony", user);
		
		// 创建测试数据
		user = new User();
		user.setUsername("tester");
		user.setPassword("tester1234");
		userDao.save(user);
		
		// 测试用户是否存在
		user = userDao.selectByUsernameAndPassword("tester", "tester1234");
		assertNotNull("Jan用户存在", user);
		
		// 测试新增
		User tester = new User();
		tester.setUsername("kaka");
		tester.setPassword("kaka123");
		tester.setDisplayName("flks");
		tester.setRealName("Ian zheng");
		userDao.save(tester);
		tester = userDao.selectByUsernameAndPassword("kaka", "kaka123");
		assertNotNull("kaka用户存在", tester);
		
		//测试更改
		tester.setDisplayName("zheng nan");
		userDao.updateUser(tester);
		tester = userDao.selectById(tester.getId());
		assertNotEquals("flks", tester.getDisplayName());
		
		//测试删除
		userDao.deleteById(tester.getId());
		tester = userDao.selectByUsernameAndPassword("kaka", "kaka123");
		assertNull("kaka用户不存在", tester);
		
		//删除测试数据
		userDao.deleteById(user.getId());
	}
	
	
	
}
