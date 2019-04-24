package com.car.demo.dao;

import com.car.demo.entity.User;

import java.util.List;

public interface UserDao {
	public List<User> selectAll();
}
