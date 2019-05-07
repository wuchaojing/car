package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.SafeProblem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    @Select("select responsible_area as responsibleArea,audit_hierarchy as auditHierarchy,count(*) as number from safe_problem group by responsible_area,audit_hierarchy order by responsible_area")
    List<Map<String, Object>> searchHierarchy();

    @Select("select responsible_area as responsibleArea,count(*)/(select count(*) from safe_problem) as repetitionRate from safe_problem where completion_status in ('4/4','6/6','完成') group by responsible_area order by responsible_area")
    List<Map<String, Object>> searchFloorCompleteRatio();

    @Select("select problem_classification as problemClassification,rank,count(*) as number from safe_problem group by problem_classification,rank order by problem_classification")
    List<Map<String, Object>> searchProblemType();

    @Select("select state_judgement as stateJudgement,count(*) as number from safe_problem group by state_judgement order by state_judgement")
    List<Map<String, Object>> searchCompanyAudit();

}

