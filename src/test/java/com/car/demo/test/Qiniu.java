package com.car.demo.test;

import com.car.demo.common.CommonUtil;
import com.car.demo.common.QiniuStorage;

import java.io.File;

public class Qiniu {

    public static void main(String[] args) {
        byte[] buff = CommonUtil.getFileBytes(new File("/Users/wuchaojing/Downloads/WechatIMG4.jpeg"));
//		System.out.println(buff);
        String key = QiniuStorage.uploadImage(buff);
        System.out.println("key = " + key);
    }

}
