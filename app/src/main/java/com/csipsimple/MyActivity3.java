package com.csipsimple;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import android.widget.Toast;

import java.util.ArrayList;

public class MyActivity3 extends Activity {
    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    protected static ArrayList<Member> memberArrayList = new ArrayList<Member>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my3);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyActivity3.this,android.R.layout.simple_list_item_1,data);
        //ListView mylist = (ListView) findViewById(R.id.mymaillist);
        //mylist.setAdapter(adapter);

        //memberArrayList = new ArrayList<Member>();
        initArray(this);
        ListView mylist = (ListView) findViewById(R.id.mymaillist);
        mylist.setAdapter(new MemberAdapter(memberArrayList,MyActivity3.this));
    }

   // private void initArray(){
   //     Member member1 = new Member("1","1111");
   //     Member member2 = new Member("2","2222");
   //     memberArrayList.add(member1);
   //     memberArrayList.add(member2);
   // }

    public void initArray(Context context) {
        StringBuilder stringmid = new StringBuilder("");
        memberArrayList.clear();
        MyActivity2.listnumber = 0;
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

                String myfile = context.getExternalCacheDir().getAbsolutePath() + File.separator + "2.txt";
                //Toast.makeText(context, myfile, Toast.LENGTH_LONG).show();

                FileInputStream inputStream = new FileInputStream(myfile);

                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);

                while (len > 0) {
                    stringmid.append(new String(buffer, 0, len));
                    len = inputStream.read(buffer);
                }
                inputStream.close();
            }
            String mylist = stringmid.toString();
            //Toast.makeText(context, mylist, Toast.LENGTH_LONG).show();
            int i = 0;
            String [] str = mylist.split("/");
            String name="",number="";
            //Member member = new Member("","");
            Member []members = new Member[10];
            while(i < str.length){
                if(i%2 == 0) {
                    name = str[i];
                    //Toast.makeText(context, member.getName(), Toast.LENGTH_LONG).show();
                }
                else if(i%2 == 1) {
                    number = str[i];
                    //Toast.makeText(context, member.getNumber(), Toast.LENGTH_LONG).show();
                }
                if(i%2 == 1&&i>=1){
                    int x = i%2-1;
                    members[x] = new Member(name,number);
                    //Toast.makeText(context, member.getName(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(context, member.getNumber(), Toast.LENGTH_LONG).show();
                    memberArrayList.add(members[x]);
                    MyActivity2.listnumber++;
                }
                i++;
            }
        } catch (Exception e) {
            return;
        }
    }
}