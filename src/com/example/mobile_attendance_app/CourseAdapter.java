package com.example.mobile_attendance_app;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CourseAdapter extends BaseAdapter {
	private Context context; 
	ViewHolder holder;
	private ArrayList<courseData> itemList = new ArrayList<courseData>();//对应数据
	// 布局装载器对象
	private LayoutInflater mInflater;

    public CourseAdapter(Context context,ArrayList<courseData> itemList) 
    { 
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
            holder = new ViewHolder(); 
            convertView = mInflater.inflate(R.layout.course_item, null); 
            holder.course_name = (TextView) convertView.findViewById(R.id.course_name); 
            holder.teacher = (TextView) convertView.findViewById(R.id.teacher);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.state = (TextView) convertView.findViewById(R.id.course_state);
            holder.room = (TextView) convertView.findViewById(R.id.room);
            convertView.setTag(holder); 
        }else 
        { 
            holder = (ViewHolder)convertView.getTag(); 
        } 
		holder.course_name.setText(itemList.get(position).course_name);
		holder.teacher.setText(itemList.get(position).teacher);
		holder.time.setText(itemList.get(position).time);
		holder.state.setText(itemList.get(position).state);
		holder.room.setText(itemList.get(position).room);
		
		return convertView;
	}
	
}
