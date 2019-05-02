package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert("insert into record (record_id, number, name, commit_time) values " +
            "(#{recordId},#{number},#{name},#{commitTime})")
    void insert(Record record);

    @Select("select record_id as recordId,number,name,commit_time as commitTime from record where number=#{number}")
    List<Record> searchRecordByUserNumber(User user);
}
