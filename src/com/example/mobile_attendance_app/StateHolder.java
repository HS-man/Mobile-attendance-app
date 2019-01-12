package com.example.mobile_attendance_app;

import android.widget.TextView;

public class StateHolder {
	public TextView course_student;
	public TextView student_state;
    
	public StateHolder() {
		// TODO Auto-generated constructor stub
		super();
	}
	public StateHolder(TextView course_student,TextView student_state) {
		// TODO Auto-generated constructor stub
		this.course_student=course_student;
		this.student_state=student_state;
	}
}
