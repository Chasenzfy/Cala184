package com.csipsimple;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;

import com.csipsimple.wizards.impl.EasyBell;

public class MyActivity2 extends Activity implements View.OnClickListener {

    //protected static String[] namelist = new String[100];
    //protected static String[] numberlist = new String[100];
    protected static int listnumber = 0;
    private TextView editname,editnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        Button getcancel = (Button)findViewById(R.id.button);
        getcancel.setOnClickListener(this);
        Button getok= (Button)findViewById(R.id.button10);
        getok.setOnClickListener(this);
        Button getlist = (Button)findViewById(R.id.button14);
        getlist.setOnClickListener(this);
        editname = (EditText)findViewById(R.id.editText);
        editnumber = (EditText)findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v){
        int vId = v.getId();
        if(vId == R.id.button) {
            finish();
        }
        else if(vId == R.id.button10){
            saveAccountMess();
        }
        else if(vId == R.id.button14) {
            showMailList();
        }
    }

    public void saveAccountMess(){
        String name,number;
        name = editname.getText().toString();
        number = editnumber.getText().toString();


        String content = name + '/' + number;
        writelist(content,MyActivity2.this);

        editname.setText(null);
        editnumber.setText(null);
        return;
    }
    public void showMailList(){
        Intent intent=new Intent(this,com.csipsimple.MyActivity3.class);
        startActivity(intent);
        return;
    }

    public static void writelist(String content,Context context) {
        content +='/';
        String filename = "2.txt";
        String storagestate;
        try {
            storagestate = Environment.getExternalStorageState();
            if(storagestate.equals(Environment.MEDIA_MOUNTED)){

                filename = context.getExternalCacheDir().getAbsolutePath() + File.separator + filename;
                //FileOutputStream outputStream = new FileOutputStream(filename);
                FileOutputStream outputStream = new FileOutputStream(filename,true);
                outputStream.write(content.getBytes());
                outputStream.close();
            }
        }
        catch (Exception e){
            return;
        }
    }
}
