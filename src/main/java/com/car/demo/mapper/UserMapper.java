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
    void insert(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where number=#{number} and password=#{password}")
    User selectByNumberAndPassword(User user);

    @Select("select count(*) from user where number=#{number}")
    Integer selectByNumber(User user);

    @Select("<script> select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime,update_time as updateTime from user " +
            "<where> 1=1 " +
            "<if test='userId != null'> " +
            "and user_id = #{userId}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<User> selectByCondition(User user);

    @Update("update user set review_state=#{reviewState} where user_id=#{userId}")
    void updateReviewState(User user);

    @Update("update user set review_state = #{reviewState},superior_id = #{superiorId} where user_id = #{userId}")
    void update(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime from user")
    List<User> selectAll();

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where user_id=#{userId}")
    User selectByUserId(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where superior_id=#{userId}")
    List<User> selectSonsBySuperiorId(User userSuperior);
}
