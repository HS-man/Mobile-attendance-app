package com.example.mobile_attendance_app;

import android.widget.TextView;

public class teacher_viewHolder {
	public TextView course_name;
	public TextView course_room;
	public TextView course_time;
	public TextView course_id;
	public teacher_viewHolder() {
		// TODO Auto-generated constructor stub
		super();
	}
	public teacher_viewHolder(TextView course_name,TextView course_room,TextView course_time,TextView course_id) {
		// TODO Auto-generated constructor stub
		this.course_name=course_name;
		this.course_room=course_room;
		this.course_time=course_time;
		this.course_id=course_id;
	}
}
