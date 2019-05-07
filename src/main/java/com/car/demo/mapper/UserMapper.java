package com.car.demo.mapper;

import com.car.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("<script> select number,name from user where review_state='已审核'" +
//            "<if test='userId != null and userId != \"\"'> " +
//            "and user_id=#{userId}" +
//            "</if> " +
            "<if test='number != null and number != \"\"'> " +
            "and number=#{number}" +
            "</if> " +
            "<if test='name != null and name != \"\"'> " +
            "and name like '%${name}%'" +
            "</if> " +
            "</script>")
    List<User> searchNumberAndName(User user);

    @Insert("insert into user (user_id, number, name, password, superior_id, review_state, create_time, update_time) values (" +
            "#{userId},#{number},#{name},#{password},#{superiorId},#{reviewState},#{createTime},#{updateTime})")
    void insert(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where number=#{number} and password=#{password}")
    User selectByNumberAndPassword(User user);

    @Select("select count(*) from user where number=#{number}")
    Integer selectByNumber(User user);

    @Update("update user set review_state=#{reviewState} where user_id=#{userId}")
    void updateReviewState(User user);

    @Update("update user set review_state = #{reviewState},superior_id = #{superiorId} where user_id = #{userId}")
    void update(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime from user")
    List<User> selectAll();

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where user_id=#{userId}")
    User selectByUserId(User user);

    @Select("select user_id as userId from user where superior_id=#{userSuperiorId}")
    List<String> selectSonsIdBySuperiorId(@Param("userSuperiorId") String userSuperiorId);

    @Select("<script> select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime from user " +
            "<where> 1=1 " +
            "<if test='userId != null and userId != \"\"'> " +
            "and user_id = #{userId}" +
            "</if> " +
            "<if test='number != null and number != \"\"'> " +
            "and number = #{number}" +
            "</if> " +
            "<if test='name != null and name != \"\"'> " +
            "and name like '%${name}%'" +
            "</if> " +
            "<if test='reviewState != null and reviewState != \"\"'> " +
            "and review_state=#{reviewState}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<User> searchByCondition(User user);

    @Update("update user set review_state=#{reviewState} where user_id=#{userId}")
    void updateReviewStateToCancle(User user);

    @Update("update user set password=#{password} where user_id=#{userId}")
    void updatePassword(User user);
}
