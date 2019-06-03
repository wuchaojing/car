package com.car.demo.service.impl;

import com.car.demo.entity.*;
import com.car.demo.mapper.RecordMapper;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.mapper.UserMapper;
import com.car.demo.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SafeProblemMapper safeProblemMapper;

    @Override
    public ResultInfo getRelativeRecords(User user) {

        List<String> totalRelativeUserIds = getRelativeUserIds(user.getUserId(), new ArrayList<>());
        List<Record> totalRelativeRecords = new ArrayList<>();
        List<Record> cur = null;
        for (String userId : totalRelativeUserIds) {
            cur = recordMapper.searchRecordByUserId(userId);
            totalRelativeRecords.addAll(cur);
        }
        return new ResultInfo(1, totalRelativeRecords);
    }

    @Override
    public ResultInfo getSafeProblemByRecordId(Record record) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByRecordId(record);
        return new ResultInfo(1, safeProblems);
    }

    public ResultInfo getSafeProblemByRecordIds(String recordIds) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByRecordIds(recordIds);
        return new ResultInfo(1, safeProblems);
    }

    public ResultInfo getSafeProblemByRecordIdsAndCondition(String recordIds, SafeProblemForSearch safeProblemForSearch) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByRecordIdsAndCondition(recordIds, safeProblemForSearch);
        return new ResultInfo(1, safeProblems);
    }

    private List<String> getRelativeUserIds(String userSuperiorId, List<String> list) {
        System.out.println("-----------");
        if (userSuperiorId == null) {//end: is null
            return null;
        }
        list.add(userSuperiorId);//add this
        List<String> curs = userMapper.selectSonsIdBySuperiorId(userSuperiorId);
        for (String userId : curs) {
            getRelativeUserIds(userId, list);//into his every son
        }
        return list;
    }
}
