package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.SafeProblemForSearch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SafeProblemMapper {
    @Select("<script> select audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime from safe_problem" +
            "<where> 1=1 " +
            "<if test='stateJudgement != null and stateJudgement != \"\"'> " +
            "and state_judgement = #{stateJudgement}" +
            "</if> " +
            "<if test='problemClassification != null and problemClassification != \"\"'> " +
            "and problem_classification = #{problemClassification}" +
            "</if> " +
            "<if test='subdivisionType != null and subdivisionType != \"\"'> " +
            "and subdivision_type = #{subdivisionType}" +
            "</if> " +
            "<if test='rank != null and rank != \"\"'> " +
            "and rank = #{rank}" +
            "</if> " +
            "<if test='auditHierarchy != null and auditHierarchy != \"\"'> " +
            "and audit_hierarchy = #{auditHierarchy}" +
            "</if> " +
            "<if test='repeatQuestion != null and repeatQuestion != \"\"'> " +
            "and repeat_question = #{repeatQuestion}" +
            "</if> " +
            "<if test='completionStatus == \"完成\"'> " +
            "and completion_status in ('4/4','6/6','完成')" +
            "</if> " +
            "<if test='completionStatus == \"未完成\"'> " +
            "and completion_status not in ('4/4','6/6','完成')" +
            "</if> " +
            "<if test='startTime != null'> " +
            "and create_time >= #{startTime}" +
            "</if> " +
            "<if test='endTime != null'> " +
            "and create_time >= #{endTime}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<SafeProblem> searchByCondition(SafeProblemForSearch safeProblemForSearch);

    @Insert("<script> upload into safe_problem (problem_id,audit_aera, propose_time, problem_description, photo, state_judgement, problem_classification, subdivision_type, rank, rectification_measures, responsible_area, person_liable, completion_deadline, audit_hierarchy, repeat_question, completion_status, finish_photo, create_time,record_id) values (" +
            "#{problemId},#{auditArea},#{proposeTime},#{problemDescription},#{photo},#{stateJudgement},#{problemClassification},#{subdivisionType},#{rank},#{rectificationMeasures},#{responsibleArea},#{personLiable},#{completionDeadline},#{auditHierarchy},#{repeatQuestion},#{completionStatus},#{finishPhoto},#{createTime},#{recordId})" +
            " </script>")
    void insert(SafeProblem safeProblem);

    @Select("select audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime from safe_problem " +
            "where record_id=#{recordId}")
    List<SafeProblem> searchByRecordId(Record record);

    @Select("select responsible_area,audit_hierarchy,count(*) as number from safe_problem group by responsible_area,audit_hierarchy order by responsible_area")
    List<Map<String, Object>> searchHierarchy();

    @Select("select responsible_area,sum(case when completion_status in ('4/4','6/6','完成') then 1 else 0 end)/count(*) as complete_ratio from safe_problem group by responsible_area order by responsible_area")
    List<Map<String, Object>> searchFloorCompleteRatio();

    @Select("select problem_classification,rank,count(*) as number from safe_problem group by problem_classification,rank order by problem_classification")
    List<Map<String, Object>> searchProblemType();

    @Select("select state_judgement,count(*) as number from safe_problem group by state_judgement order by state_judgement")
    List<Map<String, Object>> searchCompanyAudit();

}

