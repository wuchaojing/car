package com.car.demo.service.impl;

import com.car.demo.entity.CategoryInfo;
import com.car.demo.entity.DocumentInfo;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SecondCategoryInfo;
import com.car.demo.mapper.DocumentMapper;
import com.car.demo.qiniu.QiniuStorage;
import com.car.demo.service.DocumentService;
import com.car.demo.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Resource
    private DocumentMapper documentMapper;

    @Override
    public ResultInfo upload(MultipartFile file, String secondCategoryId, String userId) {
        DocumentInfo documentInfo = new DocumentInfo();
        // 上传文件到七牛云
        try {
            byte[] data = file.getBytes();
            String originName = file.getOriginalFilename();
            String fileType = originName.substring(originName.lastIndexOf("."));
            String picName = QiniuStorage.uploadFile(data, fileType);

            documentInfo.setDocId(MD5Util.str2MD5(UUID.randomUUID().toString()));
            documentInfo.setDocOriginName(originName);
            documentInfo.setDocNewName(picName);
            documentInfo.setSecondCategoryId(secondCategoryId);
            documentInfo.setUserId(userId);
            documentInfo.setCreateTime(new Date());

            documentMapper.insertDocument(documentInfo);

        } catch (IOException e) {
            log.error("fail to upload doc to qiniuyun", e);
        }
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo addCategory(String categoryName) {
        String categoryId = MD5Util.str2MD5(UUID.randomUUID().toString());
        Date createTime = new Date();

        CategoryInfo categoryInfo = new CategoryInfo(categoryId, categoryName, createTime);

        documentMapper.insertCategory(categoryInfo);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo addSecondCategory(String secondCategoryName, String categoryId) {
        String secondCategoryId = MD5Util.str2MD5(UUID.randomUUID().toString());
        Date createTime = new Date();

        SecondCategoryInfo secondCategoryInfo = new SecondCategoryInfo(secondCategoryId, secondCategoryName, categoryId, createTime);

        documentMapper.insertSecondCategory(secondCategoryInfo);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteCategory(String categoryId) {
        List<String> secondCategoryIds = documentMapper.getSubCategory(categoryId);
        for (String secondCategoryId : secondCategoryIds) {
            documentMapper.deleteDocBySecond(secondCategoryId);
        }

        documentMapper.deleteSubCategory(categoryId);

        documentMapper.deleteCategory(categoryId);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteSecondCategory(String secondCategoryId) {
        documentMapper.deleteDocBySecond(secondCategoryId);

        documentMapper.deleteSecondCategory(secondCategoryId);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo getCategory() {
        List<CategoryInfo> categoryInfos = documentMapper.getCategory();
        return new ResultInfo(1, categoryInfos);
    }

    @Override
    public ResultInfo getSecondCategory(String categoryId) {
        List<SecondCategoryInfo> secondCategoryInfos = documentMapper.getSecondCategory(categoryId);
        return new ResultInfo(1, secondCategoryInfos);
    }

    @Override
    public ResultInfo getDoc(String secondCategoryId, String userId) {
        List<DocumentInfo> docs = documentMapper.getDoc(secondCategoryId, userId);
        return new ResultInfo(1, docs);
    }

    @Override
    public ResultInfo delDoc(String docId) {
        documentMapper.delDoc(docId);
        return new ResultInfo(1);
    }
}
