package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.DocumentService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("doc")
public class DocumentController {

    @Resource
    private DocumentService documentService;

    @PostMapping("upload")
    @ResponseBody
    public ResultInfo uploadDoc(@RequestParam("file") MultipartFile file, String secondCategoryId, String name,String entryTime,HttpSession session) {

        if (file == null) {
            return new ResultInfo(0, "请选择文件");
        }

        if (StringUtils.isEmpty(secondCategoryId)) {
            return new ResultInfo(0, "请选择文件所属目录");
        }

//        if (StringUtils.isEmpty(name)) {
//            return new ResultInfo(0, "请输入名称");
//        }
//
//        if (StringUtils.isEmpty(entryTime)) {
//            return new ResultInfo(0, "请输入录入时间");
//        }


        User curUser = (User) session.getAttribute(ConstantUtil.CLIENT_ID);

        return documentService.upload(file, secondCategoryId, curUser.getUserId());
    }

    @PostMapping("admin_add_category")
    @ResponseBody
    public ResultInfo addCategory(@RequestBody Map<String, String> params) {
        String categoryName = params.get("categoryName");
        if (StringUtils.isEmpty(categoryName)) {
            return new ResultInfo(0, "请输入一级目录名字");
        }
        return documentService.addCategory(categoryName);
    }

    @GetMapping("admin_delete_category")
    @ResponseBody
    public ResultInfo deleteCategory(String categoryId) {
        if (StringUtils.isEmpty(categoryId)) {
            return new ResultInfo(0, "请输入一级目录名字");
        }
        return documentService.deleteCategory(categoryId);
    }

    @PostMapping("admin_add_secondCategory")
    @ResponseBody
    public ResultInfo addSecondCategory(@RequestBody Map<String, String> params) {
        String secondCategoryName = params.get("secondCategoryName");
        String categoryId = params.get("categoryId");
        if (StringUtils.isEmpty(secondCategoryName)) {
            return new ResultInfo(0, "请输入二级目录名字");
        }

        if (StringUtils.isEmpty(categoryId)) {
            return new ResultInfo(0, "请选择一级目录名称");
        }

        return documentService.addSecondCategory(secondCategoryName, categoryId);
    }

    @GetMapping("admin_delete_secondCategory")
    @ResponseBody
    public ResultInfo deleteSecondCategory(String secondCategoryId) {
        if (StringUtils.isEmpty(secondCategoryId)) {
            return new ResultInfo(0, "请输入二级目录名字");
        }
        return documentService.deleteSecondCategory(secondCategoryId);
    }

    @GetMapping("get_category")
    @ResponseBody
    public ResultInfo getCategory() {
        return documentService.getCategory();
    }

    @GetMapping("get_secondCategory")
    @ResponseBody
    public ResultInfo getSecondCategory(String categoryId) {
        if (StringUtils.isEmpty(categoryId)) {
            return new ResultInfo(0, "请选择一级目录");
        }
        return documentService.getSecondCategory(categoryId);
    }

    @GetMapping("get_doc")
    @ResponseBody
    public ResultInfo getDoc(String secondCategoryId, HttpSession session) {
        if (StringUtils.isEmpty(secondCategoryId)) {
            return new ResultInfo(0, "请选择二级目录");
        }
        User curUser = (User) session.getAttribute(ConstantUtil.CLIENT_ID);

        String userId = null;

        if (!curUser.getNumber().equals("admin")) {
            userId = curUser.getUserId();
        }

        return documentService.getDoc(secondCategoryId, userId);
    }

    @GetMapping("delete_doc")
    @ResponseBody
    public ResultInfo deleteDoc(String docId) {
        if (StringUtils.isEmpty(docId)) {
            return new ResultInfo(0, "请选择要删除的文件");
        }
        return documentService.delDoc(docId);
    }
}
