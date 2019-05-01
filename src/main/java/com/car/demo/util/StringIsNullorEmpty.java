package com.car.demo.util;

public class StringIsNullorEmpty {
    public static boolean check(String... strs){//no sure args
        for(String str:strs){
            if(str==null||str.length()<=0){//nice compatibility、 nice effiency
                return true;
            }
        }
        return false;
    }
}
