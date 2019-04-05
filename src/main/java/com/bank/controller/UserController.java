package com.bank.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bean.User;
import com.bank.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/getUserById", method = { RequestMethod.POST, RequestMethod.GET })
	public User getUser(@RequestParam(value = "id") String id){
		int idi=Integer.valueOf(id);
		User user=userService.getUserById(idi);
		System.out.println(user.getName()+" -----------");
		return user;
	}

}
