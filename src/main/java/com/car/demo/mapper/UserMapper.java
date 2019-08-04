package com.car.demo.mapper;

import com.car.demo.entity.Integration;
import com.car.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("<script> select user_id as userId,number,name,level,detail from user where review_state='已审核' and number not in('admin','audit')" +
            "<if test='name != null and name != \"\"'> " +
            "and name like '%${name}%'" +
            "</if> " +
            "</script>")
    List<User> searchNumberAndName(User user);

    @Insert("insert into user (user_id, number, name, password, superior_id, review_state, create_time, update_time, level, detail) values (" +
            "#{userId},#{number},#{name},#{password},#{superiorId},#{reviewState},#{createTime},#{updateTime},#{level},#{detail})")
    void insert(User user);

    @Select("select user_id as userId,number,name,superior_id as superiorId,review_state as reviewState,level,detail from user where number=#{number} and password=#{password} and review_state!='已注销'")
    User selectByNumberAndPassword(User user);

    @Select("select count(user_id) from user where number=#{number} and password=#{password} and review_state!='已注销'")
    Integer selectCountByNumberAndPassword(User user);

    @Select("select count(*) from user where number=#{number} and review_state!='已注销'")
    Integer selectByNumber(User user);

    @Update("update user set review_state=#{reviewState},update_time=#{updateTime} where user_id=#{userId}")
    void updateReviewState(User user);

    @Update("update user set detail = #{detail},update_time=#{updateTime},superior_id=#{superiorId} where user_id = #{userId}")
    void update(User user);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,create_time as createTime,level,detail from user where review_state!='已注销' and user_id !='admin'")
    List<User> selectAll();

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState from user where user_id=#{userId} and review_state!='已注销'")
    User selectByUserId(User user);

    @Select("select user_id as userId from user where superior_id=#{userSuperiorId} and review_state!='已注销'")
    List<String> selectSonsIdBySuperiorId(@Param("userSuperiorId") String userSuperiorId);

    @Select("select user_id as userId,number,name,password,superior_id as superiorId,review_state as reviewState,level,detail from user where superior_id=#{userSuperiorId} and review_state!='已注销'")
    List<User> selectSonsBySuperiorId(@Param("userSuperiorId") String userSuperiorId);

    @Select("<script> select * from retailer " +
            "<where> 1=1 " +
            "<if test='number != null and number != \"\"'> " +
            "and number = #{number}" +
            "</if> " +
            "<if test='name != null and name != \"\"'> " +
            "and name like '%${name}%'" +
            "</if> " +
            " and review_state!='已注销'" +
            "</where>" +
            "</script>")
    List<User> searchByCondition(User user);//没用到

    @Update("update user set review_state=#{reviewState},update_time=#{updateTime} where user_id=#{userId}")
    void update2Delete(User user);

    @Update("update user set password=#{password},update_time=#{updateTime} where user_id=#{userId}")
    void updatePassword(User user);

    @Select("select user_id as userId,number,name from user where review_state='已审核' and level in (${pinjie})")
    List<User> searchUpperClass(@Param("pinjie") String pinjie);

    @Insert("insert into integration values (#{id},#{name},#{reason},#{mark},#{userId},#{markId})")
    void mark(Integration integration);

    @Select("select user_id as userId,number,name from user where review_state='已审核' and superior_id=#{userId}")
    List<User> getDirectSons(@Param("userId") String userId);

    @Select("<script> (select id,name,reason,mark,user_id as userId from integration where user_id=#{userId} ) union (select id,name,reason,mark,user_id as userId from integration where mark_id=#{userId} ) </script>")
    List<Integration> getSelfAndSonsMark(@Param("userId") String userId);

    @Select("<script> (select name,sum(mark) as mark,user_id as userId from integration where user_id=#{userId}  group by user_id) union (select name,sum(mark) as mark,user_id as userId from integration where mark_id=#{userId}  group by user_id) </script>")
    List<Integration> getSelfAndSonsMarkSum(@Param("userId") String userId);//总分不用查id了

    @Delete("delete from integration where id=#{id}")
    void deleteMark(@Param("id") String markId);
}
