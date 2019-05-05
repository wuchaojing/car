package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.SafeProblem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SafeProblemMapper {
    @Select("<script> select problem_id as problemId,audit_aera as auditAera,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime,last_time as lastTime,record_id as recordId from safe_problem" +
            "<where> 1=1 " +
            "<if test='problemId != null'> " +
            "and problem_id = #{problemId}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<SafeProblem> searchByCondition(SafeProblem safeProblem);

    @Insert("<script> insert into safe_problem (problem_id,audit_aera, propose_time, problem_description, photo, state_judgement, problem_classification, subdivision_type, rank, rectification_measures, responsible_area, person_liable, completion_deadline, audit_hierarchy, repeat_question, completion_status, finish_photo, create_time, last_time,record_id) values (" +
            "#{problemId},#{auditAera},#{proposeTime},#{problemDescription},#{photo},#{stateJudgement},#{problemClassification},#{subdivisionType},#{rank},#{rectificationMeasures},#{responsibleArea},#{personLiable},#{completionDeadline},#{auditHierarchy},#{repeatQuestion},#{completionStatus},#{finishPhoto},#{createTime},#{lastTime},#{recordId})" +
            " </script>")
    void insert(SafeProblem safeProblem);

    @Select("select problem_id as problemId,audit_aera as auditAera,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime,last_time as lastTime,record_id as recordId from safe_problem " +
            "where record_id=#{recordId}")
    List<SafeProblem> searchByRecordId(Record record);

    @Select("select count(problem_id) from safe_problem where responsible_area=#{responsibleArea} and rank=#{rank}")
    int countRankByResponsibleArea(@Param("rank") String rank, @Param("responsibleArea")String responsibleArea);

    @Select("select count(problem_id) from safe_problem where responsible_area=#{responsibleArea} and repeat_question='是'")
    int completionStatusisRepeat(@Param("responsibleArea")String responsibleArea);

    @Select("select count(problem_id) from safe_problem where responsible_area=#{responsibleArea} and completion_status in ('4/4','6/6','完成')")
    int completionStatusIsDone(@Param("responsibleArea")String responsibleArea);

    @Select("select count(problem_id) from safe_problem where responsible_area=#{responsibleArea}")
    int completionStatusAll(@Param("responsibleArea")String responsibleArea);

}
