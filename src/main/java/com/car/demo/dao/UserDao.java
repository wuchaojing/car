package com.car.demo.dao;

import com.car.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

	@Select("select * from user")
	List<User> selectAll();
}
