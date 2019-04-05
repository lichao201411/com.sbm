package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.bank.bean.User;
import com.bank.dao.UserMapper;
import com.bank.service.UserService;
@ComponentScan({"com.bank.dao"})
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userDao;
	@Override
	@Cacheable(value = "all", keyGenerator = "wiselyKeyGenerator")
	public User getUserById(int id) {
		System.out.println("查询数据库-------->");
		return userDao.getOne(id);
	}

}
