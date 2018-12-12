package com.csipsimple;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter{
    private ArrayList<Member> MemberList;
    Context context;
    public MemberAdapter(ArrayList<Member>MemberList,Context context){
        this.MemberList = MemberList;
        this.context = context;
    }
    @Override
    public int getCount(){
        return MyActivity2.listnumber;
        //return 2;
    }
    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final Member member = MemberList.get(position);
        View v;
        Memberholder holder;
        if(convertView == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.member, null);//动态加载滑入ListView的item的子布局文件，并绘制item view

            /*  缓存子布局文件中的控件对象*/
            holder = new Memberholder();
            holder.MemberName = (TextView)v.findViewById(R.id.membername);
            holder.MemberNumber = (TextView)v.findViewById(R.id.membernumber);
            v.setTag(holder);
        }
        //滑入ListView中的item view有缓存
        else
        {
            v = convertView;					                        //取出缓存的item View对象
            holder = (Memberholder) v.getTag();	                        //重新获取MemberHolder对象
        }

        holder.MemberName.setText(member.getName());			//设置Name
        holder.MemberNumber.setText(member.getNumber());		//设置Number

        return v;
    }

    class Memberholder{
        TextView MemberName;
        TextView MemberNumber;
    }
}
