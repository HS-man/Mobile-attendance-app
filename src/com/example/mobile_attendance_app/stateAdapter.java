package com.example.mobile_attendance_app;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class stateAdapter extends BaseAdapter {
	private Context context; 
	StateHolder holder;
	private ArrayList<stateData> itemList = new ArrayList<stateData>();//对应数据
	// 布局装载器对象
	private LayoutInflater mInflater;
	
	public stateAdapter(Context context,ArrayList<stateData> itemList) {
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
            holder = new StateHolder(); 
            convertView = mInflater.inflate(R.layout.state_item, null); 
            holder.course_student = (TextView) convertView.findViewById(R.id.course_student); 
            holder.student_state = (TextView) convertView.findViewById(R.id.student_state);
            convertView.setTag(holder); 
        }else 
        { 
            holder = (StateHolder)convertView.getTag(); 
        } 
		holder.course_student.setText(itemList.get(position).course_student);
		holder.student_state.setText(itemList.get(position).student_state);
		
		
	
	return convertView;
	}

}
