package com.car.demo.test;

import com.car.demo.qiniu.CommonUtil;
import com.car.demo.qiniu.QiniuStorage;
import org.junit.Test;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Qiniu {

    public static void main(String[] args) {
        byte[] buff = CommonUtil.getFileBytes(new File("/Users/wuchaojing/Downloads/WechatIMG4.jpeg"));
//		System.out.println(buff);
        String key = QiniuStorage.uploadImage(buff);
        System.out.println("key = " + key);
    }

    @Test
    public void test() {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(timeStamp));
    }

}
