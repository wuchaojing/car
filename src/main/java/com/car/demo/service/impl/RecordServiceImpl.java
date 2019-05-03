package com.car.demo.service.impl;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.User;
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
    public ResultInfo getRelativeRecords(User user) {//simplify: only userId
//        user = userMapper.selectByUserId(user);//can get detail status;(avoid only userId)
//        if (user == null) {//avoid userId is not true（也保证一下吧）
//            return new ResultInfo(0, "请传入正确的userId");
//        }
        List<String> totalRelativeUserIds = getRelativeUserIds(user.getUserId(), new ArrayList<String>());
        List<Record> totalRelativeRecords = new ArrayList<>();
        List<Record> cur = null;
        for (String userId : totalRelativeUserIds) {//at least one user
            cur = recordMapper.searchRecordByUserId(userId);
            //if(cur!=null) {//maybe null// can solve null
            totalRelativeRecords.addAll(cur);
            //}
        }
        //return new ResultInfo(1, "所有的其直接或间接下属(其只有id信息)", totalRelativeUserIds);
        return new ResultInfo(1, totalRelativeRecords);
    }

    @Override
    public ResultInfo getSafeProblemByRecordId(Record record) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByRecordId(record);
        return new ResultInfo(1, safeProblems);
    }

    public List<String> getRelativeUserIds(String userSuperiorId, List<String> list) {
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
