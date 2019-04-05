package com.bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bank.bean.User;
@Mapper
public interface UserMapper{
	 List<User> getAll();
	 User getOne(int id);
	    void insert(User user);
	    void update(User user);
	    void delete(Long id);
}
