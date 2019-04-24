package com.car.demo.service.impl;

import com.car.demo.dao.UserDao;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public List<User> searchAll() {
		return userDao.selectAll();
	}
	
}
