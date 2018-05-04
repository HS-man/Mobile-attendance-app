package com.example.mobile_attendance_app;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CourseFragment extends Fragment{
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	TextView tx1;
	TextView tx2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_course, null);
		button1=(Button) view.findViewById(R.id.button1);
		button2=(Button) view.findViewById(R.id.button2);
		button3=(Button) view.findViewById(R.id.button3);
		button4=(Button) view.findViewById(R.id.button4);
		tx1=(TextView) view.findViewById(R.id.textView5);
		tx2=(TextView) view.findViewById(R.id.textView10);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter =new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss");       
				Date curDate =   new Date(System.currentTimeMillis());//获取当前时间       
				String str=formatter.format(curDate);   
				tx1.setText(str);
			}
		});
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getActivity(),AbsentActivity.class);
				startActivity(intent);
			}
		});
         button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat formatter =new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss");       
				Date curDate =   new Date(System.currentTimeMillis());//获取当前时间       
				String str=formatter.format(curDate); 
				tx2.setText(str);
			}
		});
         button4.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				Intent intent=new Intent(getActivity(),AbsentActivity.class);
				startActivity(intent);
 			}
 		});
		return view;
	}
	
}
