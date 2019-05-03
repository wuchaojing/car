package com.car.demo.service;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;

public interface RecordService {
    ResultInfo getRelativeRecords(User user);

    ResultInfo getSafeProblemByRecordId(Record record);
}
