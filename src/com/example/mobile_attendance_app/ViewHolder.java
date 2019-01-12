package com.example.mobile_attendance_app;

import android.widget.TextView;

public class ViewHolder {
     public TextView course_name;
     public TextView teacher;
     public TextView room;
     public TextView time;
     public TextView state;
     public ViewHolder() {
		// TODO Auto-generated constructor stub
    	 super();
	}
     public ViewHolder(TextView course_name,TextView teacher,TextView room,TextView time,TextView state) {
		// TODO Auto-generated constructor stub
    	 this.course_name=course_name;
    	 this.teacher=teacher;
    	 this.room=room;
    	 this.state=state;
    	 this.time=time;
	}
}
