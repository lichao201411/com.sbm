package com.shrio.service.impl;

import org.springframework.stereotype.Service;

import com.shrio.bean.UserInfo;
import com.shrio.service.UserInfoService;
@Service
public class UserInfoServiceImp implements UserInfoService {

	@Override
	public UserInfo getUserByName(String name) {
		// TODO Auto-generated method stub
		//此处省略获取
		UserInfo uInfo=new UserInfo();
		uInfo.setUsername("lc");
		
		return null;
	}

}
