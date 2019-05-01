package com.car.demo.mapper;

import com.car.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (user_id, number, name, password, superior_id, review_state, create_time, update_time) values (" +
            "#{userId},#{number},#{name},#{password},#{superiorId},#{reviewState},#{createTime},#{updateTime})")
    Integer insert(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime,update_time as updateTime from user where number=#{number} and password=#{password}")
    User select(User user);

    @Select("select count(*) from user where number=#{number}")
    Integer selectByName(User user);

    @Select("<script> select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime,update_time as updateTime from user " +
            "<where> 1=1 " +
            "<if test='userId != null'> " +
            "and user_id = #{userId}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<User> selectByCondition(User user);

    @Update("<script>" +
            "update user" +
            "<set>" +
            "<if test='reviewState != null' >" +
            "review_state=#{reviewState}" +
            "</if>" +
            "</set>" +
            "<where>" +
            "user_id=#{userId}" +
            "</where>" +
            "</script>")
    Integer updateSelective(User user);
}
