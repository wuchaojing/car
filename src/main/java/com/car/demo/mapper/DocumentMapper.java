package com.car.demo.mapper;

import com.car.demo.entity.CategoryInfo;
import com.car.demo.entity.DocumentInfo;
import com.car.demo.entity.SecondCategoryInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DocumentMapper {

    @Insert("insert into document(doc_id,doc_new_name,doc_origin_name,happen_time,second_category_id,user_id,create_time) values(" +
            "#{docId},#{docNewName},#{docOriginName},#{happenTime},#{secondCategoryId},#{userId},#{createTime})")
    void insertDocument(DocumentInfo documentInfo);

    @Insert("insert into category(category_id,category_name,create_time) values(" +
            "#{categoryId},#{categoryName},#{createTime})")
    void insertCategory(CategoryInfo categoryInfo);

    @Insert("insert into second_category(second_category_id,second_category_name,category_id,create_time) values(" +
            "#{secondCategoryId},#{secondCategoryName},#{categoryId},#{createTime})")
    void insertSecondCategory(SecondCategoryInfo secondCategoryInfo);

    @Delete("delete from category where category_id = #{categoryId}")
    void deleteCategory(@Param("categoryId") String categoryId);

    @Delete("delete from second_category where second_category_id = #{secondCategoryId}")
    void deleteSecondCategory(@Param("secondCategoryId") String secondCategoryId);

    @Delete("delete from second_category where category_id = #{categoryId}")
    void deleteSubCategory(@Param("categoryId") String categoryId);

    @Select("select second_category_id from second_category where category_id = #{categoryId}")
    List<String> getSubCategory(@Param("categoryId") String categoryId);

    @Delete("delete from document where second_category_id = #{secondCategoryId}")
    void deleteDocBySecond(@Param("secondCategoryId") String secondCategoryId);

    @Select("select category_id as categoryId,category_name as categoryName from category where 1=1")
    List<CategoryInfo> getCategory();

    @Select("select second_category_id as secondCategoryId,second_category_name as secondCategoryName from second_category where category_id = #{categoryId}")
    List<SecondCategoryInfo> getSecondCategory(@Param("categoryId") String categoryId);

    @Select("<script> select doc_id as docId,doc_new_name as docNewName,doc_origin_name as docOriginName,happen_time as happenTime from document " +
            "<where> second_category_id = #{secondCategoryId} " +
            "<if test='userId != null'>" +
            "and user_id = #{userId}" +
            "</if>" +
            "</where>" +
            "</script>")
    List<DocumentInfo> getDoc(@Param("secondCategoryId") String secondCategoryId, @Param("userId") String userId);

    @Delete("delete from document where doc_id = #{docId}")
    void delDoc(@Param("docId") String docId);

    @Update("update category set category_name = #{categoryName} where category_id = #{categoryId}")
    void updateCategory(@Param("categoryId") String categoryId, @Param("categoryName") String categoryName);

    @Update("update second_category set second_category_name = #{secondCategoryName} where second_category_id = #{secondCategoryId}")
    void updateSecondCategory(@Param("secondCategoryId") String secondCategoryId, @Param("secondCategoryName") String secondCategoryName);
}
