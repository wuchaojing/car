package com.car.demo.mapper;

import com.car.demo.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper {
    @Insert("register into record (record_id, number, name, commit_time) values " +
            "(#{recordId},#{number},#{name},#{commitTime})")
    void insert(Record record);
}
