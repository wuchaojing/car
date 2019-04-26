package com.car.demo.dao;

import com.car.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("<script> select * from user " +
            "<where> 1=1 " +
            "<if test='username != null'> " +
            "and username = #{username}</if> " +
            "<if test='password != null'> " +
            "and password = #{password}</if> " +
            "</where>" +
            "</script>")
    List<User> selectAll(User user);
}
