package com.car.demo.mapper;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.SafeProblemForSearch;
import org.apache.ibatis.annotations.*;

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
            "and completion_status in ( select name from completion_status )" +
            "</if> " +
            "<if test='completionStatus == \"未完成\"'> " +
            "and completion_status not  in ( select name from completion_status )" +
            "</if> " +
            "<if test='startTime != null'> " +
            "and propose_time >= #{startTime}" +
            "</if> " +
            "<if test='endTime != null'> " +
            "and propose_time <![CDATA[<]]> #{endTime}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<SafeProblem> searchByCondition(SafeProblemForSearch safeProblemForSearch);

    @Select("<script> select audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime from safe_problem" +
            "<where> 1=1 " +
            "<if test='startTime != null'> " +
            "and propose_time >= #{startTime}" +
            "</if> " +
            "<if test='endTime != null'> " +
            "and propose_time <![CDATA[<]]> #{endTime}" +
            "</if> " +
            "</where>" +
            "</script>")
    List<SafeProblem> searchByThisMonth(SafeProblemForSearch safeProblemForSearch);

    @Insert("<script> insert into safe_problem (problem_id,audit_area, propose_time, problem_description, photo, state_judgement, problem_classification, subdivision_type, rank, rectification_measures, responsible_area, person_liable, completion_deadline, audit_hierarchy, repeat_question, completion_status, finish_photo, create_time, record_id) values (" +
            "#{problemId},#{auditArea},#{proposeTime},#{problemDescription},#{photo},#{stateJudgement},#{problemClassification},#{subdivisionType},#{rank},#{rectificationMeasures},#{responsibleArea},#{personLiable},#{completionDeadline},#{auditHierarchy},#{repeatQuestion},#{completionStatus},#{finishPhoto},#{createTime},#{recordId})" +
            " </script>")
    void insert(SafeProblem safeProblem);


    @Select("select problem_id as problemId, audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime from safe_problem " +
            "where record_id in (${recordIds})")
    List<SafeProblem> searchByRecordIds(@Param("recordIds") String recordIds);

    @Select("<script> select problem_id as problemId, audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,create_time as createTime from safe_problem " +
            "<where> record_id in (${recordIds}) " +
            "<if test='s.stateJudgement != null and s.stateJudgement != \"\"'> " +
            "and state_judgement = #{s.stateJudgement}" +
            "</if> " +
            "<if test='s.problemClassification != null and s.problemClassification != \"\"'> " +
            "and problem_classification = #{s.problemClassification}" +
            "</if> " +
            "<if test='s.subdivisionType != null and s.subdivisionType != \"\"'> " +
            "and subdivision_type = #{s.subdivisionType}" +
            "</if> " +
            "<if test='s.rank != null and s.rank != \"\"'> " +
            "and rank = #{s.rank}" +
            "</if> " +
            "<if test='s.auditHierarchy != null and s.auditHierarchy != \"\"'> " +
            "and audit_hierarchy = #{s.auditHierarchy}" +
            "</if> " +
            "<if test='s.repeatQuestion != null and s.repeatQuestion != \"\"'> " +
            "and repeat_question = #{s.repeatQuestion}" +
            "</if> " +
            "<if test='s.completionStatus == \"完成\"'> " +
            "and completion_status in ( select name from completion_status )" +
            "</if> " +
            "<if test='s.completionStatus == \"未完成\"'> " +
            "and completion_status not in ( select name from completion_status )" +
            "</if> " +
            "<if test='s.startTime != null'> " +
            "and propose_time >= #{s.startTime}" +
            "</if> " +
            "<if test='s.endTime != null'> " +
            "and propose_time <![CDATA[<]]> #{s.endTime}" +
            "</if> " +
            "</where>" +
            "</script> ")
    List<SafeProblem> searchByRecordIdsAndCondition(@Param("recordIds") String recordIds, @Param("s") SafeProblemForSearch safeProblemForSearch);

    @Select("select responsible_area,audit_hierarchy,count(*) as number from safe_problem group by responsible_area,audit_hierarchy order by responsible_area")
    List<Map<String, Object>> searchHierarchy();

    @Select("select responsible_area,sum(case when completion_status  in ( select name from completion_status ) then 1 else 0 end)/count(*) as complete_ratio from safe_problem group by responsible_area order by responsible_area")
    List<Map<String, Object>> searchFloorCompleteRatio();

    @Select("select problem_classification,rank,count(*) as number from safe_problem group by problem_classification,rank order by problem_classification")
    List<Map<String, Object>> searchProblemType();

    @Select("select state_judgement,count(*) as number from safe_problem group by state_judgement order by state_judgement")
    List<Map<String, Object>> searchCompanyAudit();

    @Update("update safe_problem " +
            "set audit_area=#{auditArea},propose_time=#{proposeTime},problem_description=#{problemDescription},state_judgement=#{stateJudgement},problem_classification=#{problemClassification},subdivision_type=#{subdivisionType},rank=#{rank},rectification_measures=#{rectificationMeasures},responsible_area=#{responsibleArea},person_liable=#{personLiable},completion_deadline=#{completionDeadline},audit_hierarchy=#{auditHierarchy},repeat_question=#{repeatQuestion},completion_status=#{completionStatus} " +
            "where problem_id=#{problemId}")
    void update(SafeProblem safeProblem);

    @Select("select problem_id as problemId,audit_area as auditArea,propose_time as proposeTime,problem_description as problemDescription,photo,state_judgement as stateJudgement,problem_classification as problemClassification,subdivision_type as subdivisionType,rank,rectification_measures as rectificationMeasures,responsible_area as responsibleArea,person_liable as personLiable,completion_deadline as completionDeadline,audit_hierarchy as auditHierarchy,repeat_question as repeatQuestion,completion_status as completionStatus,finish_photo as finishPhoto,create_time as createTime from safe_problem " +
            "where problem_id=#{problemId}")
    SafeProblem searchById(@Param("problemId") String problemId);

    @Select("<script> select responsible_area,rank,count(*) as number from safe_problem where audit_hierarchy='公司级'  and propose_time <![CDATA[<]]> #{endTime} and propose_time >= #{startTime} group by responsible_area,rank order by responsible_area </script> ")
    List<Map<String, Object>> searchCompanyAuditByMonth(SafeProblemForSearch safeProblemForSearch);

    @Select("<script> select responsible_area,rank,count(*) as number from safe_problem  where propose_time <![CDATA[<]]> #{endTime} and propose_time >= #{startTime} group by responsible_area,rank order by responsible_area </script> ")
    List<Map<String, Object>> searchAuditByMonth(SafeProblemForSearch safeProblemForSearch);

    @Select("<script> select problem_classification,count(problem_id)/(select count(*) from safe_problem where audit_hierarchy='公司级' and propose_time <![CDATA[<]]> #{endTime} and propose_time >= #{startTime}) as complete_ratio from safe_problem where audit_hierarchy='公司级'  and propose_time <![CDATA[<]]> #{endTime}  and  propose_time >= #{startTime} group by problem_classification order by problem_classification  </script> ")
    List<Map<String, Object>> searchCompanyProblemTypeByMonth(SafeProblemForSearch safeProblemForSearch);
}

