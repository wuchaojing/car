package com.car.demo.mapper;

import com.car.demo.entity.SafeProblem;
import org.apache.ibatis.annotations.*;

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
    @Insert("<script> insert into safe_problem (audit_aera, propose_time, problem_description, photo, state_judgement, problem_classification, subdivision_type, rank, rectification_measures, responsible_area, person_liable, completion_deadline, audit_hierarchy, repeat_question, completion_status, finish_photo,submit_person, create_time, last_time) values (" +
            "#{auditAera},#{proposeTime},#{problemDescription},#{photo},#{stateJudgement},#{problemClassification},#{subdivisionType},#{rank},#{rectificationMeasures},#{responsibleArea},#{personLiable},#{completionDeadline},#{auditHierarchy},#{repeatQuestion},#{completionStatus},#{finishPhoto},#{submitPerson},#{createTime},#{lastTime})" +
            " </script>")
    public Integer insert(SafeProblem safeProblem);

}
