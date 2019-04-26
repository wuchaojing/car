package com.car.demo.mapper;

import com.car.demo.entity.SafeProblem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SafeProblemMapper {
    @Select("<script> select id,audit_aera as auditAera,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,submit_person as submitPerson,create_time as createTime,last_time as lastTime from safe_problem" +
            "<where> 1=1 " +
            "<if test='id != null'> " +
            "and id = #{id}" +
            "</if> " +
            "</where>" +
            "</script>")
     List<SafeProblem> searchByCondition(SafeProblem safeProblem) ;
}
