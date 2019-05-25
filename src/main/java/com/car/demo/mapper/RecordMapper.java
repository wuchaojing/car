package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("insert into record (record_id, number, name, commit_time,user_id) values " +
            "(#{recordId},#{number},#{name},#{commitTime},#{userId})")
    void insert(Record record);

    @Select("select record_id as recordId,number,name,commit_time as commitTime from record where number=#{number}")
    List<Record> searchRecordByUserNumber(User user);

    @Select("select record_id as recordId,number,name,commit_time as commitTime from record where user_id=#{userId} order by commit_time desc")
    List<Record> searchRecordByUserId(@Param("userId") String userId);
}
