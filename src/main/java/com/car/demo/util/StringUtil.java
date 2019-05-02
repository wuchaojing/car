package com.car.demo.util;

public class StringUtil {
    public static boolean hasNullOrEmpty(String str){
        if(str==null||str.length()<=0){//nice compatibility、 nice effiency
            return true;
        }
        return false;
    }
    public static boolean haveNullOrEmpty(String... strs){//no sure args
        for(String str:strs){
            if(str==null||str.length()<=0){//nice compatibility、 nice effiency
                return true;
            }
        }
        return false;
    }
}
