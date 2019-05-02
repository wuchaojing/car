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
    RecordMapper recordMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    SafeProblemMapper safeProblemMapper;

    @Override
    public ResultInfo getRelativeRecords(User user) {
        user = userMapper.selectByUserId(user);//can get detail status;(avoid only userId)
        if (user == null) {//avoid userId is not true
            return new ResultInfo(0, "请传入正确的userId");
        }
        List<User> totalRelativeUsers = getRelativeUsers(user, new ArrayList<User>());
        List<Record> totalRelativeRecords = new ArrayList<>();
        List<Record> cur = null;
        for (User u : totalRelativeUsers) {//at least one user
            cur = recordMapper.searchRecordByUserNumber(u);
            //if(cur!=null) {//maybe null// can solve null
            totalRelativeRecords.addAll(cur);
            //}
        }
        //return new ResultInfo(1, "所有的其直接或间接下属(其只有id信息)", totalRelativeUsers);
        return new ResultInfo(1, "所有的其以及其直接或间接下属的Records", totalRelativeRecords);
    }

    @Override
    public ResultInfo getSafeProblemByRecordId(Record record) {
        List<SafeProblem> safeProblems= safeProblemMapper.searchByRecordId(record);
        return new ResultInfo(1,"根据recordId查出的数据",safeProblems);
    }

    public List<User> getRelativeUsers(User userSuperior, List<User> list) {
        if (userSuperior == null) {//end: is null
            return null;
        }
        list.add(userSuperior);//add this
        List<User> cur = userMapper.selectBySuperiorId(userSuperior);
        for (User user : cur) {
            getRelativeUsers(user, list);//into his every son
        }
        return list;
    }

}
