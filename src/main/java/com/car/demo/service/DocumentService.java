package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    ResultInfo upload(MultipartFile file, String secondCategoryId, String userId);

    ResultInfo addCategory(String categoryName);

    ResultInfo addSecondCategory(String secondCategoryName, String categoryId);

    ResultInfo deleteCategory(String categoryId);

    ResultInfo deleteSecondCategory(String secondCategoryId);

    ResultInfo getCategory();

    ResultInfo getSecondCategory(String categoryId);

    ResultInfo getDoc(String secondCategoryId, String userId);

    ResultInfo delDoc(String docId);
}
