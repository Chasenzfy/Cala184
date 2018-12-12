package com.csipsimple;

import java.util.ArrayList;

public class MyActivity3t {
    public static ArrayList<Member> memberArrayList = new ArrayList<Member>();
    public int listnumber;

    public void initArray(String mylist){
        this.listnumber = 0;
        int i = 0;
        String [] str = mylist.split("/");
        String name="",number="";
        Member []members = new Member[10];
        while(i < str.length){
            if(i%2 == 0) {
                name = str[i];
            }
            else if(i%2 == 1) {
                number = str[i];
            }
            if(i%2 == 1&&i>=1){
                int x = i%2-1;
                members[x] = new Member(name,number);
                memberArrayList.add(members[x]);
                this.listnumber++;
            }
            i++;
        }
    }

}
