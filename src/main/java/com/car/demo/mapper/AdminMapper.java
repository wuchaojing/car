package com.car.demo.mapper;

import com.car.demo.entity.AdminData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select id,name from audit_hierarchy")
    List<AdminData> searchAuditHierarchy();

    @Insert("insert into audit_hierarchy values(#{id},#{name})")
    void insertAuditHierarchy(@Param("id") String auditHierarchyId, @Param("name") String auditHierarchyName);

    @Update("update audit_hierarchy set name=#{name} where id=#{id}")
    void updateAuditHierarchy(@Param("id") String auditHierarchyId, @Param("name") String auditHierarchyName);

    @Delete("delete from audit_hierarchy where id=#{id}")
    void deleteAuditHierarchy(@Param("id") String auditHierarchyId);
    //==================================================================1

    @Select("select id,name from completion_status")
    List<AdminData> searchCompletionStatus();

    @Insert("insert into completion_status values(#{id},#{name})")
    void insertCompletionStatus(@Param("id") String completionStatusId, @Param("name") String completionStatusName);

    @Update("update completion_status set name=#{name} where id=#{id}")
    void updateCompletionStatus(@Param("id") String completionStatusId, @Param("name") String completionStatusName);

    @Delete("delete from completion_status where id=#{id}")
    void deleteCompletionStatus(@Param("id") String completionStatusId);
    //==================================================================2

    @Select("select id,name from problem_classification")
    List<AdminData> searchProblemClassification();

    @Insert("insert into problem_classification values(#{id},#{name})")
    void insertProblemClassification(@Param("id") String problemClassificationId, @Param("name") String problemClassificationName);

    @Update("update problem_classification set name=#{name} where id=#{id}")
    void updateProblemClassification(@Param("id") String problemClassificationId, @Param("name") String problemClassificationName);

    @Delete("delete from problem_classification where id=#{id}")
    void deleteProblemClassification(@Param("id") String problemClassificationId);
    //==================================================================3

    @Select("select id,name from rank")
    List<AdminData> searchRank();

    @Insert("insert into rank values(#{id},#{name})")
    void insertRank(@Param("id") String rankId, @Param("name") String rankName);

    @Update("update rank set name=#{name} where id=#{id}")
    void updateRank(@Param("id") String rankId, @Param("name") String rankName);

    @Delete("delete from rank where id=#{id}")
    void deleteRank(@Param("id") String rankId);
    //==================================================================4

    @Select("select id,name from state_judgement")
    List<AdminData> searchStateJudgement();

    @Insert("insert into state_judgement values(#{id},#{name})")
    void insertStateJudgement(@Param("id") String stateJudgementId, @Param("name") String stateJudgementName);

    @Update("update state_judgement set name=#{name} where id=#{id}")
    void updateStateJudgement(@Param("id") String stateJudgementId, @Param("name") String stateJudgementName);

    @Delete("delete from state_judgement where id=#{id}")
    void deleteStateJudgement(@Param("id") String stateJudgementId);
    //==================================================================5

    @Select("select id,name from subdivision_type where pc_id=#{pId}")
    List<AdminData> searchSubdivisionType(@Param("pId") String problemClassificationId);

    @Insert("insert into subdivision_type values (#{id},#{name},#{pId})")
    void insertSubdivisionType(@Param("id") String subdivisionTypeId, @Param("name") String subdivisionTypeName,@Param("pId") String problemClassificationId);

    @Update("update subdivision_type set name=#{name} where id=#{id}")
    void updateSubdivisionType(@Param("id") String subdivisionTypeId, @Param("name") String subdivisionTypeName);

    @Delete("delete from subdivision_type where id=#{id}")
    void deleteSubdivisionType(@Param("id") String subdivisionTypeId);

    @Delete("delete from subdivision_type where pc_id=#{pId}")
    void deleteSubdivisionTypesByProblemClassificationId(@Param("pId") String problemClassificationId);
    //==================================================================5
}
