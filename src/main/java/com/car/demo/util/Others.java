package com.car.demo.util;

public class Others {
    public static boolean isCompletion(String value){
        if(value==null){
            return false;
        }else if("完成".equals(value)){
            return true;
        }else if("未完成".equals(value)){
            return false;
        }else{
            String []fenshu=value.split("/");
            if(fenshu.length!=2){
                return false;
            }
            if(!fenshu[0].equals(fenshu[1])){
                return false;
            }else{
                return true;
            }
        }
    }
}
