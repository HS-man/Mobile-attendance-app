package com.example.mobile_attendance_app;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class teacher_couserAdapter extends BaseAdapter{
	private Context context;
	teacher_viewHolder holder;
	private ArrayList<teacher_courseData> itemList = new ArrayList<teacher_courseData>();//对应数据
	private LayoutInflater mInflater;
	
	public teacher_couserAdapter(Context context,ArrayList<teacher_courseData> itemList) {
		// TODO Auto-generated constructor stub
		this.context = context; 
        this.itemList=itemList;
        mInflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return itemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null) 
        { 
            holder = new teacher_viewHolder(); 
            convertView = mInflater.inflate(R.layout.teacher_course_item, null); 
            holder.course_name = (TextView) convertView.findViewById(R.id.teacher_course_name); 
            holder.course_room = (TextView) convertView.findViewById(R.id.teacher_course_room); 
            holder.course_time = (TextView) convertView.findViewById(R.id.teacher_course_time); 
            holder.course_id = (TextView) convertView.findViewById(R.id.teacher_course_id); 
            convertView.setTag(holder); 
        }else 
        { 
            holder = (teacher_viewHolder)convertView.getTag(); 
        } 
		holder.course_name.setText(itemList.get(position).course_name);
		holder.course_room.setText(itemList.get(position).course_room);
		holder.course_time.setText(itemList.get(position).course_time);
		holder.course_id.setText(itemList.get(position).course_id);
		return convertView;
	 }
	}


