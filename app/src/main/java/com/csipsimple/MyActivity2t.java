package com.csipsimple;

public class MyActivity2t {
    public String combine(String x,String y){
        String res ;
        res = x +'/'+y;
        return res;
    }
    public String writeList(String origin,String content){
        String res ;
        res = origin+content;
        res += '/';
        return res;
    }
}
